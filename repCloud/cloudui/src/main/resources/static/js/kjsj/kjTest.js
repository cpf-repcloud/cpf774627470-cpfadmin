window.onload= function (){
    var   data= [ {
        value: 'beijing',
        label: '北京',
        name:'123',
        data:'456',
        age:'33',
        children: [
            {
                value: 'gugong',
                label: '故宫'
            },
            {
                value: 'tiantan',
                label: '天坛'
            },
            {
                value: 'wangfujing',
                label: '王府井'
            }
        ]
    }, {
        value: 'jiangsu',
        label: '江苏',
        children: [
            {
                value: 'nanjing',
                label: '南京',
                children: [
                    {
                        value: 'fuzimiao',
                        label: '夫子庙',
                    }
                ]
            },
            {
                value: 'suzhou',
                label: '苏州',
                children: [
                    {
                        value: 'zhuozhengyuan',
                        label: '拙政园',
                    },
                    {
                        value: 'shizilin',
                        label: '狮子林',
                    }
                ]
            }
        ],
    }]

    var app= new Vue({
        el: '#app',
        data:{
            data:data
        },
        mounted:function(){

        },
        methods:{
            format:function (labels, selectedData) {
              var selectdata=   selectedData[0]; //选中的一条数据、
                console.log(selectdata);

                debugger
                const index = labels.length - 1;
                return labels[index]; //返回的数据
    }
        }
    })

}

