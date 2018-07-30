package interview_questions;

import java.util.Scanner;

public class ReorderArray {

	/**
	 * @param args
	 */
	
	//调整数字顺序,使奇数在前,偶数在后
	public void ReorderOddEven(int [] pData, int length){
		if (pData == null || length == 0)
			return;
		
		int pBegin = 0;
		int pEnd = length - 1;
		
		while (pBegin < pEnd){
			//向后移动pBegin,直到它指向偶数
			while (pBegin < pEnd && pData[pBegin] % 2 != 0)
				pBegin++;
				
			//向前移动pEnd,直到它指向奇数
			while (pBegin < pEnd && pData[pEnd] % 2 == 0)
				pEnd--;
			
			//当pBegin位为偶数,pEnd位为奇数时,交换数字(前面的偶数与后面的奇数交换)
			if (pBegin < pEnd){
				int temp = pData[pBegin];
				pData[pBegin] = pData[pEnd];
				pData[pEnd] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter length of the array :");
		//输入数组前需先输入数组长度,才能够定义数组
		//如果测试用例的输入没有数组长度,则代码需要做修改
		int length = input.nextInt();
		int [] array = new int [length];
		System.out.println("Enter numbers of the array and split them with space :");
		for (int index = 0; index < array.length; index++)
			array [index] = input.nextInt();
		
		ReorderArray reor = new ReorderArray();
		reor.ReorderOddEven(array, length);
		for (int index = 0; index < array.length; index++)
//			System.out.printf("%d\t", array[index]);
			System.out.printf("%-2d", array[index]);
	}

}
