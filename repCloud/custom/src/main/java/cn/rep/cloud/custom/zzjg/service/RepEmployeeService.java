package cn.rep.cloud.custom.zzjg.service;

import cn.rep.cloud.custom.zzjg.entity.RepEmployee;
import cn.rep.cloud.custom.zzjg.mapper.RepEmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepEmployeeService {
    @Autowired
    private RepEmployeeMapper repEmployeeMapper;

    /**
     *
     * @param id
     * @return
     */
    public RepEmployee queryRepEmployee(String id){
        return repEmployeeMapper.selectById(id);
    }

    /**
     *
     * @param loginName
     * @return
     */
    public RepEmployee getEmpByLonginName(String loginName){
        return repEmployeeMapper.getEmpByLonginName(loginName);
    }
}
