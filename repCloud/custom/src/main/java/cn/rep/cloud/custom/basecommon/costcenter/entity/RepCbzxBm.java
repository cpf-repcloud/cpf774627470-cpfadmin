package cn.rep.cloud.custom.basecommon.costcenter.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 成本中心部门表
 * </p>
 *
 * @author chenyong
 * @since 2018-08-08
 */
@TableName("rep_cbzx_bm")
public class RepCbzxBm implements Serializable {

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
     * 成本中心ID
     */
        private String cbzxid;
        /**
     * 部门ID
     */
        private String bmid;
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

    public String getCbzxid() {
        return cbzxid;
    }

    public void setCbzxid(String cbzxid) {
        this.cbzxid = cbzxid;
    }

    public String getBmid() {
        return bmid;
    }

    public void setBmid(String bmid) {
        this.bmid = bmid;
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
