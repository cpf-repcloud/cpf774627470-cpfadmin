package cn.rep.cloud.cloudui.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginUiController {

    /**
     * @return 登录页
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "/index/login";
    }

}
