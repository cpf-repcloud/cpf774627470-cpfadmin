package cn.rep.cloud.custom.openapi.kjController.basecommon.ygkj.Bean;

import cn.rep.cloud.custom.openapi.kjController.baseBean.KjBaseResponse;

public class KjYgResponse extends KjBaseResponse {
    /**
     * 企业编号
     */
    private String qybh;
    /**
     * 工号
     */
    private String gh;
    /**
     * 英文姓名
     */
    private String ywxm;
    /**
     * 电话号码
     */
    private String dhhm;
    /**
     * 手机号码
     */
    private String sjhm;
    /**
     * 联系邮箱
     */
    private String lxyx;
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
    /**
     * 数据权限类型（1 本人，2 本部门，3 本公司,4 指定部门）
     */
    private String sjqxlx;

    /**
     * 开通状态(0 未开启，1 已开通)
     */
    private String ktzt;
    /**
     * 公司id
     */
    private String gsid;

    /**
     * 公司名称
     */
    private String gsmc;

    /**
     * 部门id
     */
    private String bmid;

    /**
     * 部门名称
     */
    private String bmmc;

    public String getQybh() {
        return qybh;
    }

    public void setQybh(String qybh) {
        this.qybh = qybh;
    }

    public String getGh() {
        return gh;
    }

    public void setGh(String gh) {
        this.gh = gh;
    }

    public String getYwxm() {
        return ywxm;
    }

    public void setYwxm(String ywxm) {
        this.ywxm = ywxm;
    }

    public String getDhhm() {
        return dhhm;
    }

    public void setDhhm(String dhhm) {
        this.dhhm = dhhm;
    }

    public String getSjhm() {
        return sjhm;
    }

    public void setSjhm(String sjhm) {
        this.sjhm = sjhm;
    }

    public String getLxyx() {
        return lxyx;
    }

    public void setLxyx(String lxyx) {
        this.lxyx = lxyx;
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

    public String getSjqxlx() {
        return sjqxlx;
    }

    public void setSjqxlx(String sjqxlx) {
        this.sjqxlx = sjqxlx;
    }

    public String getKtzt() {
        return ktzt;
    }

    public void setKtzt(String ktzt) {
        this.ktzt = ktzt;
    }

    public String getGsid() {
        return gsid;
    }

    public void setGsid(String gsid) {
        this.gsid = gsid;
    }

    public String getGsmc() {
        return gsmc;
    }

    public void setGsmc(String gsmc) {
        this.gsmc = gsmc;
    }

    public String getBmid() {
        return bmid;
    }

    public void setBmid(String bmid) {
        this.bmid = bmid;
    }

    public String getBmmc() {
        return bmmc;
    }

    public void setBmmc(String bmmc) {
        this.bmmc = bmmc;
    }
}
