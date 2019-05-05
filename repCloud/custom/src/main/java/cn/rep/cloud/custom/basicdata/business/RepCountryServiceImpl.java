package cn.rep.cloud.custom.basicdata.business;

import cn.rep.cloud.custom.basicdata.dto.RepCountryDTO;
import cn.rep.cloud.custom.basicdata.entity.RepCity;
import cn.rep.cloud.custom.basicdata.entity.RepCountry;
import cn.rep.cloud.custom.basicdata.service.RepCityService;
import cn.rep.cloud.custom.basicdata.service.RepCountryService;
import cn.rep.cloud.custom.basicdata.vo.BasicDataBean;
import cn.rep.cloud.custom.basicdata.vo.RepCountryVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RepCountryServiceImpl {

    /**
     * 日志记录类
     */
    private static final Logger logger = LoggerFactory.getLogger(RepCountryServiceImpl.class);
    /**
     * 
     * 城市服务类
     */
    @Autowired
    private RepCityServiceImpl repCityService;
    /**
     * 国家/城市/洲服务
     */
    @Autowired
    private RepCountryService repCountryService;


    /**
     * 查询省份,城市集合  用于城市级联控件
     * @return
     */
    public List<RepCountryVO> getCountryList(){
        // 先查询国内省份
        RepCountryDTO dto = new RepCountryDTO();
        dto.setId("020");
        List<RepCountry> repCountries = repCountryService.getCountryList(dto);
        List<RepCountryVO> repCountryVOS = new ArrayList<>();
        //再通过省份查询省份内城市
        for (RepCountry country : repCountries){
            RepCountryVO repCountryVO = new RepCountryVO();
            repCountryVO.setValue(country.getId());
            repCountryVO.setLabel(country.getMc());
            List<BasicDataBean> repCities = repCityService.getCityListByParid(country.getId());
//            for (RepCountryVO repCity : repCities){
//                //查询地级县市
//                List<RepCountryVO> childrens = repCityService.getCityListBySjid(repCity.getValue());
//                repCity.setChildren(childrens);
//            }
            repCountryVO.setChildren(repCities);
            repCountryVOS.add(repCountryVO);
        }
        return repCountryVOS;
    }
}
