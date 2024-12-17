package Testng;

import org.testng.annotations.Test;

public class suitTest {
	
	@Test(groups = "smoke")
	public void m1() 
	{
		System.out.println("from 2nd class");
	}

}
