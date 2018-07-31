package interview_questions;

import java.util.Scanner;

public class MiddleListNode {

	/**
	 * @param args
	 */
	
	public ListNode LinkedList(){
		char ch;
		ListNode p, t;
		ListNode h = new ListNode();
		h.m_pNext = null;
		t = h;
		Scanner input = new Scanner(System.in);
		System.out.println("Please input value of listnode to create a list :");
		//用nextLine才能够输入空的链表
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
	
	//求链表的中间结点,仍然使用两个指针遍历链表的方法
	public ListNode FindMiddleListNode(ListNode pListHead){
		if (pListHead == null)
			return null;
		
		//pAhead, pBehind两个指针都指向头结点
		ListNode pAhead = pListHead;
		ListNode pBehind = pListHead;
		
		//从头结点开始,第一个指针pAhead走两步,在前面,第二个指针pBehind走一步,在后面
		//当pAhead遍历到链表的最后一个结点,pBehind所指就是链表的中间结点
		while (pAhead.m_pNext != null){
			//第一种方法,当链表结点总数为偶数时,pBehind为中间两个结点的前一个
			pAhead = pAhead.m_pNext;
			if (pAhead.m_pNext != null){
				pAhead = pAhead.m_pNext;
				pBehind = pBehind.m_pNext;
			}
			
			//第二种方法,当链表结点总数为偶数时,pBehind为中间两个结点的后一个
			/*
			pAhead = pAhead.m_pNext;
			pBehind = pBehind.m_pNext;
			if (pAhead.m_pNext != null)
				pAhead = pAhead.m_pNext;
			*/
		}
		
		return pBehind;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiddleListNode link = new MiddleListNode();
		ListNode list = link.LinkedList();
		list = list.m_pNext;
		
		System.out.println("The middle listnode is :");
		System.out.println(link.FindMiddleListNode(list));
		System.out.println("Value of the middle listnode is :");
		if (link.FindMiddleListNode(list) != null)
			System.out.println(link.FindMiddleListNode(list).m_nValue);
		else
			System.out.println("null");
	}

}
