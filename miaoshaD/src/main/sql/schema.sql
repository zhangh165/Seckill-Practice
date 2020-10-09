-- 数据库初始化脚本

-- 创建数据库
CREATE DATABASE seckill;
-- 使用数据库
use seckill;
-- 创建商品表

CREATE TABLE seckill(
  `seckill_id` bigint AUTO_INCREMENT NOT NULL comment '商品序号',
  `name` varchar(120)  NOT NULL comment '商品名称',
  `number` int NOT NULL comment '商品数量',
  `start_time` timestamp NOT NULL comment '开始时间',
  `end_time` timestamp NOT NULL comment '结束时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间',
  PRIMARY KEY (seckill_id),
  KEY idx_start_time(start_time),
  KEY idx_end_time(end_time),
  KEY idx_create_time(create_time)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT '秒杀商品表';

-- 初始化数据
INSERT INTO
      seckill(name,number,start_time,end_time)
  VALUES
      ('火车玩具',100,'2020-10-7 00:00:00','2020-10-8 00:00:00'),
      ('汽车玩具',200,'2020-10-7 00:00:00','2020-10-8 00:00:00');

-- 秒杀明细表

CREATE TABLE seckill_info(
  `user_phone_number` varchar(20) NOT NULL comment '购买用户电话',
  `seckill_id` bigint NOT NULL comment '购买商品序号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP comment '订单创建时间',
  PRIMARY KEY (seckill_id,user_phone_number),/* 联合主键*/
  KEY idx_create_time(create_time)

)ENGINE=InnoDB DEFAULT CHAR SET=utf8 COMMENT '秒杀商品明细表';


