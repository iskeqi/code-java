/*
 Navicat Premium Data Transfer

 Source Server         : aliyun_mysql
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : rm-bp1f65ehm719kd63y5o.mysql.rds.aliyuncs.com:3306
 Source Schema         : project-seed-4

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 25/08/2021 11:58:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_account
-- ----------------------------
DROP TABLE IF EXISTS `sys_account`;
CREATE TABLE `sys_account`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '用户id',
  `account` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `nick_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `post` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '岗位',
  `password` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '盐',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_account
-- ----------------------------
INSERT INTO `sys_account` VALUES (1423547911798464514, 'user2', '用户2', 'java', '123456', 'dafdsf', '2021-08-06 15:34:05', '2021-08-06 15:36:02');
INSERT INTO `sys_account` VALUES (1423548790979108865, 'user1', '用户1', 'java', '123456', 'dafdsf', '2021-08-06 15:37:35', '2021-08-06 15:37:35');
INSERT INTO `sys_account` VALUES (1423548793046900737, 'user1', '用户1', 'java', '123456', 'dafdsf', '2021-08-06 15:37:35', '2021-08-06 15:37:35');
INSERT INTO `sys_account` VALUES (1423548793818652673, 'user1', '用户1', 'java', '123456', 'dafdsf', '2021-08-06 15:37:35', '2021-08-06 15:37:35');
INSERT INTO `sys_account` VALUES (1423548795349573633, 'user1', '用户1', 'java', '123456', 'dafdsf', '2021-08-06 15:37:36', '2021-08-06 15:37:36');
INSERT INTO `sys_account` VALUES (1423548796804997121, 'user1', '用户1', 'java', '123456', 'dafdsf', '2021-08-06 15:37:36', '2021-08-06 15:37:36');
INSERT INTO `sys_account` VALUES (1423548798327529473, 'user1', '用户1', 'java', '123456', 'dafdsf', '2021-08-06 15:37:36', '2021-08-06 15:37:36');
INSERT INTO `sys_account` VALUES (1423548799766175745, 'user1', '用户1', 'java', '123456', 'dafdsf', '2021-08-06 15:37:37', '2021-08-06 15:37:37');
INSERT INTO `sys_account` VALUES (1423548801326456834, 'user1', '用户1', 'java', '123456', 'dafdsf', '2021-08-06 15:37:37', '2021-08-06 15:37:37');
INSERT INTO `sys_account` VALUES (1423548802756714497, 'user1', '用户1', 'java', '123456', 'dafdsf', '2021-08-06 15:37:38', '2021-08-06 15:37:38');
INSERT INTO `sys_account` VALUES (1423548804379910145, 'user1', '用户1', 'java', '123456', 'dafdsf', '2021-08-06 15:37:38', '2021-08-06 15:37:38');
INSERT INTO `sys_account` VALUES (1423548805793390593, 'user1', '用户1', 'java', '123456', 'dafdsf', '2021-08-06 15:37:38', '2021-08-06 15:37:38');
INSERT INTO `sys_account` VALUES (1423548806573531138, 'user1', '用户1', 'java', '123456', 'dafdsf', '2021-08-06 15:37:38', '2021-08-06 15:37:38');
INSERT INTO `sys_account` VALUES (1423548807412391937, 'user1', '用户1', 'java', '123456', 'dafdsf', '2021-08-06 15:37:39', '2021-08-06 15:37:39');
INSERT INTO `sys_account` VALUES (1423548808758763522, 'user1', '用户1', 'java', '123456', 'dafdsf', '2021-08-06 15:37:39', '2021-08-06 15:37:39');
INSERT INTO `sys_account` VALUES (1423548810109329409, 'user1', '用户1', 'java', '123456', 'dafdsf', '2021-08-06 15:37:39', '2021-08-06 15:37:39');
INSERT INTO `sys_account` VALUES (1423550179276886018, '123456', '用户1', 'java', 'd666d6067051d487b921b8f8fdfe77540fa6e8743b6507b38155235ea89593f2', 'hCN1jQyj9pSkGsOIRvAC', '2021-08-06 15:43:06', '2021-08-06 15:43:06');
INSERT INTO `sys_account` VALUES (1423550184142278658, 'user1', '用户1', 'java', '07783442c1dfaf8dad7a3d65d322782e84e9617d0fbefc8b828974ec864c6a07', '8U1xi79NejvAuCVuXG1F', '2021-08-06 15:43:07', '2021-08-06 15:43:07');
INSERT INTO `sys_account` VALUES (1423550186927296514, 'user1', '用户1', 'java', 'ad4444ef62377d41d21f3b651e3d4b9f58e9eb1e48e2e2f12994b296fbd01156', 'bnhQfgluME0w8Pn7nMI2', '2021-08-06 15:43:08', '2021-08-06 15:43:08');
INSERT INTO `sys_account` VALUES (1423550188219142146, 'user1', '用户1', 'java', 'ebf340d313a2f6bdff741829544d2b4f104b8934abd822320756a87a31e62fbe', 'Rg2NERv8UcJ1WvS5oJC4', '2021-08-06 15:43:08', '2021-08-06 15:43:08');
INSERT INTO `sys_account` VALUES (1423550189053808642, 'user1', '用户1', 'java', '97c251d1228427024530060f90818b0ed8ddf3b166dce478e9835623197171e5', '7nOAwoHh12hF1ZOE74fV', '2021-08-06 15:43:08', '2021-08-06 15:43:08');
INSERT INTO `sys_account` VALUES (1423550190475677697, 'user1', '用户1', 'java', '97b2f4d7e1daac9b44e5d34b9f174d019bc6cd8c0e08db02ad1aad27ccb2ee95', 'StRuecZjXsnDaFSiSBbx', '2021-08-06 15:43:08', '2021-08-06 15:43:08');
INSERT INTO `sys_account` VALUES (1423550191897546754, 'user1', '用户1', 'java', 'b93120821a2f4b526a241fef08dcabc64d41683e5b1062f233e9e78d8391aa3a', 'FQszGSlzDemtEVeccThM', '2021-08-06 15:43:09', '2021-08-06 15:43:09');
INSERT INTO `sys_account` VALUES (1423550193323610113, 'user1', '用户1', 'java', '4d0727d400377ba05a3caba4dbca0416e4ae2534c189bb8eb7fcef7f59e9ab5d', '5nijqxFnFY2v7oD9LAHh', '2021-08-06 15:43:09', '2021-08-06 15:43:09');
INSERT INTO `sys_account` VALUES (1423555523248062466, 'keqi', '柯琦', 'java', '361bef378c16683a27065e48b1d6916b3ae70f7af580ba9cefc04dcac9672aee', 'gt5BeK6noJXaCQzhOhiD', '2021-08-06 16:04:20', '2021-08-06 16:04:20');

-- ----------------------------
-- Table structure for sys_account_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_account_role`;
CREATE TABLE `sys_account_role`  (
  `account_id` bigint(20) NOT NULL COMMENT '用户id',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`account_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户-角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_account_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_dict_item
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_item`;
CREATE TABLE `sys_dict_item`  (
  `type_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典类型编码',
  `type_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典类型名称',
  `item_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典项编码',
  `item_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典项值',
  `order_num` int(11) NULL DEFAULT NULL COMMENT '排序字段',
  PRIMARY KEY (`type_code`, `item_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '字典表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_item
-- ----------------------------
INSERT INTO `sys_dict_item` VALUES ('gender', '性别', 'man', '男', 1);
INSERT INTO `sys_dict_item` VALUES ('gender', '性别', 'women', '女', 2);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '菜单id',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
  `url` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求URL地址',
  `icon` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'ICON图标',
  `type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单类型 [C 目录，M 菜单，B 按钮]',
  `permiss` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限标识',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父级ID',
  `order_num` int(11) NULL DEFAULT NULL COMMENT '排序字段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '角色id',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `permiss` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限标识',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1423518074190884865, '管理员2', 'admin2', '2021-08-06 13:35:31', '2021-08-06 13:35:31');
INSERT INTO `sys_role` VALUES (1423519623566782466, '超级管理员', 'admin', '2021-08-06 13:41:41', '2021-08-06 13:50:51');
INSERT INTO `sys_role` VALUES (1423526344641138689, '管理员4', 'admin4', '2021-08-06 14:08:23', '2021-08-06 14:08:23');
INSERT INTO `sys_role` VALUES (1423526348051107841, '管理员4', 'admin4', '2021-08-06 14:08:24', '2021-08-06 14:08:24');
INSERT INTO `sys_role` VALUES (1423526350638993409, '管理员4', 'admin4', '2021-08-06 14:08:25', '2021-08-06 14:08:25');
INSERT INTO `sys_role` VALUES (1423526352375435266, '管理员4', 'admin4', '2021-08-06 14:08:25', '2021-08-06 14:08:25');
INSERT INTO `sys_role` VALUES (1423526353407234050, '管理员4', 'admin4', '2021-08-06 14:08:25', '2021-08-06 14:08:25');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单id',
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色-菜单关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
