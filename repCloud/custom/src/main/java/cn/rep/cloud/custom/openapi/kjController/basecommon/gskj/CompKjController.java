package cn.rep.cloud.custom.openapi.kjController.basecommon.gskj;

import cn.rep.cloud.custom.coreutils.common.RestResponse;
import cn.rep.cloud.custom.openapi.kjController.basecommon.gskj.bean.KjGsResponse;
import cn.rep.cloud.custom.organizationa.business.RepCompServiceImpl;
import cn.rep.cloud.custom.organizationa.entity.RepGs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kj/comp")
public class CompKjController {
    @Autowired
    private RepCompServiceImpl repCompService;

    /**
     * 查询公司list
     * @return
     */
    @RequestMapping("getCompList")
    public RestResponse<List<KjGsResponse>> getCityList(){
        List<KjGsResponse> gsList = repCompService.getCompList();
        return new RestResponse(gsList);
    }
}
