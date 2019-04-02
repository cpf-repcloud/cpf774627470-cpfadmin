package cn.rep.cloud.custom.organizationa.vo;


import java.util.List;

public class RepModularVO{

    /**
     * 主键id
     */
    private String id;
    /**
     * 父级id
     */
    private String parentid;
    /**
     * url地址
     */
    private String url;
    /**
     * 模块名称
     */
    private String name;
    /**
     * 子集合
     */
    private List<RepModularVO> children;
    /**
     * 名称
     */
    private String label;
    /**
     * 属性值
     */
    private String value;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RepModularVO> getChildren() {
        return children;
    }

    public void setChildren(List<RepModularVO> children) {
        this.children = children;
    }
}
