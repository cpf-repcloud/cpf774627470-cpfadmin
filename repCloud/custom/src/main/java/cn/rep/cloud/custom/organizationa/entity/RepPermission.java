package cn.rep.cloud.custom.organizationa.entity;


import javax.persistence.*;
import java.io.Serializable;

/**
 * 权限表
 */
@Entity
@Table(name = "rep_permission")
public class RepPermission  implements Serializable {

	/**
	 * 主键id
	 */
	@Id
	private String id;
	/**
	 * 部门id
	 */
	private String deptid;
	/**
	 * 公司id
	 */
	private String compid;
	/**
	 * 角色id
	 */
	private String ruleid;
	/**
	 * 员工id
	 */
	private String userid;
	/**
	 * 模块id
	 */
	private String modularid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getCompid() {
		return compid;
	}

	public void setCompid(String compid) {
		this.compid = compid;
	}

	public String getRuleid() {
		return ruleid;
	}

	public void setRuleid(String ruleid) {
		this.ruleid = ruleid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getModularid() {
		return modularid;
	}

	public void setModularid(String modularid) {
		this.modularid = modularid;
	}
}
