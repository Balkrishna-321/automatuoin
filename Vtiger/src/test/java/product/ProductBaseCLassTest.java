package product;

import org.testng.annotations.Test;

import Generic_utility.BaseClass;
import Generic_utility.Excell_utility;
import java_Utility.Java_Utility_Files;
import page_repo.HomePage_elements;
import page_repo.Product_Addition_page;
import page_repo.Product_page_Elements;

public class ProductBaseCLassTest extends BaseClass{

	@Test
	public void Product_BaseCLass_Test() throws Throwable	{
		
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
		
			
	}
	
}
