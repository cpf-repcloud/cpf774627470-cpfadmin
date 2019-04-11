package cn.rep.cloud.custom.organizationa.vo;

import cn.rep.cloud.custom.organizationa.entity.RepYg;

import java.util.Date;
import java.util.List;

public class RepEmployeeBean {

    /**
     * 员工信息
     */
    private RepYg repYg;
    /**
     * 菜单信息
     */
    private List<RepModularVO> menuList;

    public RepYg getRepYg() {
        return repYg;
    }

    public void setRepYg(RepYg repYg) {
        this.repYg = repYg;
    }

    public List<RepModularVO> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<RepModularVO> menuList) {
        this.menuList = menuList;
    }
}
