package cn.rep.cloud.custom.basecommon.post.mapper;

import cn.rep.cloud.custom.basecommon.post.dto.SelectPostRankListDTO;
import cn.rep.cloud.custom.basecommon.post.entity.RepGw;

import cn.rep.cloud.custom.basecommon.post.vo.SelectPostRankListVO;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 企业岗位表 Mapper 接口
 * </p>
 *
 * @author chenyong
 * @since 2018-07-10
 */
@Mapper
@Component(value = "veGwMapper")
public interface RepGwMapper extends BaseMapper<RepGw> {

    /**
     * 查询岗位数据
     *
     * @param dto 入参
     * @return List<SelectPostRankListVO> 岗位数据集合
     */
    List<SelectPostRankListVO> selectPostRankList(@Param("dto") SelectPostRankListDTO dto);
}
