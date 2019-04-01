package cn.rep.cloud.custom.zzjg.controller;

import cn.rep.cloud.custom.common.PageDTO;
import cn.rep.cloud.custom.common.RestResponse;
import cn.rep.cloud.custom.zzjg.business.RepCompServiceImpl;
import cn.rep.cloud.custom.zzjg.dto.RepCompDTO;
import cn.rep.cloud.custom.zzjg.entity.RepComp;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("repComp")
public class RepCompController {
    @Autowired
    private RepCompServiceImpl repCompService;

    @RequestMapping("list")
    public RestResponse<Page<RepComp>> list(@RequestBody PageDTO<RepCompDTO> pageDTO){//
        Page<RepComp> pageNew = repCompService.seletPage(pageDTO);
        return new RestResponse(pageNew);
    }

    @RequestMapping("add")
    public RestResponse addRepComp(@RequestBody RepCompDTO dto){//
        boolean result;
        if (StringUtils.isBlank(dto.getId())){
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
