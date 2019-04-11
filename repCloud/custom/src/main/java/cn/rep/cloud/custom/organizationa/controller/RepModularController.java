package cn.rep.cloud.custom.organizationa.controller;

import cn.rep.cloud.custom.coreutils.common.BaseController;
import cn.rep.cloud.custom.coreutils.common.PageDTO;
import cn.rep.cloud.custom.coreutils.common.RestResponse;
import cn.rep.cloud.custom.organizationa.business.RepEmployeeServiceImpl;
import cn.rep.cloud.custom.organizationa.business.RepModularServiceImpl;
import cn.rep.cloud.custom.organizationa.business.RepYgServiceImpl;
import cn.rep.cloud.custom.organizationa.dto.RepModularDTO;
import cn.rep.cloud.custom.organizationa.entity.RepLogin;
import cn.rep.cloud.custom.organizationa.entity.RepModular;
import cn.rep.cloud.custom.organizationa.entity.RepYg;
import cn.rep.cloud.custom.organizationa.vo.RepEmployeeBean;
import cn.rep.cloud.custom.organizationa.vo.RepModularVO;
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
public class RepModularController extends BaseController {
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
    /**
     * 当前登录员工
     */
    @Autowired
    private RepYgServiceImpl repYgService;

    @RequestMapping("getRepModular")
    public RestResponse<RepEmployeeBean> getRepModular(@RequestParam("id") String id){
        RepEmployeeBean repEmp = new RepEmployeeBean();
        RepLogin repEmployee = repEmployeeService.queryRepEmployee(id);
        RepYg repYg = repYgService.queryRepYg(repEmployee.getYgid(),request);
        List<RepModularVO> lists = repModularService.getModular();
        repEmp.setMenuList(lists);
        repEmp.setRepYg(repYg);
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
