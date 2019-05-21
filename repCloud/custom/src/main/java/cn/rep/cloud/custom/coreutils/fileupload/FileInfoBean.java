package cn.rep.cloud.custom.coreutils.fileupload;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * @author: Mike_cao@enable-ets.com
 * @Date: 2019/4/12 12:56
 * @Description: 文件信息
 */
public class FileInfoBean {

    private String fileId;

    private String name;

    private String md5;

    private String size;


    private String sizeDisplay;


    private String encoding;


    private String path;

    private List<String> aliasName;

    private String uuid;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String description;

    private String downloadUrl;


    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSizeDisplay() {
        return sizeDisplay;
    }

    public void setSizeDisplay(String sizeDisplay) {
        this.sizeDisplay = sizeDisplay;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<String> getAliasName() {
        return aliasName;
    }

    public void setAliasName(List<String> aliasName) {
        this.aliasName = aliasName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }
}