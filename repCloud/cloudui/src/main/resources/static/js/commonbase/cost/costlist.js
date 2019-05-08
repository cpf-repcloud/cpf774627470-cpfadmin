/**
 * 成本中心
 * Created by vetech on 2018/8/6.
 *@author nwt
 */

window.onload = function () {
        /**成本中心列表请求参数**/
        var iquery = {
            qybh: "",//企业编号
            gsbh: "",//公司编号
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
                                        debugger
                                        /**成功*/
                                        app.addData = data.result;
                                        app.addData.sfdlys == "1" ? app.addData.sfdlysone = true : app.addData.sfdlysone = false;
                                        /**未选的新增**/
                                        if (app.iquery.id == null || app.iquery.id == '') {
                                            app.addData.sjmx = "";
                                        } else {
                                            /**选的时候新增**/
                                            app.addData.sjmx = app.iquery.cbzxmc;
                                        }
                                        var xmList=app.addData.xmList;
                                        var bmList=app.addData.bmList;
                                        var glxm=[];
                                        var glbm=[];
                                        if(xmList){
                                            $.each(xmList, function (i, val) {
                                                glxm[i]=val.xmid;
                                            });
                                        }
                                       if(bmList){
                                            $.each(bmList, function (i, val) {
                                                glbm[i]=val.bmid;
                                            });
                                        }
                                        app.projectList
                                        app.addData.glxm=glxm;
                                        app.addData.glbm=glbm;

                                        if(!app.addData.sjbh) {
                                            app.addData.sjbh="none";
                                        }
                                        app.addData.sjmc=data.sjmc;

                                        app.addModel = true;
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
            qybh: "",
            gsbh: "",
            cbzxmc: "",
        }
        debugger

        /**实例化vue**/
        var app = new Vue({
            el: "#app",
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
                    qybh: "",//企业编号
                    gsbh: "",//公司编号
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
                projectList:[],
                deptList:[],
                addload:true
            },
            mounted: function () {
                debugger
                if (this.iquery.id != null && this.iquery.id != '') {
                    this.queryPage();
                }
                this.bindWindow();
                this.calcTableHeight();
                this.loadTree();
                this.initFun();
            },
            methods: {
                initFun:function(){
                    $.ajax({
                        url: "/custom/kj/project/getProjectList",
                        type: "post",
                        dataType: "json",
                        contentType: "application/json",
                        success: function (res) {
                            if (res && res.status == "200") {
                               app.projectList=res.result;
                            }
                        }
                    })
                    $.ajax({
                        url: "/custom/kj/dept/getDeptList",
                        type: "post",
                        dataType: "json",
                        data:JSON.stringify({}),
                        contentType: "application/json",
                        success: function (res) {
                            debugger
                            if (res && res.status == "200") {
                               app.deptList=res.result;
                            }
                        }
                    })
                },
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
                        qybh: "",//企业编号
                        gsbh: "",//公司编号
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
                    app.addModel = true;
                },
                selectProject:function(val,data){

                    console.log(val);
                    var proarr=[];
                    if(data){
                        $.each(data,function(index,pro) {
                            proarr.push(pro.id);
                        })
                    }
                    app.addData.xmidList=proarr;

                },
                selectDept:function(val,data){

                    console.log(val);
                    var deptarr=[];
                    if(data){
                        $.each(data,function(index,dept) {
                            deptarr.push(dept.id);
                        })
                    }
                    app.addData.bmidList=deptarr;

                },
                /**确定新增成本中心**/
                addCbzx: function () {
                    var _this = this;
                    var costurl;
                    if (app.addData.id != '' && app.addData.id != null) {
                        costurl = "/custom/costcenter/updateCostCenter"
                    } else {
                        costurl = "/custom/costcenter/insertCostCenter"
                        /**未选的新增**/
                        if (app.iquery.id == null || app.iquery.id == '') {
                            app.addData.sjbh = "none";
                        } else {
                            /**选的时候新增**/
                            app.addData.sjbh = app.iquery.id;
                        }
                    }

                    app.addData.zt = "1";
                    app.addData.sfdlysone ? app.addData.sfdlys = "1" : app.addData.sfdlys = "0";
                    debugger
                    app.$refs["add"].validate(function (valide) {
                        if (valide) {
                            $.ajax({
                                type: 'POST',
                                url: costurl,
                                dataType: 'json',
                                contentType: "application/json",
                                data: JSON.stringify(app.addData),
                                success: function (data) {
                                    /**成功*/
                                    _this.addModel = false;
                                    if (app.addData.id != '' && app.addData.id != null) {
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

                        }else{
                            setTimeout(function () {
                                app.addload = false;
                                app.$nextTick(function () {
                                    app.addload = true;
                                });
                            }, 100)
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
                            $.extend(true,app.addData,data.result);
                            app.addData.sfdlys == "1" ? app.addData.sfdlysone = true : app.addData.sfdlysone = false;
                            var bmidList, xmidList;
                            bmidList = app.addData.bmList;
                            xmidList = app.addData.xmList;
                            var ttbmidList=[];
                            var ttxmidList=[];
                            ttbmidList.splice(0,ttbmidList.length);
                            ttxmidList.splice(0,ttxmidList.length);
                            $(bmidList).each(function (k, v) {
                                ttbmidList.push(v.bmid);
                            });
                            $(xmidList).each(function (sl, svalue) {
                                ttxmidList.push(svalue.xmid);
                            });
                            app.addModel = true;

                            /**未选的新增**/
                            if (app.iquery.id == null || app.iquery.id == '') {
                                app.addData.sjmx = "";
                            } else {
                                /**选的时候新增**/
                                app.addData.sjmx = app.iquery.cbzxmc;
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
                                app.treeData = data.result.children;
                            }
                        }, error: function () {
                        }
                    });
                },

                /**树搜索加载*/
                searchCb: function () {
                    if (app.treeData instanceof Array) {
                        app.treeData.splice(0, app.treeData.length);
                    }
                    $.ajax({
                        type: 'POST',
                        url: '/custom/costcenter/queryCostCenterTree',
                        dataType: 'json',
                        contentType: "application/json",
                        data: JSON.stringify(app.dataT),
                        success: function (data) {
                            /***组装树结构数据*/
                            if (data.result) {
                                app.treeData = data.result.children;
                            }

                        }, error: function () {

                        }
                    });
                },

                /**点击树页面 显示*/
                selectTreeItem: function (data) {
                    debugger
                    if (data) {
                        var obj = {
                            id: data[0].id,
                            cbzxbh: data[0].cbzxbh,
                            sjbh: data[0].sjbh,
                            cbzxmc:data[0].cbzxmc,
                        }
                        app.iquery=obj;
                        app.search();
                    }
                },



            }
        });
        window.app=app;
    };

