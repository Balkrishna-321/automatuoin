package Testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {

	@Test
	public void m1() 
	{
		System.out.println("hi");
		System.out.println("hiiiii");
		
		Assert.assertEquals(false, false);
		// here it will fail
		
		System.out.println("bye");
		System.out.println("byeeeeee");
		
	}
	
	@Test
	public void m2() 
	{
		String expdata = "qspider";
		String actdata="qspider";
		
		Assert.assertEquals(actdata, expdata);
		// this will fail 
		
	}
	
	@Test
	public void m3() 
	{
		int a=10;
		int b=20;
		
		//assertEquals(a, b, "data is same");
		Assert.assertNotEquals(a, b,"data is same ");
	}
	
	@Test
	public void m4() 
	{
		String s1 ="bala";
		String s2 ="bal";
		Assert.assertTrue(s1.equalsIgnoreCase(s2), "different=");
		System.out.println("data is same");
	}
	
	@Test
	public void m5() 
	{
		String a ="bala";
		String b ="bal";
		Assert.assertFalse(a.equalsIgnoreCase(b), "same==");
		System.out.println("same same but different");
	}
	
	@Test
	public void m6() 
	{
		String s="hii";
		Assert.assertNull(s, "it is not null");
		System.out.println("it is null");
	}
	
	@Test
	public void m7() 
	{
		String l="bye";
		Assert.assertNotNull(l, "it is null");
		System.out.println("data is not null");
	}
	
	@Test
	public void m8() 
	{
		String a="hello";
		String b="hello";
		Assert.assertNotSame(a, b, "data is not same");
		System.out.println("data is same ");
	}
	
}
