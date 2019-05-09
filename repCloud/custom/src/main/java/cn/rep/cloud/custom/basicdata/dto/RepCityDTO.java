package cn.rep.cloud.custom.basicdata.dto;

public class RepCityDTO {

    /**
     * 主键id
     */
    private String id;
    /**
     * 是否热门城市(1.是   0.否)
     */
    private String sfrm;
    /**
     * 国内国际
     */
    private String gngj;
    /**
     * 拼音检索码
     */
    private String pyjsm;
    /**
     * 英文名称
     */
    private String ywmc;
    /**
     * 关键字(用于搜索)
     */
    private String gjz;
    /**
     * 城市名称
     */
    private String mc;
    /**
     * 所在省份id
     */
    private String szsfid;
    /**
     * 所在省份
     */
    private String szsf;

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public String getSzsfid() {
        return szsfid;
    }

    public void setSzsfid(String szsfid) {
        this.szsfid = szsfid;
    }

    public String getSzsf() {
        return szsf;
    }

    public void setSzsf(String szsf) {
        this.szsf = szsf;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSfrm() {
        return sfrm;
    }

    public void setSfrm(String sfrm) {
        this.sfrm = sfrm;
    }

    public String getGngj() {
        return gngj;
    }

    public void setGngj(String gngj) {
        this.gngj = gngj;
    }

    public String getPyjsm() {
        return pyjsm;
    }

    public void setPyjsm(String pyjsm) {
        this.pyjsm = pyjsm;
    }

    public String getYwmc() {
        return ywmc;
    }

    public void setYwmc(String ywmc) {
        this.ywmc = ywmc;
    }

    public String getGjz() {
        return gjz;
    }

    public void setGjz(String gjz) {
        this.gjz = gjz;
    }
}
