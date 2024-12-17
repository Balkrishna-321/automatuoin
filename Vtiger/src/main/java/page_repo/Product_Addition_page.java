package page_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_Addition_page {

	public Product_Addition_page(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement addproductbuttonElement;
	
	public WebElement getAddproductbuttonElement() {
		return addproductbuttonElement;
	}

	public void productadditionbutton() 
	{
		addproductbuttonElement.click();
	}
	
}
