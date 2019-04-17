window.onload = function () {
    var columns6 = [
        {
            title: "岗位编号",
            key: 'gwbh',
            slot: 'gwbh',
            minWidth: 100,
            type: 'input',//编辑的状态
        },
        {
            title: "岗位名称",
            key: 'gwmc',
            slot: 'gwmc',
            minWidth: 200,
            type: 'input',//编辑的状态
        },
        {
            title: "岗位级别",
            key: 'gwjb',
            slot: 'gwjb',
            minWidth: 100,
            "sortable": true,
            type: 'select',//编辑的状态
            selectData: [
                {
                    label: '1' + "级",
                    value: '1' + "级",
                },
                {
                    label: '2' + "级",
                    value: '2' + "级",
                },
                {
                    label: '3' + "级",
                    value: '3' + "级",
                },
                {
                    label: '4' + "级",
                    value: '4' + "级",
                },
                {
                    label: '5' + "级",
                    value: '5' + "级",
                },
                {
                    label: '6' + "级",
                    value: '6' + "级",
                },
                {
                    label: '7' + "级",
                    value: '7' + "级",
                }, {
                    label: '8' + "级",
                    value: '8' + "级",
                },
                {
                    label: '9' + "级",
                    value: '9' + "级",
                }
            ],
            filters: [
                {
                    label: '1' + "级",
                    value: '1' + "级",
                },
                {
                    label: '2' + "级",
                    value: '2' + "级",
                },
                {
                    label: '3' + "级",
                    value: '3' + "级",
                },
                {
                    label: '4' + "级",
                    value: '4' + "级",
                },
                {
                    label: '5' + "级",
                    value: '5' + "级",
                },
                {
                    label: '6' + "级",
                    value: '6' + "级",
                },
                {
                    label: '7' + "级",
                    value: '7' + "级",
                }, {
                    label: '8' + "级",
                    value: '8' + "级",
                },
                {
                    label: '9' + "级",
                    value: '9' + "级",
                }
            ],
            filterMethod: function (value, row) {
                return row.gwjb.indexOf(value) > -1;
            }
            , /*render: function (h, params) {
                var gwjb=params.row.gwjb+"级";
                return h("span", {},gwjb );
            },*/

        },
        {
            title: "岗位描述",
            key: 'gwms',
            slot: 'gwms',
            minWidth: 250,
            type: 'input',//编辑的状态(要加编辑的状态，一定要加这个)
            inputType: 'textarea'//编辑的input状态
        },
        {
            title: "操作",
            key: 'cz',
            slot: 'cz',
            minWidth: 100,

        },
        {
            title: "状态",
            key: 'zt',
            slot: 'zt',
            minWidth: 130,
            filters: [
                {
                    label: "有效",
                    value: 1
                },
                {
                    label: "无效",
                    value: 0
                }
            ],
            filterMultiple: false,
            filterMethod: function (value, row) {
                //console.log(value);
                //console.log(row);
                return row.zt == value;
            },
            render: function (h, params) {
                return h("i-switch", {
                    props: {
                        value: params.row.zt == "1" ? true : false,
                        size: "large"
                    },
                    on: {
                        'on-change': function (flag) {
                            //console.log(params.row);
                            rankEdit = {};
                            if (flag) {
                                rankEdit.zt = "1";
                            } else {
                                rankEdit.zt = "0";
                            }
                            rankEdit.id = params.row.id;
                            editRank();
                            searchDataFun(searchData);
                            //console.log(rankEdit);
                        }
                    }
                }, [h('span', {
                    slot: "open"
                }, "有效"), h('span', {
                    slot: "close"
                }, "无效")]);
            },

        }

    ];
    var data5 = [
        {
            id: '123465',
            gwbh: 'John Brown',
            gwmc: 18,
            gwjb: '1级',
            gwms: '测试',
            zt: false
        },
        {
            id: '123466',
            gwbh: 'Jim Green',
            gwmc: 24,
            gwjb: '2级',
            gwms: '2016-10-01',
            zt: false
        },
        {
            id: '123467',
            gwbh: 'Joe Black',
            gwmc: '123',
            gwjb: '3级',
            gwms: '2016-10-02',
            zt: false
        },
        {
            id: '123468',
            gwbh: 'Jon Snow',
            gwmc: 26,
            gwjb: '4级',
            gwms: '2016-10-04',
            zt: true
        }
    ];
    /*编辑使用岗位数据*/
    var rankEdit = {
        gwbh: "",
        gwmc: "",
        gwjb: "",
        gwms: "",
        zt: ""
    };
    /*新增使用 岗位1数据*/
    var rankAdd = {
        gwbh: "",
        gwmc: "",
        gwjb: "",
        gwms: "",
        zt: "1"
    }
    /*搜索使用数据*/
    var searchData = {gwbh: "", gwmc: ""};


    var validategwbh = function (rule, value, callback) {
        if (!value) {
            return callback(new Error("请输入岗位编号"));
        } else if (!/^[0-9a-zA-Z]+$/.test(value)) {
            return callback(new Error("只能输入英文和数字"))
        } else {
            var cehckedData = {gwbh: value};
            $.ajax({
                url: "/custom/postrank/list",
                type: "post",
                dataType: "json",
                async: false,
                contentType: "application/json",
                data: JSON.stringify(cehckedData),
                success: function (data) {

                    if (data.result && data.result.length > 0) {
                        callback(new Error(""));
                    } else {
                        callback();
                    }
                }
            });

        }
    };
    var rankValidate = {
        gwbh: [
            {required: true, message: "只能输入英文和数字", trigger: 'blur'},
            {validator: validategwbh, trigger: 'blur'},
        ],
        gwmc: [
            {required: true, message: "名称不能为空", trigger: 'blur'}
        ],
        gwjb: [
            {required: true, message: "请输入", trigger: 'change'}
        ],
        gwms: [
            {type: 'string', max: 50, message: "", trigger: 'blur'}
        ]
    }

    searchDataFun(searchData);
    var app = new Vue({
        el: "#app",
        data: {
            data5: data5,
            columns6: columns6,
            rankEdit: rankEdit,
            editModel: false,
            addModel: false,
            rankAdd: rankAdd,
            searchData: searchData,
            ruleRankAdd: rankValidate,
            ruleRankEdit: rankValidate,
            addload: true,
            editload: true,

            editIndex: -1,  // 当前聚焦的输入框的行数
            editGwbh: '',  // 第一列输入框，当然聚焦的输入框的输入内容，与 data 分离避免重构的闪烁
            editGwmc: '',  // 第二列输入框
            editGwjb: '',  // 第三列输入框
            editGwms: '',  // 第四列输入框
        },
        mounted: function () {

        },
        methods: {
            okEdit: function () {
                app.$refs["rankEdit"].validate(function (valid) {
                    if (valid) {
                        editRank();
                        app.data5 = data5;
                    } else {
                        app.$Message.error("");
                        getFormLoad();
                    }

                })

            },
            cancel: function () {
            },
            addRole: function () {
                app.$refs["rankAdd"].resetFields();
                $(".ivu-form-item-content").css({
                    "margin-left": "100px",
                });
                $(".ivu-form-item-label").css({
                    "width": "100px",
                })
                app.addModel = true;
            },
            selectRank: function () {
                searchDataFun(searchData);
                setTimeout(function () {
                    app.data5 = data5;
                }, 100)
            },
            okAdd: function () {
                rankAdd.gwjb = rankAdd.gwjb.substring(0, 1);
                app.$refs["rankAdd"].validate(function (valid) {
                    if (valid) {
                        $.ajax({
                            url: "/custom/postrank/addRank",
                            type: "post",
                            dataType: "json",
                            contentType: "application/json",
                            data: JSON.stringify(rankAdd),
                            success: function (data) {
                                if (data.result > 0) {
                                    app.$Message.success("新增成功");
                                    app.addModel = false;
                                    app.addload = false;
                                    var adddata = {gwbh: "", gwmc: ""};
                                    searchDataFun(adddata);
                                } else {
                                    app.$Message.error("新增失败");
                                }
                            }
                        })
                    } else {
                        app.$Message.error("");
                        getFormLoad();
                    }

                })
            },
            handleSave: function (index) {
                this.data5[index].gwbh = this.editGwbh;
                this.data5[index].gwmc = this.editGwmc;
                this.data5[index].gwjb = this.editGwjb;
                this.data5[index].gwms = this.editGwms;
                app.editIndex = -1;
                var rowVal = this.data5[index];
                var dataVal = app.data5[index];
                for (var index in rowVal) {
                    dataVal[index] = rowVal[index];
                }
                if (rowVal.zt) {
                    rowVal.zt = "1";
                } else {
                    rowVal.zt = "0";
                }
                rowVal.gwjb = rowVal.gwjb.substring(0, 1);
                rankEdit = rowVal;
                editRank();
            },
            handleEdit: function (row, index) {
                this.editGwbh = row.gwbh;
                this.editGwmc = row.gwmc;
                this.editGwjb = row.gwjb;
                this.editGwms = row.gwms;
                this.editIndex = index;
            },
            handleDelete:function(row,index){
                debugger
                var id=row.id;
                app.$Modal.confirm({
                    title: "删除岗位",
                    content: "确定删除吗",
                    onOk: function () {
                       app.data5.splice(index, 1);
                        var data = {id: ""};
                        data.id = id;
                        $.ajax({
                            url: "/custom/postrank/deleteRank",
                            type: "post",
                            dataType: "json",
                            contentType: "application/json",
                            data: JSON.stringify(data),
                            success: function (data) {
                                if (data.result > 0) {
                                    app.$Message.success("删除成功");
                                } else {
                                    app.$Message.error("删除失败");

                                }
                            }
                        })
                    },
                    onCancel: function () {

                    }
                });
            },
            changeZt:function(row,index){
                debugger
                rankEdit = {};
                var ztdata=app.data5[index];
                var zt= ztdata.zt
                if(zt=='true'){
                    ztdata.zt='0';
                }else{
                    ztdata.zt='1';
                }
                rankEdit.id = ztdata.id;
                editRank();
                searchDataFun(searchData);
            }
        }
    })

    function searchDataFun(searchData) {
        data5 = [];
        $.ajax({
            url: "/custom/postrank/list",
            type: "post",
            dataType: "json",
            async: false,
            contentType: "application/json",
            data: JSON.stringify(searchData),
            success: function (data) {
                //console.log(data);
                data5 = [];
                $.each(data.result, function (i, val) {
                    if (val.zt == "1") {
                        val.zt = true;
                    } else if (val.zt == "0") {
                        val.zt = false;
                    }
                    val.gwjb = val.gwjb + "级";
                    val.gwjbid = val.gwjb;
                    val.bcbh = "0";
                    data5.push(val);
                })
                if (app) {
                    app.data5 = data5;
                }
            },
            error: function (e) {
                console.log(e);
            }
        });
    }

    /*编辑使用方法*/
    function editRank() {
        $.ajax({
            url: "/custom/postrank/addRank",
            type: "post",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(rankEdit),
            success: function (data) {
                if (data.result > 0) {
                    app.editModel = false;
                    app.editload = false;
                    app.$Message.success("更新成功");
                    rankEdit = {};
                    searchDataFun(searchData);
                } else {
                    app.$Message.error("更新失败");

                }
            }
        })
    }

    function getFormLoad() {
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





