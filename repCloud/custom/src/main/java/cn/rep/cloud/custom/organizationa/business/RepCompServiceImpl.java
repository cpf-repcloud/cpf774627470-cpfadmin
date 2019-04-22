package cn.rep.cloud.custom.organizationa.business;

import cn.rep.cloud.custom.coreutils.common.PageDTO;
import cn.rep.cloud.custom.coreutils.common.TreeNode;
import cn.rep.cloud.custom.coreutils.utils.DateUtils;
import cn.rep.cloud.custom.openapi.kjController.basecommon.gskj.bean.KjGsResponse;
import cn.rep.cloud.custom.organizationa.dto.RepCompDTO;
import cn.rep.cloud.custom.organizationa.entity.RepGs;
import cn.rep.cloud.custom.organizationa.service.RepCompService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RepCompServiceImpl {
    /**
     * 日志记录类
     */
    private static final Logger logger = LoggerFactory.getLogger(RepCompServiceImpl.class);
    @Autowired
    private RepCompService repCompService;

    public Page<RepGs> seletPage(PageDTO<RepCompDTO> pageDTO){
        Page<RepGs> page =repCompService.selectPage(pageDTO);
        return page;
    }

    /**
     * 插入系统模块
     * @param dto 需要插入的模块数据
     * @return stu 是否成功
     */
    public boolean updateRepComp(RepCompDTO dto){
        return repCompService.updateRepComp(dto);
    }

    /**
     * 删除
     * @param dto
     * @return
     */
    public boolean deleteRepComp(RepCompDTO dto){
        return repCompService.deleteRepComp(dto);
    }

    /**
     * 插入系统模块
     * @param dto 需要插入的模块数据
     * @return stu 是否成功
     */
    public boolean insertRepComp(RepCompDTO dto){
        dto.setId(DateUtils.getNo(6));
        boolean istrue = repCompService.insertRepComp(dto);
        return istrue;
    }

    /**
     * 通过上级id查询所有公司(不传查询所有)
     * @param sjid 上级id
     * @return 公司集合
     */
    public List<RepGs> getRepList(String sjid){
        return repCompService.getRepList(sjid);
    }

    public List<TreeNode> getTreeNodes(){
        List<TreeNode> treeNodes = new ArrayList<>();
        List<RepGs> repComps = repCompService.getRepList("none");
        for (RepGs repComp : repComps) {
            TreeNode treeNodeOne = new TreeNode();
            treeNodeOne.setTitle(repComp.getJc());
            treeNodeOne.setValue(repComp.getId());
            List<TreeNode> treeNodeChildrens = getTreeNodeChildrens(treeNodeOne);
            treeNodeOne.setChildren(treeNodeChildrens);
            treeNodes.add(treeNodeOne);
        }
        if (CollectionUtils.isNotEmpty(treeNodes)){//默认展开第一个节点
            treeNodes.get(0).setExpand(true);
            treeNodes.get(0).setSelected(true);
        }
        return treeNodes;
    }

    public List<TreeNode> getTreeNodeChildrens(TreeNode treeNode){
        List<TreeNode> treeNodes = new ArrayList<>();
        List<RepGs> repComps = repCompService.getRepList(treeNode.getValue());
            for (RepGs repComp : repComps) {
                TreeNode treeNodeOne = new TreeNode();
                treeNodeOne.setTitle(repComp.getJc());
                treeNodeOne.setValue(repComp.getId());
                List<RepGs> repCompList = getRepList(treeNodeOne.getValue());
                if (CollectionUtils.isNotEmpty(repCompList)){
                    List<TreeNode> treeNodeChildrens = getTreeNodeChildrens(treeNodeOne);
                    treeNodeOne.setChildren(treeNodeChildrens);
                }
                treeNodes.add(treeNodeOne);

            }

        return treeNodes;
    }

    /**
     * 查询公司页面头部面包屑
     * @param chrId 子id
     * @return
     */
    public List<String> getMbx(String chrId){
        return repCompService.getMbx(chrId);
    }

    /**
     * 公司控件查询
     * @return
     */
    public List<KjGsResponse> getCompList(){
        List<RepGs> gsList = getRepList("");
        List<KjGsResponse> compList = new ArrayList<>();
        for (RepGs repGs : gsList){
            KjGsResponse response = new KjGsResponse();
            response.setId(repGs.getId());
            response.setName(repGs.getJc());
            response.setValue(repGs.getBh());
            compList.add(response);
        }
        return compList;
    }
}
