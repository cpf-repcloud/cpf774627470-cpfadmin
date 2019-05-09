package cn.rep.cloud.cloudui.controller;


import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.rep.cloud.cloudui.common.SerializeUtil;
import cn.rep.cloud.cloudui.controller.vo.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UiBaseController {

//    /**
//     * 注入request
//     */
//    @Autowired
//    protected HttpServletRequest request;
//    /**
//     * 当前登录人信息
//     */
//    protected LoginUser loginUser;
//
//    @ModelAttribute
//    public void loginUser(){
//        HttpSession session = request.getSession();
//        JSONObject object = (JSONObject)SerializeUtil.unSerialize((byte[])session.getAttribute(session.getId()));
//        loginUser = JSONUtil.toBean(object,LoginUser.class);
//    }
}
