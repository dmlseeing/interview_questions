package interview_questions;

import java.util.Scanner;

public class NumericString {

	/**
	 * @param args
	 */
	
	//_str_用以实时记录str移动到的位置
	static String _str_;
	
	//扫描字符串中0~9的数位,不带正负号(整数)
	public Boolean scanUnsignedInteger(String str){
		String before = str;
		char _str = str.charAt(0);
		//扫描直至_str为'\0'或非数字的字符
		while (_str != '\0' && _str >= '0' && _str <= '9'){
			str = str.substring(1);
			_str = str.charAt(0);
		}
		//修改_str_的值
		_str_ = str;
		//str.length()<before.length()成立,说明存在0~9的数位
		return str.length()<before.length();
	}
	
	//扫描带正负号的0~9的数位(整数)
	public Boolean scanInteger(String str){
		char _str = str.charAt(0);
		if (_str == '+' || _str == '-')
			str = str.substring(1);
		//继续扫描正负号后面是否为数字
		return scanUnsignedInteger(str);
	}
	
	public Boolean isNumeric(String str){
		_str_ = str;
		//字符串为空的情况
		if (str == null)
			return false;
		
		//判断小数点前是否为数字,可带正负号,所以用scanInteger()方法判断
		Boolean numeric = scanInteger(_str_);
		
		//判断小数点后,指数e前的部分是否为数字,不可带正负号,所以用scanUnsignedInteger()方法判断
		//如果出现'.',则接下来是数字的小数部分
		if (_str_.charAt(0) == '.'){
			_str_ = _str_.substring(1);
			//用或的原因:小数可以没有整数部分,小数点后面也可以没有数字(可以都有数字,但不可以都没有)
			//只有一个情况为false(前后都没有数字)
			numeric = scanUnsignedInteger(_str_) || numeric;
		}
		
		//判断指数e后是否为数字,可带正负号,所以用scanInteger()方法判断
		//如果出现'e'或者'E',则接下来是数字的指数部分
		if (_str_.charAt(0) == 'e' || _str_.charAt(0) == 'E'){
			_str_ = _str_.substring(1);
			//用和的原因:当e或E前面或者后面没有数字时,字符串都不能表示数字
			//只有一个情况为true(前后都有数字)
			numeric = numeric && scanInteger(_str_);
		}
		
		//当扫描到字符串的最后一位,并且前面各部分判断均为数字时,可得出该字符串表示数值
		return numeric && _str_.charAt(0) == '\0';
//		wrong!!
//		_str_.charAt(0) == '\0'成立但不满足_str_ == "\0"
//		return numeric && _str_ == "\0";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		NumericString ns = new NumericString();
		String str = input.nextLine() + "\0";
//		System.out.println(ns.scanUnsignedInteger(str));
//		System.out.println(ns.scanInteger(str));
//		System.out.println(ns.isNumeric(str));
		while (!str.equals("halt\0")){
			System.out.println(ns.isNumeric(str));
			str = input.nextLine() + "\0";
		}
	}

}
