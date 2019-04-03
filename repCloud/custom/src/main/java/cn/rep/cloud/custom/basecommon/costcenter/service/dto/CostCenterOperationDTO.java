package cn.rep.cloud.custom.basecommon.costcenter.service.dto;


import java.util.List;

/**
 * 成本中心操作传参
 * Created by vetech on 2018/8/7.
 */
public class CostCenterOperationDTO {
    /**
     * 成本中心主键id
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
     * 成本中心上级编号
     */
    private String sjbh;
    /**
     * 成本中心是否独立预算
     */
    private String sfdlys;
    /**
     * 最后修改人
     */
    private String zhxgr;
    /**
     * 成本中心编号
     */
    private String cbzxbh;
    /**
     * 成本中心名称
     */
    private String cbzxmc; /**
     * 状态
     */
    private String zt;
    /**
     * 最后修改ip
     */
    private String ip;
    /**
     * 操作人
     */
    private String czr;
    /**
     * 关联部门id集合
     */
    private List<String> bmidList;
    /**
     * 关联项目id集合
     */
    private List<String> xmidList;


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

    public String getSjbh() {
        return sjbh;
    }

    public void setSjbh(String sjbh) {
        this.sjbh = sjbh;
    }

    public String getSfdlys() {
        return sfdlys;
    }

    public void setSfdlys(String sfdlys) {
        this.sfdlys = sfdlys;
    }

    public String getZhxgr() {
        return zhxgr;
    }

    public void setZhxgr(String zhxgr) {
        this.zhxgr = zhxgr;
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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public List<String> getBmidList() {
        return bmidList;
    }

    public void setBmidList(List<String> bmidList) {
        this.bmidList = bmidList;
    }

    public List<String> getXmidList() {
        return xmidList;
    }

    public void setXmidList(List<String> xmidList) {
        this.xmidList = xmidList;
    }

    public String getCzr() {
        return czr;
    }

    public void setCzr(String czr) {
        this.czr = czr;
    }

    public String getGsid() {
        return gsid;
    }

    public void setGsid(String gsid) {
        this.gsid = gsid;
    }


}
