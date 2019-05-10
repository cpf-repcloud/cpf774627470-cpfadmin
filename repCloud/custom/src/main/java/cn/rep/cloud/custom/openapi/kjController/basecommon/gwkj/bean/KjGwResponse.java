package cn.rep.cloud.custom.openapi.kjController.basecommon.gwkj.bean;

import cn.rep.cloud.custom.openapi.kjController.baseBean.KjBaseResponse;

public class KjGwResponse extends KjBaseResponse {
    private String id;

    /**
     * 企业编号
     */
    private String qybh;



    /**
     * 岗位编号
     */
    private String gwbh;

    /**
     * 岗位名称
     */
    private String gwmc;


    /**
     * 岗位级别
     */
    private String gwjb;


    /**
     * 国际化编号
     */
    private String gjhbh;


    /**
     * 状态
     */
    private String zt;

    /**
     * 岗位描述
     */
    private String gwms;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getQybh() {
        return qybh;
    }

    public void setQybh(String qybh) {
        this.qybh = qybh;
    }

    public String getGwbh() {
        return gwbh;
    }

    public void setGwbh(String gwbh) {
        this.gwbh = gwbh;
    }

    public String getGwmc() {
        return gwmc;
    }

    public void setGwmc(String gwmc) {
        this.gwmc = gwmc;
    }

    public String getGwjb() {
        return gwjb;
    }

    public void setGwjb(String gwjb) {
        this.gwjb = gwjb;
    }

    public String getGjhbh() {
        return gjhbh;
    }

    public void setGjhbh(String gjhbh) {
        this.gjhbh = gjhbh;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public String getGwms() {
        return gwms;
    }

    public void setGwms(String gwms) {
        this.gwms = gwms;
    }
}
