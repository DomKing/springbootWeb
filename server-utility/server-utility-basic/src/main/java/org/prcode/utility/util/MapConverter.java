package org.prcode.utility.util;

import org.apache.log4j.Logger;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: MapConverter
 * @Date: 2017-03-24 16:47
 * @Auther: kangduo
 * @Description: (map转化类)
 */
public class MapConverter {

    private static final Logger logger = Logger.getLogger(MapConverter.class);
    /**
     * 将一个 JavaBean 对象转化为一个  Map
     *
     * @param bean 要转化的JavaBean 对象
     * @return 转化出来的  Map 对象
     */
    public static Map<String, Object> toMap(Object bean) {
        Map<String, Object> returnMap = null;
        try {
            Class<?> type = bean.getClass();
            returnMap = new HashMap<>();
            BeanInfo beanInfo = Introspector.getBeanInfo(type);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor descriptor : propertyDescriptors) {
                String propertyName = descriptor.getName();
                if (!propertyName.equals("class")) {
                    Method readMethod = descriptor.getReadMethod();
                    Object result = readMethod.invoke(bean);
                    if (result != null) {
                        returnMap.put(propertyName, result);
                    } else {
                        returnMap.put(propertyName, null);
                    }
                }
            }
        } catch (Exception e) {
            returnMap = null;
            logger.error(ExceptionUtil.parseException(e));
        }
        return returnMap;
    }
}
