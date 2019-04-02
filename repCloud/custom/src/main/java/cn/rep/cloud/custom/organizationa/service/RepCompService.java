package cn.rep.cloud.custom.organizationa.service;

import cn.rep.cloud.custom.coreutils.common.PageCopyUtil;
import cn.rep.cloud.custom.coreutils.common.PageDTO;
import cn.rep.cloud.custom.coreutils.utils.BeanMapper;
import cn.rep.cloud.custom.organizationa.dto.RepCompDTO;
import cn.rep.cloud.custom.organizationa.entity.RepComp;
import cn.rep.cloud.custom.organizationa.mapper.RepCompMapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepCompService {
    @Autowired
    private RepCompMapper repCompMapper;

    /**
     * 分页查询
     * @param pageDTO
     * @return
     */
    public Page<RepComp> selectPage(PageDTO<RepCompDTO> pageDTO){
        Page<RepComp> page = PageCopyUtil.genPage(pageDTO);
        List<RepComp> list = repCompMapper.pagelist(page,pageDTO.getData());
        page.setRecords(list);
        return page;
    }

    /**
     * 插入系统模块
     * @param dto 需要插入的模块数据
     * @return stu 是否成功
     */
    public boolean insertRepComp(RepCompDTO dto){
        RepComp repComp = BeanMapper.map(dto,RepComp.class);
        int stu = 0;
        if (null != repComp){
            stu = repCompMapper.insert(repComp);
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
    public boolean updateRepComp(RepCompDTO dto){
        RepComp repComp = BeanMapper.map(dto,RepComp.class);
        int stu = 0;
        if (null != repComp && StringUtils.isNotBlank(repComp.getId())){
            stu = repCompMapper.updateById(repComp);
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
    public boolean deleteRepComp(RepCompDTO dto){
        RepComp repComp = BeanMapper.map(dto,RepComp.class);
        int stu = 0;
        if (null != repComp && StringUtils.isNotBlank(repComp.getId())){
            stu = repCompMapper.deleteById(repComp);
        }
        if (stu>0){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
