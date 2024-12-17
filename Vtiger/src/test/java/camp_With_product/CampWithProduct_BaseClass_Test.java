package camp_With_product;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Generic_utility.BaseClass;
import Generic_utility.Excell_utility;
import java_Utility.Java_Utility_Files;
import page_repo.CAmpaigns_Addition_page;
import page_repo.Campaigns_Page_Elements;
import page_repo.HomePage_elements;
import page_repo.Product_Addition_page;
import page_repo.Product_page_Elements;


public class CampWithProduct_BaseClass_Test extends BaseClass {

	@Test
	public void CampWithProductBaseClass_Test() throws Throwable {
			
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
	
}
	
}
