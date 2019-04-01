package cn.rep.cloud.custom.zzjg.business;


import cn.rep.cloud.custom.zzjg.entity.RepEmployee;
import cn.rep.cloud.custom.zzjg.service.RepEmployeeService;
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
    public RepEmployee queryRepEmployee(String id){
        return repEmployeeService.queryRepEmployee(id);
    }

    /**
     *
     * @param loginName
     * @return
     */
    public RepEmployee getEmpByLonginName(String loginName){
        return repEmployeeService.getEmpByLonginName(loginName);
    }
}
