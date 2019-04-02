package cn.rep.cloud.custom.organizationa.service;

import cn.rep.cloud.custom.organizationa.mapper.RepPermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepPermissionService {
    @Autowired
    private RepPermissionMapper repPermissionMapper;
}
