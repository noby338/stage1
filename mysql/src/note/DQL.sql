-- 数据库查询语言，单表查询
/*
 DQL完整语法：
select
    字段列表
from
    表名列表
where
    条件列表
group by
    分组字段
having
    分组后条件
order by
    排序字段
limit
    分页限定
 */
-- 数据准备
use stage1;
drop table if exists stu;
create table stu
(
    id        int,          # 编号
    name      varchar(20),  # 姓名
    age       int,          # 年龄
    sex       varchar(5),   # 性别
    address   varchar(100), # 地址
    math      double(5, 2), # 数学成绩
    english   double(5, 2), # 英语成绩
    hire_date date          # 入学时间
);
insert into stu(id, name, age, sex, address, math, english, hire_date)
values (1, '马运', 55, '男', '杭州', 66, 78, '1995-09-01'),
       (2, '马花疼', 45, '女', '深圳', 98, 87, '1998-09-01'),
       (3, '马斯克', 55, '男', '香港', 56, 77, '1999-09-02'),
       (4, '马斯克', 55, '男', '香港', 56, 77, '1999-09-02'),
       (5, '柳白', 20, '女', '湖南', 76, 65, '1997-09-05'),
       (6, '柳青', 20, '男', '湖南', 86, null, '1998-09-01'),
       (7, '刘德花', 57, '男', '香港', 99, 99, '1998-09-01'),
       (8, '张学右', 22, '女', '香港', 99, 99, '1998-09-01'),
       (9, '德玛西亚', 18, '男', '南京', 56, 65, '1994-09-02');


-- 基础查询
# 查询所有字段，开发中尽量不用
select *
from stu;
# 给查询的结果起别名
select name 名字, age as 年龄, sex
from stu;
# 条件查询
select name, age
from stu
where age > 20;
# 范围（包含两头）
select *
from stu
where hire_date between '1998-1-1' and '1998-12-31';
# 范围，指定个数
select name, age
from stu
where age in (20, 18, 22);
# 等于空的查询方法（不能使用=）
select name, english
from stu
where english is null;
# 模糊查询，_表示单个字符
select name
from stu
where name like '柳_';
# 模糊查询，%表示多个字符
select name, hire_date
from stu
where hire_date like '%09%';
# distinct可去除查询结果中的相同记录（必须name, age, sex都相同），有两个马斯克满足条件
select distinct name, age, sex
from stu
where age = 55;
# 排序，desc表示降序，asc表示升序（默认），当math字段的记录相同时通过english字段进行排序
select name, math, english
from stu
order by math desc, english asc;

-- 聚合函数
/* 所有的聚合函数中null都不参与运算 */
# 统计记录的条数一般用*
select count(*)
from stu;
# min计算中不统计null值
select min(english)
from stu;
select avg(english)
from stu;
select sum(english)
from stu;
# 同时输出其他非聚合函数的字段
select name, math
from stu
where math = (select max(math) from stu);

-- 分组查询
/* 注意：分组之后，查询的字段为聚合函数和分组字段，查询其他字段无意义 */
# 查询男同学和女同学各自的数学平均分，以及各自人数
select sex, avg(math), count(*)
from stu
group by sex;
# 这里的分组字段为sex，查询中输入其他字段将无意义
# 查询男同学和女同学各自的数学平均分，以及各自人数，要求：分数低于70分的不参与分组
select sex, avg(math), count(*)
from stu
where math > 70
group by sex;
# where math > 70 分组前的条件限定（表示参与分组的条件）
# 查询男同学和女同学各自的数学平均分，以及各自人数，要求：分数低于70分的不参与分组，分组之后人数大2
select sex, avg(math), count(*)
from stu
where math > 70
group by sex
having count(*) > 2;
-- having count(*) > 2 分组后的过滤条件（显示分组的条件）
/*
where和having区别：
·执行时机不一样：where是分组之前进行限定，不满足where条件，则不参与分组，而having是分组之后对结果进行过滤。
·可判断的条件不一样：where不能对聚合函数进行判断，having可以。
执行顺序：where>聚合函数>having
 */

-- 分页查询
/* 其实索引=（页码-1）*每页条数 */
select *
from stu
limit 0,3;# 0表示查询的起始记录（0开始），3表示显示的条数
select *
from stu
limit 3,3;# 第二页
select *
from stu
limit 6,3;# 第三页