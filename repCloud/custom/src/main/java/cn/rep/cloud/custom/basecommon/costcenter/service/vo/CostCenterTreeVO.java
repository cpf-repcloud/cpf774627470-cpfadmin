package cn.rep.cloud.custom.basecommon.costcenter.service.vo;


import java.util.List;

/**
 * 成本中心--树形菜单VO
 * Created by vetech on 2018/8/06
 * @author yangxianglin
 */
public class CostCenterTreeVO {
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
     * 节点名称
     */
    private String title;

    /**
     * 是否展开
     */
    private String expand;

    /**
     * 成本中心对象集合
     */
    private List<CostCenterTreeVO> children;


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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExpand() {
        return expand;
    }

    public void setExpand(String expand) {
        this.expand = expand;
    }

    public List<CostCenterTreeVO> getChildren() {
        return children;
    }

    public void setChildren(List<CostCenterTreeVO> children) {
        this.children = children;
    }


}
