package cn.rep.cloud.custom.basecommon.project.service.dto;


/**
 * Created by vetech on 2018/8/4.
 */
public class SearchDataDTO {


    /**
     * id
     */
    private String id;
    /**
     * 企业编号
     */
    private String qybh;
    /**
     * 公司编号
     */
    private String gsid;
    /**
     * 项目编号
     */
    private String xmbh;

    /**
     * 项目名称
     */
    private String xmmc;

    /**
     * 上级编号
     * @return
     */
    private String sjbh;
    /**
     * 开始时间启
     */
    private String ksrqStrq;

    /**
     * 项目开始时间止
     * @return
     */
    private  String ksrqStrz;

    /**
     * 项目id
     */
    private String xmid;


    public String getSjbh() {
        return sjbh;
    }

    public void setSjbh(String sjbh) {
        this.sjbh = sjbh;
    }

    public String getXmbh() {
        return xmbh;
    }

    public void setXmbh(String xmbh) {
        this.xmbh = xmbh;
    }

    public String getXmmc() {
        return xmmc;
    }

    public void setXmmc(String xmmc) {
        this.xmmc = xmmc;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKsrqStrq() {
        return ksrqStrq;
    }

    public void setKsrqStrq(String ksrqStrq) {
        this.ksrqStrq = ksrqStrq;
    }

    public String getKsrqStrz() {
        return ksrqStrz;
    }

    public void setKsrqStrz(String ksrqStrz) {
        this.ksrqStrz = ksrqStrz;
    }

    public String getXmid() {
        return xmid;
    }

    public void setXmid(String xmid) {
        this.xmid = xmid;
    }


}
