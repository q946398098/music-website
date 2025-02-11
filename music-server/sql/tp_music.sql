-- tp_music.admin definition

CREATE TABLE `admin` (
                         `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                         `name` varchar(45) NOT NULL,
                         `password` varchar(45) NOT NULL,
                         `dt_deactivated` timestamp NULL DEFAULT NULL,
                         `ds_password_hash` varchar(100) DEFAULT NULL COMMENT 'md5加密',
                         PRIMARY KEY (`id`),
                         UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


-- tp_music.banner definition

CREATE TABLE `banner` (
                          `id` int(10) NOT NULL AUTO_INCREMENT,
                          `pic` varchar(255) NOT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;


-- tp_music.`collect` definition

CREATE TABLE `collect` (
                           `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                           `user_id` int(10) unsigned NOT NULL,
                           `type` tinyint(4) NOT NULL,
                           `song_id` int(10) unsigned DEFAULT NULL,
                           `song_list_id` int(10) unsigned DEFAULT NULL,
                           `create_time` datetime NOT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;


-- tp_music.comment definition

CREATE TABLE `comment` (
                           `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                           `user_id` int(10) unsigned NOT NULL,
                           `song_id` int(10) unsigned DEFAULT NULL,
                           `song_list_id` int(10) unsigned DEFAULT NULL,
                           `content` varchar(255) DEFAULT NULL,
                           `create_time` datetime DEFAULT NULL,
                           `type` tinyint(4) NOT NULL,
                           `up` int(10) unsigned NOT NULL DEFAULT '0',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;


-- tp_music.consumer definition

CREATE TABLE `consumer` (
                            `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                            `username` varchar(255) NOT NULL,
                            `password` varchar(100) NOT NULL,
                            `sex` tinyint(4) DEFAULT NULL,
                            `phone_num` char(15) DEFAULT NULL,
                            `email` char(30) DEFAULT NULL,
                            `birth` datetime DEFAULT NULL,
                            `introduction` varchar(255) DEFAULT NULL,
                            `location` varchar(45) DEFAULT NULL,
                            `avator` varchar(255) DEFAULT NULL,
                            `create_time` datetime NOT NULL,
                            `update_time` datetime NOT NULL,
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `username_UNIQUE` (`username`),
                            UNIQUE KEY `phone_num_UNIQUE` (`phone_num`),
                            UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


-- tp_music.list_song definition

CREATE TABLE `list_song` (
                             `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                             `song_id` int(10) unsigned NOT NULL,
                             `song_list_id` int(10) unsigned NOT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=210 DEFAULT CHARSET=utf8;


-- tp_music.rank_list definition

CREATE TABLE `rank_list` (
                             `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
                             `song_list_id` bigint(20) unsigned NOT NULL,
                             `consumer_id` bigint(20) unsigned NOT NULL,
                             `score` int(10) unsigned NOT NULL DEFAULT '0',
                             PRIMARY KEY (`id`),
                             UNIQUE KEY `consumerId` (`consumer_id`,`song_list_id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;


-- tp_music.singer definition

CREATE TABLE `singer` (
                          `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                          `name` varchar(45) CHARACTER SET utf8 NOT NULL,
                          `sex` tinyint(4) DEFAULT NULL,
                          `pic` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
                          `birth` datetime DEFAULT NULL,
                          `location` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
                          `introduction` text CHARACTER SET utf8,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- tp_music.song definition

CREATE TABLE `song` (
                        `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                        `singer_id` int(10) unsigned NOT NULL,
                        `name` varchar(45) CHARACTER SET utf8 NOT NULL,
                        `introduction` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
                        `create_time` datetime NOT NULL COMMENT '发行时间',
                        `update_time` datetime NOT NULL,
                        `pic` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
                        `lyric` text CHARACTER SET utf8,
                        `url` varchar(255) CHARACTER SET utf8 NOT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- tp_music.song_list definition

CREATE TABLE `song_list` (
                             `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                             `title` varchar(255) NOT NULL,
                             `pic` varchar(255) DEFAULT NULL,
                             `introduction` text,
                             `style` varchar(10) DEFAULT '无',
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8;


-- tp_music.user_support definition

CREATE TABLE `user_support` (
                                `id` int(11) NOT NULL AUTO_INCREMENT,
                                `comment_id` int(11) NOT NULL,
                                `user_id` varchar(45) NOT NULL,
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



INSERT INTO tp_music.admin (id, name, password, dt_deactivated, ds_password_hash) VALUES(1, 'admin', '123', NULL, '202cb962ac59075b964b07152d234b70');
INSERT INTO tp_music.admin (id, name, password, dt_deactivated, ds_password_hash) VALUES(2, 'admin1', '565', NULL, NULL);