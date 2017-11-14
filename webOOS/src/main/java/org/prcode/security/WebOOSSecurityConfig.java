package org.prcode.security;

import javax.annotation.Resource;

import org.prcode.business.support.basic.SystemConstant;
import org.prcode.business.support.basic.security.config.CsrfSecurityRequestMatcher;
import org.prcode.business.support.basic.security.config.CustomerAccessDecisionManager;
import org.prcode.business.support.basic.security.config.CustomerFilterSecurityInterceptor;
import org.prcode.business.support.basic.security.config.CustomerSecurityMetadataSource;
import org.prcode.business.support.basic.security.service.SecurityService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @className: WebOOSSecurityConfig
 * @date: 2017-4-16 14:23
 * @author: kangduo
 * @description: (安全控制配置)
 */
@Configuration
@EnableWebSecurity
public class WebOOSSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private CustomerUserDetailService customerUserDetailService;
    @Resource
    private LoginSuccessHandler loginSuccessHandler;
    @Resource
    private SecurityService securityService;
    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Bean
    public CsrfSecurityRequestMatcher csrfSecurityRequestMatcher() {
        return new CsrfSecurityRequestMatcher(securityService, SystemConstant.OOS_SYSTEM);
    }

    @Bean
    public CustomerAccessDecisionManager customerAccessDecisionManager() {
        return new CustomerAccessDecisionManager(securityService);
    }

    @Bean
    public CustomerSecurityMetadataSource customerSecurityMetadataSource() {
        return new CustomerSecurityMetadataSource(securityService, SystemConstant.OOS_SYSTEM);
    }

    @Bean
    public CustomerFilterSecurityInterceptor customerFilterSecurityInterceptor() {
        CustomerFilterSecurityInterceptor customFilter = new CustomerFilterSecurityInterceptor();
        customFilter.setCustomerSecurityMetadataSource(customerSecurityMetadataSource());
        customFilter.setAccessDecisionManager(customerAccessDecisionManager());
        customFilter.setAuthenticationManager(authenticationManager);
        return customFilter;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customerUserDetailService).passwordEncoder(passwordEncoder);
        auth.eraseCredentials(false);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login").failureUrl("/login?error").successForwardUrl("/").permitAll()
                .successHandler(loginSuccessHandler)
                .and().authorizeRequests().antMatchers("/css/**","/images/**", "/js/**", "/html/**").permitAll()
                .and().authorizeRequests().antMatchers("/logoutSuccess", "/deny").permitAll()
                .anyRequest().authenticated()
                .and().logout().logoutSuccessUrl("/logoutSuccess")
                .and().exceptionHandling().accessDeniedPage("/deny")
                .and().csrf().requireCsrfProtectionMatcher(csrfSecurityRequestMatcher())
                .and().headers().frameOptions().sameOrigin();
    }

}
