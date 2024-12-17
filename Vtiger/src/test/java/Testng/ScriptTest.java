package Testng;

import org.testng.annotations.Test;

public class ScriptTest {

	@Test(groups = "smoke")
	public void createproduct() 
	{
		System.out.println("product created ");
	}
	
	@Test(groups = "regression")
	public void productdelete() 
	{
		System.out.println("Product deleted ");
	}
	
	@Test(groups = "sanity")
	public void productmodift() 
	{
		System.out.println("product modified");
	}
}
