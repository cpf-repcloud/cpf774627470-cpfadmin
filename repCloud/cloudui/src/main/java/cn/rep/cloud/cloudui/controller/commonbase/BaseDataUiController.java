package cn.rep.cloud.cloudui.controller.commonbase;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/database")
public class BaseDataUiController {
    /**
     * @return
     */
    @RequestMapping(value = "/databaselist", method = RequestMethod.GET)
    public String databaselist() {
        return "/commonbase/databaselist";
    }
}
