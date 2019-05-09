package cn.rep.cloud.custom.basecommon.basedata.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 基础数据表
 * </p>
 *
 * @author chenyong
 * @since 2018-08-06
 */
@TableName("rep_jcsj")
public class RepJcsj implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID(主键)
     */
    @TableId("id")
    private String id;
    /**
     * 企业编号
     */
    private String qybh;

    /**
     *
     */
    private String gsid;
    /**
     * 编号
     */
    private String bh;
    /**
     * 名称
     */
    private String mc;
    /**
     *
     */
    private String lb;
    /**
     *
     */
    private String lbmc;
    /**
     *
     */
    private String sfmrz;
    /**
     * 顺序号
     */
    private String sxh;
    /**
     * 数据描述
     */
    private String sjms;
    /**
     * 最后修改人
     */
    private String zhxgr;
    /**
     * 最后修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date zhxgsj;
    /**
     * 最后修改IP
     */
    private String ip;

    /**
     * 最后修改人
     */
    private String  zhxgrmc;


    public String getZhxgrmc() {
        return zhxgrmc;
    }

    public void setZhxgrmc(String zhxgrmc) {
        this.zhxgrmc = zhxgrmc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQybh() {
        return qybh;
    }

    public void setQybh(String qybh) {
        this.qybh = qybh;
    }


    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public String getLb() {
        return lb;
    }

    public void setLb(String lb) {
        this.lb = lb;
    }

    public String getLbmc() {
        return lbmc;
    }

    public void setLbmc(String lbmc) {
        this.lbmc = lbmc;
    }

    public String getSfmrz() {
        return sfmrz;
    }

    public void setSfmrz(String sfmrz) {
        this.sfmrz = sfmrz;
    }

    public String getSxh() {
        return sxh;
    }

    public void setSxh(String sxh) {
        this.sxh = sxh;
    }

    public String getSjms() {
        return sjms;
    }

    public void setSjms(String sjms) {
        this.sjms = sjms;
    }

    public String getZhxgr() {
        return zhxgr;
    }

    public void setZhxgr(String zhxgr) {
        this.zhxgr = zhxgr;
    }

    public Date getZhxgsj() {
        return zhxgsj;
    }

    public void setZhxgsj(Date zhxgsj) {
        this.zhxgsj = zhxgsj;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }



    public String getGsid() {
        return gsid;
    }

    public void setGsid(String gsid) {
        this.gsid = gsid;
    }
}
