package cn.rep.cloud.custom.basecommon.post.dto;


import cn.hutool.json.JSONUtil;

import java.util.Date;

/**
 * Created by vetech on 2018/7/26.
 */
public class PostRankDataDTO {

    private String id;

    /**
     * 企业编号
     */
    private String qybh;



    /**
     * 岗位编号
     */
    private String gwbh;

    /**
     * 岗位名称
     */
    private String gwmc;


    /**
     * 岗位级别
     */
    private String gwjb;


    /**
     * 国际化编号
     */
    private String gjhbh;


    /**
     * 状态
     */
    private String zt;

    /**
     * 岗位描述
     */
    private String gwms;

    /**
     * 公司id
     */
    private String gsid;


    /**
     * 创建人
     * @return
     */
    private String cjr;

    /**
     * 创建时间
     * @return
     */
    private Date cjsj;

    /**
     * 最后修改人
     * @return
     */
    private String zhxgr;

    /**
     * 最后修改时间
     */
    private Date zhxgsj;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQybh() {
        return qybh;
    }

    public void setQybh(String qybh) {
        this.qybh = qybh;
    }

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

    public String getGwjb() {
        return gwjb;
    }

    public void setGwjb(String gwjb) {
        this.gwjb = gwjb;
    }

    public String getGjhbh() {
        return gjhbh;
    }

    public void setGjhbh(String gjhbh) {
        this.gjhbh = gjhbh;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public String getGwms() {
        return gwms;
    }

    public void setGwms(String gwms) {
        this.gwms = gwms;
    }

    public String getGsid() {
        return gsid;
    }

    public void setGsid(String gsid) {
        this.gsid = gsid;
    }

    public String getCjr() {
        return cjr;
    }

    public void setCjr(String cjr) {
        this.cjr = cjr;
    }



    public String getZhxgr() {
        return zhxgr;
    }

    public void setZhxgr(String zhxgr) {
        this.zhxgr = zhxgr;
    }

    public Date getCjsj() {
        return cjsj;
    }

    public void setCjsj(Date cjsj) {
        this.cjsj = cjsj;
    }

    public Date getZhxgsj() {
        return zhxgsj;
    }

    public void setZhxgsj(Date zhxgsj) {
        this.zhxgsj = zhxgsj;
    }

    @Override
    public String toString(){
        return JSONUtil.toJsonStr(this);
    }
}
