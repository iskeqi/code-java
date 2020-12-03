/*
 Navicat Premium Data Transfer

 Source Server         : 120.25.26.123
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : 120.25.26.123:3306
 Source Schema         : best-practice-one

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 03/12/2020 11:09:05
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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_account
-- ----------------------------
INSERT INTO `sys_account` VALUES (11, 'admin', '系统管理员', '管理员', '7c705886f552f568826c12bb53b326c5594be799a9e64296ff59002275734449', '2020-12-02 20:15:58', '2020-12-02 20:16:01');

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
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_item_code`(`item_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统管理-字典表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_dict_item
-- ----------------------------
INSERT INTO `sys_dict_item` VALUES (5, 'post', '岗位', 'Java', 'Java后端开发工程师', 1, NULL, NULL, 0);
INSERT INTO `sys_dict_item` VALUES (6, 'post', '岗位', 'Web', 'Web前端开发工程师', 2, NULL, NULL, 0);
INSERT INTO `sys_dict_item` VALUES (7, 'post', '岗位', 'Product', '产品经理', 3, NULL, NULL, 0);
INSERT INTO `sys_dict_item` VALUES (8, 'post', '岗位', 'IOS', 'IOS开发工程师', 4, NULL, NULL, 0);
INSERT INTO `sys_dict_item` VALUES (9, 'post', '岗位', 'android', 'android开发工程师', 5, NULL, NULL, 0);
INSERT INTO `sys_dict_item` VALUES (10, 'gender', '性别', 'man', '男', 1, NULL, NULL, 0);
INSERT INTO `sys_dict_item` VALUES (11, 'gender', '性别', 'women', '女', 2, NULL, NULL, 0);
INSERT INTO `sys_dict_item` VALUES (12, 'gender', '性别', 'unknown', '未知', 3, NULL, NULL, 0);

-- ----------------------------
-- Table structure for sys_upload_file
-- ----------------------------
DROP TABLE IF EXISTS `sys_upload_file`;
CREATE TABLE `sys_upload_file`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '文件ID',
  `name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件名称',
  `path` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件存储路径（相对路径）',
  `type` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件类型',
  `size` int UNSIGNED NULL DEFAULT NULL COMMENT '文件大小（单位：字节）',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `is_deleted` tinyint UNSIGNED NULL DEFAULT 0 COMMENT '逻辑删除字段（0 未删除，1 已删除）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文件表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_upload_file
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
