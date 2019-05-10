package cn.rep.cloud.custom.openapi.kjController.basecommon.xmkj;

import cn.rep.cloud.custom.basecommon.project.business.RepXmServiceImpl;
import cn.rep.cloud.custom.basecommon.project.entity.RepXm;
import cn.rep.cloud.custom.coreutils.common.BaseController;
import cn.rep.cloud.custom.coreutils.common.RestResponse;
import cn.rep.cloud.custom.coreutils.utils.BeanMapper;
import cn.rep.cloud.custom.openapi.kjController.basecommon.xmkj.bean.KjXmRequest;
import cn.rep.cloud.custom.openapi.kjController.basecommon.xmkj.bean.KjXmResponse;
import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 控件项目接口
 */
@RestController
@RequestMapping("/kj/project")
public class XmKjController extends BaseController {

    @Autowired
    private RepXmServiceImpl repXmService;

    @RequestMapping("/getProjectList")
    public RestResponse<List<KjXmResponse>> excute() {
        List<RepXm> xmlist = repXmService.getXmList(loginUser.getQybh());
        List<KjXmResponse> list = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(xmlist)) {
            for (RepXm xm : xmlist) {
                KjXmResponse response=  BeanMapper.map(xm,KjXmResponse.class);
                response.setId(xm.getId());
                response.setName(xm.getXmmc());
                response.setValue(xm.getXmbh());
                list.add(response);
            }
        }
        return new RestResponse<>(list);
    }


}
