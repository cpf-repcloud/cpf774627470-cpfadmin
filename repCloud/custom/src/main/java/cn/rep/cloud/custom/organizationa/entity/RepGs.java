package cn.rep.cloud.custom.organizationa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description  
 * @Author  hyg
 * @Date 2019-03-27 
 */

@Entity
@Table ( name ="rep_gs" )
public class RepGs  implements Serializable {

	private static final long serialVersionUID =  6659210305133946876L;

	/**
	 * ID(主键)
	 */
	@Id
   	@Column(name = "id" )
	private String id;

	/**
	 * 企业编号
	 */
   	@Column(name = "qybh" )
	private String qybh;

	/**
	 * 编号
	 */
   	@Column(name = "bh" )
	private String bh;

	/**
	 * 类型(1集团公司 2子公司 3.分公司)
	 */
   	@Column(name = "lx" )
	private String lx;

	/**
	 * 公司名称(全称)
	 */
   	@Column(name = "mc" )
	private String mc;

	/**
	 * 简称
	 */
   	@Column(name = "jc" )
	private String jc;

	/**
	 * 上级id(none表示无上级公司)
	 */
   	@Column(name = "sjid" )
	private String sjid;

	/**
	 * 所在国家
	 */
   	@Column(name = "szgj" )
	private String szgj;

	/**
	 * 所在省份
	 */
   	@Column(name = "szsf" )
	private String szsf;

	/**
	 * 所在城市
	 */
   	@Column(name = "szcs" )
	private String szcs;

	/**
	 * 详细地址
	 */
   	@Column(name = "xxdz" )
	private String xxdz;

	/**
	 * 公司法人
	 */
   	@Column(name = "gsfr" )
	private String gsfr;

	/**
	 * 公司电话
	 */
   	@Column(name = "gsdh" )
	private String gsdh;

	/**
	 * 公司网站
	 */
   	@Column(name = "gswz" )
	private String gswz;

	/**
	 * 公司LOGO
	 */
   	@Column(name = "logo" )
	private String logo;

	/**
	 * 状态(1有效 0 无效)
	 */
   	@Column(name = "zt" )
	private String zt;

	/**
	 * 银行账户名
	 */
   	@Column(name = "yhzhm" )
	private String yhzhm;

	/**
	 * 银行开户行
	 */
   	@Column(name = "yhkhh" )
	private String yhkhh;

	/**
	 * 银行账号
	 */
   	@Column(name = "yhzh" )
	private String yhzh;

	/**
	 * 纳税人识别号
	 */
   	@Column(name = "nsrsbh" )
	private String nsrsbh;

	/**
	 * 默认语种
	 */
   	@Column(name = "mryz" )
	private String mryz;

	/**
	 * 本位币种
	 */
   	@Column(name = "bwbz" )
	private String bwbz;

	/**
	 * 创建人ID(来源员工表)
	 */
   	@Column(name = "cjr" )
	private String cjr;

	/**
	 * 创建时间
	 */
   	@Column(name = "cjsj" )
	private Date cjsj;

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

	public String getBh() {
		return this.bh;
	}

	public void setBh(String bh) {
		this.bh = bh;
	}

	public String getLx() {
		return this.lx;
	}

	public void setLx(String lx) {
		this.lx = lx;
	}

	public String getMc() {
		return this.mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	public String getJc() {
		return this.jc;
	}

	public void setJc(String jc) {
		this.jc = jc;
	}

	public String getSjid() {
		return this.sjid;
	}

	public void setSjid(String sjid) {
		this.sjid = sjid;
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

	public String getSzcs() {
		return this.szcs;
	}

	public void setSzcs(String szcs) {
		this.szcs = szcs;
	}

	public String getXxdz() {
		return this.xxdz;
	}

	public void setXxdz(String xxdz) {
		this.xxdz = xxdz;
	}

	public String getGsfr() {
		return this.gsfr;
	}

	public void setGsfr(String gsfr) {
		this.gsfr = gsfr;
	}

	public String getGsdh() {
		return this.gsdh;
	}

	public void setGsdh(String gsdh) {
		this.gsdh = gsdh;
	}

	public String getGswz() {
		return this.gswz;
	}

	public void setGswz(String gswz) {
		this.gswz = gswz;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getZt() {
		return this.zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
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

	public String getNsrsbh() {
		return this.nsrsbh;
	}

	public void setNsrsbh(String nsrsbh) {
		this.nsrsbh = nsrsbh;
	}

	public String getMryz() {
		return this.mryz;
	}

	public void setMryz(String mryz) {
		this.mryz = mryz;
	}

	public String getBwbz() {
		return this.bwbz;
	}

	public void setBwbz(String bwbz) {
		this.bwbz = bwbz;
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
