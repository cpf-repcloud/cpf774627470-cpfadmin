package cn.rep.cloud.custom.organizationa.service;

import cn.rep.cloud.custom.basecommon.common.Constants;
import cn.rep.cloud.custom.organizationa.dto.RepBmDTO;
import cn.rep.cloud.custom.organizationa.entity.RepBm;
import cn.rep.cloud.custom.organizationa.mapper.RepDeptMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepDeptService {
    @Autowired
    private RepDeptMapper repDeptMapper;

    /**
     * 通过企业编号查询部门
     * @param bmDTO
     * @return
     */
    public List<RepBm> getBmList(RepBmDTO bmDTO){
        EntityWrapper<RepBm> ew = new EntityWrapper<>();
        if (StringUtils.isNotBlank(bmDTO.getSsgsid())){
            ew.eq("ssgsid",bmDTO.getSsgsid());
        }
        ew.eq("zt", Constants.ZT_ONE);
        ew.eq("qybh",bmDTO.getQybh());
        List<RepBm> bmList = repDeptMapper.selectList(ew);
        return bmList;
    }
}
