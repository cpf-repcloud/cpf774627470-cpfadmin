package cn.rep.cloud.custom.openapi.kjController.basecommon.cbzxkj;

import cn.rep.cloud.custom.basecommon.costcenter.business.RepCbzxServiceImpl;
import cn.rep.cloud.custom.basecommon.costcenter.entity.RepCbzx;
import cn.rep.cloud.custom.basecommon.costcenter.service.dto.CostCenterManagementDTO;
import cn.rep.cloud.custom.coreutils.common.BaseController;
import cn.rep.cloud.custom.coreutils.common.RestResponse;
import cn.rep.cloud.custom.coreutils.utils.BeanMapper;
import cn.rep.cloud.custom.openapi.kjController.basecommon.cbzxkj.bean.KjCbzxResponse;
import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 控件项目接口
 */
@RestController
@RequestMapping("/kj/cost")
public class CbzxKjController extends BaseController {

    @Autowired
    private RepCbzxServiceImpl repCbzxService;

    @RequestMapping("/getCostList")
    public RestResponse<List<KjCbzxResponse>> excute() {
        CostCenterManagementDTO dto=new CostCenterManagementDTO();
        dto.setQybh(dto.getQybh());
        dto.setGsid(dto.getGsid());
        List<RepCbzx> cbzxlist = repCbzxService.getVeCbzxList(dto);
        List<KjCbzxResponse> list = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(cbzxlist)) {
            for (RepCbzx cbzx : cbzxlist) {
                KjCbzxResponse response=  BeanMapper.map(cbzx,KjCbzxResponse.class);
                response.setId(cbzx.getId());
                response.setName(cbzx.getCbzxmc());
                response.setValue(cbzx.getCbzxbh());
                list.add(response);
            }
        }
        return new RestResponse<>(list);
    }


}
