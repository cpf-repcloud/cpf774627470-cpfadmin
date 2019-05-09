package cn.rep.cloud.custom.organizationa.controller;

import cn.rep.cloud.custom.coreutils.common.BaseController;
import cn.rep.cloud.custom.coreutils.common.RestResponse;
import cn.rep.cloud.custom.organizationa.business.RepYgServiceImpl;
import cn.rep.cloud.custom.organizationa.dto.RepYgDTO;
import cn.rep.cloud.custom.organizationa.entity.RepYg;
import cn.rep.cloud.custom.organizationa.vo.SuccessBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("repEmployee")
public class RepEmployeeController extends BaseController{
    @Autowired
    private RepYgServiceImpl repYgService;

    /**
     * 下载模板
     * @return 返回excel模板
     */
    @RequestMapping(value = "downloadModel", method = RequestMethod.GET, produces ="application/json;charset=UTF-8")
    public Object downloadModel(){
        return repYgService.downloadYgMb();
    }

    /**
     * 批量上传员工
     * @return
     */
    @RequestMapping(value = "uploadEmpBatch")
    public RestResponse<SuccessBean> uploadEmpBatch(@RequestParam("file") MultipartFile file){
        RepYgDTO dto = new RepYgDTO();
        dto.setQybh(loginUser.getQybh());
        dto.setCjr(loginUser.getXm());
        SuccessBean successBean = repYgService.uploadEmpBatch(file,dto);
        return new RestResponse(successBean);
    }

    @RequestMapping(value="getUser")
    public RestResponse<RepYg> getUser(){
        return new RestResponse<>(loginUser);
    }
}
