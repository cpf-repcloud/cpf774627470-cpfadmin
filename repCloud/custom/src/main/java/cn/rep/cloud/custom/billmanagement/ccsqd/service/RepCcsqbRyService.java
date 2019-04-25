package cn.rep.cloud.custom.billmanagement.ccsqd.service;

import cn.rep.cloud.custom.billmanagement.ccsqd.dto.RepCcsqbRyDTO;
import cn.rep.cloud.custom.billmanagement.ccsqd.entity.RepCcsqbRy;
import cn.rep.cloud.custom.billmanagement.ccsqd.mapper.RepCcsqbRyMapper;
import cn.rep.cloud.custom.billmanagement.ccsqd.vo.RepCcsqbRyVO;
import cn.rep.cloud.custom.coreutils.utils.BeanMapper;
import cn.rep.cloud.custom.coreutils.utils.DateUtils;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepCcsqbRyService {
    @Autowired
    private RepCcsqbRyMapper repCcsqbRyMapper;

    public Boolean insert(RepCcsqbRyDTO dto) {
        dto.setCjsj(DateUtils.getNow());
        dto.setXgsj(DateUtils.getNow());
        RepCcsqbRy ry = BeanMapper.map(dto, RepCcsqbRy.class);

       int i=  repCcsqbRyMapper.insert(ry);
        if (i > 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public List<RepCcsqbRyVO> queryRyListBySqdh(String sqdh) {
        EntityWrapper ew = new EntityWrapper();
        ew.eq("sqdh", sqdh);
        List<RepCcsqbRy> rclist = repCcsqbRyMapper.selectList(ew);
        List<RepCcsqbRyVO> volist = BeanMapper.mapList(rclist,RepCcsqbRyVO.class);
        return volist;
    }
}
