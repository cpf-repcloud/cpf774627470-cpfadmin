package cn.rep.cloud.custom.basicdata.service;

import cn.rep.cloud.custom.basicdata.dto.RepCountryDTO;
import cn.rep.cloud.custom.basicdata.entity.RepCountry;
import cn.rep.cloud.custom.basicdata.mapper.RepCountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepCountryService {
    @Autowired
    private RepCountryMapper repCountryMapper;

    /**
     * 查询省份/国家/洲
     * @return
     */
    public List<RepCountry> getCountryList(RepCountryDTO dto){
        List<RepCountry> countries = repCountryMapper.getCountryList(dto);
        return countries;
    }
}
