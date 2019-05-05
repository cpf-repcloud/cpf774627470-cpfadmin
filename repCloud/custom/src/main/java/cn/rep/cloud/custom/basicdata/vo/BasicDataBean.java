package cn.rep.cloud.custom.basicdata.vo;

import java.io.Serializable;

public class BasicDataBean implements Serializable{
    /**
     * 国家/省份/城市 id
     */
    private String value;
    /**
     * 国家/省份/城市 名称
     */
    private String label;

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
