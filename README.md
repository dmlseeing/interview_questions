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
    这个函数关键的点就是pBegin和pEnd的修改以及数组元素交换的方法.  
  * 要点: 如果pBegin位的数字为偶数,而pEnd位的数字为奇数,则交换这两个数字  
* **编程小结**  
这道编程题比较简单,不过有两点值得注意:  
  * 数组长度的输入: 输入数组前需先输入数组长度,才能够定义数组  
  * 类变量的定义: (是否使用static的区别)  
    由于代码中ReorderOddEven()函数没有定义为static,所以调用该方法前应该定义一个变量.  
    如果函数定义为static,则可以直接使用ReorderOddEven()方法.  
      
## 6. ReorderArrays.java  
* **题目要求**  
  * ReorderArrays.java  是第21道面试题的延伸,根据ReorderArray.java扩展的解法,要求所写函数能够解决一系列同类型的调整数组顺序问题.  
* **编程小结**  
  * 代码中新加一个func()方法,根据问题要求修改return值就可以实现不同的调整要求,如:  
    * return array[n] % 2 == 0; 使奇数位于偶数前面  
    * return array[n] > 0; 使负数位于非负数前面  
    * return array[n] % 3 != 0; 使能被3整除的数位于其余不能被3整除的数前面  
  * 根据对同类型的问题分析,func()的参数值可以不用修改,所以当问题要求改变时,只需要修改return值而Reorder()方法不需要更改.  
  * 补充: 对Reorder()函数中四个pBegin < pEnd判断语句的理解  
    * 第一个 while(pBegin < pEnd): 当pBegin < pEnd时,继续扫描数组；当pBegin < pEnd不成立时,结束对数组的扫描  
    * 第二个 while(pBegin < pEnd): pBegin < pEnd是基本要求  
    * 第三个 while(pBegin < pEnd): 可能经过第二个循环后,pBegin < pEnd仍成立,但pEnd--过程该条件不再成立,就不用继续往前扫描了  
    * 第四个 if(pBegin < pEnd): 当pBegin < pEnd不成立时,可以避免元素的错误交换
  
## 7. KthListNodeToTail.java  
* **题目要求**  
  * KthListNodeToTail.java  是第22道面试题的代码,要求根据输入的链表输出该链表中倒数第k个结点.  
* **题目分析**  
  * 思路: 遍历链表两次,先统计出链表总结点数,再找到倒数第k个结点(改进思路: 要求只遍历链表一次)
  * 要点: (1) 定义两个指针实现一次遍历  
    (2) 代码鲁棒性的考虑,要找出代码的潜在风险,并进行相应处理  
* **情况分析**    
  * 输入的pListHead为空指针: 没有对应结点,应返回null
  * 输入的参数k为0: 没有对应的第k个结点,应返回null
  * 输入的以pListHead为头结点的链表的结点总数小于k: 没有对应的第k个结点,应返回null
  * 前两种情况可以直接判断,第三种情况需要在遍历过程进行判断  
* **编程小结**  
  * 这道编程题考察对代码鲁棒性的考虑,对题目所分析的存在潜在风险的情况需要做具体的处理  
  * 定义两个指针的解法是这道题目的编程关键点,也是很多同类型问题的解题思路  
  * 除了上面分析的三种情况,在写输出结点的代码时也涉及鲁棒性,详见代码
  * MiddleListNode.java是该题目的延伸,要求找出链表的中间结点,思路与该题相同  
  * 补充: 创建链表时,键盘输入的str字符串,要用nextLine才能够输入空的链表
