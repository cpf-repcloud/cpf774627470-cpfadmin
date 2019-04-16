package cn.rep.cloud.custom.basecommon.post.controller;

import cn.rep.cloud.custom.basecommon.post.dto.PostRankDataDTO;
import cn.rep.cloud.custom.basecommon.post.dto.PostRankSearchDTO;
import cn.rep.cloud.custom.basecommon.post.service.PostRankService;
import cn.rep.cloud.custom.basecommon.post.vo.PostRankControlVO;
import cn.rep.cloud.custom.basecommon.post.vo.PostRankDataVO;
import cn.rep.cloud.custom.coreutils.common.BaseController;
import cn.rep.cloud.custom.coreutils.common.RestResponse;
import cn.rep.cloud.custom.coreutils.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 公司岗位员工 Ui 入口
 * Created by vetech on 2018/7/26.
 */

@RestController
@RequestMapping("/postrank")
public class PostRankController extends BaseController {

    @Autowired
    private PostRankService postRankService;


    /**
     * 查询列表入口 没有分页
     *
     * @param dto
     * @return
     */
    @PostMapping(value = "/list")
    public RestResponse postRankList(@RequestBody PostRankSearchDTO dto) {
        String qybh = loginUser.getQybh();
        dto.setQybh(qybh);
        List<PostRankDataVO> vos = postRankService.postRankList(dto);
        return new RestResponse(vos);
    }

    /**
     * 添加公司岗位
     *
     * @param dataDTO
     * @return
     */
    @PostMapping(value = "/addRank")
    public RestResponse addRank(@RequestBody PostRankDataDTO dataDTO) throws Exception{
        String qybh = loginUser.getQybh();
        dataDTO.setQybh(qybh);
        dataDTO.setGsid(loginUser.getQybh());
        dataDTO.setZhxgsj(DateUtils.getNow());
        dataDTO.setZhxgr(loginUser.getXm());
        int num = 0;
        if (StringUtils.isNotBlank(dataDTO.getId())) {
            num = postRankService.editRank(dataDTO);
        } else {
            dataDTO.setCjr(loginUser.getXm());
            dataDTO.setCjsj(DateUtils.getNow());
            num = postRankService.addRank(dataDTO);
        }
        return new RestResponse(num);
    }


    /**
     * 删除公司岗位
     * @param dataDTO
     * @return
     */
    @PostMapping(value = "deleteRank")
    public RestResponse deleteRank(@RequestBody PostRankDataDTO dataDTO) {
        String qybh = loginUser.getQybh();
        dataDTO.setQybh(qybh);
        int num = postRankService.deleteRank(dataDTO);
        return new RestResponse(num);
    }

    /**
     * 岗位控件
     * @param dataDTO 入参
     * @return
     */
    @RequestMapping(value = "/control/rankControl/list",method = RequestMethod.POST)
    public RestResponse<List<PostRankControlVO>> rankControl(PostRankSearchDTO dataDTO) {
        String qybh = loginUser.getQybh();
        dataDTO.setQybh(qybh);
        List<PostRankControlVO> postRankControlVOs = postRankService.getRankControl(dataDTO);
        return new RestResponse<>(postRankControlVOs);
    }
}
