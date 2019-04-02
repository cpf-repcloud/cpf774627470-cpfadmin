package cn.rep.cloud.custom.organizationa.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/***
 * 公司表
 */
@Entity
@Table(name = "rep_comp")
public class RepComp  implements Serializable {

	/**
	 * 主键id
	 */
	@Id
	private String id;
	/**
	 * 公司名称
	 */
	private String compmc;
	/**
	 * 公司简称
	 */
	private String compjc;
	/**
	 * 公司地址
	 */
	private String compaddress;
	/**
	 * 总公司
	 */
	private String zgs;
	/**
	 * 公司电话
	 */
	private String phonenumber;
	/**
	 * 公司邮箱
	 */
	private String email;
	/**
	 * 公司首页
	 */
	private String homepage;
	/**
	 * 公司主营
	 */
	private String business;
	/**
	 * 是否有效  1:有效  0:无效
	 */
	private String isdisabled;
	/**
	 * 创建人
	 */
	private String creatuser;
	/**
	 * 最后修改人
	 */
	private String updateuser;
	/**
	 * 创建时间
	 */
	private Date updatetime;
	/**
	 * 最后修改时间
	 */
	private Date creattime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompmc() {
		return compmc;
	}

	public void setCompmc(String compmc) {
		this.compmc = compmc;
	}

	public String getCompjc() {
		return compjc;
	}

	public void setCompjc(String compjc) {
		this.compjc = compjc;
	}

	public String getCompaddress() {
		return compaddress;
	}

	public void setCompaddress(String compaddress) {
		this.compaddress = compaddress;
	}

	public String getZgs() {
		return zgs;
	}

	public void setZgs(String zgs) {
		this.zgs = zgs;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public String getIsdisabled() {
		return isdisabled;
	}

	public void setIsdisabled(String isdisabled) {
		this.isdisabled = isdisabled;
	}

	public String getCreatuser() {
		return creatuser;
	}

	public void setCreatuser(String creatuser) {
		this.creatuser = creatuser;
	}

	public String getUpdateuser() {
		return updateuser;
	}

	public void setUpdateuser(String updateuser) {
		this.updateuser = updateuser;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public Date getCreattime() {
		return creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}
}
