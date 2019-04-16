package cn.rep.cloud.custom.basecommon.post.dto;


import cn.hutool.json.JSONUtil;

/**
 * 员工岗位 查询入参
 * Created by vetech on 2018/7/26.
 */
public class PostRankSearchDTO {

    /**
     * 岗位编号
     */
    private String gwbh;

    /**
     * 岗位名称
     */
    private String gwmc;

    /**
     * 企业编号
     * @return
     */
    private  String qybh;

    /**
     * 公司id
     */
    private String gsid;



    public String getGwbh() {
        return gwbh;
    }

    public void setGwbh(String gwbh) {
        this.gwbh = gwbh;
    }

    public String getGwmc() {
        return gwmc;
    }

    public void setGwmc(String gwmc) {
        this.gwmc = gwmc;
    }

    public String getQybh() {
        return qybh;
    }

    public void setQybh(String qybh) {
        this.qybh = qybh;
    }

    public String getGsid() {
        return gsid;
    }

    public void setGsid(String gsid) {
        this.gsid = gsid;
    }
    @Override
    public String toString(){
        return JSONUtil.toJsonStr(this);
    }
}
