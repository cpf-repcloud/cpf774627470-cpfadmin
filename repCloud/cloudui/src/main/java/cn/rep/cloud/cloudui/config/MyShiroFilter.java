package cn.rep.cloud.cloudui.config;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyShiroFilter extends FormAuthenticationFilter {

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        String successUrl = "/index/index";
        //WebUtils.getAndClearSavedRequest(request);
        WebUtils.issueRedirect(request,response,successUrl);
        return false;
    }
}
