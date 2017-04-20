package org.prcode.business.support.basic.messageConverter;

import org.prcode.business.support.basic.messageConverter.annotation.CacheDuration;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.*;

import static org.springframework.core.annotation.AnnotationUtils.findAnnotation;

/**
 * @ClassName: CustomerRedisCacheManager
 * @Date: 2017-04-18 15:56
 * @Auther: kangduo
 * @Description: (自定义redisCacheManager)
 */
public class CustomerRedisCacheManager extends RedisCacheManager implements ApplicationContextAware, InitializingBean {
    private ApplicationContext applicationContext;

    public CustomerRedisCacheManager(RedisOperations redisOperations) {
        super(redisOperations);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() {
        parseCacheDuration(applicationContext);
    }

    private void parseCacheDuration(ApplicationContext applicationContext) {
        final Map<String, Long> cacheExpires = new HashMap<>();
        String[] beanNames = applicationContext.getBeanNamesForType(Object.class);
        for (String beanName : beanNames) {
            final Class clazz = applicationContext.getType(beanName);
            addCacheExpires(clazz, cacheExpires);
        }
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
