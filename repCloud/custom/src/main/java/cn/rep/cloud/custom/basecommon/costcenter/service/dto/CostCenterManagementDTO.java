package cn.rep.cloud.custom.basecommon.costcenter.service.dto;


/**
 * 公司管理-公司列表DTO
 * @author yangxianglin
 * Created by vetech on 2018/08/06
 */
public class CostCenterManagementDTO {
    /**
     * 企业编号
     */
    private String qybh;

    /**
     * 公司id
     */
    private String gsid;

    /**
     * 成本中心名称
     */
    private String cbzxmc;

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

    public String getCbzxmc() {
        return cbzxmc;
    }

    public void setCbzxmc(String cbzxmc) {
        this.cbzxmc = cbzxmc;
    }


}
