package interview_questions;

import java.util.Scanner;

public class ReverseList2 {

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
	
	//利用递归的方法实现反转链表
	public static ListNode ReverseList(ListNode pNode, ListNode pPre, ListNode pReversedHead){
		//当传入的链表为空时,直接返回null
		//pReversedHead传入的参数值为null
		if (pNode == null)
			return pReversedHead;
		
		else {
			ListNode pNext = pNode.m_pNext;
			if (pNext == null)
				pReversedHead = pNode;
			pNode.m_pNext = pPre;
			
			//相当于修改pNode为pNext,pPre为pNode
			//继续反转下一个结点
			return ReverseList(pNext, pNode, pReversedHead);		
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode list = LinkedList();
		list = list.m_pNext;
		
		//递归方法传入的参数对递归的实现有影响
		ListNode relist = ReverseList(list, null, null);
		
		System.out.println("relist:\t\t" + relist);
		
		if (relist != null)
			System.out.println("relist.m_nValue:\t" + relist.m_nValue);
		else
			System.out.println("relist.m_nValue:\t" + null);
		
		while (relist != null){
			System.out.printf("%c\t", relist.m_nValue);
			relist = relist.m_pNext;
		}
	}
	
}
