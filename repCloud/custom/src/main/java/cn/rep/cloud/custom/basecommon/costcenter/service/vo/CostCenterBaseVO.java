package cn.rep.cloud.custom.basecommon.costcenter.service.vo;




/**
 * Created by vetech on 2018/8/8.
 */
public class CostCenterBaseVO {
    /**
     * ID(主键)
     */
    private String id;
    /**
     * 企业编号
     */
    private String qybh;
    /**
     * 公司编号
     */
    private String gsbh;
    /**
     * 成本中心编号
     */
    private String cbzxbh;
    /**
     * 成本中心名称
     */
    private String cbzxmc;
    /**
     * 上级编号
     */
    private String sjbh;
    /**
     * 项目状态(0 无效，1 正常)
     */
    private String zt;
    /**
     * 是否独立预算(0 否，1 是)
     */
    private String sfdlys;

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

    public String getGsbh() {
        return gsbh;
    }

    public void setGsbh(String gsbh) {
        this.gsbh = gsbh;
    }

    public String getCbzxbh() {
        return cbzxbh;
    }

    public void setCbzxbh(String cbzxbh) {
        this.cbzxbh = cbzxbh;
    }

    public String getCbzxmc() {
        return cbzxmc;
    }

    public void setCbzxmc(String cbzxmc) {
        this.cbzxmc = cbzxmc;
    }

    public String getSjbh() {
        return sjbh;
    }

    public void setSjbh(String sjbh) {
        this.sjbh = sjbh;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public String getSfdlys() {
        return sfdlys;
    }

    public void setSfdlys(String sfdlys) {
        this.sfdlys = sfdlys;
    }


}
