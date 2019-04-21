package cn.rep.cloud.custom.basecommon.basedata.service;

import cn.rep.cloud.custom.basecommon.basedata.entity.RepJcsj;
import cn.rep.cloud.custom.basecommon.basedata.mapper.RepJcsjMapper;
import cn.rep.cloud.custom.basecommon.basedata.service.dto.BaseDataListDTO;
import cn.rep.cloud.custom.basecommon.basedata.service.vo.BaseDataListVO;
import cn.rep.cloud.custom.coreutils.common.IdGenerator;
import cn.rep.cloud.custom.coreutils.common.PageCopyUtil;
import cn.rep.cloud.custom.coreutils.common.PageDTO;
import cn.rep.cloud.custom.coreutils.utils.BeanMapper;
import cn.rep.cloud.custom.coreutils.utils.DateUtils;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BasedataSerivce {
    @Autowired
    private RepJcsjMapper repJcsjMapper;


    /**
     * 分页查询
     * @param pageDTO
     * @return
     */
    public Page<BaseDataListVO> selectPage(PageDTO<BaseDataListDTO> pageDTO){
        Page<BaseDataListVO> page = PageCopyUtil.genPage(pageDTO);
        List<BaseDataListVO> list = repJcsjMapper.pagelist(page,pageDTO.getData());
        page.setRecords(list);
        return page;
    }

    /**
     * 查询基础数据名称
     *
     * @param dataListDTO
     * @param isGroup     是否分组
     * @param isShxOrder     是否排序
     * @param isAsc       是否正序
     * @param isLbOrder       按 lb排序
     * @return
     */
    public List<BaseDataListVO> getBaseDataList(BaseDataListDTO dataListDTO, Boolean isGroup,
                                                Boolean isShxOrder, Boolean isAsc,Boolean isLbOrder) {
        EntityWrapper ew = new EntityWrapper();
        ew.eq("gsid", dataListDTO.getGsid());
        ew.eq("qybh", dataListDTO.getQybh());
        if (StringUtils.isNotBlank(dataListDTO.getBh())) {
            ew.eq("bh", dataListDTO.getBh());
        }
        if (StringUtils.isNotBlank(dataListDTO.getLb())) {
            ew.eq("lb", dataListDTO.getLb());
        }
        if (StringUtils.isNotBlank(dataListDTO.getLbmc())) {
            ew.like("lbmc", dataListDTO.getLbmc());
        }
        if (StringUtils.isNotBlank(dataListDTO.getMc())) {
            ew.like("mc", dataListDTO.getMc());
        }
        ew.groupBy(isGroup, "lb");
        ew.orderBy(isShxOrder, "sxh", isAsc);
        ew.orderBy(isLbOrder, "lb", isAsc);

        List<RepJcsj> repJcsjs = repJcsjMapper.selectList(ew);
        return CollectionUtils.isNotEmpty(repJcsjs) ? BeanMapper.mapList(repJcsjs, BaseDataListVO.class) : Collections.EMPTY_LIST;
    }


    /**
     * 基础数据入库
     *
     * @param dataListDTO
     * @return
     */
    public int insert(BaseDataListDTO dataListDTO) {
        dataListDTO.setZhxgsj(DateUtils.getNow());
        dataListDTO.setId(IdGenerator.getHexId());
        RepJcsj jcsj = BeanMapper.map(dataListDTO, RepJcsj.class);
        return repJcsjMapper.insert(jcsj);
    }

    /**
     * 删除基础数据
     *
     * @param id
     * @return
     */
    public int deleteJscsById(String id) {

        return repJcsjMapper.deleteById(id);
    }

    /**
     * 修改基础数据
     * @param dataListDTO
     * @return
     */
    public int update(BaseDataListDTO dataListDTO){
        dataListDTO.setZhxgsj(DateUtils.getNow());
        RepJcsj jcsj = BeanMapper.map(dataListDTO, RepJcsj.class);
        return repJcsjMapper.updateById(jcsj);
    }

    /**
     *
     */
    public BaseDataListVO getBaseDataById(String  id){
        RepJcsj repJcsj= repJcsjMapper.selectById(id);
        return BeanMapper.map(repJcsj, BaseDataListVO.class);
    }

    /**
     * 编辑判重
     * @param dto
     * @return
     */
    public List<BaseDataListVO> checkBaseData(BaseDataListDTO dto) {
        EntityWrapper ew = new EntityWrapper();
        ew.eq("gsid", dto.getGsid());
        ew.eq("qybh", dto.getQybh());
        if (StringUtils.isNotBlank(dto.getBh())) {
            ew.eq("bh", dto.getBh());
        }
        if (StringUtils.isNotBlank(dto.getLb())) {
            ew.eq("lb", dto.getLb());
        }
        if (StringUtils.isNotBlank(dto.getLbmc())) {
            ew.eq("lbmc", dto.getLbmc());
        }
        if (StringUtils.isNotBlank(dto.getMc())) {
            ew.eq("mc", dto.getMc());
        }
        if (StringUtils.isNotBlank(dto.getSxh())) {
            ew.eq("sxh", dto.getSxh());
        }
        if(StringUtils.isNotBlank(dto.getId())){
            ew.ne("id", dto.getId());
        }
        List<RepJcsj> list = repJcsjMapper.selectList(ew);
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        List<BaseDataListVO> volist = BeanMapper.mapList(list, BaseDataListVO.class);
        return volist;
    }

}
