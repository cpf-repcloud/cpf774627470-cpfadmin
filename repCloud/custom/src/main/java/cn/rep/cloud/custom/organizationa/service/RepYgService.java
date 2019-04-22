package cn.rep.cloud.custom.organizationa.service;

import cn.rep.cloud.custom.basecommon.common.Constants;
import cn.rep.cloud.custom.organizationa.dto.RepYgDTO;
import cn.rep.cloud.custom.organizationa.entity.RepYg;
import cn.rep.cloud.custom.organizationa.mapper.RepYgMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepYgService {
    @Autowired
    private RepYgMapper repYgMapper;

    /**
     *
     * @param id
     * @return
     */
    public RepYg queryRepYg(String id){
        return repYgMapper.selectById(id);
    }

    /**
     * 根据企业编号查询员工集合
     * @return
     */
    public List<RepYg> getYgList(RepYgDTO ygDTO){
        EntityWrapper<RepYg> ew = new EntityWrapper<>();
        if (StringUtils.isNotBlank(ygDTO.getGsid())){
            ew.eq("gsid",ygDTO.getGsid());
        }
        if (StringUtils.isNotBlank(ygDTO.getBmid())){
            ew.eq("bmid",ygDTO.getGsid());
        }
        ew.eq("qybh",ygDTO.getQybh());
        ew.eq("ktzt", Constants.ZT_ONE);
        List<RepYg> ygList = repYgMapper.selectList(ew);
        return ygList;
    }

}
