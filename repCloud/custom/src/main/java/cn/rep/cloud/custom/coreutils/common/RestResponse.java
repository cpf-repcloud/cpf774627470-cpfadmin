package cn.rep.cloud.custom.coreutils.common;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.UUID;

public class RestResponse<T> implements Serializable {

    /**
     * id
     */
    private static final long serialVersionUID = 1L;

    /**
     * 响应ID
     */
    private String id = UUID.randomUUID().toString();

    /**
     * 状态码(业务定义)
     */
    private String status = ResultCode.OK.getCode();

    /**
     * 状态码描述(业务定义)
     * 错误代码[400],错误内容:%s,失败
     */
    private String message = ResultCode.OK.getMessage();

    /**
     * 页面展示给客户的信息
     */
    private String tips = ResultCode.OK.getMessage();
    /**
     * 结果集(泛型)
     */
    private T result = null; //NOSONAR


    /**
     * 构造函数
     */
    public RestResponse() {
        super();
    }

    /**
     * 请求是否成功
     *
     * @return 成功返回true
     */
    public boolean isSuccess() {
        return ResultCode.OK.getCode().equalsIgnoreCase(status);
    }

    /**
     * 构造函数
     *
     * @param result 结果集(泛型)
     */
    public RestResponse(T result) {
        super();
        this.result = result;
    }

    /**
     * 构造函数
     *
     * @param httpStatus http状态
     * @param error      错误
     */
    public RestResponse(Code httpStatus, String error) {
        super();
        this.status = httpStatus.getCode();
        if (StringUtils.trimToEmpty(httpStatus.getMessage()).indexOf("%s") >= 0) {
            this.message = String.format(httpStatus.getMessage(), error);
        } else {
            this.message = httpStatus.getMessage() + error;
        }
    }

    /**
     * 构造函数
     *
     * @param status  状态码(业务定义)
     * @param message 状态码描述(业务定义)
     * @param result  结果集(泛型)
     */
    public RestResponse(String status, String message, T result) {
        super();
        this.status = status;
        this.message = message;
        this.tips = message;
        this.result = result;
    }

    /**
     * 带展示给前台提示信息的response
     * @param status  状态码(业务定义)
     * @param message 状态码描述(业务定义)
     * @param tips    给前台的错误提示信息
     * @param result  结果集(泛型)
     */
    public RestResponse(String status, String message,String tips, T result) {
        super();
        this.status = status;
        this.message = message;
        this.tips = tips;
        this.result = result;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setResult(T result) {
        this.result = result;
    }

}
