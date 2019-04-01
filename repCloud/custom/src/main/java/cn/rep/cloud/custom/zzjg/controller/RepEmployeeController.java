package cn.rep.cloud.custom.zzjg.controller;

import cn.rep.cloud.custom.zzjg.business.RepEmployeeServiceImpl;
import cn.rep.cloud.custom.zzjg.entity.RepEmployee;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("repEmployee")
public class RepEmployeeController {
    @Autowired
    private RepEmployeeServiceImpl repEmployeeService;

    @RequestMapping("/detail")
    public RepEmployee queryRepEmployee(@RequestParam("id") String id){
        RepEmployee repEmployee = repEmployeeService.queryRepEmployee(id);
        return repEmployee;
    }

    @RequestMapping("/login")
    public boolean queryRepEmployee(@RequestBody RepEmployee repEmployee){
        String loginname = repEmployee.getLoginname();
        String passwrod = repEmployee.getPassword();
        boolean result = false;
        if (StringUtils.equals("admin",loginname) && StringUtils.equals("123456",passwrod)){
            result = true;
        }
        return result;
    }
}
