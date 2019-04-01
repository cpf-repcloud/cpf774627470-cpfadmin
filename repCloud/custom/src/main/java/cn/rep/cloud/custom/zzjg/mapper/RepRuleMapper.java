package cn.rep.cloud.custom.zzjg.mapper;

import cn.rep.cloud.custom.zzjg.entity.RepRule;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "repRuleMapper")
public interface RepRuleMapper extends BaseMapper<RepRule> {
}
