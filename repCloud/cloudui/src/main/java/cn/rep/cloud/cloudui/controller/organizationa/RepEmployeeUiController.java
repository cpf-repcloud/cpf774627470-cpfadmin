package cn.rep.cloud.cloudui.controller.organizationa;

import cn.rep.cloud.cloudui.controller.UiBaseController;
import cn.rep.cloud.cloudui.controller.vo.LoginUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("repEmp")
public class RepEmployeeUiController {

    /**
     * @return
     */
    @RequestMapping(value = "repRepEmpList", method = RequestMethod.GET)
    public String repRepEmpList() {
        return "/organizationa/employeeList";
    }
}
