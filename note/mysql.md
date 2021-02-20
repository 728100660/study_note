```mysql
--查看当前使用的数据库
select database();

--正常创建表之后，设置主键自增
alter table user modify id integer auto_increment;
```

mysql中没有序列，要实现序列，通过建立一张序列表