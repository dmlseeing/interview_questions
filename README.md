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
         _需要对头结点与后面结点重复的情况做特殊处理_  
         
## 3. ReMatch.java
* **代码学习小结**  

  之所以书中的代码运行后会报错,  

  是因为书中的str指向str.charAt(0),pattern指向pattern.charAt(0);  

  而字符串的检测向后移一位,也只需要str+1即可;  

  所以代码出错的主要原因是把对str == "\0" && pattern == "\0"的判断理解为空字符串的处理  

  事实上这一语句的判断是判断单个字符是否为'\0',是整个字符串遍历结束的标志  

  在C语言中,'\0' 是字符串的结束符，任何字符串之后都会自动加上'\0'  

  但Java定义的字符串的最后一位并不是'\0',这样无法判断字符串的遍历是否结束,  

  所以在main函数里面定义完str和pattern后,要在两个字符串后面再加上"\0",  

  确保能够判断字符串的遍历是否结束,从而返回相应的Boolean值 
