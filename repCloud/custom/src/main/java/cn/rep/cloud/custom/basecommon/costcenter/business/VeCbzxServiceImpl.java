package cn.rep.cloud.custom.basecommon.costcenter.business;


import cn.rep.cloud.custom.basecommon.costcenter.entity.VeCbzx;
import cn.rep.cloud.custom.basecommon.costcenter.mapper.VeCbzxMapper;
import cn.rep.cloud.custom.basecommon.costcenter.service.dto.CostCenterListDTO;
import cn.rep.cloud.custom.basecommon.costcenter.service.dto.CostCenterManagementDTO;
import cn.rep.cloud.custom.basecommon.costcenter.service.dto.DataSendsDTO;
import cn.rep.cloud.custom.basecommon.costcenter.service.vo.CostCenterPageListVO;
import cn.rep.cloud.custom.coreutils.common.PageCopyUtil;
import cn.rep.cloud.custom.coreutils.common.PageDTO;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import com.sun.org.apache.xpath.internal.operations.Bool;
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
public class VeCbzxServiceImpl {
    
    @Autowired
    private VeCbzxMapper veCbzxMapper;
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
        List<CostCenterPageListVO> list = veCbzxMapper.selectCostCenterPageList(page, pageDTO.getData());
        page.setRecords(list);
        return page;
    }

    /**
     * 根据成本中心id查询详情
     *
     * @param id 成本中心主键id
     * @return VeCbzx
     * @author yangxianglin
     * @date 2018-08-06 11:35:36
     */
    public VeCbzx selectVeCbzxById(String id) {
        return veCbzxMapper.selectById(id);
    }

    /**
     * 根据企业编号查询成本中心数据
     *
     * @param veCbzx 成本中心对象
     * @return List<VeCbzx>
     * @author yangxianglin
     * @date 2018-08-06 11:35:36
     */
    public List<VeCbzx> selectVeCbzxListByQybh(VeCbzx veCbzx) {
        EntityWrapper<VeCbzx> ew = new EntityWrapper<VeCbzx>();
        ew.setEntity(veCbzx);
        return veCbzxMapper.selectList(ew);
    }

    /**
     * 根据成本中心编号查询成本中心信息
     *
     * @param veCbzx 成本中心对象
     * @return 成本中心对象
     */
    public VeCbzx getVeCbzxByCbzxbh(VeCbzx veCbzx) {
        return veCbzxMapper.selectOne(veCbzx);
    }

    /**
     * 新增成本中心数据
     *
     * @param veCbzx 成本中心
     * @return Boolean
     * @author yangxianglin
     * @date 2018-08-06 11:35:36
     */
    public Boolean insertCostCenter(VeCbzx veCbzx) {
        return veCbzxMapper.insert(veCbzx) >0 ? Boolean.TRUE : Boolean.FALSE;
    }

    /**
     * 编辑成本中心数据
     *
     * @param veCbzx 成本中心
     * @return Boolean
     * @author yangxianglin
     * @date 2018-08-06 11:35:36
     */
    public Boolean updateCostCenter(VeCbzx veCbzx) {
        return veCbzxMapper.updateById(veCbzx)>0 ? Boolean.TRUE : Boolean.FALSE;
    }


    /**
     * 根据企业编号查询成本中心列表
     *
     * @param listDTO 成本中心列表Dto
     * @return 成本中心
     */
    public List<VeCbzx> getVeCbzxList(CostCenterManagementDTO listDTO) {
        EntityWrapper<VeCbzx> ew = new EntityWrapper<VeCbzx>();
        VeCbzx veCbzx = new VeCbzx();
        if (StringUtils.isNotBlank(listDTO.getQybh())) {
            veCbzx.setQybh(listDTO.getQybh());
        }
        if (StringUtils.isNotBlank(listDTO.getGsid())) {
            veCbzx.setGsid(listDTO.getGsid());
        }
        ew.setEntity(veCbzx);
        if (StringUtils.isNotBlank(listDTO.getCbzxmc())) {
            ew.like("cbzxmc", listDTO.getCbzxmc());
        }
        return veCbzxMapper.selectList(ew);
    }

    /**
     * 成本中心分类查询
     * @param veCbzx 成本中心对象
     * @return 成本中心集合
     */
    public List<VeCbzx> queryVecbzxList(VeCbzx veCbzx){
        EntityWrapper<VeCbzx> ew = new EntityWrapper<VeCbzx>();
        ew.setEntity(veCbzx);
        return veCbzxMapper.selectList(ew);
    }

    /**
     * 根据条件查询成本中心集合
     * @param dto 入参对象
     * @return 成本中心集合
     */
    public List<VeCbzx> queryVecbzxLists(DataSendsDTO dto){
        EntityWrapper<VeCbzx> ew = new EntityWrapper<VeCbzx>();
        VeCbzx veCbzx = new VeCbzx();
        veCbzx.setQybh(dto.getQybh());
        if(StringUtils.isNotBlank(dto.getGsid())){
            veCbzx.setGsid(dto.getGsid());
        }
        veCbzx.setZt("1");
        ew.setEntity(veCbzx);
        if(CollectionUtils.isNotEmpty(dto.getGsdxflids())){
            ew.in("cbzxbh",dto.getGsdxflids());
        }
        if(CollectionUtils.isNotEmpty(dto.getGsids())){
            ew.in("gsid",dto.getGsids());
        }
        return veCbzxMapper.selectList(ew);
    }

    /**
     * 批量新增或修改成本中心数据
     * @param veCbzxes 成本中心数据集合
     * @return 是否成功
     */
    public boolean createOrUpdateBatch(List<VeCbzx> veCbzxes){
        for(VeCbzx czx: veCbzxes){
            if(StringUtils.isNotBlank(czx.getId())){
                veCbzxMapper.updateById(czx);
            }else{
                veCbzxMapper.insert(czx);
            }

        }
        return Boolean.TRUE;
    }

}