/*
 Navicat Premium Data Transfer

 Source Server         : first
 Source Server Type    : MySQL
 Source Server Version : 50553
 Source Host           : localhost:3306
 Source Schema         : yy

 Target Server Type    : MySQL
 Target Server Version : 50553
 File Encoding         : 65001

 Date: 14/03/2020 19:29:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for form
-- ----------------------------
DROP TABLE IF EXISTS `form`;
CREATE TABLE `form`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `institute` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `institute_id` int(11) NULL DEFAULT NULL,
  `class` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` datetime NULL DEFAULT NULL,
  `hb` int(11) NULL DEFAULT NULL COMMENT '是否与湖北人员接触',
  `fr` int(11) NULL DEFAULT NULL COMMENT '是否发热',
  `ky` int(11) NULL DEFAULT NULL COMMENT '是否接触可以人员',
  `fx` int(11) NULL DEFAULT NULL,
  `tw` double NULL DEFAULT NULL COMMENT '体温',
  `teacher` int(255) NULL DEFAULT NULL,
  `phone` int(255) NOT NULL,
  `remark` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of form
-- ----------------------------
INSERT INTO `form` VALUES (9, 201711, '杨波', '教育学院', 2, '1班', '2020-03-06 06:44:05', 0, 0, 0, 0, 38, 16345682, 222, 1);
INSERT INTO `form` VALUES (10, 201701, '张慧', '计算机科学与工程学院', 1, '1班', '2020-03-07 09:04:13', 0, 0, 0, 0, 37.5, 17340232, 196723637, 1);
INSERT INTO `form` VALUES (11, 201721, '赵晨', '法学院', 3, '1班', '2020-03-07 08:05:11', 0, 0, 0, 0, 36, 179076514, 179076514, 1);
INSERT INTO `form` VALUES (12, 201722, '王阳', '法学院', 3, '1班', '2020-03-12 09:21:46', 0, 0, 1, 1, 37, 15892337, 178925637, 1);
INSERT INTO `form` VALUES (13, 201712, '白雪', '教育学院', 2, '2班', '2020-03-10 07:17:56', 0, 0, 0, 0, 36.8, 13647678, 1364556, 1);
INSERT INTO `form` VALUES (14, 201702, '李华', '计算机科学与工程学院', 1, '2班', '2020-03-14 07:19:04', 0, 0, 0, 0, 37, 1375482342, 13745588, 1);
INSERT INTO `form` VALUES (16, 201724, '陈亮亮', '法学院', 3, '4班', '2020-03-14 06:44:29', 0, 0, 1, 1, 37.4, 1375395205, 150642537, 1);
INSERT INTO `form` VALUES (17, 201713, '李伟', '教育学院', 2, '3班', '2020-03-14 18:45:20', 0, 1, 1, 1, 38, 178375238, 169306358, 1);
INSERT INTO `form` VALUES (18, 201714, '胡歌', '教育学院', 2, '4班', '2020-03-14 08:45:38', 0, 0, 0, 0, 38, 1380428604, 1386031578, 1);
INSERT INTO `form` VALUES (19, 201723, '王小丫', '法学院', 3, '3班', '2020-03-13 09:56:07', 0, 0, 0, 0, 38.2, 1707742438, 1703674338, 1);
INSERT INTO `form` VALUES (20, 201704, '赵霞', '计算机科学与工程学院', 1, '2班', '2020-03-14 18:46:28', 0, 0, 1, 1, 37, 2147483647, 1374032168, 1);
INSERT INTO `form` VALUES (21, 201703, '张宏', '计算机科学与工程学院', 1, '3班', '2020-03-12 09:49:23', 0, 1, 1, 1, 38, 1583031574, 1795270324, 1);

-- ----------------------------
-- Table structure for institute
-- ----------------------------
DROP TABLE IF EXISTS `institute`;
CREATE TABLE `institute`  (
  `id` int(11) NOT NULL,
  `institute` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of institute
-- ----------------------------
INSERT INTO `institute` VALUES (1, '计算机科学与工程学院');
INSERT INTO `institute` VALUES (2, '教育学院');
INSERT INTO `institute` VALUES (3, '法学院');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `institute` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `institute_id` int(11) NULL DEFAULT NULL,
  `class` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 201725 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '老师2', '管理员老师2', '123456', '教育学院', 2, '1班', '1', 0);
INSERT INTO `user` VALUES (2, '老师1', '管理员老师1', '123456', '计算机科学与工程学院', 1, '1班', '1', 0);
INSERT INTO `user` VALUES (3, '老师3', '管理员老师3', '123456', '法学院', 3, '1班', '1', 0);
INSERT INTO `user` VALUES (4, '校领导', '校领导', '123456', '法学院', 3, '1班', '3', 1);
INSERT INTO `user` VALUES (201701, '张慧', '张慧', '123456', '计算机科学与工程学院', 1, '1班', '2', 1);
INSERT INTO `user` VALUES (201702, '李华', '李华', '123456', '计算机科学与工程学院', 1, '2班', '2', 1);
INSERT INTO `user` VALUES (201703, '张宏', '张宏', '123456', '计算机科学与工程学院', 1, '3班', '2', 1);
INSERT INTO `user` VALUES (201704, '赵霞', '赵霞', '123456', '计算机科学与工程学院', 1, '2班', '2', 1);
INSERT INTO `user` VALUES (201711, '杨波', '杨波', '123456', '教育学院', 2, '1班', '2', 1);
INSERT INTO `user` VALUES (201712, '白雪', '白雪', '123456', '教育学院', 2, '2班', '2', 1);
INSERT INTO `user` VALUES (201713, '李伟', '李伟', '123456', '教育学院', 2, '3班', '2', 1);
INSERT INTO `user` VALUES (201714, '胡歌', '胡歌', '123456', '教育学院', 2, '4班', '2', 1);
INSERT INTO `user` VALUES (201721, '赵晨', '赵晨', '123456', '法学院', 3, '1班', '2', 1);
INSERT INTO `user` VALUES (201722, '王洋', '王阳', '123456', '法学院', 3, '1班', '2', 1);
INSERT INTO `user` VALUES (201723, '王小丫', '王小丫', '123456', '法学院', 3, '3班', '2', 1);
INSERT INTO `user` VALUES (201724, '陈亮亮', '陈亮亮', '123456', '法学院', 3, '4班', '2', 1);

SET FOREIGN_KEY_CHECKS = 1;
