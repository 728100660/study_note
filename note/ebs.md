# EBS工作笔记

### 2021.01.19		

#### 	1、关于报表

​		查询视图的时候，视图一般都会设置数据屏蔽，这个时候需要我们带着环境去查询，如果不模拟登录环境的话，会导致查不出数据，如果要查询视图的话，就需要模拟环境信息。但是，做报表的时候一般不推荐使用视图，因为许多慢查询都是使用视图导致的，点击视图，查看，即可看到视图源码

​	

#### 2、查找弹性域字段对应的数据库字段

首先打开想要找的弹性域窗口，记住窗口名字

![image-20210119162014654](C:\Users\72810\AppData\Roaming\Typora\typora-user-images\image-20210119162014654.png)

 在  段  里面搜索之前的窗口名字，完成之后如下

![image-20210119161657910](C:\Users\72810\AppData\Roaming\Typora\typora-user-images\image-20210119161657910.png)

其中， 列表示的是该弹性域所在视图基表对应的 attribute

#### 3、f11查询

f11进入查询模式，然后，通过检查，设置参数值，再按下ctrl + f11可以通过设置的参数值进行查询

#### 4、project项目

所有的project 项目在pa_projects_all表下

#### 5、form隐藏字段

form中有许多字段被设置成隐藏字段了，将鼠标移至块中的item上，右击->文件夹->显示，即可查看隐藏字段

### 01.20

#### 1、ebs找数据来源

在ebs中检查字段，然后去对应的数据库中无法找到对应的字段

此时应该扒源码了，利用堡垒机连接服务器，在$AU_TOP/forms/ZHS找到对应的form.fmb文件

帮助，关于可以查看当前form对应的fmb源文件

![image-20210120111836857](C:\Users\72810\AppData\Roaming\Typora\typora-user-images\image-20210120111836857.png)

打开form后，在想要的item项对应的块中搜索item，如REQUESTOR，

搜索完之后查看item的属性，看看有没有在哪里设置他，如果没有，就在块级触发器post_query（通过函数设置属性，在post_query是最合适的位置）中查看是否有库函数设置了item属，

![image-20210120112742687](C:\Users\72810\AppData\Roaming\Typora\typora-user-images\image-20210120112742687.png)

搜索调用的程序包，发现是调用的库函数中的程序包，上服务器下载对应的pl/Sql库$AU_TOP/resource

通过form打开库函数，打开程序包，找到对应的函数，搜索item的属性，一步一步追溯，直到找到在哪里赋值了item属性

#### 2、常用表

```sql
select * from hr_operating_units; --业务实体表

select * from org_organization_definitions; --库存组织表

select fu.user_name,ppf.PERSON_ID, ppf.EMPLOYEE_NUMBER, ppf.LAST_NAME, ppf.FULL_NAME
  from PER_PEOPLE_F ppf, fnd_user fu --fu，用户表，ppf员工表（解释，公司员工可能不会有账户--因为员工可能不需要使用该系统，用户也可能不是员工）
 where fu.employee_id = ppf.PERSON_ID
   and sysdate between ppf.EFFECTIVE_START_DATE and
       nvl(ppf.EFFECTIVE_END_DATE, sysdate)
   and ppf.PERSON_ID in (3357,744);

```

查org id   

先在 表    FROM mo_glob_org_access_tmp查找  organization_name，如果没找到

再在hr_operating_units查 name

### 1.21

所有的客户化应用都被挂在超级职责菜单下，      

因此，客户化应用对应的请求都可以在超级职责菜单下提交并发请求



程序包传参： out参数要在前面，in参数在后面，否则可能会报错



值集定义：当参数长度超过参数定义长度时，程序会报错。一个中文长度lengthb()为3



```plsql
--作用，将字符串输出到日志中，
log('p_org_name:' || p_org_name);

```

输出的日志可以通过如下按钮查看

![image-20210121144420247](C:\Users\72810\AppData\Roaming\Typora\typora-user-images\image-20210121144420247.png)



#### sql查询数据过多（数据发散）

​	关联表（a,b表）时，关联条件a.id = b .id 如果b有n个id与a相等，则会产生n条对应的数据

#### sql外键（+）查询（也就是左右连接）

​	一个表使用了外键，其他的附加条件中也要加外键，否则会导致查询数据量变少

如

```plsql

   and prla.UN_NUMBER_ID = poun.UN_NUMBER_ID(+)
   and poun.language(+) = USERENV('LANG')
```

### 1.22

#### 	命名规范

​	l: 本地变量

​	p：程序包过程、函数接收变量

​	x：程序包过程输出变量

​	t：游标接收变量

​	g：全局变量