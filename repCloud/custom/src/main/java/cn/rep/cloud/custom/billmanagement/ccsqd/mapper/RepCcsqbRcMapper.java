package cn.rep.cloud.custom.billmanagement.ccsqd.mapper;

import cn.rep.cloud.custom.billmanagement.ccsqd.entity.RepCcsqbRc;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component("repCcsqbRcMapper")
public interface RepCcsqbRcMapper  extends BaseMapper<RepCcsqbRc>{
}
