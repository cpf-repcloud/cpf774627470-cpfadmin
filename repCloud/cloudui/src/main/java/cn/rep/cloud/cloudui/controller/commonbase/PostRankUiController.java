package cn.rep.cloud.cloudui.controller.commonbase;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("postrank")
public class PostRankUiController {
    /**
     * @return 登录页
     */
    @RequestMapping(value = "postlist", method = RequestMethod.GET)
    public String repModularList() {
        return "/commonbase/postrank";
    }
}
