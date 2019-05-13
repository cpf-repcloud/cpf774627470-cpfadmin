package cn.rep.cloud.custom.openapi.kjController.basecommon.cskj.bean;

import cn.rep.cloud.custom.openapi.kjController.baseBean.KjBaseResponse;

import javax.persistence.Column;
import java.util.List;

public class KjCsXlResponse extends KjBaseResponse {
    private String bh;

    /**
     * 名称
     */
    private String mc;

    /**
     * 英文名称
     */
    private String ywmc;

    /**
     * 国内国际1国内，0国际
     */
    private String gngj;

    /**
     * 所在国家数据字典中获取
     */
    private String szgj;

    /**
     * 所在省份数据字典中获取
     */
    private String szsf;

    /**
     * 城市简介
     */
    private String csjj;

    /**
     * 电话区号
     */
    private String dhqh;

    /**
     * 邮政编码
     */
    private String yzbm;

    /**
     * 备注 存放城市的经纬度坐标
     */
    private String bzbz;

    /**
     * 备用一,用做城市区域来自于基础数据
     */
    private String by1;

    /**
     * 备用二,用做对应国家标准城市编号
     */
    private String by2;

    /**
     * 备用三,用做存入上级城市
     */
    private String by3;

    /**
     * 操作时间
     */
    private String czdatetime;

    /**
     * 操作用户
     */
    private String czuserid;

    /**
     * 艺龙id
     */
    private String ylid;

    /**
     * 航信id
     */
    private String hxid;

    /**
     * 携程id
     */
    private String xcid;

    /**
     * 是否热门城市1:是0:否
     */
    private String sfrm;

    /**
     * 是否省会/直辖城市 1省会城市 2直辖市 0无 3地州市 4县级市
     */
    private String sfsh;

    /**
     * 有无机场1:是0:否
     */
    private String ywjc;

    /**
     * 有无火车站1:是0:否
     */
    private String ywhcz;

    /**
     * 座标id,与t_dzzb 表对应
     */
    private String zbid;

    /**
     * 拼音检索码
     */
    private String pyjsm;

    /**
     * 城市所属行政区，用于酒店和poi数据，对应ve_city_area表id
     */
    private String xzq;

    /**
     * 是否旅游城市，1是，0否，默认为0
     */
    private String sflycs;

    /**
     * 滴滴id
     */
    private String ddid;

    /**
     * 是否酒店城市，1是，0否，默认为0
     */
    private String sfjdcs;

    /**
     * 数据新增/修改/删除时操作的字段
     */
    private Long sequence;

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public String getYwmc() {
        return ywmc;
    }

    public void setYwmc(String ywmc) {
        this.ywmc = ywmc;
    }

    public String getGngj() {
        return gngj;
    }

    public void setGngj(String gngj) {
        this.gngj = gngj;
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

    public String getCsjj() {
        return csjj;
    }

    public void setCsjj(String csjj) {
        this.csjj = csjj;
    }

    public String getDhqh() {
        return dhqh;
    }

    public void setDhqh(String dhqh) {
        this.dhqh = dhqh;
    }

    public String getYzbm() {
        return yzbm;
    }

    public void setYzbm(String yzbm) {
        this.yzbm = yzbm;
    }

    public String getBzbz() {
        return bzbz;
    }

    public void setBzbz(String bzbz) {
        this.bzbz = bzbz;
    }

    public String getBy1() {
        return by1;
    }

    public void setBy1(String by1) {
        this.by1 = by1;
    }

    public String getBy2() {
        return by2;
    }

    public void setBy2(String by2) {
        this.by2 = by2;
    }

    public String getBy3() {
        return by3;
    }

    public void setBy3(String by3) {
        this.by3 = by3;
    }

    public String getCzdatetime() {
        return czdatetime;
    }

    public void setCzdatetime(String czdatetime) {
        this.czdatetime = czdatetime;
    }

    public String getCzuserid() {
        return czuserid;
    }

    public void setCzuserid(String czuserid) {
        this.czuserid = czuserid;
    }

    public String getYlid() {
        return ylid;
    }

    public void setYlid(String ylid) {
        this.ylid = ylid;
    }

    public String getHxid() {
        return hxid;
    }

    public void setHxid(String hxid) {
        this.hxid = hxid;
    }

    public String getXcid() {
        return xcid;
    }

    public void setXcid(String xcid) {
        this.xcid = xcid;
    }

    public String getSfrm() {
        return sfrm;
    }

    public void setSfrm(String sfrm) {
        this.sfrm = sfrm;
    }

    public String getSfsh() {
        return sfsh;
    }

    public void setSfsh(String sfsh) {
        this.sfsh = sfsh;
    }

    public String getYwjc() {
        return ywjc;
    }

    public void setYwjc(String ywjc) {
        this.ywjc = ywjc;
    }

    public String getYwhcz() {
        return ywhcz;
    }

    public void setYwhcz(String ywhcz) {
        this.ywhcz = ywhcz;
    }

    public String getZbid() {
        return zbid;
    }

    public void setZbid(String zbid) {
        this.zbid = zbid;
    }

    public String getPyjsm() {
        return pyjsm;
    }

    public void setPyjsm(String pyjsm) {
        this.pyjsm = pyjsm;
    }

    public String getXzq() {
        return xzq;
    }

    public void setXzq(String xzq) {
        this.xzq = xzq;
    }

    public String getSflycs() {
        return sflycs;
    }

    public void setSflycs(String sflycs) {
        this.sflycs = sflycs;
    }

    public String getDdid() {
        return ddid;
    }

    public void setDdid(String ddid) {
        this.ddid = ddid;
    }

    public String getSfjdcs() {
        return sfjdcs;
    }

    public void setSfjdcs(String sfjdcs) {
        this.sfjdcs = sfjdcs;
    }

    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }
}
