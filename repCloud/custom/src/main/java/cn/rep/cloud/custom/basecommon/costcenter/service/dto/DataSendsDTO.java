package cn.rep.cloud.custom.basecommon.costcenter.service.dto;


import java.util.List;

/**
 * 数据下发到子公司DTO
 * @author  houshuang
 * @since 2018-9-4
 */
public class DataSendsDTO {

    /**
     * 类型：0、大类，1、分类
     */
    private String type;

    /**
     * 企业编号
     */
    private String qybh;

    /**
     * 当前登录人公司ID
     */
    private String gsid;

    /**
     * 当前登录人公司名称
     */
    private String gsmc;

    /**
     * 当前登录人
     */
    private String xfr;
    /**
     * 当前登录人姓名
     */
    private String xfrxm;

    /**
     * 公司对象分类编号
     */
    private String bh;

    /**
     * 数据下发类型ID
     */
    private String sjxflxid;

    /**
     * 数据下发类型名称
     */
    private String sjxflxmc;

    /**
     * 公司对象分类id集合
     */
    private List<String> gsdxflids;

    /**
     * 数据下发公司集合
     */
    private List<String> gsids;

    /**
     * 系统对象分类编号
     */
    private List<String> bhs;

    /**
     * IP地址
     */
    private String ip;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getGsmc() {
        return gsmc;
    }

    public void setGsmc(String gsmc) {
        this.gsmc = gsmc;
    }

    public String getXfr() {
        return xfr;
    }

    public void setXfr(String xfr) {
        this.xfr = xfr;
    }

    public String getXfrxm() {
        return xfrxm;
    }

    public void setXfrxm(String xfrxm) {
        this.xfrxm = xfrxm;
    }

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
    }

    public String getSjxflxid() {
        return sjxflxid;
    }

    public void setSjxflxid(String sjxflxid) {
        this.sjxflxid = sjxflxid;
    }

    public String getSjxflxmc() {
        return sjxflxmc;
    }

    public void setSjxflxmc(String sjxflxmc) {
        this.sjxflxmc = sjxflxmc;
    }

    public List<String> getGsdxflids() {
        return gsdxflids;
    }

    public void setGsdxflids(List<String> gsdxflids) {
        this.gsdxflids = gsdxflids;
    }

    public List<String> getGsids() {
        return gsids;
    }

    public void setGsids(List<String> gsids) {
        this.gsids = gsids;
    }

    public List<String> getBhs() {
        return bhs;
    }

    public void setBhs(List<String> bhs) {
        this.bhs = bhs;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }


}
