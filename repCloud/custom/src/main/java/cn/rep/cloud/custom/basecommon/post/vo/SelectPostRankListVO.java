package cn.rep.cloud.custom.basecommon.post.vo;


/**
 * 查询岗位数据回参
 * Created by vetech on 2018/10/8.
 *
 * @author vetech
 */
public class SelectPostRankListVO {
    /**
     * 岗位主键id
     */
    private String id;
    /**
     * 企业编号
     */
    private String qybh;
    /**
     * 公司id
     */
    private String gsid;
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

    public String getGsid() {
        return gsid;
    }

    public void setGsid(String gsid) {
        this.gsid = gsid;
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

    public String getGwms() {
        return gwms;
    }

    public void setGwms(String gwms) {
        this.gwms = gwms;
    }


}
