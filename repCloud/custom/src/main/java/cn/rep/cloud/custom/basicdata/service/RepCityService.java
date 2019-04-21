package cn.rep.cloud.custom.basicdata.service;

import cn.rep.cloud.custom.basecommon.common.Constants;
import cn.rep.cloud.custom.basicdata.dto.RepCityDTO;
import cn.rep.cloud.custom.basicdata.entity.RepCity;
import cn.rep.cloud.custom.basicdata.mapper.RepCityMapper;
import cn.rep.cloud.custom.basicdata.vo.RepCityVO;
import cn.rep.cloud.custom.coreutils.common.PageCopyUtil;
import cn.rep.cloud.custom.coreutils.common.PageDTO;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RepCityService {
    @Autowired
    private RepCityMapper repCityMapper;

    /**
     * 分页查询
     * @param pageDTO
     * @return
     */
    public Page<RepCity> selectPage(PageDTO<RepCityDTO> pageDTO){
        Page<RepCity> page = PageCopyUtil.genPage(pageDTO);
        List<RepCity> list = repCityMapper.pagelist(page,pageDTO.getData());
        page.setRecords(list);
        return page;
    }

    /**
     * 用于控件查询城市
     * @param dto
     * @return
     */
    public List<RepCityVO> getCityList(RepCityDTO dto){
        List<RepCityVO> cityList = repCityMapper.getCityList(dto);
        return cityList;
    }

    /**
     * 用于控件查询城市
     * @param pageDTO
     * @return
     */
    public Page<RepCity> getPageCityList(PageDTO<RepCityDTO> pageDTO){
        Page<RepCity> page = PageCopyUtil.genPage(pageDTO);
        List<RepCity> cityList = repCityMapper.getPageCityList(page,pageDTO.getData());
        page.setRecords(cityList);
        return page;
    }
}
