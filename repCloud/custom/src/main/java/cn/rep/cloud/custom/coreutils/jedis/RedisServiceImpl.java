package cn.rep.cloud.custom.coreutils.jedis;

import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl extends IRedisService {
    private static final String REDIS_KEY = "TEST_REDIS_KEY";
    @Override
    protected String getRedisKey() {
        return this.REDIS_KEY;
    }
}
