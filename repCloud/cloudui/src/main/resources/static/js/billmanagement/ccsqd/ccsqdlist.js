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
            key: 'djzt',
            align: 'center'
        },
        {
            title: "出差类型",
            width: 100,
            key: 'cclx',
            align: 'center'
        },
        {
            title: "行程", /* cf-dd*/
            key: 'xc'
        },
        {
            title: "成本中心",
            key: 'cbzx',
            align: 'center'
        },
        {
            title: "申请时间",
            key: 'cbzx',
            align: 'center'
        },

    ];

    var tableData = [];

    function initVue() {
        app = new Vue({
            el: "#app",
            data: {
                iquery: {
                    lb: ""
                },
                igrid: {
                    url: "/custom/basecommon/queryBaseCommonList",
                    loading: false,
                    data: tableData,
                    columns: tableColumns
                },
                modalData:{
                    addModal:false,
                    fjFile:[]
                },
                addCcsqdData:{
                    xcjh:[{mdd:"",cfsj:"",ddsj:"",sxh:""}]
                },
                detailCcsqdData:{}, // 出差申请单详情数据
                pStyle: {
                    fontSize: '16px',
                    color: 'rgba(0,0,0,0.85)',
                    lineHeight: '24px',
                    display: 'block',
                    marginBottom: '16px'
                }
                ,
                model:false



            },
            mounted: function () {
                //this.queryPage();
            },
            methods: {
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
                addCcsqd: function () {
                    // 打开新增页面
                    app.modalData.addModal=true;

                },
                okAddCcsqd:function(){

                },
                cancel:function(){},
                //新增行程计划
                addXcjh:function(){
                    var xcArr = app.addCcsqdData.xcjh;
                    var length=xcArr.length;
                    var lastXcData=xcArr[length-1];
                    // cfmrsj 出发默认时间
                    var adddata={mdd:"",cfsj:lastXcData.ddsj,ddsj:"",sxh:"",cfmrsj:lastXcData};
                    app.addCcsqdData.xcjh.push(adddata);
                },
                //删除行程计划
                deleteXc:function(index){
                    debugger
                    var xcArr = app.addCcsqdData.xcjh;
                    xcArr=xcArr.splice(0, index);
                    app.addCcsqdData.xcjh=xcArr;
                },
                //文件上传成功时候回调
                successFile:function(response,file,fileList){
                    console.log(response);
                    console.log(file);
                    console.log(fileList);

                },
                //文件上传失败 回调
                errorFile:function(error,file,fileList) {
                    console.log(error);
                    console.log(file);
                    console.log(fileList);
                },
                // 上传文件之前的钩子
                handleUpload:function(file){
                    console.log(file);
                    app.modalData.fjFile.push(file);
                },
                //删除上传的文件
                delFile:function(index) {
                    var fileDate = app.modalData.fjFile.splice(index, 0);
                    app.modalData.fjFile=fileDate;
                }
            },

            watch: {}
        });
    }


};




