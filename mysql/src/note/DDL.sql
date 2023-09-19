-- 数据库定义语言，基本操作
-- 库的操作
# 显示所有库
show databases;
# 使用指定库
use stage1;
# 创建库
create database if not exists noby_database;
# 查看库的创建信息
show create database noby_database;
# 删除库
drop database if exists noby_database;

-- 表的操作
# 显示当前库的所有表
show tables;
# 删除存在的表
drop table if exists student;
# 创建表
create table student
(
    id       int,-- 整型，四个字节
    name     varchar(10),-- 可变长字符串（字符串宽度小于等于10即可）
    gender   char(1),-- 不可变长字符串
    birthday date,-- date表示日期，tatetime表示日期和时间
    score    double(5, 2),-- 5表示数据的总长度，2表示小数点后面的位数
    email    varchar(64),
    tel      varchar(15),
    status   tinyint-- 小整型，1个字节
);
# 查看表的结构
desc student;
# 查看表的创建信息
show create table student;
# 修改字段名
alter table student rename person;
# 修改字段名
alter table person rename to student;
# 添加字段
alter table student
    add address varchar(20) after tel;
# 修改字段类型
alter table student
    modify address varchar(30);
# 修改字段名和字段类型
alter table student
    change address addr varchar(50);
# 删除字段
alter table student
    drop addr;
# 删除原表，创建一张字段相同的无记录空表
truncate student;
# 删除表
drop table student;


