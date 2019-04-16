package cn.rep.cloud.custom.basecommon.costcenter.controller;

import cn.rep.cloud.custom.basecommon.costcenter.service.CostCenterManagementBusinessService;
import cn.rep.cloud.custom.basecommon.costcenter.service.dto.CostCenterListDTO;
import cn.rep.cloud.custom.basecommon.costcenter.service.dto.CostCenterManagementDTO;
import cn.rep.cloud.custom.basecommon.costcenter.service.dto.CostCenterOperationDTO;
import cn.rep.cloud.custom.basecommon.costcenter.service.vo.CostCenterDetailVO;
import cn.rep.cloud.custom.basecommon.costcenter.service.vo.CostCenterListVO;
import cn.rep.cloud.custom.basecommon.costcenter.service.vo.CostCenterTreeVO;
import cn.rep.cloud.custom.coreutils.common.PageDTO;
import cn.rep.cloud.custom.coreutils.common.RestResponse;
import cn.rep.cloud.custom.coreutils.systemexception.SystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *项目管理
 * /controller
 */
@RestController
@RequestMapping(value = "/costcenter")
public class RepCbzxController {

    /**
     * 日志记录
     */
   private  Logger logger= LoggerFactory.getLogger(RepCbzxController.class);


    /***
     * 成本中心管理
     */
    @Autowired
    private CostCenterManagementBusinessService costCenterManagementBusinessService;


    /**
     * 查询成本中心树形结构【递归查询成本中心数据】
     *`
     * @param dto [页面带过来的查询参数]
     * @return RestResponse<CostCenterTreeVO>
     * @author yangxianglin
     * @date 2018-08-06 09:35:25
     */
    @PostMapping(value = "/queryCostCenterTree")
    public RestResponse<CostCenterTreeVO> queryCostCenterTree(@RequestBody CostCenterManagementDTO dto) {
        
        CostCenterTreeVO costCenterTreeVO = costCenterManagementBusinessService.queryCostCenterTree(dto);
        return new RestResponse<>(costCenterTreeVO);
    }

    /**
     *  成本中心分页列表
     * @param pageDTO 查询条件
     * @return  List<CostCenterPageListVO>
     * @throws SystemException [抛异常]
     * @author yangxianglin
     * @date   2018-08-06 11:00:25
     */
    @PostMapping(value = "/selectCostCenterPageList")
    public RestResponse<CostCenterListVO> selectCostCenterPageList(@RequestBody PageDTO<CostCenterListDTO> pageDTO) throws SystemException {
       /* pageDTO.getData().setQybh(loginUser.getQybh());
        pageDTO.getData().setGsid(loginUser.getGsid());*/
        CostCenterListVO listVO = costCenterManagementBusinessService.selectCostCenterPageList(pageDTO);
        return new RestResponse<>(listVO);
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
    @PostMapping(value = "/selectCostCenterDetail")
    public RestResponse<CostCenterDetailVO> selectCostCenterDetail(@RequestBody CostCenterOperationDTO operationDTO) throws SystemException {
        CostCenterDetailVO vo = costCenterManagementBusinessService.selectCostCenterDetail(operationDTO);
        return new RestResponse<>(vo);
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
    @PostMapping(value = "/insertCostCenter")
    public RestResponse<Boolean> insertCostCenter(@RequestBody CostCenterOperationDTO operationDTO) throws SystemException {
        /*operationDTO.setCzr(loginUser.getId());
        operationDTO.setGsid(loginUser.getGsid());*/
        Boolean code = costCenterManagementBusinessService.insertCostCenter(operationDTO);
        return new RestResponse<>(code);
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
    @PostMapping(value = "/updateCostCenter")
    public RestResponse<Boolean> updateCostCenter(@RequestBody CostCenterOperationDTO operationDTO) throws SystemException {
       // operationDTO.setCzr(loginUser.getId());
        Boolean code = costCenterManagementBusinessService.updateCostCenter(operationDTO);
        return new RestResponse<>(code);
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
    @PostMapping(value = "/updateCostCenterZt")
    public RestResponse<Boolean> updateCostCenterZt(@RequestBody CostCenterOperationDTO operationDTO) throws SystemException {
        Boolean code = costCenterManagementBusinessService.updateCostCenterZt(operationDTO);
        return new RestResponse<>(code);
    }

    /**
     * 成本中心管理-验证成本中心编号是否重复
     *
     * @param operationDTO 成本中心对象
     * @return 是否成功【true:有重复 false:没有重复】
     * @throws SystemException [抛异常]
     * @author yxl
     * @date 2018-08-07 10:05:20
     */
    @PostMapping(value = "/verificationCbzxbh")
    public RestResponse<Boolean> verificationCbzxbh(@RequestBody CostCenterOperationDTO operationDTO) throws SystemException {
       // operationDTO.setGsid(loginUser.getGsid());
        Boolean code = costCenterManagementBusinessService.verificationCbzxbh(operationDTO);
        return new RestResponse<>(code);
    }
}
