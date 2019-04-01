/**
 * Created by sing on 2018/7/13.
 */
//分页表格数据查询的混入
Vue.mixin({
    data:function(){
        return  {
            ipage:{
                total:0,
                current:1,
                size:20,
                isAsc:true,
                orderByField:""
            }
        };
    },
    methods:{
        queryPage:function(){
            var params = {},_this = this;
            $.extend(true,params,{data:this.iquery},this.ipage);
            this.igrid.loading = true;
            $.ajax({
                type:"POST",
                url:this.igrid.url,
                data:JSON.stringify(params),
                dataType:"json",
                contentType:"application/json;charset=UTF-8",
                success:function(response){
                    _this.igrid.loading = false;
                    if(response.status  && response.status === "200"){
                        _this.pagedata = response.result.records;
                        _this.ipage.total = response.result.total;
                        _this.ipage.size = response.result.size;
                        _this.ipage.current = response.result.current;
                    }else{
                        new Error("please config 'gridSuccsess' methods in your vue instance!");
                    }
                },
                error:function(){
                    _this.igrid.loading = false;
                }
            });
        },
        queryList:function(){   //为了传递无分页的情况
            var params = {},_this = this;
            $.extend(true,params,this.iquery);
            this.igrid.loading = true;
            $.ajax({
                type:"POST",
                url:this.igrid.url,
                data:JSON.stringify(params),
                dataType:"json",
                contentType:"application/json;charset=UTF-8",
                success:function(response){
                    _this.igrid.loading = false;
                    if(_this.gridSuccsess && Object.prototype.toString.call(_this.gridSuccsess) === "[object Function]"){
                        _this.gridSuccsess(response);
                    }else{
                        new Error("please config 'gridSuccsess' methods in your vue instance!");
                    }
                },
                error:function(){
                    _this.igrid.loading = false;
                }
            });
        },
        changePage:function(pageIndex){
            this.ipage.current = pageIndex;
            this.queryPage();
        },
        changePageSize:function(pageSize){
            this.ipage.size = pageSize;
            this.changePage(1);
        }
    }
});
