package cn.rep.cloud.custom.basecommon.basedata.service;

import cn.rep.cloud.custom.basecommon.basedata.entity.RepJscjlb;
import cn.rep.cloud.custom.basecommon.basedata.mapper.RepJscjlbMapper;
import cn.rep.cloud.custom.basecommon.basedata.service.dto.BaseDataLbVO;
import cn.rep.cloud.custom.basecommon.basedata.service.vo.BaseDataLbDTO;
import cn.rep.cloud.custom.coreutils.common.IdGenerator;
import cn.rep.cloud.custom.coreutils.utils.BeanMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasedataLbService {

    @Autowired
    private RepJscjlbMapper repJscjlbMapper;

    public int insertLb(BaseDataLbDTO dto) {
        dto.setId(IdGenerator.getHexId());
        RepJscjlb repJscjlb = BeanMapper.map(dto, RepJscjlb.class);
        return repJscjlbMapper.insert(repJscjlb);
    }

    public List<BaseDataLbVO> queryList(BaseDataLbDTO dto) {
        EntityWrapper ew = new EntityWrapper();
        if (StringUtils.isNotBlank(dto.getLb())) {
            ew.eq("lb", dto.getLb());
        }
        if (StringUtils.isNotBlank(dto.getLbmc())) {
            ew.like("lbmc", "%" + dto.getLbmc() + "%");
        }
        List<RepJscjlb> list = repJscjlbMapper.selectList(ew);
        return BeanMapper.mapList(list, BaseDataLbVO.class);
    }

    public int editJcsjLb(BaseDataLbDTO dto){
        RepJscjlb repJscjlb = BeanMapper.map(dto, RepJscjlb.class);
        return repJscjlbMapper.updateById(repJscjlb);
    }
}
