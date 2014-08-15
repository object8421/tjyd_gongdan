/*
Navicat MySQL Data Transfer

Source Server         : 工单库tuts
Source Server Version : 50077
Source Host           : 172.16.56.97:3306
Source Database       : yd_gongdan

Target Server Type    : MYSQL
Target Server Version : 50077
File Encoding         : 65001

Date: 2014-08-15 15:15:10
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL auto_increment COMMENT '客户ID',
  `customer_id` varchar(11) default NULL COMMENT '客户编号--来自移动',
  `customer_name` varchar(255) default NULL COMMENT '客户名称 - client_name',
  `customer_address` varchar(255) default NULL COMMENT '客户地址 - client_address',
  `postal_code` varchar(6) default NULL COMMENT '客户邮编 - client_code',
  `category` varchar(255) default NULL COMMENT '客户所属行业 - industry',
  `b_contact` varchar(255) default NULL COMMENT '业务联系人 - business_contact',
  `b_phone` varchar(255) default NULL COMMENT '业务联系电话 - business_phone',
  `b_email` varchar(255) default NULL COMMENT '业务联系人邮箱 - business_email',
  `t_contact` varchar(255) default NULL COMMENT '技术联系人 - technology_contact',
  `t_phone` varchar(255) default NULL COMMENT '技术联系人电话 - technology_phone',
  `t_email` varchar(255) default NULL COMMENT '技术联系人邮箱 - technology_email',
  `c_contact` varchar(255) default NULL COMMENT '客户经理名称 - customer_manager_contact',
  `c_phone` varchar(255) default NULL COMMENT '客户经理电话 - customer_manager_phone',
  `c_email` varchar(255) default NULL COMMENT '客户经理邮箱 - customer_manager_email',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', '2', '中联润通信息技术邮箱公司', '北京市海淀区苏州街20号银峰大厦2号楼802室', '100080', '软件', '张无忌', '12345678901', 'wuji.zhang@china-ops.com', '赵敏', '13245678902', 'min.zhao@china-ops.com', '杨过', '13425678901', 'guo.yang@china-ops.com');
INSERT INTO `customer` VALUES ('2', '3', '(liu)ceshiff', '北京市海淀区苏州街20号银峰大厦2号楼802室', '100080', '软件', '张无忌', '12345678901', 'wuji.zhang@china-ops.com', '赵敏', '13245678902', 'min.zhao@china-ops.com', '杨过', '13425678901', 'guo.yang@china-ops.com');
INSERT INTO `customer` VALUES ('3', '1', '(liu)ffas', '北京市海淀区苏州街20号银峰大厦2号楼802室', '100080', '软件', '张无忌', '12345678901', 'wuji.zhang@china-ops.com', '赵敏', '13245678902', 'min.zhao@china-ops.com', '杨过', '13425678901', 'guo.yang@china-ops.com');

-- ----------------------------
-- Table structure for `order_info`
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `id` int(11) NOT NULL auto_increment,
  `ticket_id` varchar(255) default NULL COMMENT '工单编号 - ticketId',
  `contract_id` varchar(255) default NULL COMMENT '同合编号 - contractId',
  `contract_signed_date` timestamp NULL default NULL COMMENT '合同起始时间 - contractSignedDate',
  `contract_expired_date` timestamp NULL default NULL COMMENT '合同截止时间 - contractExpiredDate',
  `available_at` varchar(255) default NULL COMMENT '资源开通时间 - availableAt',
  `product_type` enum('share','exclusive','storage') default NULL COMMENT ' 产品类型 - productType:专享云,共享云,云存储',
  `is_website` enum('yes','no') default NULL COMMENT '是否做网站 - forWebsite',
  `open_ports` varchar(255) default NULL COMMENT '开放端口',
  `ports_need_to_open` varchar(255) default NULL COMMENT '要求开放端口,如有多个端口，请用英文半角的逗号分隔 - portsNeedToOpen',
  `suite` varchar(255) default NULL COMMENT '套餐 - suite',
  `discount` varchar(255) default NULL COMMENT '折扣 - discount',
  `band_width` varchar(255) default NULL COMMENT '带宽 - bandwidth',
  `ip` varchar(255) default NULL COMMENT 'ip',
  `ip_count` varchar(255) default NULL COMMENT 'ip个数',
  `ecu` varchar(255) default NULL COMMENT 'ecu',
  `storage` varchar(255) default NULL COMMENT '存储',
  `snapshot` varchar(255) default NULL COMMENT '快照',
  `keys` varchar(255) default NULL COMMENT '密钥',
  `securitys` varchar(255) default NULL COMMENT '安全规则组',
  `ha` varchar(255) default NULL COMMENT '主机保护',
  `elb` varchar(255) default NULL COMMENT '负载均衡',
  `filing_no` varchar(255) default NULL COMMENT '备案号',
  `filing_ip` varchar(255) default NULL COMMENT '备案IP',
  `filing_domain` varchar(255) default NULL COMMENT '备案域名',
  `remark` varchar(255) default NULL COMMENT '备注',
  `is_fees_owed` varchar(255) default NULL COMMENT ' 是否欠费：yes/no',
  `open_time` timestamp NULL default NULL COMMENT '开通时间',
  `modify_time` timestamp NULL default NULL COMMENT '变更时间',
  `close_time` timestamp NULL default NULL COMMENT ' 撤销时间',
  `reset_time` timestamp NULL default NULL COMMENT '恢复时间',
  `reason` varchar(255) default NULL COMMENT ' 撤销原因',
  `detailed_reason` varchar(255) default NULL COMMENT ' 详细原因',
  `login_url` varchar(255) default NULL COMMENT '登录云平台的URL',
  `cloud_platform` varchar(255) default NULL COMMENT '所属云平台',
  `login_username` varchar(255) default NULL COMMENT '登录云平台用户名',
  `login_password` varchar(255) default NULL COMMENT '登陆云平台密码',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES ('1', '1', '1', '2014-08-14 00:00:00', '2014-08-30 00:00:00', '1', 'share', 'yes', '80', '432,319', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'a', null, null);
INSERT INTO `order_info` VALUES ('2', '1', '1', '2014-08-14 00:00:00', '2014-08-30 00:00:00', '1', 'exclusive', 'yes', '80', '432,319', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'c', null, null);
INSERT INTO `order_info` VALUES ('3', '2', '1', '2014-08-14 00:00:00', '2014-08-30 00:00:00', '1', 'share', 'yes', '80', '432,319', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'c', null, null);
INSERT INTO `order_info` VALUES ('4', '3', '1', '2014-08-14 00:00:00', '2014-08-30 00:00:00', '1', 'share', 'yes', '80', '432,319', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'b', null, null);

-- ----------------------------
-- Table structure for `privileges`
-- ----------------------------
DROP TABLE IF EXISTS `privileges`;
CREATE TABLE `privileges` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `token` varchar(255) default NULL,
  `url` varchar(255) default NULL,
  `sn` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of privileges
-- ----------------------------
INSERT INTO `privileges` VALUES ('1', '用户管理', '/user', '/user.htm', '1');
INSERT INTO `privileges` VALUES ('2', 'index', '/index', '/index.htm', '100');
INSERT INTO `privileges` VALUES ('3', '客户管理', '/client', '/client.htm', '2');
INSERT INTO `privileges` VALUES ('4', '工单管理', '/ticket', '/ticket.htm', '3');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL auto_increment,
  `role_name` varchar(255) default NULL,
  `role_type` enum('user','cfm','sys') default NULL COMMENT 'view - user(普通用户); cfm - configuration manager(资源分配管理员);sys - system manager(系统管理员)',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '系统管理员', 'sys');
INSERT INTO `role` VALUES ('2', '资源管理员', 'cfm');
INSERT INTO `role` VALUES ('3', '业务管理员', 'user');

-- ----------------------------
-- Table structure for `role_privileges`
-- ----------------------------
DROP TABLE IF EXISTS `role_privileges`;
CREATE TABLE `role_privileges` (
  `id` int(11) NOT NULL auto_increment,
  `role_type` varchar(20) default NULL COMMENT '角色ID - role_id',
  `priv_id` int(11) default NULL COMMENT '权限ID - privileges_id',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_privileges
-- ----------------------------
INSERT INTO `role_privileges` VALUES ('1', 'sys', '1');
INSERT INTO `role_privileges` VALUES ('2', 'sys', '2');
INSERT INTO `role_privileges` VALUES ('3', 'cfm', '3');
INSERT INTO `role_privileges` VALUES ('4', 'cfm', '2');
INSERT INTO `role_privileges` VALUES ('5', 'cfm', '4');
INSERT INTO `role_privileges` VALUES ('6', 'user', '2');
INSERT INTO `role_privileges` VALUES ('7', 'user', '4');

-- ----------------------------
-- Table structure for `ticket`
-- ----------------------------
DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket` (
  `id` int(11) NOT NULL auto_increment,
  `ticket_id` varchar(255) default NULL COMMENT '工单编号 - ticket_id',
  `customer_id` varchar(255) default NULL COMMENT '客户编号 - customer_id',
  `ticket_type` enum('open','modify','close','stop','reset') default NULL COMMENT '单工类型 - ticket_type',
  `ticket_state` varchar(255) default NULL COMMENT '工单状态 - ticket_state',
  `receive_time` timestamp NULL default NULL on update CURRENT_TIMESTAMP COMMENT '工单接收时间 yyyy-MM-dd HH:mm:ss',
  `is_use` int(11) default '1' COMMENT '是否在用 在用=1 ;作废：0；',
  `remark` varchar(255) default NULL,
  `send_time` timestamp NULL default NULL COMMENT '发送时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ticket
-- ----------------------------
INSERT INTO `ticket` VALUES ('1', '1', '1', 'open', '1', '2014-08-14 14:16:31', '1', '1', '2014-08-29 00:00:00');
INSERT INTO `ticket` VALUES ('2', '2', '1', 'open', '1', '2014-08-14 00:00:00', '1', '1', '2014-08-29 00:00:00');
INSERT INTO `ticket` VALUES ('3', '3', '1', 'modify', '1', '2014-08-14 14:36:39', '1', '1', '2014-08-29 00:00:00');
INSERT INTO `ticket` VALUES ('4', '4', '2', 'open', '1', '2014-08-14 14:18:42', '1', '1', '2014-08-29 00:00:00');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `user_name` varchar(255) default NULL,
  `login_name` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `role_type` enum('user','cfm','sys') default NULL COMMENT '角色类型 - role_type',
  `create_time` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'sysadmin', 'sysadmin', '123', 'sys', '2014-08-12 12:22:34');
INSERT INTO `user` VALUES ('2', 'admin', 'admin', 'admin', 'cfm', '2014-08-12 11:57:04');
INSERT INTO `user` VALUES ('3', 'testuser', 'user', 'user', 'user', '2014-08-11 16:19:47');
