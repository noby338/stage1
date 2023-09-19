-- 数据准备

use stage1;
drop table if exists user;
create table user
(
    id       int,-- 整型，四个字节
    name     varchar(10),-- 可变长字符串（字符串宽度小于等于10即可）
    password varchar(20)
);

insert into user(id, name,password) value (1, 'noby','123');

