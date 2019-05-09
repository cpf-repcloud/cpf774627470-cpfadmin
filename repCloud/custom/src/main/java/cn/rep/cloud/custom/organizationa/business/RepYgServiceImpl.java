package cn.rep.cloud.custom.organizationa.business;


import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.rep.cloud.custom.basecommon.common.Constants;
import cn.rep.cloud.custom.coreutils.common.DownloadFileUtil;
import cn.rep.cloud.custom.coreutils.common.ExcelConveter;
import cn.rep.cloud.custom.coreutils.common.PageDTO;
import cn.rep.cloud.custom.coreutils.utils.BeanMapper;
import cn.rep.cloud.custom.coreutils.utils.DateUtils;
import cn.rep.cloud.custom.coreutils.utils.SerializeUtil;
import cn.rep.cloud.custom.openapi.kjController.basecommon.ygkj.Bean.KjYgResponse;
import cn.rep.cloud.custom.organizationa.dto.RepYgDTO;
import cn.rep.cloud.custom.organizationa.entity.RepYg;
import cn.rep.cloud.custom.organizationa.service.RepYgService;
import cn.rep.cloud.custom.organizationa.vo.SuccessBean;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class RepYgServiceImpl {
    /**
     * 日志记录类
     */
    private static final Logger logger = LoggerFactory.getLogger(RepYgServiceImpl.class);


    @Autowired
    private RepYgService repYgService;

    private static final String filePath = "/download/excel/";


    /**
     * 分页查询
     * @param pageDTO
     * @return
     */
    public Page<RepYg> seletPage(PageDTO<RepYgDTO> pageDTO){
        Page<RepYg> page =repYgService.selectPage(pageDTO);
        return page;
    }

    /**
     * 登录成功后将当前登录人存入session中
     * @param id
     * @return
     */
    public RepYg queryRepYg(String id,HttpServletRequest request){
        RepYg repYg = repYgService.queryRepYg(id);
        if (null != repYg && StringUtils.isNotBlank(repYg.getId())){
            HttpSession session = request.getSession();
            JSONObject json = JSONUtil.parseObj(repYg);
            session.setAttribute(session.getId(), SerializeUtil.serialize(json));
        }
        return repYg;
    }

    /**
     * 根据企业编号查询员工集合
     *
     * @return 查询条件
     */
    public List<KjYgResponse> getYgList(RepYgDTO ygDTO){
        List<RepYg> ygList = repYgService.getYgList(ygDTO);
        List<KjYgResponse> responseList = new ArrayList<>();
        for (RepYg repYg : ygList){
            KjYgResponse response = new KjYgResponse();
            response.setId(repYg.getId());
            response.setName(repYg.getXm());
            response.setValue(repYg.getGh());
            BeanMapper.copy(repYg,response);
            responseList.add(response);
        }
        return responseList;
    }

    /**
     * 员工批量导入模板下载
     * @return
     */
    public ResponseEntity<InputStreamResource> downloadYgMb(){
        ResponseEntity<InputStreamResource> response = null;
        try {
            response = DownloadFileUtil.download(filePath, "员工批量导入模板");
        } catch (Exception e) {
            logger.error("下载模板失败");
        }
        return response;
    }

    public SuccessBean uploadEmpBatch(MultipartFile file,RepYgDTO dto){
        SuccessBean successBean = new SuccessBean();
        try {
            InputStream file1One = file.getInputStream();
            //获取文件后缀,后面需要判断是 xls 还是 xlsx
            String fileRealName = file.getOriginalFilename();//获得原始文件名;
            int pointIndex =  fileRealName.lastIndexOf(".");//点号的位置
            String fileSuffix = fileRealName.substring(pointIndex);//截取文件后缀
            //得到解析后的数据
            List<RepYg> list = ExcelConveter.getBean(file1One,2,fileSuffix,RepYg.class);
            //补上id和其他信息
            List<RepYg> oneList = new ArrayList<>();
            for (RepYg repYg : list){
                repYg.setId(DateUtils.getNo(5));
                repYg.setKtzt(Constants.ZT_ONE);
                repYg.setQybh(dto.getQybh());
                repYg.setCjsj(DateUtils.getNow());
                repYg.setCjr(dto.getCjr());
                oneList.add(repYg);
            }
            successBean = repYgService.insetBatch(oneList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return successBean;
    }

    /**
     * 通过id 查询员工
     * @param id
     * @return
     */
    public RepYg getYgById(String id){
        return repYgService.queryRepYg(id);
    }


}
