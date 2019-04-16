package cn.rep.cloud.custom.basecommon.project.service;

import cn.rep.cloud.custom.basecommon.project.business.RepXmServiceImpl;
import cn.rep.cloud.custom.basecommon.project.entity.RepXm;
import cn.rep.cloud.custom.basecommon.project.service.dto.AddProDTO;
import cn.rep.cloud.custom.basecommon.project.service.dto.AddProMemberDTO;
import cn.rep.cloud.custom.basecommon.project.service.dto.ProDetailDTO;
import cn.rep.cloud.custom.basecommon.project.service.dto.SearchProMemberDTO;
import cn.rep.cloud.custom.basecommon.project.service.vo.ProMembersVO;
import cn.rep.cloud.custom.coreutils.common.IdGenerator;
import cn.rep.cloud.custom.coreutils.common.PageDTO;
import cn.rep.cloud.custom.coreutils.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.stereotype.Service;

/**
 * 项目成员 service
 * Created by vetech on 2018/8/9.
 */
@Service
public class ProjectMemberService {


    /**
     * 查询项目详情
     */
    @Autowired
    private RepXmServiceImpl veXmService;
/*
    *//**
     * 项目成员
     *//*
    @Autowired
    private VeXmCyServiceImpl veXmCyService;

    *//**
     * 员工
     *//*
    @Autowired
    private VeYgServiceImpl ygService;*/

    /**
     * 添加项目成员方法
     *
     * @param dto
     * @return
     */
    public int addMember(AddProDTO dto, ProDetailDTO detailDTO) {
        AddProMemberDTO memberDTO = new AddProMemberDTO();
        memberDTO.setId(IdGenerator.getHexId());
        memberDTO.setIp(dto.getIp());
        memberDTO.setQybh(dto.getQybh());
        memberDTO.setXmid(dto.getId());
        memberDTO.setJrsj(DateUtils.getNow());
        memberDTO.setZhxgr(dto.getZhxgr());
        memberDTO.setZhxgsj(dto.getZhxgsj());
        // 新加成员项目状态为1
        memberDTO.setZt("1");
        memberDTO.setSsbmid(detailDTO.getSsbmid());
        memberDTO.setXmcy(detailDTO.getYgrzid());
        memberDTO.setSsgsid(detailDTO.getSsgsid());
        memberDTO.setCyjs(detailDTO.getCyjs());
        return 0;//veXmCyService.addMember(memberDTO);

    }

    /**
     * 查询项目包含成员列表
     *
     * @param dto
     * @return
     */

    public Page<ProMembersVO> getProMembers(PageDTO<SearchProMemberDTO> dto) {
        Page<ProMembersVO> voPage =null;// veXmCyService.getProMembers(dto);
        return voPage;
    }

    /***
     * 删除项目成员
     *
     * @param dto
     * @return
     */
    public int deleteProCy(SearchProMemberDTO dto) {
        if (StringUtils.isBlank(dto.getId())) {
            return 0;
        }
        /**修改主表的项目成员*/
        if (StringUtils.isNotBlank(dto.getCyjs()) && StringUtils.isNotBlank(dto.getXmid())) {
            RepXm vexm = veXmService.getXmByDto(dto.getXmid());
            if (StringUtils.equals(dto.getCyjs(), "2")) {
                vexm.setXmzj("");
            } else if (StringUtils.equals(dto.getCyjs(), "3")) {
                vexm.setXmlxr("");
            }
            veXmService.updateById(vexm);
        }

        return 0;//veXmCyService.deleteProCy(dto);

    }


    /**
     * 通过项目编号删除 成员角色删除项目成员 项目成员
     * @param cy
     * @return
     */
    public Boolean deleteXmCyByXmid(Object cy){
        return  null;//veXmCyService.deleteXmCyByXmid(cy);
    }

    /**
     * 修改项目成员状态
     *
     * @param dto
     * @return
     */

    public int updateCyzt(SearchProMemberDTO dto) {
        if (StringUtils.isBlank(dto.getId())) {
            return 0;
        }
        return 0;//veXmCyService.updateCyzt(dto);
    }

}
