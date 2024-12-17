package camp_With_product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_utility.Excell_utility;
import Generic_utility.File_Utility;
import java_Utility.Java_Utility_Files;
import page_repo.CAmpaigns_Addition_page;
import page_repo.HomePage_elements;
import page_repo.Login_Page;
import page_repo.Product_Addition_page;
import page_repo.Product_page_Elements;

public class CampWithProduct_Utilities {

	
			public static void main(String[] args) throws Throwable {
			WebDriver driver;
			
			File_Utility futil = new File_Utility();
			String URL = futil.getKeyAndValueData("url");
			String BROWSER = futil.getKeyAndValueData("Browser");
			String USERNAME = futil.getKeyAndValueData("username");
			String PASSWORD = futil.getKeyAndValueData("password");
			

			if (BROWSER.equalsIgnoreCase("chrome")) {
				driver=new ChromeDriver();
			}
			else if (BROWSER.equalsIgnoreCase("edge")) {
				driver= new EdgeDriver(); 
			}
			else if (BROWSER.equalsIgnoreCase("firefox")) {
				driver=new FirefoxDriver();
			}else {
				driver= new ChromeDriver();
			}
			
			driver.get(URL);
			
			Thread.sleep(1000);
			
			Login_Page logi = new Login_Page(driver);
			logi.loginPage(USERNAME, PASSWORD);
			
			HomePage_elements home = new HomePage_elements(driver);
			home.product();
			
			Product_Addition_page pro = new Product_Addition_page(driver);
			pro.productadditionbutton();
									
			Thread.sleep(1000);
			
			Excell_utility excel = new Excell_utility();
			String productname = excel.getexceldata("Product", 0, 0);
			driver.findElement(By.name("productname")).sendKeys(productname);
			
			Product_page_Elements propage = new Product_page_Elements(driver);
			propage.productsavebutton();
			
	
			
			// CAMPIGN CREATION
			
			home.moreoption();
			home.campaign();
			
			CAmpaigns_Addition_page camp = new CAmpaigns_Addition_page(driver);
			camp.createcampbutton();
						
			String campname = excel.getexceldata("Campaign", 0, 0);
			
			System.out.println(campname);
			driver.findElement(By.name("campaignname")).sendKeys(campname);
			
			driver.findElement(By.xpath("//img[@src=\"themes/softed/images/select.gif\"]")).click();
			
			Java_Utility_Files jav = new Java_Utility_Files(); 
			jav.switchwindow(driver, "Products&action");
			
			
			driver.findElement(By.xpath("//a[text()='"+productname+"']")).click();
			
			jav.switchwindow(driver, "Campaigns&action");
			
			driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
			
			
			home.adminbutton();
			home.signout();
			
		
	}

}
