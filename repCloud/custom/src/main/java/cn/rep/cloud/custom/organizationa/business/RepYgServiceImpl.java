package cn.rep.cloud.custom.organizationa.business;


import cn.rep.cloud.custom.openapi.kjController.basecommon.ygkj.Bean.KjYgResponse;
import cn.rep.cloud.custom.organizationa.dto.RepYgDTO;
import cn.rep.cloud.custom.organizationa.entity.RepYg;
import cn.rep.cloud.custom.organizationa.service.RepYgService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * 根据企业编号查询员工集合
     *
     * @return 查询条件
     */
    public List<KjYgResponse> getYgList(RepYgDTO ygDTO){
        List<RepYg> ygList = repYgService.getYgList(ygDTO);
        List<KjYgResponse> responseList = new ArrayList<>();
        for (RepYg repYg : ygList){
            KjYgResponse response = new KjYgResponse();
            response.setId(repYg.getGh());
            response.setName(repYg.getXm());
            response.setValue(repYg.getId());
            responseList.add(response);
        }
        return responseList;
    }

}
