## 0、前言

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



