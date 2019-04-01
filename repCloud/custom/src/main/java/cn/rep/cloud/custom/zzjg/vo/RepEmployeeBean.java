package cn.rep.cloud.custom.zzjg.vo;

import java.util.Date;
import java.util.List;

public class RepEmployeeBean {

    /**
     * 主键id
     */
    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 登录名
     */
    private String loginname;
    /**
     * 所在部门id
     */
    private String deptid;
    /**
     * 所在部门名称
     */
    private String deptmc;
    /**
     * 所在公司id
     */
    private String compid;
    /**
     * 所在公司名称
     */
    private String compmc;
    /**
     * 员工职级
     */
    private String rank;
    /**
     * 员工职级名称
     */
    private String rankname;
    /**
     * 权限
     */
    private String permission;
    /**
     * 岗位
     */
    private String post;
    /**
     * 岗位名称
     */
    private String postname;
    /**
     * 联系电话
     */
    private String phonenumber;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 微信账号
     */
    private String wechat;
    /**
     * QQ帐号
     */
    private String qq;
    /**
     * 性别
     */
    private String sexy;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 菜单信息
     */
    private List<RepModularVO> menuList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }

    public String getDeptmc() {
        return deptmc;
    }

    public void setDeptmc(String deptmc) {
        this.deptmc = deptmc;
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

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRankname() {
        return rankname;
    }

    public void setRankname(String rankname) {
        this.rankname = rankname;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPostname() {
        return postname;
    }

    public void setPostname(String postname) {
        this.postname = postname;
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

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getSexy() {
        return sexy;
    }

    public void setSexy(String sexy) {
        this.sexy = sexy;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<RepModularVO> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<RepModularVO> menuList) {
        this.menuList = menuList;
    }
}
