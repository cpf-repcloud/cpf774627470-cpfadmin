package cn.rep.cloud.custom.coreutils.common;

import cn.rep.cloud.custom.basecommon.common.Constants;
import cn.rep.cloud.custom.basicdata.business.RepCountryServiceImpl;
import cn.rep.cloud.custom.basicdata.vo.RepCountryVO;
import cn.rep.cloud.custom.coreutils.jedis.RedisModel;
import cn.rep.cloud.custom.coreutils.jedis.RedisServiceImpl;
import cn.rep.cloud.custom.coreutils.utils.SerializeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 项目启动时需要缓存的数据
 */
@Component
public class StartService implements ApplicationRunner {
    private static Logger logger = LoggerFactory.getLogger(StartService.class);
    @Autowired
    private RedisServiceImpl redisService;
    @Autowired
    private RepCountryServiceImpl repCountryService;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.saveCountryCityKj();
    }

    private void saveCountryCityKj(){
        //首先将城市连级控件缓存删除
        redisService.removeByKey(Constants.CITY_LJKJ);
        //再将城市连级控件缓存
//        RedisModel redisModel = new RedisModel<>();
//        List<RepCountryVO> repCountryVOS = repCountryService.getCountryList();
//        redisModel.setResultLists(repCountryVOS);
//        redisService.put(Constants.CITY_LJKJ, SerializeUtil.serialize(redisModel),-1);
        logger.info("初始化城市连级控件");
    }
}
