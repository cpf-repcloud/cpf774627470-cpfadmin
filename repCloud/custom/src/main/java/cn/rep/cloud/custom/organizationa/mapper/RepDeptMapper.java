package cn.rep.cloud.custom.organizationa.mapper;

import cn.rep.cloud.custom.organizationa.entity.RepBm;
import cn.rep.cloud.custom.organizationa.vo.RepDeptVO;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "repDeptMapper")
public interface RepDeptMapper extends BaseMapper<RepBm> {

    /**
     * 查询部门页面头部面包屑
     * @param chrId 子id
     * @return
     */
    List<String> getBmMbx(@Param("chrId") String chrId);
    /**
     * 根据部门id查询部门
     * @param bmid 部门id
     * @return
     */
    RepDeptVO getBmByBmid(@Param("bmid") String bmid,@Param("sjid") String sjid);
}
