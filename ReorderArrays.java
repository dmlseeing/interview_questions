package interview_questions;

import java.util.Scanner;

public class ReorderArrays {

	/**
	 * @param args
	 */
	
	public void Reorder(int [] pData, int length){
		if (pData == null || length == 0)
			return;
		
		int pBegin = 0;
		int pEnd = length - 1;
		
		while (pBegin < pEnd){
			while (pBegin < pEnd && !func(pData, pBegin))
				pBegin++;
			
			while (pBegin < pEnd && func(pData, pEnd))
				pEnd--;
			
			if (pBegin < pEnd){
				int temp = pData[pBegin];
				pData[pBegin] = pData[pEnd];
				pData[pEnd] = temp;
			}
		}
	}
	
	//关键函数,修改return值,可以实现不同的调整要求
	public boolean func(int [] array, int n) {
//		return array[n] % 2 == 0;
//		return array[n] > 0;
		return array[n] % 3 != 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter length of the array :");
		int length = input.nextInt();
		int [] array = new int [length];
		System.out.println("Enter numbers of the array and split them with space :");
		for (int index = 0; index < array.length; index++)
			array [index] = input.nextInt();
		
		ReorderArrays reor = new ReorderArrays();
		reor.Reorder(array, length);
		for (int index = 0; index < array.length; index++)
//			System.out.printf("%-2d", array[index]);
			System.out.printf("%d\t", array[index]);
	}

}
