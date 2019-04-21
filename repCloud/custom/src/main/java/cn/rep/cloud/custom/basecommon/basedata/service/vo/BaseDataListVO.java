package cn.rep.cloud.custom.basecommon.basedata.service.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 基础数据表
 * </p>
 *
 * @author chenyong
 * @since 2018-08-06
 */
public class BaseDataListVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID(主键)
     */
    private String id;
    /**
     * 企业编号
     */
    private String qybh;
    /**
     * 编号
     */
    private String bh;
    /**
     * 名称
     */
    private String mc;
    /**
     * 成本中心名称
     */
    private String lb;
    /**
     * 上级编号
     */
    private String lbmc;
    /**
     * 项目状态(0 无效，1 正常)
     */
    private String sfmrz;
    /**
     * 是否独立预算(0 否，1 是)
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
    private String zhxgrmc;


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


}
