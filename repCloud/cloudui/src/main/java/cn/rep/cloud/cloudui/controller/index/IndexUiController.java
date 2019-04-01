package cn.rep.cloud.cloudui.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexUiController {
    /**
     * 列表页
     *
     * @return 列表页
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String list(@RequestParam("id") String id, Model model) {
        model.addAttribute("id",id);
        return "/index/index";
    }


}
