/*******************************************************************************
 * Copyright (c) 2005, 2017 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package cn.rep.cloud.framework.common;

import java.security.SecureRandom;
import java.util.UUID;

/**
 * 封装各种生成唯一性ID算法的工具类.
 * @author houya
 */
public class IdGenerator {

    /**
     * 随机数
     */
    private static SecureRandom random = new SecureRandom();

    /**
     * 封装JDK自带的UUID, 通过Random数字生成, 中间有-分割.
     *
     * @return f3fe3397-3eeb-4937-9dd0-7adec82c4c77  36位长
     */
    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    /**
     * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
     *
     * @return uuid2:7d4901f285814e04bb814b0f337eb173  32
     */
    public static String uuid2() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
