package cn.rep.cloud.custom.basecommon.basedata.mapper;


import cn.rep.cloud.custom.basecommon.basedata.entity.RepJcsj;
import cn.rep.cloud.custom.basecommon.basedata.service.dto.BaseDataListDTO;
import cn.rep.cloud.custom.basecommon.basedata.service.vo.BaseDataListVO;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "repJcsjMapper")
public interface RepJcsjMapper extends BaseMapper<RepJcsj> {

    public List<BaseDataListVO> pagelist(Page page, @Param("dto") BaseDataListDTO dto);

    public List<BaseDataListVO> checkBaseData(BaseDataListDTO dto);
}
