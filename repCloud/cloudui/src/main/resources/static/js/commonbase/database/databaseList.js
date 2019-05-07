window.onload = function () {

    var dataT = {
        "id": "",
        "lb": "",
        "lbmc": ""
    }


    var datas = [];
    var app;

    $.ajax({
        type: 'POST',
        url: '/custom/basecommon/queryBaseLbList',
        dataType: 'json',
        contentType: "application/json",
        data: JSON.stringify(dataT),
        success: function (data) {
            debugger
            if (data) {
                $.each(data.result, function (i, item) {
                    var titles = {title: "", value: "", expand: false};
                    titles.title = data.result[i].lbmc;
                    titles.value = data.result[i].lb;
                    datas.push(titles);
                });
            }

            initVue();
            ////console.log(JSON.stringify(datas));
        }
    });

    var tableColumns = [
        {
            title: "名称",
            key: 'mc'
        },
        {
            title: "数据编号",
            key: 'bh'
        },
        {
            title: "顺序号",
            key: 'sxh'
        },
        {
            title: "操作人",
            key: 'zhxgrmc'
        },
        {
            title: "操作",
            key: "action",
            width: 140,
            renderHeader: function (h, params) {
                return h('div', [h('span', "操作"), h('a', {
                    domProps: {
                        text: "新建"
                    },
                    style: {
                        marginLeft: "5px"
                    },
                    on: {
                        click: function (e) {
                            var lb = app.xzjcsj.lb;
                            var lbmc = app.xzjcsj.lbmc;
                            app.$refs.sf.resetFields();
                            app.$data.sj.isSave = true;
                            app.$data.xzjcsj = {mc: "", bh: "", sxh: "", lb: lb, lbmc: lbmc};
                            $.extend(app.$data.xzjcsj, app.$data.xzjcsj);
                        }
                    }
                })]);
            },
            render: function (h, params) {
                return h('div', [h('a', {
                    domProps: {
                        text: "编辑"
                    },
                    style: {
                        marginRight: "5px"
                    },
                    on: {
                        click: function (e) {
                            debugger
                            app.$refs["mf"].resetFields();//重置表单
                            setTimeout(function () {
                                var data=app.$data.igrid.datas[params.index];
                                app.mfd=data;
                                //$.extend(app.$data.mfd, );
                                app.$data.md.isEdit = true;
                            }, 1)

                        }
                    }
                }, "编辑"), h('a', {
                    domProps: {
                        text: "删除"
                    },
                    style: {
                        marginRight: "5px"
                    },
                    on: {
                        click: function (e) {
                            app.$data.de.isDel = true;
                            var data=app.$data.igrid.datas[params.index];
                            app.mfd=data;
                            //$.extend(app.$data.mfd, );
                            app.$data.md.isEdit = true;
                        }
                    }
                }, "删除")]);
            }
        }
    ];

    var tableData = [];


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
    var databaseCheck = function (rule, value, callback) {
        if (value) {
            var bhxx = {
                lb: value,
            }
            $.ajax({
                type: 'POST',
                url: '/custom/basecommon/checkBaseData',
                dataType: 'json',
                contentType: "application/json",
                async: false,
                data: JSON.stringify(bhxx),
                success: function (data) {
                    /**成功*/
                    if (data.result == "true") {
                        callback(new Error("类别重复"));
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


    function initVue() {
        app = new Vue({
            el: "#app",
            data: {
                iquery: {
                    lb: ""
                },

                dataT: {lbmc: ""},
                formRule: {
                    mc: [{required: true, message: "请输入数据名称"}],
                    bh: [{required: true, message: "请输入数据编号"}],
                    sxh: [{required: true, message: "请输入顺序号"}]
                },
                editformRule: {
                    mc: [{required: true, message: "请输入数据名称"}],
                    bh: [{required: true, message: "请输入数据编号"}],
                    sxh: [{required: true, message: "请输入顺序号"}]
                },
                md: {
                    isEdit: false,
                    addSjlb: false,
                    editSjbl: false,
                    active: -1
                },
                de: {
                    isDel: false,
                    active: -1
                },
                sj: {
                    isSave: false,
                    active: -1
                },
                jcsj: false,
                mfd: {},
                xzjcsj: {},
                igrid: {
                    url: "/custom/basecommon/queryBaseCommonList",
                    loading: false,
                    data: tableData,
                    columns: tableColumns
                },
                spinShow: false,
                data1: datas,
                /**表单检验*/
                ruleValidate: {
                    lbmc: [{required: true, message: "类别名称不能为空", trigger: 'blur'}],
                    lb: [
                        {required: true, message: "类别编号不能为空", trigger: 'blur'},
                        {validator: dataCheck, trigger: 'blur'},
                        {validator: databaseCheck, trigger: 'blur'},
                    ]
                },

            },
            mounted: function () {
                //this.queryPage();
            },
            methods: {
                selectAll: function (data) {
                    if (data) {
                        app.xzjcsj.lb = data[0].value;
                        app.xzjcsj.lbmc = data[0].title;
                        this.iquery.lb = data[0].value;
                    }
                    this.iquery.lbmc = "";
                    this.queryPage();
                    app.jcsj = true;
                    return;
                },
                search: function () {
                    this.$refs.queryForm.validate(function (flag) {
                        ////console.log(arguments);
                    });
                    getJcsj(app.dataT.lbmc);
                    //this.iquery.lb = "";
                    //this.queryPage();
                },
                gridSuccsess: function (data) {
                    debugger
                    var result = data.result;
                    this.ipage.total = result.total;
                    this.igrid.datas = result.records;
                    tableData = result.records;
                },
                saves: function (ref) {
                    debugger
                    this.$refs[ref].validate(function (flag) {
                        if (flag) {
                            debugger
                            if (!app.mfd.lb) {
                                app.mfd.lb = app.xzjcsj.lb || '';
                                app.mfd.lbmc = app.xzjcsj.lbmc || '';
                            }
                            app.spinShow = true;
                            $.ajax({
                                type: "POST",
                                url: "/custom/basecommon/updateDataBase",
                                data: JSON.stringify(app.mfd),
                                dataType: "json",
                                async: true,
                                contentType: "application/json;charset=UTF-8",
                                success: function (response) {
                                    app.spinShow = false;
                                    if (response) {
                                        app.$Message.success("更新成功");
                                        app.iquery.lb = app.xzjcsj.lb;
                                        app.md.isEdit = false;
                                        app.md.addSjlb = false;
                                        app.queryPage();
                                        getJcsj(app.dataT.lbmc);
                                    } else {
                                        app.$Message.error("更新失败");
                                    }
                                },
                                error: function () {
                                    app.spinShow = false;
                                }
                            });
                        }
                    });
                },
                mydel: function () {
                    //console.log(JSON.stringify(app.mfd));
                    app.spinShow = true;
                    $.ajax({
                        type: "POST",
                        url: "/custom/basecommon/deleteDataBase",
                        data: JSON.stringify(app.mfd),
                        dataType: "json",
                        async: true,
                        contentType: "application/json;charset=UTF-8",
                        success: function (response) {
                            app.spinShow = false;
                            if (response) {
                                app.$Message.success("删除成功");
                                app.iquery.lb = app.xzjcsj.lb;
                                app.queryPage();
                            } else {
                                app.$Message.error("删除失败");
                            }
                        },
                        error: function () {
                            app.spinShow = false;
                        }
                    });
                },
                submit: function () {
                    this.$refs.sf.validate(function (flag) {
                        if (flag) {
                            if (app.xzjcsj.lbmc == "" || app.xzjcsj.lbmc == undefined) {
                                this.$Message.error("请选择类别");
                                return;
                            }
                            app.spinShow = true;
                            $.ajax({
                                type: "POST",
                                url: "/custom/basecommon/addDataBase",
                                data: JSON.stringify(app.xzjcsj),
                                dataType: "json",
                                async: true,
                                contentType: "application/json;charset=UTF-8",
                                success: function (response) {
                                    app.spinShow = false;
                                    if (response) {
                                        app.$Message.success("新增成功");
                                        app.iquery.lb = app.xzjcsj.lb;
                                        app.$data.sj.isSave = false;
                                        app.queryPage();
                                    } else {
                                        app.$Message.error("新增失败");
                                    }
                                },
                                error: function () {
                                    app.spinShow = false;
                                }
                            });
                        }
                    });
                },
                cancel: function (ref) {
                    app.$data.sj.isSave = false;
                    app.$data.md.isEdit = false;
                    app.md.addSjlb = false;
                    // this.$refs[ref].resetFields();//重置表单
                },
                keyDownEvent: function () {

                },
                addBaseLb: function () {
                    app.md.addSjlb = true;
                },
                editLb: function () {
                    app.md.editSjbl = false;
                    app.mfd.lb = xzjcsj.lb;
                    app.mfd.lbmc = xzjcsj.lbmc;
                }

            },
            watch: {
                "xzjcsj.bh": function (value) {
                    var check = app.xzjcsj;
                    var data = {bh: check.bh, lb: check.lb};
                    basicList(data);
                },
                "xzjcsj.mc": function (value) {
                    var check = app.xzjcsj;
                    var data = {mc: check.mc, lb: check.lb};
                    basicList(data);
                },
                "xzjcsj.sxh": function (value) {
                    var check = app.xzjcsj;
                    var data = {sxh: check.sxh, lb: check.lb};
                    basicList(data);
                },
                "mfd.sxh": function () {
                    var check = app.mfd;
                    var data = {sxh: check.sxh, id: check.id, lb: check.lb};
                    basicList(data);
                },
                "mfd.bh": function () {
                    var check = app.mfd;
                    var data = {bh: check.bh, id: check.id, lb: check.lb};
                    basicList(data);
                },
                "mdf.mc": function () {
                    var check = app.mfd;
                    var data = {mc: check.mc, id: check.id, lb: check.lb};
                    basicList(data);
                },
                "md.addSjlb": function (newvlaue, oldtrue) {
                    console.log(newvlaue, oldtrue)
                    if (newvlaue === false) {
                        app.$refs["savelb"].resetFields();//重置表单
                    }
                },
                "sj.isSave": function (newvalue, oldvalue) {
                    if (newvalue === false) {
                        app.$refs["sf"].resetFields();//重置表单
                    }
                },
                "md.editSjbl": function (newvalue, oldvalue) {
                    if (newvalue === false) {
                        app.$refs["editlb"].resetFields();//重置表单
                    }
                }
            }
        });
    }

    function getJcsj(lbmc) {
        if (lbmc != undefined) {
            dataT.lbmc = lbmc;
        }
        $.ajax({
            type: 'POST',
            url: '/custom/basecommon/queryBaseLbList',
            dataType: 'json',
            contentType: "application/json",
            data: JSON.stringify(dataT),
            success: function (data) {
                //app.xzjcsj.lbmc = lbmc;
                if (datas.length != undefined && datas.length > 0) {
                    datas.splice(0, datas.length);
                }
                if (data) {
                    $.each(data.result, function (i, item) {
                        var titles = {title: "", value: "", expand: false};
                        titles.title = data.result[i].lbmc;
                        titles.value = data.result[i].lbbh;
                        datas.push(titles);
                    });
                }

            }
        });
    }

    function basicList(data) {
        ////console.log(app.xzjcsj);
        $.ajax({
            type: 'POST',
            url: '/custom/basecommon/checkBaseData',
            dataType: 'json',
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function (data) {
                if (data.id) { //mfd
                    ////console.log(data.result);

                    app.editformRule.bh[0].message = "请输入数据编号";
                    app.editformRule.mc[0].message = "请输入数据名称";
                    app.editformRule.sxh[0].message = "请输入顺序号";
                    $.each(data.result, function (i, item) {
                        if (app.mfd.bh == item.bh) {
                            app.mfd.bh = "";
                            app.formRule.bh[0].message = "编号已存在";
                        } else if (app.mfd.mc == item.mc) {
                            app.mfd.mc = "";
                            app.formRule.mc[0].message = "名称已存在";
                        }
                    });


                } else { //editformRule
                    app.formRule.bh[0].message = "请输入数据编号";
                    app.formRule.mc[0].message = "请输入数据名称";
                    app.formRule.sxh[0].message = "请输入顺序号";
                    $.each(data.result, function (i, item) {
                        if (app.xzjcsj.bh == item.bh) {
                            app.xzjcsj.bh = "";
                            app.formRule.bh[0].message = "编号已存在";
                        } else if (app.xzjcsj.mc == item.mc) {
                            app.xzjcsj.mc = "";
                            app.formRule.mc[0].message = "名称已存在";
                        }
                    });
                }
            }
        });
    }
};




