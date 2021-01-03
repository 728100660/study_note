

## 1、疑问

- java四种引用类型

- 结构体？

- 可变数组ArrayList 

  ```java
  import java.util.ArrayList; // 引入 ArrayList 类
  
  ArrayList<E> objectName =new ArrayList<>();　 // 初始化
  //e为引用数据类型，可以是int嘛？
  ```

- instanceof 是？   assert 用法？  

- 注解是什么玩意，运行机制？  @data  @AllArgsConstructor @NoArgsConstruct    lombol

- .class是？

## 2、知识积累

- string.trim()  //删除字符串首尾空格
- string.charAt(i)//去除字符串i位置的字符
- ! = ' '判断不等于空格 
- null 空
- 一个类可以又多个构造方法
- 静态代码块只会执行一次，static对象在内存中只有一个副本，可以用于优化性能

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

## 8、笔试题

### 8.1

![image-20210102103549680](C:\Users\pxz\AppData\Roaming\Typora\typora-user-images\image-20210102103549680.png)

### 8.2

```java
public class Test {
    Person person = new Person("Test");
    static{
        System.out.println("test static");
    }
    public Test() {
        System.out.println("test constructor");
    }
    public static void main(String[] args) {
        new MyClass();
    }
}
 
class Person{
    static{
        System.out.println("person static");
    }
    public Person(String str) {
        System.out.println("person "+str);
    }
}
 
class MyClass extends Test {
    Person person = new Person("MyClass");
    static{
        System.out.println("myclass static");
    }
    public MyClass() {
        System.out.println("myclass constructor");
    }
}
```

解析：类似地，我们还是来想一下这段代码的具体执行过程。首先加载Test类，因此会执行Test类中的static块。接着执行new MyClass()，而MyClass类还没有被加载，因此需要加载MyClass类。在加载MyClass类的时候，发现MyClass类继承自Test类，但是由于Test类已经被加载了，所以只需要加载MyClass类，那么就会执行MyClass类的中的static块。在加载完之后，就通过构造器来生成对象。而在生成对象的时候，必须先初始化父类的成员变量，因此会执行Test中的Person person = new Person()，而Person类还没有被加载过，因此会先加载Person类并执行Person类中的static块，接着执行父类的构造器，完成了父类的初始化，然后就来初始化自身了，因此会接着执行MyClass中的Person person = new Person()，最后执行MyClass的构造器。

答案：

```java
test static
myclass static
person static
person Test
test constructor
person MyClass
myclass constructor
```

### 8.3

```java
public` `class` `Test {
  
  ``static``{
    ``System.out.println(``"test static 1"``);
  ``}
  ``public` `static` `void` `main(String[] args) {
    
  ``}
  
  ``static``{
    ``System.out.println(``"test static 2"``);
  ``}
}
```

```java
//解析：虽然在main方法中没有任何语句，但是还是会输出，原因上面已经讲述过了。另外，static块可以出现类中的任何地方（只要不是方法内部，记住，任何方法内部都不行），并且执行是按照static块的顺序执行的。
test static 1
test static 2
```