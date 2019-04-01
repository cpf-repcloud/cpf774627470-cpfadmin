package cn.rep.cloud.custom.zzjg.service;

import cn.rep.cloud.custom.zzjg.mapper.RepRuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepRuleService {
    @Autowired
    private RepRuleMapper repRuleMapper;
}
