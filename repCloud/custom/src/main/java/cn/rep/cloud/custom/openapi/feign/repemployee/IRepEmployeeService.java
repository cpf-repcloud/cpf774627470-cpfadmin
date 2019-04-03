package cn.rep.cloud.custom.openapi.feign.repemployee;

import cn.rep.cloud.custom.openapi.feign.repemployee.dto.RepEmployeeClientDTO;
import cn.rep.cloud.custom.openapi.feign.repemployee.vo.RepEmployeeClientVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/api/feign/repEmp")
public interface IRepEmployeeService {

    @GetMapping("/getRec")
    RepEmployeeClientVO getRec(RepEmployeeClientDTO dto);
}
