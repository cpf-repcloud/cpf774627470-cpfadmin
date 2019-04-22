package cn.rep.cloud.custom.openapi.kjController.basecommon.bmkj;

import cn.rep.cloud.custom.coreutils.common.BaseController;
import cn.rep.cloud.custom.coreutils.common.RestResponse;
import cn.rep.cloud.custom.coreutils.utils.BeanMapper;
import cn.rep.cloud.custom.openapi.kjController.basecommon.bmkj.bean.KjBmRequest;
import cn.rep.cloud.custom.openapi.kjController.basecommon.bmkj.bean.KjBmResponse;
import cn.rep.cloud.custom.organizationa.business.RepDeptServiceImpl;
import cn.rep.cloud.custom.organizationa.dto.RepBmDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 部门控件入口
 * @author hyg
 */
@RestController
@RequestMapping("/kj/dept")
public class BmKjController extends BaseController{

    @Autowired
    private RepDeptServiceImpl repDeptService;

    /**
     * 查询部门list
     * @param request
     * @return
     */
    @RequestMapping("getDeptList")
    public RestResponse<List<KjBmResponse>> getDeptList(@RequestBody KjBmRequest request){
        RepBmDTO dto = new RepBmDTO();
        BeanMapper.copy(request,dto);
        dto.setQybh(loginUser.getQybh());
        List<KjBmResponse> csList = repDeptService.getBmList(dto);
        return new RestResponse(csList);
    }
}
