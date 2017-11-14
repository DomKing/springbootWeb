package org.prcode.business.core.security.role.dict;

/**
 * @className: RoleDict
 * @date: 2017-4-22 14:53
 * @author: kangduo
 * @description: (角色字典类)
 */
public class RoleDict {
    public static class SpecialRole {
        /**
         * MP 普通用户
         */
        public static final String MP_ROLE_USER = "MpRoleUser";
    }
    public static class RoleState {
        /**
         * 启用
         */
        public static final byte NORMAL = 1;
        /**
         * 禁用
         */
        public static final byte FORBIDDEN = 2;
    }
}
