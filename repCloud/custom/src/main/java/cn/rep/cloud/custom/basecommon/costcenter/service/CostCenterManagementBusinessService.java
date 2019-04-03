package cn.rep.cloud.custom.basecommon.costcenter.service;


import cn.rep.cloud.custom.basecommon.costcenter.business.VeCbzxBmServiceImpl;
import cn.rep.cloud.custom.basecommon.costcenter.business.VeCbzxServiceImpl;
import cn.rep.cloud.custom.basecommon.costcenter.business.VeXmCbzxServiceImpl;
import cn.rep.cloud.custom.basecommon.costcenter.entity.VeCbzx;
import cn.rep.cloud.custom.basecommon.costcenter.entity.VeCbzxBm;
import cn.rep.cloud.custom.basecommon.costcenter.entity.VeXmCbzx;
import cn.rep.cloud.custom.basecommon.costcenter.service.dto.CostCenterListDTO;
import cn.rep.cloud.custom.basecommon.costcenter.service.dto.CostCenterManagementDTO;
import cn.rep.cloud.custom.basecommon.costcenter.service.dto.CostCenterOperationDTO;
import cn.rep.cloud.custom.basecommon.costcenter.service.vo.CostCenterDetailVO;
import cn.rep.cloud.custom.basecommon.costcenter.service.vo.CostCenterListVO;
import cn.rep.cloud.custom.basecommon.costcenter.service.vo.CostCenterPageListVO;
import cn.rep.cloud.custom.basecommon.costcenter.service.vo.CostCenterTreeVO;
import cn.rep.cloud.custom.coreutils.common.IdGenerator;
import cn.rep.cloud.custom.coreutils.common.PageDTO;
import cn.rep.cloud.custom.coreutils.common.VeCollectionUtils;
import cn.rep.cloud.custom.coreutils.systemexception.SystemException;
import cn.rep.cloud.custom.coreutils.utils.BeanMapper;
import cn.rep.cloud.custom.coreutils.utils.DateUtils;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 成本中心管理业务层service
 *
 * @author yangxianglin
 *         Created by vetech on 2018/8/06.
 */
@Service
public class CostCenterManagementBusinessService {
    /**
     * 日志记录
     */
    private Logger logger = LoggerFactory.getLogger(CostCenterManagementBusinessService.class);

    /**
     * 成本中心管理Dao
     */
    @Autowired
    private VeCbzxServiceImpl veCbzxService;

    /**
     * 成本中心管理公共service
     */
    @Autowired
    private CostCenterManagementCommonService costCenterManagementCommonService;
    /**
     * 成本中心项目service
     */
    @Autowired
    private VeXmCbzxServiceImpl veXmCbzxService;
    /**
     * 成本中心部门service
     */
    @Autowired
    private VeCbzxBmServiceImpl veCbzxBmService;

    /**
     * 成本中心分页列表
     *
     * @param pageDTO 查询条件
     * @return listVO
     * @throws SystemException [抛异常]
     */
    public CostCenterListVO selectCostCenterPageList(PageDTO<CostCenterListDTO> pageDTO) throws SystemException {
        if (StringUtils.isBlank(pageDTO.getData().getQybh())) {
            logger.info("企业编号不能为空");
            //throw new SystemException();
        }
        if (StringUtils.isBlank(pageDTO.getData().getId())) {
            logger.info("成本中心主键id不能为空");
           // throw new SystemException(BaseExceptionEnum.BASE_COSTCENTER_0000_04_0074);
        }
        List<CostCenterPageListVO> costCenterVOs = new ArrayList<CostCenterPageListVO>();
        List<String> cbzxidList = new ArrayList<String>();
        CostCenterListVO listVO = new CostCenterListVO();
        logger.info("点击查询成本中心列表数据入参：" + pageDTO.getData());
        VeCbzx param = new VeCbzx();
        param.setQybh(pageDTO.getData().getQybh());
        param.setGsid(pageDTO.getData().getGsid());
        List<VeCbzx> paramList = veCbzxService.selectVeCbzxListByQybh(param);
        List<CostCenterPageListVO> veCbzxList = BeanMapper.mapList(paramList,CostCenterPageListVO.class);
        /**获取当前成本中心信息并加到输出对象中**/
        if (CollectionUtils.isNotEmpty(veCbzxList)) {
            for (CostCenterPageListVO vo : veCbzxList) {
                if (vo.getId().equals(pageDTO.getData().getId())) {
                    costCenterVOs.add(vo);
                    break;
                }
            }
        }
        /**根据上级编号进行分组**/
        Map<String, List<CostCenterPageListVO>> costCenterMap = null;
        try {
            costCenterMap = VeCollectionUtils.group(veCbzxList, "sjbh");
        } catch (Exception e) {
            logger.error("公司集合分组异常：", e);
        }
        /**获取当前成本中心的下一级成本中心集合**/
        List<CostCenterPageListVO> cbzxlist = null;
        if (costCenterMap != null) {
            cbzxlist = costCenterMap.get(pageDTO.getData().getId());
        }
        if(CollectionUtils.isEmpty(cbzxlist)){
            cbzxidList.add(pageDTO.getData().getId());
        }else{
            costCenterManagementCommonService.costCenterListRecursive(cbzxlist, costCenterMap, costCenterVOs);
        }
        if (CollectionUtils.isNotEmpty(costCenterVOs) && CollectionUtils.isNotEmpty(cbzxlist)) {
            for (CostCenterPageListVO vo : costCenterVOs) {
                cbzxidList.add(vo.getId());
            }
        }
        pageDTO.getData().setCbzxidList(cbzxidList);
        /**根据企业编号获取该企业下所有的成本中心分页数据**/
        Page<CostCenterPageListVO> listVOPage = veCbzxService.selectCostCenterPageList(pageDTO);
        //列表上面详情信息
        VeCbzx veCbzx = veCbzxService.selectVeCbzxById(pageDTO.getData().getId());
        if (veCbzx == null) {
           // throw new SystemException(BaseExceptionEnum.BASE_COSTCENTER_0000_04_0125);
        }
        if (veCbzx != null) {
            listVO.setId(veCbzx.getId());         //成本中心主键id
            listVO.setCbzxbh(veCbzx.getCbzxbh()); //成本中心编号
            listVO.setCbzxmc(veCbzx.getCbzxmc()); //成本中心名称
            listVO.setZt(veCbzx.getZt());         //状态
            /****查询关联部门名称********/
            List<String> cbzxBmList = veCbzxBmService.getVeCbzxBmMcListByCbzxid(veCbzx.getId());
            if (CollectionUtils.isNotEmpty(cbzxBmList)) {
                String bmmcStr = this.getGlbmmc(cbzxBmList);
                listVO.setGlbmmc(bmmcStr);
            }
            /****查询关联项目名称********/
            List<String> cbzxXmList = veXmCbzxService.getVeXmCbzxMcListByCbzxid(veCbzx.getId());
            if (CollectionUtils.isNotEmpty(cbzxXmList)) {
                String xmmcStr = this.getGlxmmc(cbzxXmList);
                listVO.setGlxmmc(xmmcStr);
            }
        }
        if (CollectionUtils.isNotEmpty(listVOPage.getRecords())) {
            for (CostCenterPageListVO vo : listVOPage.getRecords()) {
                /****查询关联部门名称********/
                List<String> cbzxBmList = veCbzxBmService.getVeCbzxBmMcListByCbzxid(vo.getId());
                if (CollectionUtils.isNotEmpty(cbzxBmList)) {
                    String bmmcStr = this.getGlbmmc(cbzxBmList);
                    vo.setGlbmmc(bmmcStr);
                }
                /****查询关联项目名称********/
                List<String> cbzxXmList = veXmCbzxService.getVeXmCbzxMcListByCbzxid(vo.getId());
                if (CollectionUtils.isNotEmpty(cbzxXmList)) {
                    String xmmcStr = this.getGlxmmc(cbzxXmList);
                    vo.setGlxmmc(xmmcStr);
                }
            }
        }
        listVO.setPageList(listVOPage); //成本中心分页集合数据
        return listVO;
    }

    /**
     * 获取关联部门
     *
     * @param cbzxBmList 关联部门名称集合
     * @return String
     */
    public String getGlbmmc(List<String> cbzxBmList) {
        StringBuffer buffer = new StringBuffer();
        String bmmcStr = "";
        if (CollectionUtils.isNotEmpty(cbzxBmList)) {
            for (String bmmc : cbzxBmList) {
                buffer.append(bmmc).append("，");
            }
            bmmcStr = buffer.toString().substring(0, buffer.toString().length() - 1);
        }
        return bmmcStr;
    }

    /**
     * 获取关联项目
     *
     * @param cbzxXmList 关联项目名称集合
     * @return String
     */
    public String getGlxmmc(List<String> cbzxXmList) {
        StringBuffer buffer = new StringBuffer();
        String xmmcStr = "";
        if (CollectionUtils.isNotEmpty(cbzxXmList)) {
            for (String bmmc : cbzxXmList) {
                buffer.append(bmmc).append("，");
            }
            xmmcStr = buffer.toString().substring(0, buffer.toString().length() - 1);
        }
        return xmmcStr;
    }


    /**
     * 成本中心-树形菜单
     *
     * @param costCenterManagementDTO 入参对象
     * @return 树形菜单VO
     */
    public CostCenterTreeVO queryCostCenterTree(CostCenterManagementDTO costCenterManagementDTO) {
        logger.info("成本中心管理-树形接口入参：【" + costCenterManagementDTO + "】");
        CostCenterTreeVO treeVO = new CostCenterTreeVO();
        /**根据企业编号获取该企业下所有的成本中心**/
        List<VeCbzx> veCbzxList = veCbzxService.getVeCbzxList(costCenterManagementDTO);
        if (CollectionUtils.isEmpty(veCbzxList)) {
            logger.info("成本中心管理-企业公司查询为空");
            return null;
        }
        /**根据上级编号进行分组**/
        Map<String, List<VeCbzx>> costCenterMap = null;
        try {
            costCenterMap = VeCollectionUtils.group(veCbzxList, "sjbh");
        } catch (Exception e) {
            logger.error("成本中心分组异常：", e);
        }
        List<VeCbzx> vecbzxlist = null;
        if (costCenterMap != null) {
            vecbzxlist = costCenterMap.get("none");
        }
        if(CollectionUtils.isEmpty(vecbzxlist)){
             vecbzxlist = BeanMapper.mapList(veCbzxList,VeCbzx.class);
        }
        /**调用递归方法筛选下级成本中心数据**/
        costCenterManagementCommonService.costCenterListTreeRecursive(vecbzxlist, costCenterMap, treeVO);
        return treeVO;
    }

    /**
     * 查询成本中心详情数据
     *
     * @param operationDTO 传入参数
     * @return CostCenterDetailVO
     * @throws SystemException [抛异常]
     * @author yxl
     * @date 2018-08-07 10:05:20
     */
    public CostCenterDetailVO selectCostCenterDetail(CostCenterOperationDTO operationDTO) throws SystemException {
        logger.info("查询成本中心详情信息传入参数：" + operationDTO);
        if (StringUtils.isBlank(operationDTO.getId())) {
            logger.info("成本中心主键id不能为空");
           // throw new SystemException(BaseExceptionEnum.BASE_COSTCENTER_0000_04_0074);
        }
        VeCbzx veCbzx = veCbzxService.selectVeCbzxById(operationDTO.getId());
        CostCenterDetailVO costCenterDetailVO = BeanMapper.map(veCbzx, CostCenterDetailVO.class);
        /****查询关联部门********/
        VeCbzxBm veCbzxBm = new VeCbzxBm();
        veCbzxBm.setCbzxid(veCbzx.getId());
        List<VeCbzxBm> cbzxBmList = veCbzxBmService.getVeCbzxBmListByCbzxid(veCbzxBm);
        /****查询关联项目********/
        VeXmCbzx veXmCbzx = new VeXmCbzx();
        veXmCbzx.setCbzxid(veCbzx.getId());
        List<VeXmCbzx> cbzxXmList = veXmCbzxService.getVeXmCbzxListByCbzxid(veXmCbzx);
        if (costCenterDetailVO != null) {
            costCenterDetailVO.setBmList(cbzxBmList); //部门集合
            costCenterDetailVO.setXmList(cbzxXmList); //项目集合
        }
        return costCenterDetailVO;
    }

    /**
     * 成本中心新增数据
     *
     * @param operationDTO 传入参数
     * @return Boolean 【true:成功 false:失败】
     * @throws SystemException [抛异常]
     * @author yxl
     * @date 2018-08-07 10:05:20
     */
    public Boolean insertCostCenter(CostCenterOperationDTO operationDTO) throws SystemException {
        Boolean flag = Boolean.FALSE;
        logger.info("新增成本中心传入参数：" + operationDTO);
        if (StringUtils.isBlank(operationDTO.getQybh())) {
            logger.info("企业编号不能为空");
            //throw new SystemException(BaseExceptionEnum.BASE_COSTCENTER_0000_04_0077);
        }
        if (StringUtils.isBlank(operationDTO.getCbzxbh())) {
            logger.info("成本中心编号不能为空");
            //throw new SystemException(BaseExceptionEnum.BASE_COSTCENTER_0000_04_0075);
        }
        if (StringUtils.isBlank(operationDTO.getCbzxmc())) {
            logger.info("成本中心名称不能为空");
           // throw new SystemException(BaseExceptionEnum.BASE_COSTCENTER_0000_04_0076);
        }
        if (this.verificationCbzxbh(operationDTO)) {
            logger.info("成本中心编号不能重复");
           // throw new SystemException(BaseExceptionEnum.BASE_COSTCENTER_0000_04_0078);
        }
        VeCbzx veCbzx = new VeCbzx();
        veCbzx.setId(IdGenerator.getHexId());
        veCbzx.setQybh(operationDTO.getQybh());
        veCbzx.setGsid(operationDTO.getGsid());
        veCbzx.setCbzxbh(operationDTO.getCbzxbh());
        veCbzx.setCbzxmc(operationDTO.getCbzxmc());
        veCbzx.setSjbh(operationDTO.getSjbh());
        veCbzx.setZt("");
        veCbzx.setSfdlys(operationDTO.getSfdlys());
        veCbzx.setZhxgr(operationDTO.getCzr());
        veCbzx.setZhxgsj(DateUtils.getNow());
        flag = veCbzxService.insertCostCenter(veCbzx);
        if(!flag){
           // throw new SystemException(BaseExceptionEnum.BASE_COSTCENTER_0000_04_0146);
        }
        /******入库关联部门************/
        if (flag && CollectionUtils.isNotEmpty(operationDTO.getBmidList())) {
            List<VeCbzxBm> cbzxBmList = new ArrayList<VeCbzxBm>();
            for (String bmid : operationDTO.getBmidList()) {
                VeCbzxBm veCbzxBm = new VeCbzxBm();
                veCbzxBm.setId(IdGenerator.getHexId());
                veCbzxBm.setQybh(operationDTO.getQybh());
                veCbzxBm.setCbzxid(veCbzx.getId());
                veCbzxBm.setBmid(bmid);
                veCbzxBm.setZhxgr(operationDTO.getCzr());
                veCbzxBm.setZhxgsj(DateUtils.getNow());
                cbzxBmList.add(veCbzxBm);
            }
            flag = veCbzxBmService.insertVeCbzxBmList(cbzxBmList);
            if(!flag){
               // throw new SystemException(BaseExceptionEnum.BASE_COSTCENTER_0000_04_0148);
            }
            logger.info("批量插入成本中心部门数据返回结果：" + flag);
        }
        /******入库关联项目************/
        if (flag && CollectionUtils.isNotEmpty(operationDTO.getXmidList())) {
            List<VeXmCbzx> xmCbzxList = new ArrayList<VeXmCbzx>();
            for (String xmid : operationDTO.getXmidList()) {
                VeXmCbzx veXmCbzx = new VeXmCbzx();
                veXmCbzx.setId(IdGenerator.getHexId());
                veXmCbzx.setQybh(operationDTO.getQybh());
                veXmCbzx.setCbzxid(veCbzx.getId());
                veXmCbzx.setXmid(xmid);
                veXmCbzx.setZhxgr(operationDTO.getCzr());
                veXmCbzx.setZhxgsj(DateUtils.getNow());
                xmCbzxList.add(veXmCbzx);
            }
            flag = veXmCbzxService.insertVeXmCbzxList(xmCbzxList);
            logger.info("批量插入成本中心项目数据返回结果：" + flag);
            if(!flag){
                //throw new SystemException(BaseExceptionEnum.BASE_COSTCENTER_0000_04_0149);
            }
        }
        return flag;
    }

    /**
     * 成本中心管理-验证成本中心编号是否重复
     *
     * @param operationDTO 成本中心编号
     * @return 是否成功【true:有重复 false:没有重复】
     * @throws SystemException [抛异常]
     * @author yxl
     * @date 2018-08-07 10:05:20
     */
    public Boolean verificationCbzxbh(CostCenterOperationDTO operationDTO) throws SystemException {
        logger.info("成本中心管理-成本中心编号即时验证-成本中心编号：【" + operationDTO.getCbzxbh() + "】");
        Boolean flag = Boolean.FALSE;
        if (StringUtils.isBlank(operationDTO.getCbzxbh())) {
            logger.info("成本中心编号不能为空");
            //throw new SystemException(BaseExceptionEnum.BASE_COSTCENTER_0000_04_0075);
        }
        //同一个公司下面成本中心编号不允许重复
        VeCbzx veCbzx = new VeCbzx();
        veCbzx.setCbzxbh(operationDTO.getCbzxbh());
        veCbzx.setGsid(operationDTO.getGsid());
        VeCbzx vebm = veCbzxService.getVeCbzxByCbzxbh(veCbzx);
        if (vebm != null) {
            flag = Boolean.TRUE;
        }
        return flag;
    }

    /**
     * 成本中心编辑数据
     *
     * @param operationDTO 传入参数
     * @return Boolean 【true:成功 false:失败】
     * @throws SystemException [抛异常]
     * @author yxl
     * @date 2018-08-07 10:05:20
     */
    public Boolean updateCostCenter(CostCenterOperationDTO operationDTO) throws SystemException {
        logger.info("编辑成本中心传入参数：" + operationDTO);
        Boolean flag = Boolean.FALSE;
        if (StringUtils.isBlank(operationDTO.getId())) {
            logger.info("成本中心主键id不能为空");
          //  throw new SystemException(BaseExceptionEnum.BASE_COMPANY_1001);
        }
        VeCbzx veCbzx = veCbzxService.selectVeCbzxById(operationDTO.getId());
        if (veCbzx != null) {
            veCbzx.setCbzxmc(operationDTO.getCbzxmc());
            veCbzx.setSfdlys(operationDTO.getSfdlys());
            veCbzx.setZhxgr(operationDTO.getCzr());
            veCbzx.setZhxgsj(DateUtils.getNow());
            flag = veCbzxService.updateCostCenter(veCbzx);
            if(!flag){
                //throw new SystemException(BaseExceptionEnum.BASE_COSTCENTER_0000_04_0147);
            }
            logger.info("编辑成本中心后返回结果：" + flag);
            /****处理关联部门数据**********/
            if (flag && CollectionUtils.isNotEmpty(operationDTO.getBmidList())) {
                /******编辑进来先做删除**********/
                VeCbzxBm veCbzxBm = new VeCbzxBm();
                veCbzxBm.setCbzxid(veCbzx.getId());
                veCbzxBm.setQybh(veCbzx.getQybh());
                List<VeCbzxBm> veCbzxBmList = veCbzxBmService.getVeCbzxBmListByCbzxid(veCbzxBm);
                List<String> ids = new ArrayList<String>();
                if (CollectionUtils.isNotEmpty(veCbzxBmList)) {
                    for (VeCbzxBm bm : veCbzxBmList) {
                        ids.add(bm.getId());
                    }
                    flag = veCbzxBmService.deleteVeCbzxBmList(ids);
                    if(!flag){
                       // throw new SystemException(BaseExceptionEnum.BASE_COSTCENTER_0000_04_0150);
                    }
                }
                /******再来做新增**********/
                List<VeCbzxBm> zxbmList = new ArrayList<VeCbzxBm>();
                for (String bmid : operationDTO.getBmidList()) {
                    VeCbzxBm bm = new VeCbzxBm();
                    bm.setId(IdGenerator.getHexId());
                    bm.setQybh(operationDTO.getQybh());
                    bm.setBmid(bmid);
                    bm.setCbzxid(veCbzx.getId());
                    bm.setZhxgr(operationDTO.getCzr());
                    bm.setZhxgsj(DateUtils.getNow());
                    zxbmList.add(bm);
                }
                flag = veCbzxBmService.insertVeCbzxBmList(zxbmList);
                if(!flag){
                    //throw new SystemException(BaseExceptionEnum.BASE_COSTCENTER_0000_04_0148);
                }
                logger.info("编辑时批量插入成本中心部门数据返回结果：" + flag);
            }
            /****处理关联项目数据**********/
            if (flag && CollectionUtils.isNotEmpty(operationDTO.getXmidList())) {
                /******编辑进来先做删除**********/
                VeXmCbzx veXmCbzx = new VeXmCbzx();
                veXmCbzx.setCbzxid(veCbzx.getId());
                veXmCbzx.setQybh(veCbzx.getQybh());
                List<VeXmCbzx> veXmCbzxList = veXmCbzxService.getVeXmCbzxListByCbzxid(veXmCbzx);
                List<String> ids = new ArrayList<String>();
                if (CollectionUtils.isNotEmpty(veXmCbzxList)) {
                    for (VeXmCbzx xm : veXmCbzxList) {
                        ids.add(xm.getId());
                    }
                    flag = veXmCbzxService.deleteVeXmCbzxList(ids);
                    if(!flag){
                       // throw new SystemException(BaseExceptionEnum.BASE_COSTCENTER_0000_04_0151);
                    }
                }
                /******再来做新增**********/
                List<VeXmCbzx> zxxmList = new ArrayList<VeXmCbzx>();
                for (String xmid : operationDTO.getXmidList()) {
                    VeXmCbzx xm = new VeXmCbzx();
                    xm.setId(IdGenerator.getHexId());
                    xm.setQybh(operationDTO.getQybh());
                    xm.setXmid(xmid);
                    xm.setCbzxid(veCbzx.getId());
                    xm.setZhxgsj(DateUtils.getNow());
                    xm.setZhxgr(operationDTO.getCzr());
                    zxxmList.add(xm);
                }
                flag = veXmCbzxService.insertVeXmCbzxList(zxxmList);
                if(!flag){
                  //  throw new SystemException(BaseExceptionEnum.BASE_COSTCENTER_0000_04_0149);
                }
                logger.info("编辑时批量插入成本中心项目数据返回结果：" + flag);
            }
        }
        return flag;
    }

    /**
     * 成本中心修改状态数据
     *
     * @param operationDTO 传入参数
     * @return Boolean 【true:成功 false:失败】
     * @throws SystemException [抛异常]
     * @author yxl
     * @date 2018-08-07 10:05:20
     */
    public Boolean updateCostCenterZt(CostCenterOperationDTO operationDTO) throws SystemException {
        logger.info("修改成本中心状态传入参数：" + operationDTO);
        Boolean flag = Boolean.FALSE;
        if (StringUtils.isBlank(operationDTO.getId())) {
            logger.info("成本中心主键id不能为空");
           // throw new SystemException(BaseExceptionEnum.BASE_COMPANY_1001);
        }
        VeCbzx veCbzx = veCbzxService.selectVeCbzxById(operationDTO.getId());
        if (veCbzx != null) {
            veCbzx.setZt(operationDTO.getZt()); //项目状态
            flag = veCbzxService.updateCostCenter(veCbzx);
            logger.info("修改成本中心状态后返回结果：" + flag);
        }
        return flag;
    }


}
