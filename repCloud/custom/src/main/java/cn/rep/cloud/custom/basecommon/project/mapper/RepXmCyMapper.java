package cn.rep.cloud.custom.basecommon.project.mapper;

import cn.rep.cloud.custom.basecommon.project.entity.RepXmCy;
import cn.rep.cloud.custom.basecommon.project.service.dto.SearchProMemberDTO;
import cn.rep.cloud.custom.basecommon.project.service.vo.ProMembersVO;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by vetech on 2018/8/9.
 */
@Mapper
@Component(value = "repXmCyMapper")
public interface RepXmCyMapper  extends BaseMapper<RepXmCy> {


    List<ProMembersVO> selectProMember(Page page, @Param("dto") SearchProMemberDTO dto);

    int selectCountPro(@Param("dto") SearchProMemberDTO dto);
}
