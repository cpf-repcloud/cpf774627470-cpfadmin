package cn.rep.cloud.custom.basecommon.basedata.service.vo;

public class BaseDataLbDTO {

    /**
     * ID(主键)
     */
    private String id;

    /**
     *
     */
    private String lb;
    /**
     *
     */
    private String lbmc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
