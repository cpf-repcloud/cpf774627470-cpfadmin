package cn.rep.cloud.custom.coreutils.common;


import java.util.List;

public class TreeNode {
    /**
     * 标题名称
     */
    private String title;
    /**
     * 返回值
     */
    private String value;
    /**
     * 是否展开直子节点
     */
    private Boolean expand;
    /**
     * 禁掉响应
     */
    private Boolean disabled;
    /**
     * 禁掉 checkbox
     */
    private Boolean disableCheckbox;
    /**
     * 是否选中子节点
     */
    private Boolean selected;
    /**
     * 是否勾选(如果勾选，子节点也会全部勾选)
     */
    private Boolean checked;
    /**
     * 子节点属性数组
     */
    private List<TreeNode> children;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getExpand() {
        return expand;
    }

    public void setExpand(Boolean expand) {
        this.expand = expand;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public Boolean getDisableCheckbox() {
        return disableCheckbox;
    }

    public void setDisableCheckbox(Boolean disableCheckbox) {
        this.disableCheckbox = disableCheckbox;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }
}
