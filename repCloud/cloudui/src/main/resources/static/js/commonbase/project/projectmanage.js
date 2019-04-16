
window.onload=function (){
    
            var dataTree = [];
            //项目list 数据存放
            var proList;
            var addData = {
                xmmc: "",
                xmbh: "",
                xmgs: "",
                xmlx: "",
                zt: "",
                ksrqData: "",
                bzbz: "",
                xmjl: "",
                xmzj: "",
                xmlxr: "",
                glbm: "",
                xmys: "",
                sfdlyszt: "",
                sfyx: "1",
                cyjs: [],
                sjcbzx: "",
                sfkqcbzx: false
            };

            var editData = {
                xmmc: "", xmbh: "", xmgs: "", xmlx: "", zt: "", ksrqData: "", bzbz: ""
                , xmjl: "", xmzj: "", xmlxr: "", glbm: "", xmys: "", sfdlyszt: "", xmbhcy: []
            };
            var updateStata = {}

            var proDetail = {};

            var tableColumns = [
                {
                    title: "项目名称",
                    key: 'xmmc',
                    minWidth:180,
                    filterType: "input",
                    filterRemote: function (column, value) {
                        app.igrid.datas = [];
                        app.iquery.xmmc = value;
                        app.queryPage();
                    },
                    render: function (h, params) {
                        var xmmc = params.row.xmmc;
                        console.log(xmmc);
                        return h('div', [h('span', {
                            props: {},
                            style: {
                                color: "#2d8cf0",
                                fontSize: "12px",
                                cursor: "pointer"
                            },
                            on: {
                                click: function () {
                                    var data = {id: params.row.id};
                                    app.xmid = params.row.id;
                                    $.ajax({
                                        url: "/custom/vexm/getProDetail",
                                        type: "post",
                                        dataType: "json",
                                        contentType: "application/json",
                                        data: JSON.stringify(data),
                                        success: function (res) {
                                            console.log(res);
                                            if (res && res.status == "200") {
                                                proDetail = res.result;
                                                app.proDetail = proDetail;
                                                proList = app.igrid.datas;
                                                getCyList();
                                            }
                                            app.$refs.fter.showPanel();
                                        }
                                    })


                                }
                            }
                        }, xmmc)]);
                    }
                },
                {
                    title: "项目编号",
                    key: 'xmbh',
                    minWidth:105,

                },
                {
                    title: "项目状态",
                    key: 'zt',
                    minWidth:100,
                    filters: [
                        {
                            label: "未开始",
                            value: "0"
                        },
                        {
                            label: "进行中",
                            value: "1"
                        },
                        {
                            label: "已完成",
                            value: "2"
                        },
                    ],
                    filterMethod: function (value, row) {
                        return row.zt.indexOf(value) > -1;
                    },
                    render: function (h, params) {
                        console.log(params);
                        var xmzt = params.row.zt;
                        var value = "";
                        var color = "";
                        if (xmzt == "0") { //审批中
                            color = "#ff9900";
                            value = "未开始";
                        } else if (xmzt == "1") { //被驳回
                            color = "#2b85e4";
                            value = "进行中";
                        } else if (xmzt == "2") {//审批通过
                            color = "#19be6b";
                            value = "已完成";
                        }
                        return h("div", [h("icon", {
                            props: {
                                type: "record",
                                color: color,
                                size: "1"
                            },

                        }), h("span", {
                            props: {},
                            style: {
                                marginLeft: "5px",
                            }
                        }, value)]);
                    }
                },
                {
                    title: "开始日期",
                    key: 'ksrqStr',
                    minWidth:145,
                    sortable: true,
                    filterType: "date",
                    filterRemote: function (column, value) {

                        app.igrid.datas = [];
                        app.iquery.ksrqStrq = value[0];
                        app.iquery.ksrqStrz = value[1];
                        console.log(app.iquery);
                        app.queryPage();
                    }
                },
                {
                    title: "项目预算",
                    key: 'xmys',
                    minWidth:90,

                },
                {
                    title: "操作",
                    key: "action",
                    minWidth:110,
                    renderHeader: function (h, params) {
                        return h('div', [h('span', "操作")]);
                    },
                    render: function (h, params) {
                        return h('div', [h('span', {
                            props: {},
                            style: {
                                marginRight: "5px",
                                color: "#3399ff",
                                fontSize: "12px",
                                cursor: "pointer"
                            },
                            on: {
                                click: function (e) {
                                    var dataid = {id: params.row.id};
                                    console.log(params.row);
                                    getEditKjData(dataid);
                                }
                            }
                        }, "编辑"), h('dropdown', {
                            props: {
                                trigger: "hover"
                            },
                            style: {
                                marginRight: "5px",
                                color: "#3399ff",
                                fontSize: "12px",
                                cursor: "pointer"
                            },
                            on: {
                                'on-click': function (e) {

                                }
                            }
                        }, [h('DropdownMenu', {
                            slot: "list"
                        }, [ h('DropdownItem', {
                            props: {
                                name: "dc"
                            }

                        }, "项目状态"), h('DropdownItem', {
                            props: {
                                name: "dy"
                            }
                        }, "关联部门"), h('DropdownItem', {
                            props: {
                                name: "dytx"
                            }
                        }, "关联成本中心")
                        ]),  h('a',"更多"),
                            h('icon',{
                                domProps:{
                                    text:'更多\t'
                                },
                                props:{
                                    type:'ios-arrow-down'
                                }
                            }),])

                        ]);
                    }
                }, {
                    title: "状态",
                    key: 'sfyx',
                    minWidth:90,
                    render: function (h, params) {
                        return h("i-switch", {
                            props: {
                                value: params.row.sfyx == "1" ? true : false,
                                size: "large"
                            },
                            on: {
                                'on-change': function (flag) {
                                    var data = {id: params.row.id, sfyx: flag}
                                    updataStataFun(data);
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

            var proMembertableColumns = [
                {
                    title: "序号",
                    type: 'index',
                    width: 60,
                    align: 'center'
                },
                {
                    title: "项目",
                    key: 'xm',
                    width: 120,
                    render: function (h, params) {
                        return h('span', [h('span', params.row.xm + "(" + params.row.gh + ")")]);
                    }
                },

                {
                    title: "状态",
                    key: 'zt',
                    width: 140,
                    filters: [
                        {
                            label: "在项目中",
                            value: "1"
                        },
                        {
                            label: "离开项目",
                            value: "0"
                        },
                    ],
                    filterMethod: function (value, row) {
                        return row.zt.indexOf(value) > -1;
                    },
                    render: function (h, params) {
                        return h("i-select", {
                            props: {
                                value: params.row.zt,
                            },
                            on: {
                                'on-change': function (value) {
                                    console.log(value);
                                    var data = {id: params.row.id, zt: value};
                                    $.ajax({
                                        url: "/custom/vexm/updateCyzt",
                                        type: "post",
                                        contentType: "application/json",
                                        dataType: "json",
                                        data: JSON.stringify(data),
                                        success: function (res) {
                                            if (res.status == 200) {
                                                if (res.result > 0) {
                                                    app.$Message.success("更新成功");
                                                    proList = app.igrid.datas;
                                                    getCyList();
                                                } else {
                                                    app.$Message.error("更新失败");
                                                }
                                            } else {
                                                app.$Message.error("更新失败");
                                            }
                                        }
                                    })
                                }
                            }
                        }, [h('i-option', {
                            props: {
                                value: "1",
                            },

                        }, "在项目中"), h('i-option', {
                            props: {
                                value: "0",
                            },
                        }, "离开项目")]);
                    }
                },
                {
                    title: "成员角色",
                    key: 'cyjs',
                    width: 130,
                    render: function (h, params) {
                        var value = "";
                        var cyjs = params.row.cyjs;
                        if (cyjs == "1") {
                            value = "项目经理";
                        } else if (cyjs == "2") {
                            value = "项目总监";
                        } else if (cyjs == "3") {
                            value = "项目联系人";
                        } else if (cyjs == "4") {
                            value = "普通成员";
                        }
                        return h("div", [h('span', {}, value)])
                    }
                },
                {
                    title: "操作",
                    key: "action",
                    width: 80,
                    renderHeader: function (h, params) {
                        return h('div', [h('span', "操作")]);
                    },
                    render: function (h, params) {
                        var cyjs = params.row.cyjs;
                        return h('div', [h('span', {
                            props: {},
                            style: {
                                marginRight: "5px",
                                color: cyjs == 1 ? "#c5c8ce" : "#3399ff",
                                fontSize: "12px",
                                cursor: "pointer"
                            },
                            on: {
                                click: function (e) {
                                    if (cyjs != "1") {
                                        var vedata = params.row;
                                        var data = {id: vedata.id, xmid: vedata.xmid, cyjs: vedata.cyjs};
                                        $.ajax({
                                            url: "/custom/vexm/deleteProCy",
                                            type: "post",
                                            contentType: "application/json",
                                            dataType: "json",
                                            data: JSON.stringify(data),
                                            success: function (res) {
                                                if (res.status == 200) {
                                                    if (res.result > 0) {
                                                        app.$Message.success("删除成功");
                                                        proList = app.igrid.datas;
                                                        getCyList();
                                                    } else {
                                                        app.$Message.error("删除失败");
                                                    }
                                                } else {
                                                    app.$Message.error("删除失败");
                                                }
                                            }
                                        })
                                    }

                                }
                            }
                        }, "删除")]);
                    }
                }

            ];


            /**项目列表数据*/
            var tableData = [];
            /**项目成员数据*/
            var tableDatas = [];

            var validatexmbh = function (rule, value, callback) {
                if (!value) {
                    return callback(new Error("请输入项目编号"));
                } else if (!/^[0-9a-zA-Z]+$/.test(value)) {
                    return callback(new Error("只能输入英文数字"))
                } else {
                    callback();
                }
            };

            var validatecbzxbh = function (rule, value, callback) {
                if (app.addData.sfkqcbzx) {
                    if (!value) {
                        return callback(new Error("请输入成本中心编号"));
                    } else if (!/^[0-9a-zA-Z]+$/.test(value)) {
                        return callback(new Error("只能输入英文数字"))
                    } else {
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
                                    callback();
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

            };

            var validatesjbh = function (rule, value, callback) {
                if (value && !/^[0-9a-zA-Z]+$/.test(value)) {
                    return callback(new Error("只能输入英文数字"))
                } else {
                    callback();
                }
            };
            var validatexmys = function (rule, value, callback) {
                if (value && !/^[0-9]+$/.test(value)) {
                    return callback(new Error("只能输入数字"))
                } else {
                    callback();
                }
            };

            var ruleValidate = {
                sjxm: [
                    {reqeired: false, message: "只能输入英文数字", trigger: 'blur'},
                    {validator: validatesjbh, trigger: 'blur'},
                ],

                xmmc: [
                    {required: true, message: "名称不能为空", trigger: 'blur'}
                ],
                xmbh: [
                    {required: true, message: "项目编号不能为空", trigger: 'blur'},
                    {validator: validatexmbh, trigger: 'blur'},
                ],
                xmlx: [
                    {required: true, message: "请选择", trigger: 'change'}
                ],
                xmgs: [
                    {required: true, message: "请选择", trigger: 'change'}
                ],
                xmjl: [
                    {required: true, message: "请选择", trigger: 'change'}
                ],
                glbm: [
                    {required: false, message: "请选择", trigger: 'change'}
                ],
                xmzj: [
                    {required: true, message: "请选择", trigger: 'change'}
                ],
                xmlxr: [
                    {required: true, message: "请选择", trigger: 'change'}
                ],
                zt: [
                    {required: true, message: "请选择", trigger: 'change'}
                ],
                ksrqData: [
                    {required: true, type: 'date', message: "请选择", trigger: 'change'}
                ],
                jsrqData: [
                    {required: false, type: 'date', message: "请选择", trigger: 'change'}
                ],

                xmys: [
                    {validator: validatexmys, trigger: 'blur'}
                ],
                bzbz: [
                    {type: 'string', max: 50, message: "", trigger: 'blur'}
                ],
                cbzxbh: [
                    {required: false, message: "", trigger: 'blur'},
                    {validator: validatecbzxbh, trigger: 'blur'},
                ],

            }
            var ruleValidateedit = {
                sjxm: [
                    {reqeired: false, message: "只能输入英文数字", trigger: 'blur'},
                    {validator: validatesjbh, trigger: 'blur'},
                ],

                xmmc: [
                    {required: true, message: "名称不能为空", trigger: 'blur'}
                ],
                xmbh: [
                    {required: true, message: "项目编号不能为空", trigger: 'blur'},
                    {validator: validatexmbh, trigger: 'blur'},
                ],
                xmlx: [
                    {required: true, message: "请选择", trigger: 'change'}
                ],
                xmgs: [
                    {required: true, message: "请选择", trigger: 'change'}
                ],
                xmjl: [
                    {required: true, message: "请选择", trigger: 'change'}
                ],
                glbm: [
                    {required: false, message: "请选择", trigger: 'change'}
                ],
                xmzj: [
                    {required: true, message: "请选择", trigger: 'change'}
                ],
                xmlxr: [
                    {required: true, message: "请选择", trigger: 'change'}
                ],
                zt: [
                    {required: true, message: "请选择", trigger: 'change'}
                ],
                ksrqData: [
                    {required: true, type: 'date', message: "请选择", trigger: 'change'}
                ],
                jsrqData: [
                    {required: false, type: 'date', message: "请选择", trigger: 'change'}
                ],

                xmys: [
                    {validator: validatexmys, trigger: 'blur'}
                ],
                bzbz: [
                    {type: 'string', max: 50, message: "zdwsgzf", trigger: 'blur'}
                ]
            }
            var kjAddData = {xmjl: [], xmzj: [], xmbhcy: [], xmlxr: [], cbzxData: ""};
            var kjEditData = {xmjl: [], xmzj: [], xmbhcy: [], xmlxr: [], cbzxData: ""};

            var iquery = {};
            var app;
            var proListDetail = {};
            
            $.ajax({
                type:"POST",
                url:"/custom/vexm/getTreeList",
                success: function (res) {
                    
                    if (res && res.result) {
                        dataTree = res.result.children;
                        if(res.result.children){
                            var proData = res.result.children[0];
                            iquery.sjbh = proData.xmbh;
                        }
                    }
                    getApp();
                    app.data = dataTree;
                    app.iquery = iquery;
                    app.proListDetail = proListDetail;
                }
            })

            function getApp() {
                app = new Vue({
                    el: "#app",
                    data: {
                        data: dataTree,
                        iquery: iquery,
                        igrid: {
                            url: "/custom/vexm/proList",
                            loading: false,
                            datas: tableData,
                            columns: tableColumns
                        },
                        igrids: {
                            url: "/custom/vexm/getProMembers",
                            loading: false,
                            datas: tableDatas,
                            columns: proMembertableColumns
                        },
                        addModel: false,
                        addData: addData,
                        proListDetail: proListDetail,
                        proDetail: proDetail,
                        editModel: false,
                        editData: editData,
                        kjAddData: kjAddData,
                        xmmc: "",
                        kjEditData: kjEditData,
                        changeTabData: "1",
                        tabValue: "1",
                        xmid: "",
                        addload: true,
                        editload: true,
                        ruleValidate: ruleValidate,
                        ruleValidateEdit: ruleValidateedit,
                        bmsdata: {
                            url: "/custom/control/costcenter/selectVeCbzxTreeListToControl"
                        },
                        simpleData1: {
                            id: "id",
                            name: "label",
                            children: "children"
                        },
                    },
                    mounted: function () {
                        //this.queryPage();
                    },
                    methods: {
                        search: function () {
                            var _this = this;
                            this.$refs.queryForm.validate(function (flag) {
                                if (flag) {
                                }
                                app.iquery.sjbh = data.xmbh;
                                _this.queryPage();
                            });
                        },
                        gridSuccsess: function (data) {
                            if (data && data.status == '200' && data.result) {
                                var result = data.result;
                                console.log(result);
                                if (result.records.length > 0) {
                                    if (result.records[0].xmbh) {
                                        console.log(result.records[0].cyjs);
                                        tableData = result.records;
                                        this.igrid.datas = result.records;
                                        this.ipage.total = result.total;
                                    } else {
                                        this.igrid.datas = tableData;
                                        this.igrid.columns = tableColumns;
                                        tableDatas = result.records;
                                        this.igrids.datas = result.records;
                                        this.ipage.total = result.total;
                                    }
                                }

                            }
                        },
                        okAdd: function () {
                            app.$refs["formValidateAdd"].validate(function (valid) {
                                if (valid) {
                                    addData.id = "";
                                    if (addData.sfdlyszt) {
                                        addData.sfdlys = "1"
                                    } else {
                                        addData.sfdlys = "0"
                                    }
                                    if (addData.sjbh == null || addData.sjbh == "") {
                                        addData.sjbh = "none";
                                    }
                                    $.ajax({
                                        url: "/custom/vexm/addPro",
                                        type: "post",
                                        dataType: 'json',
                                        contentType: "application/json",
                                        data: JSON.stringify(addData),
                                        success: function (data) {
                                            if (data.status == 200) {
                                                app.$Message.success("新增成功");
                                                addData = {};
                                                app.addData = {};
                                                app.addload = false;
                                                app.addModel = false;
                                            } else {
                                                app.$Message.error("新增失败");
                                            }
                                            getTreeData();
                                        },
                                        error: function (e) {
                                            console.log(e);
                                            app.addload = false;
                                        }
                                    })
                                } else {
                                    app.$Message.error('表单验证失败!');
                                    getFormrest();

                                }
                            })
                        },
                        okEdit: function () {
                            
                            app.$refs["formValidateEdit"].validate(function (valid) {
                                if (valid) {
                                    if (editData.sfdlyszt) {
                                        editData.sfdlys = "1"
                                    } else {
                                        editData.sfdlys = "0"
                                    }
                                    //上级编号为空 默认为none
                                    if (!editData.sjbh) {
                                        editData.sjbh = "none";
                                    }
                                    $.ajax({
                                        url: "/custom/vexm/addPro",
                                        type: "post",
                                        dataType: 'json',
                                        contentType: "application/json",
                                        data: JSON.stringify(editData),
                                        success: function (data) {
                                            if (data.status == 200) {
                                                app.$Message.success("更新成功");
                                                app.editData = {};
                                                app.editload = false;
                                                app.editModel = false;
                                            } else {
                                                app.$Message.error("更新失败");
                                            }
                                            getTreeData();
                                        }
                                    })
                                }
                                else {
                                    app.$Message.error('表单验证失败!');
                                    getFormrest();

                                }
                            })
                        },
                        changeTab: function (data) {
                            console.log(data);
                            if (data == "1") {
                                app.changeTabData = "1";
                                $("#fix").css("right", "0px");
                                var data = {id: proDetail.id};
                                $.ajax({
                                    url: "/custom/vexm/getProDetail",
                                    type: "post",
                                    dataType: "json",
                                    contentType: "application/json",
                                    data: JSON.stringify(data),
                                    success: function (res) {
                                        console.log(res);
                                        if (res && res.status == "200") {
                                            proDetail = res.result;
                                            app.proDetail = proDetail;
                                            proList = app.igrid.datas;
                                        }
                                    }
                                })
                            } else if (data == "2") {
                                proList = app.igrid.datas;
                                getCyList();
                                app.changeTabData = "2";
                                $("#fix").css("right", "0px");

                            }
                        },
                        cancel: function () {

                        },
                        addFun: function () {
                            app.$refs["formValidateAdd"].resetFields();
                            app.kjAddData = {xmjl: [], xmzj: [], xmbhcy: [], xmlxr: []};
                            app.addModel = true;

                            addData.xmbhcy = [];
                            /**默认新增上级编号为 当前项目的项目编号*/
                            if (proListDetail.xmbh) {
                                addData.sjbh = proListDetail.xmbh;
                            } else {
                                addData.sjbh = "";
                            }
                            addData.sfkqcbzx = false;

                            addData.sfdlyszt = false;
                            app.addData = addData;
                        },
                        ksrqFunDemo: function (data1, data2) {
                            addData.ksrqStr = data1;
                        },
                        jssjFunDemo: function (data1, data2) {
                            addData.jsrqStr = data1;
                        },
                        getProData: function (data) {
                            if (data) {
                                var seat = {};
                                var proData = data[0];
                                seat.id = proData.id;
                                tableData = [];
                                proListDetail = {};
                                app.iquery.sjbh = proData.xmbh;
                                getXmList();
                                app.queryPage();
                                $.ajax({
                                    url: "/custom/vexm/getProDetail",
                                    type: "post",
                                    contentType: "application/json",
                                    dataType: "json",
                                    data: JSON.stringify(seat),
                                    success: function (res) {
                                        var detailData = res.result;
                                        proListDetail = JSON.parse(JSON.stringify(detailData));
                                        if (detailData.sfyx == "1") {
                                            proListDetail.sfyx = true;
                                        } else {
                                            proListDetail.sfyx = false;
                                        }
                                        if (detailData.sfdlys == "1") {
                                            proListDetail.sfdlyszt = true;
                                        } else {
                                            proListDetail.sfdlyszt = false;
                                        }
                                        app.proListDetail = proListDetail;
                                        console.log(proListDetail);
                                    }
                                });
                            }
                        },
                        //搜索项目成员
                        searchCyData: function () {
                            proList = app.igrid.datas;
                            getCyList();
                        },
                        //搜索项目方法
                        searchProData: function () {
                            tableData = [];
                            app.igrid.datas = [];
                            app.iquery.sjbh = proListDetail.xmbh;
                            getXmList();
                            app.queryPage();

                        },
                        ///修改项目状态
                        enabledPro: function () {
                            updataStataFun(app.proListDetail);
                        },
                        editProData: function () {
                            var dataid = {id: proListDetail.id};
                            getEditKjData(dataid);
                        },
                        selectXmjl: function (data) {
                            if (data.length == 3) {
                                if (app.addModel) {
                                    addData.xmjl = data[2].value;
                                    var prod = {ssgsid: data[0].id, ssbmid: data[1].id, ygrzid: data[2].value, cyjs: "1"}
                                    addData.xmbhcy.push(prod);
                                }
                                if (app.editModel) {
                                    removeCyFun("1");
                                    editData.xmjl = data[2].value;
                                    var prod = {ssgsid: data[0].id, ssbmid: data[1].id, ygrzid: data[2].value, cyjs: "1"}
                                    editData.xmbhcy.push(prod);
                                }
                            } else {
                                removeCyFun("1");
                            }

                        },
                        selectXmzj: function (data) {
                            if (data.length == 3) {
                                if (app.addModel) {
                                    addData.xmzj = data[2].value;
                                    var prod = {ssgsid: data[0].id, ssbmid: data[1].id, ygrzid: data[2].value, cyjs: "2"};
                                    addData.xmbhcy.push(prod);
                                }
                                if (app.editModel) {
                                    removeCyFun("2");
                                    editData.xmzj = data[2].value;
                                    var prod = {ssgsid: data[0].id, ssbmid: data[1].id, ygrzid: data[2].value, cyjs: "2"};
                                    editData.xmbhcy.push(prod);
                                }
                            } else {
                                removeCyFun("2");
                            }
                        },
                        selectCbzxFun: function (data) {
                            console.log(data);
                            if (app.addModel) {
                                addData.sjcbzx = data[0].value;
                            }
                            if (app.editModel) {
                                editData.sjcbzx = data[0].value;
                            }
                        },
                        selectXmlxr: function (data) {
                            if (data.length == 3) {
                                if (app.addModel) {
                                    addData.xmlxr = data[2].value;
                                    var prod = {ssgsid: data[0].id, ssbmid: data[1].id, ygrzid: data[2].value, cyjs: "3"};
                                    addData.xmbhcy.push(prod);
                                }
                                if (app.editModel) {
                                    removeCyFun("3");
                                    editData.xmlxr = data[2].value;
                                    var prod = {ssgsid: data[0].id, ssbmid: data[1].id, ygrzid: data[2].value, cyjs: "3"};
                                    editData.xmbhcy.push(prod);
                                }
                            } else {
                                removeCyFun("3");
                            }
                        },

                    }

                })
            }

            function updataStataFun(data) {
                updateStata.id = data.id;
                if (data.sfyx) {
                    updateStata.sfyx = "1";
                } else {
                    updateStata.sfyx = "0";
                }
                $.ajax({
                    url: "/custom/vexm/updateState",
                    type: "post",
                    contentType: "application/json",
                    dataType: "json",
                    data: JSON.stringify(updateStata),
                    success: function (data) {
                        //console.log(data)
                        if (data.status == 200) {
                            app.$Message.success("更新成功");
                        } else {
                            app.$Message.error("更新失败");
                        }
                    }
                })
            }

            /**重新渲染树形结构*/

            function getTreeData() {
                $.ajax({
                    url: "/custom/vexm/getTreeList",
                    type: "post",
                    async: false,
                    success: function (data) {
                        
                        if (data && data.result) {
                            var dataTree = data.result.children;
                            app.data = dataTree;
                        } else {
                            app.data = [];
                        }
                        getXmList();
                    }
                });
            }


            function removeCyFun(cyjs) {
                
                if (app.addModel) {
                    $.each(addData.xmbhcy, function (index, val) {
                        if (val.cyjs && val.cyjs == cyjs) {
                            addData.xmbhcy.splice(index, 1);
                        }
                    })
                }
                if (app.editModel) {
                    $.each(editData.xmbhcy, function (index, val) {
                        if (val.cyjs && val.cyjs == cyjs) {
                            editData.xmbhcy.splice(index, 1);
                        }
                    })
                }
            }

            /**调用查询项目list 方法*/
            function getXmList() {
                app.igrid.datas = [];
                app.igrid.url = "/custom/vexm/proList";
                app.igrid.columns = tableColumns;
                app.queryPage();
            }

            /**调用查询 成员list方法*/
            function getCyList() {
                app.iquery.xmid = app.xmid;
                app.igrid.url = app.igrids.url;
                app.igrid.datas = app.igrids.datas;
                app.igrid.columns = app.igrids.columns;
                app.igrids.datas = [];
                app.queryPage();
                app.igrid.datas = proList;
                app.igrid.columns = tableColumns
            }


            // 编辑回显数据处理
            function getEditKjData(dataid) {
                app.$refs["formValidateEdit"].resetFields();
                $.ajax({
                    url: "/custom/vexm/getProDetail",
                    type: "post",
                    contentType: "application/json",
                    dataType: "json",
                    data: JSON.stringify(dataid),
                    success: function (res) {
                        console.log(res);
                        editData = {};
                        editData = res.result;
                        editData.xmbhcy = [];
                        var prodxmjl = {
                            ssgsid: editData.xmjlszgs,
                            ssbmid: editData.xmjlszbm,
                            ygrzid: editData.xmjl,
                            cyjs: "1"
                        }
                        if (editData.xmjl) {
                            editData.xmbhcy.push(prodxmjl);
                        }
                        var prodxmzj = {
                            ssgsid: editData.xmzjszgs,
                            ssbmid: editData.xmzjszbm,
                            ygrzid: editData.xmzj,
                            cyjs: "2"
                        };
                        if (editData.xmzj) {
                            editData.xmbhcy.push(prodxmzj);
                        }
                        var prodxmlxr = {
                            ssgsid: editData.xmlxrszgs,
                            ssbmid: editData.xmlxrszbm,
                            ygrzid: editData.xmlxr,
                            cyjs: "3"
                        };
                        if (editData.xmlxr) {
                            editData.xmbhcy.push(prodxmlxr);
                        }

                        console.log(editData);
                        if (editData.sfdlys == "1") {
                            editData.sfdlyszt = true;
                        } else {
                            editData.sfdlyszt = false;
                        }
                        if (editData.sjbh == "none") {
                            editData.sjbh = "";
                        }
                        editData.ksrqData = editData.ksrqStr
                        editData.jsrqData = editData.jsrqStr;

                        //员工控件回显
                        
                        console.log(app.kjEditData);
                        app.editData = editData;
                        if (!editData.xmjlszgs) {
                            kjEditData.xmjl = [];
                            app.kjEditData.xmjl = [];
                        } else {
                            Vue.set(kjEditData.xmjl, 0, editData.xmjlszgs);
                            Vue.set(kjEditData.xmjl, 1, editData.xmjlszbm);
                            Vue.set(kjEditData.xmjl, 2, editData.xmjl);
                        }
                        if (!editData.xmzjszgs) {
                            kjEditData.xmzj = [];
                            app.kjEditData.xmzj = [];
                        } else {
                            Vue.set(kjEditData.xmzj, 0, editData.xmzjszgs);
                            Vue.set(kjEditData.xmzj, 1, editData.xmzjszbm);
                            Vue.set(kjEditData.xmzj, 2, editData.xmzj);
                        }
                        if (!editData.xmlxrszgs) {
                            kjEditData.xmlxr = [];
                            app.kjEditData.xmlxr = [];
                        } else {
                            Vue.set(kjEditData.xmlxr, 0, editData.xmlxrszgs);
                            Vue.set(kjEditData.xmlxr, 1, editData.xmlxrszbm);
                            Vue.set(kjEditData.xmlxr, 2, editData.xmlxr);
                        }
                        kjEditData.cbzxData = editData.sjcbzx;

                        app.kjEditData = kjEditData;

                        app.editModel = true;

                    }
                })

            }

            /**表单提交*/
            function getFormrest() {
                setTimeout(function () {
                    app.addload = false;
                    app.editload = false;
                    app.$nextTick(function () {
                        app.addload = true;
                        app.editload = true;
                    });
                }, 100)
            }


}




