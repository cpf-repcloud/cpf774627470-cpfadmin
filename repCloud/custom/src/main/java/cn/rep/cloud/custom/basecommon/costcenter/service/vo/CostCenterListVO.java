package cn.rep.cloud.custom.basecommon.costcenter.service.vo;

import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

/**
 * 成本中心列表数据
 * Created by vetech on 2018/8/6.
 */
public class CostCenterListVO {
    /**
     * 成本中心主键id
     */
    private String id;
    /**
     * 成本中心编号
     */
    private String cbzxbh;
    /**
     * 成本中心名称
     */
    private String cbzxmc;
    /**
     * 状态
     */
    private String zt;
    /**
     * 员工列表数据分页集合
     */
    private Page<CostCenterPageListVO> pageList;
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

    public Page<CostCenterPageListVO> getPageList() {
        return pageList;
    }

    public void setPageList(Page<CostCenterPageListVO> pageList) {
        this.pageList = pageList;
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

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }


}
