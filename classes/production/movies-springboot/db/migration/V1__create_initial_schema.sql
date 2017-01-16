CREATE TABLE `movies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` int(11) NOT NULL DEFAULT '0',
  `title` varchar(45) NOT NULL,
  `watched` tinyint(4) DEFAULT '0',
  `rating` varchar(5) DEFAULT NULL,
  `released` date DEFAULT NULL,
  `length` int(11) DEFAULT NULL,
  `created` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
