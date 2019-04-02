package cn.rep.cloud.custom.coreutils.common;

/**
 * 错误代码，其他错误代码枚举需要实现它
 *
 * @author houya
 */
public interface Code extends ICode{


    /**
     * 错误信息
     *
     * @return 错误信息
     */
    String getMessage();
}
