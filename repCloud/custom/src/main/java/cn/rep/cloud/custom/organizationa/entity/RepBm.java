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
@Table ( name ="rep_bm" )
public class RepBm  implements Serializable {

	private static final long serialVersionUID =  4403952364249098722L;

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
	 * 部门编号(同一企业下的部门编号要唯一)
	 */
   	@Column(name = "bh" )
	private String bh;

	/**
	 * 部门名称(全称)
	 */
   	@Column(name = "mc" )
	private String mc;

	/**
	 * 简称
	 */
   	@Column(name = "jc" )
	private String jc;

	/**
	 * 上级id(none表示无上级部门)
	 */
   	@Column(name = "sjid" )
	private String sjid;

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
	 * 所在地址
	 */
   	@Column(name = "szdz" )
	private String szdz;

	/**
	 * 部门负责人(员工任职ID)
	 */
   	@Column(name = "bmfzr" )
	private String bmfzr;

	/**
	 * 部门电话
	 */
   	@Column(name = "bmdh" )
	private String bmdh;

	/**
	 * 所属公司ID(直属公司，不管所属公司的上级公司是哪个)
	 */
   	@Column(name = "ssgsid" )
	private String ssgsid;

	/**
	 * 财务主管(员工任职ID)
	 */
   	@Column(name = "cwzg" )
	private String cwzg;

	/**
	 * 是否自动生成成本中心(1 是 0 否)
	 */
   	@Column(name = "sfzdsccbzx" )
	private String sfzdsccbzx;

	/**
	 * 状态(0 无效1 有效)
	 */
   	@Column(name = "zt" )
	private String zt;

	/**
	 * 创建人ID(来源于员工ID)
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

	public String getSzdz() {
		return this.szdz;
	}

	public void setSzdz(String szdz) {
		this.szdz = szdz;
	}

	public String getBmfzr() {
		return this.bmfzr;
	}

	public void setBmfzr(String bmfzr) {
		this.bmfzr = bmfzr;
	}

	public String getBmdh() {
		return this.bmdh;
	}

	public void setBmdh(String bmdh) {
		this.bmdh = bmdh;
	}

	public String getSsgsid() {
		return this.ssgsid;
	}

	public void setSsgsid(String ssgsid) {
		this.ssgsid = ssgsid;
	}

	public String getCwzg() {
		return this.cwzg;
	}

	public void setCwzg(String cwzg) {
		this.cwzg = cwzg;
	}

	public String getSfzdsccbzx() {
		return this.sfzdsccbzx;
	}

	public void setSfzdsccbzx(String sfzdsccbzx) {
		this.sfzdsccbzx = sfzdsccbzx;
	}

	public String getZt() {
		return this.zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
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
