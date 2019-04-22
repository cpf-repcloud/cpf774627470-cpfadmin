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
}
