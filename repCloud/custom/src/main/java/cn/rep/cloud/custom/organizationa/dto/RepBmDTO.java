package cn.rep.cloud.custom.organizationa.dto;

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
