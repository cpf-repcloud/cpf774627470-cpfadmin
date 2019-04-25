package cn.rep.cloud.custom.organizationa.service;

import cn.rep.cloud.custom.organizationa.entity.RepLogin;
import cn.rep.cloud.custom.organizationa.mapper.RepEmployeeMapper;
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
    public RepLogin queryRepEmployee(String id){
        return repEmployeeMapper.selectById(id);
    }

    /**
     *
     * @param loginName
     * @return
     */
    public RepLogin getEmpByLonginName(String loginName){
        return repEmployeeMapper.getEmpByLonginName(loginName);
    }

    /**
     * 新增登录账号
     * @param repLogin
     * @return
     */
    public boolean insetLogin(RepLogin repLogin){
        int result = repEmployeeMapper.insert(repLogin);
        if (result > 0){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
