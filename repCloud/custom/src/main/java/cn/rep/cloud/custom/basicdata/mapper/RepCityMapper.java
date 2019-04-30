package cn.rep.cloud.custom.basicdata.mapper;

import cn.rep.cloud.custom.basicdata.dto.RepCityDTO;
import cn.rep.cloud.custom.basicdata.entity.RepCity;
import cn.rep.cloud.custom.basicdata.vo.RepCityVO;
import cn.rep.cloud.custom.basicdata.vo.RepCountryVO;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "repCityMapper")
public interface RepCityMapper extends BaseMapper<RepCity> {

    List<RepCity> pagelist(Page page, @Param("dto") RepCityDTO dto);

    List<RepCityVO> getCityList(@Param("dto") RepCityDTO dto);

    List<RepCity> getPageCityList(Page page,@Param("dto") RepCityDTO dto);

    List<RepCountryVO> getCityListBySfid(@Param("szsf") String szsf);

    List<RepCountryVO> getCityListBySjid(@Param("sjid") String sjid);
}
