window.onload=function (){
    var apps= new Vue({
        el: '#app',
        data:{
            sc:{},
            loading:false,
            upload:false,
            breadList:"",
            showMore:false,
            columns1: [],
            pagedata: [],
            treeNodeList:"",
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
            addComp:false,
            iquery:{
                sjid:"",
                zt:""
            },
            parentList:[],
            saveData:{
                id:"",compmc:"",compjc:"",compaddress:"",zgs:"",phonenumber:"",email:"",
                homepage:"",business:"",isdisabled:""
            },
            value:""
        },
        mounted:function (){
            var _this=this;
            _this.queryPage();
        },
        methods:{
            // showMore:function (data) {
            //     alert(data);
            // },
            download:function () {
                window.location.href = "/custom/repEmployee/downloadModel";
            },
            scProgress:function (event, file, fileList) {
                apps.loading = true;
            },
            scSuccess:function (response, file, fileList) {
                debugger
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