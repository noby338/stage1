-- 事务
-- 数据准备
# 订单表
drop table if exists `order`;
create table `order`
(
    id           int primary key auto_increment,
    payment      double(10, 2),
    payment_type tinyint,
    status       tinyint
);
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


-- 如果在执行某条sql时出现问题，那就应该回滚 删除缓存数据，不让这些数据生效
-- 方式一：通过关闭自动提交后，两条语句执行完后，commit上传

# 关闭自动提交
set autocommit = 0;

# 业务sql
# 减去商品的购买数量，调整库存
update good set inventory=inventory-2 where id=1;
# 添加订单(第二次执行该事务的时候，id为1会冲突，语句执行失败，但上一条语句不会写入数据库)
insert into `order` (id, payment, payment_type, status)
values (1,17998,1,1);
# 添加中间表
insert into order_good_item(id, order_id, goods_id, count)
    values (default,1,1,2);

# 手动提交
commit;
# 开启自动提交
set autocommit = 1;



-- 方式二：手动开启事务

# 开启事务
start transaction;

# 业务sql
# 减去商品的购买数量，调整库存
update good set inventory=inventory-1 where id=3;
# 添加订单(第二次执行该事务的时候，id为2会冲突，语句执行失败，但上一条语句不会写入数据库)
insert into `order` (id, payment, payment_type, status)
values (2,60,1,1);
# 添加中间表
insert into order_good_item(id, order_id, goods_id, count)
values (default,2,3,1);

# 如果业务sql不存在问题，则执行该语句(手动提交，写入sql)
commit;

# 如果业务sql存在问题，则执行该语句(删除缓存数据，不写入sql)
rollback;