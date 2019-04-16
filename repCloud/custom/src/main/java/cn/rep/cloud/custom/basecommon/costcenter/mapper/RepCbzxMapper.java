package cn.rep.cloud.custom.basecommon.costcenter.mapper;

import cn.rep.cloud.custom.basecommon.costcenter.entity.RepCbzx;
import cn.rep.cloud.custom.basecommon.costcenter.service.dto.CostCenterListDTO;
import cn.rep.cloud.custom.basecommon.costcenter.service.vo.CostCenterPageListVO;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
  * 成本中心表 Mapper 接口
 * </p>
 *
 * @author chenyong
 * @since 2018-08-06
 */
@Mapper
@Component(value = "veCbzxMapper")
public interface RepCbzxMapper extends BaseMapper<RepCbzx> {
    /**
     *  成本中心分页列表
     * @param dto 查询条件
     * @return  List<CostCenterPageListVO>
     */
    List<CostCenterPageListVO> selectCostCenterPageList(Page page, @Param("dto") CostCenterListDTO dto);

}