package cn.rep.cloud.custom.basecommon.service;


import cn.rep.cloud.custom.basecommon.business.VeXmServiceImpl;
import cn.rep.cloud.custom.basecommon.entity.VeXm;
import cn.rep.cloud.custom.basecommon.service.dto.AddProDTO;
import cn.rep.cloud.custom.basecommon.service.dto.ProDetailDTO;
import cn.rep.cloud.custom.basecommon.service.dto.SearchDataDTO;
import cn.rep.cloud.custom.basecommon.service.vo.ProDataVo;
import cn.rep.cloud.custom.basecommon.service.vo.ProTreeVo;
import cn.rep.cloud.custom.common.IdGenerator;
import cn.rep.cloud.custom.common.PageDTO;
import cn.rep.cloud.custom.common.VeCollectionUtils;
import cn.rep.cloud.custom.utils.DateUtils;
import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by vetech on 2018/8/4.
 */
@Service
public class ProjectManageService {
    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(ProjectManageService.class);


    /***
     * service
     */
    @Autowired
    private VeXmServiceImpl veXmService;

    /**
     * 项目成员service
     */
    @Autowired
    private ProjectMemberService memberService;





    /**
     * 新增项目方法
     *
     * @param dto 入参
     * @return
     */
    public int addPro(AddProDTO dto) throws Exception {
        if (StringUtils.isBlank(dto.getGsid())) {
             //  throw new Exception(BaseExceptionEnum.BASE_PROJECT_0000_04_0140);
        }
        dto.setId(IdGenerator.getHexId());
        dto.setKsrq(DateUtils.strToDate(dto.getKsrqStr()));
        dto.setJsrq(DateUtils.strToDate(dto.getJsrqStr()));
        if (CollectionUtils.isNotEmpty(dto.getXmbhcy())) {
            //新增项目成员
            addXmCy(dto.getXmbhcy(), dto);
        }
        /**是否开启成本中心*/
        if (dto.getSfkqcbzx()) {
           // addVeXmCbzx(dto);
        }
        return veXmService.addPro(dto);
    }


    /**
     * 新增项目成员
     *
     * @param dtos
     * @param dto
     */
    public void addXmCy(List<ProDetailDTO> dtos, AddProDTO dto) {
        for (ProDetailDTO del : dtos) {
            memberService.addMember(dto, del);
        }
    }

    /**
     * 插入成本中心项目表
     *
     * @param dto
     * @return
     */
   /* public Boolean addVeXmCbzx(AddProDTO dto) {
        //插入成本中心表
        VeCbzx veCbzx = new VeCbzx();
        veCbzx.setId(IdGenerator.getHexId());
        veCbzx.setQybh(dto.getQybh());
        veCbzx.setGsid(dto.getGsid());
        veCbzx.setCbzxbh(dto.getCbzxbh());
        veCbzx.setGsid(dto.getGsid());
        if (StringUtils.isNotBlank(dto.getSjcbzx())) {
            veCbzx.setSjbh(dto.getSjcbzx());
        } else {
            veCbzx.setSjbh("none");
        }
        veCbzx.setZt(CostCenterConstants.COSTCENTER_XMZT_ZC);
        veCbzx.setZhxgr(dto.getZhxgr());
        veCbzx.setZhxgsj(VeDate.getNow());
        veCbzx.setCbzxmc(dto.getXmmc());
        if (veCbzxService.insertCostCenter(veCbzx)) {
            VeXmCbzx xmcbzx = new VeXmCbzx();
            xmcbzx.setId(IdGenerator.getHexId());
            xmcbzx.setQybh(dto.getQybh());
            xmcbzx.setXmid(dto.getId());
            xmcbzx.setCbzxid(veCbzx.getId());
            xmcbzx.setZhxgr(dto.getZhxgr());
            xmcbzx.setZhxgsj(dto.getZhxgsj());
            return veXmCbzxService.insertVeXmCbzx(xmcbzx);
        }

        return Boolean.FALSE;
    }*/

    /**
     * 查询list
     *
     * @param dto 入参R
     * @return
     */
    public Page<ProDataVo> selectPage(PageDTO<SearchDataDTO> dto) {
        logger.info("查询项目列表入参{}", dto);
        Page<ProDataVo> vso = veXmService.selectPage(dto);
        return vso;
    }

    /**
     * 编辑页面方法
     *
     * @param dto 入参
     * @return
     */
    public int editPro(AddProDTO dto) throws Exception{
        if (StringUtils.isBlank(dto.getGsid())) {
          //  throw new SystemException(BaseExceptionEnum.BASE_PROJECT_0000_04_0140);
        }
        logger.info("编辑项目方法 入参{}", dto);
        //上级编号为空 设置为none
        if (StringUtils.isBlank(dto.getSjbh())) {
            dto.setSjbh("none");
        }
        /*编辑 项目成员*/
        if (CollectionUtils.isNotEmpty(dto.getXmbhcy())) {
            for (ProDetailDTO cydet : dto.getXmbhcy()) {
               /* VeXmCy cy = new VeXmCy();
                cy.setCyjs(cydet.getCyjs());
                cy.setXmid(dto.getId());
                memberService.deleteXmCyByXmid(cy);*/
            }
            // 新增项目成员角色
            addXmCy(dto.getXmbhcy(), dto);
        }
        return veXmService.editPro(dto);
    }


    /**
     * 查询
     *
     * @param qybh 企业编号
     * @return 树形结构
     */
    public ProTreeVo getTreeList(String qybh) {
        ProTreeVo proTreeVo = new ProTreeVo();
        /**查询该企业下面的所有项目list*/
        List<VeXm> veList = veXmService.getAllList(qybh);
        if (CollectionUtils.isEmpty(veList)) {
            return null;
        }
        Map<String, List<VeXm>> veXmMap = null;
        try {
            /**通过上级编号分组*/
            veXmMap = VeCollectionUtils.group(veList, "sjbh");
        } catch (Exception e) {
            logger.error("获取项目分组map 报错", e);
        }

        /** 获取一级项目list**/
        List<VeXm> veXms = veXmMap.get("none");
        getTreeData(veXms, veXmMap, proTreeVo);
        return proTreeVo;
    }

    /**
     * 获取树形结构
     *
     * @param veList    项目分组list
     * @param veXmMap   项目分组map
     * @param proTreeVo 树形结构出参
     */
    private void getTreeData(List<VeXm> veList, Map<String, List<VeXm>> veXmMap, ProTreeVo proTreeVo) {
        /*if (CollectionUtils.isNotEmpty(veList)) {
            List<ProTreeVo> proTreeVoList = new ArrayList<>();
            for (VeXm xm : veList) {
                ProTreeVo treeVo = new ProTreeVo();
                Type<ProTreeVo> proTreeVoType = BeanMapper.getType(ProTreeVo.class);
                Type<VeXm> veXmType = BeanMapper.getType(VeXm.class);
                treeVo = BeanMapper.map(xm, veXmType, proTreeVoType);
                treeVo.setTitle(xm.getXmmc());
                String xmbh = xm.getXmbh();
                String xmjl = xm.getXmjl();//项目经理
                VeYgrz ygrz = veYgrzServicel.searchYgrzById(xmjl);
                if (null != ygrz) {
                    treeVo.setXmjlmc(ygrz.getXm());
                    String xmjlygid = ygrz.getYgid();
                    EmployeeInfoBaseDTO baseDTO = new EmployeeInfoBaseDTO();
                    baseDTO.setYgid(xmjlygid);
                    EmployeeSessionBaseVO vo = ygService.selectEmployeeSessionInfo(baseDTO);
                    if (null != vo) {
                        treeVo.setXmjlgh(vo.getGh());
                    }
                }
                List<VeXm> xmList = veXmMap.get(xmbh);// 获取子级项目编号
                if (CollectionUtils.isNotEmpty(xmList)) {
                    treeVo.setExpand("true");
                } else {
                    treeVo.setExpand("false");
                }
                proTreeVoList.add(treeVo);
                getTreeData(xmList, veXmMap, treeVo);
            }
            proTreeVo.setChildren(proTreeVoList);
        }*/

    }

    /**
     * 查询详情
     *
     * @param dto
     * @return
     */
    public ProDataVo getXmVoByData(SearchDataDTO dto) {
       /* String id = dto.getId();
        if (StringUtils.isBlank(id)) {
            return null;
        }
        VeXm xm = veXmService.getXmByDto(id);
        ProDataVo vo = BeanMapper.map(xm, ProDataVo.class);
        VeXmCbzx cbzx = new VeXmCbzx();
        cbzx.setXmid(xm.getId());
        List<VeXmCbzx> cbzxes = veXmCbzxService.getCbzxByBean(cbzx);
        if (CollectionUtils.isNotEmpty(cbzxes)) {
            vo.setSfkqcbzx(Boolean.TRUE);
            VeXmCbzx cbzx2 = cbzxes.get(0);
            VeCbzx cb = new VeCbzx();
            cb.setId(cbzx2.getCbzxid());
            cb = veCbzxService.getVeCbzxByCbzxbh(cb);
            vo.setCbzxbh(cb.getCbzxbh());
            if (StringUtils.equals(cb.getSjbh(), "none")) {
                vo.setSjcbzx(null);
            } else {
                VeCbzx cb2 = new VeCbzx();
                cb2.setCbzxbh(cb.getSjbh());
                cb2 = veCbzxService.getVeCbzxByCbzxbh(cb2);
                vo.setSjcbzx(cb2.getId());
            }
        } else {
            vo.setSfkqcbzx(Boolean.FALSE);
        }
        //项目经理
        VeYgrz xmjlrz = getYgInfoBYRzid(vo.getXmjl());
        if (null != xmjlrz) {
            vo.setXmjlmc(xmjlrz.getXm());
            vo.setXmjlszbm(xmjlrz.getBmid());
            vo.setXmjlszgs(xmjlrz.getGsid());
            EmployeeInfoBaseDTO baseDTO = new EmployeeInfoBaseDTO();
            baseDTO.setYgid(xmjlrz.getYgid());
            EmployeeSessionBaseVO baseVO = ygService.selectEmployeeSessionInfo(baseDTO);
            if (null != vo) {
                vo.setXmjlgh(baseVO.getGh());
            }
        }
        VeYgrz xmzjrz = getYgInfoBYRzid(vo.getXmzj());
        if (null != xmzjrz) {
            vo.setXmzjmc(xmzjrz.getXm());
            vo.setXmzjszbm(xmzjrz.getBmid());
            vo.setXmzjszgs(xmzjrz.getGsid());
        }
        VeYgrz xmlxrrz = getYgInfoBYRzid(vo.getXmlxr());
        if (null != xmlxrrz) {
            vo.setXmlxrmc(xmlxrrz.getXm());
            vo.setXmlxrszbm(xmlxrrz.getBmid());
            vo.setXmlxrszgs(xmlxrrz.getGsid());
        }
        return vo;*/
       return null;
    }




    /**
     * 修改项目状态
     *
     * @param dto 入参
     * @return
     */
    public int updateState(AddProDTO dto) {
        return veXmService.updateState(dto);
    }


}
