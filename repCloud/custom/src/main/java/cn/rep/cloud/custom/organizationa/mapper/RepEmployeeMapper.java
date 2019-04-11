package cn.rep.cloud.custom.organizationa.mapper;

import cn.rep.cloud.custom.organizationa.entity.RepLogin;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;


@Mapper
@Component(value = "repEmployeeMapper")
public interface RepEmployeeMapper extends BaseMapper<RepLogin> {

    RepLogin getEmpByLonginName(@Param("loginName") String loginName);
}
