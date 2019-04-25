package cn.rep.cloud.custom.organizationa.service;

import cn.rep.cloud.custom.coreutils.utils.DateUtils;
import cn.rep.cloud.custom.coreutils.utils.Md5AndSalt;
import cn.rep.cloud.custom.organizationa.entity.RepLogin;
import cn.rep.cloud.custom.organizationa.entity.RepYg;
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
     * @param repYg
     * @return
     */
    public boolean insetLogin(RepYg repYg){
        RepLogin repLogin = new RepLogin();
        repLogin.setId(DateUtils.getNo(5));
        repLogin.setYgid(repYg.getId());
        repLogin.setLoginname(repYg.getGh());
        repLogin.setName(repYg.getXm());
        String password = Md5AndSalt.getMd5("123456",repYg.getGh()).toString();
        repLogin.setCreattime(DateUtils.getNow());
        repLogin.setCreattime(DateUtils.getNow());
        repLogin.setCreatuser(repYg.getCjr());
        repLogin.setUpdateuser(repYg.getCjr());
        repLogin.setPassword(password);
        int result = repEmployeeMapper.insert(repLogin);
        if (result > 0){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
