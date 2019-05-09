package cn.rep.cloud.custom.organizationa.business;

import cn.rep.cloud.custom.basecommon.common.Constants;
import cn.rep.cloud.custom.basicdata.business.RepCityServiceImpl;
import cn.rep.cloud.custom.basicdata.dto.RepCityDTO;
import cn.rep.cloud.custom.basicdata.entity.RepCity;
import cn.rep.cloud.custom.coreutils.common.TreeNode;
import cn.rep.cloud.custom.coreutils.utils.BeanMapper;
import cn.rep.cloud.custom.coreutils.utils.DateUtils;
import cn.rep.cloud.custom.openapi.kjController.basecommon.bmkj.bean.KjBmResponse;
import cn.rep.cloud.custom.organizationa.dto.RepBmDTO;
import cn.rep.cloud.custom.organizationa.entity.RepBm;
import cn.rep.cloud.custom.organizationa.entity.RepGs;
import cn.rep.cloud.custom.organizationa.service.RepCompService;
import cn.rep.cloud.custom.organizationa.service.RepDeptService;
import cn.rep.cloud.custom.organizationa.vo.RepDeptVO;
import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RepDeptServiceImpl {
    /**
     * 日志记录类
     */
    private static final Logger logger = LoggerFactory.getLogger(RepDeptServiceImpl.class);

    @Autowired
    private RepDeptService repDeptService;
    @Autowired
    private RepCompService repCompService;
    @Autowired
    private RepCityServiceImpl repCityService;

    /**
     * 通过企业编号查询部门
     * @param bmDTO
     * @return
     */
    public List<KjBmResponse> getBmList(RepBmDTO bmDTO){
        List<RepBm> deptList = repDeptService.getBmList(bmDTO);
        List<KjBmResponse> responseList = new ArrayList<>();
        for (RepBm repBm : deptList){
            KjBmResponse response = new KjBmResponse();
            response.setId(repBm.getId());
            response.setName(repBm.getJc());
            response.setValue(repBm.getBh());
            BeanMapper.copy(repBm,response);
            responseList.add(response);
        }
        return responseList;
    }

    /**
     * 通过部门编号查询部门
     * @param bmbh
     * @return
     */
    public RepBm getBmByBh(String bmbh){
        if (StringUtils.isNotBlank(bmbh))
        return repDeptService.getBmByBh(bmbh);
        return null;
    }

    /**
     * 查询页面面包屑和部门基本信息
     * @param bmid 部门id
     * @param ssgsid 所属公司id
     * @return
     */
    public RepDeptVO getBmMbx(String bmid, String ssgsid){
        //获取页面面包屑
        List<String> stringList = new ArrayList<>();
        RepGs repGs = repCompService.getGsByBh(ssgsid);
        stringList.add(repGs.getJc());
        List<String> bmxList = repDeptService.getBmMbx(bmid);
        for (String str : bmxList){
            stringList.add(str);
        }
        //获取部门基本信息
        RepBm repBm = repDeptService.getBmById(bmid);
        String sjid = "";
        if (null != repBm && !StringUtils.equals("none",repBm.getSjid())){
            sjid = repBm.getSjid();
        }
        RepDeptVO repDeptVO = repDeptService.getBmByBmid(bmid,sjid);
        if (null != repDeptVO){
            if (StringUtils.isBlank(repDeptVO.getSjbmmc())){
                repDeptVO.setSjbmmc("无");
            }
        }
        if (null == repDeptVO){
            repDeptVO = new RepDeptVO();
        }
        repDeptVO.setMbxList(stringList);
        return repDeptVO;
    }

    /**
     * 通过递归查询方式获取部门树形结构
     * @return
     */
    public List<TreeNode> getTreeNodes(){
        //部门子节点
        List<TreeNode> treeNodes = new ArrayList<>();
        List<RepBm> repBmList = repDeptService.getRepList("none");
        for (RepBm repBm : repBmList) {
            TreeNode treeNodeOne = new TreeNode();
            treeNodeOne.setValue(repBm.getId());
            treeNodeOne.setTitle(repBm.getJc());
            List<TreeNode> treeNodeChildrens = getTreeNodeChildrens(treeNodeOne);
            treeNodeOne.setChildren(treeNodeChildrens);
            treeNodes.add(treeNodeOne);
        }
        if (CollectionUtils.isNotEmpty(treeNodes)){
            treeNodes.get(0).setExpand(true);
            treeNodes.get(0).setSelected(true);
        }
        return treeNodes;
    }

    public List<TreeNode> getTreeNodeChildrens(TreeNode treeNode){
        List<TreeNode> treeNodes = new ArrayList<>();
        List<RepBm> repBms = repDeptService.getRepList(treeNode.getValue());
        for (RepBm repBm : repBms) {
            TreeNode treeNodeOne = new TreeNode();
            treeNodeOne.setTitle(repBm.getJc());
            treeNodeOne.setValue(repBm.getId());
            List<RepBm> repBmList = repDeptService.getRepList(treeNodeOne.getValue());
            if (CollectionUtils.isNotEmpty(repBmList)){
                List<TreeNode> treeNodeChildrens = getTreeNodeChildrens(treeNodeOne);
                treeNodeOne.setChildren(treeNodeChildrens);
            }
            treeNodes.add(treeNodeOne);

        }

        return treeNodes;
    }

    /**
     * 新增部门
     * @param repBmDTO
     */
    public boolean insertDept(RepBmDTO repBmDTO){
        if (StringUtils.isBlank(repBmDTO.getMc())) return Boolean.FALSE;
        repBmDTO.setId(DateUtils.getNo(5));
        repBmDTO.setZt(Constants.ZT_ONE);
        repBmDTO.setSfzdsccbzx(Constants.ZT_ONE);
        //查询所在城市,所在省份
        RepCityDTO repCity = repCityService.getCityCountryByCsid(repBmDTO.getSzcsid());
        if (null == repCity) return Boolean.FALSE;
        repBmDTO.setSzcs(repCity.getMc());
        repBmDTO.setSzsf(repCity.getSzsf());
        repBmDTO.setSzsfid(repCity.getSzsfid());
        RepBm repBm = new RepBm();
        BeanMapper.copy(repBmDTO,repBm);
        repBm.setCjsj(DateUtils.getNow());
        repBm.setSsgsid(repBmDTO.getSsgsbh());
        if (StringUtils.isBlank(repBm.getSjid())){
            repBm.setSjid("none");
        }
        return repDeptService.insertRepDept(repBm);
    }


    /**
     * 批量上传部门
     *
     * @param file
     * @param dto
     * @return
     */
//    public SuccessBean uploadEmpBatch(MultipartFile file, RepBmDTO dto){
//        SuccessBean successBean = new SuccessBean();
//        try {
//            InputStream file1One = file.getInputStream();
//            //获取文件后缀,后面需要判断是 xls 还是 xlsx
//            String fileRealName = file.getOriginalFilename();//获得原始文件名;
//            int pointIndex =  fileRealName.lastIndexOf(".");//点号的位置
//            String fileSuffix = fileRealName.substring(pointIndex);//截取文件后缀
//            //得到解析后的数据
//            List<RepBm> list = ExcelConveter.getBean(file1One,2,fileSuffix,RepBm.class);
//            //补上id和其他信息
//            List<RepBm> oneList = new ArrayList<>();
//            for (RepBm repYg : list){
//                repYg.setId(DateUtils.getNo(5));
//                repYg.setQybh(dto.getQybh());
//                repYg.setCjsj(DateUtils.getNow());
//                repYg.setCjr(dto.getCjr());
//                oneList.add(repYg);
//            }
//            successBean = repDeptService.insetBatch(oneList);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return successBean;
//    }
}
