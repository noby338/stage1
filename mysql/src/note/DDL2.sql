-- 数据库定义语言，约束
-- 1、默认值约束：
drop table if exists `user`;# 这里的反引号表示会和系统的标识符冲突，使用自定义标识符
create table `user`
(
    id     int,
    `name` varchar(20),
    gender varchar(20) default '女'
);
# 当填写该字段时，使用该值
insert into `user` value (1, '令狐冲', '男');
# 当未填写该字段时，该值使用默认值
insert into `user` (id, `name`) value (2, '岳灵珊');
# 当该字段填写默认值时，使用默认值
insert into `user` value (3, '林黛玉', default);

# 添加字段，同时给字段添加默认值约束
alter table `user`
    add hobby varchar(20) default '没有兴趣爱好';
# 修改字段默认值约束，不会修改记录中已经填入的默认值，是新的默认值会变为新设置的默认值
alter table `user`
    modify hobby varchar(20) default 'nohobby';
# 删除默认值约束，不会删除记录中已经填入的默认值，是新的默认值会为null
alter table `user`
    modify hobby varchar(20);
desc `user`;

-- 2、非空约束
drop table if exists `user`;
create table `user`
(
    id     int,
    `name` varchar(20) not null, # 非null
    gender varchar(20) default '女'
);

# 不可以为null
insert into `user` value (1, null, '男');
# 可以为''
insert into `user` value (2, '', '男');
# 添加字段，同时给字段添加非空约束
alter table `user`
    add hobby varchar(20) not null;
# 添加not null的字段约束
alter table `user`
    modify hobby varchar(20) not null;
# 删除约束
alter table `user`
    modify hobby varchar(20);
desc `user`;

-- 3、唯一约束
drop table if exists `user`;
create table `user`
(
    id     int unique, # 唯一
    `name` varchar(20) not null,
    gender varchar(20) default '女'
);
insert into `user` value (1, '令狐冲', '男');
# 将不能添加已存在的id(该字段设置了唯一约束)
insert into `user` value (1, '岳灵珊', '女');
# 添加unique的字段约束
alter table `user`
    modify id int unique;
# 删除唯一约束
alter table `user`
    drop index id;
desc `user`;

-- 4、主键约束(非空+唯一)：通常加在int类型的字段上(id)，一般表都有主键
drop table if exists `user`;
create table `user`
(
    id     int primary key, # 主键
    `name` varchar(20) not null,
    gender varchar(20) default '女'
);
insert into `user` value (1, '令狐冲', '男');
# 将不能添加已存在的id(该字段设置了主键约束)
insert into `user` value (1, '岳灵珊', '女');
# 将不能添加null值的id(该字段设置了主键约束)
insert into `user` value (null, '岳不群', '男');
# 添加primary key的字段约束
alter table `user`
    modify id int primary key;
# 删除主键约束
alter table `user`
    drop primary key;
desc `user`;


-- 联合主键：将多个字段设置为一个主键
drop table if exists teacher;
create table teacher
(# 记录每位老师不同班级学科成绩
    tid   int, # 工号
    cid   int, # 班级编号
    grade int, # 学科成绩
    primary key (tid, cid) # 联合主键
);

insert into teacher value (1001, 1, 80);
insert into teacher value (1001, 2, 90);
insert into teacher value (1001, 2, 100);# 不能插入相同的联合主键
desc teacher;


-- 5、自增长约束
drop table if exists `user`;
create table `user`
(
    id     int primary key auto_increment, # 主键约束、自增长约束
    `name` varchar(20) not null,
    gender varchar(20) default '女'
) auto_increment = 100;# 设置自增长的起始值为100
insert into `user` value (1001, '令狐冲', '男');
# 自增长约束在插入字段值时可根据最大值记录自动增加1
insert into `user` (`name`, gender) value ('岳灵珊', '女');
# 可以填入default，如果第一条记录的di字段值设置为default，则id为默认起始值。
insert into `user` value (default, '岳不群', '男');
# 设置自增长值
alter table `user`
    auto_increment = 10;
desc `user`;


-- 6、外键约束
drop table if exists `user`;
create table `user`
(# 用户表(父表)
    id     int primary key auto_increment, # 主键约束、自增长约束
    `name` varchar(20) not null,
    gender varchar(20) default '女'
) auto_increment = 100;# 设置自增长的起始值为100
insert into `user` value (default, 'noby', '男');
insert into `user` value (default, 'kace', '男');
insert into `user` value (default, 'july', '男');
desc `user`;

drop table if exists house;
create table house
(# 房屋表（子表）
    id        int primary key auto_increment, # 主键约束、自增长约束
    `address` varchar(20) not null,
    `user_id` int, # 用户id，值必须为用户表中的id值
    foreign key (`user_id`) references `user` (id) on update cascade # 给user_id字段添加外键约束，它的值受到user表中的id的约束
#  on update cascade 当更新父表时同时更新子表
);
insert into house value (default, 'chengdu', 100);
insert into house value (default, 'beijing', 101);
insert into house value (default, 'shanghai', 102);
# 没有103主键的user，添加失败
insert into house value (default, 'shengzheng', 103);
desc house;

# 父表更新主键，子表自动更新外键（定义子表时所设置）
update `user`
set id = 2
where id = 102;
# 删除父表的数据前应该先删除掉子表的数据
delete
from house
where id = 1;
# 直接执行此步报错
delete
from `user`
where id = 100;

