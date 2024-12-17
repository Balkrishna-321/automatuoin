package validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Product_Validation {
	
	public  Product_Validation(WebDriver driver ){
		PageFactory.initElements(driver, this);
	}	
		
public String validateproduct(WebDriver driver,String campname) 
{
	String actData = driver.findElement(By.xpath("//td[@id=\"mouseArea_Product Name\"]")).getText();

		if (actData.contains(campname)) {
			System.out.println("Campaign Name is Created");
		} else {
			System.out.println("Campaign Name is not Created");
		}
		return actData;
	
}
	
	
	
	
	
	
//	WebDriver driver= new ChromeDriver();
//				
//		String savedname = driver.findElement(By.xpath("//td[@id=\"mouseArea_Product Name\"]")).getText();
//		
//		assertEquals(savedname, excelname);
//		
//		assertSame(excelname, savedname, "product is created");
		
	}


