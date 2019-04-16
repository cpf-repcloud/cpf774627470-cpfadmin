package cn.rep.cloud.custom.basecommon.project.mapper;


import cn.rep.cloud.custom.basecommon.project.entity.RepXm;
import cn.rep.cloud.custom.basecommon.project.service.dto.SearchDataDTO;
import cn.rep.cloud.custom.basecommon.project.service.vo.ProDataVo;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 项目管理
 * Created by vetech on 2018/8/4.
 */
@Mapper
@Component(value = "veXmMapper")
public interface RepXmMapper extends BaseMapper<RepXm> {

    List<ProDataVo> selectVeXmPage(Page page, @Param("dto") SearchDataDTO dto);



}
