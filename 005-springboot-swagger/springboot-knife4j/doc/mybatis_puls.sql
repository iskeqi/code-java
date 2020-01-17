/*
 Navicat Premium Data Transfer

 Source Server         : 47.102.124.165
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : 47.102.124.165:3306
 Source Schema         : mybatis_puls

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 08/01/2020 13:51:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_code_gen
-- ----------------------------
DROP TABLE IF EXISTS `t_code_gen`;
CREATE TABLE `t_code_gen`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `weight` double NULL DEFAULT NULL COMMENT '重量',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_code_gen
-- ----------------------------
INSERT INTO `t_code_gen` VALUES (1, 'keqi', 23, 75.5, '2020-01-06 18:10:59', '2020-01-06 18:11:01', 'admin', 'admin');
INSERT INTO `t_code_gen` VALUES (2, 'hjt', 23, 49.3, '2020-01-06 18:11:32', '2020-01-06 18:11:35', 'admin', 'admin');
INSERT INTO `t_code_gen` VALUES (3, 'fdafa', 12, 23.32, '2020-01-08 11:49:32', '2020-01-08 11:49:32', NULL, NULL);
INSERT INTO `t_code_gen` VALUES (4, 'fdafa', 1223, 23.32, '2020-01-08 11:51:39', '2020-01-08 11:54:49', NULL, NULL);

-- ----------------------------
-- Table structure for t_code_gen_db
-- ----------------------------
DROP TABLE IF EXISTS `t_code_gen_db`;
CREATE TABLE `t_code_gen_db`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `weight` double NULL DEFAULT NULL COMMENT '重量',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_code_gen_db
-- ----------------------------
INSERT INTO `t_code_gen_db` VALUES (1, 'keqi', 23, 75.5, '2020-01-06 18:10:59', '2020-01-06 18:11:01', 'admin', 'admin');
INSERT INTO `t_code_gen_db` VALUES (2, 'hjt', 22, 49.3, '2020-01-06 18:11:32', '2020-01-08 10:38:05', 'admin', 'admin');
INSERT INTO `t_code_gen_db` VALUES (3, 'fja', 25, 234, '2020-01-08 10:51:46', '2020-01-08 10:52:23', NULL, NULL);
INSERT INTO `t_code_gen_db` VALUES (4, 'ds', 32564, 23, '2020-01-08 12:00:58', '2020-01-08 12:01:05', NULL, NULL);
INSERT INTO `t_code_gen_db` VALUES (5, 'fdafa', 12234312, 23.32, '2020-01-08 13:48:08', '2020-01-08 13:50:17', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
