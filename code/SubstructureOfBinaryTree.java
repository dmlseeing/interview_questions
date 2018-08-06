package interview_questions;

import java.io.IOException;
import java.util.Scanner;

public class SubstructureOfBinaryTree {

	/**
	 * @param args
	 * @throws IOException 
	 */
	
	//创建二叉树
	//输入数据格式要求:输入二叉树的先序序列
	//分行输入数据(字符串类型),一个数据输入之后回车,输入下一个数据
	//若输入的字符串是"#",表示该二叉树是空树；
	//非"#"的其余数据为相应结点的数据元素
	public static BinaryTreeNode createBiTree(){
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		
		//输入字符串为"#",对应结点为空
		if (str.equals("#"))
			return null;
		
		//按先根序列创建二叉树
		else {
			double value = Double.parseDouble(str);
			BinaryTreeNode bt = new BinaryTreeNode();
			bt.m_dbValue = value;			//根
			bt.m_pLeft = createBiTree();	//左
			bt.m_pRight = createBiTree();	//右
			return bt;
		}
	}
	
	//由于数据类型为double,判断两个结点的值是否相等,不能直接用==判断
	//判相等标准:两个数之差的绝对值在一个很小的范围内
	public static boolean Equal(double num1, double num2){
		if ((num1 - num2 > -0.0000001) && (num1 - num2 < 0.0000001))
			return true;
		else
			return false;
	}
	
	//判断由树结点pRoot2引出的二叉树是否为相对应pRoot1的子结构
	public static boolean DoesTree1HaveTree2(BinaryTreeNode pRoot1, BinaryTreeNode pRoot2){
		//如果pRoot2为空,则pRoot2为pRoot1的子结构
		//pRoot1可以为空或非空
		if (pRoot2 == null)
			return true;
		
		//如果pRoot1为空且pRoot2不为空,则pRoot1不包含pRoot2
		if (pRoot1 == null)
			return false;
		
		//如果pRoot1与pRoot2对应的结点值不同,则pRoot1不包含pRoot2
		if (!Equal(pRoot1.m_dbValue, pRoot2.m_dbValue))
			return false;
		
		//pRoot1与pRoot2均非空的情况
		//只有当pRoot1与pRoot2对应的左孩子结点和右孩子结点的值都相等时,
		//才能够判断pRoot2为pRoot1的子结构
		return DoesTree1HaveTree2(pRoot1.m_pLeft, pRoot2.m_pLeft) 
				&& DoesTree1HaveTree2(pRoot1.m_pRight, pRoot2.m_pRight);
	}
	
	//寻找pRoot1中m_dbValue值与pRoot2相等的结点
	public static boolean HasSubtree(BinaryTreeNode pRoot1, BinaryTreeNode pRoot2){
		//result初始化为false,当传入的树结点为空时,返回false
		boolean result = false;
		
		//进入判断的条件是pRoot1和pRoot2均不为空
		if (pRoot1 != null && pRoot2 != null){
			//找到pRoot1中m_dbValue值与pRoot2相等的结点,
			//调用DoesTree1HaveTree2进行子结构的判断
			if (Equal(pRoot1.m_dbValue, pRoot2.m_dbValue))
				result = DoesTree1HaveTree2(pRoot1, pRoot2);
			
			//未找到m_dbValue值相等的结点时,继续遍历左右子树
			if (!result)
				result = HasSubtree(pRoot1.m_pLeft, pRoot2);
			if (!result)
				result = HasSubtree(pRoot1.m_pRight, pRoot2);
		}
		
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//创建树bt1
		BinaryTreeNode bt1 = new BinaryTreeNode();
		System.out.println("bt1");
		System.out.println("Please input preorder value of " +
				"binarytreenode to create bt1 :");
		bt1 = createBiTree();
		
		System.out.println();
		
		//创建树bt2
		BinaryTreeNode bt2 = new BinaryTreeNode();
		System.out.println("bt2");
		System.out.println("Please input preorder value of " +
				"binarytreenode to create bt2 :");
		bt2 = createBiTree();
		
		//判断bt2是否为bt1的子结构
		System.out.println("bt1 has bt2?");
		System.out.println(HasSubtree(bt1, bt2));
	}

}

class BinaryTreeNode {
	double m_dbValue;
	BinaryTreeNode m_pLeft;
	BinaryTreeNode m_pRight;
}
