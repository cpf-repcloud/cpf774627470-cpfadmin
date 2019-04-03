package cn.rep.cloud.custom.basecommon.costcenter.service.dto;


import java.util.List;

/**
 * 成本中心列表查询传入参数
 * Created by vetech on 2018/8/6.
 */
public class CostCenterListDTO {
    /**
     * 成本中心id
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
     * 成本中心编号
     */
    private String cbzxbh;
    /**
     * 成本中心名称
     */
    private String cbzxmc;
    /**
     * 成本中心id集合
     */
    private List<String> cbzxidList;

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

    public List<String> getCbzxidList() {
        return cbzxidList;
    }

    public void setCbzxidList(List<String> cbzxidList) {
        this.cbzxidList = cbzxidList;
    }


}
