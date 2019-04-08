package cn.rep.cloud.custom.openapi.kjController.baseBean;

import java.util.List;

/**
 * 控件基础bean
 */
public class KjBaseResponse {

    private String value;

    private String label;

    private List<KjBaseResponse> children;


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

    public List<KjBaseResponse> getChildren() {
        return children;
    }

    public void setChildren(List<KjBaseResponse> children) {
        this.children = children;
    }
}
