package cn.rep.cloud.custom.organizationa.entity;

import cn.rep.cloud.custom.coreutils.jedis.RedisModel;

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
@Table ( name ="rep_yg" )
public class RepYg implements Serializable {

	private static final long serialVersionUID =  7830729778526719356L;

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
	 * 工号
	 */
   	@Column(name = "gh" )
	private String gh;

	/**
	 * 姓名
	 */
   	@Column(name = "xm" )
	private String xm;

	/**
	 * 英文姓名
	 */
   	@Column(name = "ywxm" )
	private String ywxm;

	/**
	 * 电话号码
	 */
   	@Column(name = "dhhm" )
	private String dhhm;

	/**
	 * 手机号码
	 */
   	@Column(name = "sjhm" )
	private String sjhm;

	/**
	 * 国际电话区号
	 */
   	@Column(name = "gjdhqh" )
	private String gjdhqh;

	/**
	 * 联系邮箱
	 */
   	@Column(name = "lxyx" )
	private String lxyx;

	/**
	 * 联系地址
	 */
   	@Column(name = "lxdz" )
	private String lxdz;

	/**
	 * 籍贯
	 */
   	@Column(name = "jg" )
	private String jg;

	/**
	 * 性别(M男，F女)
	 */
   	@Column(name = "xb" )
	private String xb;

	/**
	 * 生日(32489)
	 */
   	@Column(name = "sr" )
	private Date sr;

	/**
	 * 是否秘书(0 否，1 是）
	 */
   	@Column(name = "sfms" )
	private String sfms;

	/**
	 * 报销委托人
	 */
   	@Column(name = "bxwtr" )
	private String bxwtr;

	/**
	 * 常驻工作地
	 */
   	@Column(name = "czgzd" )
	private String czgzd;

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
	 * 数据权限类型（1 本人，2 本部门，3 本公司,4 指定部门）
	 */
   	@Column(name = "sjqxlx" )
	private String sjqxlx;

	/**
	 * 开通状态(0 未开启，1 已开通)
	 */
   	@Column(name = "ktzt" )
	private String ktzt;

	/**
	 * 个人图像
	 */
   	@Column(name = "grtx" )
	private String grtx;

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

	/**
	 * 公司id
	 */
	@Column(name = "gsid" )
	private String gsid;

	/**
	 * 公司名称
	 */
	@Column(name = "gsmc" )
	private String gsmc;

	/**
	 * 部门id
	 */
	@Column(name = "bmid" )
	private String bmid;

	/**
	 * 部门名称
	 */
	@Column(name = "bmmc" )
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
