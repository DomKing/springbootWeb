package org.prcode.socket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @className: WebScoketConfig.
 * @date: 2017-11-24 14:53
 * @author: kangduo
 * @description: (自动注册使用了ServerEndpoint注解声明的Websocket endpoint, 如果使用独立的servlet容器,
 *                  而不是直接使用springboot的内置容器, 就不要注入ServerEndpointExporter,因为它将由容器自己提供和管理)
 */
@Configuration
public class WebScoketConfig {
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
