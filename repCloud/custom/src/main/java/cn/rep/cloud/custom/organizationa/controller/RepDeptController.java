package cn.rep.cloud.custom.organizationa.controller;

import cn.rep.cloud.custom.coreutils.common.BaseController;
import cn.rep.cloud.custom.coreutils.common.RestResponse;
import cn.rep.cloud.custom.organizationa.business.RepDeptServiceImpl;
import cn.rep.cloud.custom.organizationa.dto.RepBmDTO;
import cn.rep.cloud.custom.organizationa.vo.SuccessBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("repDept")
public class RepDeptController extends BaseController {

    @Autowired
    private RepDeptServiceImpl repDeptService;

    /**
     * 批量上传员工
     * @return
     */
//    @RequestMapping(value = "uploadEmpBatch")
//    public RestResponse<SuccessBean> uploadEmpBatch(@RequestParam("file") MultipartFile file){
//        RepBmDTO dto = new RepBmDTO();
//        dto.setQybh(loginUser.getQybh());
//        dto.setCjr(loginUser.getXm());
//        SuccessBean successBean = repDeptService.uploadEmpBatch(file,dto);
//        return new RestResponse(successBean);
//    }
}
