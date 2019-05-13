package cn.rep.cloud.custom.basicdata.controller;

import cn.rep.cloud.custom.basecommon.common.Constants;
import cn.rep.cloud.custom.basicdata.entity.RepCity;
import cn.rep.cloud.custom.coreutils.common.RestResponse;
import cn.rep.cloud.custom.coreutils.jedis.RedisModel;
import cn.rep.cloud.custom.coreutils.jedis.RedisServiceImpl;
import cn.rep.cloud.custom.coreutils.utils.SerializeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("repcity")
public class RepCityController {
    @Autowired
    private RedisServiceImpl redisService;

    @RequestMapping("getXlCityList")
    public RestResponse<List<RepCity>> getXlCityList(){
        byte[] citykj = redisService.getByKey(Constants.CITY_XLKJ);
        RedisModel redisModel = (RedisModel) SerializeUtil.unSerialize(citykj);
        List<RepCity> repCityList = redisModel.getResultLists();
        return new RestResponse(repCityList);
    }
}
