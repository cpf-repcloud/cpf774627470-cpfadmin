package cn.rep.cloud.custom.coreutils.systemexception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by vetech on 2017/9/11.
 *
 * @author houya
 */
public class CodeUtil {
    /**
     * 注释
     */
    private static final Logger logger = LoggerFactory.getLogger(CodeUtil.class);

    /**
     * 解析错误代码
     *
     * @param code 错误代码
     * @return 返回错误解析内容
     */
    public static String getMessage(Code code) {
        return getMessage(code, "");
    }

    /**
     * 解析错误代码
     *
     * @param code 错误代码
     * @param args 错误参数
     * @return 返回错误解析内容
     */
    public static String getMessage(Code code, String args) {
        return getMessage(code, new String[]{args});
    }

    /**
     * 解析错误代码
     *
     * @param code 错误代码
     * @param args 错误参数
     * @return 返回错误解析内容
     */
    public static String getMessage(Code code, Object[] args) {
        String info = code.getMessage();
        if (args != null && args.length > 0) {
            try {
                info = String.format(code.getMessage(), args);
            } catch (Exception e) {
                logger.error("格式化字符串{}，参数报错{}", code.getMessage(), args, e);
            }
        }
        return "[" + code.getCode() + "]" + info;
    }

    /**
     * 解析错误代码
     *
     * @param code  错误代码
     * @param args  错误参数
     * @param cause 异常
     * @return 返回错误解析内容
     */
    public static String getMessage(Code code, Object[] args, Throwable cause) {
        String info = getMessage(code, args);
        if (cause != null) {
            info = info + "，" + cause.getMessage();
        }
        return info;
    }
}
