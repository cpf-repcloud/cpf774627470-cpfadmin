package cn.rep.cloud.custom.organizationa.controller;

import cn.rep.cloud.custom.coreutils.common.BaseController;
import cn.rep.cloud.custom.coreutils.common.PageDTO;
import cn.rep.cloud.custom.coreutils.common.RestResponse;
import cn.rep.cloud.custom.organizationa.business.RepYgServiceImpl;
import cn.rep.cloud.custom.organizationa.dto.RepYgDTO;
import cn.rep.cloud.custom.organizationa.entity.RepYg;
import cn.rep.cloud.custom.organizationa.vo.SuccessBean;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("repEmployee")
public class RepEmployeeController extends BaseController {
    @Autowired
    private RepYgServiceImpl repYgService;

    @RequestMapping("list")
    public RestResponse<Page<RepYg>> list(@RequestBody PageDTO<RepYgDTO> pageDTO) {//
        Page<RepYg> pageNew = repYgService.seletPage(pageDTO);
        return new RestResponse(pageNew);
    }

    /**
     * 下载模板
     *
     * @return 返回excel模板
     */
    @RequestMapping(value = "downloadModel", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public Object downloadModel() {
        return repYgService.downloadYgMb();
    }

    /**
     * 批量上传员工
     *
     * @return
     */
    @RequestMapping(value = "uploadEmpBatch")
    public RestResponse<SuccessBean> uploadEmpBatch(@RequestParam("file") MultipartFile file) {
        RepYgDTO dto = new RepYgDTO();
        dto.setQybh(loginUser.getQybh());
        dto.setCjr(loginUser.getXm());
        SuccessBean successBean = repYgService.uploadEmpBatch(file, dto);
        return new RestResponse(successBean);
    }

    /**
     * 页面获取登录人信息使用
     * @return
     */
    @RequestMapping(value = "getUser")
    public RestResponse<RepYg> getUser(){
        return new RestResponse(loginUser);
    }
}