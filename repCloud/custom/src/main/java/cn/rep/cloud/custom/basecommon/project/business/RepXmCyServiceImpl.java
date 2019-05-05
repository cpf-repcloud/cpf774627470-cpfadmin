package cn.rep.cloud.custom.basecommon.project.business;

import cn.rep.cloud.custom.basecommon.project.entity.RepXmCy;
import cn.rep.cloud.custom.basecommon.project.mapper.RepXmCyMapper;
import cn.rep.cloud.custom.basecommon.project.service.dto.AddProMemberDTO;
import cn.rep.cloud.custom.basecommon.project.service.dto.SearchProMemberDTO;
import cn.rep.cloud.custom.basecommon.project.service.vo.ProMembersVO;
import cn.rep.cloud.custom.coreutils.common.PageDTO;
import cn.rep.cloud.custom.coreutils.utils.BeanMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目成员service
 * Created by vetech on 2018/8/9.
 */
@Service
public class RepXmCyServiceImpl{
    @Autowired
    private RepXmCyMapper repXmCyMapper;

    /**
     * 项目成员添加数据
     *
     * @param memberDTO
     * @return
     */
    public int addMember(AddProMemberDTO memberDTO) {
        RepXmCy xmcy = BeanMapper.map(memberDTO, RepXmCy.class);
        return repXmCyMapper.insert(xmcy);
    }

    /**
     * 获取项目成员列表
     *
     * @return
     */
    public Page<ProMembersVO> getProMembers() {
        return getProMembers();
    }

    /**
     * 获取项目成员列表
     *
     * @param dto
     * @return
     */
    public Page<ProMembersVO> getProMembers(PageDTO<SearchProMemberDTO> dto) {
        Page<ProMembersVO> page = new Page<>(dto.getCurrent(), dto.getSize(), dto.getOrderByField());
        List<ProMembersVO> list = repXmCyMapper.selectProMember(page, dto.getData());
        page.setRecords(list);
        page.setTotal(repXmCyMapper.selectCountPro(dto.getData()));
        return page;
    }


    /**
     * 删除项目成员
     *
     * @param dto
     * @return
     */

    public int deleteProCy(SearchProMemberDTO dto) {
        RepXmCy cy = new RepXmCy();
        cy.setId(dto.getId());
        cy.setQybh(dto.getQybh());
        EntityWrapper ew = new EntityWrapper(cy);
        return repXmCyMapper.delete(ew);
    }

    /**
     * 通过项目编号 删除项目成员
     * @param cy
     * @return
     */
    public int deleteXmCyByXmid(RepXmCy cy){
        EntityWrapper ew=new EntityWrapper();
        if(StringUtils.isNotBlank(cy.getXmid())){
            ew.eq("xmid",cy.getXmid());
        }
        if(StringUtils.isNotBlank(cy.getCyjs())){
            ew.eq("cyjs",cy.getCyjs());
        }
        return  repXmCyMapper.delete(ew);

    }

    /**
     * 修改项目成员状态
     * @param dto
     * @return
     */
    public int updateCyzt(SearchProMemberDTO dto) {
        RepXmCy cy = new RepXmCy();
        cy.setId(dto.getId());
        cy.setQybh(dto.getQybh());
        cy.setZt(dto.getZt());
        return repXmCyMapper.updateById(cy);
    }
}
