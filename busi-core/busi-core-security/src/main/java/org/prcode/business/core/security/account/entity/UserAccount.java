package org.prcode.business.core.security.account.entity;

import io.swagger.models.auth.In;
import org.prcode.business.basedomain.role.domain.Role;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: UserAccount
 * @Date: 2017-4-19 22:05
 * @Auther: kangduo
 * @Description: ()
 */
public class UserAccount implements Serializable {
    private static final long serialVersionUID = -6819122784304918758L;
    private String userId;
    private String username;
    private String password;
    private String mobile;
    private Byte userState;
    private List<Role> roleList;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Byte getUserState() {
        return userState;
    }

    public void setUserState(Byte userState) {
        this.userState = userState;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
