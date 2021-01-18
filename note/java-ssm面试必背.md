### 1、spring mvc 的特点

Spring Mvc Framework 有这样一些特点

他是基于组件技术的，全部的应用对象，无论控制器和视图，还是业务对象之类的都是java组件，并且和Spring提供的其他基础结构紧密集成，它不依赖于ServletAPI（目标虽是如此，但是在实现的时候确实是依赖于Servlet的）可以任意使用各种视图技术，而不仅仅局限于JSP；支持各种请求资源的映射策略；Spring MVC是易于扩展的 

### 2、Spring MVC的工作流程

- 用户发送请求至前端控制器DispatcherServlet
- DispatcherServlet收到请求并调用HanderMapping处理映射器
- 处理映射器根据接受到的url去找到具体的  ~~handle~~ 处理器，**生成处理器对象和处理器拦截器（如果有则生成）**并将对象一并  ~~handle~~  返回给DispatcherServlet
- DispatcherServlet通过HandlerAdapter处理适配器调用处理器
- Controller执行处理器（也叫做后端控制器）
- Controller执行完之后返回ModelAndView
- HandlerAdapter将接收的ModelAndView返回给DispatcherServlet
- DispatcherServlet将接收到的ModelAndView交给ViewResolver视图解析器解析
- ViewResolver将解析得到具体的view，并返回给DispatcherServlet
- DispatcherServlet收到具体的view对view进行渲染视图（将模型数据填入到视图之中）
- DispatcherServlet响应用户

### 3、Spring和Struts2的区别



### 4、ssm 的优缺点、使用场景



### 5、Mybatis

​	mybatis 的理解



### 6、Spring在ssm中的作用

Spring 是一个轻量级的框架，是一个ioc/di容器，Spring从实质上来讲就是一个bean工厂，主要用来维护和管理bean的生命周期和框架的集成。**Spring 的顶层容器为BeanFactory，常用的ApplicationContext为他的常用子接口**，关于spring，最重要的就是ioc（控制反转）和AOP

### 7、怎样理解IOC和DI

IOC和DI其实就是同一个概念的不同描述，由于IOC控制反转的概念有些模糊，所以后面就提出了更容易理解的DI。

- 谁依赖了谁：应用程序依赖容器
- 为什么需要依赖：应用程序需要容器来提供对象需要的外部资源
- 谁注入谁：IOC容器注入对象，以及对象依赖的对象
- 注入了什么：注入了应用程序对象和依赖的外部资源（依赖对象，常量数据，资源等）

为什么要叫做控制反转：有反转，那么就有正转，按照传统的编程思维，都是由应用程序自己去主动获取资源，这是所谓的正转。在Spring 中，所有的对象获取资源都是由spring创建并提供的，是被动接收的，因此叫做控制反转。因此可以达到降低对象间的耦合度的目的，让代码更加清晰。

### 8、IOC的作用



### 9、Spring的配置文件有哪些内容



### 10、Spring中常用的注解



### 11、为什么要用Spring

降低对象的耦合度，让代码更加清晰（并且提供一些常见的模板）



### 12、Spring DI注入的常用方式

- <constractor-arg name = "dao"/>使用构造器的方法注入

- <property name="dao"  ref = "dao2"/>通过setter 的方法初始化注入

  在实际开发中，通常使用setter的方法注入。

### 13、问题

**（1）SpringMvc的控制器是不是单例模式,如果是,有什么问题,怎么解决**
	是单例模式,所以在多线程访问的时候有线程安全问题,不要用同步,会影响性能的,解决方案是在控制器里面不能写字段

**(2)SpingMvc中的控制器的注解**
	@Controller 注解：该注解表明该类扮演控制器的角色，Spring不需要你继承任何其他控制器基类或引用Servlet API。

**(3)@RequestMapping注解用在类上面有什么作用**
	该注解是用来映射一个URL到一个类或一个特定的方处理法上。

**(4) 我想在拦截的方法里面得到从前台传入的参数,怎么得到**
	直接在形参里面声明这个参数就可以,但必须名字和传过来的参数一样

**(5)如果前台有很多个参数传入,并且这些参数都是一个对象的,那么怎么样快速得到这个对象**
	直接在方法中声明这个对象,SpringMvc就自动会把属性赋值到这个对象里面

**(6)SpringMvc中函数的返回值是什么**
	返回值可以有很多类型,有String, ModelAndView,List,Set等,一般用String比较好,如果是AJAX请求,返回的可以是一个集合（或者可以是一个JSON字符串？）

**(7)SpringMvc怎么处理返回值的**
	SpringMvc根据配置文件中InternalResourceViewResolver(内部资源视图解析器)的前缀和后缀,用前缀+返回值+后缀组成完整的返回值

**(8)SpringMVC怎么样设定重定向和转发的**
	在返回值前面加”forward:”就可以让结果转发,譬如”forward:user.do?name=method4” 在返回值前面加”redirect:”就可以让返回值重定向,譬如”redirect:[http://www.uu456.com](http://www.uu456.com/)”

**(9)SpringMvc中有个类把视图和数据都合并的一起的,叫什么**
	ModelAndView

**(10)怎么样把数据放入Session里面**（重点？）
	可以声明一个request,或者session先拿到session,然后就可以放入数据,或者可以在类上面加上@SessionAttributes注解,里面包含的字符串就是要放入session里面的key

**(11)SpringMvc怎么和AJAX相互调用的**
	通过Jackson框架就可以把Java里面的对象直接转化成js可以识别的Json对象 具体步骤如下 :
	1.加入Jackson.jar
	2.在配置文件中配置json的映射
	3.在接受Ajax方法里面可以直接返回Object,List等,但方法前面要加上@ResponseBody注解

**（12)什么是mybatis的接口绑定，有什么好处**

​	接口映射就是在IBatis中定义接口，然后将接口中的方法与sql语句绑定，这样，相比传统的sqlsession的方法，我们可以有更加灵活的选择和设置。

**(13)什么情况下用注解绑定，什么情况下用xml绑定**

​	当sql语句比较简单的情况下，用注解绑定；当sql 变得复杂的时候，用xml绑定，一般选择用xml绑定；

**(14)如果要查询的表名和返回的实体Bean对象不一致，那你是怎么处理的？**

​	在MyBatis里面最主要最灵活的的一个映射对象的ResultMap,在它里面可以映射键值对, 默认里面有id节点,result节点,它可以映射表里面的列名和对象里面的字段名. 并且在一对一,一对多的情况下结果集也一定要用ResultMap。

**(15)MyBatis在核心处理类叫什么**
	MyBatis里面的核心处理类叫做SqlSession

**(16)讲下MyBatis的缓存**
	MyBatis的缓存分为一级缓存和二级缓存,一级缓存放在session里面,默认就有,二级缓存放在它的命名空间里,
默认是打开的,使用二级缓存属性类需要实现Serializable序列化接口(可用来保存对象的状态),可在它的映射文件中配置

**(17)MyBatis(IBatis)的好处是什么**

- IBatis把sql语句从java源程序中分离出来，单独放在xml文件之中编写，为程序后续的维护提供了很大的便利；
- ibatis封装了底层JDBC API的调用细节，并能将结果集转换成javabean对象，大大简化了java数据库编程的复杂操作，而且ibatis需要开发人员编写sql，开发人员可以根据数据库自身的特点去灵活控制sql语句，因而实现比hibernate等全自动orm框架更加高效的sql查询

**(18)MyBatis怎么配置一对多？**
     一对多的关系 ：property: 指的是集合属性的值, ofType：指的是集合中元素的类型

**(19)MyBatis怎样配置多对一？**
     多对一的关系：property: 指的是属性的值, javaType：指的是属性的类型