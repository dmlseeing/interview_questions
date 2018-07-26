package interview_questions;

public class DeleteListNode_2_18 {

	/**
	 * @param args
	 */
	
	//通过尾插法建立单链表
		public ListNode LinkedList(){
			char ch;
			ListNode p, t;
			ListNode h = new ListNode();
			h.m_pNext = null;
			t = h;
			String str = "1233445";
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
	
	//删除链表重复结点的函数
	//pHead为链表头结点
	public static void DeleteDuplication(ListNode pHead){
		//当链表为空时，return
		if (pHead == null)
			return;
		
		//pPreNode为当前结点的前一个结点
		ListNode pPreNode = null;
		//从头结点开始遍历
		//pNode为当前结点
		ListNode pNode = pHead;
		//遍历到最后一个结点后退出循环
		while (pNode != null){
			//pNext为当前结点的下一个结点
			ListNode pNext = pNode.m_pNext;
			//通过needDelete判断是否需要删除结点
			Boolean needDelete = false;
			//当下一个结点非空且当前结点与其下一个结点重复时,needDelete为真
			if (pNext != null && pNext.m_nValue == pNode.m_nValue)
				needDelete = true;
			
			//当前结点与下一个结点不重复的情况
			//修改对应结点,继续遍历链表
			if (!needDelete){
				//当前结点设置为pPreNode
				pPreNode = pNode;
				//当前结点的下一个结点设置为pNode
				//判断pNode是否等于null,是否继续while循环
				pNode = pNode.m_pNext;
			}
			//当前结点与下一个结点重复的情况
			//删除并修改对应结点
			else {
				//value为要删除结点的值
				char value = pNode.m_nValue;
				//pToBeDel为要删除的结点
				ListNode pToBeDel = pNode;
				//删除结点的条件:两个结点的m_nValue域的值相等
				//删除所有重复结点直到设置的pToBeDel结点值不等于pNode的值
				while (pToBeDel != null && pToBeDel.m_nValue == value){
					//pNext设置为要删除的结点的下一个结点
					pNext = pToBeDel.m_pNext;
					
					//删除结点pToBeDel
					pToBeDel = null;
					
					//pToBeDel设置为下一个结点
					pToBeDel = pNext;
				}
				//pPreNode被删除的情况
				if (pPreNode == null)
					pHead = pNext;
				//pPreNode未被删除,其m_pNext域的指针指向pNext
				else
					pPreNode.m_pNext = pNext;
				//修改pNode
				//判断pNode是否等于null,是否继续while循环
				pNode = pNext;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeleteListNode_2_18 link = new DeleteListNode_2_18();
		ListNode list = link.LinkedList();
		list = list.m_pNext;
		while (list != null){
			System.out.print(list.m_nValue + "\t");
			list = list.m_pNext;
		}
				
		DeleteListNode_2_18 link1 = new DeleteListNode_2_18();
		ListNode list1 = link1.LinkedList();
		System.out.println();
		list1 = list1.m_pNext;

		////调用DeleteDuplication()函数删除重复的结点
		DeleteDuplication(list1);
		
		while (list1 != null){
			System.out.print(list1.m_nValue + "\t");
			list1 = list1.m_pNext;
		}
	}

}
