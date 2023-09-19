-- 函数

-- 数据准备
use stage1;
drop table if exists stu;
create table stu (
                     id int, # 编号
                     name varchar(20), # 姓名
                     age int, # 年龄
                     sex varchar(5), # 性别
                     address varchar(100), # 地址
                     math double(5,2), # 数学成绩
                     english double(5,2), # 英语成绩
                     hire_date date # 入学时间
);
insert into stu(id,name,age,sex,address,math,english,hire_date)
values
    (1,'马运',55,'男','杭州',66,78,'1995-09-01'),
    (2,'马花疼',45,'女','深圳',98,87,'1998-09-01'),
    (3,'马斯克',55,'男','香港',56,77,'1999-09-02'),
    (4,'马斯克',55,'男','香港',56,77,'1999-09-02'),
    (5,'柳白',20,'女','湖南',76,65,'1997-09-05'),
    (6,'柳青',20,'男','湖南',86,null,'1998-09-01'),
    (7,'刘德花',57,'男','香港',99,99,'1998-09-01'),
    (8,'张学右',22,'女','香港',99,99,'1998-09-01'),
    (9,'德玛西亚',18,'男','南京',56,65,'1994-09-02');


-- mysql自带函数
-- 日期、时间有关
# 日期时间
select sysdate();
# 日期时间
select now();
# 时间戳
select current_timestamp();
# 日期
select curdate();
# 时间
select curtime();

-- 字符串有关
select concat('Hello', ' ', 'World');
select length('hello');
select lower('JAVA');
select upper('java');
select trim(' java ');
select ltrim(' java ');
select rtrim(' java ');

-- null有关
select name,ifnull(english,'是空的') from stu;
select name,if(english,'不是空的','是空的') from stu;

-- 加密有关
select md5('18435fdsf');

-- sql函数在DML中的应用
insert into stu value (10,'函数在DML中的应用',18,'男','南京',56,65,now());
-- sql函数在DQL中的应用
select *,concat(name,age) from stu;
select name,ifnull(english,'是空的') from stu;
select name,if(english,'不是空的','是空的') from stu;






