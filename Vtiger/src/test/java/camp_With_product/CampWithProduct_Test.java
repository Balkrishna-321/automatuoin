package camp_With_product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CampWithProduct_Test {

	@Test
	public void CampWithProductTest() throws Throwable {
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
	
	HomePage_elements vhome = new HomePage_elements(driver);
	
	vhome.product();
	
	Product_Addition_page pro = new Product_Addition_page(driver);
	pro.productadditionbutton();
							
	Thread.sleep(1000);
	
	Excell_utility excel = new Excell_utility();
	String productname = excel.getexceldata("Product", 0, 0);
	
	Java_Utility_Files jlib = new Java_Utility_Files();
	int rannum = jlib.Random();
	
	Product_page_Elements pp = new Product_page_Elements(driver);
	pp.productname(productname+rannum);
	                                                                                                                                          
	pp.productsavebutton();
	
//----------------------------------------------------
	//CAMP PAGE
	
	vhome.moreoption();
	vhome.campaign();
	
	CAmpaigns_Addition_page cadd = new CAmpaigns_Addition_page(driver);
	cadd.createcampbutton();
	System.out.println("checking");
	
	String cname = excel.getexceldata("Campaign", 0, 0);
	Campaigns_Page_Elements cp = new Campaigns_Page_Elements(driver);
	cp.campignnamebox(cname+rannum);
	cp.productlookupsign();
	jlib.switchwindow(driver, "Products&action");
	driver.findElement(By.xpath("//a[text()='"+productname+"']")).click();
	jlib.switchwindow(driver, "Campaigns&action");
	cp.savecamp();
	
	vhome.signingout();
	
}
}
