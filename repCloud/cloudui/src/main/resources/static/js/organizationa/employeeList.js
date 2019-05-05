
window.onload=function (){
    var apps;
    var treeNodeList =[];
    var employeeList =[];
    var deptList =[];
    var compList =[];
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
                editBmData:{},
                saveBmData:{},
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
                formSaveBmRule:{
                    ssgsid:[{required:true,message: "请选择所属公司",trigger: 'blur'}],
                    mc:[{required:true,message: "请输入部门名称",trigger: 'blur'}],
                    jc:[{required:true,message: "请输入部门简称",trigger: 'blur'}],
                    bh:[{required:true,message: "请输入部门编号",trigger: 'blur'}],
                    bmfzr:[{required:true,message: "请选择部门负责人",trigger: 'blur'}],
                    countryid:[{required:true,message: "请选择部门所在城市",trigger: 'blur'}],
                    cwzg:[{required:true,message: "请选择部门财务主管",trigger: 'blur'}],
                    bmdh:[{required:true,message: "请输入部门电话",trigger: 'blur'}],
                    szdz:[{required:true,message: "请输入部门详细地址",trigger: 'blur'}]
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
                empChange:function (val,data) {
                    console.log(data);
                },
                deptChange:function (data) {
                    console.log(data);
                },
                compChange:function (data) {
                    console.log(data);
                },
                editBms:function (bmid) {
                    apps.editBm = true;
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


}
