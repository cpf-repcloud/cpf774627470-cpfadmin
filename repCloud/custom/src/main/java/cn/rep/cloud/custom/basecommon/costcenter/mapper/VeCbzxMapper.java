package cn.rep.cloud.custom.basecommon.costcenter.mapper;

import cn.rep.cloud.custom.basecommon.costcenter.entity.VeCbzx;
import cn.rep.cloud.custom.basecommon.costcenter.service.dto.CostCenterListDTO;
import cn.rep.cloud.custom.basecommon.costcenter.service.vo.CostCenterPageListVO;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  * 成本中心表 Mapper 接口
 * </p>
 *
 * @author chenyong
 * @since 2018-08-06
 */
public interface VeCbzxMapper extends BaseMapper<VeCbzx> {
    /**
     *  成本中心分页列表
     * @param dto 查询条件
     * @return  List<CostCenterPageListVO>
     */
    List<CostCenterPageListVO> selectCostCenterPageList(Page page, @Param("dto") CostCenterListDTO dto);

}