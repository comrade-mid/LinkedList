import java.io.*;

public class ListTest{
	
	public static void main(String[] args) 
	{
		List Test = new List();
		List Test2 = new List();
		
		
		int n = Test.length();
		System.out.println(n);
		
		Test.append(20);
		Test.insertAfter(201);
		Test.insertAfter(2011);
		Test.insertAfter(20111);
		Test.insertAfter(20111);
		Test.insertAfter(201111);
		Test.insertAfter(2011111);
		Test.insertAfter(20111111);
		Test.insertAfter(201111111);
		Test.insertAfter(2034);
		Test.insertAfter(205);
		Test.insertAfter(202);
		Test.insertAfter(206);
		Test.insertAfter(207);
		
		Test.moveFront();
		
		Test.moveNext();
		Test.moveNext();
		Test.moveNext();
		Test.moveNext();
		Test.moveNext();
		Test.moveNext();
		Test.moveNext();
		Test.moveNext();
		Test.moveNext();
		Test.insertBefore(44);
		System.out.println(Test);
		System.out.println(Test.length());
	}
	
}