package cn.rep.cloud.cloudui.controller.index;

import cn.rep.cloud.cloudui.common.UserBean;
import cn.rep.cloud.cloudui.feignclient.IRepEmployeeServiceClient;
import cn.rep.cloud.cloudui.feignclient.dto.RepEmployeeClientDTO;
import cn.rep.cloud.cloudui.feignclient.vo.RepEmployeeClientVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("login")
public class LoginTestController {
    private static final Logger logger = LoggerFactory.getLogger(LoginTestController.class);
    @Resource
    private IRepEmployeeServiceClient iRepEmployeeServiceClient;

    @RequestMapping("/login")
    public List<String> login(@RequestBody UserBean repEmployee){
        // 当前用户
        Subject currentUser = SecurityUtils.getSubject();
        List<String> resultList = new ArrayList<>();
        String flag = "1";
        RepEmployeeClientDTO dto = new RepEmployeeClientDTO();
        dto.setLoginName(repEmployee.getUsername());
        RepEmployeeClientVO principal = iRepEmployeeServiceClient.getRec(dto);
        // 验证是否身份认证֤
        if (!currentUser.isAuthenticated()) {
            // 将用户名、密码封装为token
            UsernamePasswordToken token = new UsernamePasswordToken(repEmployee.getUsername(), repEmployee.getPassword());
            // rememberMe
            token.setRememberMe(true);
            try {
                // 执行登录
                currentUser.login(token);
            } catch (UnknownAccountException uae) {
                logger.info("用户名 " + token.getPrincipal()+" 不存在!");
                flag = "用户名不存在! ";
            } catch (IncorrectCredentialsException ice) {
                logger.info("帐户密码 " + token.getPrincipal() + " 错误!");
                flag = "密码错误！";
            } catch (LockedAccountException lae) {
                logger.info("用户名的帐户 " + token.getPrincipal() + " 被锁定, "
                        + "请与管理员联系以解锁。");
                flag = "用户名的帐户被锁定,请与管理员联系以解锁。";
            } catch (AuthenticationException ae) {
                logger.info("用户名或密码错误!");
                flag = "用户名或密码错误!";
            }
        }
//        if (StringUtils.equals("1",flag)){
//            return new ModelAndView ("redirect:/index?id="+principal.getId());
//        }
//           // return "redirect:要访问的相对网址或绝对网址?参数名="+参数值;
//        return new ModelAndView("");
        resultList.add(principal.getId());
        resultList.add(flag);
        return resultList;
    }
}
