### 百度

- ddl事务
- Oracle dump函数
- greatest函数（和max的区别？）
- usernv
- vsize
- interval

### 0 注意事项

- 当使用日期是,需要注意如果有超过5位小数加到日期上, 这个日期会进到下一天!
- 常用日期格式 ‘YYYY-MM-DD HH24:MI:SS’
- 在FORM中使用系统日期$$DBDATE$$ ;(不带时间的日期),$DBDATETIME$$ ;(带时间的日期),不带时间的item的 legth=11，带时间的item的 legth=20。

### 1、name_in

系统提供了NAME_IN的功能让我们可以根据一个变量字符串去访问控件。当需要用统一的代码来控制一组控件，而这多个控件的名称有一定规则，可根据不同的控件名称产生相应的功能的时候，用NAME_IN可以很方便的集成此控件组。

### 2、copy

### 3、显示隐藏画布

show_view('canvas name')    hide_view('canvas name')

### 4、form 内调用触发器

excute_trigger('pre_record');

### 5、并发涉及到的表

并发处理架构中所涉及到的数据库表：

- fnd_concurrent_requests:详细的请求运行信息，包括状态、开始时间和完成时间
- fnd_concurrent_programs:并发程序的详细信息
- fnd_concurrent_processes: 并发管理器过程的历史信息和并发请求之间交叉引用的信息
- fnd_concurrent_queues: 每个并发管理器队列的信息

### 6、form异常处理

​	使用fnd_message来显示错误信息

```plsql
IF (error_condition) THEN
fnd_message.set_name(appl_short_name,
message_name);
fnd_message.error;
RAISE FORM_TRIGGER_FAILURE;
END IF;
```

### 7、设置回滚点

```plsql
Declare
      SAVEPOINT  point1;
      ……
   Exception
      When others then
ROLLBACK TO SAVEPOINT point1
   End;
```

### 8、模拟登录

通常我们使用

```plsql
BEGIN 
             fnd_global.APPS_INITIALIZE(user_id => 0, resp_id => 20419, resp_appl_id=> 0) ;
         END ;
```

来模拟登录，resp_id 代表职责id，resp_appl_id（不知道）

上面的参数在ebs中，help，检查，块$PROFILES$中查找