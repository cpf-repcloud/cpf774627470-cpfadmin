package cn.rep.cloud.custom.coreutils.systemexception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


/**
 * 所有异常 抛出到这里
 */
@ControllerAdvice
public class ExceptionAdvice {

 private Logger logger= LoggerFactory.getLogger(ExceptionAdvice.class);

    /**
     * 全局捕获异常 ，只要作用在requestmapping 就可以捕获异常
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value=Exception.class)
    public Map<String,Object> errorHander(Exception e){
        logger.error("程序异常",e);
        Map<String,Object> map=new HashMap<>();
        map.put("msg",e.getMessage());
        map.put("error",e.getStackTrace());
        map.put("code",-1);
        return map;
    }

}
