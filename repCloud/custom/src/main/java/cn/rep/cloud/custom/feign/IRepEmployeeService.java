package cn.rep.cloud.custom.feign;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/api/feign/repEmp")
public interface IRepEmployeeService {

    @GetMapping("/getRec")
    RepEmployeeClientVO getRec(RepEmployeeClientDTO dto);
}
