package org.prcode.business.support.basic.security.config;

import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName: CustomerFilterSecurityInterceptor
 * @Date: 2017-4-16 20:15
 * @Auther: kangduo
 * @Description: (权限管理过滤器)
 */
public class CustomerFilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter {

    private CustomerSecurityMetadataSource customerSecurityMetadataSource;
    public void setCustomerSecurityMetadataSource(CustomerSecurityMetadataSource customerSecurityMetadataSource) {
        this.customerSecurityMetadataSource = customerSecurityMetadataSource;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        FilterInvocation fi = new FilterInvocation(request, response, chain);
        invoke(fi);
    }
    private void invoke(FilterInvocation fi) throws IOException, ServletException {
        InterceptorStatusToken token = super.beforeInvocation(fi);
        try {
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            super.afterInvocation(token, null);
        }
    }

    @Override
    public Class<?> getSecureObjectClass() {
        return FilterInvocation.class;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return this.customerSecurityMetadataSource;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}
    @Override
    public void destroy() {}
}
