package cn.rep.cloud.custom.organizationa.controller;

import cn.rep.cloud.custom.coreutils.common.BaseController;
import cn.rep.cloud.custom.coreutils.common.RestResponse;
import cn.rep.cloud.custom.coreutils.common.TreeNode;
import cn.rep.cloud.custom.organizationa.business.RepDeptServiceImpl;
import cn.rep.cloud.custom.organizationa.dto.RepBmDTO;
import cn.rep.cloud.custom.organizationa.entity.RepBm;
import cn.rep.cloud.custom.organizationa.vo.RepDeptVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("repDept")
public class RepDeptController extends BaseController {

    @Autowired
    private RepDeptServiceImpl repDeptService;

    @RequestMapping(value = "getTreeNodes")
    public RestResponse<List<TreeNode>> getTreeNodes(){
        List<TreeNode> treeNodes = repDeptService.getTreeNodes();
        return new RestResponse(treeNodes);
    }

    /**
     * 查询页面面包屑和部门基本信息
     * @param chrId 部门id
     * @return
     */
    @RequestMapping(value = "getBmMbx")
    public RestResponse<RepDeptVO> getBmMbx(@RequestParam("chrId") String chrId){
        String ssgsid = loginUser.getGsid();
        RepDeptVO repDeptVO = repDeptService.getBmMbx(chrId,ssgsid);
        return new RestResponse(repDeptVO);
    }

    /**
     * 新增部门
     * @param repBmDTO
     * @return
     */
    @RequestMapping(value = "saveDept")
    public RestResponse<Boolean> saveDept(@RequestBody RepBmDTO repBmDTO){
        repBmDTO.setQybh(loginUser.getQybh());
        repBmDTO.setCjr(loginUser.getId());
        repBmDTO.setSsgsbh(loginUser.getGsid());
        boolean result = repDeptService.insertDept(repBmDTO);
        return new RestResponse(result);
    }

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
