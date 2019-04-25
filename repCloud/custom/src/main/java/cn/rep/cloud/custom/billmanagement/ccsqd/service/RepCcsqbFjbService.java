package cn.rep.cloud.custom.billmanagement.ccsqd.service;

import cn.rep.cloud.custom.billmanagement.ccsqd.dto.RepCcsqbFjbDTO;
import cn.rep.cloud.custom.billmanagement.ccsqd.entity.RepCcsqbFjb;
import cn.rep.cloud.custom.billmanagement.ccsqd.entity.RepCcsqbRy;
import cn.rep.cloud.custom.billmanagement.ccsqd.mapper.RepCcsqbFjbMapper;
import cn.rep.cloud.custom.billmanagement.ccsqd.vo.RepCcsqbFjbVO;
import cn.rep.cloud.custom.billmanagement.ccsqd.vo.RepCcsqbRyVO;
import cn.rep.cloud.custom.coreutils.utils.BeanMapper;
import cn.rep.cloud.custom.coreutils.utils.DateUtils;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepCcsqbFjbService {
    @Autowired
    private RepCcsqbFjbMapper repCcsqbFjbMapper;


    public Boolean insertFj(RepCcsqbFjbDTO dto) {
        dto.setCjsj(DateUtils.getNow());
        dto.setXgsj(DateUtils.getNow());
        RepCcsqbFjb fjb = BeanMapper.map(dto, RepCcsqbFjb.class);
        int i = repCcsqbFjbMapper.insert(fjb);
        if (i > 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public List<RepCcsqbFjbVO> queryFjbListBySqdh(String sqdh) {
        EntityWrapper ew = new EntityWrapper();
        ew.eq("sqdh", sqdh);
        List<RepCcsqbFjb> rclist = repCcsqbFjbMapper.selectList(ew);
        List<RepCcsqbFjbVO> volist = BeanMapper.mapList(rclist,RepCcsqbFjbVO.class);
        return volist;
    }
}
