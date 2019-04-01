package cn.rep.cloud.custom.feign;

import cn.rep.cloud.custom.zzjg.business.RepEmployeeServiceImpl;
import cn.rep.cloud.custom.zzjg.entity.RepEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/feign/repEmp")
public class RepEmployeeFeignClient{

    @Autowired
    private RepEmployeeServiceImpl repEmployeeService;

    @PostMapping("/getRec")
    public RepEmployeeClientVO getRec(@RequestBody RepEmployeeClientDTO dto){
            String loginName = dto.getLoginName();
            RepEmployee repEmployee = repEmployeeService.getEmpByLonginName(loginName);
            RepEmployeeClientVO repEmployeeClientVO = new RepEmployeeClientVO();
            repEmployeeClientVO.setId(repEmployee.getId());
            repEmployeeClientVO.setName(repEmployee.getName());
            repEmployeeClientVO.setLoginname(repEmployee.getLoginname());
            repEmployeeClientVO.setPassword(repEmployee.getPassword());
            return repEmployeeClientVO;
        }

}
