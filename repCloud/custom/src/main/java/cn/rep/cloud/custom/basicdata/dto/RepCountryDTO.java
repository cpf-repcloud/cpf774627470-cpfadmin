package cn.rep.cloud.custom.basicdata.dto;

public class RepCountryDTO {
    /**
     * 主键id
     */
    private String id;

    /**
     * 国家名称
     */
    private String mc;

    /**
     * 英文名称
     */
    private String ywmc;
    /**
     * 父级id
     */
    private String parid;

    /**
     * 类别
     */
    private String lb;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public String getYwmc() {
        return ywmc;
    }

    public void setYwmc(String ywmc) {
        this.ywmc = ywmc;
    }

    public String getParid() {
        return parid;
    }

    public void setParid(String parid) {
        this.parid = parid;
    }

    public String getLb() {
        return lb;
    }

    public void setLb(String lb) {
        this.lb = lb;
    }
}
