package cn.rep.cloud.custom.basecommon.basedata.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("rep_jscjlb")
public class RepJscjlb implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID(主键)
     */
    @TableId("id")
    private String id;

    /**
     *
     */
    private String lb;
    /**
     *
     */
    private String lbmc;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLb() {
        return lb;
    }

    public void setLb(String lb) {
        this.lb = lb;
    }

    public String getLbmc() {
        return lbmc;
    }

    public void setLbmc(String lbmc) {
        this.lbmc = lbmc;
    }
}
