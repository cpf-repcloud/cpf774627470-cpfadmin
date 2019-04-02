package cn.rep.cloud.cloudui.controller.organizationa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("repComp")
public class RepCompUiController {
    /**
     * @return
     */
    @RequestMapping(value = "repRepCompList", method = RequestMethod.GET)
    public String repRepCompList() {
        return "/organizationa/repCompList";
    }

}
