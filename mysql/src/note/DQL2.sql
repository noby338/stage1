-- 数据库查询语言，多表查询
-- 数据准备
drop table if exists emp;
drop table if exists dep;
create table dep # 部门表
(
    id   int primary key auto_increment,
    name varchar(20)
);
create table emp # 员工表
(
    id        int primary key auto_increment,
    name      varchar(10),
    gender    char(1),                       # 性别
    salary    double,                        # 工资
    hire_date date,                          # 入职日期
    dep_id    int,
    foreign key (dep_id) references dep (id) # 外键，关联部门表(部门表的主键)
);
insert into dep (name)
values ('研发部'),
       ('市场部'),
       ('财务部'),
       ('销售部');
insert into emp(name, gender, salary, hire_date, dep_id)
values ('孙悟空', '男', 7200, '2013-02-24', 1),
       ('猪八戒', '男', 3600, '2010-12-02', 2),
       ('唐僧', '男', 9000, '2008-08-08', 2),
       ('白骨精', '女', 5000, '2015-10-07', 3),
       ('蜘蛛精', '女', 4500, '2011-03-14', 1),
       ('小白龙', '男', 2500, '2011-02-14', null);

-- 笛卡尔积 ： 有 a ,b两个集合 取 a,b所有的组合情况
select *
from emp,
     dep;

-- 内连接查询，只返回两个表中公有的记录
# 隐式内连接
select *
from emp,
     dep
where emp.dep_id = dep.id;

# 查询 emp的 name，gender。dep表的name
select emp.name,
       emp.gender,
       dep.name
from emp,
     dep
where emp.dep_id = dep.id;

# 给表起别名
select t1.name,
       t1.gender,
       t2.name
from emp t1,
     dep t2
where t1.dep_id = t2.id;


# 显式内连接
select *
from emp
         inner join dep on emp.dep_id = dep.id;
select *
from dep
         inner join emp on emp.dep_id = dep.id;
# inner可以省略
select *
from emp
         join dep on emp.dep_id = dep.id;


-- 外连接查询
# outer可以省略
# 左外连接，返回左表中全部数据
select *
from emp
         left join dep on emp.dep_id = dep.id;# 查询员工表所有数据和对应的部门信息，emp显示在前，显示emp外键为null的记录
select *
from dep
         left join emp on emp.dep_id = dep.id;# 查询部门表所有数据和对应的员工信息，dep显示在前，显示dep外键为null的记录
# 右外连接，返回右表中全部数据
select *
from emp
         right join dep on emp.dep_id = dep.id;# 查询员工表所有数据和对应的部门信息，emp显示在前，显示dep外键为null的记录
select *
from dep
         right join emp on emp.dep_id = dep.id;# 查询部门表所有数据和对应的员工信息，dep显示在前，显示emp外键为null的记录


-- 子查询
# 查询工资高于猪八戒的员工信息
/*子查询语句结果是单行单列，子查询语句作为条件值，使用 =  !=  >  <  等进行条件判断*/
select *
from emp
where salary > (select salary from emp where name = '猪八戒');

# 查询 '财务部' 和 '市场部' 所有的员工信息
/*子查询语句结果是多行单列，子查询语句作为条件值，使用 in 等关键字进行条件判断*/
select *
from emp
where dep_id in (select id from dep where name in ('财务部', '市场部'));


# 查询入职日期是 '2011-11-11' 之后的员工信息和部门信息
/*子查询语句结果是多行多列/单行多列，子查询语句作为虚拟表*/
select *
from (select * from emp where hire_date > '2011-11-11') t1,
     dep
where t1.dep_id = dep.id;