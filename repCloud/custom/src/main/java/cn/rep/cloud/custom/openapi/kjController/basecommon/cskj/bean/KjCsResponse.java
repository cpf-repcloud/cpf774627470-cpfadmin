package cn.rep.cloud.custom.openapi.kjController.basecommon.cskj.bean;

import cn.rep.cloud.custom.openapi.kjController.baseBean.KjBaseResponse;

import java.util.List;

public class KjCsResponse extends KjBaseResponse {

    /**
     * id
     */
    private String id;
    /**
     * 城市编号
     */
    private String bh;
    /**
     * 城市名称
     */
    private String name;
    /**
     * 子对象
     */
    private List<CityBean> children;
    /**
     * 分类(热门城市,A-Z)
     */
    private String firstZ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CityBean> getChildren() {
        return children;
    }

    public void setChildren(List<CityBean> children) {
        this.children = children;
    }

    public String getFirstZ() {
        return firstZ;
    }

    public void setFirstZ(String firstZ) {
        this.firstZ = firstZ;
    }
}
