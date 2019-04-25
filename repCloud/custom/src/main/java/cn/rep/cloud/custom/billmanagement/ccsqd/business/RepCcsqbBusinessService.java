package cn.rep.cloud.custom.billmanagement.ccsqd.business;

import cn.rep.cloud.custom.basecommon.project.entity.RepXm;
import cn.rep.cloud.custom.basecommon.project.service.vo.ProDataVo;
import cn.rep.cloud.custom.billmanagement.ccsqd.dto.RepCcsqbDTO;
import cn.rep.cloud.custom.billmanagement.ccsqd.dto.RepCcsqbRcDTO;
import cn.rep.cloud.custom.billmanagement.ccsqd.dto.RepCcsqbRyDTO;
import cn.rep.cloud.custom.billmanagement.ccsqd.dto.RepCcsqbFjbDTO;
import cn.rep.cloud.custom.billmanagement.ccsqd.entity.RepCcsqbFjb;
import cn.rep.cloud.custom.billmanagement.ccsqd.service.RepCcsqbFjbService;
import cn.rep.cloud.custom.billmanagement.ccsqd.service.RepCcsqbRcService;
import cn.rep.cloud.custom.billmanagement.ccsqd.service.RepCcsqbRyService;
import cn.rep.cloud.custom.billmanagement.ccsqd.service.RepCcsqbService;
import cn.rep.cloud.custom.billmanagement.ccsqd.vo.RepCcsqbFjbVO;
import cn.rep.cloud.custom.billmanagement.ccsqd.vo.RepCcsqbRcVO;
import cn.rep.cloud.custom.billmanagement.ccsqd.vo.RepCcsqbRyVO;
import cn.rep.cloud.custom.billmanagement.ccsqd.vo.RepCcsqbVO;
import cn.rep.cloud.custom.billmanagement.common.Constants;
import cn.rep.cloud.custom.coreutils.common.IdGenerator;
import cn.rep.cloud.custom.coreutils.common.PageCopyUtil;
import cn.rep.cloud.custom.coreutils.common.PageDTO;
import cn.rep.cloud.custom.coreutils.utils.BeanMapper;
import cn.rep.cloud.custom.coreutils.utils.DateUtils;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

/**
 * 出差申请单service
 * 基础 招商银行模板
 */
@Service
public class RepCcsqbBusinessService {

    @Autowired
    private RepCcsqbService repCcsqbService;

    @Autowired
    private RepCcsqbRcService repCcsqbRcService;

    @Autowired
    private RepCcsqbRyService repCcsqbRyService;

    @Autowired
    private RepCcsqbFjbService repCcsqbFjbService;


    /**
     * 查询分页
     *
     * @param dto
     * @return
     */
    public Page<RepCcsqbVO> queryCcsqbPage(PageDTO<RepCcsqbDTO> pageDTO) {
        Page page = PageCopyUtil.genPage(pageDTO);
        List<RepCcsqbVO> list = repCcsqbService.queryCcsqbPage(page, pageDTO.getData());
        page.setRecords(list);
        return page;
    }


    /**
     * 新增出差申请单号
     *
     * @param dto
     * @return
     */
    @Transient
    public Boolean insertCcsqd(RepCcsqbDTO dto) {
        String sqdh = "SQ" + DateUtils.getTimeStr() + DateUtils.getNo(5);
        dto.setSqdh(sqdh);
        dto.setBxzt(Constants.BXZT_WBX_0);
        dto.setCcsfwc(Constants.CCSFWC_WWC_0);
        Boolean isFul = repCcsqbService.insertCcsqd(dto);
        if (isFul) {
            insertRc(dto.getRcList(), sqdh);
            insertRy(dto.getRyList(), sqdh);
            insertFj(dto.getFjList(), sqdh);
        }
        return isFul;
    }


    public Boolean confirmCcsqb(RepCcsqbDTO dto) {
        if (StringUtils.isBlank(dto.getSqdh())) {
            //throw  new Exception("");
        }
        if (StringUtils.isBlank(dto.getSjccrqz())) {
            //
        }
        return repCcsqbService.updateCcsqbBySqdh(dto);
    }

    public RepCcsqbVO queryCcsqbDetail(String sqdh) {
        if (StringUtils.isBlank(sqdh)) {
            //  throw new Exception();
        }
        RepCcsqbVO vo = repCcsqbService.queryCcsqbBySqdh(sqdh);
        if (null != vo) {
            List<RepCcsqbRcVO> rcvolist = repCcsqbRcService.queryRcListBySqdh(sqdh);
            List<RepCcsqbRyVO> ryvolist = repCcsqbRyService.queryRyListBySqdh(sqdh);
            List<RepCcsqbFjbVO> fjbvolist = repCcsqbFjbService.queryFjbListBySqdh(sqdh);
            vo.setRcList(rcvolist);
            vo.setRyList(ryvolist);
            vo.setFjList(fjbvolist);
        }
        return vo;
    }


    public Boolean insertRc(List<RepCcsqbRcDTO> rclist, String sqdh) {
        if (CollectionUtils.isNotEmpty(rclist)) {
            for (RepCcsqbRcDTO rc : rclist) {
                rc.setId(IdGenerator.getHexId());
                rc.setSqdh(sqdh);
                repCcsqbRcService.insert(rc);
            }
        }

        return Boolean.TRUE;
    }

    public Boolean insertRy(List<RepCcsqbRyDTO> rylist, String sqdh) {
        if (CollectionUtils.isNotEmpty(rylist)) {
            for (RepCcsqbRyDTO ry : rylist) {
                ry.setSqdh(sqdh);
                ry.setId(IdGenerator.getHexId());
                repCcsqbRyService.insert(ry);
            }
        }
        return Boolean.TRUE;
    }

    public Boolean insertFj(List<RepCcsqbFjbDTO> fjblist, String sqdh) {
        if (CollectionUtils.isNotEmpty(fjblist)) {
            for (RepCcsqbFjbDTO fjb : fjblist) {
                fjb.setSqdh(sqdh);
                fjb.setId(IdGenerator.getHexId());
                repCcsqbFjbService.insertFj(fjb);
            }
        }
        return Boolean.TRUE;
    }

}
