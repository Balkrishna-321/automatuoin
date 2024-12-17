package product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_utility.Excell_utility;
import Generic_utility.File_Utility;
import java_Utility.Java_Utility_Files;
import page_repo.HomePage_elements;
import page_repo.Login_Page;
import page_repo.Product_Addition_page;
import page_repo.Product_page_Elements;

public class Product_Utility_Test {
	

	@Test
	public void ProductUtilityTest() throws Throwable {

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
	
	Product_Addition_page proadd = new Product_Addition_page(driver);
	proadd.productadditionbutton();
	
	Java_Utility_Files jav = new Java_Utility_Files();
	int rannum = jav.Random();
	
	Excell_utility elib = new Excell_utility();
	String proname = elib.getexceldata("Product", 0, 0);
	
	Product_page_Elements pro = new Product_page_Elements(driver);
	pro.productname(proname+rannum);
	
	pro.productsavebutton();
	
	home.adminbutton();
	home.signout();

	
}
}
