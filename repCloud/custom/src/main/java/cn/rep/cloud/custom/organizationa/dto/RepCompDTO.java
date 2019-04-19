package cn.rep.cloud.custom.organizationa.dto;


public class RepCompDTO {
    /**
     * 主键id
     */
    private String id;
    /**
     * 上级id
     */
    private String sjid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSjid() {
        return sjid;
    }

    public void setSjid(String sjid) {
        this.sjid = sjid;
    }
}
