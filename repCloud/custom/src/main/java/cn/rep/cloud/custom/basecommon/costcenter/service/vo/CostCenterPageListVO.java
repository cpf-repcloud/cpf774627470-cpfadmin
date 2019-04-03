package cn.rep.cloud.custom.basecommon.costcenter.service.vo;

import cn.rep.cloud.custom.coreutils.utils.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import freemarker.template.utility.DateUtil;

import java.util.Date;

/**
 * 成本中心列表分页对象数据
 * Created by vetech on 2018/8/6.
 */
public class CostCenterPageListVO {
    /**
     * 成本中心主键id
     */
    private String id;
    /**
     * 成本中心编号
     */
    private String cbzxbh;
    /**
     * 上级编号
     */
    private String sjbh;
    /**
     * 成本中心名称
     */
    private String cbzxmc;
    /**
     * 成本中心项目状态
     */
    private String zt;
    /**
     * 最后修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date zhxgsj;
    /**
     * 关联部门名称
     */
    private String glbmmc;
    /**
     * 关联项目名称
     */
    private String glxmmc;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public Date getZhxgsj() {
        return zhxgsj;
    }

    public void setZhxgsj(Date zhxgsj) {
        this.zhxgsj = zhxgsj;
    }

    public String getSjbh() {
        return sjbh;
    }

    public void setSjbh(String sjbh) {
        this.sjbh = sjbh;
    }

    public String getGlbmmc() {
        return glbmmc;
    }

    public void setGlbmmc(String glbmmc) {
        this.glbmmc = glbmmc;
    }

    public String getGlxmmc() {
        return glxmmc;
    }

    public void setGlxmmc(String glxmmc) {
        this.glxmmc = glxmmc;
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
