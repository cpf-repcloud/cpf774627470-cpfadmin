package cn.rep.cloud.custom.basicdata.mapper;


import cn.rep.cloud.custom.basicdata.dto.RepCountryDTO;
import cn.rep.cloud.custom.basicdata.entity.RepCountry;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "repCountryMapper")
public interface RepCountryMapper extends BaseMapper<RepCountry> {

    List<RepCountry> getCountryList(@Param("dto") RepCountryDTO dto);
}
