package cn.rep.cloud.custom.coreutils.fileupload;

/**
 * @author: Mike_cao@enable-ets.com
 * @Date: 2019/4/12 11:41
 * @Description:
 */
public class FileUploadResponse {

    private FileInfoBean data;

    private String status;

    private String statusCode;

    private String message;

    public FileInfoBean getData() {
        return data;
    }

    public void setData(FileInfoBean data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}