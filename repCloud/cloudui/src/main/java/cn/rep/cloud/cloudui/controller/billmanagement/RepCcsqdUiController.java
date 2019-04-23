package cn.rep.cloud.cloudui.controller.billmanagement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/billmanagement")
public class RepCcsqdUiController {
    /**
     * @return
     */
    @RequestMapping(value = "/ccsqdlist", method = RequestMethod.GET)
    public String databaselist() {
        return "/billmanagement/ccsqdlist";
    }
}
