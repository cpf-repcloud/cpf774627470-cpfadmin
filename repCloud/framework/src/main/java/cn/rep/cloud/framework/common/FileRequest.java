package cn.rep.cloud.framework.common;

public class FileRequest {

    /**
     * 上传的父目录
     */
    private String childFile;
    /**
     * 允许上传的文件后缀名
     */
    private String extension;

    public String getChildFile() {
        return childFile;
    }

    public void setChildFile(String childFile) {
        this.childFile = childFile;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
