package cn.rep.cloud.custom.basecommon.costcenter.business;


import cn.rep.cloud.custom.basecommon.costcenter.entity.RepCbzx;
import cn.rep.cloud.custom.basecommon.costcenter.mapper.RepCbzxMapper;
import cn.rep.cloud.custom.basecommon.costcenter.service.dto.CostCenterListDTO;
import cn.rep.cloud.custom.basecommon.costcenter.service.dto.CostCenterManagementDTO;
import cn.rep.cloud.custom.basecommon.costcenter.service.dto.DataSendsDTO;
import cn.rep.cloud.custom.basecommon.costcenter.service.vo.CostCenterPageListVO;
import cn.rep.cloud.custom.coreutils.common.PageCopyUtil;
import cn.rep.cloud.custom.coreutils.common.PageDTO;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 成本中心表 服务实现类
 * </p>
 *
 * @author chenyong
 * @since 2018-08-06
 */
@Service
public class RepCbzxServiceImpl {
    
    @Autowired
    private RepCbzxMapper repCbzxMapper;
    /**
     * 成本中心分页列表
     *
     * @param pageDTO 查询条件
     * @return Page<CostCenterPageListVO>
     * @author yangxianglin
     * @date 2018-08-06 11:23:15
     */
    public Page<CostCenterPageListVO> selectCostCenterPageList(PageDTO<CostCenterListDTO> pageDTO) {
        Page<CostCenterPageListVO> page = PageCopyUtil.genPage(pageDTO);
        List<CostCenterPageListVO> list = repCbzxMapper.selectCostCenterPageList(page, pageDTO.getData());
        page.setRecords(list);
        return page;
    }

    /**
     * 根据成本中心id查询详情
     *
     * @param id 成本中心主键id
     * @return RepCbzx
     * @author yangxianglin
     * @date 2018-08-06 11:35:36
     */
    public RepCbzx selectVeCbzxById(String id) {
        return repCbzxMapper.selectById(id);
    }

    /**
     * 根据企业编号查询成本中心数据
     *
     * @param repCbzx 成本中心对象
     * @return List<RepCbzx>
     * @author yangxianglin
     * @date 2018-08-06 11:35:36
     */
    public List<RepCbzx> selectVeCbzxListByQybh(RepCbzx repCbzx) {
        EntityWrapper<RepCbzx> ew = new EntityWrapper<RepCbzx>();
        ew.setEntity(repCbzx);
        return repCbzxMapper.selectList(ew);
    }

    /**
     * 根据成本中心编号查询成本中心信息
     *
     * @param repCbzx 成本中心对象
     * @return 成本中心对象
     */
    public RepCbzx getVeCbzxByCbzxbh(RepCbzx repCbzx) {
        return repCbzxMapper.selectOne(repCbzx);
    }

    /**
     * 新增成本中心数据
     *
     * @param repCbzx 成本中心
     * @return Boolean
     * @author yangxianglin
     * @date 2018-08-06 11:35:36
     */
    public Boolean insertCostCenter(RepCbzx repCbzx) {
        return repCbzxMapper.insert(repCbzx) >0 ? Boolean.TRUE : Boolean.FALSE;
    }

    /**
     * 编辑成本中心数据
     *
     * @param repCbzx 成本中心
     * @return Boolean
     * @author yangxianglin
     * @date 2018-08-06 11:35:36
     */
    public Boolean updateCostCenter(RepCbzx repCbzx) {
        return repCbzxMapper.updateById(repCbzx)>0 ? Boolean.TRUE : Boolean.FALSE;
    }


    /**
     * 根据企业编号查询成本中心列表
     *
     * @param listDTO 成本中心列表Dto
     * @return 成本中心
     */
    public List<RepCbzx> getVeCbzxList(CostCenterManagementDTO listDTO) {
        EntityWrapper<RepCbzx> ew = new EntityWrapper<RepCbzx>();
        RepCbzx repCbzx = new RepCbzx();
        if (StringUtils.isNotBlank(listDTO.getQybh())) {
            repCbzx.setQybh(listDTO.getQybh());
        }
        if (StringUtils.isNotBlank(listDTO.getGsid())) {
            repCbzx.setGsid(listDTO.getGsid());
        }
        ew.setEntity(repCbzx);
        if (StringUtils.isNotBlank(listDTO.getCbzxmc())) {
            ew.like("cbzxmc", listDTO.getCbzxmc());
        }
        return repCbzxMapper.selectList(ew);
    }

    /**
     * 成本中心分类查询
     * @param repCbzx 成本中心对象
     * @return 成本中心集合
     */
    public List<RepCbzx> queryVecbzxList(RepCbzx repCbzx){
        EntityWrapper<RepCbzx> ew = new EntityWrapper<RepCbzx>();
        ew.setEntity(repCbzx);
        return repCbzxMapper.selectList(ew);
    }

    /**
     * 根据条件查询成本中心集合
     * @param dto 入参对象
     * @return 成本中心集合
     */
    public List<RepCbzx> queryVecbzxLists(DataSendsDTO dto){
        EntityWrapper<RepCbzx> ew = new EntityWrapper<RepCbzx>();
        RepCbzx repCbzx = new RepCbzx();
        repCbzx.setQybh(dto.getQybh());
        if(StringUtils.isNotBlank(dto.getGsid())){
            repCbzx.setGsid(dto.getGsid());
        }
        repCbzx.setZt("1");
        ew.setEntity(repCbzx);
        if(CollectionUtils.isNotEmpty(dto.getGsdxflids())){
            ew.in("cbzxbh",dto.getGsdxflids());
        }
        if(CollectionUtils.isNotEmpty(dto.getGsids())){
            ew.in("gsid",dto.getGsids());
        }
        return repCbzxMapper.selectList(ew);
    }

    /**
     * 批量新增或修改成本中心数据
     * @param repCbzxes 成本中心数据集合
     * @return 是否成功
     */
    public boolean createOrUpdateBatch(List<RepCbzx> repCbzxes){
        for(RepCbzx czx: repCbzxes){
            if(StringUtils.isNotBlank(czx.getId())){
                repCbzxMapper.updateById(czx);
            }else{
                repCbzxMapper.insert(czx);
            }

        }
        return Boolean.TRUE;
    }

}