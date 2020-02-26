/*
 Navicat Premium Data Transfer

 Source Server         : 47.102.124.165
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : 47.102.124.165:3306
 Source Schema         : mybatis_puls

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 26/02/2020 13:41:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for T_MANUAL_INSPECTION
-- ----------------------------
DROP TABLE IF EXISTS `T_MANUAL_INSPECTION`;
CREATE TABLE `T_MANUAL_INSPECTION`  (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PLAN_NAME` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '巡检计划名称',
  `PLAN_CONTENT` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '巡检内容描述',
  `PERIOD_TYPE` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '巡检周期类型 （Y固定时间，N不固定时间）',
  `PEOPLE_TYPE` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '巡检人员类型 （Y不固定人员，N固定人员）',
  `RUN_PERIOD` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '执行周期',
  `RUN_PERIOD_UNIT` char(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '周期单位（MONTH/WEEK/DAY）',
  `RUN_PERIOD_DATE` tinyint(3) UNSIGNED NULL DEFAULT NULL COMMENT '执行日期（WEEK:1-7,MONTH:1-31）',
  `RUN_PERIOD_START` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
  `ACTIVE` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '启用状态（Y启用，N停用）',
  `CREATE_USER` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_USER` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '最后修改人',
  `UPDATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '人工巡检计划表' ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_code_gen
-- ----------------------------
INSERT INTO `t_code_gen` VALUES (1, 'keqi', 23, 75.5, '2020-01-06 18:10:59', '2020-01-06 18:11:01', 'admin', 'admin');
INSERT INTO `t_code_gen` VALUES (2, 'hjt', 23, 49.3, '2020-01-06 18:11:32', '2020-01-06 18:11:35', 'admin', 'admin');
INSERT INTO `t_code_gen` VALUES (3, 'fdafa', 12, 23.32, '2020-01-08 11:49:32', '2020-01-08 11:49:32', NULL, NULL);
INSERT INTO `t_code_gen` VALUES (4, 'fdafa', 1223, 23.32, '2020-01-08 11:51:39', '2020-01-08 11:54:49', NULL, NULL);
INSERT INTO `t_code_gen` VALUES (5, NULL, NULL, NULL, '2020-02-19 00:56:40', '2020-02-19 00:56:40', NULL, NULL);
INSERT INTO `t_code_gen` VALUES (6, NULL, NULL, NULL, '2020-02-19 00:56:46', '2020-02-19 00:56:46', NULL, NULL);
INSERT INTO `t_code_gen` VALUES (7, NULL, NULL, NULL, '2020-02-19 00:57:00', '2020-02-19 00:57:00', NULL, NULL);
INSERT INTO `t_code_gen` VALUES (8, NULL, NULL, NULL, '2020-02-19 00:57:07', '2020-02-19 00:57:07', NULL, NULL);
INSERT INTO `t_code_gen` VALUES (9, 'fdasfsdaf', NULL, NULL, '2020-02-19 00:57:56', '2020-02-19 00:57:56', NULL, NULL);
INSERT INTO `t_code_gen` VALUES (10, 'fdasfsdaf', NULL, NULL, '2020-02-19 00:58:02', '2020-02-19 00:58:02', NULL, NULL);
INSERT INTO `t_code_gen` VALUES (11, 'fdasfsdaf', NULL, NULL, '2020-02-19 00:58:04', '2020-02-19 00:58:04', NULL, NULL);
INSERT INTO `t_code_gen` VALUES (12, 'fdasfsdaf', NULL, NULL, '2020-02-19 00:58:08', '2020-02-19 00:58:08', NULL, NULL);
INSERT INTO `t_code_gen` VALUES (13, 'fdasfsdaf', NULL, NULL, '2020-02-19 00:58:09', '2020-02-19 00:58:09', NULL, NULL);
INSERT INTO `t_code_gen` VALUES (14, 'fdasfsdaf', NULL, NULL, '2020-02-19 00:58:10', '2020-02-19 00:58:10', NULL, NULL);
INSERT INTO `t_code_gen` VALUES (15, 'fdasfsdaf', NULL, NULL, '2020-02-19 00:58:11', '2020-02-19 00:58:11', NULL, NULL);
INSERT INTO `t_code_gen` VALUES (16, 'fdasfsdaf', NULL, NULL, '2020-02-19 00:58:12', '2020-02-19 00:58:12', NULL, NULL);
INSERT INTO `t_code_gen` VALUES (17, 'fdasfsdaf', NULL, NULL, '2020-02-19 00:58:13', '2020-02-19 00:58:13', NULL, NULL);
INSERT INTO `t_code_gen` VALUES (18, 'fdasfsdaf', NULL, NULL, '2020-02-19 00:58:14', '2020-02-19 00:58:14', NULL, NULL);
INSERT INTO `t_code_gen` VALUES (19, 'fdasfsdaf', NULL, NULL, '2020-02-19 00:58:15', '2020-02-19 00:58:15', NULL, NULL);
INSERT INTO `t_code_gen` VALUES (20, 'fdasfsdaf', NULL, NULL, '2020-02-19 00:58:16', '2020-02-19 00:58:16', NULL, NULL);
INSERT INTO `t_code_gen` VALUES (21, 'fdasfsdaf', NULL, NULL, '2020-02-19 00:58:17', '2020-02-19 00:58:17', NULL, NULL);
INSERT INTO `t_code_gen` VALUES (22, 'fdasfsdaf', NULL, NULL, '2020-02-19 00:58:17', '2020-02-19 00:58:17', NULL, NULL);
INSERT INTO `t_code_gen` VALUES (23, 'fdasfsdaf', NULL, NULL, '2020-02-19 00:58:18', '2020-02-19 00:58:18', NULL, NULL);
INSERT INTO `t_code_gen` VALUES (24, 'fdasfsdaf', NULL, NULL, '2020-02-19 00:58:19', '2020-02-19 00:58:19', NULL, NULL);
INSERT INTO `t_code_gen` VALUES (25, 'fdasfsdaf', NULL, NULL, '2020-02-19 00:58:20', '2020-02-19 00:58:20', NULL, NULL);
INSERT INTO `t_code_gen` VALUES (26, 'fdasfsdaf', NULL, NULL, '2020-02-19 00:58:43', '2020-02-19 00:58:43', NULL, NULL);
INSERT INTO `t_code_gen` VALUES (27, 'fdasfsdaf', NULL, NULL, '2020-02-19 00:59:07', '2020-02-19 00:59:07', NULL, NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_code_gen_db
-- ----------------------------
INSERT INTO `t_code_gen_db` VALUES (1, 'keqi', 23, 75.5, '2020-01-06 18:10:59', '2020-01-06 18:11:01', 'admin', 'admin');
INSERT INTO `t_code_gen_db` VALUES (2, 'hjt', 22, 49.3, '2020-01-06 18:11:32', '2020-01-08 10:38:05', 'admin', 'admin');
INSERT INTO `t_code_gen_db` VALUES (3, 'fja', 25, 234, '2020-01-08 10:51:46', '2020-01-08 10:52:23', NULL, NULL);
INSERT INTO `t_code_gen_db` VALUES (4, 'ds', 32564, 23, '2020-01-08 12:00:58', '2020-01-08 12:01:05', NULL, NULL);
INSERT INTO `t_code_gen_db` VALUES (5, 'fdafa', 12234312, 23.32, '2020-01-08 13:48:08', '2020-01-08 13:50:17', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
