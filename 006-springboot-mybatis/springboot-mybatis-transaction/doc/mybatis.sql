/*
 Navicat Premium Data Transfer

 Source Server         : 47.102.124.165
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : 47.102.124.165:3306
 Source Schema         : mybatis

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 08/01/2020 00:11:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int(255) NULL DEFAULT NULL,
  `gmtCreate` datetime(0) NULL DEFAULT NULL,
  `gmtModified` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (4, 'xx', NULL, NULL, NULL, NULL);
INSERT INTO `t_user` VALUES (5, 'xx', NULL, NULL, NULL, NULL);
INSERT INTO `t_user` VALUES (6, 'xx', NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
