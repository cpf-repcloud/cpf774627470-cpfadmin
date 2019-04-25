package cn.rep.cloud.custom.billmanagement.ccsqd.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import javax.persistence.Entity;
import java.util.Date;

@TableName("rep_ccsqb_ry")
public class RepCcsqbRy {

    @TableId("id")
    private String id;
    /***/
    private String sqdh;
    /***/
    private String ygid;
    private String ygxm;
    /**顺序号*/
    private Integer sxh;
    private String by1;
    private String by2;
    private String by3;
    /**是否申请人*/
    private String sfsqr;
    /**是否借款人*/
    private String sfjkr;
    /**成本中心*/
    private String cbzx;
    /**'出行人类型 1员工  2外部人员'*/
    private String cxrlx;
    /**消费额度*/
    private Double xfed;
    /**预算id*/
    private String ysid;
    /**部门id*/
    private String bmid;
    /**报销状态*/
    private String bxzt;
    /***/
    private String bxdh;
    private String by4;
    private String by5;


    /**
     * 创建时间
     */
    private Date cjsj;

    /**
     * 修改时间
     */
    private Date xgsj;


    public Date getCjsj() {
        return cjsj;
    }

    public void setCjsj(Date cjsj) {
        this.cjsj = cjsj;
    }

    public Date getXgsj() {
        return xgsj;
    }

    public void setXgsj(Date xgsj) {
        this.xgsj = xgsj;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSqdh() {
        return sqdh;
    }

    public void setSqdh(String sqdh) {
        this.sqdh = sqdh;
    }

    public String getYgid() {
        return ygid;
    }

    public void setYgid(String ygid) {
        this.ygid = ygid;
    }

    public String getYgxm() {
        return ygxm;
    }

    public void setYgxm(String ygxm) {
        this.ygxm = ygxm;
    }



    public String getBy1() {
        return by1;
    }

    public void setBy1(String by1) {
        this.by1 = by1;
    }

    public String getBy2() {
        return by2;
    }

    public void setBy2(String by2) {
        this.by2 = by2;
    }

    public String getBy3() {
        return by3;
    }

    public void setBy3(String by3) {
        this.by3 = by3;
    }

    public String getSfsqr() {
        return sfsqr;
    }

    public void setSfsqr(String sfsqr) {
        this.sfsqr = sfsqr;
    }

    public String getSfjkr() {
        return sfjkr;
    }

    public void setSfjkr(String sfjkr) {
        this.sfjkr = sfjkr;
    }

    public String getCbzx() {
        return cbzx;
    }

    public void setCbzx(String cbzx) {
        this.cbzx = cbzx;
    }

    public String getCxrlx() {
        return cxrlx;
    }

    public void setCxrlx(String cxrlx) {
        this.cxrlx = cxrlx;
    }

    public Integer getSxh() {
        return sxh;
    }

    public void setSxh(Integer sxh) {
        this.sxh = sxh;
    }

    public Double getXfed() {
        return xfed;
    }

    public void setXfed(Double xfed) {
        this.xfed = xfed;
    }

    public String getYsid() {
        return ysid;
    }

    public void setYsid(String ysid) {
        this.ysid = ysid;
    }

    public String getBmid() {
        return bmid;
    }

    public void setBmid(String bmid) {
        this.bmid = bmid;
    }

    public String getBxzt() {
        return bxzt;
    }

    public void setBxzt(String bxzt) {
        this.bxzt = bxzt;
    }

    public String getBxdh() {
        return bxdh;
    }

    public void setBxdh(String bxdh) {
        this.bxdh = bxdh;
    }

    public String getBy4() {
        return by4;
    }

    public void setBy4(String by4) {
        this.by4 = by4;
    }

    public String getBy5() {
        return by5;
    }

    public void setBy5(String by5) {
        this.by5 = by5;
    }
}
