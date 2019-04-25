package cn.rep.cloud.custom.billmanagement.ccsqd.mapper;

import cn.rep.cloud.custom.billmanagement.ccsqd.entity.RepCcsqbFjb;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component("repCcsqdFjbMapper")
public interface RepCcsqbFjbMapper extends BaseMapper<RepCcsqbFjb> {
}
