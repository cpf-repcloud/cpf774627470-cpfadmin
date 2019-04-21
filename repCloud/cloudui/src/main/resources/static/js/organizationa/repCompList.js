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
            key: 'jc',
            render:function (h,params) {
                return h('a',{
                    on:{
                        click:function () {
                            alert(params.row.jc);
                        }
                    }
                },params.row.jc)
            }
        },
        {
            title: '上级公司',
            key: 'sjmc'
            // render: function (h, params) {
            //     return h('div', {
            //         // params.row.sjmc == null ? '无上级' : params.row.sjmc,
            //         props:{
            //             text:params.row.sjmc
            //         },
            //         style:{
            //             textAlign: 'center'
            //         }
            //     });
            // }
        },
        {
            title: '所在城市',
            key: 'szcs'
        },
        {
            title: '最后修改人',
            key: 'cjr'
        },
        {
            title: '最后修改时间',
            key: 'cjsj',
            render: function (h, params) {
                return h('div',
                    formatDate(new Date(params.row.cjsj),'MM-dd hh:mm')
                );
            }
        },
        {
            title: '状态',
            key: 'zt',
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
                            apps.iquery.zt = value?"1":"0";
                            apps.iquery.id = params.row.id;
                            //apps.edit();
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
    var apps;
    var treeNodeList =[];
    var breadList =[];
    $.ajax({
        type: "POST",
        url: "/custom/repComp/getTreeNodes",
        data: {},
        dataType: "json",
        contentType: "application/json;charset=UTF-8",
        success: function (response) {
            if (response.status && response.status === "200") {
                treeNodeList = response.result;
                breadList.push(treeNodeList[0].title);
            }
            initVue();
        }
    })


    function initVue() {
        apps= new Vue({
            el: '#app',
            data:{
                breadList:breadList,
                columns1: columns,
                pagedata: [],
                treeNodeList:treeNodeList,
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
                },
                checkedTreeNode:function (data) {
                    var _this = this;
                    if (data && data.length > 0){
                        var sjid = data[0].value;
                        _this.iquery.sjid = sjid;
                        getMbx(sjid);
                        this.queryPage();
                    }
                }
            }
        })
    }

    function getMbx(chrId) {
        var url = "/custom/repComp/getMbx?chrId="+chrId;
        $.ajax({
            type:"GET",
            url:url,
            dataType:"json",
            contentType:"application/json;charset=UTF-8",
            success:function(response){
                if(response.status  && response.status === "200"){
                    apps.breadList = response.result;
                }
            },
            error:function(){
                apps.$Message.error("系统错误,请联系管理员!");
            }
        });
    }

}
