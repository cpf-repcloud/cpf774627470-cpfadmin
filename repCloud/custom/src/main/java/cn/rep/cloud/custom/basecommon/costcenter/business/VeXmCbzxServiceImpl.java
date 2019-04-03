package cn.rep.cloud.custom.basecommon.costcenter.business;


import cn.rep.cloud.custom.basecommon.costcenter.entity.VeXmCbzx;
import cn.rep.cloud.custom.basecommon.costcenter.mapper.VeXmCbzxMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 项目成本中心表 服务实现类
 * </p>
 *
 * @author chenyong
 * @since 2018-08-08
 */
@Service
public class VeXmCbzxServiceImpl  {

    
    @Autowired
    private VeXmCbzxMapper veXmCbzxMapper;
    /**
     * 新增成本中心项目数据
     *
     * @param list 成本中心项目
     * @return Boolean
     * @author yangxianglin
     * @date 2018-08-06 11:35:36
     */
    public Boolean insertVeXmCbzxList(List<VeXmCbzx> list) {
        for(VeXmCbzx cbzx:list){
            veXmCbzxMapper.insert(cbzx);
        }
        return Boolean.TRUE;
    }

    /**
     * 批量删除成本中心项目数据
     *
     * @param list 成本中心项目
     * @return Boolean
     * @author yangxianglin
     * @date 2018-08-06 11:35:36
     */
    public Boolean deleteVeXmCbzxList(List<String> list) {
        return veXmCbzxMapper.deleteBatchIds(list) >0 ? Boolean.TRUE : Boolean.FALSE;
    }

    /**
     * 查询成本中心项目数据
     *
     * @param   veXmCbzx 成本中心项目对象
     * @return  List<VeXmCbzx>
     * @author  yangxianglin
     * @date    2018-08-06 11:35:36
     */
    public List<VeXmCbzx> getVeXmCbzxListByCbzxid(VeXmCbzx veXmCbzx) {
        EntityWrapper<VeXmCbzx> ew = new EntityWrapper<VeXmCbzx>();
        ew.setEntity(veXmCbzx);
        return veXmCbzxMapper.selectList(ew);
    }

    /**
     * 插入成本中心数据
     * @param veXmCbzx
     * @return
     */
    public int insertVeXmCbzx(VeXmCbzx veXmCbzx){
        return veXmCbzxMapper.insert(veXmCbzx);
    }


    public List<VeXmCbzx> getCbzxByBean(VeXmCbzx cbzx){
        EntityWrapper ew=new EntityWrapper();
        if(StringUtils.isNotBlank(cbzx.getXmid())){
            ew.eq("xmid",cbzx.getXmid());
        }
        if(StringUtils.isNotBlank(cbzx.getCbzxid())){
            ew.eq("cbzxid",cbzx.getCbzxid());
        }
        return veXmCbzxMapper.selectList(ew);

    }
    /**
     * 查询成本中心部门名称数据集合
     *
     * @param   cbzxid 成本中心id
     * @return  List<String>
     * @author  yangxianglin
     * @date    2018-08-06 11:35:36
     */
    public List<String> getVeXmCbzxMcListByCbzxid(String cbzxid) {
        return veXmCbzxMapper.getVeXmCbzxMcListByCbzxid(cbzxid);
    }


}