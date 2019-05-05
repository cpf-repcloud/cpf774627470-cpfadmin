package cn.rep.cloud.custom.basicdata.vo;

import java.io.Serializable;
import java.util.List;

public class RepCountryVO implements Serializable{
    /**
     * 国家/省份/城市 id
     */
    private String value;
    /**
     * 国家/省份/城市 名称
     */
    private String label;
    /**
     * 下级
     */
    private List<BasicDataBean> children;

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

    public List<BasicDataBean> getChildren() {
        return children;
    }

    public void setChildren(List<BasicDataBean> children) {
        this.children = children;
    }
}
