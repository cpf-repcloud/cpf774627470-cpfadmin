package cn.rep.cloud.custom.openapi.feign.repemployee;

import cn.rep.cloud.custom.openapi.feign.repemployee.dto.RepEmployeeClientDTO;
import cn.rep.cloud.custom.openapi.feign.repemployee.vo.RepEmployeeClientVO;
import cn.rep.cloud.custom.organizationa.business.RepEmployeeServiceImpl;
import cn.rep.cloud.custom.organizationa.entity.RepLogin;
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
            RepLogin repEmployee = repEmployeeService.getEmpByLonginName(loginName);
            RepEmployeeClientVO repEmployeeClientVO = new RepEmployeeClientVO();
            repEmployeeClientVO.setId(repEmployee.getId());
            repEmployeeClientVO.setName(repEmployee.getName());
            repEmployeeClientVO.setLoginname(repEmployee.getLoginname());
            repEmployeeClientVO.setPassword(repEmployee.getPassword());
            return repEmployeeClientVO;
        }

}
