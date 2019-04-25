package cn.rep.cloud.custom.organizationa.vo;

import java.util.List;

public class SuccessBean {
    /**
     * 失败总条数
     */
    private Integer failCount;
    /**
     * 成功总条数
     */
    private Integer successCount;
    /**
     * 失败原因集合
     */
    private List<FailBean> failBeanList;

    public Integer getFailCount() {
        return failCount;
    }

    public void setFailCount(Integer failCount) {
        this.failCount = failCount;
    }

    public Integer getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(Integer successCount) {
        this.successCount = successCount;
    }

    public List<FailBean> getFailBeanList() {
        return failBeanList;
    }

    public void setFailBeanList(List<FailBean> failBeanList) {
        this.failBeanList = failBeanList;
    }
}
