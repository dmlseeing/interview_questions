package interview_questions;

public class DeleteListNode_1_18 {

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
		String str = "123456789";
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
	
	//删除链表结点的函数
	//传入参数值pListHead（链表的头结点，包含整条链表），
	//pToBeDeleted（要删除的结点）
	public static void DeleteNode(ListNode pListHead,
			ListNode pToBeDeleted){
		
		//当链表为空或要删除的结点为空时，return
		if (pListHead == null || pToBeDeleted == null)
			return;
		
		//要删除的结点不是尾结点
		if (pToBeDeleted.m_pNext != null){
			//pNext为要删除的结点pToBeDeleted的下一个结点
			ListNode pNext = pToBeDeleted.m_pNext;
			//将pNext结点的m_nValue值复制到pToBeDeleted结点
			//此时pToBeDeleted结点可以保留，删除pNext结点即可
			pToBeDeleted.m_nValue = pNext.m_nValue;
			//删除pNext结点
			pToBeDeleted.m_pNext = pNext.m_pNext;
			
			//释放pNext所占内存
			pNext = null;
			
			//c++中delete和nullptr的用法
			//delete pNext;（delete运算符默认释放指针指向的空间，却不把指针本身置空）
			//pNext = nullptr;（手动释放指针空间;c++中的nullptr相当于Java中的null）
		}
		
		//链表只有一个结点，删除头结点（也是尾结点）
		else if (pListHead == pToBeDeleted){
			//要删除的结点置空
			pToBeDeleted = null;
			//链表头结点（即尾结点）置空
			pListHead = null;
		}
		
		//链表中有多个结点，删除尾结点
		else {
			//从头结点开始
			ListNode pNode = pListHead;
			//遍历所有结点
			while (pNode.m_pNext != pToBeDeleted){
				//取下一个结点
				pNode = pNode.m_pNext;
			}
			//尾结点置空
			pNode.m_pNext = null;
			//要删除的结点（尾结点）置空
			pToBeDeleted = null;
		}	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//建立单链表（list）
		DeleteListNode_1_18 link = new DeleteListNode_1_18();
		ListNode list = link.LinkedList();
		//头结点的m_pNext值为空，不取
		list = list.m_pNext;
		//从第一个结点开始，遍历单链表
		while (list != null){
			System.out.print(list.m_nValue + "\t");
			//取下一个结点
			list = list.m_pNext;
		}//list指向尾结点（空）
		
		DeleteListNode_1_18 link1 = new DeleteListNode_1_18();
		ListNode list1 = link1.LinkedList();
		System.out.println();
		list1 = list1.m_pNext;
		ListNode p = list1;
		//p为要删除的结点，修改while()中的语句可以改变要删除的结点
		while (p.m_nValue != '5'){
			//通过寻找m_nValue的值确定p
			p = p.m_pNext;
		}
		//调用DeleteNode()函数删除p
		DeleteNode(list1, p);
		//打印删除结点后的链表的m_nValue值
		while (list1 != null){
			System.out.print(list1.m_nValue + "\t");
			list1 = list1.m_pNext;
		}
	}
	
}

//ListNode为结点类型
class ListNode{
	public char m_nValue;
	public ListNode m_pNext;
	
}