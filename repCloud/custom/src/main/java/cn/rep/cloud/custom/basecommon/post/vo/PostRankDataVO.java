package cn.rep.cloud.custom.basecommon.post.vo;


/**
 * 公司岗位出参
 * Created by vetech on 2018/7/26.
 */
public class PostRankDataVO {

    private String id;

    /**
     * 企业编号
     */
    private String qybh;



    /**
     * 岗位编号
     */
    private String gwbh;

    /**
     * 岗位名称
     */
    private String gwmc;


    /**
     * 岗位级别
     */
    private String gwjb;


    /**
     * 国际化编号
     */
    private String gjhbh;


    /**
     * 状态
     */
    private String zt;

    /**
     * 岗位描述
     */
    private String gwms;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQybh() {
        return qybh;
    }

    public void setQybh(String qybh) {
        this.qybh = qybh;
    }

    public String getGwbh() {
        return gwbh;
    }

    public void setGwbh(String gwbh) {
        this.gwbh = gwbh;
    }

    public String getGwmc() {
        return gwmc;
    }

    public void setGwmc(String gwmc) {
        this.gwmc = gwmc;
    }

    public String getGwjb() {
        return gwjb;
    }

    public void setGwjb(String gwjb) {
        this.gwjb = gwjb;
    }

    public String getGjhbh() {
        return gjhbh;
    }

    public void setGjhbh(String gjhbh) {
        this.gjhbh = gjhbh;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public String getGwms() {
        return gwms;
    }

    public void setGwms(String gwms) {
        this.gwms = gwms;
    }
}
