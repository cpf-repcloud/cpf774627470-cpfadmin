package cn.rep.cloud.custom.openapi.kjController.basecommon;

import cn.rep.cloud.custom.basecommon.post.dto.PostRankSearchDTO;
import cn.rep.cloud.custom.basecommon.post.service.PostRankService;
import cn.rep.cloud.custom.basecommon.post.vo.PostRankDataVO;
import cn.rep.cloud.custom.coreutils.common.BaseController;
import cn.rep.cloud.custom.coreutils.common.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kj/postrank")
public class GeKjController extends BaseController {


    @Autowired
    private PostRankService postRankService;


    /**
     * 岗位控件接口
     * @return
     */
    @RequestMapping("getPostRankList")
    public RestResponse<List<PostRankDataVO>> getPostRankList() {
        String qybh = loginUser.getQybh();
        String gsid = loginUser.getGsid();
        PostRankSearchDTO dto = new PostRankSearchDTO();
        dto.setQybh(qybh);
        dto.setGsid(gsid);
        List<PostRankDataVO> postranklist = postRankService.postRankList(dto);
        return new RestResponse(postranklist);

    }


}
