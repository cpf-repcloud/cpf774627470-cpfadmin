package cn.rep.cloud.custom.organizationa.service;

import cn.rep.cloud.custom.basecommon.common.Constants;
import cn.rep.cloud.custom.coreutils.utils.BeanMapper;
import cn.rep.cloud.custom.organizationa.dto.RepBmDTO;
import cn.rep.cloud.custom.organizationa.entity.RepBm;
import cn.rep.cloud.custom.organizationa.mapper.RepDeptMapper;
import cn.rep.cloud.custom.organizationa.vo.RepDeptVO;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * 通过上级id查询所有部门(不传查询所有)
     * @param sjid 上级id
     * @return 公司集合
     */
    public List<RepBm> getRepList(String sjid){
        EntityWrapper<RepBm> ew = new EntityWrapper<>();
        if (StringUtils.isNotBlank(sjid)){
            ew.eq("sjid",sjid);
        }
        ew.orderBy("cjsj");
        return repDeptMapper.selectList(ew);
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
     * 根据上级id获取页面面包屑
     * @param sjid
     * @return
     */
    public List<String> getBmMbx(String sjid){
        return repDeptMapper.getBmMbx(sjid);
    }

    /**
     * 根据部门id查询部门
     * @param bmid 部门id
     * @return
     */
    public RepDeptVO getBmByBmid(String bmid,String sjid){
        return repDeptMapper.getBmByBmid(bmid,sjid);
    }

    /**
     * 根据主键id查询部门
     * @param id
     * @return
     */
    public RepBm getBmById(String id){
        EntityWrapper<RepBm> ew = new EntityWrapper<>();
        ew.eq("id",id);
        return repDeptMapper.selectById(id);
    }

    /**
     * 插入部门
     * @param repBm 需要插入的部门
     * @return stu 是否成功
     */
    public boolean insertRepDept(RepBm repBm){
        int stu = 0;
        if (null != repBm){
            stu = repDeptMapper.insert(repBm);
        }
        if (stu>0){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 更新部门
     * @param repBm 需要更新的部门数据
     * @return stu 是否成功
     */
    public boolean updateRepDept(RepBm repBm){
        int stu = 0;
        if (null != repBm && StringUtils.isNotBlank(repBm.getId())){
            stu = repDeptMapper.updateById(repBm);
        }
        if (stu>0){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 删除部门   物理删除
     * @param repBm 需要删除的模块数据
     * @return stu 是否成功
     */
    public boolean physicalDeletionDept(RepBm repBm){
        int stu = 0;
        if (null != repBm && StringUtils.isNotBlank(repBm.getId())){
            stu = repDeptMapper.deleteById(repBm);
        }
        if (stu>0){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 删除部门   逻辑删除
     * @param repBm 需要删除的模块数据
     * @return stu 是否成功
     */
    public boolean logicalDeletionDept(RepBm repBm){
        int stu = 0;
        if (null != repBm && StringUtils.isNotBlank(repBm.getId())){
            repBm.setZt(Constants.ZT_ZERO);
            stu = repDeptMapper.updateById(repBm);
        }
        if (stu>0){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
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
