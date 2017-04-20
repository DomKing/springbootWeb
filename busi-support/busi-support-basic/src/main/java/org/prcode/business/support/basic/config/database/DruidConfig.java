package org.prcode.business.support.basic.config.database;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: DruidConfig
 * @Date: 2017-03-29 17:26
 * @Auther: kangduo
 * @Description: (Druid监控页面配置)
 */
@Configuration
public class DruidConfig {

    private final DbConfigProperties dbConfigProperties;

    @Autowired
    public DruidConfig(DbConfigProperties dbConfigProperties) {
        this.dbConfigProperties = dbConfigProperties;
    }

    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean reg = new ServletRegistrationBean();
        reg.setServlet(new StatViewServlet());
        reg.addUrlMappings("/druid/*");
        reg.addInitParameter("allow", "127.0.0.1");//允许访问地址，不填则全允许，填了只允许
//        reg.addInitParameter("deny", "127.0.0.1");
        reg.addInitParameter("loginUsername", dbConfigProperties.getDruidVisitName());
        reg.addInitParameter("loginPassword", dbConfigProperties.getDruidVisitPwd());
        return reg;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

}
