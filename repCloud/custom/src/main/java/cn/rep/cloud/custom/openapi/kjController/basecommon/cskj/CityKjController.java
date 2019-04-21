package cn.rep.cloud.custom.openapi.kjController.basecommon.cskj;

import cn.rep.cloud.custom.basicdata.business.RepCityServiceImpl;
import cn.rep.cloud.custom.basicdata.dto.RepCityDTO;
import cn.rep.cloud.custom.basicdata.entity.RepCity;
import cn.rep.cloud.custom.coreutils.common.PageDTO;
import cn.rep.cloud.custom.coreutils.common.RestResponse;
import cn.rep.cloud.custom.openapi.kjController.basecommon.cskj.bean.KjCsRequest;
import cn.rep.cloud.custom.openapi.kjController.basecommon.cskj.bean.KjCsResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/kj/city")
public class CityKjController {
    @Autowired
    private RepCityServiceImpl repCityService;

    /**
     * 查询城市list
     * @param request
     * @return
     */
    @RequestMapping("getCityList")
    public RestResponse<List<RepCity>> getCityList(@RequestBody KjCsRequest request){
        RepCityDTO dto = new RepCityDTO();
        List<KjCsResponse> csList = repCityService.getCityList(dto);
        return new RestResponse(csList);
    }

    /**
     * 查询城市list
     * @param request
     * @return
     */
    @RequestMapping("getSearchCity")
    public RestResponse<KjCsResponse> getSearchCity(@RequestBody KjCsRequest request){
        RepCityDTO dto = new RepCityDTO();
        dto.setGjz(request.getValue().toUpperCase());
        PageDTO<RepCityDTO> pageDTO = new PageDTO<>();
        pageDTO.setCurrent(request.getCurrent());
        pageDTO.setData(dto);
        KjCsResponse response = repCityService.getSearchCity(pageDTO);
        return new RestResponse(response);
    }
}
