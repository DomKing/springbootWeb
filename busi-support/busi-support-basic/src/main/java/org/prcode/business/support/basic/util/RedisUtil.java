package org.prcode.business.support.basic.util;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.prcode.utility.util.ExceptionUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @className: RedisUtil.
 * @date: 2017-11-14 18:12
 * @author: kangduo
 * @description: ()
 */
@Component
public class RedisUtil {

    private static final Logger logger = Logger.getLogger(RedisUtil.class);


    private static RedisTemplate redisTemplate;
    @Resource
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        if (RedisUtil.redisTemplate == null) {
            RedisUtil.redisTemplate = redisTemplate;
        }
    }

    /**
     * 批量删除对应的value
     *
     * @param keys 键
     */
    public static void del(final String... keys) {
        for (String key : keys) {
            del(key);
        }
    }

    /**
     * 批量删除key
     *
     * @param pattern 表达式
     */
    @SuppressWarnings("unchecked")
    public static void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0) {
            redisTemplate.delete(keys);
        }
    }

    /**
     * 删除对应的value
     *
     * @param key 键
     */
    @SuppressWarnings("unchecked")
    public static void del(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key 键
     * @return 是否包含指定key
     */
    @SuppressWarnings("unchecked")
    public static boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 读取缓存
     *
     * @param key 键
     * @return 值
     */
    @SuppressWarnings("unchecked")
    public static Object get(final String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 写入缓存
     *
     * @param key 键
     * @param value 值
     * @return 写入是否成功
     */
    @SuppressWarnings("unchecked")
    public static boolean set(final String key, Object value) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().set(key, value);
            result = true;
        } catch (Exception e) {
            logger.debug(ExceptionUtil.parseException(e));
        }
        return result;
    }

    /**
     * 写入缓存，指定过期秒数
     *
     * @param key 键
     * @param value 值
     * @return 写入是否成功
     */
    @SuppressWarnings("unchecked")
    public static boolean set(final String key, Object value, Long expireSeconds) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().set(key, value);
            redisTemplate.expire(key, expireSeconds, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            logger.debug(ExceptionUtil.parseException(e));
        }
        return result;
    }
}
