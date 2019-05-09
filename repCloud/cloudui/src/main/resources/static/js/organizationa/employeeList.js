
window.onload=function (){
    var apps;
    var treeNodeList =[];
    var employeeList =[];
    var deptList =[];
    var compList =[];
    var countryList =[];
    var countryid = [];
    var tableDatas = [];
    var saveBmData = {
        id:"",mc:"",jc:"",bh:"",bmfzr:"",szcsid:"",cwzg:"",bmdh:"",szdz:"",sjid:"",ssgsbh:""
    };
    var request = {
        gsid:"",
        bmid:""
    };
    $(function () {
        treeNode();
    });

    var breadList = [];
    var bmvo={
        id:"",bh:"",sjbmmc:"",bmfzrmc:"",bmdh:"",jc:"",ssgsmc:"",xxszdz:"",cwzgmc:"",szdz:"",cwzg:"",sjid:"",
    };
    var deptid;
    var employee;

    var dataColumns=[
        {
            title: "序号",
            type: 'index',
            width: 80,
            align: 'center'
        },
        {
            title: "姓名",
            key: 'xm',
            align: 'center'
        },
        {
            title: "工号",
            key: 'gh',
            align: 'center'
        },
        {
            title: "状态",
            key: 'ktzt',
            align: 'center'
        },
        {
            title: "开通状态",
            key: 'ktzt',
            align: 'center'
        },
        {
            title: "岗位名称",
            key: 'ktzt',
            align: 'center'
        },
        {
            title:'操作',
            width: 150,
            render:function (h,params) {
                return h('div',[
                    h('a',{
                        style: {
                            fontSize: '14px',
                        },
                        on:{
                            click:function () {
                                // apps.addMenu = true;
                                // $.extend(true,apps.saveData,params.row);
                            }
                        }
                    },'编辑'),
                    h('a',{
                        style:{
                            fontSize: '14px',
                            paddingLeft:'6px',
                            paddingRight:'6px'
                        },
                        on:{
                            click:function () {
                                // apps.iquery.id = params.row.id;
                                // apps.deleteRepModular();
                            }
                        }
                    },'删除')
                ])
            }
        }
    ];

    function getBmMbx(sjid) {
        $.ajax({
            type: "GET",
            url: "/custom/repDept/getBmMbx?chrId="+sjid,
            dataType: "json",
            contentType: "application/json;charset=UTF-8",
            success: function (response) {
                if (response.status && response.status === "200") {
                    if (response.result != null && response.result.mbxList){
                        breadList = response.result.mbxList;
                        bmvo = response.result;
                        deptid = response.result.id;
                        employee = response.result.bmfzr;
                    }
                    getCountryList();
                }
            }
        });
    }
    function getBmMbx_app(sjid) {
        $.ajax({
            type: "GET",
            url: "/custom/repDept/getBmMbx?chrId="+sjid,
            dataType: "json",
            contentType: "application/json;charset=UTF-8",
            success: function (response) {
                if (response.status && response.status === "200") {
                    apps.breadList = response.result.mbxList;
                    apps.bmvo = response.result;
                    apps.deptid = response.result.id;
                    apps.employee = response.result.bmfzr;
                }
            }
        });
    }

    function initVue() {
        apps= new Vue({
            el: '#app',
            data:{
                xb:"男",
                editBmData:{},
                addEmployee:{},
                saveBmData:saveBmData,
                compList:compList,
                countryid:[],
                countryList:countryList,
                countryid:countryid,
                employeeList:employeeList,
                deptList:deptList,
                employee:employee,
                deptid:deptid,
                sc:{},
                bmvo:bmvo,
                adddeptload:true,
                loading:false,
                upload:false,
                addload:false,
                addEmp:false,
                addDept:false,
                showMore:false,
                editBm:false,
                dataColumns: dataColumns,
                pagedata: [],
                treeNode:treeNodeList,
                breadList:breadList,
                formSaveBmRule:{
                    bmfzr:[{required:true,message: "请选择部门负责人",trigger: 'change'}],
                    cwzg:[{required:true,message: "请选择部门财务主管",trigger: 'change'}],
                    mc:[{required:true,message: "请输入部门名称",trigger: 'blur'}],
                    jc:[{required:true,message: "请输入部门简称",trigger: 'blur'}],
                    bh:[{required:true,message: "请输入部门编号",trigger: 'blur'}],
                    szcsid:[{required:true,message: "请选择部门所在城市",trigger: 'change'}],
                    bmdh:[{required:true,message: "请输入部门电话",trigger: 'blur'}],
                    szdz:[{required:true,message: "请输入部门详细地址",trigger: 'blur'}]
                },
                igrid:{
                    url:"/custom/repEmployee/list",
                    loading:false
                },
                iquery:{
                    sjid:"",
                    zt:""
                }
            },
            mounted:function (){
                var _this=this;
                _this.queryPage();
            },
            methods:{
                gridSuccsess: function (data) {
                    if (data && data.status == '200' && data.result) {
                        var result = data.result;
                        debugger
                        console.log(result);
                        if (result.records.length > 0) {
                            apps.pagedata = result.records;
                            // if (result.records[0].xmbh) {
                            //     console.log(result.records[0].cyjs);
                            //     tableData = result.records;
                            //     this.igrid.datas = result.records;
                            //     this.ipage.total = result.total;
                            // } else {
                            //     this.igrid.datas = tableData;
                            //     this.igrid.columns = tableColumns;
                            //     tableDatas = result.records;
                            //     this.igrids.datas = result.records;
                            //     this.ipage.total = result.total;
                            // }
                        }
                    }
                },
                cancelEmp:function () {
                    apps.addEmp = false;
                },
                saveEmp:function () {
                    apps.addDept = true;
                    apps.$refs["saveBmDatas"].resetFields();
                },
                saveDept:function () {
                    apps.$refs["saveBmDatas"].validate(function (valid) {
                        if (valid) {
                            $.ajax({
                                url: "/custom/repDept/saveDept",
                                type: "post",
                                dataType: 'json',
                                contentType: "application/json",
                                data: JSON.stringify(apps.saveBmData),
                                success: function (data) {
                                    if (data.status == 200 && data.result) {
                                        apps.$Message.success("新增成功");
                                        apps.saveBmData = {};
                                        apps.adddeptload = false;
                                        apps.addDept = false;
                                        treeNode();
                                    } else {
                                        apps.adddeptload = false;
                                        apps.$Message.error("新增失败");
                                    }
                                },
                                error: function (e) {
                                    console.log(e);
                                    apps.addload = false;
                                }
                            })
                        }
                        else {
                            validateError()
                        }
                    })
                },
                cancelDept:function () {

                },
                editDept:function () {

                },
                bmfzrChange:function (val,data) {
                    apps.saveBmData.bmfzr = val[0];
                },
                cwzgChange:function (val,data) {
                    apps.saveBmData.cwzg = val[0];
                },
                deptChange:function (val,data) {
                    apps.saveBmData.sjid = val[0];
                    console.log(data);
                },
                compChange:function (val,data) {
                    debugger
                    apps.saveBmData.ssgsid = val[0];
                    apps.saveBmData.ssgsbh = data[0].value;
                    console.log(data);
                },
                editBms:function (bmid) {
                    apps.editBm = true;
                    if (apps.bmvo && apps.bmvo.xxszdzid){
                        var list = apps.bmvo.xxszdzid.split(",");
                        apps.countryid = list;
                    }
                },
                empChange:function () {

                },
                saveEmployee:function () {

                },
                checkedTreeNode:function (data) {
                    var _this = this;
                    if (data && data.length > 0){
                        var sjid = data[0].value;
                        _this.iquery.sjid = sjid;
                        getBmMbx_app(sjid);
                        //this.queryPage();
                    }
                },
                download:function () {
                    window.location.href = "/custom/repEmployee/downloadModel";
                },
                scProgress:function (event, file, fileList) {
                    apps.loading = true;
                },
                scSuccess:function (response, file, fileList) {
                    apps.sc = {};
                    apps.loading = false;
                    $(".kssc").hide();
                    $(".sbyy").show();
                    $(".sc-footer").show();
                    apps.sc = response.result;
                },
                matchUpload:function () {
                    apps.upload = true;
                    $(".sbyy").hide();
                    $(".sc-footer").hide();
                    $(".kssc").show();
                },
                changeCity:function (selectedData) {
                    // console.log(JSON.stringify(value));
                    apps.saveBmData.szcsid = selectedData.id;
                    console.log(JSON.stringify(selectedData));
                    // apps.saveBmData.countryid = value;
                }
            }
        });
        window.apps=apps;
    }

    function treeNode() {
        $.ajax({
            type: "POST",
            url: "/custom/repDept/getTreeNodes",
            data: {},
            dataType: "json",
            contentType: "application/json;charset=UTF-8",
            success: function (response) {
                if (response.status && response.status === "200") {
                    treeNodeList = response.result;
                    debugger
                    if (response.result != null && response.result.length>0){
                        getBmMbx(treeNodeList[0].value);
                    }else{
                        getBmMbx("");
                    }
                }
            }
        });
    }

    //查询员工控件
    function getEmployeeList() {
        $.ajax({
            type: "POST",
            url: "/custom/kj/employee/getEmployeeList",
            data: JSON.stringify(request),
            dataType: "json",
            contentType: "application/json;charset=UTF-8",
            success: function (response) {
                if (response.status && response.status === "200") {
                    employeeList = response.result;
                }
                getDeptList();
            }
        });
    }

    //查询部门控件
    function getDeptList() {
        $.ajax({
            type: "POST",
            url: "/custom/kj/dept/getDeptList",
            data: JSON.stringify(request),
            dataType: "json",
            contentType: "application/json;charset=UTF-8",
            success: function (response) {
                if (response.status && response.status === "200") {
                    deptList = response.result;
                }
                getCompList();
            }
        });
    }
    //查询公司控件
    function getCompList() {
        $.ajax({
            type: "POST",
            url: "/custom/kj/comp/getCompList",
            data: JSON.stringify(request),
            dataType: "json",
            contentType: "application/json;charset=UTF-8",
            success: function (response) {
                if (response.status && response.status === "200") {
                    compList = response.result;
                }
                initVue();
            }
        });
    }

    function getCountryList() {
        $.ajax({
            type: "POST",
            url: "/custom/country/getCountryList",
            data: {},
            dataType: "json",
            contentType: "application/json;charset=UTF-8",
            success: function (response) {
                if (response.status && response.status === "200") {
                    countryList = response.result;
                }
                getEmployeeList();
            }
        });
    }

    function validateError() {
        apps.$Message.error('表单验证失败!');
        setTimeout(function () {
            apps.adddeptload = false;
            apps.$nextTick(function () {
                apps.adddeptload = true;
            });
        }, 100)
    }



}
