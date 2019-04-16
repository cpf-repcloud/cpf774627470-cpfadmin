package cn.rep.cloud.custom.basecommon.post.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * <p>
 * 企业岗位表
 * </p>
 *
 * @author chenyong
 * @since 2018-07-10
 */
@TableName("rep_gw")
public class RepGw {

    private static final long serialVersionUID = 1L;

    /**
     * ID(主键)
     */
    @TableId("id")

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
     * 下发来源ID
     */
    private String xflyid;

    /**
     * 下发来源公司ID
     */
    private String xflygsid;

    /**
     * 下发时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date xfsj;

    /**
     * 公司ID
     */
    private String gsid;

    /**
     * 创建人
     */
    private String cjr;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date cjsj;
    /**
     * 最后修改人
     */
    private String zhxgr;
    /**
     * 最后修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date zhxgsj;
    /**
     * 最后修改IP
     */
    private String ip;


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

    public String getXflyid() {
        return xflyid;
    }

    public void setXflyid(String xflyid) {
        this.xflyid = xflyid;
    }

    public String getXflygsid() {
        return xflygsid;
    }

    public void setXflygsid(String xflygsid) {
        this.xflygsid = xflygsid;
    }

    public Date getXfsj() {
        return xfsj;
    }

    public void setXfsj(Date xfsj) {
        this.xfsj = xfsj;
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

    public Date getCjsj() {
        return cjsj;
    }

    public void setCjsj(Date cjsj) {
        this.cjsj = cjsj;
    }

    public String getZhxgr() {
        return zhxgr;
    }

    public void setZhxgr(String zhxgr) {
        this.zhxgr = zhxgr;
    }

    public Date getZhxgsj() {
        return zhxgsj;
    }

    public void setZhxgsj(Date zhxgsj) {
        this.zhxgsj = zhxgsj;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

}
