package org.prcode.business.support.basic.security.domain;

import org.prcode.business.basedomain.role.domain.Role;

import java.util.List;

/**
 * @ClassName: CustomerUrlRoles
 * @Date: 2017-4-16 20:42
 * @Auther: kangduo
 * @Description: (url对应的可访问角色列表)
 */
public class CustomerUrlRoles {
    private String url;
    private List<Role> roles;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
