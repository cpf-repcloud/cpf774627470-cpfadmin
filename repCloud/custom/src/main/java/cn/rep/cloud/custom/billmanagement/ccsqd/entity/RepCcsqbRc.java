package cn.rep.cloud.custom.billmanagement.ccsqd.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import javax.persistence.Entity;
import java.util.Date;

@TableName("rep_ccsqb_rc")
public class RepCcsqbRc {

    @TableId("id")
    private String  id ;
    private String  sqdh ;
    private String  mddid ;
    private String  mddmc ;
    /**出发时间*/
    private String  cfsj ;
    /**到达时间*/
    private String  ddsj ;
    /**顺序号*/
    private Integer  sxh ;

    /**
     * 创建时间
     */
    private Date cjsj;

    /**
     * 修改时间
     */
    private Date xgsj;

    /**
     * 交通工具名称
     * 1飞机
     2火车
     3汽车
     4其他
     */
    private String jtgj;
    /*** 单程往返*/
    private String dcwf;

    /*其他交通工具名称*/
    private String qtjtgj;


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

    public String getMddid() {
        return mddid;
    }

    public void setMddid(String mddid) {
        this.mddid = mddid;
    }

    public String getMddmc() {
        return mddmc;
    }

    public void setMddmc(String mddmc) {
        this.mddmc = mddmc;
    }

    public String getCfsj() {
        return cfsj;
    }

    public void setCfsj(String cfsj) {
        this.cfsj = cfsj;
    }

    public String getDdsj() {
        return ddsj;
    }

    public void setDdsj(String ddsj) {
        this.ddsj = ddsj;
    }

    public Integer getSxh() {
        return sxh;
    }

    public void setSxh(Integer sxh) {
        this.sxh = sxh;
    }

    public String getJtgj() {
        return jtgj;
    }

    public void setJtgj(String jtgj) {
        this.jtgj = jtgj;
    }

    public String getDcwf() {
        return dcwf;
    }

    public void setDcwf(String dcwf) {
        this.dcwf = dcwf;
    }

    public String getQtjtgj() {
        return qtjtgj;
    }

    public void setQtjtgj(String qtjtgj) {
        this.qtjtgj = qtjtgj;
    }
}
