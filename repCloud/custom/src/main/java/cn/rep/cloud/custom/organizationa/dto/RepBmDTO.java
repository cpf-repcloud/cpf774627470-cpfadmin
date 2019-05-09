package cn.rep.cloud.custom.organizationa.dto;

import java.util.Date;

public class RepBmDTO {

    /**
     * 部门id
     */
    private String id;
    /**
     * 上级id
     */
    private String sjid;
    /**
     * 企业编号
     */
    private String qybh;
    /**
     * 所属公司id
     */
    private String ssgsid;
    /**
     * 所属公司bh
     */
    private String ssgsbh;
    /**
     * 状态(0 无效1 有效)
     */
    private String zt;
    /**
     * 是否自动生成成本中心(1 是 0 否)
     */
    private String sfzdsccbzx;
    /**
     * 创建人
     */
    private String cjr;
    /**
     * 创建时间
     */
    private Date cjsj;
    /**
     * 部门名称
     */
    private String mc;
    /**
     * 部门简称
     */
    private String jc;
    /**
     * 部门编号
     */
    private String bh;
    /**
     * 所在详细地址
     */
    private String szdz;
    /**
     * 部门电话
     */
    private String bmdh;
    /**
     * 所在省份id
     */
    private String szsfid;
    /**
     * 所在城市id
     */
    private String szcsid;
    /**
     * 所在省份
     */
    private String szsf;
    /**
     * 所在省份
     */
    private String szcs;
    /**
     * 部门主管
     */
    private String cwzg;
    /**
     * 部门负责人
     */
    private String bmfzr;

    public String getSsgsbh() {
        return ssgsbh;
    }

    public void setSsgsbh(String ssgsbh) {
        this.ssgsbh = ssgsbh;
    }

    public String getBmfzr() {
        return bmfzr;
    }

    public void setBmfzr(String bmfzr) {
        this.bmfzr = bmfzr;
    }

    public Date getCjsj() {
        return cjsj;
    }

    public void setCjsj(Date cjsj) {
        this.cjsj = cjsj;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public String getJc() {
        return jc;
    }

    public void setJc(String jc) {
        this.jc = jc;
    }

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
    }

    public String getSzdz() {
        return szdz;
    }

    public void setSzdz(String szdz) {
        this.szdz = szdz;
    }

    public String getBmdh() {
        return bmdh;
    }

    public void setBmdh(String bmdh) {
        this.bmdh = bmdh;
    }

    public String getSzsfid() {
        return szsfid;
    }

    public void setSzsfid(String szsfid) {
        this.szsfid = szsfid;
    }

    public String getSzcsid() {
        return szcsid;
    }

    public void setSzcsid(String szcsid) {
        this.szcsid = szcsid;
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

    public String getCwzg() {
        return cwzg;
    }

    public void setCwzg(String cwzg) {
        this.cwzg = cwzg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSjid() {
        return sjid;
    }

    public void setSjid(String sjid) {
        this.sjid = sjid;
    }

    public String getQybh() {
        return qybh;
    }

    public void setQybh(String qybh) {
        this.qybh = qybh;
    }

    public String getSsgsid() {
        return ssgsid;
    }

    public void setSsgsid(String ssgsid) {
        this.ssgsid = ssgsid;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public String getSfzdsccbzx() {
        return sfzdsccbzx;
    }

    public void setSfzdsccbzx(String sfzdsccbzx) {
        this.sfzdsccbzx = sfzdsccbzx;
    }

    public String getCjr() {
        return cjr;
    }

    public void setCjr(String cjr) {
        this.cjr = cjr;
    }
}
