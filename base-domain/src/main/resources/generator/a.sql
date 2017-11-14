
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE IF NOT EXISTS `t_user` (
  `f_id` bigint(32) NOT NULL COMMENT 'userId',
  `f_user_name` varchar(100) NOT NULL COMMENT '用户名',
  `f_real_name` varchar(100) DEFAULT NULL COMMENT '真实姓名',
  `f_id_card` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `f_pay_pwd` varchar(100) DEFAULT NULL COMMENT '支付密码',
  `f_mobile` varchar(16) DEFAULT NULL COMMENT '手机号',
  `f_state` tinyint(4) NOT NULL DEFAULT '1' COMMENT '当前状态，1正常，2禁止登录',
  `f_last_pwdmod_time` datetime DEFAULT NULL COMMENT '最近修改密码时间',
  `f_device_id` varchar(255) DEFAULT NULL COMMENT '设备Id',
  `f_sys_add_time` datetime DEFAULT NULL COMMENT '新增时间',
  `f_sys_upd_time` datetime DEFAULT NULL COMMENT '修改时间',
  `f_sys_del_time` datetime DEFAULT NULL COMMENT '删除时间',
  `f_sys_add_user` bigint(32) DEFAULT NULL COMMENT '新增人',
  `f_sys_upd_user` bigint(32) DEFAULT NULL COMMENT '修改人',
  `f_sys_del_user` bigint(32) DEFAULT NULL COMMENT '删除人',
  `f_sys_del_state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除状态',
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';


DROP TABLE IF EXISTS `t_role`;
CREATE TABLE IF NOT EXISTS `t_role` (
  `f_id` bigint(32) NOT NULL COMMENT 'roleId',
  `f_role_name` varchar(100) NOT NULL COMMENT '角色名称',
  `f_role_code` varchar(100) NOT NULL COMMENT '角色代码',
  `f_role_desc` varchar(100) NOT NULL COMMENT '角色描述',
  `f_system_code` varchar(32) NOT NULL COMMENT '系统code',
  `f_role_state` tinyint(4) NOT NULL COMMENT '状态，1启用，2禁用',
  `f_sys_add_time` datetime DEFAULT NULL COMMENT '新增时间',
  `f_sys_upd_time` datetime DEFAULT NULL COMMENT '修改时间',
  `f_sys_del_time` datetime DEFAULT NULL COMMENT '删除时间',
  `f_sys_add_user` bigint(32) DEFAULT NULL COMMENT '新增人',
  `f_sys_upd_user` bigint(32) DEFAULT NULL COMMENT '修改人',
  `f_sys_del_user` bigint(32) DEFAULT NULL COMMENT '删除人',
  `f_sys_del_state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除状态',
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';


DROP TABLE IF EXISTS `t_resource_url`;
CREATE TABLE IF NOT EXISTS `t_resource_url` (
  `f_id` bigint(32) NOT NULL COMMENT 'resourceUrlId',
  `f_url` varchar(100) NOT NULL COMMENT '不可匿名访问的地址',
  `f_url_desc` varchar(100) NOT NULL COMMENT '描述',
  `f_parent_id` bigint(32) DEFAULT NULL COMMENT '父级ID',
  `f_is_menu` tinyint(1) NOT NULL COMMENT '是否菜单',
  `f_level` TINYINT(4) NOT NULL COMMENT '层级',
  `f_system_code` varchar(32) NOT NULL COMMENT '系统code',
  `f_need_csrf` TINYINT(1) NOT NULL DEFAULT '0' COMMENT '是否校验csrf',
  `f_order` INT(10) NOT NULL DEFAULT '0' COMMENT '优先级，同level大的在上',
  `f_sys_add_time` datetime DEFAULT NULL COMMENT '新增时间',
  `f_sys_upd_time` datetime DEFAULT NULL COMMENT '修改时间',
  `f_sys_del_time` datetime DEFAULT NULL COMMENT '删除时间',
  `f_sys_add_user` bigint(32) DEFAULT NULL COMMENT '新增人',
  `f_sys_upd_user` bigint(32) DEFAULT NULL COMMENT '修改人',
  `f_sys_del_user` bigint(32) DEFAULT NULL COMMENT '删除人',
  `f_sys_del_state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除状态',
  PRIMARY KEY (`f_id`),
  KEY `idx_resourceUrl_parentId` (`f_parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='访问链接表';

DROP TABLE IF EXISTS `t_comm_sys_para`;
CREATE TABLE `t_comm_sys_para` (
	`f_id` bigint(32) NOT NULL COMMENT 'id',
	`f_sys_para_code` VARCHAR(50) NULL DEFAULT NULL COMMENT '参数码',
	`f_sys_para_value` VARCHAR(1024) NULL DEFAULT NULL COMMENT '参数值',
	`f_sys_para_desc` VARCHAR(100) NULL DEFAULT NULL COMMENT '参数描述',
	`f_sys_add_time` DATETIME NULL DEFAULT NULL COMMENT '新增时间',
	`f_sys_upd_time` DATETIME NULL DEFAULT NULL COMMENT '更新时间',
	`f_sys_del_time` DATETIME NULL DEFAULT NULL COMMENT '删除时间',
	`f_sys_add_user` bigint(32) NULL DEFAULT NULL COMMENT '新增者',
	`f_sys_upd_user` bigint(32) NULL DEFAULT NULL COMMENT '修改者',
	`f_sys_del_user` bigint(32) NULL DEFAULT NULL COMMENT '删除者',
	`f_sys_del_state` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '记录状态=={"0":"正常","1":"已删除"}',
	PRIMARY KEY (`f_id`),
	UNIQUE INDEX `f_sys_para_code_UNIQUE` (`f_sys_para_code`) USING BTREE
)
COMMENT='系统参数'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

DROP TABLE IF EXISTS `t_login_log`;
DROP TABLE IF EXISTS `t_login_log`;
CREATE TABLE IF NOT EXISTS `t_login_log` (
  `f_id` bigint(32) NOT NULL COMMENT 'id',
  `f_user_id` bigint(32) NOT NULL COMMENT 'userId',
  `f_user_account` varchar(100) NOT NULL COMMENT '登录账号',
  `f_system_code` VARCHAR(100) NOT NULL COMMENT '系统code',
  `f_sys_add_time` datetime DEFAULT NULL COMMENT '新增时间',
  `f_sys_upd_time` datetime DEFAULT NULL COMMENT '修改时间',
  `f_sys_del_time` datetime DEFAULT NULL COMMENT '删除时间',
  `f_sys_add_user` bigint(32) DEFAULT NULL COMMENT '新增人',
  `f_sys_upd_user` bigint(32) DEFAULT NULL COMMENT '修改人',
  `f_sys_del_user` bigint(32) DEFAULT NULL COMMENT '删除人',
  `f_sys_del_state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除状态',
  PRIMARY KEY (`f_id`),
  KEY `fk_loginLog_userId` (`f_user_id`),
  CONSTRAINT `fk_loginLog_userId` FOREIGN KEY (`f_user_id`) REFERENCES `t_user` (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='登录日志表';


DROP TABLE IF EXISTS `t_login_no`;
CREATE TABLE IF NOT EXISTS `t_login_no` (
  `f_id` bigint(32) NOT NULL COMMENT 'id',
  `f_user_id` bigint(32) NOT NULL COMMENT 'userId',
  `f_user_account` varchar(100) NOT NULL COMMENT '登录账号',
  `f_user_pwd` varchar(100) NOT NULL COMMENT '登录密码',
  `f_type` tinyint(4) NOT NULL COMMENT '登录类型，1手机号，2微信小程序，3微博，4账号OOS',
  `f_wechat_union_id` VARCHAR(100) NULL DEFAULT NULL COMMENT '微信unionId',
  `f_sys_add_time` datetime DEFAULT NULL COMMENT '新增时间',
  `f_sys_upd_time` datetime DEFAULT NULL COMMENT '修改时间',
  `f_sys_del_time` datetime DEFAULT NULL COMMENT '删除时间',
  `f_sys_add_user` bigint(32) DEFAULT NULL COMMENT '新增人',
  `f_sys_upd_user` bigint(32) DEFAULT NULL COMMENT '修改人',
  `f_sys_del_user` bigint(32) DEFAULT NULL COMMENT '删除人',
  `f_sys_del_state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除状态',
  PRIMARY KEY (`f_id`),
  KEY `fk_loginNo_userId` (`f_user_id`),
  CONSTRAINT `fk_loginNo_userId` FOREIGN KEY (`f_user_id`) REFERENCES `t_user` (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='登录账号表';


DROP TABLE IF EXISTS `t_role_resource`;
DROP TABLE IF EXISTS `t_role_resource`;
CREATE TABLE IF NOT EXISTS `t_role_resource` (
  `f_id` bigint(32) NOT NULL COMMENT '角色资源ID',
  `f_role_id` bigint(32) NOT NULL COMMENT 'roleId',
  `f_resource_url_id` bigint(100) NOT NULL COMMENT '资源ID',
  `f_sys_add_time` datetime DEFAULT NULL COMMENT '新增时间',
  `f_sys_upd_time` datetime DEFAULT NULL COMMENT '修改时间',
  `f_sys_del_time` datetime DEFAULT NULL COMMENT '删除时间',
  `f_sys_add_user` bigint(32) DEFAULT NULL COMMENT '新增人',
  `f_sys_upd_user` bigint(32) DEFAULT NULL COMMENT '修改人',
  `f_sys_del_user` bigint(32) DEFAULT NULL COMMENT '删除人',
  `f_sys_del_state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除状态',
  PRIMARY KEY (`f_id`),
  KEY `fk_roleResource_roleId` (`f_role_id`),
  KEY `fk_roleResource_resourceId` (`f_resource_url_id`),
  CONSTRAINT `fk_roleResource_resourceId` FOREIGN KEY (`f_resource_url_id`) REFERENCES `t_resource_url` (`f_id`),
  CONSTRAINT `fk_roleResource_roleId` FOREIGN KEY (`f_role_id`) REFERENCES `t_role` (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色资源表';

DROP TABLE IF EXISTS `t_user_role`;
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE IF NOT EXISTS `t_user_role` (
  `f_id` bigint(32) NOT NULL COMMENT 'ID',
  `f_user_id` bigint(100) NOT NULL COMMENT 'userId',
  `f_role_id` bigint(32) NOT NULL COMMENT 'roleId',
  `f_sys_add_time` datetime DEFAULT NULL COMMENT '新增时间',
  `f_sys_upd_time` datetime DEFAULT NULL COMMENT '修改时间',
  `f_sys_del_time` datetime DEFAULT NULL COMMENT '删除时间',
  `f_sys_add_user` bigint(32) DEFAULT NULL COMMENT '新增人',
  `f_sys_upd_user` bigint(32) DEFAULT NULL COMMENT '修改人',
  `f_sys_del_user` bigint(32) DEFAULT NULL COMMENT '删除人',
  `f_sys_del_state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除状态',
  PRIMARY KEY (`f_id`),
  KEY `fk_userRole_userId` (`f_user_id`),
  KEY `fk_userRole_roleId` (`f_role_id`),
  CONSTRAINT `fk_userRole_roleId` FOREIGN KEY (`f_role_id`) REFERENCES `t_role` (`f_id`),
  CONSTRAINT `fk_userRole_userId` FOREIGN KEY (`f_user_id`) REFERENCES `t_user` (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

INSERT INTO `t_user` (`f_id`, `f_user_name`, `f_real_name`, `f_id_card`, `f_pay_pwd`, `f_mobile`, `f_state`, `f_last_pwdmod_time`, `f_device_id`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (1, 'admin', '管理员', NULL, NULL, '17688709202', 1, NULL, NULL, '2017-04-16 15:52:40', NULL, NULL, NULL, NULL, NULL, 0);

INSERT INTO `t_login_no` (`f_id`, `f_user_id`, `f_user_account`, `f_user_pwd`, `f_type`, `f_wechat_union_id`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (1, 1, 'kangduo', '$2a$10$MNADoB/kM4CfrMri/Cp8O.OT5aNx3f8HkNodosYQUNBIIg3WmN.fC', 4, NULL, '2017-04-19 21:01:59', NULL, NULL, NULL, NULL, NULL, 0);


INSERT INTO `t_role` (`f_id`, `f_role_name`, `f_role_code`, `f_role_desc`, `f_system_code`, `f_role_state`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (1, '普通用户', 'ROLE_USER', '普通用户', 'OOS', 1, '2017-04-16 21:42:35', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_role` (`f_id`, `f_role_name`, `f_role_code`, `f_role_desc`, `f_system_code`, `f_role_state`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (2, '管理员', 'ROLE_ADMIN', '管理员', 'OOS', 1, '2017-04-16 15:52:01', NULL, NULL, NULL, NULL, NULL, 0);

INSERT INTO `t_resource_url` (`f_id`, `f_url`, `f_url_desc`, `f_parent_id`, `f_is_menu`, `f_level`, `f_system_code`, `f_need_csrf`, `f_order`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (1, '#', '菜单1', '0', 1, 1, 'OOS', 0, 4, '2017-04-19 20:17:33', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_resource_url` (`f_id`, `f_url`, `f_url_desc`, `f_parent_id`, `f_is_menu`, `f_level`, `f_system_code`, `f_need_csrf`, `f_order`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (2, '#', '菜单2', 1, 1, 2, 'OOS', 0, 0, '2017-04-19 20:17:50', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_resource_url` (`f_id`, `f_url`, `f_url_desc`, `f_parent_id`, `f_is_menu`, `f_level`, `f_system_code`, `f_need_csrf`, `f_order`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (3, '#', '菜单3', 1, 1, 2, 'OOS', 0, 0, '2017-04-19 20:17:50', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_resource_url` (`f_id`, `f_url`, `f_url_desc`, `f_parent_id`, `f_is_menu`, `f_level`, `f_system_code`, `f_need_csrf`, `f_order`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (4, '#', '菜单4', 1, 1, 2, 'OOS', 0, 0, '2017-04-19 20:17:50', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_resource_url` (`f_id`, `f_url`, `f_url_desc`, `f_parent_id`, `f_is_menu`, `f_level`, `f_system_code`, `f_need_csrf`, `f_order`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (5, '#', '菜单5', '0', 1, 1, 'OOS', 0, 3, '2017-04-19 20:19:15', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_resource_url` (`f_id`, `f_url`, `f_url_desc`, `f_parent_id`, `f_is_menu`, `f_level`, `f_system_code`, `f_need_csrf`, `f_order`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (6, '#', '菜单6', '0', 1, 1, 'OOS', 0, 6, '2017-04-19 20:05:09', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_resource_url` (`f_id`, `f_url`, `f_url_desc`, `f_parent_id`, `f_is_menu`, `f_level`, `f_system_code`, `f_need_csrf`, `f_order`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (7, '#', '菜单7', 5, 1, 2, 'OOS', 0, 0, '2017-04-19 20:19:34', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_resource_url` (`f_id`, `f_url`, `f_url_desc`, `f_parent_id`, `f_is_menu`, `f_level`, `f_system_code`, `f_need_csrf`, `f_order`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (8, '#', '菜单8', 5, 1, 2, 'OOS', 0, 0, '2017-04-19 20:19:34', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_resource_url` (`f_id`, `f_url`, `f_url_desc`, `f_parent_id`, `f_is_menu`, `f_level`, `f_system_code`, `f_need_csrf`, `f_order`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (9, '#', '菜单9', 5, 1, 2, 'OOS', 0, 0, '2017-04-19 20:19:34', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_resource_url` (`f_id`, `f_url`, `f_url_desc`, `f_parent_id`, `f_is_menu`, `f_level`, `f_system_code`, `f_need_csrf`, `f_order`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (10, '#', '菜单10', 5, 1, 2, 'OOS', 0, 0, '2017-04-19 20:19:34', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_resource_url` (`f_id`, `f_url`, `f_url_desc`, `f_parent_id`, `f_is_menu`, `f_level`, `f_system_code`, `f_need_csrf`, `f_order`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (11, '#', '菜单11', 5, 1, 2, 'OOS', 0, 0, '2017-04-19 20:19:34', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_resource_url` (`f_id`, `f_url`, `f_url_desc`, `f_parent_id`, `f_is_menu`, `f_level`, `f_system_code`, `f_need_csrf`, `f_order`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (13, '#', '菜单12', '0', 1, 1, 'OOS', 0, 2, '2017-04-19 20:20:30', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_resource_url` (`f_id`, `f_url`, `f_url_desc`, `f_parent_id`, `f_is_menu`, `f_level`, `f_system_code`, `f_need_csrf`, `f_order`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (15, '#', '菜单13', 13, 1, 2, 'OOS', 0, 0, '2017-04-19 20:20:45', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_resource_url` (`f_id`, `f_url`, `f_url_desc`, `f_parent_id`, `f_is_menu`, `f_level`, `f_system_code`, `f_need_csrf`, `f_order`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (16, '#', '菜单13', 13, 1, 2, 'OOS', 0, 0, '2017-04-19 20:20:45', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_resource_url` (`f_id`, `f_url`, `f_url_desc`, `f_parent_id`, `f_is_menu`, `f_level`, `f_system_code`, `f_need_csrf`, `f_order`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (17, '#', '菜单15', 13, 1, 2, 'OOS', 0, 0, '2017-04-19 20:20:45', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_resource_url` (`f_id`, `f_url`, `f_url_desc`, `f_parent_id`, `f_is_menu`, `f_level`, `f_system_code`, `f_need_csrf`, `f_order`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (18, '#', '菜单16', 13, 1, 2, 'OOS', 0, 0, '2017-04-19 20:20:45', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_resource_url` (`f_id`, `f_url`, `f_url_desc`, `f_parent_id`, `f_is_menu`, `f_level`, `f_system_code`, `f_need_csrf`, `f_order`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (19, '#', '菜单17', 13, 1, 2, 'OOS', 0, 0, '2017-04-19 20:20:46', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_resource_url` (`f_id`, `f_url`, `f_url_desc`, `f_parent_id`, `f_is_menu`, `f_level`, `f_system_code`, `f_need_csrf`, `f_order`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (20, '#', '菜单18', '0', 1, 1, 'OOS', 0, 1, '2017-04-19 20:21:27', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_resource_url` (`f_id`, `f_url`, `f_url_desc`, `f_parent_id`, `f_is_menu`, `f_level`, `f_system_code`, `f_need_csrf`, `f_order`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (21, '#', '菜单19', 20, 1, 2, 'OOS', 0, 0, '2017-04-19 20:21:44', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_resource_url` (`f_id`, `f_url`, `f_url_desc`, `f_parent_id`, `f_is_menu`, `f_level`, `f_system_code`, `f_need_csrf`, `f_order`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (22, '#', '菜单20', 20, 1, 2, 'OOS', 0, 0, '2017-04-19 20:21:44', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_resource_url` (`f_id`, `f_url`, `f_url_desc`, `f_parent_id`, `f_is_menu`, `f_level`, `f_system_code`, `f_need_csrf`, `f_order`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (23, '#', '菜单21', 6, 1, 2, 'OOS', 0, 0, '2017-04-19 20:07:31', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_resource_url` (`f_id`, `f_url`, `f_url_desc`, `f_parent_id`, `f_is_menu`, `f_level`, `f_system_code`, `f_need_csrf`, `f_order`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (24, '#', '菜单22', 6, 1, 2, 'OOS', 0, 0, '2017-04-19 20:07:34', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_resource_url` (`f_id`, `f_url`, `f_url_desc`, `f_parent_id`, `f_is_menu`, `f_level`, `f_system_code`, `f_need_csrf`, `f_order`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (25, '#', '菜单23', '0', 1, 1, 'OOS', 0, 5, '2017-04-19 20:08:01', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_resource_url` (`f_id`, `f_url`, `f_url_desc`, `f_parent_id`, `f_is_menu`, `f_level`, `f_system_code`, `f_need_csrf`, `f_order`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (26, '#', '菜单24', 25, 1, 2, 'OOS', 0, 0, '2017-04-19 20:16:12', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_resource_url` (`f_id`, `f_url`, `f_url_desc`, `f_parent_id`, `f_is_menu`, `f_level`, `f_system_code`, `f_need_csrf`, `f_order`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (27, '#', '菜单25', 25, 1, 2, 'OOS', 0, 0, '2017-04-19 20:16:12', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_resource_url` (`f_id`, `f_url`, `f_url_desc`, `f_parent_id`, `f_is_menu`, `f_level`, `f_system_code`, `f_need_csrf`, `f_order`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (28, '#', '菜单26', 25, 1, 2, 'OOS', 0, 0, '2017-04-19 20:16:12', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_resource_url` (`f_id`, `f_url`, `f_url_desc`, `f_parent_id`, `f_is_menu`, `f_level`, `f_system_code`, `f_need_csrf`, `f_order`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (29, '#', '菜单27', 25, 1, 2, 'OOS', 0, 0, '2017-04-19 20:16:12', NULL, NULL, NULL, NULL, NULL, 0);

INSERT INTO `t_role_resource` (`f_id`, `f_role_id`, `f_resource_url_id`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (1, 2, 1, '2017-04-19 21:33:28', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_role_resource` (`f_id`, `f_role_id`, `f_resource_url_id`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (2, 2, 2, '2017-04-19 21:33:28', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_role_resource` (`f_id`, `f_role_id`, `f_resource_url_id`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (3, 2, 3, '2017-04-19 21:33:28', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_role_resource` (`f_id`, `f_role_id`, `f_resource_url_id`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (4, 2, 4, '2017-04-19 21:33:28', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_role_resource` (`f_id`, `f_role_id`, `f_resource_url_id`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (5, 2, 5, '2017-04-19 21:33:28', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_role_resource` (`f_id`, `f_role_id`, `f_resource_url_id`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (6, 2, 6, '2017-04-19 21:33:28', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_role_resource` (`f_id`, `f_role_id`, `f_resource_url_id`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (7, 2, 7, '2017-04-19 21:33:28', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_role_resource` (`f_id`, `f_role_id`, `f_resource_url_id`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (8, 2, 8, '2017-04-19 21:33:28', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_role_resource` (`f_id`, `f_role_id`, `f_resource_url_id`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (9, 2, 9, '2017-04-19 21:33:28', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_role_resource` (`f_id`, `f_role_id`, `f_resource_url_id`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (10, 2, 10, '2017-04-19 21:33:28', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_role_resource` (`f_id`, `f_role_id`, `f_resource_url_id`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (11, 2, 11, '2017-04-19 21:33:28', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_role_resource` (`f_id`, `f_role_id`, `f_resource_url_id`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (13, 2, 13, '2017-04-19 21:33:28', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_role_resource` (`f_id`, `f_role_id`, `f_resource_url_id`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (15, 2, 15, '2017-04-19 21:33:28', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_role_resource` (`f_id`, `f_role_id`, `f_resource_url_id`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (16, 2, 16, '2017-04-19 21:33:28', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_role_resource` (`f_id`, `f_role_id`, `f_resource_url_id`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (17, 2, 17, '2017-04-19 21:33:28', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_role_resource` (`f_id`, `f_role_id`, `f_resource_url_id`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (18, 2, 18, '2017-04-19 21:33:28', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_role_resource` (`f_id`, `f_role_id`, `f_resource_url_id`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (19, 2, 19, '2017-04-19 21:33:28', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_role_resource` (`f_id`, `f_role_id`, `f_resource_url_id`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (20, 2, 20, '2017-04-19 21:33:28', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_role_resource` (`f_id`, `f_role_id`, `f_resource_url_id`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (21, 2, 21, '2017-04-19 21:33:28', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_role_resource` (`f_id`, `f_role_id`, `f_resource_url_id`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (22, 2, 22, '2017-04-19 21:33:28', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_role_resource` (`f_id`, `f_role_id`, `f_resource_url_id`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (23, 2, 23, '2017-04-19 21:33:28', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_role_resource` (`f_id`, `f_role_id`, `f_resource_url_id`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (24, 2, 24, '2017-04-19 21:33:28', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_role_resource` (`f_id`, `f_role_id`, `f_resource_url_id`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (25, 2, 25, '2017-04-19 21:33:28', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_role_resource` (`f_id`, `f_role_id`, `f_resource_url_id`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (26, 2, 26, '2017-04-19 21:33:28', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_role_resource` (`f_id`, `f_role_id`, `f_resource_url_id`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (27, 2, 27, '2017-04-19 21:33:28', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_role_resource` (`f_id`, `f_role_id`, `f_resource_url_id`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (28, 2, 28, '2017-04-19 21:33:28', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_role_resource` (`f_id`, `f_role_id`, `f_resource_url_id`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (29, 2, 29, '2017-04-19 21:33:28', NULL, NULL, NULL, NULL, NULL, 0);

INSERT INTO `t_user_role` (`f_id`, `f_user_id`, `f_role_id`, `f_sys_add_time`, `f_sys_upd_time`, `f_sys_del_time`, `f_sys_add_user`, `f_sys_upd_user`, `f_sys_del_user`, `f_sys_del_state`) VALUES (1, 1, 2, '2017-04-19 21:03:48', NULL, NULL, NULL, NULL, NULL, 0);


#以下部分为日志记录库，请单独建一个库
CREATE TABLE `t_comm_logger` (
	`f_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`f_user_id` BIGINT(32) NULL DEFAULT NULL COMMENT '用户Id',
	`f_user_acc_no` VARCHAR(100) NULL DEFAULT NULL COMMENT '登录账号',
	`f_user_acc_type` TINYINT(4) NULL DEFAULT NULL COMMENT '登录账号类型',
	`f_action_url_tail` VARCHAR(100) NULL DEFAULT NULL COMMENT '请求的action',
	`f_action_url_all` VARCHAR(500) NULL DEFAULT NULL COMMENT '请求的action全路径',
	`f_request_params` MEDIUMTEXT NULL COMMENT '请求的参数信息',
	`f_action_res_code` VARCHAR(100) NULL DEFAULT NULL COMMENT '返回结果码',
	`f_is_undefined_exception` TINYINT(1) NULL DEFAULT NULL COMMENT '是否为未处理的异常=={"1":"是","0":"否"}',
	`f_excep_stack_info` MEDIUMTEXT NULL COMMENT '异常堆栈信息',
	`f_ip` VARCHAR(64) NULL DEFAULT NULL COMMENT '客户IP地址',
	`f_device_id` VARCHAR(500) NULL DEFAULT NULL COMMENT '设备Id',
	`f_os` VARCHAR(1000) NULL DEFAULT NULL COMMENT '操作系统相关信息',
	`f_os_version` VARCHAR(45) NULL DEFAULT NULL COMMENT '操作系统版本',
	`f_req_start_time` DATETIME NOT NULL COMMENT '请求发起时间',
	`f_req_deal_time` INT(11) NULL DEFAULT NULL COMMENT '请求处理时间,毫秒',
	`f_req_end_time` DATETIME NULL DEFAULT NULL COMMENT '请求结束时间',
	`f_response_data` MEDIUMTEXT NULL COMMENT '返回结果数据',
	`f_sys_add_time` DATETIME NULL DEFAULT NULL COMMENT '新增时间',
	`f_sys_upd_time` DATETIME NULL DEFAULT NULL COMMENT '更新时间',
	`f_sys_del_time` DATETIME NULL DEFAULT NULL COMMENT '删除时间',
	`f_sys_add_user` BIGINT(32) NULL DEFAULT NULL COMMENT '新增者',
	`f_sys_upd_user` BIGINT(32) NULL DEFAULT NULL COMMENT '修改者',
	`f_sys_del_user` BIGINT(32) NULL DEFAULT NULL COMMENT '删除者',
	`f_sys_del_state` TINYINT(1) NOT NULL DEFAULT '0' COMMENT '记录状态=={"0":"正常","1":"已删除"}',
	PRIMARY KEY (`f_id`, `f_req_start_time`)
)
COMMENT='公共日志记录表'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=1514
;

CREATE TABLE `t_oos_logger` (
	`f_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`f_user_id` BIGINT(32) NULL DEFAULT NULL COMMENT '用户Id',
	`f_user_acc_no` VARCHAR(100) NULL DEFAULT NULL COMMENT '登录账号',
	`f_user_acc_type` TINYINT(4) NULL DEFAULT NULL COMMENT '登录账号类型',
	`f_action_url_tail` VARCHAR(100) NULL DEFAULT NULL COMMENT '请求的action',
	`f_action_url_all` VARCHAR(500) NULL DEFAULT NULL COMMENT '请求的action全路径',
	`f_request_params` MEDIUMTEXT NULL COMMENT '请求的参数信息',
	`f_action_res_code` VARCHAR(100) NULL DEFAULT NULL COMMENT '返回结果码',
	`f_is_undefined_exception` TINYINT(1) NULL DEFAULT NULL COMMENT '是否为未处理的异常=={"1":"是","0":"否"}',
	`f_excep_stack_info` MEDIUMTEXT NULL COMMENT '异常堆栈信息',
	`f_ip` VARCHAR(64) NULL DEFAULT NULL COMMENT '客户IP地址',
	`f_device_id` VARCHAR(500) NULL DEFAULT NULL COMMENT '设备Id',
	`f_os` VARCHAR(1000) NULL DEFAULT NULL COMMENT '操作系统相关信息',
	`f_os_version` VARCHAR(45) NULL DEFAULT NULL COMMENT '操作系统版本',
	`f_req_start_time` DATETIME NOT NULL COMMENT '请求发起时间',
	`f_req_deal_time` INT(11) NULL DEFAULT NULL COMMENT '请求处理时间,毫秒',
	`f_req_end_time` DATETIME NULL DEFAULT NULL COMMENT '请求结束时间',
	`f_response_data` MEDIUMTEXT NULL COMMENT '返回结果数据',
	`f_sys_add_time` DATETIME NULL DEFAULT NULL COMMENT '新增时间',
	`f_sys_upd_time` DATETIME NULL DEFAULT NULL COMMENT '更新时间',
	`f_sys_del_time` DATETIME NULL DEFAULT NULL COMMENT '删除时间',
	`f_sys_add_user` BIGINT(32) NULL DEFAULT NULL COMMENT '新增者',
	`f_sys_upd_user` BIGINT(32) NULL DEFAULT NULL COMMENT '修改者',
	`f_sys_del_user` BIGINT(32) NULL DEFAULT NULL COMMENT '删除者',
	`f_sys_del_state` TINYINT(1) NOT NULL DEFAULT '0' COMMENT '记录状态=={"0":"正常","1":"已删除"}',
	PRIMARY KEY (`f_id`, `f_req_start_time`)
)
COMMENT='公共日志记录表'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=1514
;


