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

@Table ( name ="rep_country" )
public class RepCountry  implements Serializable {

	private static final long serialVersionUID =  3331491151396073461L;

	/**
	 * 主键id
	 */
   	@Column(name = "id" )
	@Id
	private String id;

	/**
	 * 国家名称
	 */
   	@Column(name = "mc" )
	private String mc;

	/**
	 * 英文名称
	 */
   	@Column(name = "ywmc" )
	private String ywmc;

	/**
	 * 顺序号
	 */
   	@Column(name = "sxh" )
	private String sxh;

	/**
	 * 父级id
	 */
   	@Column(name = "parid" )
	private String parid;

	/**
	 * 类别
	 */
   	@Column(name = "lb" )
	private String lb;

	/**
	 * 备用1
	 */
   	@Column(name = "by1" )
	private String by1;

	/**
	 * 备用2(代号)
	 */
   	@Column(name = "by2" )
	private String by2;

	/**
	 * 备用3(代号简称)
	 */
   	@Column(name = "by3" )
	private String by3;

	/**
	 * 备用4
	 */
   	@Column(name = "by4" )
	private String by4;

	/**
	 * 备用5
	 */
   	@Column(name = "by5" )
	private String by5;

	/**
	 * 备用6(所属洲际)
	 */
   	@Column(name = "by6" )
	private String by6;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getSxh() {
		return this.sxh;
	}

	public void setSxh(String sxh) {
		this.sxh = sxh;
	}

	public String getParid() {
		return this.parid;
	}

	public void setParid(String parid) {
		this.parid = parid;
	}

	public String getLb() {
		return this.lb;
	}

	public void setLb(String lb) {
		this.lb = lb;
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

	public String getBy4() {
		return this.by4;
	}

	public void setBy4(String by4) {
		this.by4 = by4;
	}

	public String getBy5() {
		return this.by5;
	}

	public void setBy5(String by5) {
		this.by5 = by5;
	}

	public String getBy6() {
		return this.by6;
	}

	public void setBy6(String by6) {
		this.by6 = by6;
	}

}
