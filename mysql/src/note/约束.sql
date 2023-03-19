-- 约束
/*
   外键约束:
      * 外键用来让两个表的数据之间建立链接，保证数据的一致性和完整性

   # 创建表时添加外键约束
   create table 表名(
       列名 数据类型,
       …
       [constraint] [外键名称] foreign key(外键列名) references 主表(主表列名)
   );

   # 建完表后添加外键约束
   alter table 表名 add constraint 外键名称 foreign key (外键字段名称) references 主表名称(主表列名称);

   # 删除约束
   alter table 表名 drop foreign key 外键名称;
*/

-- 表与表之间的一对多关系
# 部门表（主表）
drop table if exists department;
create table department(
                           id int primary key auto_increment,
                           dep_name varchar(20),
                           address varchar(20)
);
insert into department(dep_name,address) values
                                    ('研发部','广州'),
                                    ('销售部', '深圳');

# 员工表(从表)，创建从表前应该先创建主表
drop table if exists employee;
create table employee (
                     id int primary key auto_increment, # 员工id，主键（非空和唯一），且自增长
                     name varchar(50) not null unique, # 员工姓名，非空并且唯一
                     join_date date not null , # 入职日期，非空
                     salary double(7,2) not null , # 工资，非空
                     bonus double(7,2) default 0, # 奖金，如果没有奖金默认为0
                     department_id int,

                     # 添加外键 department_id,关联 department 表的id主键
                     constraint fk_emp_dept foreign key(department_id) references department (id) # fk_emp_dept为外键名称
)auto_increment 100;# 设置自增长的起始值

# 删除外键
-- alter table department drop foreign key fk_emp_dept;

# 建完表后，添加外键
-- alter table department add constraint fk_emp_dept foreign key(department_id) references department(id);

insert into employee (name, join_date, salary,bonus,department_id) values
                                                           ('张三','1999-11-11',8800,5000,1),
                                                           ('李四','1999-11-11',8800,5000,2),
                                                           ('王五','1999-11-11',8800,5000,1),
                                                           ('赵六','1999-11-11',8800,5000,2);
# 指定自增长后还是可以手动赋值
# insert into employee(id,name,join_date,salary,bonus,department_id) values(2,'张三','1999-11-11',8800,5000,1);

-- 表的多对多关系
/*
   多对多：
      * 如：订单 和 商品
      * 一个商品对应多个订单，一个订单包含多个商品

   实现方式：建立第三张中间表，中间表至少包含两个外键，分别关联两方主键
*/
# 订单表
drop table if exists tb_order;
create table tb_order(
                         id int primary key auto_increment,
                         payment double(10,2),
                         payment_type tinyint,
                         status tinyint
);
# 商品表
drop table if exists tb_goods;
create table tb_goods(
                         id int primary key auto_increment,
                         title varchar(100),
                         price double(10,2)
);
# 订单商品中间表
drop table if exists tb_order_goods;
create table tb_order_goods(
                               id int primary key auto_increment,
                               order_id int,
                               goods_id int,
                               count int
);
# 建完表后，添加外键
alter table tb_order_goods add constraint fk_order_id foreign key(order_id) references tb_order(id);
alter table tb_order_goods add constraint fk_goods_id foreign key(goods_id) references tb_goods(id);