package cn.rep.cloud.custom.organizationa.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 部门表
 */
@Entity
@Table(name = "rep_dept")
public class RepDept  implements Serializable {

	/**
	 * 主键id
	 */
	@Id
	private String id;
	/**
	 * 部门名称
	 */
	private String deptmc;
	/**
	 * 部门编号
	 */
	private String deptbh;
	/**
	 * 上级编号
	 */
	private String suppernumber;
	/**
	 * 公司id
	 */
	private String compid;
	/**
	 * 公司名称
	 */
	private String compmc;
	/**
	 * 总公司
	 */
	private String zgs;
	/**
	 * 部门描述
	 */
	private String deptms;
	/**
	 * 部门电话
	 */
	private String deptphone;
	/**
	 * 部门邮箱
	 */
	private String deptemail;
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
	private String updatetime;
	/**
	 * 最后修改时间
	 */
	private String creattime;

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeptmc() {
		return deptmc;
	}

	public void setDeptmc(String deptmc) {
		this.deptmc = deptmc;
	}

	public String getDeptbh() {
		return deptbh;
	}

	public void setDeptbh(String deptbh) {
		this.deptbh = deptbh;
	}

	public String getSuppernumber() {
		return suppernumber;
	}

	public void setSuppernumber(String suppernumber) {
		this.suppernumber = suppernumber;
	}

	public String getCompid() {
		return compid;
	}

	public void setCompid(String compid) {
		this.compid = compid;
	}

	public String getCompmc() {
		return compmc;
	}

	public void setCompmc(String compmc) {
		this.compmc = compmc;
	}

	public String getZgs() {
		return zgs;
	}

	public void setZgs(String zgs) {
		this.zgs = zgs;
	}

	public String getDeptms() {
		return deptms;
	}

	public void setDeptms(String deptms) {
		this.deptms = deptms;
	}

	public String getDeptphone() {
		return deptphone;
	}

	public void setDeptphone(String deptphone) {
		this.deptphone = deptphone;
	}

	public String getDeptemail() {
		return deptemail;
	}

	public void setDeptemail(String deptemail) {
		this.deptemail = deptemail;
	}

	public String getIsdisabled() {
		return isdisabled;
	}

	public void setIsdisabled(String isdisabled) {
		this.isdisabled = isdisabled;
	}
}
