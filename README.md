# interview_questions
This is summary of the learning of interview_questions.  
  
  
## 1. DeleteListNode_1_18.java
* **题目要求**
  * DeleteListNode_1_18.java  是第18道面试题的代码，要求在O(1)时间内删除链表结点  
* **题目分析**
  * 难点: 在于时间复杂度的控制，按常规删除结点的方法，需要遍历链表，时间复杂度为O(n)  
  * 技巧: 在时间复杂度为O(1)的情况下，我们想删除一个结点并不一定要删除这个结点本身  
         _可以先把下一个结点的内容复制出来覆盖被删除结点的内容，然后把下一个结点删除_
* **情况分析**  
  * _代码基于假设：要删除的结点在链表中_  
  * 从有多个结点的链表的中间删除一个结点  
  pToBeDeleted.m_pNext != null  
  * 从有多个结点的链表中删除头结点  
  pToBeDeleted.m_pNext != null  
  * 从有多个结点的链表中删除尾结点  
  pNode.m_pNext != pToBeDeleted  
  * 从只有一个结点的链表中删除唯一的结点  
  pListHead == pToBeDeleted  
  * 链表为空或要删除的结点为空  
  pListHead == null || pToBeDeleted == null  
    
## 2. DeleteListNode_2_18.java  
* **题目要求**  
  * DeleteListNode_2_18.java  是第18道面试题的代码，要求删除链表中重复的结点  
* **题目分析**
  * 难点: 要确保当前结点的前一个结点始终与下一个没有重复的结点连接在一起  
         _需要对头结点与后面结点重复的情况做特殊处理(详见具体代码分析)_  
         
## 3. ReMatch.java  
* **题目要求**  
  * ReMatch.java  是第19道面试题的代码,要求编写函数实现正则表达式的匹配(字符串和模式的匹配)  
  *  '.' 表示任意一个字符,而 '*' 表示它前面的字符可以出现任意次(含0次)  
* **题目分析**  
  * 要点: (1) 当字符串中的字符和模式中的字符相匹配时,接着匹配后面的字符  
    (2) 当模式中出现字符 '*' 时,可以在模式上向后移动两个字符,也可以保持模式不变  
* **编程小结**  
  * 之所以书中的代码运行后会报错,  
    是因为书中的str指向str.charAt(0),pattern指向pattern.charAt(0);  
    而字符串的检测向后移一位,也只需要str+1即可;  
    所以代码出错的主要原因是把对str == "\0" && pattern == "\0"的判断理解为空字符串的处理.  
    事实上这一语句的判断是判断单个字符是否为'\0',是整个字符串遍历结束的标志.  
    在C语言中,'\0' 是字符串的结束符，任何字符串之后都会自动加上'\0'.  
    但Java定义的字符串的最后一位并不是'\0',这样无法判断字符串的遍历是否结束,  
    所以在main函数里面定义完str和pattern后,要在两个字符串后面再加上"\0",  
    确保能够判断字符串的遍历是否结束,从而返回相应的Boolean值.  
      
## 4. NumericString.java  
* **题目要求**  
  * NumericString.java  是第20道面试题的代码,要求编写函数判断字符串是否表示数值  
* **题目分析**  
  * 要点: 涉及或(||)和与(&&)的使用  
* **情况分析**  
  * 表示数值的字符串遵循模式 A[.[B]][e|EC] 或 .B[e|EC]  ,如字符串"123.45e+6"
  * A代表小数点前面部分,可带正负号(也可以没有)  
  * B代表小数点后,指数e前的部分,不可带正负号  
    当遇到小数点 '.' 时,开始扫描B部分  
  * C代表指数e后面部分,可带正负号(也可以没有)  
    当遇到 'e' 或 'E' 时,开始扫描C部分  
* **编程小结**  
  * 书中的代码使用*str,**str和&str,有'整型变量的指针类型'和'整型变量的指针的指针类型（二级指针）'的使用,  
    但Java没有该数据类型的使用,所以无法直接用str扫描当前所在字符.  
    为了解决这个问题,根据Java实际情况,代码中定义了字符串_str_,用以实时记录str移动到的位置.  
    
## 5. ReorderArray.java  
* **题目要求**  
  * ReorderArray.java  是第21道面试题的代码,要求编写函数调整数组顺序使奇数位于偶数前面  
* **题目分析**  
  * 思路: 从头扫描数组,遇到偶数,将该数拿出,移动后面所有数字,并把该数放到数组最后一个位置,直到整个数组扫描结束.  
    这个方法能够实现题目要求,但时间复杂度为O(n*n),应该从时间复杂度方面考虑优化.  
  * 技巧: 借鉴Java数据结构中排序的方法,可设置两个变量,分别从数组第一位和数组最后一位开始遍历,这样就不需要大部分数组元素的移动. 
