package cn.rep.cloud.custom.basecommon.project.controller;

import cn.rep.cloud.custom.basecommon.project.service.ProjectManageService;
import cn.rep.cloud.custom.basecommon.project.service.ProjectMemberService;
import cn.rep.cloud.custom.basecommon.project.service.dto.AddProDTO;
import cn.rep.cloud.custom.basecommon.project.service.dto.SearchDataDTO;
import cn.rep.cloud.custom.basecommon.project.service.dto.SearchProMemberDTO;
import cn.rep.cloud.custom.basecommon.project.service.vo.ProDataVo;
import cn.rep.cloud.custom.basecommon.project.service.vo.ProMembersVO;
import cn.rep.cloud.custom.basecommon.project.service.vo.ProTreeVo;
import cn.rep.cloud.custom.coreutils.common.PageDTO;
import cn.rep.cloud.custom.coreutils.common.RestResponse;
import cn.rep.cloud.custom.coreutils.utils.DateUtils;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.lang3.StringUtils;
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
@RequestMapping("vexm")
public class RepXmController {

    /**
     * 日志记录
     */
   private  Logger logger= LoggerFactory.getLogger(RepXmController.class);


    /**
     * 新增项目service
     */
    @Autowired
    private ProjectManageService service;


    /**
     * 项目成员service
     */
    @Autowired
    private ProjectMemberService memberService;

    /**
     * 查询list分页
     *
     * @param dto 入参
     * @return
     */
    @PostMapping(value = "/proList")
    public RestResponse proList(@RequestBody PageDTO<SearchDataDTO> dto) {
       // String qybh = loginUser.getQybh();
       // dto.getData().setQybh(qybh);
        Page<ProDataVo> pagevo = service.selectPage(dto);
        return new RestResponse(pagevo);
    }

    /**
     * 添加项目数据
     *
     * @param dto 新增参数
     * @return
     */
    @PostMapping(value = "/addPro")
    public RestResponse addPro(@RequestBody AddProDTO dto) throws Exception {
      /*  String qybh = loginUser.getQybh();
        dto.setQybh(qybh);
        dto.setZhxgr(loginUser.getXm());
        dto.setZhxgsj(VeDate.getNow());
        dto.setGsid(loginUser.getGsid());*/
        int num = 0;
        if (StringUtils.isNotBlank(dto.getId())) {
            num = service.editPro(dto);
        } else {
            dto.setSfyx("1");
           // dto.setCjr(loginUser.getXm());
            dto.setCjsj(DateUtils.getNow());
            num = service.addPro(dto);
        }
        return new RestResponse(num);
    }


    /**
     * 获取树形结构数据
     *
     * @return
     */
    @PostMapping(value = "/getTreeList")
    public RestResponse getTreeList() {
        //String qybh = loginUser.getQybh();
        String gsid="123456789";
        ProTreeVo treeVo = service.getTreeList(gsid);
        return new RestResponse(treeVo);
    }

    /**
     * 通过主键id查询详情
     *
     * @param dto id
     * @return 返回详情vo
     */
    @PostMapping(value = "/getProDetail")
    public RestResponse getProDetail(@RequestBody SearchDataDTO dto) {
        //String qybh = loginUser.getQybh();
       // dto.setQybh(qybh);
        ProDataVo vo = service.getXmVoByData(dto);
        return new RestResponse(vo);
    }


    /**
     * 修改项目状态
     *
     * @param dto 入参
     * @return
     */
    @PostMapping(value = "/updateState")
    public RestResponse updateState(@RequestBody AddProDTO dto) {
        //String qybh = loginUser.getQybh();
        //dto.setQybh(qybh);
        int num = service.updateState(dto);
        return new RestResponse(num);

    }


    /**
     * 获取项目成员分页列表
     *
     * @param dto
     * @return
     */
    @PostMapping(value = "/getProMembers")
    public RestResponse getProMembers(@RequestBody PageDTO<SearchProMemberDTO> dto) {
       // String qybh = loginUser.getQybh();
       // dto.getData().setQybh(qybh);
        Page<ProMembersVO> page = memberService.getProMembers(dto);
        return new RestResponse(page);
    }


    /**
     * 删除项目成员
     *
     * @param dto
     * @return
     */
    @PostMapping(value = "deleteProCy")
    public RestResponse deleteProCy(@RequestBody SearchProMemberDTO dto) {
       // dto.setQybh(loginUser.getQybh());
        int num = memberService.deleteProCy(dto);
        return new RestResponse(num);
    }


    /**
     * 修改项目成员状态
     * @param dto
     * @return
     */
    @PostMapping(value = "updateCyzt")
    public RestResponse updateCyzt(@RequestBody SearchProMemberDTO dto) {
      //  dto.setQybh(loginUser.getQybh());
        int num = memberService.updateCyzt(dto);
        return new RestResponse(num);
    }

}
