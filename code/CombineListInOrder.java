package interview_questions;

import java.util.Scanner;

public class CombineListInOrder {

	/**
	 * @param args
	 */
	
	public static ListNode LinkedList(){
		char ch;
		ListNode p, t;
		ListNode h = new ListNode();
		h.m_pNext = null;
		t = h;
		Scanner input = new Scanner(System.in);
		System.out.println("Please input value of listnode to create a list :");
		String str = input.nextLine();
		int i = 0;
		while (i < str.length()){
			ch = str.charAt(i);
			p = new ListNode();
			p.m_nValue = ch;
			p.m_pNext = null;
			t.m_pNext = p;
			t = p;
			i++;
		}
		return h;
	}
	
	public static ListNode Merge(ListNode pHead1, ListNode pHead2){
		//当第一个链表pHead1为空链表时,合并链表得到第二个链表pHead2
		//如果pHead1和pHead2都是空链表,那么返回pHead2也会得到null
		if (pHead1 == null)
			return pHead2;
		//当第二个链表pHead2为空链表时,合并链表得到第一个链表pHead1
		if (pHead2 == null)
			return pHead1;
		
		//定义pMergedHead为合并链表的头结点,并初始化为null
		ListNode pMergedHead = null;
		
		//当pHead1的结点值小于pHead2时
		//pHead1为未合并结点得到的链表的头结点
		if (pHead1.m_nValue < pHead2.m_nValue){
			//修改头结点pMergedHead为pHead1
			pMergedHead = pHead1;
			//继续比较两条链表的头结点
			//pHead1的下一个结点与pHead2的头结点做比较
			//得出头结点的下一个结点
			pMergedHead.m_pNext = Merge(pHead1.m_pNext, pHead2);
		}
		//当pHead1的结点值大于等于pHead2时,同上分析
		else {
			pMergedHead = pHead2;
			pMergedHead.m_pNext = Merge(pHead1, pHead2.m_pNext);
		}
		
		return pMergedHead;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("list1");
		ListNode list1 = LinkedList();
		list1 = list1.m_pNext;
		System.out.println("list2");
		ListNode list2 = LinkedList();
		list2 = list2.m_pNext;
		
		ListNode mergelist = Merge(list1, list2);
		System.out.println("mergelist:\t\t" + mergelist);
		
		if (mergelist != null)
			System.out.println("mergelist.m_nValue:\t" + mergelist.m_nValue);
		else
			System.out.println("mergelist.m_nValue:\t" + null);
				
		while (mergelist != null){
			System.out.printf("%c\t", mergelist.m_nValue);
			mergelist = mergelist.m_pNext;
		}	
	}

}
