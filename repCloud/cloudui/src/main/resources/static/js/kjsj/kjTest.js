window.onload= function (){
        var xlList = [
            {id:"1",name:"测试1",value:"123"},
            {id:"2",name:"测试2",value:"123"},
            {id:"3",name:"测试3",value:"123"},
            {id:"4",name:"测试4",value:"123"},
            {id:"5",name:"测试5",value:"123"},
            {id:"6",name:"测试6",value:"123"},
            {id:"7",name:"测试7",value:"123"},
            {id:"8",name:"测试8",value:"123"},
            {id:"9",name:"测试9",value:"123"},
            {id:"10",name:"测试10",value:"123"},
            {id:"11",name:"测试11",value:"123"},
            {id:"12",name:"测试12",value:"123"},
            {id:"13",name:"测试13",value:"123"},
            {id:"14",name:"测试14",value:"123"},
            {id:"15",name:"测试15",value:"123"}
        ];
        var titleMenu = [
            {
                name:'热门城市',
                px:[''],
                chek:true,
            },
            {
                name:'ABCD',
                px:['A','B','C','D'],
                chek:false,
            },
            {
                name:'EFGHI',
                px:['E','F','G','H','I'],
                chek:false,
            },
            {
                name:'JKLM',
                px:['J','K','L','M'],
                chek:false,
            },
            {
                name:'NPQRS',
                px:['N','P','Q','R','S'],
                chek:false,
            },
            {
                name:'TUVW',
                px:['T','U','V','W'],
                chek:false,
            },
            {
                name:'XYZ',
                px:['X','Y','Z'],
                chek:false,
            }
        ];
       var csxz = [];
       /*
        {"id":"6844648646","children":[{"name":"武汉","id":"WUH" },{"name":"北京首都","id":"PEK"},{"name":"上海","id":"SHA"}, {"name":"长沙","id":"10190"},{"name":"深圳","id":"10511"},{"name":"广州","id":"10507"}, {"name":"西安","id":"XAY"},{"name":"厦门","id":"XMS"}],"firstZ":""},
        {"id":"6844648646","children":[{"name":"武汉","id":"WUH" },{"name":"北京首都","id":"PEK"},{"name":"上海","id":"SHA"}, {"name":"长沙","id":"10190"},{"name":"深圳","id":"10511"},{"name":"广州","id":"10507"}, {"name":"西安","id":"XAY"},{"name":"厦门","id":"XMS"}],"firstZ":"A"},
        {"id":"426874378","children":[{"name":"三亚市","id":"437035111"},{"name":"三亚市","id":"387666453"},{"name":"上海市","id":"688251651"},{"name":"嘉兴市","id":"6893828131"},{"name":"九龙","id":"397364229"},{"name":"宜春市","id":"297212856"},{"name":"喀什地区","id":"55780682"},{"name":"阿里地区","id":"55851807"}],"firstZ":"B"},
        {"id":"925875224","children":[{"name":"忻州市","id":"874117544"},{"name":"武汉市","id":"2161291059"},{"name":"邢台市","id":"111131397"},{"name":"南投县","id":"72727342"},{"name":"海东市","id":"58281591"},{"name":"天津市","id":"095254834"},{"name":"香港岛","id":"6555128748"},{"name":"四平市","id":"4902702125"}],"firstZ":"C"},
        {"id":"638556543","children":[{"name":"周口市","id":"288277613"},{"name":"朝阳市","id":"03052419"},{"name":"通化市","id":"146539667"},{"name":"盘锦市","id":"356553686"},{"name":"葫芦岛市","id":"09226541"},{"name":"北海市","id":"36342627"},{"name":"哈密地区","id":"87563569"},{"name":"沧州市","id":"726612507"}],"firstZ":"D"},
        {"id":"820413255","children":[{"name":"九龙","id":"7383124851"},{"name":"喀什地区","id":"247330677"},{"name":"吴忠市","id":"9565820822"},{"name":"湖州市","id":"99828255"},{"name":"澳门半岛","id":"887883620"},{"name":"林芝地区","id":"870837162"},{"name":"岳阳市","id":"181980057"},{"name":"黄南藏族自治州","id":"85092561"}],"firstZ":"E"},
        {"id":"6424514699","children":[{"name":"内江市","id":"927471274"},{"name":"鸡西市","id":"334624864"},{"name":"香港岛","id":"19882842"},{"name":"吉安市","id":"978551178"},{"name":"上海市","id":"29765457"},{"name":"安顺市","id":"49484631"},{"name":"嘉义县","id":"105855406"},{"name":"长沙市","id":"4734831424"}],"firstZ":"F"},
        {"id":"61393127","children":[{"name":"汉中市","id":"11544727"},{"name":"晋城市","id":"051824530"},{"name":"淮安市","id":"4113361207"},{"name":"临夏回族自治州","id":"98532689"},{"name":"丽江市","id":"888933528"},{"name":"乌海市","id":"331643639"},{"name":"日照市","id":"287280415"},{"name":"张掖市","id":"324156377"}],"firstZ":"G"},
        {"id":"51081930","children":[{"name":"上海市","id":"256751824"},{"name":"贵港市","id":"184121125"},{"name":"屏东县","id":"26118874"},{"name":"固原市","id":"662282414"},{"name":"百色市","id":"064240734"},{"name":"赤峰市","id":"2142412184"},{"name":"厦门市","id":"31145211"},{"name":"邵阳市","id":"1520360653"}],"firstZ":"H"},
        {"id":"68701475","children":[{"name":"哈密地区","id":"0781889555"},{"name":"金昌市","id":"172319457"},{"name":"珠海市","id":"3926714772"},{"name":"天津市","id":"04112814"},{"name":"唐山市","id":"336023057"},{"name":"烟台市","id":"584475239"},{"name":"澳门半岛","id":"167345785"},{"name":"博尔塔拉蒙古自治州","id":"371169383"}],"firstZ":"I"},
        {"id":"12586645","children":[{"name":"无锡市","id":"198317722"},{"name":"海北藏族自治州","id":"12161588"},{"name":"鸡西市","id":"23856164"},{"name":"新竹市","id":"258329311"},{"name":"三亚市","id":"67656854"},{"name":"淮安市","id":"476380233"},{"name":"吴忠市","id":"283314871"},{"name":"天津市","id":"08922628"}],"firstZ":"J"},
        {"id":"731888083","children":[{"name":"黑河市","id":"394153662"},{"name":"阿里地区","id":"6438572613"},{"name":"海东市","id":"37712376"},{"name":"三亚市","id":"871538375"},{"name":"玉林市","id":"6276064154"},{"name":"池州市","id":"834411874"},{"name":"离岛","id":"1992845128"},{"name":"白城市","id":"145555886"}],"firstZ":"K"},
        {"id":"2247811114","children":[{"name":"新余市","id":"88277331"},{"name":"阿克苏地区","id":"5751425601"},{"name":"河池市","id":"03623672"},{"name":"澳门半岛","id":"79647827"},{"name":"泰州市","id":"750438546"},{"name":"忻州市","id":"973412167"},{"name":"茂名市","id":"768920315"},{"name":"乌海市","id":"466592813"}],"firstZ":"L"},
        {"id":"51116121","children":[{"name":"白银市","id":"08019265"},{"name":"果洛藏族自治州","id":"51601588"},{"name":"三沙市","id":"92127583"},{"name":"晋城市","id":"813723747"},{"name":"伊春市","id":"592355729"},{"name":"张家口市","id":"118450144"},{"name":"九龙","id":"74173022"},{"name":"海外","id":"573356822"}],"firstZ":"M"},
        {"id":"138265661","children":[{"name":"驻马店市","id":"931838685"},{"name":"佛山市","id":"34073294"},{"name":"天津市","id":"901807691"},{"name":"濮阳市","id":"24648471"},{"name":"新乡市","id":"067672136"},{"name":"澳门半岛","id":"822511657"},{"name":"锡林郭勒盟","id":"188615330"},{"name":"固原市","id":"381800571"}],"firstZ":"N"},
        {"id":"60673322","children":[{"name":"海北藏族自治州","id":"59224214"},{"name":"西安市","id":"88446641"},{"name":"青岛市","id":"489451501"},{"name":"孝感市","id":"63072987"},{"name":"新界","id":"54295331"},{"name":"云林县","id":"582557395"},{"name":"重庆市","id":"13944186"},{"name":"漳州市","id":"698655312"}],"firstZ":"O"},
        {"id":"7325724542","children":[{"name":"吐鲁番地区","id":"121487375"},{"name":"怀化市","id":"486278769"},{"name":"武汉市","id":"607862017"},{"name":"烟台市","id":"1723619106"},{"name":"肇庆市","id":"1824893521"},{"name":"松原市","id":"187515626"},{"name":"天津市","id":"8611866923"},{"name":"阜阳市","id":"1521270612"}],"firstZ":"P"},
        {"id":"2323124185","children":[{"name":"离岛","id":"079280901"},{"name":"抚州市","id":"18277016"},{"name":"白山市","id":"26893119"},{"name":"吐鲁番地区","id":"943318717"},{"name":"驻马店市","id":"327526580"},{"name":"天津市","id":"72367776"},{"name":"锡林郭勒盟","id":"16267015"},{"name":"三亚市","id":"338475525"}],"firstZ":"Q"},{"id":"8359277832","children":[{"name":"伊犁哈萨克自治州","id":"0412765461"},{"name":"林芝地区","id":"5462245975"},{"name":"重庆市","id":"095875377"},{"name":"贵港市","id":"1823373978"},{"name":"白山市","id":"24951964"},{"name":"天津市","id":"764763788"},{"name":"深圳市","id":"6640052527"},{"name":"黔南布依族苗族自治州","id":"481311562"}],"firstZ":"R"},{"id":"688955132","children":[{"name":"天津市","id":"862571173"},{"name":"山南地区","id":"71751785"},{"name":"邢台市","id":"445861727"},{"name":"阜新市","id":"192582484"},{"name":"淄博市","id":"458846378"},{"name":"十堰市","id":"575647895"},{"name":"吴忠市","id":"56447998"},{"name":"泰州市","id":"787337621"}],"firstZ":"S"},{"id":"845405765","children":[{"name":"铜仁市","id":"212522129"},{"name":"晋城市","id":"6732775532"},{"name":"伊春市","id":"3293723576"},{"name":"昌都地区","id":"54357462"},{"name":"铜川市","id":"217501475"},{"name":"鹤壁市","id":"1878543144"},{"name":"遂宁市","id":"083622541"},{"name":"襄阳市","id":"6433231685"}],"firstZ":"T"},{"id":"35318154","children":[{"name":"绥化市","id":"851921056"},{"name":"海东市","id":"815534658"},{"name":"襄阳市","id":"7839037851"},{"name":"新界","id":"42742323"},{"name":"莆田市","id":"387060945"},{"name":"徐州市","id":"862621084"},{"name":"苏州市","id":"7087766156"},{"name":"昌都地区","id":"469526022"}],"firstZ":"U"},{"id":"60214844","children":[{"name":"金华市","id":"4021028716"},{"name":"铜川市","id":"61335881"},{"name":"泉州市","id":"397627213"},{"name":"珠海市","id":"661173738"},{"name":"玉树藏族自治州","id":"82072492"},{"name":"北京市","id":"5244491017"},{"name":"湖州市","id":"074463428"},{"name":"巴彦淖尔市","id":"042810433"}],"firstZ":"V"},{"id":"478744349","children":[{"name":"黔东南苗族侗族自治州","id":"627773547"},{"name":"本溪市","id":"731194104"},{"name":"云林县","id":"484686802"},{"name":"漯河市","id":"08267164"},{"name":"大庆市","id":"861286438"},{"name":"淮安市","id":"15429741"},{"name":"北海市","id":"467373272"},{"name":"白银市","id":"28412512"}],"firstZ":"W"},{"id":"4644618764","children":[{"name":"淮北市","id":"6462688741"},{"name":"天津市","id":"738644121"},{"name":"澳门半岛","id":"888167941"},{"name":"天津市","id":"475376691"},{"name":"唐山市","id":"0236732631"},{"name":"香港岛","id":"4414460584"},{"name":"西双版纳傣族自治州","id":"77766925"},{"name":"新乡市","id":"5445432850"}],"firstZ":"X"},{"id":"66404252","children":[{"name":"唐山市","id":"17182992"},{"name":"喀什地区","id":"367687619"},{"name":"临沧市","id":"149622243"},{"name":"张家界市","id":"636326356"},{"name":"三沙市","id":"62274863"},{"name":"上海市","id":"009436576"},{"name":"昆明市","id":"0412276467"},{"name":"佳木斯市","id":"717144037"}],"firstZ":"Y"}
    */
    var app;
    var request = {};
    $.ajax({
        type: "POST",
        url: "/custom/kj/city/getCityList",
        data: JSON.stringify(request),
        dataType: "json",
        contentType: "application/json;charset=UTF-8",
        success: function (response) {
            debugger
            if (response.status && response.status === "200") {
                console.log(JSON.stringify(response.result))
                csxz = response.result;
                initVue();
            }
        }
    })


    function initVue() {
        app= new Vue({
            el: '#app',
            data:{
                xlValue:"",
                xlList:xlList,
                titleMenu:titleMenu,
                csxz:csxz
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

