CREATE TABLE  tb_menu (
  section varchar(100) ,
  name varchar(100) ,
  url varchar(200) ,
  parent varchar(100) ,
  order varchar(100) ,
  id int(11) NOT NULL AUTO_INCREMENT,
  code varchar(100) ,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
INSERT INTO recomendador.tb_menu VALUES  ('FCSpiderParametrization','General','FCSpiderParametrization',NULL,'1',8,'param.spider.general'),
 ('FCSpiderParametrization','SpiderEPG','FCSpiderParametrization.do.spiderEpg',NULL,'1',9,'param.spider.epg'),
 ('FCSpiderParametrization','SpiderOD','FCSpiderParametrization.do.spiderOd',NULL,'2',10,'param.spider.od'),
 ('FCSpiderParametrization','SpiderRating','FCSpiderParametrization.do.spiderRating',NULL,'3',11,'param.spider.rating'),
 ('FCSpiderParametrization','SpiderChannel','FCSpiderParametrization.do.spideChannel',NULL,'4',12,'param.spider.channel'),
 ('FCSpiderParametrization','SpiderVod','FCSpiderParametrization.do.spiderVod',NULL,'5',13,'param.spider.vod');
 
 