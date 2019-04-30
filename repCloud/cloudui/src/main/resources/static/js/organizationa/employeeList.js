
window.onload=function (){
    var apps;
    var treeNodeList =[];
    var employeeList =[];
    var deptList =[];
    var countryList =[];
    var countryid = [];
    var request = {
        gsid:"",
        bmid:""
    };
    $(function () {
        treeNode();
    });

    var breadList = [];
    var bmvo;
    var deptid;
    var employee;

    function getBmMbx(sjid) {
        $.ajax({
            type: "GET",
            url: "/custom/repDept/getBmMbx?chrId="+sjid,
            dataType: "json",
            contentType: "application/json;charset=UTF-8",
            success: function (response) {
                if (response.status && response.status === "200") {
                    breadList = response.result.mbxList;
                    bmvo = response.result;
                    deptid = response.result.id;
                    employee = response.result.bmfzr;
                    getEmployeeList();
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
                countryid:[],
                countryList:countryList,
                countryid:countryid,
                employeeList:employeeList,
                deptList:deptList,
                employee:employee,
                deptid:deptid,
                sc:{},
                bmvo:bmvo,
                loading:false,
                upload:false,
                addEmp:false,
                addDept:false,
                showMore:false,
                editBm:false,
                columns1: [],
                pagedata: [],
                treeNode:treeNodeList,
                breadList:breadList,
                formRule:{
                    compmc:[{required:true,message: "请输入公司名称",trigger: 'blur'}],
                    compjc:[{required:true,message: "请输入公司简称",trigger: 'blur'}],
                    compaddress:[{required:true,message: "请输入公司地址",trigger: 'blur'}],
                    phonenumber:[{required:true,message: "请输入公司电话",trigger: 'blur'}],
                    email:[{required:true,message: "请输入公司邮件",trigger: 'blur'}],
                    homepage:[{required:true,message: "请输入公司地址",trigger: 'blur'}]
                },
                igrid:{
                    // url:"/custom/repComp/list",
                    // loading:false
                },
                iquery:{
                    sjid:"",
                    zt:""
                },
                saveData:{
                    id:"",compmc:"",compjc:"",compaddress:"",zgs:"",phonenumber:"",email:"",
                    homepage:"",business:"",isdisabled:""
                }
            },
            mounted:function (){
                var _this=this;
                _this.queryPage();
            },
            methods:{
                cancelEmp:function () {
                    apps.addEmp = false;
                    this.$refs.saveData.resetFields();
                },
                saveEmp:function () {

                },
                empChange:function (data) {
                    console.log(data);
                },
                deptChange:function (data) {
                    console.log(data);
                },
                editBms:function (bmid) {
                    apps.editBm = true;
                    getCountryList();
                    if (apps.bmvo && apps.bmvo.xxszdzid){
                        var list = apps.bmvo.xxszdzid.split(",");
                        apps.countryid = list;
                    }
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
                changeCity:function (value, selectedData) {
                    console.log(JSON.stringify(value));
                    console.log(JSON.stringify(selectedData));
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
                    getBmMbx(treeNodeList[0].value);
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
                    initVue();
                }
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
            async:true,
            success: function (response) {
                if (response.status && response.status === "200") {
                    apps.countryList = response.result;
                }
            }
        });
    }


}
