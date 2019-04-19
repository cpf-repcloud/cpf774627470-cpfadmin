package cn.rep.cloud.custom.basicdata.business;

import cn.rep.cloud.custom.basecommon.common.Constants;
import cn.rep.cloud.custom.basicdata.dto.RepCityDTO;
import cn.rep.cloud.custom.basicdata.entity.RepCity;
import cn.rep.cloud.custom.basicdata.service.RepCityService;
import cn.rep.cloud.custom.basicdata.vo.RepCityVO;
import cn.rep.cloud.custom.coreutils.common.PageDTO;
import cn.rep.cloud.custom.coreutils.common.VeCollectionUtils;
import cn.rep.cloud.custom.openapi.kjController.basecommon.cskj.bean.CityBean;
import cn.rep.cloud.custom.openapi.kjController.basecommon.cskj.bean.KjCsResponse;
import com.baomidou.mybatisplus.plugins.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RepCityServiceImpl {

    /**
     * 日志记录类
     */
    private static final Logger logger = LoggerFactory.getLogger(RepCityServiceImpl.class);
    /**
     * 
     * 城市服务类
     */
    @Autowired
    private RepCityService repCityService;

    /**
     * 分页查询
     * @param pageDTO
     * @return
     */
    public Page<RepCity> seletPage(PageDTO<RepCityDTO> pageDTO){
        Page<RepCity> page =repCityService.selectPage(pageDTO);
        return page;
    }

    /**
     * 控件查询城市
     * @param dto
     * @return
     */
    public List<KjCsResponse> getCityList(RepCityDTO dto){
        dto.setGngj(Constants.GN);
        logger.info("开始查询城市数据: 入参为{}",dto);
        List<KjCsResponse> responseList = new ArrayList<>();
        //首先查询热门城市
        dto.setSfrm(Constants.SFRM_Y);
        List<RepCityVO> rmcsList = repCityService.getCityList(dto);
        List<CityBean> rmcsBeanList = new ArrayList<>();
        KjCsResponse rmcsResponse = new KjCsResponse();
        rmcsResponse.setFirstZ("");
        for (RepCityVO rmcs : rmcsList){
            CityBean rmcsBean = new CityBean();
            rmcsBean.setId(rmcs.getBh());
            rmcsBean.setBh(rmcs.getBh());
            rmcsBean.setName(rmcs.getMc());
            rmcsBeanList.add(rmcsBean);
            rmcsResponse.setId(rmcs.getBh());
        }
        rmcsResponse.setChildren(rmcsBeanList);
        responseList.add(rmcsResponse);

        //再查询其他城市分类
        dto.setSfrm(Constants.SFRM_N);
        List<RepCityVO> repCityVOS = repCityService.getCityList(dto);
        try {
            //根据城市分类分组(热门城市,A-Z)
            Map<String,List<RepCityVO>> cityGroups = VeCollectionUtils.group(repCityVOS,"firstZ");
            for (List<RepCityVO> lists : cityGroups.values()){
                KjCsResponse response = new KjCsResponse();
                List<CityBean> cityBeanList = new ArrayList<>();
                for (RepCityVO vo : lists){
                    CityBean cityBean = new CityBean();
                    cityBean.setId(vo.getBh());
                    cityBean.setBh(vo.getBh());
                    cityBean.setName(vo.getMc());
                    cityBeanList.add(cityBean);
                    response.setId(vo.getBh());
                    response.setFirstZ(vo.getFirstZ());
                }
                response.setChildren(cityBeanList);
                responseList.add(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("根据城市分类分组失败!");
        }
        return responseList;
    }

    /**
     * 城市控件搜索查询
     * @param dto
     * @return
     */
    public List<KjCsResponse> getSearchCity(RepCityDTO dto){
        List<KjCsResponse> responseList = new ArrayList<>();
        List<RepCityVO> repCityVOS = repCityService.getCityList(dto);
        for (RepCityVO vo : repCityVOS){
            KjCsResponse response = new KjCsResponse();
            response.setId(vo.getBh());
            response.setBh(vo.getBh());
            response.setName(vo.getMc());
            responseList.add(response);
        }
        return responseList;
    }

    
}
