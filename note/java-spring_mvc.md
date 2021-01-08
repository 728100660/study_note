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



