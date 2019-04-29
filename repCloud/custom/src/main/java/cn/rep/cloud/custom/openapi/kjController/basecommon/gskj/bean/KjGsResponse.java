package cn.rep.cloud.custom.openapi.kjController.basecommon.gskj.bean;

import cn.rep.cloud.custom.openapi.kjController.baseBean.KjBaseResponse;

public class KjGsResponse extends KjBaseResponse {
    /**
     * 企业编号
     */
    private String qybh;
    /**
     * 类型(1集团公司 2子公司 3.分公司)
     */
    private String lx;

    /**
     * 公司名称(全称)
     */
    private String mc;
    /**
     * 上级id(none表示无上级公司)
     */
    private String sjid;

    /**
     * 上级名称(null表示无上级公司)
     */
    private String sjmc;

    /**
     * 所在国家
     */
    private String szgj;

    /**
     * 所在省份
     */
    private String szsf;

    /**
     * 所在城市
     */
    private String szcs;

    /**
     * 详细地址
     */
    private String xxdz;

    /**
     * 公司法人
     */
    private String gsfr;

    /**
     * 公司电话
     */
    private String gsdh;
    /**
     * 银行账户名
     */
    private String yhzhm;

    /**
     * 银行开户行
     */
    private String yhkhh;

    /**
     * 银行账号
     */
    private String yhzh;

    public String getQybh() {
        return qybh;
    }

    public void setQybh(String qybh) {
        this.qybh = qybh;
    }

    public String getLx() {
        return lx;
    }

    public void setLx(String lx) {
        this.lx = lx;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public String getSjid() {
        return sjid;
    }

    public void setSjid(String sjid) {
        this.sjid = sjid;
    }

    public String getSjmc() {
        return sjmc;
    }

    public void setSjmc(String sjmc) {
        this.sjmc = sjmc;
    }

    public String getSzgj() {
        return szgj;
    }

    public void setSzgj(String szgj) {
        this.szgj = szgj;
    }

    public String getSzsf() {
        return szsf;
    }

    public void setSzsf(String szsf) {
        this.szsf = szsf;
    }

    public String getSzcs() {
        return szcs;
    }

    public void setSzcs(String szcs) {
        this.szcs = szcs;
    }

    public String getXxdz() {
        return xxdz;
    }

    public void setXxdz(String xxdz) {
        this.xxdz = xxdz;
    }

    public String getGsfr() {
        return gsfr;
    }

    public void setGsfr(String gsfr) {
        this.gsfr = gsfr;
    }

    public String getGsdh() {
        return gsdh;
    }

    public void setGsdh(String gsdh) {
        this.gsdh = gsdh;
    }

    public String getYhzhm() {
        return yhzhm;
    }

    public void setYhzhm(String yhzhm) {
        this.yhzhm = yhzhm;
    }

    public String getYhkhh() {
        return yhkhh;
    }

    public void setYhkhh(String yhkhh) {
        this.yhkhh = yhkhh;
    }

    public String getYhzh() {
        return yhzh;
    }

    public void setYhzh(String yhzh) {
        this.yhzh = yhzh;
    }
}
