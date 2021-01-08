### 1、 mybatis(iBatis)简介

​	mybatis 是一个优秀的持久层框架

官网连接https://mybatis.org/mybatis-3/zh/getting-started.html

#### 	1.1 持久化

​	数据持久化

- 持久化就是将程序的数据在持久状态和瞬时状态转化的过程
- 内存：断电即失
- 持久化方式：数据库，io文件持久

####     1.2 持久层

​	完成持久化工作的代码块

#### 	1.3 优点

- 简单易学
- 灵活
- sql和代码分离，提高了可维护性
- 提供映射标签，支持对现象与数据库的orm字段关系映射
- 提供对象关系映射标签，支持对现象惯性组件维护
- 提供xml标签，支持编写动态sql

### 2 搭建项目

#### 	1、新建maven项目

#### 	2、删除src目录

这样主目录就可以当作一个父工程

#### 	3、导入依赖

maven依赖，junit测试单元，mysql驱动，mybatis

#### 	4、编写配置文件

mybatis配置文件（从官网拷贝，更改），environment可以设置多套环境

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<!--核心配置文件，从官网拷贝-->
<configuration>
    <environments default="development">
<!--        environment可以设置多套环境，default选择development-->
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/mybatis?useSSL=true&amp;useUnicode=true&amp;characterEncoding=UTF-8"/>
                <property name="username" value="root"/>
                <property name="password" value="123456"/>
            </dataSource>
        </environment>
    </environments>
        <mappers>
<!--       mapper是实现了dao借口的配置文件-->
        <mapper resource="com/pxz/dao/UserMapper.xml"/>
    </mappers>
</configuration>
```

#### 	5、创建数据库对象

在pojo下建立表对象，属性应该要和数据库中的字段名字保持一致，私有，设置getter，setter，tostring，有参构造，无参构造（无参构造可以什么都不干）

### 3、注意事项 

- ​	导入junit 包要导入最新的release，不然可能会出问题，如@Test报红等

- ​	maven资源过滤问题，在pom.xml中需要添加配置如下

```xml
<build>
   <resources>
       <resource>
           <directory>src/main/java</directory>
           <includes>
               <include>**/*.properties</include>
               <include>**/*.xml</include>
           </includes>
           <filtering>false</filtering>
       </resource>
       <resource>
           <directory>src/main/resources</directory>
           <includes>
               <include>**/*.properties</include>
               <include>**/*.xml</include>
           </includes>
           <filtering>false</filtering>
       </resource>
   </resources>
</build>
```

- ​	每一个mapper.xml（就是实现了dao接口的配置文件）都需要在mybatis核心配置文件中注册

![image-20210102112419685](C:\Users\pxz\AppData\Roaming\Typora\typora-user-images\image-20210102112419685.png)

Mybatis的三个核心接口

![image-20210102113240153](C:\Users\pxz\AppData\Roaming\Typora\typora-user-images\image-20210102113240153.png)

![image-20210102113424588](C:\Users\pxz\AppData\Roaming\Typora\typora-user-images\image-20210102113424588.png)

如果程序执行过程中报错，可能并不会走到我们写的close代码处，因此使用try  catch  finally ，在finally中写关闭sqlsession操作

### 4、dao配置文件 CRUD

步骤，1、编写dao接口，

​			2、编写配置文件

​			3、测试（工具类获取sqlsession，然后getmapper加载接口，然后调用接口方法，关闭sqlsession）

增删改必须提交事务 sqlsession.commit()

参考代码，mybatis-01/src/test/java/com/pxz/dao.UserDaoTest

#### 4.1 select

- id
- resultType    结果类型
- parameterType   传参类型（里面的sql通过#{} 获取参数）

#### 4.2 insert

- 传递多个参数    接口传递的参数选择pojo数据库对象user，xml中~~通过user.parameter~~  直接通过user 中的  属性接收对应的属性 如#{id} 接收用户id（可以用map传参）
- 需要提交事务 sqlsession.commit()
- 定义dao中的接口的时候建议定义一个返回值（不知道在哪里实现的返回）mybatis 会自动把操作的数据条数返回出来， 附：insert没有resultType属性

####  4.3 update

#### 4.4 delete

#### 4.5 通过map传参

当数据库对象字段太多的时候，可以使用这种方法，无需new一个数据库对象

接口定义      public int addUser(Map<String,Object> map)

​						parameterType ="map"

取值通过map中的string直接取值，假如map.put("userid",3)

就通过#{userid}取出对应的值	

### 5、配置解析

mybatis-config.xml中可以配置多套运行环境，切换的时候将default改掉即可

#### 5.1 配置结构

​	configuration（配置）

- [properties（属性）](https://mybatis.org/mybatis-3/zh/configuration.html#properties)
- [settings（设置）](https://mybatis.org/mybatis-3/zh/configuration.html#settings)
- [typeAliases（类型别名）](https://mybatis.org/mybatis-3/zh/configuration.html#typeAliases)
- [typeHandlers（类型处理器）](https://mybatis.org/mybatis-3/zh/configuration.html#typeHandlers)
- [objectFactory（对象工厂）](https://mybatis.org/mybatis-3/zh/configuration.html#objectFactory)
- [plugins（插件）](https://mybatis.org/mybatis-3/zh/configuration.html#plugins)
- environments（环境配置）
  - environment（环境变量）
    - transactionManager（事务管理器）
    - dataSource（数据源）
- [databaseIdProvider（数据库厂商标识）](https://mybatis.org/mybatis-3/zh/configuration.html#databaseIdProvider)
- [mappers（映射器）](https://mybatis.org/mybatis-3/zh/configuration.html#mappers)

#### 5.2 事务管理器

- JDBC（默认）
- MANAGED

#### 5.3 数据源datasource（默认POOLED）

​	用作连接数据库

#### 5.4 properties属性

​	可以动态设置mybatis-config.xml中的属性

通过<properties resource='db.properties'></properties>导入

properties标签内容中也可以设置值，但不推荐，首先加载标签内的，然后再加载resource文件中的属性，如果重复会被覆盖；

![image-20210102173721084](C:\Users\pxz\AppData\Roaming\Typora\typora-user-images\image-20210102173721084.png)

![image-20210102173754792](C:\Users\pxz\AppData\Roaming\Typora\typora-user-images\image-20210102173754792.png)

#### 5.5 别名typeAliases

#### 5.6 mappers     

​	报错MapperRegistry就是这个属性没有注册

​	绑定dao接口的配置xml 文件

​	创建dao下面的xml 文件的时候，尽可能保持xml文件和interface文件同名，且保持在同一个包下

#### 5.7 生命周期和作用域

Mybatis的请求流程

![image-20210103204400389](C:\Users\pxz\AppData\Roaming\Typora\typora-user-images\image-20210103204400389.png)

![image-20210103204619825](C:\Users\pxz\AppData\Roaming\Typora\typora-user-images\image-20210103204619825.png)

每一个mapper代表一个业务（执行sql语句）

​	SqlSessionFactoryBuilder

- 以但创建了SqlSessionFactory，就不需要他了
- 应该设置为局部变量

   SqlSessionFactory

- 想象为数据库连接池
- 一旦创建，一直存在
- 最佳作用域：应用作用域，一个mybatis就一个SqlSessionFactory
- 使用单例模式，或者静态单例模式

​    SqlSession

- 连接到连接池的一个请求
- 不是线程安全的，不能被共享，最佳作用域是请求或者方法作用域
- 用完之后必须关闭，不能浪费资源

### 6 resultMap（重要）

​	之前用resultType设置返回类型，用于处理pojo对象属性和数据库字段不一致的情况

​	简单使用方法

​	![image-20210103210135590](C:\Users\pxz\AppData\Roaming\Typora\typora-user-images\image-20210103210135590.png)

可以只设置不一样的属性，id和name都可以删掉

### 7、 日志

#### 7.1 日志工厂

logImpl

常用SLF4J

![image-20210103214619174](C:\Users\pxz\AppData\Roaming\Typora\typora-user-images\image-20210103214619174.png)