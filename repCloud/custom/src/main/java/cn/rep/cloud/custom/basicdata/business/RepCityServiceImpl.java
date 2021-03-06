package cn.rep.cloud.custom.basicdata.business;

import cn.rep.cloud.custom.basecommon.common.Constants;
import cn.rep.cloud.custom.basicdata.dto.RepCityDTO;
import cn.rep.cloud.custom.basicdata.entity.RepCity;
import cn.rep.cloud.custom.basicdata.service.RepCityService;
import cn.rep.cloud.custom.basicdata.vo.BasicDataBean;
import cn.rep.cloud.custom.basicdata.vo.RepCityVO;
import cn.rep.cloud.custom.basicdata.vo.RepCountryVO;
import cn.rep.cloud.custom.coreutils.common.PageDTO;
import cn.rep.cloud.custom.coreutils.common.VeCollectionUtils;
import cn.rep.cloud.custom.openapi.kjController.basecommon.cskj.bean.CityBean;
import cn.rep.cloud.custom.openapi.kjController.basecommon.cskj.bean.KjCsResponse;
import cn.rep.cloud.custom.openapi.kjController.basecommon.cskj.bean.KjXlCsResponse;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.lang.StringUtils;
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
        dto.setSfrm("");
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
     * @param pageDTO
     * @return
     */
    public KjCsResponse getSearchCity(PageDTO<RepCityDTO> pageDTO){
        Page<RepCity> repCityVOS = repCityService.getPageCityList(pageDTO);
        KjCsResponse response = new KjCsResponse();
        List<CityBean> responseList = new ArrayList<>();
        for (RepCity vo : repCityVOS.getRecords()){
            CityBean cityBean = new CityBean();
            cityBean.setId(vo.getBh());
            cityBean.setBh(vo.getBh());
            cityBean.setName(vo.getMc());
            responseList.add(cityBean);
        }
        response.setChildren(responseList);
        response.setTotal(repCityVOS.getTotal());
        return response;
    }

    /**
     * 根据省份id查询城市
     * @param parid
     * @return
     */
    public List<BasicDataBean> getCityListByParid(String parid){
        if (StringUtils.isBlank(parid)) return null;
        return repCityService.getCityListByParid(parid);
    }

    /**
     * 根据父级id查询城市
     * @param sjid 上级id
     * @return
     */
    public List<RepCountryVO> getCityListBySjid(String sjid){
        if (StringUtils.isBlank(sjid)) return null;
        return repCityService.getCityListBySjid(sjid);
    }

    /**
     * 根据城市id 查询城市/省份名称
     * @param csid 城市id
     * @return
     */
    public RepCityDTO getCityCountryByCsid(String csid){
        if (StringUtils.isBlank(csid)) return null;
        return repCityService.getCityCountryByCsid(csid);
    }


    /**
     * 查询下拉城市控件
     * @return
     */
    public List<KjXlCsResponse> getXlCityKj(){
        List<KjXlCsResponse> responseList = repCityService.getXlCityKj();
        return responseList;
    }
}
