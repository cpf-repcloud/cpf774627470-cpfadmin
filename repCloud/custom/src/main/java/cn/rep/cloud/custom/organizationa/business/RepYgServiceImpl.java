package cn.rep.cloud.custom.organizationa.business;


import cn.rep.cloud.custom.organizationa.entity.RepYg;
import cn.rep.cloud.custom.organizationa.service.RepYgService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class RepYgServiceImpl {

    @Autowired
    private RepYgService repYgService;

    /**
     * 登录成功后将当前登录人存入session中
     * @param id
     * @return
     */
    public RepYg queryRepYg(String id,HttpServletRequest request){
        RepYg repYg = repYgService.queryRepYg(id);
        if (null != repYg && StringUtils.isNotBlank(repYg.getId())){
            HttpSession session = request.getSession();
            System.out.println(session.getId());
            session.setAttribute(session.getId(),repYg);
        }
        return repYg;
    }

}
