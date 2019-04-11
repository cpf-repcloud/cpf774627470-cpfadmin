window.onload= function (){
    var leftMenu=[];
    var app= new Vue({
        el: '#app',
        data:{
            leftMenu:undefined,
            employee:{},
            topMenu:[
                {
                    name:'首页',
                    url:'/repModular/repModularList',
                    id:'000',
                    parrentId:'none'
                }
                ],
            nowId:'000',
            menuDh:''
        },
        mounted:function(){
            this.leftMenu=leftMenu;
            var _this=this;
            var id = $("#id").val();
            $.ajax({
                url: '/custom/repModular/getRepModular?id='+id
                , type: 'POST'
                , data: JSON.stringify({})
                , contentType: 'application/json;charset=utf-8'
                , success: function (data) {
                    console.log(JSON.stringify(data));
                    debugger
                    _this.employee = data.result.repYg;
                    console.log(_this.employee);
                    _this.leftMenu=data.result.menuList;
                }
            })
        },
        methods:{
            menuFunc:function(item){
                var topMenu=this.topMenu,
                _this=this,
                    i=0;
                this.menuDhFn(item);
                    topMenu.forEach(function(list){
                        i++;
                        if(item.id==list.id){
                            i--;
                        }else{
                            if(i==topMenu.length) topMenu.push(item);
                            _this.nowId= item.id;
                        }
                    })
            },
            topMenuFun:function(item){
                this.nowId=item.id;
                this.menuDhFn(item);
            },
            menuDhFn: function (item){
                debugger;
                var _this=this;
                if(item.parrentId !== 'none'){
                    this.leftMenu.forEach(function(pList){
                        if(pList.id==item.parrentId){
                            _this.menuDh= ' / '+pList.name+' / '+item.name
                        }
                    })
                }else {
                    _this.menuDh='';
                }
            },
            closeMenu:function(i){
                 this.topMenu.splice(i,1);
                this.nowId=this.topMenu[i-1].id;
            }
        }
    })

    $(".login-out").click(function () {
        alert(111);
    })
    // 展开与收缩左侧边栏
    var slidleft=true;
$(".slide_left").click(function () {
    var nowDom=$(this);
    if(nowDom.hasClass("slide_rotate")){
        nowDom.removeClass("slide_rotate");
    }else{
        nowDom.addClass("slide_rotate");
    }
    if(slidleft){
        $('article').animate({
            left:'-220px'
        })
        $('section').animate({
            left:'0'
        })
    } else{
        $('article').animate({
            left:'0'
        })
        $('section').animate({
            left:'220px'
        })
    }
    slidleft=!slidleft;
})
    // 左侧菜单子节点的点击事件
    var iframe='<iframe src="11" frameborder="0" class="content_page"></iframe>';
    var li='<li></li>'
$(".article_child").click(function(){
    var src= $(this).attr("data-src");
    $("#content_page").attr("src",src);
})
}

