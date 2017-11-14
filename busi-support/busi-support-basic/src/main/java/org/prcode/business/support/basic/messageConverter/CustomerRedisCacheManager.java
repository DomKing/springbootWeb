package org.prcode.business.support.basic.messageConverter;

import org.apache.log4j.Logger;
import org.prcode.business.support.basic.messageConverter.annotation.CacheDuration;
import org.prcode.utility.util.ClassUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.*;

import static org.springframework.core.annotation.AnnotationUtils.findAnnotation;

/**
 * @className: CustomerRedisCacheManager
 * @date: 2017-04-18 15:56
 * @author: kangduo
 * @description: (自定义redisCacheManager)
 */
public class CustomerRedisCacheManager extends RedisCacheManager implements InitializingBean {

    private static final String BASE_SCAN_PACKAGE = "org.prcode.business";
    private static final Logger logger = Logger.getLogger(CustomerRedisCacheManager.class);
    public CustomerRedisCacheManager(RedisOperations redisOperations) {
        super(redisOperations);
    }

    @Override
    public void afterPropertiesSet() {
        parseCacheDuration();
    }

    private void parseCacheDuration() {
        final Map<String, Long> cacheExpires = new HashMap<>();
        //扫描service，这里不用spring直接获取bean，是因为有的service拿不到注解，原因暂未明
        List<Class> classes = ClassUtil.scanPackage(BASE_SCAN_PACKAGE,
                clazz -> findAnnotation(clazz, Service.class) != null);
        for (Class aClass : classes) {
            addCacheExpires(aClass, cacheExpires);
        }
        logger.debug("初始化redisCacheManager, 配置有过期时间的key, 内容如下：" + cacheExpires);
        //设置有效期
        super.setExpires(cacheExpires);
    }

    private void addCacheExpires(final Class clazz, final Map<String, Long> cacheExpires) {
        ReflectionUtils.doWithMethods(clazz, method -> {
            ReflectionUtils.makeAccessible(method);
            CacheDuration cacheDuration = findCacheDuration(clazz, method);
            Cacheable cacheable = findAnnotation(method, Cacheable.class);
            CacheConfig cacheConfig = findAnnotation(clazz, CacheConfig.class);
            Set<String> cacheNames = findCacheNames(cacheConfig, cacheable);
            for (String cacheName : cacheNames) {
                if (cacheDuration != null) {
                    cacheExpires.put(cacheName, cacheDuration.expireSeconds());
                }
            }
        }, method -> null != findAnnotation(method, Cacheable.class));
    }

    private CacheDuration findCacheDuration(Class clazz, Method method) {
        CacheDuration methodCacheDuration = findAnnotation(method, CacheDuration.class);
        if (null != methodCacheDuration) {
            return methodCacheDuration;
        }
        CacheDuration classCacheDuration = findAnnotation(clazz, CacheDuration.class);
        if (null != classCacheDuration) {
            return classCacheDuration;
        }
        return null;
    }

    private HashSet<String> findCacheNames(CacheConfig cacheConfig, Cacheable cacheable) {
        return cacheable.value().length == 0 ? new HashSet<>(Arrays.asList(cacheConfig.cacheNames())) : new HashSet<>(Arrays.asList(cacheable.value()));
    }
}
