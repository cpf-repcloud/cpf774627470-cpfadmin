package cn.rep.cloud.custom.openapi.kjController.basecommon.xmkj.bean;

import cn.rep.cloud.custom.openapi.kjController.baseBean.KjBaseResponse;

import java.util.List;

/**
 * 项目控件返回参数
 */
public class KjXmResponse extends KjBaseResponse {

    private List<KjXmResponse> children;


    public List<KjXmResponse> getChildren() {
        return children;
    }

    public void setChildren(List<KjXmResponse> children) {
        this.children = children;
    }
}
