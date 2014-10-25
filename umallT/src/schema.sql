DROP TABLE IF EXISTS `umall`.`customers`;
CREATE TABLE  `umall`.`customers` (
`ID` varchar(15) NOT NULL,
`name` varchar(20) NOT NULL,
`password` varchar(20) NOT NULL,
`address` varchar(100) NOT NULL,
`phone` varchar(30) DEFAULT NULL,
`gender` char(1) DEFAULT NULL,
`birth_date` date DEFAULT NULL,
`married` tinyint(1) NOT NULL,
`email` varchar(30) DEFAULT NULL,
`blood_type` varchar(2) DEFAULT NULL,
PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
commit;

INSERT INTO `umall`.`customers` (`id`, `name`, `password`, `phone`, `gender`, `address`, `email`, `married`, `birth_date`, `blood_type`) 
    VALUES ('A123456789', '張三','1234', '25149191', 'M', '台北市復興北路99號14樓', 'test@uuu.com.tw', 0, '1967/3/4', 'A');
INSERT INTO `umall`.`customers` (`id`, `name`, `password`, `phone`, `gender`, `address`, `email`, `married`, `birth_date`, `blood_type`) 
    VALUES ('A223456781', '李莉梅','1234', '25149191', 'F', '台北市南京東路2段16號1F', 'limei_lee@uuu.com.tw', 1, '1953-12-11', 'B');
commit;

DROP TABLE IF EXISTS `umall`.`products`;
CREATE TABLE  `umall`.`products` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `unit_price` double NOT NULL DEFAULT '0',
  `free` tinyint(1) NOT NULL DEFAULT '0',
  `stock` int(5) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
commit;

INSERT INTO `umall`.`products` (`id`, `name`,`unit_price`, `free`,`stock`)
 VALUES(1,'HTC One(M8) 16GB', 20075.0,0,10);
INSERT INTO `umall`.`products` (`id`, `name`,`unit_price`, `free`,`stock`)
 VALUES(2,'Sony Xperia Z2',	24718.0,0,20);
INSERT INTO `umall`.`products` (`id`, `name`,`unit_price`, `free`,`stock`)
 VALUES(3,'Acer Liquid E3 16GB', 7585.0,0,15);
INSERT INTO `umall`.`products` (`id`, `name`,`unit_price`, `free`,`stock`)
 VALUES(4,'ASUS PadFone mini 4.3', 9708.0,0,10);
INSERT INTO `umall`.`products` (`id`, `name`,`unit_price`, `free`,`stock`)
 VALUES(5,'Apple iPhone 5S 16GB', 19610.0,0,10);
INSERT INTO `umall`.`products` (`id`, `name`,`unit_price`, `free`,`stock`)
 VALUES(6,'HTC Desire 816', 9901.0,0,20);
commit;

DROP TABLE IF EXISTS `umall`.`order_items`;
DROP TABLE IF EXISTS `umall`.`orders`;
commit;

CREATE TABLE `orders` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `customer_id` varchar(15) NOT NULL,
  `order_date` datetime NOT NULL,
  `amount` double DEFAULT '0',
  `status` int(2) unsigned NOT NULL DEFAULT '0',
  `payment`int(1) unsigned DEFAULT NULL,
  `payment_amount` double DEFAULT '0',
  `payment_note` varchar(100) NULL,
  `shipping` int(1) unsigned DEFAULT NULL,
  `receiver_name` varchar(45) NOT NULL,
  `receiver_phone` varchar(30) NOT NULL,
  `receiver_email` varchar(30) NOT NULL,
  `shipping_address` varchar(100) NOT NULL,
  `shipping_cost` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `order_items` (
  `order_id` int(11) unsigned NOT NULL,
  `product_id` int(11) unsigned NOT NULL,
  `price` double NOT NULL,
  `quantity` double NOT NULL,
  `free` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`order_id`,`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

commit;




