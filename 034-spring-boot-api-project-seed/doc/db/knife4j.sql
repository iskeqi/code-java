/*
 Navicat Premium Data Transfer

 Source Server         : 120.25.26.123
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : 120.25.26.123:3306
 Source Schema         : knife4j

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 20/01/2021 21:03:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_account
-- ----------------------------
DROP TABLE IF EXISTS `sys_account`;
CREATE TABLE `sys_account`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `account` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `nick_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `post` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '岗位',
  `password` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '盐',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_account
-- ----------------------------
INSERT INTO `sys_account` VALUES (1, 'admin', '系统管理员', 'post:manager', '262c72308d35e4fdd32c27330efaaa0f3592ef6ee092c3027bf162aac28a2b90', 'yss17vhtbx7jzd3uvd1q', '2020-12-02 20:15:58', '2020-12-02 20:16:01');
INSERT INTO `sys_account` VALUES (6, 'jack', '杰克', NULL, 'e72559c512fd35eb4d02026a8d828c1f4155313a886049a01abb768b0f5badc8', 'f91wzbhmhbh5jtdyfbbl', '2021-01-19 21:23:40', NULL);

-- ----------------------------
-- Table structure for sys_account_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_account_role`;
CREATE TABLE `sys_account_role`  (
  `account_id` bigint NOT NULL COMMENT '用户id',
  `role_id` bigint NOT NULL COMMENT '角色id',
  PRIMARY KEY (`account_id`, `role_id`) USING BTREE,
  INDEX `FK_Reference_2`(`role_id`) USING BTREE,
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`account_id`) REFERENCES `sys_account` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户-角色关联表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_account_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `parent_id` bigint NULL DEFAULT 0 COMMENT '父部门id',
  `ancestors` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '部门名称',
  `order_num` int NULL DEFAULT 0 COMMENT '显示顺序',
  `leader` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 200 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (201, 0, '', '', 0, '', '', '', '', '', '', '2021-01-20 14:16:09', '', '2021-01-20 14:16:09');
INSERT INTO `sys_dept` VALUES (202, 0, '', '', 0, '', '', '', '', '', '', '2021-01-20 14:16:09', '', '2021-01-20 14:16:09');
INSERT INTO `sys_dept` VALUES (203, 0, '', '', 0, '', '', '', '', '', '', '2021-01-20 14:16:10', '', '2021-01-20 14:16:10');
INSERT INTO `sys_dept` VALUES (204, 0, '', '', 0, '', '', '', '', '', '', '2021-01-20 14:16:10', '', '2021-01-20 14:16:10');
INSERT INTO `sys_dept` VALUES (205, 0, '', '', 0, '', '', '', '', '', '', '2021-01-20 14:16:10', '', '2021-01-20 14:16:10');
INSERT INTO `sys_dept` VALUES (206, 0, '', '', 0, '', '', '', '', '', '', '2021-01-20 14:16:11', '', '2021-01-20 14:16:11');
INSERT INTO `sys_dept` VALUES (207, 0, '', '', 0, '', '', '', '', '', '', '2021-01-20 14:16:11', '', '2021-01-20 14:16:11');
INSERT INTO `sys_dept` VALUES (208, 0, '', '', 0, '', '', '', '', '', '', '2021-01-20 14:16:11', '', '2021-01-20 14:16:11');
INSERT INTO `sys_dept` VALUES (209, 0, '', '', 0, '', '', '', '', '', '', '2021-01-20 14:16:11', '', '2021-01-20 14:16:11');
INSERT INTO `sys_dept` VALUES (210, 0, '', '', 0, '', '', '', '', '', '', '2021-01-20 14:16:11', '', '2021-01-20 14:16:11');
INSERT INTO `sys_dept` VALUES (211, 0, '', '', 0, '', '', '', '', '', '', '2021-01-20 14:16:12', '', '2021-01-20 14:16:12');
INSERT INTO `sys_dept` VALUES (212, 0, '', '', 0, '', '', '', '', '', '', '2021-01-20 14:16:12', '', '2021-01-20 14:16:12');
INSERT INTO `sys_dept` VALUES (213, 0, '', '', 0, '', '', '', '', '', '', '2021-01-20 14:16:12', '', '2021-01-20 14:16:12');
INSERT INTO `sys_dept` VALUES (214, 0, '', '', 0, '', '', '', '', '', '', '2021-01-20 14:16:12', '', '2021-01-20 14:16:12');
INSERT INTO `sys_dept` VALUES (215, 0, '', '', 0, '', '', '', '', '', '', '2021-01-20 14:16:12', '', '2021-01-20 14:16:12');
INSERT INTO `sys_dept` VALUES (216, 0, '', '', 0, '', '', '', '', '', '', '2021-01-20 14:16:12', '', '2021-01-20 14:16:12');
INSERT INTO `sys_dept` VALUES (217, 0, '', '', 0, '', '', '', '', '', '', '2021-01-20 14:16:13', '', '2021-01-20 14:16:13');
INSERT INTO `sys_dept` VALUES (218, 0, '', '', 0, '', '', '', '', '', '', '2021-01-20 14:16:13', '', '2021-01-20 14:16:13');
INSERT INTO `sys_dept` VALUES (219, 0, '', '', 0, '', '', '', '', '', '', '2021-01-20 14:16:13', '', '2021-01-20 14:16:13');
INSERT INTO `sys_dept` VALUES (220, 0, '', '', 0, '', '', '', '', '', '', '2021-01-20 14:16:13', '', '2021-01-20 14:16:13');
INSERT INTO `sys_dept` VALUES (221, 0, '', '', 0, '', '', '', '', '', '', '2021-01-20 14:16:13', '', '2021-01-20 14:16:13');
INSERT INTO `sys_dept` VALUES (222, 0, '', '', 0, '', '', '', '', '', '', '2021-01-20 14:16:13', '', '2021-01-20 14:16:13');
INSERT INTO `sys_dept` VALUES (223, 0, '', '', 0, '', '', '', '', '', '', '2021-01-20 14:16:14', '', '2021-01-20 14:16:14');
INSERT INTO `sys_dept` VALUES (224, 0, '', '', 0, '', '', '', '', '', '', '2021-01-20 14:16:14', '', '2021-01-20 14:16:14');
INSERT INTO `sys_dept` VALUES (225, 0, '', '', 0, '', '', '', '', '', '', '2021-01-20 14:16:14', '', '2021-01-20 14:16:14');

-- ----------------------------
-- Table structure for sys_dict_item
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_item`;
CREATE TABLE `sys_dict_item`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '字典项id',
  `type_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典类型编码',
  `type_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典类型名称',
  `item_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典项编码',
  `item_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典项值',
  `order_num` int NULL DEFAULT NULL COMMENT '排序字段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '字典表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_dict_item
-- ----------------------------
INSERT INTO `sys_dict_item` VALUES (1, 'configType', '参数配置类型', 'configType:xtnz', '系统内置', 1);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
  `url` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求URL地址',
  `icon` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'ICON图标',
  `type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单类型（C目录 M菜单 B按钮）',
  `permiss` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限标识',
  `parent_id` bigint NULL DEFAULT NULL COMMENT '父级ID',
  `order_num` int NULL DEFAULT NULL COMMENT '排序字段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单权限表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '操作日志记录id',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作名称',
  `method` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '方法名称（对应 Controller 方法名称）',
  `type` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求方式（GET、POST）',
  `url` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求URL',
  `ip` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求IP地址',
  `content_type` char(33) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求参数类型',
  `param` json NULL COMMENT '请求参数（表单参数也转成 JSON 格式保存）',
  `result` json NULL COMMENT '返回参数',
  `success` tinyint NULL DEFAULT NULL COMMENT '是否操作成功（0 成功，1 失败）',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '操作日志记录表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_oper_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_param_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_param_config`;
CREATE TABLE `sys_param_config`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '参数配置id',
  `param_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
  `param_key` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '键名',
  `param_value` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '键值',
  `param_type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型（dictType：configType）',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '参数配置表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_param_config
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `role_id` bigint NOT NULL COMMENT '角色id',
  `menu_id` bigint NOT NULL COMMENT '菜单id',
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE,
  INDEX `FK_Reference_4`(`menu_id`) USING BTREE,
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`menu_id`) REFERENCES `sys_menu` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色-权限关联表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_upload_file
-- ----------------------------
DROP TABLE IF EXISTS `sys_upload_file`;
CREATE TABLE `sys_upload_file`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '文件id',
  `name` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件名称',
  `path` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件存储路径（相对路径）',
  `type` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件类型',
  `size` bigint NULL DEFAULT NULL COMMENT '文件大小（单位：字节）',
  `deleted` tinyint NULL DEFAULT NULL COMMENT '是否删除（0 未删除，1 已删除）',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文件表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_upload_file
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
