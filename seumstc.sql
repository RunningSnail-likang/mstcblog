/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : seumstc

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-05-03 22:34:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `activity`
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `title` varchar(64) DEFAULT NULL,
  `location` varchar(64) DEFAULT NULL,
  `time` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `is_top` tinyint(4) DEFAULT NULL,
  `sponsor` varchar(128) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `content` text,
  `like_count` int(11) DEFAULT NULL,
  `dislike_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity
-- ----------------------------

-- ----------------------------
-- Table structure for `activity_comment`
-- ----------------------------
DROP TABLE IF EXISTS `activity_comment`;
CREATE TABLE `activity_comment` (
  `id` int(32) NOT NULL,
  `entity_id` int(11) DEFAULT NULL,
  `entity_type` tinyint(4) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `to_user_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `content` text,
  `status` tinyint(4) DEFAULT NULL,
  `like_count` int(11) DEFAULT NULL,
  `dislike_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity_comment
-- ----------------------------

-- ----------------------------
-- Table structure for `activity_like_dislike`
-- ----------------------------
DROP TABLE IF EXISTS `activity_like_dislike`;
CREATE TABLE `activity_like_dislike` (
  `id` int(32) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `entity_id` int(11) DEFAULT NULL,
  `entity_type` tinyint(4) DEFAULT NULL,
  `is_like` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity_like_dislike
-- ----------------------------

-- ----------------------------
-- Table structure for `blog`
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` int(20) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `blog_abstract` text,
  `content` text,
  `image_url` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `key_word` varchar(255) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `flag` tinyint(4) DEFAULT NULL,
  `like_count` int(11) DEFAULT NULL,
  `dislike_count` int(11) DEFAULT NULL,
  `is_top` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------

-- ----------------------------
-- Table structure for `blog_comment`
-- ----------------------------
DROP TABLE IF EXISTS `blog_comment`;
CREATE TABLE `blog_comment` (
  `id` int(32) NOT NULL,
  `entity_id` int(11) NOT NULL,
  `entity_type` tinyint(4) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `to_user_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `content` text,
  `status` tinyint(4) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `like_count` int(11) DEFAULT NULL,
  `dislike_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_comment
-- ----------------------------

-- ----------------------------
-- Table structure for `blog_like_dislike`
-- ----------------------------
DROP TABLE IF EXISTS `blog_like_dislike`;
CREATE TABLE `blog_like_dislike` (
  `id` int(32) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `entity_id` int(11) DEFAULT NULL,
  `entity_type` tinyint(4) DEFAULT NULL,
  `is_like` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_like_dislike
-- ----------------------------

-- ----------------------------
-- Table structure for `my_collection`
-- ----------------------------
DROP TABLE IF EXISTS `my_collection`;
CREATE TABLE `my_collection` (
  `id` int(32) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `entity_id` int(32) DEFAULT NULL,
  `entity_type` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of my_collection
-- ----------------------------

-- ----------------------------
-- Table structure for `news`
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `title` varchar(64) DEFAULT NULL,
  `news_abstract` text,
  `content` text,
  `created_time` datetime DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `is_top` tinyint(4) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------

-- ----------------------------
-- Table structure for `news_comment`
-- ----------------------------
DROP TABLE IF EXISTS `news_comment`;
CREATE TABLE `news_comment` (
  `id` int(32) NOT NULL,
  `entity_id` int(11) DEFAULT NULL,
  `entity_type` tinyint(4) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `to_user_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `content` text,
  `status` tinyint(4) DEFAULT NULL,
  `like_count` int(11) DEFAULT NULL,
  `dislike_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news_comment
-- ----------------------------

-- ----------------------------
-- Table structure for `news_like_dislike`
-- ----------------------------
DROP TABLE IF EXISTS `news_like_dislike`;
CREATE TABLE `news_like_dislike` (
  `id` int(32) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `entity_id` int(11) DEFAULT NULL,
  `entity_type` tinyint(4) DEFAULT NULL,
  `is_like` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news_like_dislike
-- ----------------------------

-- ----------------------------
-- Table structure for `programming`
-- ----------------------------
DROP TABLE IF EXISTS `programming`;
CREATE TABLE `programming` (
  `id` int(20) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `ideas` text,
  `answer` text,
  `image_url` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `flag` tinyint(4) DEFAULT NULL,
  `like_count` int(11) DEFAULT NULL,
  `dislike_count` int(11) DEFAULT NULL,
  `is_top` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of programming
-- ----------------------------

-- ----------------------------
-- Table structure for `programming_comment`
-- ----------------------------
DROP TABLE IF EXISTS `programming_comment`;
CREATE TABLE `programming_comment` (
  `id` int(32) NOT NULL,
  `entity_id` int(11) NOT NULL,
  `entity_type` tinyint(4) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `to_user_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `content` text,
  `status` tinyint(4) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `like_count` int(11) DEFAULT NULL,
  `dislike_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of programming_comment
-- ----------------------------

-- ----------------------------
-- Table structure for `programming_like_dislike`
-- ----------------------------
DROP TABLE IF EXISTS `programming_like_dislike`;
CREATE TABLE `programming_like_dislike` (
  `id` int(32) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `entity_id` int(11) DEFAULT NULL,
  `entity_type` tinyint(4) DEFAULT NULL,
  `is_like` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of programming_like_dislike
-- ----------------------------

-- ----------------------------
-- Table structure for `question`
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` int(20) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `content` text,
  `image_url` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `key_word` varchar(255) DEFAULT NULL,
  `status` tinyint(4) NOT NULL,
  `flag` tinyint(4) DEFAULT NULL,
  `like_count` int(11) DEFAULT NULL,
  `dislike_count` int(11) DEFAULT NULL,
  `is_top` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------

-- ----------------------------
-- Table structure for `question_comment`
-- ----------------------------
DROP TABLE IF EXISTS `question_comment`;
CREATE TABLE `question_comment` (
  `id` int(32) NOT NULL,
  `entity_id` int(11) NOT NULL,
  `entity_type` tinyint(4) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `to_user_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `content` text,
  `status` tinyint(4) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `like_count` int(11) DEFAULT NULL,
  `dislike_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question_comment
-- ----------------------------

-- ----------------------------
-- Table structure for `question_like_dislike`
-- ----------------------------
DROP TABLE IF EXISTS `question_like_dislike`;
CREATE TABLE `question_like_dislike` (
  `id` int(32) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `entity_id` int(11) DEFAULT NULL,
  `entity_type` tinyint(4) DEFAULT NULL,
  `is_like` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question_like_dislike
-- ----------------------------

-- ----------------------------
-- Table structure for `system_message`
-- ----------------------------
DROP TABLE IF EXISTS `system_message`;
CREATE TABLE `system_message` (
  `id` int(32) NOT NULL,
  `from_id` int(11) DEFAULT NULL,
  `to_id` int(11) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `has_read` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_message
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(128) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `salt` varchar(32) DEFAULT NULL,
  `sex` tinyint(4) DEFAULT NULL,
  `head_url` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `hometown` varchar(255) DEFAULT NULL,
  `school` varchar(255) DEFAULT NULL,
  `department` varchar(64) DEFAULT NULL,
  `degree` varchar(64) DEFAULT NULL,
  `hobby` varchar(255) DEFAULT NULL,
  `qq` varchar(64) DEFAULT NULL,
  `wechat` varchar(64) DEFAULT NULL,
  `register_time` datetime DEFAULT NULL,
  `label` varchar(255) DEFAULT NULL,
  `token` varchar(128) DEFAULT NULL,
  `type` tinyint(4) DEFAULT NULL,
  `follown_count` int(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('3', '978094403@qq.com', '978094403@qq.com', 'BDD1B4897330BBF9280C6F378637CD43', '3fdf8', '0', null, null, null, '江苏省 南京市', null, null, null, null, null, null, '2018-05-02 21:21:58', null, 'ee537453-7090-467a-a205-ad278874abb7', null, null);
INSERT INTO `user` VALUES ('4', '626929685@qq.com', '626929685@qq.com', '85B9B1BD6A36B479F1010AF7558B214C', '36919', '0', null, null, null, '江苏省 南京市', null, null, null, null, null, null, '2018-05-03 20:09:13', null, 'cbb176dc-4fd2-4e19-90de-282b8557857f', null, '0');

-- ----------------------------
-- Table structure for `user_follower`
-- ----------------------------
DROP TABLE IF EXISTS `user_follower`;
CREATE TABLE `user_follower` (
  `id` int(32) NOT NULL,
  `from_id` int(11) DEFAULT NULL,
  `to_id` int(11) DEFAULT NULL,
  `relationship_id` varchar(32) DEFAULT NULL,
  `is_friend` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_follower
-- ----------------------------

-- ----------------------------
-- Table structure for `user_message`
-- ----------------------------
DROP TABLE IF EXISTS `user_message`;
CREATE TABLE `user_message` (
  `id` int(32) NOT NULL,
  `from_id` int(11) DEFAULT NULL,
  `to_id` int(11) DEFAULT NULL,
  `content` varchar(256) DEFAULT NULL,
  `has_read` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `conversation_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_message
-- ----------------------------
