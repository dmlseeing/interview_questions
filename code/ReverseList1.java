package interview_questions;

import java.util.Scanner;

public class ReverseList1 {

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
	
	public static ListNode ReverseList(ListNode pHead){
		//pReversedHead,反转链表的头结点
		//初始化为null,当传入的pHead为null时,返回null
		ListNode pReversedHead = null;
		//pNode,当前结点,初始化为pHead
		ListNode pNode = pHead;
		//pPrev,当前结点的前一个结点
		//初始化为null,另反转链表的最后一个结点指向null
		ListNode pPrev = null;
		
		while (pNode != null){
			ListNode pNext = pNode.m_pNext;
			
			//当pNext为null时,对应的pNode是原链表的最后一个结点
			if (pNext == null)
				pReversedHead = pNode;
			
			//修改当前结点的下一个结点(m_pNext)为pPrev
			pNode.m_pNext = pPrev;
			
			//pPrev,pNode均往后移一位
			//注意:先修改pPrev,再修改pNode
			pPrev = pNode;
			pNode = pNext;
		}
		
		return pReversedHead;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode list = LinkedList();
		list = list.m_pNext;
		ListNode relist = ReverseList(list);
		System.out.println("relist:\t\t" + relist);
		System.out.println("relist.m_nValue:\t" + relist.m_nValue);
		while (relist != null){
			System.out.printf("%c\t", relist.m_nValue);
			relist = relist.m_pNext;
		}
	}

}
