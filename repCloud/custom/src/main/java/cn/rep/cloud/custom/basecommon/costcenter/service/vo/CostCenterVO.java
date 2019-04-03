package cn.rep.cloud.custom.basecommon.costcenter.service.vo;


import java.util.List;

/**
 * 成本中心项目控件VO
 * Created by vetech on 2018/8/20.
 */
public class CostCenterVO {
    /**
     * 成本中心主键id
     ***/
    private String id;
    /**
     * 成本中心编号
     ***/
    private String value;
    /**
     * 成本中心名称
     ***/
    private String label;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }


}
