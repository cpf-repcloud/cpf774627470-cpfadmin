package cn.rep.cloud.custom.zzjg.service;

import cn.rep.cloud.custom.zzjg.mapper.RepPermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepPermissionService {
    @Autowired
    private RepPermissionMapper repPermissionMapper;
}
