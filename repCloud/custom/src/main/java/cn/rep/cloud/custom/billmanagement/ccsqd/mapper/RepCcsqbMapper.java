package cn.rep.cloud.custom.billmanagement.ccsqd.mapper;

import cn.rep.cloud.custom.billmanagement.ccsqd.dto.RepCcsqbDTO;
import cn.rep.cloud.custom.billmanagement.ccsqd.entity.RepCcsqb;
import cn.rep.cloud.custom.billmanagement.ccsqd.vo.RepCcsqbVO;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("repCcsqbMapper")
public interface RepCcsqbMapper extends BaseMapper<RepCcsqb> {

    List<RepCcsqbVO> queryCcsqbPage(Page page ,@Param("dto") RepCcsqbDTO dto);

}
