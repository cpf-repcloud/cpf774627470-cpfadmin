package cn.rep.cloud.custom.organizationa.controller;

import cn.rep.cloud.custom.coreutils.common.BaseController;
import cn.rep.cloud.custom.coreutils.common.PageDTO;
import cn.rep.cloud.custom.coreutils.common.RestResponse;
import cn.rep.cloud.custom.coreutils.common.TreeNode;
import cn.rep.cloud.custom.organizationa.business.RepCompServiceImpl;
import cn.rep.cloud.custom.organizationa.dto.RepCompDTO;
import cn.rep.cloud.custom.organizationa.entity.RepGs;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("repComp")
public class RepCompController  extends BaseController {
    @Autowired
    private RepCompServiceImpl repCompService;

    @RequestMapping("list")
    public RestResponse<Page<RepGs>> list(@RequestBody PageDTO<RepCompDTO> pageDTO){//
        Page<RepGs> pageNew = repCompService.seletPage(pageDTO);
        return new RestResponse(pageNew);
    }

    @RequestMapping("add")
    public RestResponse addRepComp(@RequestBody RepCompDTO dto){//
        boolean result;
        if (StringUtils.isBlank(dto.getId())){
            result = repCompService.insertRepComp(dto);
        }else{
            result =  repCompService.updateRepComp(dto);
        }
        return new RestResponse(result);
    }

    @RequestMapping("edit")
    public RestResponse edit(@RequestBody RepCompDTO dto){//
        boolean result = repCompService.updateRepComp(dto);
        return new RestResponse(result);
    }

    @RequestMapping("delete")
    public RestResponse delete(@RequestBody RepCompDTO dto){//
        boolean result = repCompService.deleteRepComp(dto);
        return new RestResponse(result);
    }

    /**
     * 通过上级id查询所有公司(不传查询所有)
     * @param sjid 上级id
     * @return 公司集合
     */
    @RequestMapping("getRepList")
    public RestResponse<List<RepGs>> getRepList(@RequestParam("sjid") String sjid){
        List<RepGs> repComps = repCompService.getRepList(sjid);
        return new RestResponse(repComps);
    }

    /**
     * 查询公司树形结构
     * @return 公司集合
     */
    @RequestMapping("getTreeNodes")
    public RestResponse<List<TreeNode>> getTreeNodes(){
        List<TreeNode> treeNodes = repCompService.getTreeNodes();
        return new RestResponse(treeNodes);
    }
}
