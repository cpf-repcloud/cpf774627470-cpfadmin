package cn.rep.cloud.custom.basecommon.costcenter.service;


import cn.rep.cloud.custom.basecommon.costcenter.business.RepCbzxServiceImpl;
import cn.rep.cloud.custom.basecommon.costcenter.entity.RepCbzx;
import cn.rep.cloud.custom.basecommon.costcenter.service.dto.CostCenterBaseDTO;
import cn.rep.cloud.custom.basecommon.costcenter.service.vo.*;
import cn.rep.cloud.custom.coreutils.common.VeCollectionUtils;
import cn.rep.cloud.custom.coreutils.utils.BeanMapper;
import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 成本中心公共方法管理服务【包括对外接口】
 * Created by vetech on 2018/8/6.
 *
 * @author yxl
 */
@Service
public class CostCenterManagementCommonService {
    /**
     * 日志记录
     */
    Logger logger = LoggerFactory.getLogger(CostCenterManagementCommonService.class);

    /**
     * 成本中心管理Dao
     */
    @Autowired
    private RepCbzxServiceImpl veCbzxService;
    /**
     * 公司管理服务
     */
   /* @Autowired
    private VeGsServiceImpl veGsService;*/

    /**
     * 成本中心管理--数据递归筛选
     *
     * @param list          成本中心列表
     * @param costCenterMap 成本中心分组MAP
     * @param treeVO        成本中心树形结构出参
     */
    public void costCenterListTreeRecursive(List<RepCbzx> list, Map<String, List<RepCbzx>> costCenterMap, CostCenterTreeVO treeVO) {
        /**递归跳出的条件**/
        if (CollectionUtils.isNotEmpty(list)) {
            List<CostCenterTreeVO> costCenterList = new ArrayList<CostCenterTreeVO>();
            for (RepCbzx repCbzx : list) {
                /**将成本中心对象保存到输出页面VO对象**/
                CostCenterTreeVO costCenterTreeVO = BeanMapper.map(repCbzx,CostCenterTreeVO.class);
                costCenterTreeVO.setTitle(repCbzx.getCbzxmc());
                costCenterTreeVO.setExpand("false");
                costCenterList.add(costCenterTreeVO);
                /**继续递归筛选下级成本中心信息并填充到VO对象**/
                String id = repCbzx.getId();
                List<RepCbzx> repCbzxList = costCenterMap.get(id);
                costCenterListTreeRecursive(repCbzxList, costCenterMap, costCenterTreeVO);
            }
            treeVO.setChildren(costCenterList); //子节点集合数据
        }
    }

    /**
     * 成本中心管理-数据递归筛选
     *
     * @param list          成本中心分组列表
     * @param costCenterMap 成本中心分组MAP
     * @param costCenterVOs 成本中心列表出参
     */
    public void costCenterListRecursive(List<CostCenterPageListVO> list, Map<String, List<CostCenterPageListVO>> costCenterMap, List<CostCenterPageListVO> costCenterVOs) {
        /**递归跳出条件**/
        if (CollectionUtils.isNotEmpty(list)) {
            for (CostCenterPageListVO vo : list) {
                costCenterVOs.add(vo);
                /**继续递归筛选下级公司信息并填充到VO对象**/
                String sjbh = vo.getId();
                List<CostCenterPageListVO> costCenterList = costCenterMap.get(sjbh);
                costCenterListRecursive(costCenterList, costCenterMap, costCenterVOs);
            }
        }
    }

    /**
     * 根据企业编号查询成本中心列表
     *
     * @param costCenterBaseDTO 成本中心列表Dto
     * @return List<CostCenterBaseVO> 成本中心
     */
    public List<CostCenterBaseVO> selectVeCbzxListByQybh(CostCenterBaseDTO costCenterBaseDTO) {
        List<CostCenterBaseVO> targetList = new ArrayList<CostCenterBaseVO>();
        RepCbzx repCbzx = new RepCbzx();
        repCbzx.setQybh(costCenterBaseDTO.getQybh());
        repCbzx.setGsid(costCenterBaseDTO.getGsid());
        List<RepCbzx> repCbzxList = veCbzxService.selectVeCbzxListByQybh(repCbzx);
        targetList = BeanMapper.mapList(repCbzxList,  CostCenterBaseVO.class);
        return targetList;
    }

    /**
     * 根据企业编号查询成本中心树给控件
     *
     * @param costCenterBaseDTO 成本中心列表Dto
     * @return CostCenterControlVO 成本中心
     */
    public CostCenterControlVO selectVeCbzxTreeListToControl(CostCenterBaseDTO costCenterBaseDTO) {
        RepCbzx repCbzx = new RepCbzx();
        List<CostCenterBaseVO> targetList = new ArrayList<CostCenterBaseVO>();
        repCbzx.setQybh(costCenterBaseDTO.getQybh());
        repCbzx.setGsid(costCenterBaseDTO.getGsid());
        List<RepCbzx> repCbzxList = veCbzxService.selectVeCbzxListByQybh(repCbzx);
        CostCenterControlVO treeVO = new CostCenterControlVO();
        /**根据上级编号进行分组**/
        Map<String, List<RepCbzx>> costCenterMap = null;
        try {
            costCenterMap = VeCollectionUtils.group(repCbzxList, "sjbh");
        } catch (Exception e) {
            logger.error("成本中心分组异常：", e);
        }
        List<RepCbzx> vecbzxlist = new ArrayList<RepCbzx>();
        vecbzxlist = costCenterMap.get("none");
        /**调用递归方法筛选下级成本中心数据**/
        costCenterListTreeRecursiveToControl(vecbzxlist, costCenterMap, treeVO);
        return treeVO;
    }

    /**
     * 成本中心管理--数据递归筛选
     *
     * @param list          成本中心列表
     * @param costCenterMap 成本中心分组MAP
     * @param treeVO        成本中心树形结构出参
     */
    public void costCenterListTreeRecursiveToControl(List<RepCbzx> list, Map<String, List<RepCbzx>> costCenterMap, CostCenterControlVO treeVO) {
        /**递归跳出的条件**/
        if (CollectionUtils.isNotEmpty(list)) {
            List<CostCenterControlVO> costCenterList = new ArrayList<CostCenterControlVO>();
            for (RepCbzx repCbzx : list) {
                /**将成本中心对象保存到输出页面VO对象**/
                CostCenterControlVO costCenterTreeVO = new CostCenterControlVO();
                costCenterTreeVO.setId(repCbzx.getId());
                costCenterTreeVO.setLabel(repCbzx.getCbzxmc());
                costCenterTreeVO.setValue(repCbzx.getCbzxbh());
                costCenterList.add(costCenterTreeVO);

                /**继续递归筛选下级成本中心信息并填充到VO对象**/
                String cbzxbh = repCbzx.getCbzxbh();
                List<RepCbzx> repCbzxList = costCenterMap.get(cbzxbh);
                costCenterListTreeRecursiveToControl(repCbzxList, costCenterMap, costCenterTreeVO);
            }
            treeVO.setChildren(costCenterList); //子节点集合数据
        }
    }

    /**
     * 成本中心与公司级联的服务
     *
     * @param dto 查询条件传参
     * @retuen List 成本中心数据
     */
    public List<CostCenterCompanyVO> selectCompCostCenterList(CostCenterBaseDTO dto) {
        logger.info("成本中心管理-->>调用成本中心与公司级联的服务传入后台参数：", dto);
        /*List<CostCenterCompanyVO> targetList = new ArrayList<CostCenterCompanyVO>();
        //第一步：查询登录人所在企业下所有公司
        CompanyManagementDTO companyListDTO = new CompanyManagementDTO();
        companyListDTO.setQybh(dto.getQybh());
        List<VeGs> veGsList = veGsService.getVeGsList(companyListDTO);

        //第二步：查询具体一个下的成本中心数据
        if (CollectionUtils.isNotEmpty(veGsList)) {
            for (VeGs veGs : veGsList) {
                CostCenterCompanyVO companyVO = new CostCenterCompanyVO();
                companyVO.setId(veGs.getId());  //公司主键id
                companyVO.setLabel(veGs.getMc()); //公司名称
                companyVO.setValue(veGs.getBh()); //公司编号
                RepCbzx veCbzx = new RepCbzx();
                veCbzx.setQybh(dto.getQybh());
                veCbzx.setGsid(veGs.getId());
                veCbzx.setZt(CostCenterConstants.COSTCENTER_XMZT_ZC);
                List<RepCbzx> veCbzxList = veCbzxService.selectVeCbzxListByQybh(veCbzx);
                if (CollectionUtils.isNotEmpty(veCbzxList)) {
                    List<CostCenterVO> cbzxList = new ArrayList<>();
                    for (RepCbzx cbzx : veCbzxList) {
                        CostCenterVO costCenterVO = new CostCenterVO();
                        costCenterVO.setId(cbzx.getId()); //成本中心主键id
                        costCenterVO.setLabel(cbzx.getCbzxmc());//成本中心名称
                        costCenterVO.setValue(cbzx.getCbzxbh());//成本中心编号
                        cbzxList.add(costCenterVO);
                    }
                    companyVO.setCbzxList(cbzxList);
                }
                targetList.add(companyVO);
            }
        }
        return targetList;*/
        return null;
    }
}
