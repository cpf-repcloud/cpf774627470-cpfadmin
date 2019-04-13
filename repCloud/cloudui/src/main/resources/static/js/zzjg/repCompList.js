window.onload=function (){
    var columns = [
        {
            title:'序号',
            type: 'index',
            width: 80,
            align: 'center'
        },
        {
            title: '公司简称',
            key: 'compjc',
            render:function (h,params) {
                return h('a',{
                    on:{
                        click:function () {
                            alert(params.row.name);
                        }
                    }
                },params.row.name)
            }
        },
        {
            title: '总公司',
            key: 'zgs'
        },
        {
            title: '公司电话',
            key: 'phonenumber'
        },
        {
            title: '公司邮件',
            key: 'email'
        },
        {
            title: '最后修改人',
            key: 'updateuser'
        },
        {
            title: '最后修改时间',
            key: 'updatetime'
        },
        {
            title: '是否有效',
            key: 'isdisabled',
            render:function (h,params) {
                return h('i-switch',{
                    props: {
                        size: 'large',
                        value: params.row.isdisabled==1?true:false
                    },
                    style: {
                        marginRight: '5px'
                    },
                    on: {
                        'on-change':function (value) {
                            apps.iquery.isdisabled = value?"1":"0";
                            apps.iquery.id = params.row.id;
                            apps.edit();
                        }
                    }
                },[h('span',{
                    slot:"open",domProps:{innerHTML:'有效'}
                }),h('span',{
                    slot:"close",domProps:{innerHTML:'无效'}
                })])
            }
        },{
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
                                apps.addMenu = true;
                                $.extend(true,apps.saveData,params.row);
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
                                apps.iquery.id = params.row.id;
                                apps.deleteRepModular();
                            }
                        }
                    },'删除')
                ])
            }
        }
    ];
    var apps= new Vue({
        el: '#app',
        data:{
            columns1: columns,
            pagedata: [],
            formRule:{
                compmc:[{required:true,message: "请输入公司名称",trigger: 'blur'}],
                compjc:[{required:true,message: "请输入公司简称",trigger: 'blur'}],
                compaddress:[{required:true,message: "请输入公司地址",trigger: 'blur'}],
                phonenumber:[{required:true,message: "请输入公司电话",trigger: 'blur'}],
                email:[{required:true,message: "请输入公司邮件",trigger: 'blur'}],
                homepage:[{required:true,message: "请输入公司地址",trigger: 'blur'}]
            },
            igrid:{
                url:"/custom/repComp/list",
                loading:false
            },
            addComp:false,
            iquery:{
                id:"",
                isdisabled:""
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
            _this.parentMenu();
        },
        methods:{
            search: function (){
                var _this=this;
                apps.pagedata=[];
                _this.queryPage();
            },
            edit:function () {
                var url = "/custom/repModular/edit";
                apps.igrid.loading = true;
                $.ajax({
                    type:"POST",
                    url:url,
                    data:JSON.stringify(apps.iquery),
                    dataType:"json",
                    contentType:"application/json;charset=UTF-8",
                    success:function(response){
                        apps.igrid.loading = false;
                        if(response.status  && response.status === "200"){
                            apps.$Message.success("修改成功!");
                            //window.location.reload();
                            apps.queryPage();
                        }else{
                            apps.$Message.error("修改失败!");
                        }
                    },
                    error:function(){
                        apps.igrid.loading = false;
                        this.$Message.error("系统错误,请联系管理员!");
                    }
                });
            },
            saveComp:function () {
                apps.saveData = {id:"",compmc:"",compjc:"",compaddress:"",zgs:"",phonenumber:"",email:"",
                    homepage:"",business:"",isdisabled:""};
                apps.addComp = true;
            },
            parentMenu:function () {
                var url = "/custom/repModular/parentList";
                $.ajax({
                    type:"POST",
                    url:url,
                    data:JSON.stringify({}),
                    dataType:"json",
                    contentType:"application/json;charset=UTF-8",
                    success:function(response){
                        if(response.status  && response.status === "200"){
                            apps.parentList = response.result;
                        }
                    },
                    error:function(){
                        this.$Message.error("系统错误,请联系管理员!");
                    }
                });
            },
            save:function () {
                var url = "/custom/repModular/addRepModular";
                $.ajax({
                    type:"POST",
                    url:url,
                    data:JSON.stringify(apps.saveData),
                    dataType:"json",
                    contentType:"application/json;charset=UTF-8",
                    success:function(response){
                        if(response.status  && response.status === "200"){
                            apps.$Message.success("修改成功!");
                            //window.location.reload();
                            apps.queryPage();
                        }
                    },
                    error:function(){
                        this.$Message.error("系统错误,请联系管理员!");
                    }
                });
            },
            deleteRepModular:function () {
                var url = "/custom/repModular/delete";
                $.ajax({
                    type:"POST",
                    url:url,
                    data:JSON.stringify(apps.iquery),
                    dataType:"json",
                    contentType:"application/json;charset=UTF-8",
                    success:function(response){
                        if(response.status  && response.status === "200"){
                            apps.$Message.success("删除成功!");
                            //window.location.reload();
                            apps.queryPage();
                        }
                    },
                    error:function(){
                        this.$Message.error("系统错误,请联系管理员!");
                    }
                });
            }
        }
    })
}
