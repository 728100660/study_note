



### 1、 report builder   xml    report

​	在xml  管理员职责下，定义数据源（与请求关联，从定义的请求中获取数据源）和模板，具体参考hand 学院任务3；在调用请求的时候就是调用通过这个数据源和模板生成的report，注意，中英文目录都应该有相应的模板文件。



### 2、 plsql 生成 xml

​	创建可执行，方法为plsql 对应方法

​	创建请求，并且设置参数，为plsql main 方法的参数，定义值集（系统管理员，应用产品，验证，请求集定义，参考任务4），值集 类似lov（拼接各个位置的设置，成为一个sql），查询条件与其它请求集关联，where  *** = :$FLEX$.CUX_ORG_NAME（值集名字）。

​	同一个数据源可以定义多个模板，   模板也可以定义多语言版本



​	

### 3、BIP   report 

​	XML数据源通过自己定义	

​	定义程序的时候不需要定义可执行，可执行名称一定要选择XDODTEXT

![image-20201229163327755](C:\Users\72810\AppData\Roaming\Typora\typora-user-images\image-20201229163327755.png)

​	定义数据源，将上面自己写的xml 文件上传到数据定义的 数据模板中

![image-20201229164119854](C:\Users\72810\AppData\Roaming\Typora\typora-user-images\image-20201229164119854.png)

​	数据源如何与 并发程序关联？

​	猜测：可能是通过数据代码名字和并发程序的简称关联

### 4、手动添加模板元素

​	复制其他元素，在帮助元素中，修改成你要添加的数据源item名字即可

### 5、主机类型并发	请求

![image-20201229172242157](C:\Users\72810\AppData\Roaming\Typora\typora-user-images\image-20201229172242157.png)

​	用于运行shell 脚本，

​	shell脚本编写的时候，如果在windows 上面编写上传到linux 服务器上面，可能会因为编码问题报错，改为unix格式即可

### 6、并发请求错误查看

​	如果报错，先看并发请求得log，一般报错日志会写到 系统管理员下并发，管理，管理中的opp（输出处理程序）中，选中后，选择process，再选择manager log

![image-20201230143137848](C:\Users\72810\AppData\Roaming\Typora\typora-user-images\image-20201230143137848.png)

### 7、注意事项

#### 	7.1 请求报错

​	可能会报一个ref 未定义却被使用的错误，原因：下载过高版本的BI Publisher  解决办法：

```
o resolve the issue, test the following steps in a development instance and then migrate accordingly:

1. On the "Build" tab, set "Backward Compatible" for "Form Field Size" for the BI Publisher Desktop Integrator

2. Retest the XML Publisher concurrent request and confirm the output is generated correctly.
```

#### 	7.2 输出

​	增加输出文件的打开方式 系统管理员->安装->浏览器选项 添加对应的方式即可

​	设置默认查看方式    系统管理员->配置文件->系统->用户（输入当前用户）->配置文件查找%浏览%，再用户栏添加默认应用即可    （参考任务11）

### 8、ebs管理器结构

​	内部管理器：

- 标准管理器
- opp（输出处理器）

重启管理器

applmgr
cd $ADMIN_SCRIPTS_HOME
./adcmctl.sh stop apps/apps
ps -elf | grep FNDLIBR | grep -v grep |wc -l         FNDLIBR 是内部管理器的运行标识符        -v 排除grep字符，   wc -l 计数
显示为0 后
./adcmctl.sh start apps/apps