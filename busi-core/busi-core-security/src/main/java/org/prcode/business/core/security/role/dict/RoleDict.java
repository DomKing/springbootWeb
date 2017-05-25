package org.prcode.business.core.security.role.dict;

/**
 * @ClassName: RoleDict
 * @Date: 2017-4-22 14:53
 * @Auther: kangduo
 * @Description: (角色字典类)
 */
public class RoleDict {
    public static class SpecialRole {
        //LP 普通用户
        public static final String LP_ROLE_USER = "LpRoleUser";
    }
    public static class RoleState {
        //启用
        public static final byte NORMAL = 1;
        //禁用
        public static final byte FORBIDDEN = 2;
    }
}
