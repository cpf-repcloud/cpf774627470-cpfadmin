package cn.rep.cloud.custom.organizationa.vo;

import java.util.List;

public class RepDeptVO {

    /**
     * 部门id
     */
    private String id;
    /**
     * 部门编号
     */
    private String bh;
    /**
     * 上级部门id
     */
    private String sjid;
    /**
     * 上级部门名称
     */
    private String sjbmmc;
    /**
     * 部门负责人
     */
    private String bmfzr;
    /**
     * 部门负责人名称
     */
    private String bmfzrmc;
    /**
     * 部门电话
     */
    private String bmdh;
    /**
     * 简称
     */
    private String jc;
    /**
     * 部门名称
     */
    private String mc;
    /**
     * 所属公司名称
     */
    private String ssgsmc;
    /**
     * 所在地址
     */
    private String xxszdz;
    /**
     * 所在地址
     */
    private String szdz;
    /**
     * 所在城市
     */
    private String szcs;
    /**
     * 财务主管
     */
    private String cwzg;
    /**
     * 财务主管名称
     */
    private String cwzgmc;
    /**
     * 页面面包屑
     */
    private List<String> mbxList;
    /**
     * 详细所在地址id
     */
    private String xxszdzid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
    }

    public String getSjbmmc() {
        return sjbmmc;
    }

    public void setSjbmmc(String sjbmmc) {
        this.sjbmmc = sjbmmc;
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

    public String getJc() {
        return jc;
    }

    public void setJc(String jc) {
        this.jc = jc;
    }

    public String getSsgsmc() {
        return ssgsmc;
    }

    public void setSsgsmc(String ssgsmc) {
        this.ssgsmc = ssgsmc;
    }

    public String getSzdz() {
        return szdz;
    }

    public void setSzdz(String szdz) {
        this.szdz = szdz;
    }

    public String getCwzg() {
        return cwzg;
    }

    public void setCwzg(String cwzg) {
        this.cwzg = cwzg;
    }

    public List<String> getMbxList() {
        return mbxList;
    }

    public void setMbxList(List<String> mbxList) {
        this.mbxList = mbxList;
    }

    public String getSjid() {
        return sjid;
    }

    public void setSjid(String sjid) {
        this.sjid = sjid;
    }

    public String getBmfzrmc() {
        return bmfzrmc;
    }

    public void setBmfzrmc(String bmfzrmc) {
        this.bmfzrmc = bmfzrmc;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public String getXxszdz() {
        return xxszdz;
    }

    public void setXxszdz(String xxszdz) {
        this.xxszdz = xxszdz;
    }

    public String getSzcs() {
        return szcs;
    }

    public void setSzcs(String szcs) {
        this.szcs = szcs;
    }

    public String getCwzgmc() {
        return cwzgmc;
    }

    public void setCwzgmc(String cwzgmc) {
        this.cwzgmc = cwzgmc;
    }

    public String getXxszdzid() {
        return xxszdzid;
    }

    public void setXxszdzid(String xxszdzid) {
        this.xxszdzid = xxszdzid;
    }
}
