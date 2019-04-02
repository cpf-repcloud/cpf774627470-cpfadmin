package cn.rep.cloud.custom.organizationa.mapper;

import cn.rep.cloud.custom.organizationa.entity.RepRule;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "repRuleMapper")
public interface RepRuleMapper extends BaseMapper<RepRule> {
}
