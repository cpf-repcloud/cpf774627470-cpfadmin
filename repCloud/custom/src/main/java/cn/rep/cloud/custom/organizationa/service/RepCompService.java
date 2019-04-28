package cn.rep.cloud.custom.organizationa.service;

import cn.rep.cloud.custom.coreutils.common.PageCopyUtil;
import cn.rep.cloud.custom.coreutils.common.PageDTO;
import cn.rep.cloud.custom.coreutils.utils.BeanMapper;
import cn.rep.cloud.custom.organizationa.dto.RepCompDTO;
import cn.rep.cloud.custom.organizationa.entity.RepGs;
import cn.rep.cloud.custom.organizationa.mapper.RepCompMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public Page<RepGs> selectPage(PageDTO<RepCompDTO> pageDTO){
        Page<RepGs> page = PageCopyUtil.genPage(pageDTO);
        List<RepGs> list = repCompMapper.pagelist(page,pageDTO.getData());
        page.setRecords(list);
        return page;
    }

    /**
     * 插入系统模块
     * @param dto 需要插入的模块数据
     * @return stu 是否成功
     */
    public boolean insertRepComp(RepCompDTO dto){
        RepGs repComp = BeanMapper.map(dto,RepGs.class);
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
     * 根据id查询公司
     * @param gsid
     * @return
     */
    public RepGs getGsById(String gsid){
        if (StringUtils.isBlank(gsid)) return null;
        RepGs repGs = repCompMapper.selectById(gsid);
        return repGs;
    }

    /**
     * 更新系统模块
     * @param dto 需要更新的模块数据
     * @return stu 是否成功
     */
    public boolean updateRepComp(RepCompDTO dto){
        RepGs repComp = BeanMapper.map(dto,RepGs.class);
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
        RepGs repComp = BeanMapper.map(dto,RepGs.class);
        int stu = 0;
        if (null != repComp && StringUtils.isNotBlank(repComp.getId())){
            stu = repCompMapper.deleteById(repComp);
        }
        if (stu>0){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 通过上级id查询所有公司(不传查询所有)
     * @param sjid 上级id
     * @return 公司集合
     */
    public List<RepGs> getRepList(String sjid){
        EntityWrapper<RepGs> ew = new EntityWrapper<>();
        if (StringUtils.isNotBlank(sjid)){
            ew.eq("sjid",sjid);
        }
        ew.orderBy("cjsj");
        return repCompMapper.selectList(ew);
    }

    /**
     * 查询公司页面头部面包屑
     * @param chrId 子id
     * @return
     */
    public List<String> getMbx(String chrId){
        return repCompMapper.getMbx(chrId);
    }

    /**
     * 根据公司编号查询公司
     * @param bh
     * @return
     */
    public RepGs getGsByBh(String bh){
        RepGs repGs = new RepGs();
        repGs.setBh(bh);
        return repCompMapper.selectOne(repGs);
    }
}
