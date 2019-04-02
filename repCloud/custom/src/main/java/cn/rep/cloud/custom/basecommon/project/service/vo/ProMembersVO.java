package cn.rep.cloud.custom.basecommon.project.service.vo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by vetech on 2018/8/13.
 */
public class ProMembersVO {

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
     * 项目ID
     */
    private String xmid;
    /**
     * 项目成员(员工ID)
     */
    private String xmcy;

    /**
     * 状态(0 离开项目，1 在项目中)
     */
    private String zt;
    /**
     * 进入项目时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date jrsj;
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
     * 成员姓名
     */
    private String xm;

    /**
     * 项目角色
     */
    private String cyjs;

    /**
     * 工号
     * @return
     */
    private String gh;

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

    public String getXmid() {
        return xmid;
    }

    public void setXmid(String xmid) {
        this.xmid = xmid;
    }

    public String getXmcy() {
        return xmcy;
    }

    public void setXmcy(String xmcy) {
        this.xmcy = xmcy;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public Date getJrsj() {
        return jrsj;
    }

    public void setJrsj(Date jrsj) {
        this.jrsj = jrsj;
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

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getCyjs() {
        return cyjs;
    }

    public void setCyjs(String cyjs) {
        this.cyjs = cyjs;
    }

    public String getGh() {
        return gh;
    }

    public void setGh(String gh) {
        this.gh = gh;
    }
}


