package page_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_page_Elements {
	
	public Product_page_Elements(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	

	
	@FindBy(name = "button")
	private WebElement saveproductbuttonElement;
	
	@FindBy(name = "productname")
	private WebElement productnamefieldElement;

	
	
	
	public WebElement getSaveproductbuttonElement() {
		return saveproductbuttonElement;
	}

	public WebElement getProductnamefieldElement() {
		return productnamefieldElement;
	}
	
	
	
	
	public void productsavebutton() 
	{
		saveproductbuttonElement.click();
	}
	
	public void productname(String productname) 
	{
		productnamefieldElement.sendKeys(productname);
	}
	
	
	

}
