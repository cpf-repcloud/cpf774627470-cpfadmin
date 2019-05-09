package cn.rep.cloud.custom.basecommon.basedata.mapper;

import cn.rep.cloud.custom.basecommon.basedata.entity.RepJscjlb;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "repJscjlbMapper")
public interface RepJscjlbMapper extends BaseMapper<RepJscjlb> {
}
