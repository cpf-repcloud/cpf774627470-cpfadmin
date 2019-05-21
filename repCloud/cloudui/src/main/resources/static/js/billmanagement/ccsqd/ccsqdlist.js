window.onload = function () {

    var dataT = {
        "id": "",
        "lb": "",
        "lbmc": ""
    }

    var datas = [];
    var app;
    var tableData = [];
    var tableColumns = [
        {
            title: "序号",
            type: 'index',
            width: 70,
            align: 'center'
        },
        {
            title: "操作",
            width: 80,
            key: 'action',
            align: 'center'
        },
        {
            title: "申请单号",
            width: 150,
            key: 'sqdh',
            align: 'center'
        },
        {
            title: "单据状态",
            width: 100,
            key: 'djzt',
            align: 'center'
        },
        {
            title: "审批状态",
            width: 100,
            key: 'djztMc',
            align: 'center'
        },
        {
            title: "出差类型",
            width: 100,
            key: 'cclxMc',
            align: 'center'
        },
        {
            title: "行程", /* cf-dd*/
            key: 'xc'
        },
        {
            title: "出行人员", /* cf-dd*/
            key: 'ccry'
        },
        {
            title: "成本中心",
            key: 'cbzxmc',
            align: 'center'
        },
        {
            title: "申请时间",
            key: 'cbzx',
            align: 'center'
        },

    ];
    initVue();


    function initVue() {
        app = new Vue({
            el: "#app",
            data: {
                iquery: {
                    lb: ""
                },
                igrid: {
                    url: "/custom/repccsqb/queryCcsqbPage",
                    loading: false,
                    datas: tableData,
                    columns: tableColumns
                },
                modalData: {
                    addModal: false,
                    loading: true,
                },
                addCcsqdData: {
                    ccryStr:[],
                    cbzx:[],
                    xmbh:[],
                    ccsy:"",
                    xcjh: [{
                        cfd: "", mdd: "", cfsj: "", ddsj: "", sxh: "",
                        cfdArr:"",mddArr:"",jtgj:"1",
                        startTimeOption: {
                            disabledDate: function (dataTime) {
                                return dataTime < new Date(getTimeStr());
                            }
                        },
                        endTimeOption: {
                            disabledDate: function (dataTime) {
                                return dataTime < new Date(getTimeStr());
                            }
                        }
                    }],
                    cclx: "2"
                },
                detailCcsqdData: {}, // 出差申请单详情数据
                pStyle: {
                    fontSize: '16px',
                    color: 'rgba(0,0,0,0.85)',
                    lineHeight: '24px',
                    display: 'block',
                    marginBottom: '16px'
                },
                model: false,
                fjFile: [],
                employeeList: [],//员工控件数据
                costcenterList: [],//成本中心控件数据
                projectList: [],//项目控件数据
                user: {},
                nowTime: "",
                nowTimeStr:""

            },
            mounted: function () {
                this.queryPage();
                this.initKj();
            },
            methods: {
                search: function () {
                    this.$refs.queryForm.validate(function (flag) {
                        ////console.log(arguments);
                    });
                    //this.iquery.lb = "";
                    //this.queryPage();
                },
                gridSuccsess: function (data) {
                    var result = data.result;
                    this.ipage.total = result.total;
                    tableData = result.records;
                    this.igrid.datas = result.records;
                    this.igrid.loading=false;

                },
                initKj: function () {
                    this.getEmployeeList({});
                    this.getCostconterList({});
                    this.getProjectList({});
                    this.getUser();
                },
                timeFormate: function () {
                    var data = new Date();
                    var year = data.getFullYear();
                    var month = data.getMonth() + 1 < 10 ? "0" + (data.getMonth() + 1) : data.getMonth() + 1;
                    var date = data.getDate() < 10 ? "0" + data.getDate() : data.getDate();
                    var hh = data.getHours() < 10 ? "0" + data.getHours() : data.getHours();
                    var mm = data.getMinutes() < 10 ? "0" + data.getMinutes() : data.getMinutes();
                    app.nowTime = year + "年" + month + "月" + date + "日" + " " + hh + ":" + mm;
                },
                dataChange: function (index, data1, type,rules) {
                    if (app.modalData.addModal) {
                        if (type == 'cfd') {
                            app.addCcsqdData.xcjh[index].cfdid = data1.id;
                            app.addCcsqdData.xcjh[index].cfdmc = data1.name;
                            app.addCcsqdData.xcjh[index].cfdArr=data1.id;

                        } else if (type == 'mdd') {
                            app.addCcsqdData.xcjh[index].mddid = data1.id;
                            app.addCcsqdData.xcjh[index].mddmc = data1.name;
                            app.addCcsqdData.xcjh[index].mddArr=data1.id;
                        }
                    }
                    app.$refs["addCcsqdData"].validateField(rules,null);
                   // app.addCcsqdDataRules[rules] = [{required: false, trigger: 'blur'}]
                    /*console.log(app.$refs["addCcsqdData"]);
                    app.$refs["addCcsqdData"][rules].validate();*/
                    app.$forceUpdate();
                },
                selectCcry: function (val, data) {
                    debugger
                    console.log(data);
                    var ryList = [];
                    var ccry = "";
                    if (data) {
                        $.each(data, function (i, val) {
                            var tempdata = {
                                ygxm: val.name,
                                ygid: val.id,
                                sxh: i + 1,
                                bmid: val.bmid,
                                cxrlx: "1",
                                bxzt: '0',
                            };
                            ccry += ("," + val.name);
                            ryList.push(tempdata);
                        })
                    }
                    if (ccry) {
                        ccry = ccry.substring(1, ccry.length);
                    }
                    app.addCcsqdData.ccryStr=data;
                    app.addCcsqdData.ryList = ryList;
                    app.addCcsqdData.ccry = ccry;
                    app.$forceUpdate();
                },
                selectCfd: function (index, val, data) {
                    console.log(data);
                },
                selectMdd: function (index, val, data) {

                },
                selectCbzx: function (val, data) {
                    if (data) {
                        var cbzx = data[0];
                        if (app.modalData.addModal && cbzx) {
                            app.addCcsqdData.cbzxbh = cbzx.value;
                            app.addCcsqdData.cbzxmc = cbzx.name;
                        }
                    }
                    app.addCcsqdData.cbzx=val;
                    app.$forceUpdate();
                },
                selectProject: function (val, data) {
                    if (data) {
                        var xm = data[0];
                        if (app.modalData.addModal && xm) {
                            app.addCcsqdData.xmbh = xm.value;
                            app.addCcsqdData.xmmc = xm.name;
                        }
                    }
                    app.addCcsqdData.xmbh = val;
                },

                addCcsqd: function () {
                    // 打开新增页面
                    debugger
                    app.$refs["addCcsqdData"].resetFields();
                    console.log(app.user);
                    this.timeFormate();
                    console.log(app.cityXlList);
                    app.$forceUpdate();
                    app.modalData.addModal = false;
                    setTimeout(function () {
                        app.modalData.addModal = true;
                    }, 11)
                },
                okAddCcsqd: function () {
                    app.$refs["addCcsqdData"].validate(function (valid) {
                        if (valid) {
                            var timedata=app.addCcsqdData.xcjh;
                            var isPass=true;
                            var index=0;
                            $.each(timedata,function(i,val) {
                                if(i==0){
                                    if(val.cfsj>val.ddsj) {
                                        isPass=false;
                                        index=i;
                                        return false;
                                    }
                                }else{
                                    if(val.cfsj>val.ddsj){
                                        isPass=false;
                                        index=i;
                                        return false;
                                    }
                                    if(val.cfsj<timedata[i-1].ddsj) {
                                        isPass=false;
                                        index=i;
                                        return false;
                                    }
                                }
                            });
                            if(!isPass) {
                                app.$refs["addCcsqdData"].validateField("xcjh."+index+".cfsj",function(error){
                                    app.$Message.error("出发时间不能大于到达时间！");
                                    setTimeout(function () {
                                        app.modalData.loading = false;
                                        app.$nextTick(function () {
                                            app.modalData.loading = true;
                                        });
                                    }, 100)
                                });
                                setTimeout(function () {
                                    app.modalData.loading = false;
                                    app.$nextTick(function () {
                                        app.modalData.loading = true;
                                    });
                                }, 100)
                                return false;
                            }

                            app.modalData.addModal = true;
                            console.log(app.addCcsqdData);
                            var xchj = app.addCcsqdData.xcjh;
                            var rcList = [];
                            if (xchj) {
                                $.each(xchj, function (ii, val) {
                                    var tempData = {
                                        cfdid: val.cfdid,
                                        mddid: val.mddid,
                                        cfdmc: val.cfdmc,
                                        mddmc: val.mddmc
                                    };
                                    if (val.cfsj) {
                                        tempData.cfsj = app.getStrDate(val.cfsj);
                                    }
                                    if (val.ddsj) {
                                        tempData.ddsj = app.getStrDate(val.ddsj);
                                    }
                                    tempData.sxh = ii + 1;
                                    rcList.push(tempData);
                                })
                            }
                            app.addCcsqdData.rcList = rcList;
                            var formData = new FormData();
                            formData.append("addCcsqdData", JSON.stringify(app.addCcsqdData));
                            $.each(app.fjFile,function(i,val){
                                formData.append("file",val);
                            })
                            $.ajax({
                                url: "/custom/repccsqb/insertCcsqb",
                                type: 'post',
                                data: formData,
                                async: false,
                                dataType: 'json',
                                processData: false,
                                contentType: false,
                                success: function (resule) {
                                    console.log(resule);
                                }
                            })
                        }else {
                            app.$Message.error('表单验证失败!');
                            setTimeout(function () {
                                app.modalData.loading = false;
                                app.$nextTick(function () {
                                    app.modalData.loading = true;
                                });
                            }, 100)
                        }
                    });
                },
                cancel: function () {
                },
                //新增行程计划
                addXcjh: function () {
                    var xcArr = app.addCcsqdData.xcjh;
                    var length = xcArr.length;
                    var index=length - 1;
                    var ruleCfdArr,ruleMddArr,ruleCfsj,ruleDdsj;
                    app.$refs["addCcsqdData"].validateField("xcjh."+index+".cfdArr",function(error){
                         ruleCfdArr=error;
                    });
                    app.$refs["addCcsqdData"].validateField("xcjh."+index+".mddArr",function(error){
                        ruleMddArr=error;
                    });
                    app.$refs["addCcsqdData"].validateField("xcjh."+index+".cfsj",function(error){
                        ruleCfsj=error;
                    });
                    app.$refs["addCcsqdData"].validateField("xcjh."+index+".ddsj",function(error){
                        ruleDdsj=error;
                    });
                    if(!ruleCfdArr&&!ruleMddArr&&!ruleCfsj&&!ruleDdsj) {
                        var lastXcData = xcArr[length - 1].ddsj;
                        // cfmrsj 出发默认时间
                        var adddata = {
                            cfd: "", mdd: "", cfsj: "", ddsj: "", sxh: "", cfmrsj: "",
                            cfdArr:"",mddArr:"",ccsy:"",
                            startTimeOption: {
                                disabledDate: function (dataTime) {
                                    return dataTime < new Date(getTimeStr()) ||  (lastXcData ? dataTime < new Date(app.formatTime(lastXcData)) :false);
                                }
                            },
                            endTimeOption: {
                                disabledDate: function (dataTime) {
                                    return dataTime < new Date(getTimeStr()) || (lastXcData ? dataTime < new Date(app.formatTime(lastXcData)) :false);
                                }
                            }
                        };
                        app.addCcsqdData.xcjh.push(adddata);
                    }
                    app.$forceUpdate();

                },
                onStartTimeChange: function (index, endTime, e) {
                    var lastEndTime;
                    if (index > 0) {
                        lastEndTime = app.addCcsqdData.xcjh[index - 1].cfsj;
                    }
                    app.addCcsqdData.xcjh[index].endTimeOption = {
                        disabledDate: function (dataTime) {
                            if (lastEndTime) {
                                return  dataTime < new Date(getTimeStr()) ||
                                    dataTime < new Date(app.formatTime(lastEndTime)) || dataTime < new Date(e);
                            } else {
                                return  dataTime < new Date(getTimeStr())|| dataTime < new Date(e);
                            }
                        }
                    }
                    app.addCcsqdData.xcjh[index].cfsj=e;
                    app.$forceUpdate();
                },
                onEndTimeChange: function (index, startTime,e) {
                    var nextStartTime;
                    if (app.addCcsqdData.xcjh.length > index + 1) {
                        nextStartTime = app.addCcsqdData.xcjh[index + 1].cfsj;
                    }
                    app.addCcsqdData.xcjh[index].startTimeOption = {
                        disabledDate: function (dataTime) {
                            if (nextStartTime) {
                                return  dataTime < new Date(getTimeStr()) ||
                                    dataTime > new Date(app.formatTime(nextStartTime)) || dataTime > new Date(e);
                            } else {
                                return  dataTime < new Date(getTimeStr()) || dataTime > new Date(e);
                            }
                        }
                    }
                    app.addCcsqdData.xcjh[index].ddsj=e;
                    app.$forceUpdate();
                },
                //删除行程计划
                deleteXc: function (index) {
                    app.addCcsqdData.xcjh.splice(index, 1);
                },
                //文件上传成功时候回调
                successFile: function (response, file, fileList) {
                    console.log(response);
                    console.log(file);
                    console.log(fileList);

                },
                //文件上传失败 回调
                errorFile: function (error, file, fileList) {
                    console.log(error);
                    console.log(file);
                    console.log(fileList);
                },
                // 上传文件之前的钩子
                handleUpload: function (file) {
                    console.log(file);
                    app.fjFile.push(file);
                    //http://106.12.74.114:9159/storage/upload
                },
                //删除上传的文件
                delFile: function (index) {
                    var fileDate = app.fjFile.splice(index, 0);
                    app.fjFile = fileDate;
                },
                uploadFile: function (file) {
                    debugger
                    console.log(file)
                },
                getStrDate: function (dataTemp) {
                    var date=new Date(dataTemp);
                    var y = date.getFullYear();
                    var m = date.getMonth() + 1;
                    m = m < 10 ? ('0' + m) : m;
                    var d = date.getDate();
                    d = d < 10 ? ('0' + d) : d;
                    var h = date.getHours();
                    var minute = date.getMinutes();
                    minute = minute < 10 ? ('0' + minute) : minute;
                    var second = date.getSeconds();
                    second = minute < 10 ? ('0' + second) : second;
                    return y + '-' + m + '-' + d + ' ' + h + ':' + minute + ':' + second;

                },
                formatTime:function(time){
                    return time+" 00:00:00"
                }
            },

            watch: {}
        });
    }



    function getTimeStr(){
        var data = new Date();
        var year = data.getFullYear();
        var month = data.getMonth() + 1 < 10 ? "0" + (data.getMonth() + 1) : data.getMonth() + 1;
        var date = data.getDate() < 10 ? "0" + data.getDate() : data.getDate();
        return year+"-"+month+"-"+date + " 00:00:00";
    }
};





