package cn.rep.cloud.custom.openapi.kjController.basecommon.cskj.bean;

import cn.rep.cloud.custom.openapi.kjController.baseBean.KjBaseRequest;

public class KjCsRequest extends KjBaseRequest {
    /**
     * 请求值
     */
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
