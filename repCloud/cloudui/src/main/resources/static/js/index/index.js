window.onload= function (){
    var leftMenu=[];
    var h = 0;

    function contentsH() {
        var contentsH = $("section").height();
        var footerh = contentsH - 55 - 40 - 8;
        debugger
        $(".index_footer").height(footerh);
    }

    function mouseScroll() {
        var outDiv = document.getElementById('mouseScroll');
        outDiv.onwheel = function(event){
            //禁止事件默认行为（此处禁止鼠标滚轮行为关联到"屏幕滚动条上下移动"行为）
            event.preventDefault();
            //设置鼠标滚轮滚动时屏幕滚动条的移动步长
            var step = 50;
            if(event.deltaY < 0){
                //向上滚动鼠标滚轮，屏幕滚动条左移
                this.scrollLeft -= step;
            } else {
                //向下滚动鼠标滚轮，屏幕滚动条右移
                this.scrollLeft += step;
            }
        }
    }
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
            menuDh:'',
            topMenuId:""
        },
        mounted:function(){
            contentsH();
            mouseScroll();
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
            topMenuFun:function(item,index,e){
                var _this= this;
                debugger
                var this_li = e.target;
                if (this_li.tagName != "LI"){
                    var pp = $(this_li).parent();
                    this_li = pp[0];
                }

                this.menuDhFn(item);
                this.nowId=item.id;
                setTimeout(function(){
                    if(index != _this.topMenu.length-1){
                        $('.ivu-menu-item-selected').removeClass('ivu-menu-item-active');
                    }
                })
            },
            menuDhFn: function (item){
                debugger;
                var _this=this;
                if(item.parentid !== 'none'){
                    this.leftMenu.forEach(function(pList){
                        if(pList.id==item.parentid){
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
            },
            leftWards:function () {
                if (h < 0) h = 0;
                var scroll_left = $("#mouseScroll").scrollLeft();
                if(h<=0 && scroll_left == 0){
                    return;
                }else if (h ==0 && scroll_left != 0){
                    h = scroll_left;
                }
                h -= 250;
                $("#mouseScroll").animate({
                    scrollLeft: h
                },300)
            },
            rightWards:function () {
                debugger
                var scroll_left1 = $("#mouseScroll").scrollLeft();
                if (h < 0 || scroll_left1 != h) h = 0;
                h += 250;
                $("#mouseScroll").animate({
                    scrollLeft: h
                },300)
                setTimeout(function () {
                    var scroll_left = $("#mouseScroll").scrollLeft();
                        if(h > scroll_left){
                        h = scroll_left;
                    }
                },400)

            },
            closeMenuAll:function (name) {
                var _this = this;
                var topMenuList = _this.topMenu;
                if(name == '1'){

                }else{

                }
                alert(name);
            }
        }
    })

    $(".login-out").click(function () {

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

