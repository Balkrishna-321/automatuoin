package Testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data_Providers {
	
	
	@Test(dataProvider = "readdata")
	public void usedata(String src, String dest)
	{
		System.out.println("ticket is booked from   " + src + " to " + dest);
	}

	@DataProvider
	public Object[][] readdata()
	{
		
		Object[][] obj = new Object[3][2];
		
		obj[0][0]= "Hyderabad";
		obj[0][1]= "goa";
						
		obj[1][0]= "hydearabad";
		obj[1][1]= "bangalore";
										
		obj[2][0]= "Hyderabad";
		obj[2][1]= "bIHAR";
		
		return obj;

		//hollalalaleleoooo holalalalaleooooo
		
		//push push pushpa
		
	}
	
	
}
