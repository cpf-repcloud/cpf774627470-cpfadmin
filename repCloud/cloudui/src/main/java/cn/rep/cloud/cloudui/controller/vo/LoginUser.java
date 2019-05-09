package cn.rep.cloud.cloudui.controller.vo;

import java.io.Serializable;
import java.util.Date;

public class LoginUser implements Serializable {
    private static final long serialVersionUID =  7830729778526719356L;

    /**
     * ID(主键)
     */
    private String id;

    /**
     * 企业编号
     */
    private String qybh;

    /**
     * 工号
     */
    private String gh;

    /**
     * 姓名
     */
    private String xm;

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
     * 国际电话区号
     */
    private String gjdhqh;

    /**
     * 联系邮箱
     */
    private String lxyx;

    /**
     * 联系地址
     */
    private String lxdz;

    /**
     * 籍贯
     */
    private String jg;

    /**
     * 性别(M男，F女)
     */
    private String xb;

    /**
     * 生日(32489)
     */
    private Date sr;

    /**
     * 是否秘书(0 否，1 是）
     */
    private String sfms;

    /**
     * 报销委托人
     */
    private String bxwtr;

    /**
     * 常驻工作地
     */
    private String czgzd;

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
     * 个人图像
     */
    private String grtx;

    /**
     * 创建人ID(来源员工表)
     */
    private String cjr;

    /**
     * 创建时间
     */
    private Date cjsj;

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

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQybh() {
        return this.qybh;
    }

    public void setQybh(String qybh) {
        this.qybh = qybh;
    }

    public String getGh() {
        return this.gh;
    }

    public void setGh(String gh) {
        this.gh = gh;
    }

    public String getXm() {
        return this.xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getYwxm() {
        return this.ywxm;
    }

    public void setYwxm(String ywxm) {
        this.ywxm = ywxm;
    }

    public String getDhhm() {
        return this.dhhm;
    }

    public void setDhhm(String dhhm) {
        this.dhhm = dhhm;
    }

    public String getSjhm() {
        return this.sjhm;
    }

    public void setSjhm(String sjhm) {
        this.sjhm = sjhm;
    }

    public String getGjdhqh() {
        return this.gjdhqh;
    }

    public void setGjdhqh(String gjdhqh) {
        this.gjdhqh = gjdhqh;
    }

    public String getLxyx() {
        return this.lxyx;
    }

    public void setLxyx(String lxyx) {
        this.lxyx = lxyx;
    }

    public String getLxdz() {
        return this.lxdz;
    }

    public void setLxdz(String lxdz) {
        this.lxdz = lxdz;
    }

    public String getJg() {
        return this.jg;
    }

    public void setJg(String jg) {
        this.jg = jg;
    }

    public String getXb() {
        return this.xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    public Date getSr() {
        return this.sr;
    }

    public void setSr(Date sr) {
        this.sr = sr;
    }

    public String getSfms() {
        return this.sfms;
    }

    public void setSfms(String sfms) {
        this.sfms = sfms;
    }

    public String getBxwtr() {
        return this.bxwtr;
    }

    public void setBxwtr(String bxwtr) {
        this.bxwtr = bxwtr;
    }

    public String getCzgzd() {
        return this.czgzd;
    }

    public void setCzgzd(String czgzd) {
        this.czgzd = czgzd;
    }

    public String getYhzhm() {
        return this.yhzhm;
    }

    public void setYhzhm(String yhzhm) {
        this.yhzhm = yhzhm;
    }

    public String getYhkhh() {
        return this.yhkhh;
    }

    public void setYhkhh(String yhkhh) {
        this.yhkhh = yhkhh;
    }

    public String getYhzh() {
        return this.yhzh;
    }

    public void setYhzh(String yhzh) {
        this.yhzh = yhzh;
    }

    public String getSjqxlx() {
        return this.sjqxlx;
    }

    public void setSjqxlx(String sjqxlx) {
        this.sjqxlx = sjqxlx;
    }

    public String getKtzt() {
        return this.ktzt;
    }

    public void setKtzt(String ktzt) {
        this.ktzt = ktzt;
    }

    public String getGrtx() {
        return this.grtx;
    }

    public void setGrtx(String grtx) {
        this.grtx = grtx;
    }

    public String getCjr() {
        return this.cjr;
    }

    public void setCjr(String cjr) {
        this.cjr = cjr;
    }

    public Date getCjsj() {
        return this.cjsj;
    }

    public void setCjsj(Date cjsj) {
        this.cjsj = cjsj;
    }
}
