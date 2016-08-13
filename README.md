# 描述
一个基于Java Web的服务器端程序，实现了对应Android程序所需的接口。其对应的Android程序源码为[Sport_Android](https://github.com/happyheng/Sport_Android)。

#技术栈
[Spring](http://projects.spring.io/spring-framework/#quick-start) 在项目中充当了管理容器的角色

[Spring MVC](http://projects.spring.io/spring-framework/#quick-start) 提供了构建Web应用程序的全能MVC模块

[MyBatis](http://www.mybatis.org/mybatis-3/index.html) 一个支持普通SQL查询,存储过程和高级映射的优秀持久层框架

[Redis](http://redis.io) 一个基于Key-Value的内存数据库 

#配置信息
### 数据库配置
本项目使用MySQL数据库，其数据库建表语句为

```
-- User表
create table tal_user(
id INT(11) unsigned not null  auto_increment,
name varchar(50) not null unique,
password varchar(50) not null,
nickname varchar(50) not null,
token varchar(50),
stime TIMESTAMP,
primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

-- 运动表
create table tal_sport(
id INT(11) unsigned not null  auto_increment,
userid int(11) unsigned not null,
primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

-- 运动信息表
create table tal_sport_message(
id INT(11) unsigned not null  auto_increment,
sportId INT(11) unsigned,
posx float,
posy float,
stime TIMESTAMP,
location varchar(100),
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

-- 资讯表
create table tal_news(
id INT(11) unsigned not null  auto_increment,
name varchar(50) not null,
simplecontent varchar(100),
thumbnail varchar(255),
url varchar(255),
stime TIMESTAMP,
primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

```
### 数据库连接配置
连接数据库的配置信息存储在项目的/src/dbconfig.properties中，可以将其改成自己的数据库连接配置。

需要注意的是，本项目使用Meven进行项目构建，所以在运行项目之前需要确保Maven可以正常使用。


