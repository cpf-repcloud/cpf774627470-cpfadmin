package cn.rep.cloud.cloudui.feignclient;

import cn.rep.cloud.cloudui.feignclient.dto.RepEmployeeClientDTO;
import cn.rep.cloud.cloudui.feignclient.vo.RepEmployeeClientVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(value = "custom")
public interface IRepEmployeeServiceClient {
    @PostMapping(value = "/api/feign/repEmp/getRec")
    RepEmployeeClientVO getRec(@RequestBody RepEmployeeClientDTO dto);
}
