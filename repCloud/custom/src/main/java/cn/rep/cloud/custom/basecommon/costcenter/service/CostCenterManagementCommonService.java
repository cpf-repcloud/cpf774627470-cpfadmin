package cn.rep.cloud.custom.basecommon.costcenter.service;


import cn.rep.cloud.custom.basecommon.costcenter.business.VeCbzxServiceImpl;
import cn.rep.cloud.custom.basecommon.costcenter.entity.VeCbzx;
import cn.rep.cloud.custom.basecommon.costcenter.service.dto.CostCenterBaseDTO;
import cn.rep.cloud.custom.basecommon.costcenter.service.vo.*;
import cn.rep.cloud.custom.coreutils.common.VeCollectionUtils;
import cn.rep.cloud.custom.coreutils.utils.BeanMapper;
import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.metamodel.Type;
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
    private VeCbzxServiceImpl veCbzxService;
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
    public void costCenterListTreeRecursive(List<VeCbzx> list, Map<String, List<VeCbzx>> costCenterMap, CostCenterTreeVO treeVO) {
        /**递归跳出的条件**/
        if (CollectionUtils.isNotEmpty(list)) {
            List<CostCenterTreeVO> costCenterList = new ArrayList<CostCenterTreeVO>();
            for (VeCbzx veCbzx : list) {
                /**将成本中心对象保存到输出页面VO对象**/
                CostCenterTreeVO costCenterTreeVO = BeanMapper.map(veCbzx,CostCenterTreeVO.class);
                costCenterTreeVO.setTitle(veCbzx.getCbzxmc());
                costCenterTreeVO.setExpand("false");
                costCenterList.add(costCenterTreeVO);
                /**继续递归筛选下级成本中心信息并填充到VO对象**/
                String id = veCbzx.getId();
                List<VeCbzx> veCbzxList = costCenterMap.get(id);
                costCenterListTreeRecursive(veCbzxList, costCenterMap, costCenterTreeVO);
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
        VeCbzx veCbzx = new VeCbzx();
        veCbzx.setQybh(costCenterBaseDTO.getQybh());
        veCbzx.setGsid(costCenterBaseDTO.getGsid());
        List<VeCbzx> veCbzxList = veCbzxService.selectVeCbzxListByQybh(veCbzx);
        targetList = BeanMapper.mapList(veCbzxList,  CostCenterBaseVO.class);
        return targetList;
    }

    /**
     * 根据企业编号查询成本中心树给控件
     *
     * @param costCenterBaseDTO 成本中心列表Dto
     * @return CostCenterControlVO 成本中心
     */
    public CostCenterControlVO selectVeCbzxTreeListToControl(CostCenterBaseDTO costCenterBaseDTO) {
        VeCbzx veCbzx = new VeCbzx();
        List<CostCenterBaseVO> targetList = new ArrayList<CostCenterBaseVO>();
        veCbzx.setQybh(costCenterBaseDTO.getQybh());
        veCbzx.setGsid(costCenterBaseDTO.getGsid());
        List<VeCbzx> veCbzxList = veCbzxService.selectVeCbzxListByQybh(veCbzx);
        CostCenterControlVO treeVO = new CostCenterControlVO();
        /**根据上级编号进行分组**/
        Map<String, List<VeCbzx>> costCenterMap = null;
        try {
            costCenterMap = VeCollectionUtils.group(veCbzxList, "sjbh");
        } catch (Exception e) {
            logger.error("成本中心分组异常：", e);
        }
        List<VeCbzx> vecbzxlist = new ArrayList<VeCbzx>();
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
    public void costCenterListTreeRecursiveToControl(List<VeCbzx> list, Map<String, List<VeCbzx>> costCenterMap, CostCenterControlVO treeVO) {
        /**递归跳出的条件**/
        if (CollectionUtils.isNotEmpty(list)) {
            List<CostCenterControlVO> costCenterList = new ArrayList<CostCenterControlVO>();
            for (VeCbzx veCbzx : list) {
                /**将成本中心对象保存到输出页面VO对象**/
                CostCenterControlVO costCenterTreeVO = new CostCenterControlVO();
                costCenterTreeVO.setId(veCbzx.getId());
                costCenterTreeVO.setLabel(veCbzx.getCbzxmc());
                costCenterTreeVO.setValue(veCbzx.getCbzxbh());
                costCenterList.add(costCenterTreeVO);

                /**继续递归筛选下级成本中心信息并填充到VO对象**/
                String cbzxbh = veCbzx.getCbzxbh();
                List<VeCbzx> veCbzxList = costCenterMap.get(cbzxbh);
                costCenterListTreeRecursiveToControl(veCbzxList, costCenterMap, costCenterTreeVO);
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
                VeCbzx veCbzx = new VeCbzx();
                veCbzx.setQybh(dto.getQybh());
                veCbzx.setGsid(veGs.getId());
                veCbzx.setZt(CostCenterConstants.COSTCENTER_XMZT_ZC);
                List<VeCbzx> veCbzxList = veCbzxService.selectVeCbzxListByQybh(veCbzx);
                if (CollectionUtils.isNotEmpty(veCbzxList)) {
                    List<CostCenterVO> cbzxList = new ArrayList<>();
                    for (VeCbzx cbzx : veCbzxList) {
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
