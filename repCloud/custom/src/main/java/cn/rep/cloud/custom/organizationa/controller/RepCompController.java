package cn.rep.cloud.custom.organizationa.controller;

import cn.rep.cloud.custom.coreutils.common.BaseController;
import cn.rep.cloud.custom.coreutils.common.PageDTO;
import cn.rep.cloud.custom.coreutils.common.RestResponse;
import cn.rep.cloud.custom.organizationa.business.RepCompServiceImpl;
import cn.rep.cloud.custom.organizationa.dto.RepCompDTO;
import cn.rep.cloud.custom.organizationa.entity.RepComp;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("repComp")
public class RepCompController  extends BaseController {
    @Autowired
    private RepCompServiceImpl repCompService;

    @RequestMapping("list")
    public RestResponse<Page<RepComp>> list(@RequestBody PageDTO<RepCompDTO> pageDTO){//
        String cjr = loginUser.getCjr();
        Page<RepComp> pageNew = repCompService.seletPage(pageDTO);
        return new RestResponse(pageNew);
    }

    @RequestMapping("add")
    public RestResponse addRepComp(@RequestBody RepCompDTO dto){//
        boolean result;
        if (StringUtils.isBlank(dto.getId())){
            dto.setCreatuser(loginUser.getCjr());
            result = repCompService.insertRepComp(dto);
        }else{
            result =  repCompService.updateRepComp(dto);
        }
        return new RestResponse(result);
    }

    @RequestMapping("edit")
    public RestResponse edit(@RequestBody RepCompDTO dto){//
        boolean result = repCompService.updateRepComp(dto);
        return new RestResponse(result);
    }

    @RequestMapping("delete")
    public RestResponse delete(@RequestBody RepCompDTO dto){//
        boolean result = repCompService.deleteRepComp(dto);
        return new RestResponse(result);
    }
}
