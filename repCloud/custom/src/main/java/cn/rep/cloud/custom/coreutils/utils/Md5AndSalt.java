package cn.rep.cloud.custom.coreutils.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class Md5AndSalt {
    /**
     * 我们可以这样获取:盐值加密后的结果
     *
     * @param
     * @date 2018年8月15日 上午11:46:23
     */
    public static Object getMd5(String jmdx,String yhm) {
        // 加密算法(MD5、SHA1等)
        String hashAlgorithmName = "MD5";
        // 加密对象(即:密码)
        Object credentials = jmdx;
        // 盐值(注:一般使用用户名)
        Object salt = ByteSource.Util.bytes(yhm);
        // 迭代次数
        int hashIterations = 1024;
        // 执行加密
        Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        return result;
    }
}
