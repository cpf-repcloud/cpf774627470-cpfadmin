window.onload=function (){
    var apps;
    var treeNodeList =[];
    var breadList =[];
    var employeeList =[];
    var deptList =[];
    var request = {
        gsid:"",
        bmid:""
    };
    $(function () {
        getEmployeeList();
    });

    function getBmMbx(sjid) {
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
                employeeList:employeeList,
                deptList:deptList,
                employee:"",
                deptid:"",
                sc:{},
                bmvo:{},
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
                getBmMbx(treeNodeList[0].value);
                _this.queryPage();
            },
            methods:{
                empChange:function (data) {
                    console.log(data);
                },
                deptChange:function (data) {
                    console.log(data);
                },
                editBms:function (bmid) {
                    apps.$forceUpdate();
                    apps.editBm = true;
                },
                checkedTreeNode:function (data) {
                    var _this = this;
                    if (data && data.length > 0){
                        var sjid = data[0].value;
                        _this.iquery.sjid = sjid;
                        getBmMbx(sjid);
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
                }
            }
        })
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
                    initVue();
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
            async:true,
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
            async:true,
            contentType: "application/json;charset=UTF-8",
            success: function (response) {
                if (response.status && response.status === "200") {
                    debugger
                    deptList = response.result;
                }
                treeNode();
            }
        });
    }

}