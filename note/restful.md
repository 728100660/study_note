restful风格	

高效，便捷安全

## 1、改变url传参形式

​	1.1、普通     http://localhost:8080/hello?a=1&b=2

​	1.2、 restful  http://localhost:8080/hello/1/2

​	作用，安全，无法通过url看出你做出的操作以及参数名字

资源：互联网所有的事务都可以被抽象作为资源

资源操作：POST（更新），DELETE（删除）， PUT（新增）， GET（查询）



## 2、请求方法控制操作

可以通过不同的请求方式完成不同的操作

```java
@requestmapping      //匹配所有方法，通过method指定要匹配的方法
@GetMapping 		//匹配get方法
省略。。。
```

