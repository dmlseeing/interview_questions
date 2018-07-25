# interview_questions
This is summary of the learning of interview_questions.




DeleteListNode_1_18.java  是第18道面试题的代码，要求在O(1)时间内删除链表结点

这道题的难点在于时间复杂度的控制，按常规删除结点的方法，需要遍历链表，时间复杂度为O(n)；

！！！在时间复杂度为O(1)的情况下，提示我们想删除一个结点并不一定要删除这个结点本身

（可以先把下一个结点的内容复制出来覆盖被删除结点的内容，然后把下一个结点删除）

需要考虑的情况有五种：

1.（一般情况）从有多个结点的链表的中间删除一个结点（pToBeDeleted.m_pNext != null）

2.从有多个结点的链表中删除头结点（pToBeDeleted.m_pNext != null）

3.从有多个结点的链表中删除尾结点（pNode.m_pNext != pToBeDeleted）

4.从只有一个结点的链表中删除唯一的结点（pListHead == pToBeDeleted）

5.链表为空或要删除的结点为空（pListHead == null || pToBeDeleted == null）

（代码基于假设：要删除的结点在链表中）
