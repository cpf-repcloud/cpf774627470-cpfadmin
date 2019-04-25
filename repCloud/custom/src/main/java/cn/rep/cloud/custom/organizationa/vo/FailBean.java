package cn.rep.cloud.custom.organizationa.vo;

public class FailBean {
    /**
     * id
     */
    private String id;
    /**
     * 编号
     */
    private String bh;
    /**
     * 名称
     */
    private String mc;
    /**
     * 原因
     */
    private String message;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
