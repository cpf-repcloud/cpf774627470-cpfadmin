package cn.rep.cloud.custom.zzjg.controller;

import cn.rep.cloud.custom.common.PageDTO;
import cn.rep.cloud.custom.common.RestResponse;
import cn.rep.cloud.custom.utils.BeanMapper;
import cn.rep.cloud.custom.zzjg.business.RepEmployeeServiceImpl;
import cn.rep.cloud.custom.zzjg.business.RepModularServiceImpl;
import cn.rep.cloud.custom.zzjg.dto.RepModularDTO;
import cn.rep.cloud.custom.zzjg.entity.RepEmployee;
import cn.rep.cloud.custom.zzjg.entity.RepModular;
import cn.rep.cloud.custom.zzjg.vo.RepEmployeeBean;
import cn.rep.cloud.custom.zzjg.vo.RepModularVO;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("repModular")
public class RepModularController {
    /**
     * 系统模块服务
     */
    @Autowired
    private RepModularServiceImpl repModularService;
    /**
     * 当前登录人信息
     */
    @Autowired
    private RepEmployeeServiceImpl repEmployeeService;

    @RequestMapping("getRepModular")
    public RestResponse<RepEmployeeBean> getRepModular(@RequestParam("id") String id){
        RepEmployeeBean repEmp = new RepEmployeeBean();
        RepEmployee repEmployee = repEmployeeService.queryRepEmployee(id);
        repEmp = BeanMapper.map(repEmployee,RepEmployeeBean.class);
        List<RepModularVO> lists = repModularService.getModular();
        repEmp.setMenuList(lists);
        return new RestResponse(repEmp);
    }

    @RequestMapping("list")
    public RestResponse<Page<RepModular>> list(@RequestBody PageDTO<RepModularDTO> pageDTO){//
        Page<RepModular> pageNew = repModularService.seletPage(pageDTO);
        return new RestResponse(pageNew);
    }

    @RequestMapping("addRepModular")
    public RestResponse addRepModular(@RequestBody RepModularDTO dto){//
        boolean result;
        if (StringUtils.isBlank(dto.getId())){
            result = repModularService.insertRepModular(dto);
        }else{
            result =  repModularService.updateRepModular(dto);
        }
        return new RestResponse(result);
    }

    @RequestMapping("edit")
    public RestResponse edit(@RequestBody RepModularDTO dto){//
        boolean result = repModularService.updateRepModular(dto);
        return new RestResponse(result);
    }

    @RequestMapping("parentList")
    public RestResponse<List<RepModularVO>> parentList(){
        List<RepModularVO> parentList = repModularService.parentList();
        return new RestResponse(parentList);
    }

    @RequestMapping("delete")
    public RestResponse delete(@RequestBody RepModularDTO dto){//
        boolean result = repModularService.deleteRepModular(dto);
        return new RestResponse(result);
    }
}
