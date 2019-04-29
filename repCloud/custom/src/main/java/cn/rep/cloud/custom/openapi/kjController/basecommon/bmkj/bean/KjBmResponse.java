package cn.rep.cloud.custom.openapi.kjController.basecommon.bmkj.bean;

import cn.rep.cloud.custom.openapi.kjController.baseBean.KjBaseResponse;

public class KjBmResponse extends KjBaseResponse {
    /**
     * 企业编号
     */
    private String qybh;
    /**
     * 部门名称(全称)
     */
    private String mc;
    /**
     * 上级id(none表示无上级部门)
     */
    private String sjid;
    /**
     * 所在省份
     */
    private String szsf;

    /**
     * 所在城市
     */
    private String szcs;

    /**
     * 所在地址
     */
    private String szdz;
    /**
     * 部门负责人(员工任职ID)
     */
    private String bmfzr;

    /**
     * 部门电话
     */
    private String bmdh;

    /**
     * 所属公司ID(直属公司，不管所属公司的上级公司是哪个)
     */
    private String ssgsid;

    /**
     * 财务主管(员工任职ID)
     */
    private String cwzg;

    public String getQybh() {
        return qybh;
    }

    public void setQybh(String qybh) {
        this.qybh = qybh;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public String getSjid() {
        return sjid;
    }

    public void setSjid(String sjid) {
        this.sjid = sjid;
    }

    public String getSzsf() {
        return szsf;
    }

    public void setSzsf(String szsf) {
        this.szsf = szsf;
    }

    public String getSzcs() {
        return szcs;
    }

    public void setSzcs(String szcs) {
        this.szcs = szcs;
    }

    public String getSzdz() {
        return szdz;
    }

    public void setSzdz(String szdz) {
        this.szdz = szdz;
    }

    public String getBmfzr() {
        return bmfzr;
    }

    public void setBmfzr(String bmfzr) {
        this.bmfzr = bmfzr;
    }

    public String getBmdh() {
        return bmdh;
    }

    public void setBmdh(String bmdh) {
        this.bmdh = bmdh;
    }

    public String getSsgsid() {
        return ssgsid;
    }

    public void setSsgsid(String ssgsid) {
        this.ssgsid = ssgsid;
    }

    public String getCwzg() {
        return cwzg;
    }

    public void setCwzg(String cwzg) {
        this.cwzg = cwzg;
    }
}
