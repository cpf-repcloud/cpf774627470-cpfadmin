package cn.rep.cloud.cloudui.controller.organizationa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("repModular")
public class RepModularUiController {
    /**
     * @return 登录页
     */
    @RequestMapping(value = "repModularList", method = RequestMethod.GET)
    public String repModularList() {
        return "/organizationa/repModularList";
    }

    /**
     * @return 登录页
     */
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test() {
        return "/organizationa/basicdataList";
    }
}
