package cn.rep.cloud.custom.organizationa.service;

import cn.rep.cloud.custom.coreutils.common.PageCopyUtil;
import cn.rep.cloud.custom.coreutils.common.PageDTO;
import cn.rep.cloud.custom.coreutils.common.RepConstants;
import cn.rep.cloud.custom.coreutils.utils.BeanMapper;
import cn.rep.cloud.custom.organizationa.dto.RepModularDTO;
import cn.rep.cloud.custom.organizationa.entity.RepModular;
import cn.rep.cloud.custom.organizationa.mapper.RepModularMapper;
import cn.rep.cloud.custom.organizationa.vo.RepModularVO;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RepModularService {
    @Autowired
    private RepModularMapper repModularMapper;

    /**
     * 查询有效的模块
     * @return voList
     */
    public List<RepModularVO> getModular(){
        List<RepModularVO> voList = new ArrayList<>();
        EntityWrapper<RepModular> ew = new EntityWrapper<>();
        ew.eq("isdisabled",RepConstants.SFYX_YX);
        ew.orderBy("sxh");
        List<RepModular> modularList = repModularMapper.selectList(ew);
        voList = BeanMapper.mapList(modularList,RepModularVO.class);
        return voList;
    }

    /**
     * 查询有效的父级模块
     * @return voList
     */
    public List<RepModularVO> getParentModular(){
        List<RepModularVO> voList = new ArrayList<>();
        EntityWrapper<RepModular> ew = new EntityWrapper<>();
        ew.eq("isdisabled", RepConstants.SFYX_YX);
        ew.eq("parentid","none");
        ew.orderBy("sxh");
        List<RepModular> modularList = repModularMapper.selectList(ew);
        voList = BeanMapper.mapList(modularList,RepModularVO.class);
        return voList;
    }

    /**
     * 根据父级id查询有效的子集模块
     * @return voList
     */
    public List<RepModularVO> getChildrenModular(String parentid){
        List<RepModularVO> voList = new ArrayList<>();
        EntityWrapper<RepModular> ew = new EntityWrapper<>();
        ew.eq("isdisabled",RepConstants.SFYX_YX);
        ew.eq("parentid",parentid);
        ew.orderBy("sxh");
        List<RepModular> modularList = repModularMapper.selectList(ew);
        voList = BeanMapper.mapList(modularList,RepModularVO.class);
        return voList;
    }

    /**
     * 插入系统模块
     * @param dto 需要插入的模块数据
     * @return stu 是否成功
     */
    public boolean insertRepModular(RepModularDTO dto){
        RepModular repModular = BeanMapper.map(dto,RepModular.class);
        int stu = 0;
        if (null != repModular){
            stu = repModularMapper.insert(repModular);
        }
        if (stu>0){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 更新系统模块
     * @param dto 需要更新的模块数据
     * @return stu 是否成功
     */
    public boolean updateRepModular(RepModularDTO dto){
        RepModular repModular = BeanMapper.map(dto,RepModular.class);
        int stu = 0;
        if (null != repModular && StringUtils.isNotBlank(repModular.getId())){
            stu = repModularMapper.updateById(repModular);
        }
        if (stu>0){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 删除系统模块
     * @param dto 需要删除的模块数据
     * @return stu 是否成功
     */
    public boolean deleteRepModular(RepModularDTO dto){
        RepModular repModular = BeanMapper.map(dto,RepModular.class);
        int stu = 0;
        if (null != repModular && StringUtils.isNotBlank(repModular.getId())){
            stu = repModularMapper.deleteById(repModular);
        }
        if (stu>0){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 分页查询
     * @param pageDTO
     * @return
     */
    public Page<RepModular> selectPage(PageDTO<RepModularDTO> pageDTO){
        Page<RepModular> page = PageCopyUtil.genPage(pageDTO);
        List<RepModular> list = repModularMapper.pagelist(page,pageDTO.getData());
        page.setRecords(list);
        return page;
    }

    /**
     * 分页查询
     * @return
     */
    public List<RepModular> parentList(){
        EntityWrapper<RepModular> ew = new EntityWrapper<>();
        ew.eq("isdisabled",RepConstants.SFYX_YX);
        ew.eq("parentid","none");
        ew.orderBy("sxh");
        List<RepModular> modularList = repModularMapper.selectList(ew);
        return modularList;
    }

}
