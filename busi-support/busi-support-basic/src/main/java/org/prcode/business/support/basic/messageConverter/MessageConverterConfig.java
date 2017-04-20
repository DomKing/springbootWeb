package org.prcode.business.support.basic.messageConverter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import javax.annotation.Resource;

/**
 * @ClassName: MessageConverterConfig
 * @Date: 2017-03-30 20:58
 * @Auther: kangduo
 * @Description: (消息转换器, 去除返回数据中的null)
 */
@Configuration
public class MessageConverterConfig {

    @Resource
    private ObjectMapper objectMapper;
    @Resource
    private RedisConnectionFactory redisConnectionFactory;
    @Resource
    private RedisTemplate redisTemplate;

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper;
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        messageConverter.setObjectMapper(objectMapper);
        return messageConverter;
    }

    @Bean
    public CustomerRedisCacheManager cacheManager() {
        CustomerRedisCacheManager redisCacheManager = new CustomerRedisCacheManager(redisTemplate);
        redisCacheManager.setUsePrefix(true);
        return redisCacheManager;
    }

}
