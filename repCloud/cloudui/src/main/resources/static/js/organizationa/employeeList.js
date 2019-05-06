
window.onload=function (){
    var apps;
    var treeNodeList =[];
    var employeeList =[];
    var deptList =[];
    var compList =[];
    var countryList =[];
    var countryid = [];
    var saveBmData = {
        id:"",ssgsid:"",mc:"",jc:"",bh:"",bmfzr:"",countryid:"",cwzg:"",bmdh:"",szdz:""
    };
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
                columns1: [],
                pagedata: [],
                treeNode:treeNodeList,
                breadList:breadList,
                formSaveBmRule:{
                    ssgsid:[{required:true,message: "请选择所属公司",trigger: 'change'}],
                    bmfzr:[{required:true,message: "请选择部门负责人",trigger: 'change'}],
                    cwzg:[{required:true,message: "请选择部门财务主管",trigger: 'change'}],
                    mc:[{required:true,message: "请输入部门名称",trigger: 'blur'}],
                    jc:[{required:true,message: "请输入部门简称",trigger: 'blur'}],
                    bh:[{required:true,message: "请输入部门编号",trigger: 'blur'}],
                    countryid:[{required:true,message: "请选择部门所在城市",trigger: 'change'}],
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
                }
            },
            mounted:function (){
                var _this=this;
                _this.queryPage();
            },
            methods:{
                cancelEmp:function () {
                    apps.addEmp = false;
                },
                saveEmp:function () {
                    apps.addDept = true;
                    apps.$refs["saveBmDatas"].resetFields();
                },
                saveDept:function () {
                    // debugger
                    // apps.$refs["saveBmDatas"].validate(function(flag) {
                    //     if(flag){
                    //         alert(2);
                    //     }
                    // })


                    apps.$refs["saveBmDatas"].validate(function (valid) {
                        if (valid) {
                            $.ajax({
                                url: "/custom/repXm/addPro",
                                type: "post",
                                dataType: 'json',
                                contentType: "application/json",
                                data: JSON.stringify(apps.saveBmData),
                                success: function (data) {
                                    if (data.status == 200) {
                                        apps.$Message.success("新增成功");
                                        apps.saveBmData = {};
                                        apps.adddeptload = false;
                                        apps.addDept = false;
                                        treeNode();
                                    } else {
                                        app.$Message.error("新增失败");
                                    }
                                },
                                error: function (e) {
                                    console.log(e);
                                    app.addload = false;
                                }
                            })
                        }
                        else {
                            apps.$Message.error('表单验证失败!');
                            setTimeout(function () {
                                apps.adddeptload = false;
                                apps.$nextTick(function () {
                                    apps.adddeptload = true;
                                });
                            }, 100)

                        }
                    })


                },
                cancelDept:function () {
                    this.$refs.saveBmData.resetFields();
                },
                empChange:function (val,data) {
                    apps.saveBmData.bmfzr = val[0];
                },
                deptChange:function (data) {
                    console.log(data);
                },
                compChange:function (val,data) {
                    debugger
                    apps.saveBmData.ssgsid = val[0];
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
                    apps.saveBmData.countryid = value[0];
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
