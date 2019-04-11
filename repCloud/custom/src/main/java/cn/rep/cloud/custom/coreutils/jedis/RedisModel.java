package cn.rep.cloud.custom.coreutils.jedis;

import org.apache.poi.ss.formula.functions.T;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class RedisModel<T> implements Serializable {
    /**
     * redis key
     */
    private String redisKey;
    /**
     * 储存对象
     */
    private T resultModel;
    /**
     * 储存list集合
     */
    private List<T> resultLists;
    /**
     * 储存map集合
     */
    private Map<Object,Object> resultMaps;

    public String getRedisKey() {
        return redisKey;
    }

    public void setRedisKey(String redisKey) {
        this.redisKey = redisKey;
    }

    public T getResultModel() {
        return resultModel;
    }

    public void setResultModel(T resultModel) {
        this.resultModel = resultModel;
    }

    public List<T> getResultLists() {
        return resultLists;
    }

    public void setResultLists(List<T> resultLists) {
        this.resultLists = resultLists;
    }

    public Map<Object, Object> getResultMaps() {
        return resultMaps;
    }

    public void setResultMaps(Map<Object, Object> resultMaps) {
        this.resultMaps = resultMaps;
    }
}
