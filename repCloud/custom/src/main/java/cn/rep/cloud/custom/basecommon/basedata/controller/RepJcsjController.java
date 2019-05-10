package cn.rep.cloud.custom.basecommon.basedata.controller;

import cn.rep.cloud.custom.basecommon.basedata.business.BasecommonSerivceImpl;
import cn.rep.cloud.custom.basecommon.basedata.service.dto.BaseDataLbVO;
import cn.rep.cloud.custom.basecommon.basedata.service.dto.BaseDataListDTO;
import cn.rep.cloud.custom.basecommon.basedata.service.vo.BaseDataLbDTO;
import cn.rep.cloud.custom.basecommon.basedata.service.vo.BaseDataListVO;
import cn.rep.cloud.custom.coreutils.common.BaseController;
import cn.rep.cloud.custom.coreutils.common.PageDTO;
import cn.rep.cloud.custom.coreutils.common.RestResponse;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.List;

/**
 * <p>
 * 基础数据表
 * </p>
 *
 * @author chenyong
 * @since 2018-08-06
 */
@RequestMapping("basecommon")
@RestController
public class RepJcsjController extends BaseController {

    @Autowired
    private BasecommonSerivceImpl basecommonSerivce;

    @RequestMapping("queryBaseCommonList")
    public RestResponse<Page<BaseDataListVO>> queryBaseCommonList(@RequestBody PageDTO<BaseDataListDTO> dto) {
        dto.getData().setGsid(loginUser.getGsid());
        dto.getData().setQybh(loginUser.getQybh());
        Page<BaseDataListVO> page = basecommonSerivce.queryBaseCommonList(dto);
        return new RestResponse<>(page);
    }
    /**
     * @param id
     * @return
     */
    @RequestMapping("getDataBeanById")
    public BaseDataListVO getDateBeanById(@RequestParam(value = "id") String id) {
        return basecommonSerivce.getBaseDataById(id);
    }
    /**
     * 查询 基础数据分组列表
     *
     * @param dto
     * @return
     */
    @RequestMapping("queryBaseLbList")
    public RestResponse<List<BaseDataLbVO>> queryBaseLbList(@RequestBody BaseDataLbDTO dto) {
        List<BaseDataLbVO> list = basecommonSerivce.queryBaseLbList(dto);
        return new RestResponse<>(list);
    }
    @RequestMapping("addDataBase")
    public RestResponse<Boolean> addDataBase(@RequestBody BaseDataListDTO dto) {
        dto.setQybh(loginUser.getQybh());
        dto.setGsid(loginUser.getGsid());
        dto.setZhxgr(loginUser.getId());
        dto.setZhxgrmc(loginUser.getXm());
        Boolean isSul = basecommonSerivce.addDataBaseLb(dto);
        return new RestResponse<>(isSul);
    }
    @RequestMapping("updateDataBase")
    public RestResponse<Boolean> updateDataBase(@RequestBody BaseDataListDTO dto) {
        dto.setQybh(loginUser.getQybh());
        dto.setGsid(loginUser.getGsid());
        dto.setZhxgr(loginUser.getId());
        dto.setZhxgrmc(loginUser.getXm());
        Boolean isSul = basecommonSerivce.updataDataBase(dto);
        return new RestResponse<>(isSul);
    }

    @RequestMapping("deleteDataBase")
    public RestResponse<Boolean> delBasicdata(@RequestBody BaseDataListDTO dto) {
        dto.setQybh(loginUser.getQybh());
        dto.setGsid(loginUser.getGsid());
        dto.setZhxgr(loginUser.getId());
        dto.setZhxgrmc(loginUser.getXm());
        Boolean isSul = basecommonSerivce.deleteDataBase(dto);
        return new RestResponse<>(isSul);
    }

    @RequestMapping("checkBaseData")
    public RestResponse<Boolean> checkBaseData(@RequestBody BaseDataListDTO dto) {
        dto.setQybh(loginUser.getQybh());
        dto.setGsid(loginUser.getGsid());
        dto.setZhxgrmc(loginUser.getXm());
        Boolean isSul = basecommonSerivce.checkBaseData(dto);
        return new RestResponse<>(isSul);
    }
    /**
     * 新增基础数据类别
     * @param dto
     * @return
     */
    @RequestMapping("addJcsjLb")
    public RestResponse<Integer> addJcsjLb(@RequestBody BaseDataLbDTO dto) {
        int i = basecommonSerivce.addJcsjLb(dto);
        return new RestResponse<>(i);
    }
    /**
     * 新增基础数据类别
     * @param dto
     * @return
     */
    @RequestMapping("editJcsjLb")
    public RestResponse<Integer> editJcsjLb(@RequestBody BaseDataLbDTO dto) {
        int i = basecommonSerivce.editJcsjLb(dto);
        return new RestResponse<>(i);
    }
}
