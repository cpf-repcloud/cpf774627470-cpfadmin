package cn.rep.cloud.custom.organizationa.service;

import cn.rep.cloud.custom.basecommon.common.Constants;
import cn.rep.cloud.custom.coreutils.common.PageCopyUtil;
import cn.rep.cloud.custom.coreutils.common.PageDTO;
import cn.rep.cloud.custom.coreutils.utils.BeanMapper;
import cn.rep.cloud.custom.coreutils.utils.DateUtils;
import cn.rep.cloud.custom.coreutils.utils.Md5AndSalt;
import cn.rep.cloud.custom.organizationa.business.RepCompServiceImpl;
import cn.rep.cloud.custom.organizationa.business.RepDeptServiceImpl;
import cn.rep.cloud.custom.organizationa.dto.RepYgDTO;
import cn.rep.cloud.custom.organizationa.entity.RepBm;
import cn.rep.cloud.custom.organizationa.entity.RepGs;
import cn.rep.cloud.custom.organizationa.entity.RepLogin;
import cn.rep.cloud.custom.organizationa.entity.RepYg;
import cn.rep.cloud.custom.organizationa.mapper.RepYgMapper;
import cn.rep.cloud.custom.organizationa.vo.FailBean;
import cn.rep.cloud.custom.organizationa.vo.SuccessBean;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.dnd.DropTarget;
import java.util.ArrayList;
import java.util.List;

@Service
public class RepYgService {
    @Autowired
    private RepYgMapper repYgMapper;
    @Autowired
    private RepEmployeeService repEmployeeService;
    @Autowired
    private RepDeptServiceImpl repDeptService;
    @Autowired
    private RepCompServiceImpl repCompService;

    /**
     *  通过id查询员工
     * @param id
     * @return
     */
    public RepYg queryRepYg(String id){
        return repYgMapper.selectById(id);
    }

    /**
     * 分页查询
     * @param pageDTO
     * @return
     */
    public Page<RepYg> selectPage(PageDTO<RepYgDTO> pageDTO){
        Page<RepYg> page = PageCopyUtil.genPage(pageDTO);
        List<RepYg> list = repYgMapper.pagelist(page,pageDTO.getData());
        page.setRecords(list);
        return page;
    }

    /**
     * 根据工号查询员工
     * @param gh
     * @return
     */
    public RepYg queryRepYgByGh(String gh){
        if (StringUtils.isNotBlank(gh)){
            RepYg repYg = new RepYg();
            repYg.setGh(gh);
            return repYgMapper.selectOne(repYg);
        }else{
            return null;
        }
    }

    /**
     * 根据企业编号查询员工集合
     * @return
     */
    public List<RepYg> getYgList(RepYgDTO ygDTO){
        EntityWrapper<RepYg> ew = new EntityWrapper<>();
        if (StringUtils.isNotBlank(ygDTO.getGsid())){
            ew.eq("gsid",ygDTO.getGsid());
        }
        if (StringUtils.isNotBlank(ygDTO.getBmid())){
            ew.eq("bmid",ygDTO.getGsid());
        }
        ew.eq("qybh",ygDTO.getQybh());
        ew.eq("ktzt", Constants.ZT_ONE);
        List<RepYg> ygList = repYgMapper.selectList(ew);
        return ygList;
    }

    /**
     * 新增员工
     * @param repYg
     * @return
     */
    public boolean insertYg(RepYg repYg){
        if (StringUtils.isNotBlank(repYg.getId())){
            int result = repYgMapper.insert(repYg);
            if (result > 0){
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /**
     * 编辑员工
     * @param repYg
     * @return
     */
    public boolean updateYg(RepYg repYg){
        if (StringUtils.isNotBlank(repYg.getId())){
            int result = repYgMapper.updateById(repYg);
            if (result > 0){
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /**
     * 删除员工  物理删除
     * @param repYg
     * @return
     */
    public boolean physicalDeletionYg(RepYg repYg){
        if (StringUtils.isNotBlank(repYg.getId())){
            int result = repYgMapper.deleteById(repYg);
            if (result > 0){
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /**
     * 删除员工  逻辑删除
     * @param repYg
     * @return
     */
    public boolean logicalDeletionYg(RepYg repYg){
        if (StringUtils.isNotBlank(repYg.getId())){
            repYg.setKtzt(Constants.ZT_ZERO);
            int result = repYgMapper.updateById(repYg);
            if (result > 0){
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /**
     * 批量插入
     * @param repYgs
     * @return
     */
    public SuccessBean insetBatch(List<RepYg> repYgs){
        List<RepYg> successList = new ArrayList<>();//插入成功集合
        SuccessBean successBeans = new SuccessBean();//成功失败条数及失败原因
        List<FailBean> failBeanList = new ArrayList<>();
        int failCount = 0;
        int successCount = 0;
        for (RepYg repYg : repYgs){
            //失败后返回给页面的数据
            FailBean insertFailBean = new FailBean();
            failCount++;
            //判断公司是否存在
            RepGs repGs = repCompService.getGsByBh(repYg.getGsid());
            //判断工号是否被注册
            RepYg one = queryRepYgByGh(repYg.getGh());
            //判断部门是否存在
            RepBm repBm = repDeptService.getBmByBh(repYg.getBmid());
            if (null == repGs){
                insertFailBean.setMessage("公司不存在或者公司编号填写错误!");
            }else if (null == repBm){
                insertFailBean.setMessage("部门不存在或者部门编号填写错误!");
            }else if (null != one){
                insertFailBean.setMessage("该工号已经注册!");
            }else{
                failCount--;
                RepYg tow = new RepYg();
                BeanMapper.copy(repYg,tow);
                successList.add(tow);
                continue;
            }
            insertFailBean.setId(repYg.getId());
            insertFailBean.setBh(repYg.getGh());
            insertFailBean.setMc(repYg.getXm());
            failBeanList.add(insertFailBean);
        }
        if (CollectionUtils.isNotEmpty(successList)){
            successCount = repYgMapper.insertBatch(successList);
            //员工添加成功后,就默认添加一个登录账号,登录账号默认为工号,密码默认为123456
            if (successCount > 0){
                for (RepYg repYg : successList){
                    repEmployeeService.insetLogin(repYg);
                }
            }
        }
        successBeans.setSuccessCount(successCount);
        successBeans.setFailCount(failCount);
        successBeans.setFailBeanList(failBeanList);
        return successBeans;
    }

}
