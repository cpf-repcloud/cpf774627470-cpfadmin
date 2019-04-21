package cn.rep.cloud.custom.openapi.kjController.basecommon.cskj.bean;

import cn.rep.cloud.custom.openapi.kjController.baseBean.KjBaseRequest;

public class KjCsRequest extends KjBaseRequest {
    /**
     * 请求值(关键字)
     */
    private String value;
    /**
     * 用于查询时分页  当前页
     */
    private Integer current;
    /**
     * 用于查询时分页 每一页多少条
     */
    private Integer pageSize;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
