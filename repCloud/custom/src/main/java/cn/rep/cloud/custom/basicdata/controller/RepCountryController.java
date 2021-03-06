package cn.rep.cloud.custom.basicdata.controller;

import cn.rep.cloud.custom.basecommon.common.Constants;
import cn.rep.cloud.custom.basicdata.business.RepCountryServiceImpl;
import cn.rep.cloud.custom.basicdata.vo.RepCountryVO;
import cn.rep.cloud.custom.coreutils.common.RestResponse;
import cn.rep.cloud.custom.coreutils.jedis.RedisModel;
import cn.rep.cloud.custom.coreutils.jedis.RedisServiceImpl;
import cn.rep.cloud.custom.coreutils.utils.SerializeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("country")
public class RepCountryController {

}
