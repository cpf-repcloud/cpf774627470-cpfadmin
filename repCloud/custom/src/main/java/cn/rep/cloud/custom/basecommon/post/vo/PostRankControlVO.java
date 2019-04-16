package cn.rep.cloud.custom.basecommon.post.vo;

import java.util.List;

/**
 * 岗位控件VO
 *
 * @author : wzx
 * @since : 2018/8/8 9:44
 */
public class PostRankControlVO {

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
     * 父id
     */
    public String parentId;

    /**
     * 子节点集合
     */
    public List<PostRankControlVO> children;


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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<PostRankControlVO> getChildren() {
        return children;
    }

    public void setChildren(List<PostRankControlVO> children) {
        this.children = children;
    }
}
