package cn.rep.cloud.custom.basecommon.costcenter.business;

import cn.rep.cloud.custom.basecommon.costcenter.entity.VeCbzxBm;
import cn.rep.cloud.custom.basecommon.costcenter.mapper.VeCbzxBmMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 成本中心部门表 服务实现类
 * </p>
 *
 * @author chenyong
 * @since 2018-08-08
 */
@Service
public class VeCbzxBmServiceImpl  { 
    @Autowired
    private VeCbzxBmMapper veCbzxBmMapper;
    /**
     * 批量新增成本中心部门数据
     *
     * @param list 成本中心部门
     * @return Boolean
     * @author yangxianglin
     * @date 2018-08-06 11:35:36
     */
    public Boolean insertVeCbzxBmList(List<VeCbzxBm> list) {
        for(VeCbzxBm bm :list){
            veCbzxBmMapper.insert(bm);
        }
        return Boolean.TRUE;
    }

    /**
     * 批量删除成本中心部门数据
     *
     * @param list 成本中心部门
     * @return Boolean
     * @author yangxianglin
     * @date 2018-08-06 11:35:36
     */
    public Boolean deleteVeCbzxBmList(List<String> list) {
        return veCbzxBmMapper.deleteBatchIds(list) >0 ? Boolean.TRUE : Boolean.FALSE;
    }

    /**
     * 查询成本中心部门数据
     *
     * @param   veCbzxBm 成本中心项目对象
     * @return  List<VeXmCbzx>
     * @author  yangxianglin
     * @date    2018-08-06 11:35:36
     */
    public List<VeCbzxBm> getVeCbzxBmListByCbzxid(VeCbzxBm veCbzxBm) {
        EntityWrapper<VeCbzxBm> ew = new EntityWrapper<VeCbzxBm>();
        ew.setEntity(veCbzxBm);
        return veCbzxBmMapper.selectList(ew);
    }

    /**
     * 查询成本中心部门名称数据集合
     *
     * @param   cbzxid 成本中心id
     * @return  List<String>
     * @author  yangxianglin
     * @date    2018-08-06 11:35:36
     */
    public List<String> getVeCbzxBmMcListByCbzxid(String cbzxid) {
        return veCbzxBmMapper.getVeCbzxBmMcListByCbzxid(cbzxid);
    }


}