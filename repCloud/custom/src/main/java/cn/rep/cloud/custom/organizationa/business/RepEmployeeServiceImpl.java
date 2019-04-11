package cn.rep.cloud.custom.organizationa.business;


import cn.rep.cloud.custom.organizationa.entity.RepLogin;
import cn.rep.cloud.custom.organizationa.service.RepEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepEmployeeServiceImpl {

    @Autowired
    private RepEmployeeService repEmployeeService;

    /**
     *
     * @param id
     * @return
     */
    public RepLogin queryRepEmployee(String id){
        return repEmployeeService.queryRepEmployee(id);
    }

    /**
     *
     * @param loginName
     * @return
     */
    public RepLogin getEmpByLonginName(String loginName){
        return repEmployeeService.getEmpByLonginName(loginName);
    }
}
