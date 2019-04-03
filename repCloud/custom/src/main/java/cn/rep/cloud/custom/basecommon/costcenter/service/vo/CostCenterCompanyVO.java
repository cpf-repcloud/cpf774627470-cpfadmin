package cn.rep.cloud.custom.basecommon.costcenter.service.vo;


import java.util.List;

/**
 * 成本中心公司级联控件展示数据
 *
 * @author : vetech
 * @since : 2018/10/19 10:52
 */
public class CostCenterCompanyVO {
    /**
     * id
     */
    public String id;
    /**
     * 公司名称
     */
    public String label;
    /**
     * 公司对应的值
     */
    public String value;
    /**
     * 成本中心数据
     */
    private List<CostCenterVO> cbzxList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<CostCenterVO> getCbzxList() {
        return cbzxList;
    }

    public void setCbzxList(List<CostCenterVO> cbzxList) {
        this.cbzxList = cbzxList;
    }



}
