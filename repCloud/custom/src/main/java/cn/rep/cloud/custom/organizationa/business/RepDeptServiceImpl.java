package cn.rep.cloud.custom.organizationa.business;

import cn.rep.cloud.custom.openapi.kjController.basecommon.bmkj.bean.KjBmResponse;
import cn.rep.cloud.custom.organizationa.dto.RepBmDTO;
import cn.rep.cloud.custom.organizationa.entity.RepBm;
import cn.rep.cloud.custom.organizationa.service.RepDeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RepDeptServiceImpl {
    /**
     * 日志记录类
     */
    private static final Logger logger = LoggerFactory.getLogger(RepDeptServiceImpl.class);

    @Autowired
    private RepDeptService repDeptService;

    /**
     * 通过企业编号查询部门
     * @param bmDTO
     * @return
     */
    public List<KjBmResponse> getBmList(RepBmDTO bmDTO){
        List<RepBm> deptList = repDeptService.getBmList(bmDTO);
        List<KjBmResponse> responseList = new ArrayList<>();
        for (RepBm repBm : deptList){
            KjBmResponse response = new KjBmResponse();
            response.setId(repBm.getBh());
            response.setName(repBm.getJc());
            response.setValue(repBm.getId());
            responseList.add(response);
        }
        return responseList;
    }
}
