package interview_questions;

import java.util.Scanner;

public class KthListNodeToTail {

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
		//根据输入的数据创建单链表
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
	
	public ListNode FindKthToTail(ListNode pListHead, int k){
		//考虑输入的pListHead为空或k等于0的情况
		//这两种情况都找不到要求的倒数第k个结点,所以return null
		if (pListHead == null || k == 0)
			return null;
		
		//pAhead为第一个指针,初始化为pListHead
		ListNode pAhead = pListHead;
		//pBhead为第二个指针,初始化为null
		ListNode pBehind = null;
		
		for (int i = 0; i < k - 1; i++){
			if (pAhead.m_pNext != null)
				pAhead = pAhead.m_pNext;
			//如果输入的以pListHead为头结点的链表的结点总数少于k,则无法得到倒数第k个结点
			//遍历过程中会使pAhead.m_pNext == null成立,则return null
			else
				return null;
		}
		
		//pBehind指向链表的头结点
		pBehind = pListHead;
		//pAhead和pBehind同步遍历链表,直到pAhead指向链表最后一个结点
		while (pAhead.m_pNext != null){
			pAhead = pAhead.m_pNext;
			pBehind = pBehind.m_pNext;
		}
		
		return pBehind;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KthListNodeToTail link = new KthListNodeToTail();
		ListNode list = link.LinkedList();
		//list的头结点为空,所以从头结点的下一个结点开始遍历
		//相当于修改list,此时list的头结点有m_nValue值
		list = list.m_pNext;
		
		/*
		while (list != null){
			System.out.println(list.m_nValue);
			list = list.m_pNext;
		}
		*/
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please input the value of k :");
		int k = input.nextInt();
		System.out.println("The " + k + "th listnode to tail is :");
		//返回的是整个结点,输出"interview_questions.ListNode@12a3a380"
		System.out.println(link.FindKthToTail(list, k));
		
		System.out.println("Value of the " + k + "th listnode to tail is :");
		//返回的是结点的m_nValue值
		//当结点为null时,结点的m_nValue值不存在,需要特殊处理
		if (link.FindKthToTail(list, k) != null)
			System.out.println(link.FindKthToTail(list, k).m_nValue);
		else
			System.out.println("null");
	}
}
