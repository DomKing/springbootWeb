package org.prcode.business.support.basic.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @ClassName: SpringUtil
 * @Date: 2017-4-24 21:28
 * @Auther: kangduo
 * @Description: (SpringUtil, 用来普通类获取bean)
 */
@Component
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(SpringUtil.applicationContext == null) {
            SpringUtil.applicationContext = applicationContext;
        }
    }

    private static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 通过name获取bean
     * @param name spring管理的bean名称
     * @return bean
     */
    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }


    /**
     * 通过名称和class获取指定bean
     * @param name name
     * @param clazz class
     * @param <T> 泛型
     * @return bean
     */
    public static <T> T getBean(String name,Class<T> clazz){
        return getApplicationContext().getBean(name, clazz);
    }
}
