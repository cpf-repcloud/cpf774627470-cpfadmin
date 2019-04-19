document.write('<script type="text/javascript" src="../../static/public/js/vue.min.js"></script>')
document.write('<script type="text/javascript" src="../../static/public/js/iview.min.js"></script>')
document.write('<script type="text/javascript" src="../../static/public/js/jquery.min.js"></script>')
document.write('<script type="text/javascript" src="../../static/public/js/vue.extend.js"></script>')
document.write('<script type="text/javascript" src="../../static/public/js/vetech-business.min.js"></script>')
document.write('<script type="text/javascript" src="../../static/public/js/vetech-common.min.js"></script>')


/*************************** 自定义公共工具 ***********************************/

/**
 * 日期格式化工具
 *
 * @param date 传入的日期
 * @param fmt 时间格式 yyyy-MM-dd hh:mm:ss
 * @returns {*}
 */
function formatDate (date, fmt) {
    var o = {
        'M+': date.getMonth() + 1, // 月份
        'd+': date.getDate(), // 日
        'h+': date.getHours(), // 小时
        'm+': date.getMinutes(), // 分
        's+': date.getSeconds(), // 秒
        'S': date.getMilliseconds() // 毫秒
    }
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (date.getFullYear() + '').substr(4 - RegExp.$1.length))
    }
    for (var k in o) {
        if (new RegExp('(' + k + ')').test(fmt)) {
            debugger
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? (o[k]) : (('00' + o[k]).substr(('' + o[k]).length)))
        }
    }
    return fmt
}