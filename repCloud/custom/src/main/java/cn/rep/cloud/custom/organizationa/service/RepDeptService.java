package cn.rep.cloud.custom.organizationa.service;

import cn.rep.cloud.custom.organizationa.mapper.RepDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepDeptService {
    @Autowired
    private RepDeptMapper repDeptMapper;
}
