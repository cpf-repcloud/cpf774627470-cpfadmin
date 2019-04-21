/**
 * 成本中心
 * Created by vetech on 2018/8/6.
 *@author nwt
 */

window.onload = function () {
        /**成本中心列表请求参数**/
        var iquery = {
            qybh: "VETECH",//企业编号
            gsbh: "VETECH001",//公司编号
            id: "",
            mcbh: "",
            cbzxbh: "",//成本中心编号
            cbzxmc: "",
            sjbh: "",
            cbzxmcxx:"",
        };

        /***列数据**/
        var tableColumns = [
            {
                title: "成本中心名称",
                key: 'cbzxmc',
                minWidth: 120
            },
            {
                title: "成本中心编号",
                key: 'cbzxbh',
                minWidth: 120
            },
            {
                title: "关联部门",
                key: 'glbmmc',
                minWidth: 100
            },
            {
                title: "关联项目",
                key: 'glxmmc',
                minWidth: 100
            },
            {
                title: "最后修改时间",
                key: 'zhxgsjMC',
                minWidth:150
            },
            {
                title: "操作",
                key: "action",
                minWidth: 100,
                render: function (h, params) {
                    return h('div', [h('span', {
                        props: {
                            type: "primary",
                            size: "small"
                        },
                        style: {
                            marginRight: "5px",
                            color: "#3399ff",
                            fontSize: "12px",
                            cursor: "pointer"
                        },
                        on: {
                            click: function (e) {
                                /**获取成本中心详*/
                                var cr = {
                                    id: params.row.id
                                }
                                $.ajax({
                                    type: 'POST',
                                    url: '/custom/costcenter/selectCostCenterDetail',
                                    dataType: 'json',
                                    contentType: "application/json",
                                    data: JSON.stringify(cr),
                                    success: function (data) {
                                        /**成功*/
                                        app.$data.addData = data.result;
                                        app.$data.addData.sfdlys == "1" ? app.$data.addData.sfdlysone = true : app.$data.addData.sfdlysone = false;
                                        var bmList, xmList;
                                        bmList = app.$data.addData.bmList;
                                        xmList = app.$data.addData.xmList;
                                        var ttbmid=[];
                                        var ttxmid=[];
                                        ttbmid.splice(0,ttbmid.length);
                                        ttxmid.splice(0,ttxmid.length);
                                        $(bmList).each(function (k, v) {
                                            ttbmid.push(v.bmid);
                                        });
                                        app.$set(app.$data.kjxx,"bmdxkj",ttbmid);
                                        $(xmList).each(function (k, v) {
                                            ttxmid.push(v.xmid);
                                        });
                                        app.$set(app.$data.kjxx,"xmdxkj",ttxmid)

                                        /**未选的新增**/
                                        if (app.$data.iquery.id == null || app.$data.iquery.id == '') {
                                            app.$data.addData.sjmx = "";
                                        } else {
                                            /**选的时候新增**/
                                            app.$data.addData.sjmx = app.$data.iquery.cbzxmc;
                                        }

                                        app.$data.addModel = true;
                                    },
                                    error: function (xhr, type) {
                                        /**失败*/
                                    }
                                });

                            }
                        }
                    }, "编辑")]);
                }
            },
            {
                title: "状态",
                key: "zt",
                minWidth: 100,
                align: 'left',
                filters: [
                    {
                        label: "有效",
                        value: "1"
                    },
                    {
                        label: "无效",
                        value: "0"
                    }
                ],
                filterMethod: function (value, row) {
                    return row.zt.indexOf(value) > -1;
                },
                render: function (h, params) {
                    return h("i-switch", {
                        props: {
                            value: params.row.zt == "1",
                            size: 'large',
                        },
                        style: {
                            marginRight: '5px'
                        },
                        on: {
                            'on-change': function (value) {
                                var zt = value ? "1" : "0";
                                /**更新状态*/
                                var cr = {
                                    id: params.row.id,
                                    zt: zt
                                }
                                $.ajax({
                                    type: 'POST',
                                    url: '/custom/costcenter/updateCostCenterZt',
                                    dataType: 'json',
                                    contentType: "application/json",
                                    data: JSON.stringify(cr),
                                    success: function (data) {
                                        /**更新成功*/
                                        app.$Message.success("更新成功");
                                        app.queryPage();
                                    },
                                    error: function (xhr, type) {
                                        /**更新失败*/
                                        app.$Message.error("更新失败");
                                        app.queryPage();
                                    }
                                });
                            }
                        }
                    }, [h('span', {
                        slot: "open"
                    }, "有效"), h('span', {
                        slot: "close"
                    }, "无效")]);
                }
            }
        ];
        var tableData = [];

        /***获取树传参**/
        function getparams() {
            var params = window.location.search;
            if (params.length == 1) {
                return {};
            }
            params = params.substr(1);
            var pos = params.split("&");
            var tmp = null;
            var rg = {};
            for (var a = 0, len = pos.length; a < len; a++) {
                tmp = pos[a].split("=");
                rg[tmp[0]] = decodeURIComponent(tmp[1]);
            }
            return rg;
        }

        var qobj = getparams();
        $.extend(iquery, qobj);


        /**编码校验**/
        var dataCheck = function (rule, value, callback) {
            if (value) {
                if (/[\u4E00-\u9FA5]/g.test(value)) {
                    return callback(new Error(""));
                } else {
                    return callback();
                }
            }
        }

        /**自定义档案编号重复校验*/
        var cbzxCheck = function (rule, value, callback) {
            if (value) {
                var bhxx = {
                    cbzxbh: value,
                }
                $.ajax({
                    type: 'POST',
                    url: '/custom/costcenter/verificationCbzxbh',
                    dataType: 'json',
                    contentType: "application/json",
                    async: false,
                    data: JSON.stringify(bhxx),
                    success: function (data) {
                        /**成功*/
                        if (data.result) {
                            callback(new Error("部门重复"));
                        } else {
                            callback();
                        }

                    },
                    error: function (xhr, type) {
                        /**失败*/
                        callback();
                    }
                });
            }

        }

        /**树结构数据*/
        var treeData = [];

        /**树结构查询用到的请求参数*/
        var dataT = {
            qybh: "VETECH",
            gsbh: "VETECH001",
            cbzxmc: "",
        }

        /**实例化vue**/
        var app = new Vue({
            el: "#appCbzx",
            data: {
                /**搜索条件数据绑定**/
                iquery: iquery,
                addModel: false,
                showMore: true,//展开或收起
                cbzxTitle: {
                    cj: "新建成本中心",
                    bj: "编辑成本中心"
                },
                /**新增或编辑数据绑定**/
                addData: {
                    id: "",
                    qybh: "VETECH",//企业编号
                    gsbh: "VETECH001",//公司编号
                    sjbh: "",
                    cbzxmc: "",
                    cbzxbh: "",
                    sfdlysone: false,
                    sfdlys: this.sfdlysone ? "1" : "0",
                    glbm: "",
                    glxm: "",
                    bmidList: [],
                    xmidList: [],
                },
                igrid: {
                    url: "/custom/costcenter/selectCostCenterPageList",
                    loading: false,
                    datas: tableData,
                    columns: tableColumns
                },
                /**面包屑数据绑定**/
                breadData: {
                    id: "",
                    cbzxmc: "",
                    cbzxbh: "",
                    glbmmc: "",
                    glxmmc: "",
                    ztone: false,
                    zt: ""
                },
                /**表单检验*/
                ruleValidate: {
                    cbzxmc: [{required: true, message: "成本中心名称", trigger: 'blur'}],
                    cbzxbh: [
                        {required: true, message: "成本中心编号", trigger: 'blur'},
                        {validator: dataCheck, trigger: 'blur'},
                        {validator: cbzxCheck, trigger: 'blur'},
                    ]
                },

                /**树结构数据**/
                treeData: treeData,
                dataT: dataT,

                /**项目多选控件*/
                xmsdata: {url: "/custom/control/project/getTreeProject"},
                simpleData2: {
                    id: "id",
                    name: "title",
                    children: "children"
                },


                /**部门多选控件***/
                bmsdata: {url: "/custom/control/dept/searchDeptTreeByGs"},
                simpleData3: {
                    id: "id",
                    name: "title",
                    children: "children"
                },
                /**控件信息接收**/
                kjxx:{
                    bmdxkj: [],//接收控件信息
                    xmdxkj: [],//接收控件信息

                }


            },
            mounted: function () {
                if (this.iquery.id != null && this.iquery.id != '') {
                    this.queryPage();
                }
                this.bindWindow();
                this.calcTableHeight();
                this.loadTree();
            },
            methods: {
                bindWindow: function () {
                    var _this = this, hex;
                    $(window).on('resize', function () {
                        if (_this.timer) {
                            clearTimeout(_this.timer);
                        }
                        _this.timer = setTimeout(function () {
                            hex = $(window).height() - 260;
                            _this.igrid.hex = hex;
                        }, 200);
                    });
                },
                calcTableHeight: function () {
                    var hex = $(window).height() - 260;
                    this.igrid.hex = hex;
                },
                search: function () {
                    var cbzxmx=iquery.cbzxmcxx;
                    iquery.cbzxmc=cbzxmx;
                    this.queryPage();
                },
                gridSuccsess: function (data) {
                    if (data.result) {
                        this.igrid.datas = data.result.pageList.records;//每页展示的数据
                        this.ipage.total = data.result.pageList.total;//总条数
                        this.breadData = data.result;//面包屑数据
                        this.breadData.zt == '1' ? this.breadData.ztone = true : this.breadData.ztone = false;
                    }
                },
                /**新增成本中心之前弹出新增页面**/
                addCbzxBefore: function () {
                    this.addData = {
                        id: "",
                        qybh: "VETECH",//企业编号
                        gsbh: "VETECH001",//公司编号
                        sjbh: "",
                        cbzxmc: "",
                        cbzxbh: "",
                        sfdlysone: false,
                        sfdlys: this.sfdlysone ? "1" : "0",
                        glbm: "",
                        glxm: "",
                        bmidList: [],
                        xmidList: [],
                    }
                    app.$data.addModel = true;
                },
                /**确定新增成本中心**/
                addCbzx: function () {
                    var _this = this;
                    var costurl;
                    if (app.$data.addData.id != '' && app.$data.addData.id != null) {
                        costurl = "/custom/costcenter/updateCostCenter"
                    } else {
                        costurl = "/custom/costcenter/insertCostCenter"
                        /**未选的新增**/
                        if (app.$data.iquery.id == null || app.$data.iquery.id == '') {
                            app.$data.addData.sjbh = "none";
                        } else {
                            /**选的时候新增**/
                            app.$data.addData.sjbh = app.$data.iquery.id;
                        }
                    }
                    app.$data.addData.bmidList = [];
                    app.$data.addData.xmidList = [];

                    if (app.$data.addData.bmidList instanceof Array) {
                        app.$data.addData.bmidList.splice(0, app.$data.addData.bmidList.length);
                    }
                    if (app.$data.addData.xmidList instanceof Array) {
                        app.$data.addData.xmidList.splice(0, app.$data.addData.xmidList.length);
                    }
                    if(app.$data.kjxx.bmdxkj instanceof Array){
                        $(app.$data.kjxx.bmdxkj).each(function(bmk,bmv){
                            app.$data.addData.bmidList.push(bmv)
                        });
                    }else{
                        app.$data.addData.bmidList.push(app.$data.kjxx.bmdxkj);
                    }

                    if (app.$data.kjxx.xmdxkj instanceof Array) {
                        $(app.$data.kjxx.xmdxkj).each(function (kj, kjvalue) {
                            app.$data.addData.xmidList.push(kjvalue);
                        });
                    } else {
                        app.$data.addData.xmidList.push(app.$data.kjxx.xmdxkj);
                    }
                    app.$data.addData.sfdlysone ? app.$data.addData.sfdlys = "1" : app.$data.addData.sfdlys = "0";
                    this.$refs["add"].validate(function (valide) {
                        if (valide) {
                            var dataCheck = true;
                            app.addData.bmidList=['1']; //todo
                            if (app.$data.addData.bmidList.length == 0) {
                                app.$Message.warning("请选择关联部门!");
                                dataCheck = false;
                            }
                            app.addData.xmidList=['2'];//todo
                            if (app.$data.addData.xmidList.length == 0) {
                                app.$Message.warning("请选择关联项目!");
                                dataCheck = false;
                            }
                            if (dataCheck) {
                                $.ajax({
                                    type: 'POST',
                                    url: costurl,
                                    dataType: 'json',
                                    contentType: "application/json",
                                    data: JSON.stringify(app.$data.addData),
                                    success: function (data) {
                                        /**成功*/
                                        _this.addModel = false;
                                        if (app.$data.addData.id != '' && app.$data.addData.id != null) {
                                            _this.$Message.info("编辑成功");
                                        } else {
                                            _this.$Message.info("新增成功");
                                        }
                                        app.queryPage();//左侧页刷新
                                        app.searchCb();
                                    },
                                    error: function (xhr, type) {
                                        /**失败*/
                                    }
                                });
                            }
                        }
                    });
                },
                cancel: function () {
                    this.addModel = false;
                    this.$refs["add"].resetFields();//重置表单
                },
                /**面包屑出的编辑*/
                editCostCenter: function () {
                    /**获取成本中心详*/
                    var cr = {
                        id: this.breadData.id,
                        zt: this.breadData.zt ? "1" : "0"
                    }
                    $.ajax({
                        type: 'POST',
                        url: '/custom/costcenter/selectCostCenterDetail',
                        dataType: 'json',
                        contentType: "application/json",
                        data: JSON.stringify(cr),
                        success: function (data) {
                            /**成功*/
                            $.extend(true,app.$data.addData,data.result);
                            app.$data.addData.sfdlys == "1" ? app.$data.addData.sfdlysone = true : app.$data.addData.sfdlysone = false;
                            var bmidList, xmidList;
                            bmidList = app.$data.addData.bmList;
                            xmidList = app.$data.addData.xmList;
                            var ttbmidList=[];
                            var ttxmidList=[];
                            ttbmidList.splice(0,ttbmidList.length);
                            ttxmidList.splice(0,ttxmidList.length);
                            $(bmidList).each(function (k, v) {
                                ttbmidList.push(v.bmid);
                            });
                            app.$set(app.$data.kjxx,"bmdxkj",ttbmidList)
                            $(xmidList).each(function (sl, svalue) {
                                ttxmidList.push(svalue.xmid);
                            });
                            app.$set(app.$data.kjxx,"xmdxkj",ttxmidList);
                            app.$data.addModel = true;

                            /**未选的新增**/
                            if (app.$data.iquery.id == null || app.$data.iquery.id == '') {
                                app.$data.addData.sjmx = "";
                            } else {
                                /**选的时候新增**/
                                app.$data.addData.sjmx = app.$data.iquery.cbzxmc;
                            }

                        },
                        error: function (xhr, type) {
                            /**失败*/
                        }
                    });
                },
                /**更新状态*/
                updateCostCenterZt: function () {
                    /**更新状态*/
                    var cr = {
                        id: this.breadData.id,
                        zt: this.breadData.ztone ? "1" : "0"
                    }
                    $.ajax({
                        type: 'POST',
                        url: '/custom/costcenter/updateCostCenterZt',
                        dataType: 'json',
                        contentType: "application/json",
                        data: JSON.stringify(cr),
                        success: function (data) {
                            /**更新成功*/
                            app.$Message.success("更新成功");
                            app.queryPage();
                        },
                        error: function (xhr, type) {
                            /**更新失败*/
                            app.$Message.error("更新成功");
                            app.queryPage();
                        }
                    });
                },

                /**加载树结构信息**/
                loadTree: function () {
                    var obj = this.dataT;
                    $.ajax({
                        type: 'POST',
                        url: '/custom/costcenter/queryCostCenterTree',
                        dataType: 'json',
                        contentType: "application/json",
                        data: JSON.stringify(obj),
                        success: function (data) {
                            if(data&&data.result){
                                app.$data.treeData = data.result.children;
                            }
                        }, error: function () {
                        }
                    });
                },

                /**树搜索加载*/
                searchCb: function () {
                    if (app.$data.treeData instanceof Array) {
                        app.$data.treeData.splice(0, app.$data.treeData.length);
                    }
                    $.ajax({
                        type: 'POST',
                        url: '/custom/costcenter/queryCostCenterTree',
                        dataType: 'json',
                        contentType: "application/json",
                        data: JSON.stringify(app.$data.dataT),
                        success: function (data) {
                            /***组装树结构数据*/
                            if (data.result) {
                                app.$data.treeData = data.result.children;
                            }

                        }, error: function () {

                        }
                    });
                },

                /**点击树页面 显示*/
                selectTreeItem: function (data) {
                    if (data) {
                        var obj = {
                            id: data[0].id,
                            cbzxbh: data[0].cbzxbh,
                            sjbh: data[0].sjbh,
                            cbzxmc:data[0].cbzxmc,
                        }
                        $.extend(iquery, obj);
                        app.search();
                    }
                },

                /**项目多选控件**/
                xmdxCheckFn: function (value) {//项目树
                },
                /**部门多选控件**/
                bmdxCheckFn: function (value) {//项目树
                }

            }
        });
    };

