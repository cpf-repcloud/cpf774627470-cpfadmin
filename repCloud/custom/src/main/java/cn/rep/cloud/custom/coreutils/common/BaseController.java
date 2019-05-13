package cn.rep.cloud.custom.coreutils.common;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.rep.cloud.custom.coreutils.utils.SerializeUtil;
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
        byte[] result = (byte[])session.getAttribute(session.getId());
        if (null != result){
            JSONObject object = (JSONObject)SerializeUtil.unSerialize(result);
            loginUser = JSONUtil.toBean(object,RepYg.class);
        }
    }
}
