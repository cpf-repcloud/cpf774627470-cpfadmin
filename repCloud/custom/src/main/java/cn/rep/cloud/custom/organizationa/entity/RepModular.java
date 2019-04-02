package cn.rep.cloud.custom.organizationa.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 模块表
 */
@Entity
@Table(name = "rep_modular")
public class RepModular  implements Serializable {

	/**
	 * 主键id
	 */
	@Id
	private String id;
	/**
	 * 父级id
	 */
	private String parentid;
	/**
	 * url地址
	 */
	private String url;
	/**
	 * 模块名称
	 */
	private String name;
	/**
	 * 创建时间
	 */
	private Date creattime;
	/**
	 * 最后修改时间
	 */
	private Date updatetime;
	/**
	 * 创建人
	 */
	private String creatuser;
	/**
	 * 最后修改人
	 */
	private String updateuser;
	/**
	 * 角色id
	 */
	private String ruleid;
	/**
	 * 是否有效
	 */
	private String isdisabled;
	/**
	 * 顺序号
	 */
	private String sxh;

	public String getSxh() {
		return sxh;
	}

	public void setSxh(String sxh) {
		this.sxh = sxh;
	}

	public String getUpdateuser() {
		return updateuser;
	}

	public void setUpdateuser(String updateuser) {
		this.updateuser = updateuser;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreattime() {
		return creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getCreatuser() {
		return creatuser;
	}

	public void setCreatuser(String creatuser) {
		this.creatuser = creatuser;
	}

	public String getRuleid() {
		return ruleid;
	}

	public void setRuleid(String ruleid) {
		this.ruleid = ruleid;
	}

	public String getIsdisabled() {
		return isdisabled;
	}

	public void setIsdisabled(String isdisabled) {
		this.isdisabled = isdisabled;
	}
}
