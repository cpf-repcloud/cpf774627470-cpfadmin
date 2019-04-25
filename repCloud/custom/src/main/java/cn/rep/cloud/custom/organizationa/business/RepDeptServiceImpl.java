package cn.rep.cloud.custom.organizationa.business;

import cn.rep.cloud.custom.openapi.kjController.basecommon.bmkj.bean.KjBmResponse;
import cn.rep.cloud.custom.organizationa.dto.RepBmDTO;
import cn.rep.cloud.custom.organizationa.entity.RepBm;
import cn.rep.cloud.custom.organizationa.service.RepDeptService;
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
            response.setId(repBm.getBh());
            response.setName(repBm.getJc());
            response.setValue(repBm.getId());
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
