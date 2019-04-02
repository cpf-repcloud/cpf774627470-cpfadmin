package cn.rep.cloud.custom.organizationa.business;

import cn.rep.cloud.custom.coreutils.common.PageDTO;
import cn.rep.cloud.custom.coreutils.common.RepConstants;
import cn.rep.cloud.custom.coreutils.utils.DateUtils;
import cn.rep.cloud.custom.organizationa.dto.RepCompDTO;
import cn.rep.cloud.custom.organizationa.entity.RepComp;
import cn.rep.cloud.custom.organizationa.service.RepCompService;
import com.baomidou.mybatisplus.plugins.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepCompServiceImpl {
    /**
     * 日志记录类
     */
    private static final Logger logger = LoggerFactory.getLogger(RepCompServiceImpl.class);
    @Autowired
    private RepCompService repCompService;

    public Page<RepComp> seletPage(PageDTO<RepCompDTO> pageDTO){
        Page<RepComp> page =repCompService.selectPage(pageDTO);
        return page;
    }

    /**
     * 插入系统模块
     * @param dto 需要插入的模块数据
     * @return stu 是否成功
     */
    public boolean updateRepComp(RepCompDTO dto){
        dto.setCreattime(DateUtils.getNow());
        dto.setUpdatetime(DateUtils.getNow());
        return repCompService.updateRepComp(dto);
    }

    /**
     * 删除
     * @param dto
     * @return
     */
    public boolean deleteRepComp(RepCompDTO dto){
        return repCompService.deleteRepComp(dto);
    }

    /**
     * 插入系统模块
     * @param dto 需要插入的模块数据
     * @return stu 是否成功
     */
    public boolean insertRepComp(RepCompDTO dto){
        dto.setId(DateUtils.getNo(6));
        dto.setCreatuser("addmin");
        dto.setUpdateuser("addmin");
        dto.setCreattime(DateUtils.getNow());
        dto.setUpdatetime(DateUtils.getNow());
        dto.setIsdisabled(RepConstants.SFYX_YX);
        boolean istrue = repCompService.insertRepComp(dto);
        return istrue;
    }


}
