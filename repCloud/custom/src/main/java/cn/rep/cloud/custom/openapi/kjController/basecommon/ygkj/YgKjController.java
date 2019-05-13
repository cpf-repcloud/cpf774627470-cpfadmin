package cn.rep.cloud.custom.openapi.kjController.basecommon.ygkj;

import cn.rep.cloud.custom.coreutils.common.BaseController;
import cn.rep.cloud.custom.coreutils.common.RestResponse;
import cn.rep.cloud.custom.coreutils.utils.BeanMapper;
import cn.rep.cloud.custom.openapi.kjController.basecommon.ygkj.Bean.KjYgRequest;
import cn.rep.cloud.custom.openapi.kjController.basecommon.ygkj.Bean.KjYgResponse;
import cn.rep.cloud.custom.organizationa.business.RepYgServiceImpl;
import cn.rep.cloud.custom.organizationa.dto.RepYgDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 员工控件入口
 * @author hyg
 */
@RestController
@RequestMapping("/kj/employee")
public class YgKjController extends BaseController {
    @Autowired
    private RepYgServiceImpl repYgService;

    /**
     * 查询员工list
     * @param request
     * @return
     */
    @RequestMapping("getEmployeeList")
    public RestResponse<List<KjYgResponse>> getEmployeeList(@RequestBody KjYgRequest request){
        RepYgDTO dto = new RepYgDTO();
        BeanMapper.copy(request,dto);
        dto.setQybh(loginUser.getQybh());
        List<KjYgResponse> csList = repYgService.getYgList(dto);
        return new RestResponse(csList);
    }
}
