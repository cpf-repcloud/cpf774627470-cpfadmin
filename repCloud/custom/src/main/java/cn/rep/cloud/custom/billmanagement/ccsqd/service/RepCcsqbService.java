package cn.rep.cloud.custom.billmanagement.ccsqd.service;

import cn.rep.cloud.custom.billmanagement.ccsqd.dto.RepCcsqbDTO;
import cn.rep.cloud.custom.billmanagement.ccsqd.entity.RepCcsqb;
import cn.rep.cloud.custom.billmanagement.ccsqd.mapper.RepCcsqbMapper;
import cn.rep.cloud.custom.billmanagement.ccsqd.vo.RepCcsqbVO;
import cn.rep.cloud.custom.coreutils.common.PageCopyUtil;
import cn.rep.cloud.custom.coreutils.common.PageDTO;
import cn.rep.cloud.custom.coreutils.utils.BeanMapper;
import cn.rep.cloud.custom.coreutils.utils.DateUtils;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 出差申请单controller
 * 基础 招商银行模板
 */
@Service
public class RepCcsqbService {
    @Autowired
    private RepCcsqbMapper repCcsqbMapper;


    /**
     * 新增出差申请单号
     *
     * @param dto
     * @return
     */
    public Boolean insertCcsqd(RepCcsqbDTO dto) {
        String sqdh = "SQ" + DateUtils.getTimeStr() + DateUtils.getNo(5);
        dto.setSqdh(sqdh);
        dto.setSqsj(DateUtils.getStringDate());
        RepCcsqb ccsqb = BeanMapper.map(dto, RepCcsqb.class);
        int i = repCcsqbMapper.insert(ccsqb);
        if (i > 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }


    public Boolean updateCcsqbBySqdh(RepCcsqbDTO dto) {
        dto.setXgsj(DateUtils.getNow());
        RepCcsqb repccsqb = BeanMapper.map(dto, RepCcsqb.class);
        int i = repCcsqbMapper.updateById(repccsqb);
        if (i > 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public List<RepCcsqbVO> queryCcsqbPage(Page page, RepCcsqbDTO dto) {
        List<RepCcsqbVO> volist = repCcsqbMapper.queryCcsqbPage(page, dto);
        return volist;
    }


    /**
     * @param sqdh
     * @return
     */
    public RepCcsqbVO queryCcsqbBySqdh(String sqdh) {
        RepCcsqb repccsqb = repCcsqbMapper.selectById(sqdh);
        RepCcsqbVO vo = BeanMapper.map(repccsqb, RepCcsqbVO.class);
        return vo;
    }

}
