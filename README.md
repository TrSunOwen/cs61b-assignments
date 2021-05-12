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