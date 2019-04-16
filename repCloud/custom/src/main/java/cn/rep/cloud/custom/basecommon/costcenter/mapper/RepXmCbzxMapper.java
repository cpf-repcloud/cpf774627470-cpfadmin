package cn.rep.cloud.custom.basecommon.costcenter.mapper;


import cn.rep.cloud.custom.basecommon.costcenter.entity.RepXmCbzx;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
  * 项目成本中心表 Mapper 接口
 * </p>
 *
 * @author chenyong
 * @since 2018-08-08
 */
@Mapper
@Component(value = "veXmCbzxMapper")
public interface RepXmCbzxMapper extends BaseMapper<RepXmCbzx> {
    /**
     * 查询成本中心项目名称数据集合
     *
     * @param   cbzxid 成本中心id
     * @return  List<String>
     * @author  yangxianglin
     * @date    2018-08-06 11:35:36
     */
    List<String> getVeXmCbzxMcListByCbzxid(@Param("cbzxid") String cbzxid);

}