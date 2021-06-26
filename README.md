# cs61b-assignments

## Proj0

### Planet.java

用到了所学的最基本的java class的构建方法，如何调用方法，静态方法等等。

*   对于基本变量，引用变量，对象等等有了初步深入的认识。

### NBody.java

之前不理解javac XXX.java以及 java XXX的具体用法，也不理解 public static void main(String[] args)。

但是通过proj0对这部分有了稍微深入的理解了。

关于更多，参考https://introcs.cs.princeton.edu/java/15inout/。



总的来说，Proj0很好，虽然工作量不小，但是写完之后收获很大。

另外，java visualizer`是个很好用的东西`。



## Proj1a

### Lined List Deque

用doubly linked list实现 deque，

-   An alternate approach is to implement the list so that it is circular, with the front and back pointers sharing the same sentinel node.

使用哨兵sentinel节点作为起始节点，但是注意它永远不参与任何操作。

注意：

-   每实现一个方法后，检查从sentinel一直next下去看是否回到sentinel，从sentinel一直prev下去看是否回到sentinel。
-   写双向链表的增删方法时，不能只看一个方向，要双向考虑。
-   写删除方法时，要考虑链表为空的情况。



## Proj1b

这个project主要考验Interface的使用，以及简单的assert

我的代码出现的问题是在`Palindrome`中的

```
private boolean isPalindromeHelper(Deque<String> d,  CharacterComparator cc) 
```

无法(char)d.removeLast()

非常奇怪



## HW3

hashCode()和equals()定义在Object类中，这个类是所有java类的基类，所以所有的java类都继承这两个方法。

#### 1.equals

equals要遵守的通用约定（equals方法实现了等价关系）：
1）自反性：x.equals(x)一定返回true
2）对称性：x.equals(y)返回true当且仅当y.equals(x)
3）传递性：x.equals(y)且y.equals(z)，则x.equals(z)为true
4）一致性：若x.equals(y)返回true，则不改变x，y时多次调用x.equals(y)都返回true
5）对于任意的非空引用值x，x.equals(null)一定返回false。
当重写完equals方法后，应该检查是否满足对称性、传递性、一致性。（自反性、null通常会自行满足）



#### 1.2 编写equals开发方法 的建议

当equals参数不属于同一类时，且具有继承关系时，instanceof的检测结果将不满足对称性。
如：c是p的子类,如果在equals中用instanceof检测，那么：
　　p.equals(c) 将返回true；
　　c.equals(p) 将返回false或者抛出异常。
1、显示参数命名为otherobject，稍后强制转换为叫other的变量。
2、检测this==otherobject
3、检测this==null
4、检测getclass()!=otherobject.getclass()
　　如果所有的子类都拥有统一的语义，就使用instanceof检测
　　otherobject instanceof classname
5、将otherobject转换为相应类型的变量
6、比较所有的域
7、若在子类中重新定义了equals开发方法 ，则需在子类中包含调用super.equals(other)

#### 2.hashCode

hashCode()是HashTable、HashMap和HashSet使用的。hashCode()方法被用来获取给定对象的唯一整数。这个整数被用来确定对象被存储在HashTable类似的结构中的位置。**默认的，Object类的hashCode()方法返回这个对象存储的内存地址的编号。**

hash散列算法,使得在hash表中查找一个记录速度变O(1). 每个记录都有自己的hashcode,散列算法按照hashcode把记录放置在合适的位置. 在查找一个记录,首先先通过hashcode快速定位记录的位置.然后再通过equals来比较是否相等。如果hashcode没找到，则必定不equal，元素不存在于哈希表中；即使找到了，也只需执行hashcode相同的几个元素的equal，如果不equal，还是不存在哈希表中。


### Evaluating the ComplexOomage hashCode

For ComplexOomage, it has an Integer's list, its HashCode calculation method is to plus each of this LIST with a 256 and the next number, multiplying 256.

256 is 1 followed by 8 0, and the INT representation is 1 back with 32 0, so the up to four will overflow. So the result of Hashcode depends on the last four numbers in the COMPLExOomage.

We only need to set the last four numbers in the list of each ComplexOMage object to the same way to implement TestWithdeadlyparams.

如上所述，我认为其实是因为param数组最多有4个INTEGER，否则再多的话，total的值就会过大，会导致overflow (hinter.java运行结果告诉我们，256^5已经无法计算了，会显示是0，因为overflow!)