## 1 用户

### 	1.1 os 用户

​	Linux操作系统用户，通过shell连接linux操作系统，进行操作（root，appl***， oracle *）

### 	1.2 数据库用户

 	 ebs用户apps，一般用apps进行plsql代码的编辑，创建过程，函数，pkg，进行数据库增删改查等等

### 	1.3  EBS用户

​	sysadmin或者拥有应用开发员和系统管理员职责的等价用户：注册form等各AOL对象、测试form。



## 2 文件

### 	1.1 文件类型

​		 .fmb  forms二进制源文件

​		 .fmx  可执行文件，类似.exe ， 必须在 froms runtime 环境中运行

 		.pll  函数库文件，类似vc中的  .cpp文件

​		 .plx  函数库文件

### 	2.2 文件目录结构

​			![image-20201204201711806](C:\Users\72810\AppData\Roaming\Typora\typora-user-images\image-20201204201711806.png)

| $Au_TOP/RESOURCE                 | pll、plx文件               |
| -------------------------------- | :------------------------- |
| $AU_TOP/forms/US                 | 英文fmb文件                |
| $AU_TOP/forms/<语言代码>         | 特定语种（如ZHS的fmb文件） |
| $<应用简称>_TOP/forms/US         | 各个模块的英文fmb文件      |
| $<应用简称>_TOP/forms/<语言代码> | 特定语种（如ZHS）fmb文件   |

## 3 开发工具安装

### 	3.1 Developer 10 g

### 	3.2 配置TNS 进行数据库连接

### 	3.3 配置formpath

​	formpath 中的路径要包含依赖文件，其中，依赖文件，从$AU_TOP/forms/AU、$AU_TOP/resource里面下载

## 4 初识form builder

### 	4.1 常用的form 对象

![image-20201204203305617](C:\Users\72810\AppData\Roaming\Typora\typora-user-images\image-20201204203305617.png)

![image-20201204203338716](C:\Users\72810\AppData\Roaming\Typora\typora-user-images\image-20201204203338716.png)

#### 	4.1.1 module 对象

​	module 的属性就是整个form的属性

module主要属性有property class  、module name 、first navigation

- property	 class   子类型（类似java，每个对象都有个类型）： module（不可更改）
- module name     对象名，应该与fmb文件名保持一致
- fist navigation     当form 被打开时，光标被定位在哪一个canvas

####       4.1.2 window



### 4.2 form 对象关系图

![image-20201204203424242](C:\Users\72810\AppData\Roaming\Typora\typora-user-images\image-20201204203424242.png)

### 4.3 form 的使用

- form使用前一定记得连接数据库
- 使用template模板的时候拷贝一份副本使用

### 4.4  template模板使用

​	删除data block 下面的两个blockname、detailblock，删除blockname画布，修改blockname，window 属性名称，修改form触发器PRE-FORM,将window 名称改为自己建立的，将，日期，文件，作者改为自己的。修改WHEN-NEW-FORM-INSTANCE，修改文件名，版本，日期；修改程序单元，将your first window改成自己的；

### 4.5 form 的上传编译注册

#### 	4.5.1	form的上传编译

​	将form 文件上传到服务器$CUX_TOP/form/US目录下，进入服务器$AU_TOP/form/US目录下运行frmcmp_batch $CUX_TOP/form/US/your_file_name apps/password output_file = $CUX_TOP/form/US/your_file_name

#### 	4.5.2 form 的注册使用

​	进入ebs 系统 application developer/ form，定义的form名字要与上传编译的文件名字保持一致，选择application，一般选择cux，user form name 自定义， 一般与form name 保持一致，

​	定义function，在description页 ， function名字和form名字一致，user function name 自定义，

​	切换到form页，选择之前定义的form ，加入menu，随便选择一个可用的客户职责A，加入之前定义的func，prompt提示自定义

​	切换到A客户职责，点击使用

## 5 block数据块

​	block数据块中的项目与数据库中的字段一一对应

## 6 canvas 画布

​	画布放置于窗口window上，block中的item放置在canvas画布上，通过画布显示

​	画布分两种，content画布和stack画布，stack画布可以放置滚动条

## 7 window 窗口

### 7.1 primary canvas 属性

​	将primary canvas设置为某一个画布，则window的大小会自动调整为对应的窗口

### 7.2 first navigation data block 属性

​	某个数据块被设置到该属性，window 被打开时，光标停在该数据块的第一个字段上

## 8 触发器

### 8.1 触发器

​	触发器是form中的对象，他是因为某个时间被执行或触发而引起，触发器实际上是一段pl/sql代码。

### 8.2 触发器注意事项

​	编写触发器应该注意的两点

- insert、update和delete语句必须放在事务性触发器中，这些触发器在保存到数据库时触发
- 事务控制语句（commit、rollback、savepoint）不能直接包含在触发器sql中，这些动作由form根据用户发出的命令和内部过程来执行

### 8.3 触发器事件

​	分类

​	进入enter：光标进入某区域

​	退出exit：

​	查询query：在查询记录之前或者之后

​	修改changed：在改变一个数值之前或向数据库中提交、插入、修改、删除之前或者之后。

​	按键key：按下了某功能键

![image-20201210102510183](C:\Users\72810\AppData\Roaming\Typora\typora-user-images\image-20201210102510183.png)

### 8.4 常用触发器

​	![image-20201210102613007](C:\Users\72810\AppData\Roaming\Typora\typora-user-images\image-20201210102613007.png)

## 9 参数parameter

​	parameter 时form级别的参数，外部程序在调用form的时候，可以传递具体的参数值，从而达到对form的某种控制	

## 10 值列表 list

​	list是一种特殊的item（subclass 为list）显示一组预定义的对象，可以由用户选择使用

​	删除列表项 shift + ctl + <

​	list 的三种类型（属性列表选择属性）：弹出列表poplist（最普通），文本列表Tlist(右侧带滚动条)，组合框combo box（与poplist类似，但允许输入）

## 11 lov值列表

​	lov是窗口式值列表，用来限制字段在某一个范围内，这个范围在form中用记录组来表示，记录组通常来源于数据库的表（一段sql）；

​	lov值列表可以赋值给其他没有lov属性的item

​	lov一般是会验证用户输入是否在记录组中，也可不验证

​	lov 有个麻烦的问题，空值不触发验证，如果清空了lov的值，但之前被赋值的item并不会清空，所以需要写代码处理。

## 12 folder 开发注意事项

​	promt块的item设置的顺序，大小要和folder 字段的item顺序一样



## 13 弹性域

​	弹性域注册在form中

![image-20201211145443456](C:\Users\72810\AppData\Roaming\Typora\typora-user-images\image-20201211145443456.png)

## 14 数据库设计

​	保留弹性域字段，is_delete, changed by who。

## **问题记录**

- ​	本地可以先通过该按钮测试form编写是否有错误


![image-20201211143124219](C:\Users\72810\AppData\Roaming\Typora\typora-user-images\image-20201211143124219.png)

- ​	数据块对应的items对应数据库中相应的对象


- ​	显示日历，calendar.show


- ​	检查最后一次执行的sql语句  help， diagnostics,  examine, system, last_query


![image-20201209094701746](C:\Users\72810\AppData\Roaming\Typora\typora-user-images\image-20201209094701746.png)	

- ​	debug：FND_MESSAGE.DEBUG('DDSD');（相当于print）


- ​	注册弹性域字段：在ebs系统注册完之后，要在form中显示，通过唯一标识name关联。


- ​	高级 jtf grid开发


- ​	form builder 中help ， online help 可以查看内置程序和错误码等说明


- ​	ebs中 help， diagnostics， custom code， show custom events 可以查看form运行时触发了那些触发器，以及进行了那些时间等
- ​	form中，在导航栏中，最上面的画布会盖住下面的画布
- 删除列表项 shift + ctl + <
- 导入pll依赖库的时候要选中yes
- 系统遇到不明错误，切换到applmgr用户![image-20201211165617818](C:\Users\72810\AppData\Roaming\Typora\typora-user-images\image-20201211165617818.png)
- 职责添加，切换到系统管理员职责![image-20201211172647492](C:\Users\72810\AppData\Roaming\Typora\typora-user-images\image-20201211172647492.png)
- 配置文件，ebs   系统管理员，配置文件，系统，用户（sysadmin）
- 调试信息：1、plsql 中调用函数， 2、ebs中编辑配置文件   3、查看调试信息fnd_log_messages(调试信息表)
- help  诊断properties ，item 可以查看form 属性![image-20201211192235622](C:\Users\72810\AppData\Roaming\Typora\typora-user-images\image-20201211192235622.png)
- ebs    examine   system 块，  record_status   ，根据当前光标状态触发触发器，  状态有：new（光标没操作，可以离开该item）、insert（已经进行修改，必须将所有要填的字段填写正确光标才可离开,触发on_insert）、query（已查出记录，并未修改）、changed（查出记录，并修改，保存触发on_update，检查到changed之后，马上触发on_lock）等等

## 

## **步骤** 

​	**建表，注册表和字段，生成增删改查api，复制模板文件，改名，删除多余块**

 	**view 不能超过canves的大小**

​	**不要在linux上写空格**

​	**调用hand工具，生成api，生成程序单元**

****

**将文件上传到 $CUX_TOP/forms/US**

**在$AU_TOP/forms/US目录下运行编译命令**

**删除列表项 shift + ctl + <**



int i = 0, j = nums.length - 1;

while(i < j){

}