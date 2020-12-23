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