##  0、重点记录

基于java实现的轻量级web框架（核心servlet）

ssm mybatis + spring  + springmvc 

javaSE ：

javaWeb：

ssm框架

springMvc   springcloud  spring boot  linux

spring ： 重点ioc 和 aop

springmvc：springmvc的执行流程

springmvc：ssm框架整合

mvc：model模型（dao数据库交互，service 业务逻辑控制），view视图（jsp），controler控制器（servlet   转发重定向	）；

mvp, mvvm: m  v    vm(viewmodel)



变量命名网站**Codelf**



### 0.1 创建项目步骤：

1. 新建空白maven 项目
2. 删除src目录，并导入依赖

### 0.2 spring mvc 特点

​	简单轻量

​	高效，基于请求响应的mvc框架

​	与spring兼容性好

​	约定优于配置

​	功能强大：restful、数据验证、格式化、本地化、主题等

​	简洁灵活

### 0.3 mvc 请求流程图（面试重点！）

​	实线事mvc 帮我们实现的，虚线是我们需要自己完善的

![image-20201229201543796](C:\Users\pxz\AppData\Roaming\Typora\typora-user-images\image-20201229201543796.png)

​	1 用户的所有请求都会呗dispatcherservlet拦截】

​	2 handlemapping  处理映射，根据url查找处理器

​	3 handlerexecution   将解析后的信息返回给dispatcherservlet 

​	5 handleradapter  处理适配器，按照一定的规则去执行handler，找到controller（所有实现了controller的类或者，呗注解了的）

​	6 controller  调用业务层和数据库，返回ModelAndView

​	9 dispatcherservlet 调用视图解析器veiwresolver（1、得到modelandView数据，2、解析ModelAndView的视图名字，根据规则拼接名字，找到对应的视图 4、将数据渲染到这个视图上面）解析modelAndView

​	12 dispatcherservlet 根据解析器得到的结果，调用具体的视图

### 0.4 WEB-INF目录

​	为什么把视图放在这个目录下面，为了保证视图安全，放置在这个目录下的视图，客户端不能直接访问

### 0.5 注解 

​	@Controller 注解的类，返回的东西会通过视图解析器

​	@RestController注解，返回的不会，前后端分离，返回json数据

​	@RequestMapping("/hello")    匹配路由，可以注解类和方法

​	@Component      组件

​	@Service	service

​	@Controller	controller

​	@Repository	dao

​	@RequestParam("")  //用于接收前端参数

![image-20201229221913517](C:\Users\pxz\AppData\Roaming\Typora\typora-user-images\image-20201229221913517.png)

### 0.6 转发和重定向

​	地址栏url不变是转发，地址栏url变了是重定向

​	springmvc默认使用的是转发，如果需要重定向则需要return "redirect :/ index.jsp"   

redirect 使用的是全限定名路径，使用了redirect之后springmvc是不会走视图解析器的

### 0.7 前端传参

​	1、传递多个参数

​	可以通过封装实体类，实体类与参数名字一一对应，spring帮你自动匹配

### 0.8 过滤器解决乱码

​	过滤器自己手写，视频13集

## 1、三层框架

### 1.1 表现层 springmvc

​	与浏览器交互，接收参数并且相应结果

​	业务处理过程，浏览器-表现层-业务层-持久层，再一级一级返回结果

### 1.2 业务层spring框架

### 1.3 持久层 MyBatis

### 任何响应式框架都离不开response 和 request对象

### 1.4 面试

​	springmvc 和 struts2 的区别

## 2、 创建spring mvc项目

### 2.1快速创建maven项目

​	添加moudle的时候，选择maven项目，创建的时候会自动从网络上下载很多插件，在properties 中添加一对键值对   archetypeCatalog： internal 即可快速创建maven项目

### 2.2 导入json包（使用jackson）

```xml
<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core -->
<dependency>
   <groupId>com.fasterxml.jackson.core</groupId>
   <artifactId>jackson-databind</artifactId>
   <version>2.9.8</version>
</dependency>
```

jackson的使用

```java
//        获取jackson对象
        ObjectMapper mapper = new ObjectMapper();
//        定义结果字符串
        String res = null;
        try {
//            将需要json序列话的对象json序列化并保存到res字符串中
            res = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
//        返回
        return res;	
```



## 3、遇到的坑

### 3.1 

在公司发的电脑上面重新配置环境的时候

报错：Artifact springmvc-01-use:war exploded: Error during artifact deployment.，然后点击了下面框出来的部分就能运行了

![image-20210114153644574](C:\Users\72810\AppData\Roaming\Typora\typora-user-images\image-20210114153644574.png)

### 3.2 ssm整合

​	导入spring  pom.xml依赖的时候，要保证，spring依赖的版本号对应一致，不然在引用的时候可能会报错

![image-20210115165818065](C:\Users\72810\AppData\Roaming\Typora\typora-user-images\image-20210115165818065.png)



### 3.3 404 not found

​	可能原因

- lib包没导入

- controller层没导入

  解决，在mvc核心配置文件中

  ```xml
  <!--自动扫描包，让指定包下面的注解生效-->
  <context:component-scan base-package="com.pxz.controller"/>
  ```

### 3.4 500错误

sql error   Parameter index out of range (1 > number of parameters, which is 0)

明确告诉你这是sql错误sql 写错了

检查sql，在xml中，可能符号写错了，varchar做条件判断时不要加"",or '' 

### 3.5 依赖包问题

在项目创建之后，再新增包，一定要记得导入到项目的lib文件中 

### 3.6 post传参问题

参数传在body中，后台无法接收（网上说要加一个@Requestbody注解，但是加了之后报415错误，无法解决）

参数要传在query中后台才能接收（就相当于get）

### 3.7 命名

数据库字段命名一般是user_name , 不符合驼峰命名规范，在select 要这么写

```mysql
selecet user_name userName from user;	
```

为了避免麻烦，在mybatis的配置文件中添加

```xml
<!--    mybatis开启驼峰命名规则-->
    <settings>
        <setting name="mapUnderscoreToCamelCase" value="true"/>
    </settings>
```

### 3.8 传参报错问题

​	 is present but cannot be translated into a null value due to being declared as a primitive type. Consider declaring it as object wrapper for the corresponding primitive type.

​	可能问题：传参错误，后台未接受到正确的参数类型或者参数个数

​	当让传参允许为空时，（在参数前添加@nullable装饰器的时候，好像不加也可以），参数类型应该定义为Integer之类的包装类，int类型不允许这么做。