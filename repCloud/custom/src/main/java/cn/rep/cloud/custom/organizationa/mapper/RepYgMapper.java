package cn.rep.cloud.custom.organizationa.mapper;

import cn.rep.cloud.custom.organizationa.dto.RepYgDTO;
import cn.rep.cloud.custom.organizationa.entity.RepYg;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component(value = "repYgMapper")
public interface RepYgMapper extends BaseMapper<RepYg> {

    List<RepYg> pagelist(Page page, @Param("dto")RepYgDTO dto);

    /**
     * 批量新增员工
     * @param repYgList
     * @return
     */
    Integer insertBatch(@Param("repYgList") List<RepYg> repYgList);

    /**
     * 批量修改员工
     * @param repYgList
     * @return
     */
    Integer updateBatch(@Param("repYgList") List<RepYg> repYgList);

}
