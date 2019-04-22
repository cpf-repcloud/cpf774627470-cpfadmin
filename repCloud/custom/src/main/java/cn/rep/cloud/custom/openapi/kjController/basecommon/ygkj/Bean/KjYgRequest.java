package cn.rep.cloud.custom.openapi.kjController.basecommon.ygkj.Bean;

public class KjYgRequest {
    /**
     * 公司id
     */
    private String gsid;
    /**
     * 部门id
     */
    private String bmid;

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
}
