package cn.rep.cloud.custom.openapi.kjController.basecommon.cskj.bean;

import cn.rep.cloud.custom.openapi.kjController.baseBean.KjBaseResponse;

import java.io.Serializable;
import java.util.List;

public class KjCsResponse extends KjBaseResponse implements Serializable{

    /**
     * 城市编号
     */
    private String bh;
    /**
     * 子对象
     */
    private List<CityBean> children;
    /**
     * 分类(热门城市,A-Z)
     */
    private String firstZ;
    /**
     * 查询时返回分页信息
     */
    private Long total;

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
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

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
