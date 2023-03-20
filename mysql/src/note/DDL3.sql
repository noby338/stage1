-- 数据库定义语言，表之间的关系

-- 表与表之间的一对多关系
# 部门表（主表）
drop table if exists department;
create table department
(
    id       int primary key auto_increment,
    dep_name varchar(20),
    address  varchar(20)
);
insert into department(dep_name, address)
values ('研发部', '广州'),
       ('销售部', '深圳');

# 员工表(从表)，创建从表前应该先创建主表
drop table if exists employee;
create table employee
(
    id            int primary key auto_increment,                                 # 员工id，主键（非空和唯一），且自增长
    name          varchar(50)  not null unique,                                   # 员工姓名，非空并且唯一
    join_date     date         not null,                                          # 入职日期，非空
    salary        double(7, 2) not null,                                          # 工资，非空
    bonus         double(7, 2) default 0,                                         # 奖金，如果没有奖金默认为0
    department_id int,

    # 添加外键 department_id,关联 department 表的id主键
    constraint fk_emp_dept foreign key (department_id) references department (id) # fk_emp_dept为外键名称
);
insert into employee (name, join_date, salary, bonus, department_id)
values ('张三', '1999-11-11', 8800, 5000, 1),
       ('李四', '1999-11-11', 8800, 5000, 2),
       ('王五', '1999-11-11', 8800, 5000, 1),
       ('赵六', '1999-11-11', 8800, 5000, 2);


-- 表的多对多关系
/*
   多对多：
      * 如：订单 和 商品
      * 一个商品对应多个订单，一个订单包含多个商品

   实现方式：建立第三张中间表，中间表至少包含两个外键，分别关联两方主键
*/
# 订单表
drop table if exists `order`;
create table `order`
(
    id           int primary key auto_increment,
    payment      double(10, 2),
    payment_type tinyint,
    status       tinyint
);
insert into `order` (id, payment, payment_type, status)
values (1,17998,1,1),
       (2,60,1,1);
# 商品表
drop table if exists good;
create table good
(
    id        int primary key auto_increment,
    title     varchar(100),
    price     double(10, 2),
    inventory int #库存
);
insert into good(id, title, price, inventory)
values (default, 'iphone13', 8999, 100),
       (default, 'pencil', 2, 200),
       (default, 'bag', 30, 400);
# 订单商品中间表
drop table if exists order_good_item;
create table order_good_item
(
    id       int primary key auto_increment,
    order_id int,
    goods_id int,
    count    int,
    foreign key (`order_id`) references `order` (id) on update cascade,
    foreign key (`goods_id`) references good (id) on update cascade
);
insert into order_good_item(id, order_id, goods_id, count)
values (default,1,1,2),
       (default,2,3,1);