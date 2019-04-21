package cn.rep.cloud.cloudui.controller.commonbase;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cost")
public class CostListUiController {
    /**
     * @return
     */
    @RequestMapping(value = "/costlist", method = RequestMethod.GET)
    public String repModularList() {
        return "/commonbase/costlist";
    }
}
