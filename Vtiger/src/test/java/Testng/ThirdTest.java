package Testng;

import org.testng.annotations.Test;

public class ThirdTest {
	
	@Test(groups = "Regression")
	public void m1() 
	{
		System.out.println("from third class");
	}

}
