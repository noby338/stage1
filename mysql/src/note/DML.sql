-- 数据库操作语言
-- 数据准备

use stage1;
drop table if exists student;
create table student(
                        id       int,-- 整型，四个字节
                        name     varchar(10),-- 可变长字符串（字符串宽度小于等于10即可）
                        gender   char(1),-- 不可变长字符串
                        birthday date,-- date表示日期，tatetime表示日期和时间
                        score    double(5, 2),-- 5表示数据的总长度，2表示小数点后面的位数
                        email    varchar(64),
                        tel      varchar(15),
                        status   tinyint-- 小整型，1个字节
);



# 插入记录部分字段（value和values无区别）
insert into student(id, name) value (null, 'noby');
# 插入记录的简写，插入全部字段
insert into student
values (2, '张三', '男', '1999-11-12', 88.88, 'lisi@qq.com', '13888888888', 1);
# 同时插入多条记录
insert into student
values (3, '李四', '男', '1999-11-11', 88.88, 'lisi@qq.com', '13888888888', 1),
       (4, '王五', '男', '1999-11-11', 88.88, 'lisi@qq.com', '13888888888', 1),
       (5, '赵六', '男', '1999-11-11', 88.88, 'lisi@qq.com', '13888888888', 1);
# 删除记录
delete
from student
where name = '李四';
# 修改记录
update student
set name = '王二麻子'
where id = 4;