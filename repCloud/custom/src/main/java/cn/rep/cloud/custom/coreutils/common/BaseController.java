package cn.rep.cloud.custom.coreutils.common;

import cn.rep.cloud.custom.organizationa.entity.RepYg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class BaseController {
    /**
     * 注入request
     */
    @Autowired
    protected HttpServletRequest request;
    /**
     * 当前登录人信息
     */
    protected RepYg loginUser;

    @ModelAttribute
    public void loginUser(){
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        loginUser = (RepYg)session.getAttribute(session.getId());
    }
}
