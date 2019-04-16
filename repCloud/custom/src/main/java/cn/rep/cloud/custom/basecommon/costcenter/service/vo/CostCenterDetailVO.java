package cn.rep.cloud.custom.basecommon.costcenter.service.vo;


import cn.rep.cloud.custom.basecommon.costcenter.entity.RepCbzxBm;
import cn.rep.cloud.custom.basecommon.costcenter.entity.RepXmCbzx;
import cn.rep.cloud.custom.coreutils.utils.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * 成本中心详情信息展示数据
 * Created by vetech on 2018/8/6.
 */
public class CostCenterDetailVO {
    /**
     * ID(主键)
     */
    private String id;
    /**
     * 企业编号
     */
    private String qybh;
    /**
     * 公司编号
     */
    private String gsbh;
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
     * 关联部门id集合
     */
    private List<RepCbzxBm> bmList;
    /**
     * 关联项目id集合
     */
    private List<RepXmCbzx> xmList;



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

    public String getGsbh() {
        return gsbh;
    }

    public void setGsbh(String gsbh) {
        this.gsbh = gsbh;
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

    public List<RepCbzxBm> getBmList() {
        return bmList;
    }

    public void setBmList(List<RepCbzxBm> bmList) {
        this.bmList = bmList;
    }

    public List<RepXmCbzx> getXmList() {
        return xmList;
    }

    public void setXmList(List<RepXmCbzx> xmList) {
        this.xmList = xmList;
    }

    /*****
     * 最后修改时间转中文
     * @return String
     */
    public String getZhxgsjMC(){
        if(zhxgsj != null) {
            return DateUtils.formatToStr(zhxgsj, "yyyy-MM-dd HH:mm");
        }else {
            return "";
        }
    }


}
