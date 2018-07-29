package interview_questions;

import java.util.Scanner;

public class ReMatch {

	/**
	 * @param args
	 */
	
	public Boolean match(String str, String pattern){
		//输入字符串和模式字符串是null的情况
		if (str == null || pattern == null)
			return false;
		return matchCore(str, pattern);
	}
	
	/*
	//判断字符串是否匹配的方法,书中提供的代码
	public Boolean matchCore(String str, String pattern){
		//空字符串的处理,错误理解
		if (str == "\0" && pattern == "\0")
			return true;
		if (str != "\0" && pattern == "\0")
			return false;
		
//		当检测到'*'时的处理
		if (pattern.charAt(1) == '*'){
			if (pattern.charAt(0) == str.charAt(0)
					|| (pattern.charAt(0) == '.' && str.charAt(0) != '\0'))
				return matchCore(str.substring(1), pattern.substring(2))
						|| matchCore(str.substring(1), pattern)
						|| matchCore(str, pattern.substring(2));
			else
				return matchCore(str, pattern.substring(2));
		}
		
//		当检测到'.'时的处理
//		报错,因为当str或pattern长度为1时,还没有返回Boolean值,继续比较下一个字符,就会出错
//		if (str.charAt(0) == pattern.charAt(0) || (pattern.charAt(0) == '.' && str.charAt(0) != '\0')){
//		这一语句是错误的,不能用str == pattern做判断
		if (str == pattern || (pattern.charAt(0) == '.' && str.charAt(0) != '\0')){
			if (str.length() == 1 || pattern.length() == 1)
				return true;
			return matchCore(str.substring(1), pattern.substring(1));
		}		
		return false;
	}
	*/
	
//	未完善的方法,主要是要考虑当str和pattern的长度为1时如何返回Boolean值
//	public Boolean match(String str, String pattern){
//		if (str.charAt(0) == pattern.charAt(0)){
//			if (str.length() == 1 || pattern.length() == 1)
//				return true;
//			return match(str.substring(1), pattern.substring(1));
//		}
//		return false;
//	}
	
	//判断字符串是否匹配的方法,根据运行过程出现的问题而修改的代码
		public Boolean matchCore(String str, String pattern){
//			用_str和_pattern检测str和pattern的第一个字符是否匹配
			char _str = str.charAt(0);
			char _pattern = pattern.charAt(0);
//			当检测到字符串末尾时return相应Boolean值
			if (_str == '\0' && _pattern == '\0')
				return true;
			if (_str != '\0' && _pattern == '\0')
				return false;
			
//			当检测到'*'时的处理
			if (pattern.charAt(1) == '*'){
				if (_pattern == _str
						|| (_pattern == '.' && _str != '\0'))
//					跳过'*'的匹配,继续匹配下一个字符;按原模式匹配下一个字符;忽略'*',继续匹配当前字符
					return matchCore(str.substring(1), pattern.substring(2))
							|| matchCore(str.substring(1), pattern)
							|| matchCore(str, pattern.substring(2));
//				当_str与_pattern不匹配时,将pattern中'*'后的字符与str当前字符匹配
				else
					return matchCore(str, pattern.substring(2));
			}
			
//			当检测到'.'时的处理
//			'.'表示任一字符,可以与str中的任意字符相匹配,所以继续匹配下一个字符
			if (_str == _pattern || (_pattern == '.' && _str != '\0'))
				return matchCore(str.substring(1), pattern.substring(1));
			
//			匹配过程中发现两字符不相匹配时,或匹配_str == '\0' && _pattern != '\0'的情况
			return false;
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		给定测试用例
//		String str = "abcd";
//		String pattern = "abcd";
//		考虑字符串为空的情况
//		String str = "";
//		String pattern = "";
		
//		键盘输入str和pattern值
		Scanner input = new Scanner(System.in);
// 		用next()无法输入空字符串
// 		String str = input.next();
// 		String pattern = input.next();
		String str = input.nextLine();
		String pattern = input.nextLine();
//		System.out.println(str.length());
//		System.out.println(pattern.length());
		
//		字符串加"\0"是为了在调用matchCore()函数时,能够检测到字符串的最后一个字符,然后返回相应的Boolean值
		str = str + "\0";
		pattern = pattern + "\0";
//		验证字符串加上"\0"长度加一
//		System.out.println(str.length());
//		System.out.println(pattern.length());
		ReMatch check = new ReMatch();
		System.out.println(check.match(str, pattern));
	}

}
