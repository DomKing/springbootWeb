package org.prcode.business.core.security.role.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.prcode.business.core.security.role.group.RoleStateChange;
import org.prcode.business.support.basic.group.Create;
import org.prcode.business.support.basic.validate.ValidateRegexp;

import java.io.Serializable;
import java.util.List;

/**
 * @className: RoleEntity
 * @date: 2017-4-22 14:58
 * @author: kangduo
 * @description: ()
 */
public class RoleEntity implements Serializable{
    private static final long serialVersionUID = 7325858210842114309L;

    private Long id;
    @NotBlank(message = "请输入角色名", groups = Create.class)
    private String roleName;
    @NotBlank(message = "请输入角色code", groups = Create.class)
    private String roleCode;
    @NotBlank(message = "请输入角色描述", groups = Create.class)
    private String roleDesc;

    @ValidateRegexp(regexp = "^[1-2]$", message = "操作不正确", groups = RoleStateChange.class)
    private Byte roleState;

    @NotEmpty(message = "必须选择权限", groups = Create.class)
    private List<Long> resourceUrlIds;

    /**
     * 拥有的权限
     */
    private List<RolePrivilege> privileges;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public Byte getRoleState() {
        return roleState;
    }

    public void setRoleState(Byte roleState) {
        this.roleState = roleState;
    }

    public List<Long> getResourceUrlIds() {
        return resourceUrlIds;
    }

    public void setResourceUrlIds(List<Long> resourceUrlIds) {
        this.resourceUrlIds = resourceUrlIds;
    }

    public List<RolePrivilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<RolePrivilege> privileges) {
        this.privileges = privileges;
    }
}
