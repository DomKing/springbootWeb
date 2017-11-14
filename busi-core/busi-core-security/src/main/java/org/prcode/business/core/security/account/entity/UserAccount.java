package org.prcode.business.core.security.account.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.prcode.business.core.security.account.group.UserStateChange;
import org.prcode.business.support.basic.group.Create;
import org.prcode.business.support.basic.group.Edit;
import org.prcode.business.support.basic.validate.ValidateRegexp;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @className: UserAccount
 * @date: 2017-4-19 22:05
 * @author: kangduo
 * @description: ()
 */
public class UserAccount implements Serializable {
    private static final long serialVersionUID = -6819122784304918758L;

    @NotBlank(message = "用户ID不可为空", groups = {Edit.class})
    private String userId;
    /**
     * loginNo中的userAccount
     */
    private String username;

    /**
     * t_user中的username
     */
    @ValidateRegexp(regexp = "^[a-zA-Z0-9]{5,20}$", message = "账号需为5到20的字母或数字", groups = Create.class)
    private String userAccount;

    private String realName;
    @ValidateRegexp(regexp = "^(?!\\d+$)(?![a-zA-Z]+$)[0-9a-zA-Z]{6,16}$", message = "密码需为6-16位字符(字母与数字的组合)", groups = Create.class)
    private String password;
    private String mobile;
    private String unionId;

    @ValidateRegexp(regexp = "^[1-2]$", message = "操作不正确", groups = UserStateChange.class)
    private Byte userState;
    private Byte accountType;
    private Set<UserHasRole> roleList;

    @NotEmpty(message = "必须选择角色", groups = {Create.class, Edit.class})
    private List<String> roleIds;

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

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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

    public Byte getAccountType() {
        return accountType;
    }

    public void setAccountType(Byte accountType) {
        this.accountType = accountType;
    }

    public Set<UserHasRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(Set<UserHasRole> roleList) {
        this.roleList = roleList;
    }

    public List<String> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<String> roleIds) {
        this.roleIds = roleIds;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }
}
