package cn.rep.cloud.custom.billmanagement.ccsqd.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import javax.persistence.Entity;
import java.util.Date;


@TableName("rep_ccsqb")
public class RepCcsqb {



    @TableId("id")
    private String sqdh;

    private String qybh;

    private String gsid;

    //**出差人员*//
    private String ccry;

    /**
     *目的地
     */
    private String mdd;

    /**
     *出差日期始
     */
    private String ccrqs;

    /**
     * 出差日期止
     */
    private String ccrqz;

    /**
     *单据状态 '0草稿 1未提交 2审批中 3审批完成 4已拒绝 5已确认 6已报销 7无需审批'
     */
    private String djzt;

    /**
     * 申请人姓名
     */
    private String sqrxm;

    /**
     *申请部门
     */
    private String sqbm;

    /**
     *申请人手机
     */
    private String sqrsj;

    /**
     * 申请时间
     */
    private String sqsj;
    /**
     * 送审时间
     */
    private String sssj;


    /**
     * 审批时间
     */
    private String spsj;
    /**
     * 成本中心编号
     */
    private String cbzxbh;
    /**
     * 成本中心名称
     */
    private String cbzxmc;

    /**
     * 项目编号
     */
    private String xmbh;

    /**
     * 项目名称
     */
    private String xmmc;

    /**
     * 报销人
     */
    private String bxr;


    /**
     * 是否送审，送审一次次数加1
     */
    private Integer sfss;

    /**
     * 出差类型 1项目出差 2部门出差
     */
    private String cclx;

    /**
     * 审批人
     */
    private String sprxm;


    /**
     * 借款人，可以有多个，存姓名
     */
    private String jkr;


    /**
     * 出发地
     */
    private String cfd;

    private String cfdbh;

    private String mddbh;

    /**
     * 借支金额
     */
    private String jzje;

    /**
     * 报销状态
     */
    private String bxzt;

    /**
     * 实际出差日期止
     */
    private String sjccrqz;
    /**
     * 报销单号
     */
    private String bxdh;
    /**
     * 出差是否完成 0.未完成 1. 已完成
     */
    private String ccsfwc;

    /**
     * 申请人id
     */
    private String sqrid;


    /**
     * 审批人id
     */
    private String sprid;


    /**
     * 出差事由
     */
    private String ccsy;

    /**
     * 创建时间
     */
    private Date cjsj;

    /**
     * 修改时间
     */
    private Date xgsj;


    public Date getCjsj() {
        return cjsj;
    }

    public void setCjsj(Date cjsj) {
        this.cjsj = cjsj;
    }

    public Date getXgsj() {
        return xgsj;
    }

    public void setXgsj(Date xgsj) {
        this.xgsj = xgsj;
    }

    public String getSqdh() {
        return sqdh;
    }

    public void setSqdh(String sqdh) {
        this.sqdh = sqdh;
    }

    public String getQybh() {
        return qybh;
    }

    public void setQybh(String qybh) {
        this.qybh = qybh;
    }

    public String getGsid() {
        return gsid;
    }

    public void setGsid(String gsid) {
        this.gsid = gsid;
    }

    public String getCcry() {
        return ccry;
    }

    public void setCcry(String ccry) {
        this.ccry = ccry;
    }

    public String getMdd() {
        return mdd;
    }

    public void setMdd(String mdd) {
        this.mdd = mdd;
    }

    public String getCcrqs() {
        return ccrqs;
    }

    public void setCcrqs(String ccrqs) {
        this.ccrqs = ccrqs;
    }

    public String getCcrqz() {
        return ccrqz;
    }

    public void setCcrqz(String ccrqz) {
        this.ccrqz = ccrqz;
    }

    public String getDjzt() {
        return djzt;
    }

    public void setDjzt(String djzt) {
        this.djzt = djzt;
    }

    public String getSqrxm() {
        return sqrxm;
    }

    public void setSqrxm(String sqrxm) {
        this.sqrxm = sqrxm;
    }

    public String getSqbm() {
        return sqbm;
    }

    public void setSqbm(String sqbm) {
        this.sqbm = sqbm;
    }

    public String getSqrsj() {
        return sqrsj;
    }

    public void setSqrsj(String sqrsj) {
        this.sqrsj = sqrsj;
    }

    public String getSqsj() {
        return sqsj;
    }

    public void setSqsj(String sqsj) {
        this.sqsj = sqsj;
    }

    public String getSssj() {
        return sssj;
    }

    public void setSssj(String sssj) {
        this.sssj = sssj;
    }

    public String getSpsj() {
        return spsj;
    }

    public void setSpsj(String spsj) {
        this.spsj = spsj;
    }

    public String getCbzxbh() {
        return cbzxbh;
    }

    public void setCbzxbh(String cbzxbh) {
        this.cbzxbh = cbzxbh;
    }

    public String getCbzxmc() {
        return cbzxmc;
    }

    public void setCbzxmc(String cbzxmc) {
        this.cbzxmc = cbzxmc;
    }

    public String getXmbh() {
        return xmbh;
    }

    public void setXmbh(String xmbh) {
        this.xmbh = xmbh;
    }

    public String getXmmc() {
        return xmmc;
    }

    public void setXmmc(String xmmc) {
        this.xmmc = xmmc;
    }

    public String getBxr() {
        return bxr;
    }

    public void setBxr(String bxr) {
        this.bxr = bxr;
    }

    public Integer getSfss() {
        return sfss;
    }

    public void setSfss(Integer sfss) {
        this.sfss = sfss;
    }

    public String getCclx() {
        return cclx;
    }

    public void setCclx(String cclx) {
        this.cclx = cclx;
    }

    public String getSprxm() {
        return sprxm;
    }

    public void setSprxm(String sprxm) {
        this.sprxm = sprxm;
    }

    public String getJkr() {
        return jkr;
    }

    public void setJkr(String jkr) {
        this.jkr = jkr;
    }

    public String getCfd() {
        return cfd;
    }

    public void setCfd(String cfd) {
        this.cfd = cfd;
    }

    public String getCfdbh() {
        return cfdbh;
    }

    public void setCfdbh(String cfdbh) {
        this.cfdbh = cfdbh;
    }

    public String getMddbh() {
        return mddbh;
    }

    public void setMddbh(String mddbh) {
        this.mddbh = mddbh;
    }

    public String getJzje() {
        return jzje;
    }

    public void setJzje(String jzje) {
        this.jzje = jzje;
    }

    public String getBxzt() {
        return bxzt;
    }

    public void setBxzt(String bxzt) {
        this.bxzt = bxzt;
    }

    public String getSjccrqz() {
        return sjccrqz;
    }

    public void setSjccrqz(String sjccrqz) {
        this.sjccrqz = sjccrqz;
    }

    public String getBxdh() {
        return bxdh;
    }

    public void setBxdh(String bxdh) {
        this.bxdh = bxdh;
    }

    public String getCcsfwc() {
        return ccsfwc;
    }

    public void setCcsfwc(String ccsfwc) {
        this.ccsfwc = ccsfwc;
    }

    public String getSqrid() {
        return sqrid;
    }

    public void setSqrid(String sqrid) {
        this.sqrid = sqrid;
    }

    public String getSprid() {
        return sprid;
    }

    public void setSprid(String sprid) {
        this.sprid = sprid;
    }

    public String getCcsy() {
        return ccsy;
    }

    public void setCcsy(String ccsy) {
        this.ccsy = ccsy;
    }
}
