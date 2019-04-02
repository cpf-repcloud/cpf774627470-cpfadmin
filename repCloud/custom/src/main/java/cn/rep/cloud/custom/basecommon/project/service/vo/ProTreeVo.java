package cn.rep.cloud.custom.basecommon.project.service.vo;

import cn.rep.cloud.custom.coreutils.utils.DateUtils;
import com.baomidou.mybatisplus.annotations.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by vetech on 2018/8/6.
 */
public class ProTreeVo {

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
     * 公司编号
     */
    private String gsid;
    /**
     * 项目编号
     */
    private String xmbh;
    /**
     * 上级编号(为 none 时则为一级)
     */
    private String sjbh;
    /**
     * 项目名称
     */
    private String xmmc;
    /**
     * 项目描述
     */
    private String xmms;
    /**
     * 项目开始日期
     */
    private String ksrqStr;

    /**
     * 开始日期
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date ksrq;
    /**
     * 项目结束日期
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date jsrq;

    /**
     * 结束日期Str类型
     * */
    private String jsrqStr;
    /**
     * 项目经理
     */
    private String xmjl;
    /**
     * 项目总监
     */
    private String xmzj;
    /**
     * 项目联系人
     */
    private String xmlxr;
    /**
     * 项目类型(取基础数据)
     */
    private String xmlx;
    /**
     * 项目预算
     */
    private BigDecimal xmys;
    /**
     * 是否独立预算(0 否，1 是)
     */
    private String sfdlys;
    /**
     * 流程ID(与审批流程定义关联)
     */
    private String lcid;
    /**
     * 项目状态(0 未开始，1 进行中 2已完成)
     */
    private String zt;
    /**
     * 是否公共项目(0 否，1 是)
     */
    private String sfggxm;
    /**
     * 备注
     */
    private String bzbz;
    /**
     * 创建人
     */
    private String cjr;
    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date cjsj;
    /**
     * 最后修改人
     */
    private String zhxgr;
    /**
     * 最后修改时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date zhxgsj;
    /**
     * 最后修改IP
     */
    private String ip;


    /**
     * 节点名称
     */
    private String title;

    /**
     * 是否展开
     */
    private String expand;

    /**
     * 是否有效
     */
    private String sfyx;

    /**
     * 项目经理名称
     */
    private String xmjlmc;

    /**
     * 项目经理工号
     */
    private String xmjlgh;

    /**
     *字节点
     */
    private List<ProTreeVo> children;
    /**
     * 结束日期的str方法
     * @return
     */
    public String getJsrqStr() {
        if(this.jsrq!=null){
            jsrqStr= DateUtils.formatToStr(this.ksrq,"yyyy-MM-dd");
        }else{
            jsrqStr="";
        }
        return jsrqStr;
    }

    public void setJsrqStr(String jsrqStr) {
        this.jsrqStr = jsrqStr;
    }




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

    public String getGsid() {
        return gsid;
    }

    public void setGsid(String gsid) {
        this.gsid = gsid;
    }

    public String getXmbh() {
        return xmbh;
    }

    public void setXmbh(String xmbh) {
        this.xmbh = xmbh;
    }

    public String getSjbh() {
        return sjbh;
    }

    public void setSjbh(String sjbh) {
        this.sjbh = sjbh;
    }

    public String getXmmc() {
        return xmmc;
    }

    public void setXmmc(String xmmc) {
        this.xmmc = xmmc;
    }

    public String getXmms() {
        return xmms;
    }

    public void setXmms(String xmms) {
        this.xmms = xmms;
    }

    /**
     * 获取开始日期的str类型
     * @return
     */
    public String getKsrqStr() {
        if(null!=ksrq){
            ksrqStr= DateUtils.formatToStr(ksrq,"yyyy-MM-dd");
        }else{
            ksrqStr="";
        }
        return ksrqStr;
    }

    public void setKsrqStr(String ksrqStr) {
        this.ksrqStr = ksrqStr;
    }

    public Date getKsrq() {
        return ksrq;
    }

    public void setKsrq(Date ksrq) {
        this.ksrq = ksrq;
    }

    public Date getJsrq() {
        return jsrq;
    }

    public void setJsrq(Date jsrq) {
        this.jsrq = jsrq;
    }

    public String getXmjl() {
        return xmjl;
    }

    public void setXmjl(String xmjl) {
        this.xmjl = xmjl;
    }

    public String getXmzj() {
        return xmzj;
    }

    public void setXmzj(String xmzj) {
        this.xmzj = xmzj;
    }

    public String getXmlxr() {
        return xmlxr;
    }

    public void setXmlxr(String xmlxr) {
        this.xmlxr = xmlxr;
    }

    public String getXmlx() {
        return xmlx;
    }

    public void setXmlx(String xmlx) {
        this.xmlx = xmlx;
    }

    public BigDecimal getXmys() {
        return xmys;
    }

    public void setXmys(BigDecimal xmys) {
        this.xmys = xmys;
    }

    public String getSfdlys() {
        return sfdlys;
    }

    public void setSfdlys(String sfdlys) {
        this.sfdlys = sfdlys;
    }

    public String getLcid() {
        return lcid;
    }

    public void setLcid(String lcid) {
        this.lcid = lcid;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public String getSfggxm() {
        return sfggxm;
    }

    public void setSfggxm(String sfggxm) {
        this.sfggxm = sfggxm;
    }

    public String getBzbz() {
        return bzbz;
    }

    public void setBzbz(String bzbz) {
        this.bzbz = bzbz;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExpand() {
        return expand;
    }

    public void setExpand(String expand) {
        this.expand = expand;
    }

    public List<ProTreeVo> getChildren() {
        return children;
    }

    public void setChildren(List<ProTreeVo> children) {
        this.children = children;
    }

    public String getSfyx() {
        return sfyx;
    }

    public void setSfyx(String sfyx) {
        this.sfyx = sfyx;
    }

    public String getXmjlmc() {
        return xmjlmc;
    }

    public void setXmjlmc(String xmjlmc) {
        this.xmjlmc = xmjlmc;
    }

    public String getXmjlgh() {
        return xmjlgh;
    }

    public void setXmjlgh(String xmjlgh) {
        this.xmjlgh = xmjlgh;
    }
}
