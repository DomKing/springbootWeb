package org.prcode.business.core.security.account.entity;

import java.io.Serializable;

/**
 * @className: UserHasRole
 * @date: 2017-4-22 16:02
 * @author: kangduo
 * @description: ()
 */
public class UserHasRole implements Serializable{
    private static final long serialVersionUID = -1661880085302969664L;

    private String roleId;
    private String roleName;
    private String roleDesc;
    private Boolean hasRole;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public Boolean getHasRole() {
        return hasRole;
    }

    public void setHasRole(Boolean hasRole) {
        this.hasRole = hasRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserHasRole that = (UserHasRole) o;

        if (roleId != null ? !roleId.equals(that.roleId) : that.roleId != null) {
            return false;
        }
        if (roleName != null ? !roleName.equals(that.roleName) : that.roleName != null) {
            return false;
        }
        if (roleDesc != null ? !roleDesc.equals(that.roleDesc) : that.roleDesc != null) {
            return false;
        }
        return hasRole != null ? hasRole.equals(that.hasRole) : that.hasRole == null;
    }

    @Override
    public int hashCode() {
        int result = roleId != null ? roleId.hashCode() : 0;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        result = 31 * result + (roleDesc != null ? roleDesc.hashCode() : 0);
        result = 31 * result + (hasRole != null ? hasRole.hashCode() : 0);
        return result;
    }
}
