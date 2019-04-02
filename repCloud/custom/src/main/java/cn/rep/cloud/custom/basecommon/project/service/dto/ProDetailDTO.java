package cn.rep.cloud.custom.basecommon.project.service.dto;

/**
 * Created by vetech on 2018/8/9.
 */
public class ProDetailDTO {

    /**
     * 所属公司
     */
    private String ssgsid;

    /**
     * 所属部门
     */
    private String ssbmid;

    /**
     * 所属员工id
     */
    private String ygrzid;

    /**
     * 角色编号
     *
     * @return
     */
    private String cyjs;


    public String getSsbmid() {
        return ssbmid;
    }

    public void setSsbmid(String ssbmid) {
        this.ssbmid = ssbmid;
    }

    public String getSsgsid() {
        return ssgsid;
    }

    public void setSsgsid(String ssgsid) {
        this.ssgsid = ssgsid;
    }

    public String getYgrzid() {
        return ygrzid;
    }

    public void setYgrzid(String ygrzid) {
        this.ygrzid = ygrzid;
    }

    public String getCyjs() {
        return cyjs;
    }

    public void setCyjs(String cyjs) {
        this.cyjs = cyjs;
    }
}
