package org.prcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * EnableCaching支持使用springCache
 * EnableAsync运行@Async进行异步操作
 */
@SpringBootApplication
@EnableCaching
@EnableAsync
@EnableScheduling
public class WebOOSApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebOOSApplication.class, args);
	}
}
