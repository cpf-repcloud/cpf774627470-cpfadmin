package cn.rep.cloud.custom.openapi.kjController.basecommon;

import cn.rep.cloud.custom.basecommon.project.business.RepXmServiceImpl;
import cn.rep.cloud.custom.coreutils.common.RestResponse;
import cn.rep.cloud.custom.openapi.kjController.basecommon.bean.KjXmRequest;
import cn.rep.cloud.custom.openapi.kjController.basecommon.bean.KjXmResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 控件项目接口
 */
@RestController("/kj/project")
public class XmKjController  {

    @Autowired
    private RepXmServiceImpl veXmServicel;

    @RequestMapping("getProjectList")
    public RestResponse<List<KjXmResponse>> excute(@RequestBody KjXmRequest data) {
        //veXmServicel.
        return new RestResponse<List<KjXmResponse>>();
    }




    public List<KjXmResponse> translate(Object data) {
        return null;
    }
}
