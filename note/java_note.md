

## 1、疑问

- java四种引用类型

- 可变数组ArrayList 

  ```java
  import java.util.ArrayList; // 引入 ArrayList 类
  
  ArrayList<E> objectName =new ArrayList<>();　 // 初始化
  //e为引用数据类型，可以是int嘛？
  ```

- instanceof 是？   assert 用法？  

## 2、知识积累

- string.trim()  //删除字符串首尾空格
- string.charAt(i)//去除字符串i位置的字符
- ! = ' '判断不等于空格 
- null 空
- 一个类可以又多个构造方法

## 3、命名规范

​	java是大小写敏感的，标识符Hello 与hello 是不同的

​	类名： 类名所有单词首字母大写

​	方法名：第一个单词首字母小写，后米的单词首字母大写

​	源文件名：与类名一致

## 4、java修饰符

- 访问控制修饰符：default，public， protect， private
- 非访问控制修饰符：final， abstract， static， synchronized

## 5、一个类里面的变量

- 局部变量：定义在方法中，在方法或者语句执行完之后会自动销毁，局部变量分配在栈上，局部变量没有默认值
- 成员变量：定义在类中，方法体之外，拥有默认值，数值类型是0，Boolean是false，引用类型为null，成员变量一半设这位私有，通过使用访问修饰符可以使实例变量对子类可见，直接通过变量名访问，但在静态方法以及其他类中，就应该使用完全限定名：objectreference.VariableName。
- 类变量：和成员变量一样，不过多了static 修饰符；无论一个类创建了多少个对象，类只拥有类变量的一份拷贝。使用完全限定名访问。类变量通常通过final 设置为常量。

## 6、java数据类型

### 	1、内置数据类型

- 八种基本数据类型及自动转换：   byte, short, char --> int --> long --> float --> double                         boolean;

### 	2、引用数据类型

​			待定



## 7、java复杂数据类型

### 	7.1 双向队列

​	应用举例   Deque<Integer> deque = new LinkedList<>();   **注意是LinkedList而不是LinkList！！！！！！**

​	常用方法deque.peekFirst(),removeFirst(),removeLast()，isEmpty(),addLast()等