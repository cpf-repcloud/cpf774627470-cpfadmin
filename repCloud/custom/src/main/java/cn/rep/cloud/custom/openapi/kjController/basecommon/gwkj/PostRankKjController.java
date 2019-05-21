package cn.rep.cloud.custom.openapi.kjController.basecommon.gwkj;

import cn.rep.cloud.custom.basecommon.post.business.PostRankServiceImpl;
import cn.rep.cloud.custom.basecommon.post.dto.PostRankSearchDTO;
import cn.rep.cloud.custom.basecommon.post.vo.PostRankDataVO;
import cn.rep.cloud.custom.coreutils.common.BaseController;
import cn.rep.cloud.custom.coreutils.common.RestResponse;
import cn.rep.cloud.custom.coreutils.utils.BeanMapper;
import cn.rep.cloud.custom.openapi.kjController.basecommon.gskj.bean.KjGsResponse;
import cn.rep.cloud.custom.openapi.kjController.basecommon.gwkj.bean.KjGwResponse;
import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 岗位控件
 */
@RestController
@RequestMapping("/kj/postrank")
public class PostRankKjController extends BaseController{
    @Autowired
    private PostRankServiceImpl postRankService;

    /**
     * 查询公司list
     * @return
     */
    @RequestMapping("getPostrankList")
    public RestResponse<List<KjGsResponse>> getCityList(){
        PostRankSearchDTO dto=new PostRankSearchDTO();
        dto.setGsid(loginUser.getGsid());
        dto.setQybh(loginUser.getQybh());
        List<KjGwResponse> list = new ArrayList<>();
        List<PostRankDataVO> gwlist = postRankService.postRankList(dto);
        if (CollectionUtils.isNotEmpty(gwlist)) {
            for(PostRankDataVO postrank:gwlist){
                KjGwResponse response=  BeanMapper.map(postrank,KjGwResponse.class);
                response.setId(postrank.getId());
                response.setName(postrank.getGwmc());
                response.setValue(postrank.getGwbh());
                list.add(response);
            }

        }
        return new RestResponse(list);
    }
}
