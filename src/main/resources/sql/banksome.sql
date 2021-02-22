
DROP TABLE IF EXISTS `bank`;
CREATE TABLE `bank`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `kid` int(0) NULL DEFAULT NULL COMMENT '课程分类id',
  `course` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '课程分类',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '题目',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '内容',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者',
  `modifyTime` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `modifer` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者',
  `version` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '版本',
  `level` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '题的级别',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for contract
-- ----------------------------
DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '合约名称',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '机构代码',
  `open` double(255, 0) NULL DEFAULT NULL COMMENT '开盘价',
  `top` double(255, 0) NULL DEFAULT NULL COMMENT '最高价',
  `down` double(255, 0) NULL DEFAULT NULL COMMENT '最低价',
  `closing` double(255, 0) NULL DEFAULT NULL COMMENT '昨收',
  `now` double(255, 0) NULL DEFAULT NULL COMMENT '最新价',
  `onesell` double(255, 0) NULL DEFAULT NULL COMMENT '当前卖出价',
  `onebuy` double(255, 0) NULL DEFAULT NULL COMMENT '当前买入价',
  `settlement` double(255, 0) NULL DEFAULT NULL COMMENT '结算价',
  `yessettlement` double(255, 0) NULL DEFAULT NULL COMMENT '昨日结算价',
  `onebuynum` double(255, 0) NULL DEFAULT NULL COMMENT '当前买入挂量',
  `onesellnum` double(255, 0) NULL DEFAULT NULL COMMENT '当前卖出挂量',
  `holdings` bigint(0) NULL DEFAULT NULL COMMENT '目前持仓量',
  `volume` bigint(0) NULL DEFAULT NULL COMMENT '总交易成交量',
  `exchange` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '交易所',
  `varieties` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '品种',
  `date` date NULL DEFAULT NULL COMMENT '时间',
  `unknownparameters1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '未知参数1',
  `unknownparameters2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '未知参数2',
  `unknownparameters3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '未知参数3',
  `unknownparameters4` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '未知参数4',
  `unknownparameters5` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '未知参数5',
  `unknownparameters6` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '未知参数6',
  `unknownparameters7` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '未知参数7',
  `historytop` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '合约最高价格',
  `historydown` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '合约最低价格',
  `avg` double(255, 0) NULL DEFAULT NULL COMMENT '平均价格',
  `flag` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `creatime` datetime(0) NULL DEFAULT NULL,
  `modifyTime` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `onlyFlag`(`flag`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 456678 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `kid` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '分类名称',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '分类代码',
  PRIMARY KEY (`kid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for info
-- ----------------------------
DROP TABLE IF EXISTS `info`;
CREATE TABLE `info`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `contract` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '合约',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '合约中文名称',
  `var` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '品种英文代码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for metadate
-- ----------------------------
DROP TABLE IF EXISTS `metadate`;
CREATE TABLE `metadate`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '元数据名称',
  `value` bigint(0) NULL DEFAULT NULL COMMENT '元数据值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
