package cn.rep.cloud.custom.basecommon.post.dto;


import cn.hutool.json.JSONUtil;

/**
 * 查询岗位数据传参
 * Created by vetech on 2018/10/8.
 *
 * @author vetech
 */
public class SelectPostRankListDTO {
    /**
     * 企业编号
     ***/
    private String qybh;
    /**
     * 公司编号
     ***/
    private String gsid;
    /**
     * 搜索条件【可以指岗位编号、岗位名称、岗位级别】
     ***/
    private String sstj;

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

    public String getSstj() {
        return sstj;
    }

    public void setSstj(String sstj) {
        this.sstj = sstj;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

}
