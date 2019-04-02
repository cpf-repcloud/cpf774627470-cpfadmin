package cn.rep.cloud.custom.organizationa.mapper;

import cn.rep.cloud.custom.organizationa.entity.RepEmployee;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;


@Mapper
@Component(value = "repEmployeeMapper")
public interface RepEmployeeMapper extends BaseMapper<RepEmployee> {

    RepEmployee getEmpByLonginName(@Param("loginName") String loginName);
}
