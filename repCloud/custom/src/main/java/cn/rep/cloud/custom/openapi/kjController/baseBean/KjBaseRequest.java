package cn.rep.cloud.custom.openapi.kjController.baseBean;

/**
 * 控件基础request
 */
public class KjBaseRequest {

    /**
     * 公司id
     */
    private String gsid;

    private String qybh;

    public String getGsid() {
        return gsid;
    }

    public void setGsid(String gsid) {
        this.gsid = gsid;
    }

    public String getQybh() {
        return qybh;
    }

    public void setQybh(String qybh) {
        this.qybh = qybh;
    }
}
