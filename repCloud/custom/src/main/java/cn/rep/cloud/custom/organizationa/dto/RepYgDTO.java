package cn.rep.cloud.custom.organizationa.dto;

public class RepYgDTO {

    /**
     * 员工id
     */
    private String id;
    /**
     * 员工工号
     */
    private String gh;
    /**
     * 企业编号
     */
    private String qybh;
    /**
     * 公司id
     */
    private String gsid;
    /**
     * 部门id
     */
    private String bmid;
    /**
     * 开通状态(0 未开启，1 已开通)
     */
    private String ktzt;
    /**
     * 创建人
     */
    private String cjr;
    /**
     * 关键字查询
     */
    private String gjz;
    /**
     * 是否离职 0:否 1:是
     */
    private Integer sflz;
    /**
     * 岗位
     */
    private String gw;
    /**
     * 直属上级
     */
    private String zssj;
    /**
     * 权限级别
     */
    private Integer qxjb;
    /**
     * 平台角色
     */
    private String ptjs;

    public Integer getSflz() {
        return sflz;
    }

    public void setSflz(Integer sflz) {
        this.sflz = sflz;
    }

    public String getGw() {
        return gw;
    }

    public void setGw(String gw) {
        this.gw = gw;
    }

    public String getZssj() {
        return zssj;
    }

    public void setZssj(String zssj) {
        this.zssj = zssj;
    }

    public Integer getQxjb() {
        return qxjb;
    }

    public void setQxjb(Integer qxjb) {
        this.qxjb = qxjb;
    }

    public String getPtjs() {
        return ptjs;
    }

    public void setPtjs(String ptjs) {
        this.ptjs = ptjs;
    }

    public String getGjz() {
        return gjz;
    }

    public void setGjz(String gjz) {
        this.gjz = gjz;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGh() {
        return gh;
    }

    public void setGh(String gh) {
        this.gh = gh;
    }

    public String getQybh() {
        return qybh;
    }

    public void setQybh(String qybh) {
        this.qybh = qybh;
    }

    public String getGsid() {
        return gsid;
    }

    public void setGsid(String gsid) {
        this.gsid = gsid;
    }

    public String getBmid() {
        return bmid;
    }

    public void setBmid(String bmid) {
        this.bmid = bmid;
    }

    public String getKtzt() {
        return ktzt;
    }

    public void setKtzt(String ktzt) {
        this.ktzt = ktzt;
    }

    public String getCjr() {
        return cjr;
    }

    public void setCjr(String cjr) {
        this.cjr = cjr;
    }
}
