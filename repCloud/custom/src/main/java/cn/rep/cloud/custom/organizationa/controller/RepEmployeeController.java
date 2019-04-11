package cn.rep.cloud.custom.organizationa.controller;

import cn.rep.cloud.custom.organizationa.business.RepEmployeeServiceImpl;
import cn.rep.cloud.custom.organizationa.entity.RepLogin;
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
    public RepLogin queryRepEmployee(@RequestParam("id") String id){
        RepLogin repEmployee = repEmployeeService.queryRepEmployee(id);
        return repEmployee;
    }

    @RequestMapping("/login")
    public boolean queryRepEmployee(@RequestBody RepLogin repEmployee){
        String loginname = repEmployee.getLoginname();
        String passwrod = repEmployee.getPassword();
        boolean result = false;
        if (StringUtils.equals("admin",loginname) && StringUtils.equals("123456",passwrod)){
            result = true;
        }
        return result;
    }
}
