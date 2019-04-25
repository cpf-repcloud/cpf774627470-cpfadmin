package cn.rep.cloud.custom.billmanagement.ccsqd.service;

import cn.rep.cloud.custom.billmanagement.ccsqd.dto.RepCcsqbRcDTO;
import cn.rep.cloud.custom.billmanagement.ccsqd.entity.RepCcsqbRc;
import cn.rep.cloud.custom.billmanagement.ccsqd.mapper.RepCcsqbRcMapper;
import cn.rep.cloud.custom.billmanagement.ccsqd.vo.RepCcsqbRcVO;
import cn.rep.cloud.custom.coreutils.utils.BeanMapper;
import cn.rep.cloud.custom.coreutils.utils.DateUtils;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepCcsqbRcService {
    @Autowired
    private RepCcsqbRcMapper repCcsqbRcMapper;

    public Boolean insert(RepCcsqbRcDTO dto) {
        dto.setCjsj(DateUtils.getNow());
        dto.setXgsj(DateUtils.getNow());
        RepCcsqbRc rc = BeanMapper.map(dto, RepCcsqbRc.class);
        int i = repCcsqbRcMapper.insert(rc);
        if (i > 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public List<RepCcsqbRcVO> queryRcListBySqdh(String sqdh) {
        EntityWrapper ew = new EntityWrapper();
        ew.eq("sqdh", sqdh);
        List<RepCcsqbRc> rclist = repCcsqbRcMapper.selectList(ew);
        List<RepCcsqbRcVO> volist = BeanMapper.mapList(rclist,RepCcsqbRcVO.class);
        return volist;
    }
}
