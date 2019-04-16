package cn.rep.cloud.custom.basecommon.costcenter.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 成本中心表
 * </p>
 *
 * @author chenyong
 * @since 2018-08-06
 */
@TableName("rep_cbzx")
public class RepCbzx implements Serializable {

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
     * 公司id
     */
    private String gsid;
    /**
     * 成本中心编号
     */
    private String cbzxbh;
    /**
     * 成本中心名称
     */
    private String cbzxmc;
    /**
     * 上级编号
     */
    private String sjbh;
    /**
     * 项目状态(0 无效，1 正常)
     */
    private String zt;
    /**
     * 是否独立预算(0 否，1 是)
     */
    private String sfdlys;
    /**
     * 备注
     */
    private String bzbz;
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

    public String getCbzxbh() {
        return cbzxbh;
    }

    public void setCbzxbh(String cbzxbh) {
        this.cbzxbh = cbzxbh;
    }

    public String getCbzxmc() {
        return cbzxmc;
    }

    public void setCbzxmc(String cbzxmc) {
        this.cbzxmc = cbzxmc;
    }

    public String getSjbh() {
        return sjbh;
    }

    public void setSjbh(String sjbh) {
        this.sjbh = sjbh;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public String getSfdlys() {
        return sfdlys;
    }

    public void setSfdlys(String sfdlys) {
        this.sfdlys = sfdlys;
    }

    public String getBzbz() {
        return bzbz;
    }

    public void setBzbz(String bzbz) {
        this.bzbz = bzbz;
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

    public String getGsid() {
        return gsid;
    }

    public void setGsid(String gsid) {
        this.gsid = gsid;
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


}
