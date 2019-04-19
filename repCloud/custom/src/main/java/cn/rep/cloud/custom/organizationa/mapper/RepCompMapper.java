package cn.rep.cloud.custom.organizationa.mapper;

import cn.rep.cloud.custom.organizationa.dto.RepCompDTO;
import cn.rep.cloud.custom.organizationa.entity.RepGs;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "repCompMapper")
public interface RepCompMapper extends BaseMapper<RepGs> {

    List<RepGs> pagelist(Page page, @Param("dto") RepCompDTO dto);
}
