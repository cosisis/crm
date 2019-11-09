/*
SQLyog 企业版 - MySQL GUI v8.14
MySQL - 5.7.4-m14 : Database - crm
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`crm` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `crm`;

/*Table structure for table `income_info` */

DROP TABLE IF EXISTS `income_info`;

CREATE TABLE `income_info` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `income_type` int(11) DEFAULT NULL COMMENT '理财类型',
  `principal` decimal(10,4) DEFAULT NULL COMMENT '本金',
  `rate` decimal(10,4) DEFAULT NULL COMMENT '利率',
  `profit` decimal(10,4) DEFAULT NULL COMMENT '收益',
  `begin_date` int(11) DEFAULT NULL COMMENT '存入日期',
  `value_date` int(11) DEFAULT NULL COMMENT '生息日期',
  `end_date` int(11) DEFAULT NULL COMMENT '到期日期',
  `day_nums` int(11) DEFAULT NULL COMMENT '投资天数',
  `create_time` date DEFAULT NULL COMMENT '创建日期',
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `income_info` */

insert  into `income_info`(`id`,`income_type`,`principal`,`rate`,`profit`,`begin_date`,`value_date`,`end_date`,`day_nums`,`create_time`,`user_id`) values (18,24,'10000.0000','10.0000','300.0000',20180120,20180120,0,30,'2018-07-17',1),(19,24,'10000.0000','10.0000','300.0000',20180120,20180120,0,30,'2018-09-06',1);

/*Table structure for table `income_type` */

DROP TABLE IF EXISTS `income_type`;

CREATE TABLE `income_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8;

/*Data for the table `income_type` */

insert  into `income_type`(`id`,`type_name`) values (24,'人人贷'),(25,'宜人财富'),(28,'支付宝'),(88,'aaa'),(89,'bbbbb'),(90,'cccc'),(91,'abc'),(92,'5544433'),(93,'333');

/*Table structure for table `sys_resources` */

DROP TABLE IF EXISTS `sys_resources`;

CREATE TABLE `sys_resources` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `permission` varchar(100) DEFAULT NULL,
  `parent_id` bigint(20) unsigned DEFAULT '0',
  `sort` int(10) unsigned DEFAULT NULL,
  `external` tinyint(1) unsigned DEFAULT NULL COMMENT '是否外部链接',
  `available` tinyint(1) unsigned DEFAULT '0',
  `icon` varchar(100) DEFAULT NULL COMMENT '菜单图标',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_sys_resource_parent_id` (`parent_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `sys_resources` */

insert  into `sys_resources`(`id`,`name`,`type`,`url`,`permission`,`parent_id`,`sort`,`external`,`available`,`icon`,`create_time`,`update_time`) values (1,'用户管理','menu',NULL,NULL,0,1,0,1,'fa fa-users','2018-05-16 17:02:54','2018-05-16 17:02:54'),(2,'用户列表','menu','/users','users',1,1,0,1,NULL,'2017-12-22 13:56:15','2018-05-16 14:44:20'),(3,'新增用户','button',NULL,'user:add',2,2,0,1,NULL,'2018-05-16 14:07:43','2018-05-16 14:16:23'),(4,'批量删除用户','button',NULL,'user:batchDelete',2,3,0,1,NULL,'2018-05-16 14:12:23','2018-05-16 14:16:35'),(5,'编辑用户','button',NULL,'user:edit',2,4,0,1,NULL,'2018-05-16 14:12:50','2018-05-16 14:16:43'),(6,'删除用户','button',NULL,'user:delete',2,5,0,1,NULL,'2018-05-16 14:13:09','2018-05-16 14:51:50'),(7,'分配用户角色','button',NULL,'user:allotRole',2,6,0,1,NULL,'2018-05-16 14:15:28','2018-05-16 14:16:54'),(8,'系统配置','menu',NULL,NULL,0,2,0,1,'fa fa-cogs','2017-12-20 16:40:06','2017-12-20 16:40:08'),(9,'资源管理','menu','/resources','resources',8,1,0,1,NULL,'2017-12-22 15:31:05','2017-12-22 15:31:05'),(10,'新增资源','button',NULL,'resource:add',9,2,0,1,NULL,'2018-05-16 14:07:43','2018-05-16 14:16:23'),(11,'批量删除资源','button',NULL,'resource:batchDelete',9,3,0,1,NULL,'2018-05-16 14:12:23','2018-05-16 14:16:35'),(12,'编辑资源','button',NULL,'resource:edit',9,4,0,1,NULL,'2018-05-16 14:12:50','2018-05-16 14:16:43'),(13,'删除资源','button',NULL,'resource:delete',9,5,0,1,NULL,'2018-05-16 14:13:09','2018-05-16 14:51:50'),(14,'角色管理','menu','/roles','roles',8,2,0,1,'','2017-12-22 15:31:27','2018-05-17 12:51:06'),(15,'新增角色','button',NULL,'role:add',14,2,0,1,NULL,'2018-05-16 14:07:43','2018-05-16 14:16:23'),(16,'批量删除角色','button',NULL,'role:batchDelete',14,3,0,1,NULL,'2018-05-16 14:12:23','2018-05-16 14:16:35'),(17,'编辑角色','button',NULL,'role:edit',14,4,0,1,NULL,'2018-05-16 14:12:50','2018-05-16 14:16:43'),(18,'删除角色','button',NULL,'role:delete',14,5,0,1,NULL,'2018-05-16 14:13:09','2018-05-16 14:51:50'),(19,'分配角色资源','button',NULL,'role:allotResource',14,6,0,1,NULL,'2018-05-17 10:04:21','2018-05-17 10:04:21'),(20,'数据监控','menu','','',NULL,3,0,1,'fa fa-heartbeat','2018-05-17 12:38:20','2018-05-17 12:53:06'),(21,'Druid监控','menu','/druid/index.html','druid',20,1,1,1,'','2018-05-17 12:46:37','2018-05-17 12:52:33');

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '角色名',
  `description` varchar(100) DEFAULT NULL,
  `available` tinyint(1) DEFAULT '0',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`name`,`description`,`available`,`create_time`,`update_time`) values (1,'role:root','超级管理员',1,'2017-12-20 16:40:24','2017-12-20 16:40:26'),(2,'role:admin','管理员',1,'2017-12-22 13:56:39','2017-12-22 13:56:39');

/*Table structure for table `sys_role_resources` */

DROP TABLE IF EXISTS `sys_role_resources`;

CREATE TABLE `sys_role_resources` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) unsigned NOT NULL,
  `resources_id` bigint(20) unsigned NOT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `sys_role_resources` */

insert  into `sys_role_resources`(`id`,`role_id`,`resources_id`,`create_time`,`update_time`) values (27,1,20,'2018-05-17 12:52:41','2018-05-17 12:52:41'),(28,1,21,'2018-05-17 12:52:41','2018-05-17 12:52:41'),(29,1,1,'2018-05-17 12:52:41','2018-05-17 12:52:41'),(30,1,2,'2018-05-17 12:52:41','2018-05-17 12:52:41'),(31,1,3,'2018-05-17 12:52:41','2018-05-17 12:52:41'),(32,1,4,'2018-05-17 12:52:41','2018-05-17 12:52:41'),(33,1,5,'2018-05-17 12:52:41','2018-05-17 12:52:41'),(34,1,6,'2018-05-17 12:52:41','2018-05-17 12:52:41'),(35,1,7,'2018-05-17 12:52:41','2018-05-17 12:52:41'),(36,1,8,'2018-05-17 12:52:41','2018-05-17 12:52:41'),(37,1,9,'2018-05-17 12:52:41','2018-05-17 12:52:41'),(38,1,10,'2018-05-17 12:52:41','2018-05-17 12:52:41'),(39,1,11,'2018-05-17 12:52:41','2018-05-17 12:52:41'),(40,1,12,'2018-05-17 12:52:41','2018-05-17 12:52:41'),(41,1,13,'2018-05-17 12:52:41','2018-05-17 12:52:41'),(42,1,14,'2018-05-17 12:52:41','2018-05-17 12:52:41'),(43,1,15,'2018-05-17 12:52:41','2018-05-17 12:52:41'),(44,1,16,'2018-05-17 12:52:41','2018-05-17 12:52:41'),(45,1,17,'2018-05-17 12:52:41','2018-05-17 12:52:41'),(46,1,18,'2018-05-17 12:52:41','2018-05-17 12:52:41'),(47,1,19,'2018-05-17 12:52:41','2018-05-17 12:52:41'),(48,2,20,'2018-05-17 12:52:51','2018-05-17 12:52:51'),(49,2,21,'2018-05-17 12:52:51','2018-05-17 12:52:51'),(50,2,2,'2018-05-17 12:52:51','2018-05-17 12:52:51'),(51,2,3,'2018-05-17 12:52:51','2018-05-17 12:52:51'),(52,2,8,'2018-05-17 12:52:51','2018-05-17 12:52:51'),(53,2,9,'2018-05-17 12:52:51','2018-05-17 12:52:51'),(54,2,10,'2018-05-17 12:52:51','2018-05-17 12:52:51'),(55,2,14,'2018-05-17 12:52:51','2018-05-17 12:52:51'),(56,2,15,'2018-05-17 12:52:51','2018-05-17 12:52:51'),(57,2,1,'2018-05-17 12:52:51','2018-05-17 12:52:51');

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL COMMENT '登录密码',
  `nickname` varchar(30) DEFAULT '' COMMENT '昵称',
  `mobile` varchar(30) DEFAULT NULL COMMENT '手机号',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱地址',
  `qq` varchar(20) DEFAULT NULL COMMENT 'QQ',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `gender` tinyint(2) unsigned DEFAULT NULL COMMENT '性别',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像地址',
  `user_type` enum('ROOT','ADMIN','USER') DEFAULT 'ADMIN' COMMENT '超级管理员、管理员、普通用户',
  `reg_ip` varchar(30) DEFAULT NULL COMMENT '注册IP',
  `last_login_ip` varchar(30) DEFAULT NULL COMMENT '最近登录IP',
  `last_login_time` datetime DEFAULT NULL COMMENT '最近登录时间',
  `login_count` int(10) unsigned DEFAULT '0' COMMENT '登录次数',
  `remark` varchar(100) DEFAULT NULL COMMENT '用户备注',
  `status` int(1) unsigned DEFAULT NULL COMMENT '用户状态',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`username`,`password`,`nickname`,`mobile`,`email`,`qq`,`birthday`,`gender`,`avatar`,`user_type`,`reg_ip`,`last_login_ip`,`last_login_time`,`login_count`,`remark`,`status`,`create_time`,`update_time`) values (1,'root','CGUx1FN++xS+4wNDFeN6DA==','超级管理员','15151551516','843977358@qq.com','843977358',NULL,NULL,'https://static.zhyd.me/static/img/favicon.ico','ROOT',NULL,'127.0.0.1','2018-05-17 13:09:35',228,NULL,1,'2018-01-02 09:32:15','2018-05-17 13:09:35'),(2,'admin','gXp2EbyZ+sB/A6QUMhiUJQ==','管理员','15151551516','843977358@qq.com','843977358',NULL,NULL,NULL,'ADMIN','0:0:0:0:0:0:0:1','0:0:0:0:0:0:0:1','2018-05-17 13:08:30',13,NULL,1,'2018-01-02 15:56:34','2018-05-17 13:08:30');

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) unsigned NOT NULL,
  `role_id` bigint(20) unsigned NOT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`id`,`user_id`,`role_id`,`create_time`,`update_time`) values (1,1,1,'2018-01-02 10:47:27','2018-01-02 10:47:27'),(2,2,2,'2018-01-05 18:21:02','2018-01-05 18:21:02');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) DEFAULT NULL,
  `note` varchar(100) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`user_name`,`note`,`sex`) values (1,'liu','jun',1),(2,'liu','jun',1),(3,'aaa','bbbb',2),(4,'vvvv','bbbb',2),(5,'abc','bca',1),(6,'abc','bca',1);

/*Table structure for table `test` */

DROP TABLE IF EXISTS `test`;

CREATE TABLE `test` (
  `column_1` int(11) NOT NULL,
  `column_2` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `test` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `usercode` varchar(100) DEFAULT NULL COMMENT '用户名',
  `password` varchar(200) DEFAULT NULL COMMENT '密码',
  `username` varchar(100) DEFAULT NULL COMMENT '姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`usercode`,`password`,`username`) values (1,'liuzhen','liuzhen','刘圳'),(2,'coisis','cosisis','罗思思');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`id`,`username`,`age`) values (53,'tsingsoft',14),(54,'tsingmybast',14),(55,NULL,5),(56,'zz',5),(57,'z888z',5),(58,'tsingdddssoft',14),(59,'tsingdddssoft',14),(60,'tsi先入为主uoft',14),(61,'log4jTest',14),(62,'log4jTest',14),(63,'hhhhoft',14),(64,'log4jTest',14),(65,'log4jTest',14),(66,'log4jTest',14),(67,'log4jTest',14);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
