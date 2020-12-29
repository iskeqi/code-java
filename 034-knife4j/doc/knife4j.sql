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

 Date: 29/12/2020 15:00:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_account
-- ----------------------------
DROP TABLE IF EXISTS `sys_account`;
CREATE TABLE `sys_account`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `account` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `nick_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `post` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '岗位',
  `password` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_account`(`account`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_account
-- ----------------------------
INSERT INTO `sys_account` VALUES (1, 'admin', '系统管理员', 'manager', '7c705886f552f568826c12bb53b326c5594be799a9e64296ff59002275734449', '2020-12-02 20:15:58', '2020-12-02 20:16:01');

-- ----------------------------
-- Table structure for sys_dict_item
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_item`;
CREATE TABLE `sys_dict_item`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '字典记录主键',
  `type_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典类型编码',
  `type_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典类型名称',
  `item_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典项编码',
  `item_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典项值',
  `item_sort` int UNSIGNED NULL DEFAULT NULL COMMENT '字典项排序',
  `item_remark` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典项备注字段',
  `item_css` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典项样式属性(备用字段)',
  `is_deleted` tinyint UNSIGNED NULL DEFAULT 0 COMMENT '逻辑删除字段（0 未删除，1 已删除）',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_item_code`(`item_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统管理-字典表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_dict_item
-- ----------------------------
INSERT INTO `sys_dict_item` VALUES (5, 'post', '岗位', 'java', 'Java后端开发工程师', 1, NULL, NULL, 0, '2020-12-04 10:49:30', '2020-12-04 10:49:30');
INSERT INTO `sys_dict_item` VALUES (6, 'post', '岗位', 'web', 'Web前端开发工程师', 2, NULL, NULL, 0, '2020-12-04 10:49:30', '2020-12-04 10:49:30');
INSERT INTO `sys_dict_item` VALUES (7, 'post', '岗位', 'product', '产品经理', 3, NULL, NULL, 0, '2020-12-04 10:49:30', '2020-12-04 10:49:30');
INSERT INTO `sys_dict_item` VALUES (8, 'post', '岗位', 'ios', 'IOS开发工程师', 4, NULL, NULL, 0, '2020-12-04 10:49:30', '2020-12-04 10:49:30');
INSERT INTO `sys_dict_item` VALUES (9, 'post', '岗位', 'android', 'android开发工程师', 5, NULL, NULL, 0, '2020-12-04 10:49:30', '2020-12-04 10:49:30');
INSERT INTO `sys_dict_item` VALUES (10, 'gender', '性别', 'man', '男', 1, NULL, NULL, 0, '2020-12-04 10:49:30', '2020-12-04 11:35:44');
INSERT INTO `sys_dict_item` VALUES (11, 'gender', '性别', 'women', '女', 2, NULL, NULL, 0, '2020-12-04 10:49:30', '2020-12-04 10:49:30');
INSERT INTO `sys_dict_item` VALUES (12, 'gender', '性别', 'unknown', '未知', 3, NULL, NULL, 0, '2020-12-04 10:49:30', '2020-12-04 10:49:30');
INSERT INTO `sys_dict_item` VALUES (14, 'post', '岗位', 'manger', '系统管理员', 6, NULL, NULL, 0, '2020-12-24 17:22:03', '2020-12-24 17:22:03');

-- ----------------------------
-- Table structure for sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作名称',
  `method` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '方法名称（对应 Controller 方法名称）',
  `type` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求方式（GET、POST）',
  `url` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求URL',
  `ip` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求IP地址',
  `content_type` char(33) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求参数类型',
  `param` json NULL COMMENT '请求参数（表单参数也转成 JSON 格式保存）',
  `result` json NULL COMMENT '返回参数',
  `is_success` tinyint NULL DEFAULT 0 COMMENT '是否操作成功（0 成功，1 失败）',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人员',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '操作日志记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_oper_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_upload_file
-- ----------------------------
DROP TABLE IF EXISTS `sys_upload_file`;
CREATE TABLE `sys_upload_file`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '文件ID',
  `name` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件名称',
  `path` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件存储路径（相对路径）',
  `type` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件类型',
  `size` bigint UNSIGNED NULL DEFAULT NULL COMMENT '文件大小（单位：字节）',
  `is_deleted` tinyint UNSIGNED NULL DEFAULT 0 COMMENT '逻辑删除字段（0 未删除，1 已删除）',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文件表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_upload_file
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
