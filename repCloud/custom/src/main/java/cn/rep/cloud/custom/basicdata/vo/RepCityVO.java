package cn.rep.cloud.custom.basicdata.vo;


public class RepCityVO{

    /**
     * 城市编号
     */
    private String bh;

    /**
     * 城市名称
     */
    private String mc;

    /**
     * 城市分类(热门城市,A-Z)
     */
    private String firstZ;

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

    public String getFirstZ() {
        return firstZ;
    }

    public void setFirstZ(String firstZ) {
        this.firstZ = firstZ;
    }
}
