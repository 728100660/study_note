

## 1、疑问

- java四种引用类型

- 结构体？

- 可变数组ArrayList 

  ```java
  import java.util.ArrayList; // 引入 ArrayList 类
  
  ArrayList<E> objectName =new ArrayList<>();　 // 初始化
  //e为引用数据类型，可以是int嘛？
  ```

- instanceof 是？    

  ```java
  obj instanceof Class
  //obj 为一个对象，Class 表示一个类或者一个接口，当 obj 为 Class 的对象，或者是其直接或间接子类，或者是其接口的实现类，结果result 都返回 true，否则返回false。
  ```

- assert 的作用是现计算表达式 expression ，如果其值为假（即为0），那么它终止程序运行。

  ```java
   assert <bool expression>
   //类似于
   if(expression){
   	...
   }
   else{
   	抛出异常;
   }
  ```

  

## 2、知识积累

- string.trim()  //删除字符串首尾空格
- string.charAt(i)//去除字符串i位置的字符
- ! = ' '判断不等于空格 
- null 空
- 一个类可以又多个构造方法

## 3、命名规范

​	java是大小写敏感的，标识符Hello 与hello 是不同的

​	类名： 类名所有单词首字母大写

​	方法名：第一个单词首字母小写，后米的单词首字母大写（驼峰命名）

​	源文件名：与类名一致

## 4、java修饰符

- 访问控制修饰符：default，public， protect， private
- 非访问控制修饰符：final， abstract， static， synchronized

## 5、一个类里面的变量

- 局部变量：定义在方法中，在方法或者语句执行完之后会自动销毁，局部变量分配在栈上，局部变量没有默认值
- 成员变量：定义在类中，方法体之外，拥有默认值，数值类型是0，Boolean是false，引用类型为null，成员变量一般设置为私有，通过使用访问修饰符可以使实例变量对子类可见，直接通过变量名访问，但在静态方法以及其他类中，就应该使用完全限定名：objectreference.VariableName。
- 类变量：和成员变量一样，不过多了static 修饰符；无论一个类创建了多少个对象，类只拥有类变量的一份拷贝。使用完全限定名访问。类变量通常通过final 设置为常量。

## 6、java数据类型

### 	1、内置数据类型

- 八种基本数据类型及自动转换：   byte, short, char --> int --> long --> float --> double                         boolean;

### 	2、引用数据类型

​			待定



## 7、java复杂数据类型

### 	7.1 双向链表

​	应用举例   Deque<Integer> deque = new LinkedList<>();   **注意是LinkedList而不是LinkList！！！！！！**

​	常用方法deque.peekFirst(),removeFirst(),removeLast()，isEmpty(),addLast()等



### 7.2 List（可通过add（）动态添加元素）

​	应用举例   List<String> list = new ArrayList<>();  

​	常用方法，list.add(str), contains(str)

## 8、supper & this

- ​	从本质上讲，this是一个指向本对象的指针，而supper是java中的一个关键字。
- supper指向当前类的直接父类，this指向当前类本身，可以引用成员变量，方法
- this（参数），supper（参数），调用对应对象的对应形参的构造方法
- this(),supper()方法必须在构造方法的第一行，默认隐式调用supper()方法

## 9、异常抛出

继承Exception类，自定义异常类，构造方法调用Exception父类的构造方法

![image-20210104171415051](C:\Users\72810\AppData\Roaming\Typora\typora-user-images\image-20210104171415051.png)