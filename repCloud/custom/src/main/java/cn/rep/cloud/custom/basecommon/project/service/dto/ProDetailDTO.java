package cn.rep.cloud.custom.basecommon.project.service.dto;

/**
 * Created by vetech on 2018/8/9.
 */
public class ProDetailDTO {

    /**
     * 所属公司
     */
    private String gsid;

    /**
     * 所属部门
     */
    private String bmid;

    /**
     * 所属员工id
     */
    private String id;

    /**
     * 角色编号 成员角色 1 项目经理  2 项目总监 3 项目联系人 4 普通成员
     *
     * @return
     */
    private String cyjs;


    public String getCyjs() {
        return cyjs;
    }

    public void setCyjs(String cyjs) {
        this.cyjs = cyjs;
    }


    public String getGsid() {
        return gsid;
    }

    public void setGsid(String gsid) {
        this.gsid = gsid;
    }

    public String getBmid() {
        return bmid;
    }

    public void setBmid(String bmid) {
        this.bmid = bmid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
