package cn.rep.cloud.custom.basicdata.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Description  
 * @Author  hyg
 * @Date 2019-04-18 
 */

@Entity
@Table ( name ="rep_city" )
public class RepCity  implements Serializable {

	private static final long serialVersionUID =  2027071088060472370L;

	/**
	 * 编号主键
	 */
   	@Column(name = "bh" )
	@Id
	private String bh;

	/**
	 * 名称
	 */
   	@Column(name = "mc" )
	private String mc;

	/**
	 * 英文名称
	 */
   	@Column(name = "ywmc" )
	private String ywmc;

	/**
	 * 国内国际1国内，0国际
	 */
   	@Column(name = "gngj" )
	private String gngj;

	/**
	 * 所在国家数据字典中获取
	 */
   	@Column(name = "szgj" )
	private String szgj;

	/**
	 * 所在省份数据字典中获取
	 */
   	@Column(name = "szsf" )
	private String szsf;

	/**
	 * 城市简介
	 */
   	@Column(name = "csjj" )
	private String csjj;

	/**
	 * 电话区号
	 */
   	@Column(name = "dhqh" )
	private String dhqh;

	/**
	 * 邮政编码
	 */
   	@Column(name = "yzbm" )
	private String yzbm;

	/**
	 * 备注 存放城市的经纬度坐标
	 */
   	@Column(name = "bzbz" )
	private String bzbz;

	/**
	 * 备用一,用做城市区域来自于基础数据
	 */
   	@Column(name = "by1" )
	private String by1;

	/**
	 * 备用二,用做对应国家标准城市编号
	 */
   	@Column(name = "by2" )
	private String by2;

	/**
	 * 备用三,用做存入上级城市
	 */
   	@Column(name = "by3" )
	private String by3;

	/**
	 * 操作时间
	 */
   	@Column(name = "czdatetime" )
	private String czdatetime;

	/**
	 * 操作用户
	 */
   	@Column(name = "czuserid" )
	private String czuserid;

	/**
	 * 艺龙id
	 */
   	@Column(name = "ylid" )
	private String ylid;

	/**
	 * 航信id
	 */
   	@Column(name = "hxid" )
	private String hxid;

	/**
	 * 携程id
	 */
   	@Column(name = "xcid" )
	private String xcid;

	/**
	 * 是否热门城市1:是0:否
	 */
   	@Column(name = "sfrm" )
	private String sfrm;

	/**
	 * 是否省会/直辖城市 1省会城市 2直辖市 0无 3地州市 4县级市
	 */
   	@Column(name = "sfsh" )
	private String sfsh;

	/**
	 * 有无机场1:是0:否
	 */
   	@Column(name = "ywjc" )
	private String ywjc;

	/**
	 * 有无火车站1:是0:否
	 */
   	@Column(name = "ywhcz" )
	private String ywhcz;

	/**
	 * 座标id,与t_dzzb 表对应
	 */
   	@Column(name = "zbid" )
	private String zbid;

	/**
	 * 拼音检索码
	 */
   	@Column(name = "pyjsm" )
	private String pyjsm;

	/**
	 * 城市所属行政区，用于酒店和poi数据，对应ve_city_area表id
	 */
   	@Column(name = "xzq" )
	private String xzq;

	/**
	 * 是否旅游城市，1是，0否，默认为0
	 */
   	@Column(name = "sflycs" )
	private String sflycs;

	/**
	 * 滴滴id
	 */
   	@Column(name = "ddid" )
	private String ddid;

	/**
	 * 是否酒店城市，1是，0否，默认为0
	 */
   	@Column(name = "sfjdcs" )
	private String sfjdcs;

	/**
	 * 数据新增/修改/删除时操作的字段
	 */
   	@Column(name = "sequence" )
	private Long sequence;

	public String getBh() {
		return this.bh;
	}

	public void setBh(String bh) {
		this.bh = bh;
	}

	public String getMc() {
		return this.mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	public String getYwmc() {
		return this.ywmc;
	}

	public void setYwmc(String ywmc) {
		this.ywmc = ywmc;
	}

	public String getGngj() {
		return this.gngj;
	}

	public void setGngj(String gngj) {
		this.gngj = gngj;
	}

	public String getSzgj() {
		return this.szgj;
	}

	public void setSzgj(String szgj) {
		this.szgj = szgj;
	}

	public String getSzsf() {
		return this.szsf;
	}

	public void setSzsf(String szsf) {
		this.szsf = szsf;
	}

	public String getCsjj() {
		return this.csjj;
	}

	public void setCsjj(String csjj) {
		this.csjj = csjj;
	}

	public String getDhqh() {
		return this.dhqh;
	}

	public void setDhqh(String dhqh) {
		this.dhqh = dhqh;
	}

	public String getYzbm() {
		return this.yzbm;
	}

	public void setYzbm(String yzbm) {
		this.yzbm = yzbm;
	}

	public String getBzbz() {
		return this.bzbz;
	}

	public void setBzbz(String bzbz) {
		this.bzbz = bzbz;
	}

	public String getBy1() {
		return this.by1;
	}

	public void setBy1(String by1) {
		this.by1 = by1;
	}

	public String getBy2() {
		return this.by2;
	}

	public void setBy2(String by2) {
		this.by2 = by2;
	}

	public String getBy3() {
		return this.by3;
	}

	public void setBy3(String by3) {
		this.by3 = by3;
	}

	public String getCzdatetime() {
		return this.czdatetime;
	}

	public void setCzdatetime(String czdatetime) {
		this.czdatetime = czdatetime;
	}

	public String getCzuserid() {
		return this.czuserid;
	}

	public void setCzuserid(String czuserid) {
		this.czuserid = czuserid;
	}

	public String getYlid() {
		return this.ylid;
	}

	public void setYlid(String ylid) {
		this.ylid = ylid;
	}

	public String getHxid() {
		return this.hxid;
	}

	public void setHxid(String hxid) {
		this.hxid = hxid;
	}

	public String getXcid() {
		return this.xcid;
	}

	public void setXcid(String xcid) {
		this.xcid = xcid;
	}

	public String getSfrm() {
		return this.sfrm;
	}

	public void setSfrm(String sfrm) {
		this.sfrm = sfrm;
	}

	public String getSfsh() {
		return this.sfsh;
	}

	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}

	public String getYwjc() {
		return this.ywjc;
	}

	public void setYwjc(String ywjc) {
		this.ywjc = ywjc;
	}

	public String getYwhcz() {
		return this.ywhcz;
	}

	public void setYwhcz(String ywhcz) {
		this.ywhcz = ywhcz;
	}

	public String getZbid() {
		return this.zbid;
	}

	public void setZbid(String zbid) {
		this.zbid = zbid;
	}

	public String getPyjsm() {
		return this.pyjsm;
	}

	public void setPyjsm(String pyjsm) {
		this.pyjsm = pyjsm;
	}

	public String getXzq() {
		return this.xzq;
	}

	public void setXzq(String xzq) {
		this.xzq = xzq;
	}

	public String getSflycs() {
		return this.sflycs;
	}

	public void setSflycs(String sflycs) {
		this.sflycs = sflycs;
	}

	public String getDdid() {
		return this.ddid;
	}

	public void setDdid(String ddid) {
		this.ddid = ddid;
	}

	public String getSfjdcs() {
		return this.sfjdcs;
	}

	public void setSfjdcs(String sfjdcs) {
		this.sfjdcs = sfjdcs;
	}

	public Long getSequence() {
		return this.sequence;
	}

	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}

}
