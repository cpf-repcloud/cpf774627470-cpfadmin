package cn.rep.cloud.cloudui.controller.kjtest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KjTestController {
    /**
     * 列表页
     *
     * @return 列表页
     */
    @RequestMapping(value = "kjtest", method = RequestMethod.GET)
    public String list( Model model) {
        return "/kjsj/kjTest";
    }


}
