package cn.rep.cloud.custom.openapi.feignclient.fileupload.vo;

public class UploadFileVO {
    /**
     * 返回状态
     */
    private String errorDode;
    /**
     * 文件名
     */
    private String fileName;
    /**
     * 扩展名
     */
    private String extName;
    /**
     * 文件大小，字节
     */
    private Long fileSize;
    /**
     * 文件存储在服务器的相对地址
     */
    private String serverPath;

    public String getErrorDode() {
        return errorDode;
    }

    public void setErrorDode(String errorDode) {
        this.errorDode = errorDode;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getExtName() {
        return extName;
    }

    public void setExtName(String extName) {
        this.extName = extName;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getServerPath() {
        return serverPath;
    }

    public void setServerPath(String serverPath) {
        this.serverPath = serverPath;
    }
}
