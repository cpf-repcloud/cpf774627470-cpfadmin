package cn.rep.cloud.custom.coreutils.systemexception;


public class SystemException  extends RuntimeException{


    /**
     * 描述 : id
     */
    private static final long serialVersionUID = 1L;

    /**
     * 文本替换的参数
     */
    private Object[] args;
    /**
     * 错误代码
     */
    private Code code;

    /**
     * 构造
     *
     * @param code 错误代码
     */
    public SystemException(Code code) {
        super(CodeUtil.getMessage(code));
        this.code = code;
    }

    /**
     * 构造
     *
     * @param code 错误代码
     * @param args 文本替换的参数
     */
    public SystemException(Code code, String args) {
        super(CodeUtil.getMessage(code, args));
        this.code = code;
        this.args = new String[]{args};
    }

    /**
     * 构造
     *
     * @param code  错误代码
     * @param args  文本替换的参数
     * @param cause 其他异常信息
     */
    public SystemException(Code code, String args, Throwable cause) {
        super(CodeUtil.getMessage(code, args), cause);
        this.code = code;
        this.args = new String[]{args};
    }

    /**
     * 构造
     *
     * @param code 错误代码
     * @param args 文本替换的参数
     */
    public SystemException(Code code, String[] args) {
        super(CodeUtil.getMessage(code, args));
        this.code = code;
        this.args = args;
    }


    /**
     * 构造
     *
     * @param code  错误代码
     * @param args  文本替换的参数
     * @param cause 其他异常信息
     */
    public SystemException(Code code, String[] args, Throwable cause) {
        super(CodeUtil.getMessage(code, args), cause);
        this.code = code;
        this.args = args;
    }

    /**
     * 构造
     *
     * @param code  错误代码
     * @param cause 其他异常信息
     */
    public SystemException(Code code, Throwable cause) {
        super(CodeUtil.getMessage(code), cause);
        this.code = code;
    }

    @Override
    public String getMessage() {
        return CodeUtil.getMessage(this.code, this.args, getCause());
    }

    public Code getCode() {
        return code;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    /**
     * 返回错误代码中的编码
     *
     * @return 返回错误代码中的编码
     */
    public String getCodeValue() {
        if (code != null) {
            return code.getCode();
        }
        return "SYS000";
    }
}
