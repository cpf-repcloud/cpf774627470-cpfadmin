package cn.rep.cloud.cloudui.controller.commonbase;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("project")
public class ProjectUiController {
    /**
     * @return 登录页
     */
    @RequestMapping(value = "projectList", method = RequestMethod.GET)
    public String repModularList() {
        return "/project/projectmanage";
    }
}
