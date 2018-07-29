# interview_questions
This is summary of the learning of interview_questions.


## 1.DeleteListNode_1_18.java
### try the function of you
* try the function of *
+ try the function of +
- try the function of -  

  - Like this
  - And this


## 3.ReMatch.java
* **代码学习小结**  

  之所以书中的代码运行后会报错,  

  是因为书中的str即str.charAt(0),pattern即pattern.charAt(0);  

  而字符串的检测向后移一位,只需要str+1即可;  

  所以代码出错的主要原因是把对str == "\0" && pattern == "\0"的判断理解为空字符串的处理  

  事实上这一语句的判断是判断单个字符是否为'\0',是整个字符串遍历结束的标志  

  在C语言中,'\0' 是字符串的结束符，任何字符串之后都会自动加上'\0'  

  但Java定义的字符串的最后一位并不是'\0',这样无法判断字符串的遍历是否结束,  

  所以在main函数里面定义完str和pattern后,要在两个字符串后面再加上"\0",  

  确保能够判断字符串的遍历是否结束,从而返回相应的Boolean值 
