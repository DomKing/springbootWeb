package org.prcode.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @className: SessionConfig
 * @date: 2017-04-18 17:54
 * @author: kangduo
 * @description: ()
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 3600)
public class SessionConfig {
}
