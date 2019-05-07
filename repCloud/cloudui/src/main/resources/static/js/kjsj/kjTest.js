window.onload= function (){
        var xlList = [];
            // {"id":"1","name":"测试1","value":"123"},
            // {"id":"2","name":"测试2","value":"123"}
    var app;
    var request = {};
    var request = {
        gsid:"",
        bmid:""
    }
    $.ajax({
        type: "POST",
        url: "/custom/kj/employee/getEmployeeList",
        data: JSON.stringify(request),
        dataType: "json",
        async:true,
        contentType: "application/json;charset=UTF-8",
        success: function (response) {

            if (response.status && response.status === "200") {
                console.log(JSON.stringify(response.result));
                xlList = response.result;
                initVue();
            }
        }
    })


    function initVue() {
        app= new Vue({
            el: '#app',
            data:{
                xlValue:"",
                xlList:xlList
            },
            mounted:function(){
            },
            methods:{
                dataChange:function(data){
                    console.log(data);
                },
                changeHandler:function(val,data){
                    /*val隐藏域的值*/
                    /*data返回已选择数据的集合*/
                    console.log(JSON.stringify(data));
                },
                ckyf:function (data) {
                    var kjms = $(".kjms");
                    $.each(kjms,function (i,item) {
                        if (data == i){
                            var kjmsid = 'kjms'+i;
                            $("#"+kjmsid).show();
                        }
                    })
                },
                sqyf:function (data) {
                    var kjms = $(".kjms");
                    $.each(kjms,function (i,item) {
                        if (data == i){
                            var kjmsid = 'kjms'+i;
                            $("#"+kjmsid).hide();
                        }
                    })
                }
            }
        })
    }

}

