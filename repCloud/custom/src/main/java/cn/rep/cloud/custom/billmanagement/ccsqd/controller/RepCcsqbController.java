package cn.rep.cloud.custom.billmanagement.ccsqd.controller;

import cn.rep.cloud.custom.billmanagement.ccsqd.business.RepCcsqbBusinessService;
import cn.rep.cloud.custom.billmanagement.ccsqd.dto.RepCcsqbDTO;
import cn.rep.cloud.custom.billmanagement.ccsqd.service.RepCcsqbService;
import cn.rep.cloud.custom.billmanagement.ccsqd.vo.RepCcsqbVO;
import cn.rep.cloud.custom.coreutils.common.BaseController;
import cn.rep.cloud.custom.coreutils.common.PageDTO;
import cn.rep.cloud.custom.coreutils.common.RestResponse;
import com.baomidou.mybatisplus.plugins.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.ws.Response;

/**
 * 出差申请单controller
 */
@Controller
@RequestMapping("repccsqb")
public class RepCcsqbController extends BaseController {

    /**
     * 日志记录
     */
    private Logger logger = LoggerFactory.getLogger(RepCcsqbController.class);

    @Autowired
    private RepCcsqbBusinessService repCcsqbBusinessService;


    /**
     * 新增出差申请单
     *
     * @param dto
     * @return
     */
    @RequestMapping("insertCcsqb")
    public RestResponse<Boolean> insertCcsqb(@RequestBody RepCcsqbDTO dto) {
        dto.setQybh(loginUser.getQybh());
        dto.setGsid(loginUser.getGsid());
        Boolean isSul = repCcsqbBusinessService.insertCcsqd(dto);
        return new RestResponse<Boolean>(isSul);
    }


    /**
     * 新增出差申请单 列表
     *
     * @param pageDTO
     * @return
     */
    @RequestMapping("queryCcsqbPage")
    public RestResponse<Page> queryCcsqbPage(@RequestBody PageDTO<RepCcsqbDTO> pageDTO) {
        pageDTO.getData().setQybh(loginUser.getQybh());
        pageDTO.getData().setGsid(loginUser.getGsid());
        pageDTO.getData().setSqrid(loginUser.getId());
        Page<RepCcsqbVO> page = repCcsqbBusinessService.queryCcsqbPage(pageDTO);
        return new RestResponse<>(page);
    }

    /**
     * 确认出差完成
     *
     * @param dto
     * @return
     */
    @RequestMapping("confirmCcsqb")
    public RestResponse<Boolean> confirmCcsqb(@RequestBody RepCcsqbDTO dto) {
        dto.setQybh(loginUser.getQybh());
        dto.setGsid(loginUser.getGsid());
        Boolean isFul = repCcsqbBusinessService.confirmCcsqb(dto);
        return new RestResponse<>(isFul);
    }

    /**
     * 查询出差申请表详情
     *
     * @param dto
     * @return
     */
    @RequestMapping("queryCcsqbDetail")
    public RestResponse<RepCcsqbVO> queryCcsqbDetail(@RequestBody RepCcsqbDTO dto) {
        RepCcsqbVO vo = repCcsqbBusinessService.queryCcsqbDetail(dto.getSqdh());
        return new RestResponse<>(vo);
    }


}
