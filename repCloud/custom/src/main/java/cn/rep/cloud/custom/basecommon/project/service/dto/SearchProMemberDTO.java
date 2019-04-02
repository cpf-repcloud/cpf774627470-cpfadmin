package cn.rep.cloud.custom.basecommon.project.service.dto;

/**
 * Created by vetech on 2018/8/13.
 */
public class SearchProMemberDTO {

    /**
     *成员 姓名
     */
    private String cymc;

    /**
     * 状态
     */
    private String zt;


    /**
     * 项目id
     */
    private String xmid;

    /**
     * 企业编号
     */
    private String qybh;


    /***
     * id
     * @return
     */
    private String id;

    /**
     * 成员角色
     */
    private String cyjs;


    public String getCyjs() {
        return cyjs;
    }

    public void setCyjs(String cyjs) {
        this.cyjs = cyjs;
    }

    public String getCymc() {
        return cymc;
    }

    public void setCymc(String cymc) {
        this.cymc = cymc;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }



    public String getXmid() {
        return xmid;
    }

    public void setXmid(String xmid) {
        this.xmid = xmid;
    }

    public String getQybh() {
        return qybh;
    }

    public void setQybh(String qybh) {
        this.qybh = qybh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
