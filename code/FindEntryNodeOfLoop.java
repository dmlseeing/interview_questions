package interview_questions;

import java.util.Scanner;

public class FindEntryNodeOfLoop {

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
		System.out.println("Please input value of listnode with loop to create a list :");
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
		
		//根据键盘输入,若存在相同的值,则创建的链表包含环
		//代码前提:要求输入的每个结点的m_nValue值都不同
		ListNode front = h;
		ListNode behind = h;
		for (int j = 0; j < str.length(); j++){
			for (int k = 0; k < j; k++){
				if (front.m_pNext.m_nValue == str.charAt(k)){
					while (behind.m_nValue != front.m_pNext.m_nValue)
						behind = behind.m_pNext;
					front.m_pNext = behind;
				}
			}
			front = front.m_pNext;
		}
		
		//检验带环的链表是否创建成功
		/*
		int n = 0;
		while (n <= 2){
			h = h.m_pNext;
			System.out.println(h.m_nValue);
			if (behind.m_nValue == h.m_nValue)
				n++;
		}
		*/
		
		return h;
	}
	
	//找出环中任意一个结点
	public static ListNode MeetingNode(ListNode pHead){
		pHead = pHead.m_pNext;
		//链表为空的情况
		if (pHead == null)
			return null;
		
		ListNode pSlow = pHead.m_pNext;
		//链表只有一个结点的情况
		if (pSlow == null)
			return null;
		
		//pFast走两步,pSlow走一步
		ListNode pFast = pSlow.m_pNext;
		while(pFast != null && pSlow != null){
			if (pFast == pSlow)
				return pFast;
			
			pSlow = pSlow.m_pNext;
			
			pFast = pFast.m_pNext;
			//总结点数为奇数且链表中无环时,到达链表最后一个结点时,无法走两步
			if (pFast != null)
				pFast = pFast.m_pNext;
		}
		
		return null;
	}
	
	public static ListNode EntryNodeOfLoop(ListNode pHead){
		ListNode meetingNode = MeetingNode(pHead);
		//链表为空的情况
		if (meetingNode == null)
			return null;
		
		//得到环中结点的数目
		int nodesInLoop = 1;
		ListNode pNode1 = meetingNode;
		while (pNode1.m_pNext != meetingNode){
			pNode1 = pNode1.m_pNext;
			nodesInLoop++;
		}
//		System.out.println("The number of nodes in loop is :");
//		System.out.println(nodesInLoop);
		
		//先移动pNode1,次数为环中结点的数目
		pNode1 = pHead.m_pNext;
		for (int i = 0; i < nodesInLoop; i++)
			pNode1 = pNode1.m_pNext;
		
		//再移动pNode1和pNode2
		ListNode pNode2 = pHead.m_pNext;
		while (pNode1 != pNode2){
			pNode1 = pNode1.m_pNext;
			pNode2 = pNode2.m_pNext;
		}
		
		return pNode1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode list = LinkedList();
		ListNode entrynode = EntryNodeOfLoop(list);
		System.out.print("The entrynode of loop is : ");
		System.out.println(entrynode);
		System.out.print("Value of the entrynode of loop is : ");
		if (entrynode != null)
			System.out.println(entrynode.m_nValue);
		else
			System.out.println("null");
	}

}
