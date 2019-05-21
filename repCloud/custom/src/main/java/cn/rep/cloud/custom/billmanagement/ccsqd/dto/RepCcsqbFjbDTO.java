package cn.rep.cloud.custom.billmanagement.ccsqd.dto;

import com.baomidou.mybatisplus.annotations.TableName;

import javax.persistence.Entity;
import java.util.Date;

public class RepCcsqbFjbDTO {

    private String id;
    private String sqdh;
    /**上传地址*/
    private String scdz;
    private String czr;
    /**备注*/
    private String bzbz;
    private String by1;
    private String by2;
    private String by3;
    /**附件名称*/
    private String fjmc;
    /**上传时间*/
    private String scsj;
    /**附加id*/
    private String fjid;

    /**
     * 创建时间
     */
    private Date cjsj;

    /**
     * 修改时间
     */
    private Date xgsj;

    /*附件下载地址*/
    private String fjxzdz;


    public String getFjxzdz() {
        return fjxzdz;
    }

    public void setFjxzdz(String fjxzdz) {
        this.fjxzdz = fjxzdz;
    }

    public Date getCjsj() {
        return cjsj;
    }

    public void setCjsj(Date cjsj) {
        this.cjsj = cjsj;
    }

    public Date getXgsj() {
        return xgsj;
    }

    public void setXgsj(Date xgsj) {
        this.xgsj = xgsj;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSqdh() {
        return sqdh;
    }

    public void setSqdh(String sqdh) {
        this.sqdh = sqdh;
    }

    public String getScdz() {
        return scdz;
    }

    public void setScdz(String scdz) {
        this.scdz = scdz;
    }

    public String getCzr() {
        return czr;
    }

    public void setCzr(String czr) {
        this.czr = czr;
    }

    public String getBzbz() {
        return bzbz;
    }

    public void setBzbz(String bzbz) {
        this.bzbz = bzbz;
    }

    public String getBy1() {
        return by1;
    }

    public void setBy1(String by1) {
        this.by1 = by1;
    }

    public String getBy2() {
        return by2;
    }

    public void setBy2(String by2) {
        this.by2 = by2;
    }

    public String getBy3() {
        return by3;
    }

    public void setBy3(String by3) {
        this.by3 = by3;
    }

    public String getFjmc() {
        return fjmc;
    }

    public void setFjmc(String fjmc) {
        this.fjmc = fjmc;
    }

    public String getScsj() {
        return scsj;
    }

    public void setScsj(String scsj) {
        this.scsj = scsj;
    }

    public String getFjid() {
        return fjid;
    }

    public void setFjid(String fjid) {
        this.fjid = fjid;
    }
}
