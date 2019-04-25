package cn.rep.cloud.custom.organizationa.service;

import cn.rep.cloud.custom.basecommon.common.Constants;
import cn.rep.cloud.custom.coreutils.utils.BeanMapper;
import cn.rep.cloud.custom.organizationa.dto.RepBmDTO;
import cn.rep.cloud.custom.organizationa.entity.RepBm;
import cn.rep.cloud.custom.organizationa.entity.RepGs;
import cn.rep.cloud.custom.organizationa.mapper.RepDeptMapper;
import cn.rep.cloud.custom.organizationa.vo.FailBean;
import cn.rep.cloud.custom.organizationa.vo.SuccessBean;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RepDeptService {
    @Autowired
    private RepDeptMapper repDeptMapper;

    /**
     * 通过企业编号查询部门
     * @param bmDTO
     * @return
     */
    public List<RepBm> getBmList(RepBmDTO bmDTO){
        EntityWrapper<RepBm> ew = new EntityWrapper<>();
        if (StringUtils.isNotBlank(bmDTO.getSsgsid())){
            ew.eq("ssgsid",bmDTO.getSsgsid());
        }
        ew.eq("zt", Constants.ZT_ONE);
        ew.eq("qybh",bmDTO.getQybh());
        List<RepBm> bmList = repDeptMapper.selectList(ew);
        return bmList;
    }

    /**
     * 通过部门编号查询部门
     * @param bmbh
     * @return
     */
    public RepBm getBmByBh(String bmbh){
        RepBm repBm = new RepBm();
        repBm.setBh(bmbh);
        return repDeptMapper.selectOne(repBm);
    }

    /**
     * 通过部门上级id查询部门
     * @param sjid
     * @return
     */
    public RepBm getBmBySjid(String sjid){
        RepBm repBm = new RepBm();
        repBm.setSjid(sjid);
        return repDeptMapper.selectOne(repBm);
    }

    /**
     * 批量插入
     * @param repYgs
     * @return
     */
//    public SuccessBean insetBatch(List<RepBm> oneList){
//            List<RepBm> successList = new ArrayList<>();//插入成功集合
//            SuccessBean successBeans = new SuccessBean();//成功失败条数及失败原因
//            List<FailBean> failBeanList = new ArrayList<>();
//            int failCount = 0;
//            int successCount = 0;
//            for (RepBm repbm : oneList){
//                //失败后返回给页面的数据
//                FailBean insertFailBean = new FailBean();
//                failCount++;
//                insertFailBean.setId(repbm.getId());
//                insertFailBean.setBh(repbm.getBh());
//                insertFailBean.setMc(repbm.getJc());
//                //判断公司是否存在
//                RepGs repGs = repCompService.getGsByBh(repYg.getGsid());
//                //判断上级部门是否存在
//                RepBm repBm = getBmBySjid(repbm.getSjid());
//                if (null == repGs){
//                    insertFailBean.setMessage("公司不存在或者公司编号填写错误!");
//                }else if (null == repBm){
//                    insertFailBean.setMessage("上级部门不存在或者部门编号填写错误!");
//                }else{
//                    failCount--;
//                    RepBm tow = new RepBm();
//                    BeanMapper.copy(repbm,tow);
//                    successList.add(tow);
//                }
//                failBeanList.add(insertFailBean);
//            }
//            if (CollectionUtils.isNotEmpty(successList)){
//                successCount = repYgMapper.insertBatch(successList);
//            }
//            successBeans.setSuccessCount(successCount);
//            successBeans.setFailCount(failCount);
//            successBeans.setFailBeanList(failBeanList);
//            return successBeans;
//        }
//    }
}
