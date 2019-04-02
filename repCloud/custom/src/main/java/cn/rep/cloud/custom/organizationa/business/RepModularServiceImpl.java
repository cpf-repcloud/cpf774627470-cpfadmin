package cn.rep.cloud.custom.organizationa.business;

import cn.rep.cloud.custom.coreutils.common.PageDTO;
import cn.rep.cloud.custom.coreutils.common.RepConstants;
import cn.rep.cloud.custom.coreutils.utils.DateUtils;
import cn.rep.cloud.custom.organizationa.dto.RepModularDTO;
import cn.rep.cloud.custom.organizationa.entity.RepModular;
import cn.rep.cloud.custom.organizationa.service.RepModularService;
import cn.rep.cloud.custom.organizationa.vo.RepModularVO;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RepModularServiceImpl {
    /**
     * 日志记录类
     */
    private static final Logger logger = LoggerFactory.getLogger(RepModularServiceImpl.class);
    /**
     * 模块数据提供服务
     */
    @Autowired
    private RepModularService repModularService;

    /**
     * 查询有效的模块
     * @return lists
     */
    public List<RepModularVO> getModular(){
        List<RepModularVO> lists = repModularService.getParentModular();
        for (RepModularVO prentVo : lists){
            String parentid = prentVo.getId();
            List<RepModularVO> childrenVos = repModularService.getChildrenModular(parentid);
            prentVo.setChildren(childrenVos);
        }
        return lists;
    }

    /**
     * 插入系统模块
     * @param dto 需要插入的模块数据
     * @return stu 是否成功
     */
    public boolean insertRepModular(RepModularDTO dto){
        dto.setId(DateUtils.getNo(6));
        if (StringUtils.isBlank(dto.getParentid())){
            dto.setParentid("none");
        }
        dto.setCreatuser("addmin");
        dto.setUpdateuser("addmin");
        dto.setCreattime(DateUtils.getNow());
        dto.setUpdatetime(DateUtils.getNow());
        dto.setIsdisabled(RepConstants.SFYX_YX);
        boolean istrue = repModularService.insertRepModular(dto);
        return istrue;
    }

    public Page<RepModular> seletPage(PageDTO<RepModularDTO> pageDTO){
        Page<RepModular> page =repModularService.selectPage(pageDTO);
        return page;
    }

    public List<RepModularVO> parentList(){
        List<RepModular> parentList =repModularService.parentList();
        List<RepModularVO> voList = new ArrayList<>();
        RepModularVO onevo = new RepModularVO();
        onevo.setValue("none");
        onevo.setLabel("设置为最上级");
        voList.add(onevo);
        for (RepModular modular : parentList){
            RepModularVO vo = new RepModularVO();
            vo.setLabel(modular.getName());
            vo.setValue(modular.getId());
            voList.add(vo);
        }
        return voList;
    }

    /**
     * 插入系统模块
     * @param dto 需要插入的模块数据
     * @return stu 是否成功
     */
    public boolean updateRepModular(RepModularDTO dto){
        dto.setCreattime(DateUtils.getNow());
        dto.setUpdatetime(DateUtils.getNow());
        return repModularService.updateRepModular(dto);
    }

    /**
     * 删除
     * @param dto
     * @return
     */
    public boolean deleteRepModular(RepModularDTO dto){
        return repModularService.deleteRepModular(dto);
    }

}
