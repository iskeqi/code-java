/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.49.18
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : 192.168.49.18:3306
 Source Schema         : mybatis_puls

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 06/01/2020 18:12:45
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

SET FOREIGN_KEY_CHECKS = 1;
