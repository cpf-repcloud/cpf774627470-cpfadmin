package cn.rep.cloud.custom.organizationa.entity;


import javax.persistence.*;
import java.io.Serializable;

/**
 * 角色表
 */
@Entity
@Table(name = "rep_rule")
public class RepRule  implements Serializable {

	/**
	 * 主键id
	 */
	@Id
	private String id;
	/**
	 * 角色编号
	 */
	private String ruleno;
	/**
	 * 角色名称
	 */
	private String rule;
	/**
	 * 权限id
	 */
	private String permission;
	/**
	 * 是否有效
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
	private String updatetime;
	/**
	 * 最后修改时间
	 */
	private String creattime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRuleno() {
		return ruleno;
	}

	public void setRuleno(String ruleno) {
		this.ruleno = ruleno;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
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

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getCreattime() {
		return creattime;
	}

	public void setCreattime(String creattime) {
		this.creattime = creattime;
	}
}
