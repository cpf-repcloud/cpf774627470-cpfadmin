package cn.vetech.charge.cloud.base.server.mapper;

import cn.vetech.charge.cloud.base.server.entity.VeXmCy;
import cn.vetech.charge.cloud.base.server.service.projectmanage.dto.SearchProMemberDTO;
import cn.vetech.charge.cloud.base.server.service.projectmanage.vo.ProMembersVO;
import cn.vetech.charge.cloud.database.base.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * Created by vetech on 2018/8/9.
 */
public interface VeXmCyMapper  extends BaseMapper<VeXmCy> {


    List<ProMembersVO> selectProMember(Page page, @Param("dto") SearchProMemberDTO dto);

    int selectCountPro(@Param("dto") SearchProMemberDTO dto);
}
