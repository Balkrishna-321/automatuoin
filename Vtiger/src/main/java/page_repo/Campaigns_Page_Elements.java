package page_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Campaigns_Page_Elements {

	public Campaigns_Page_Elements(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
		
	
	@FindBy(name = "campaignname")
	private WebElement campaignnametextfieldElement;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/select.gif\"]")
	private WebElement productlookupimagElement;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement savebottonElement;
	
	
	//---------------------------------------------------------------------------------------------------

	public WebElement getCampaignnametextfieldElement() {
		return campaignnametextfieldElement;
	}

	public WebElement getProductlookupimagElement() {
		return productlookupimagElement;
	}

	public WebElement getSavebottonElement() {
		return savebottonElement;
	}

	//------------------------------------------------------------------------------------
	
	public void campignnamebox(String campname) 
	{
		campaignnametextfieldElement.sendKeys(campname);
	}
	
	public void productlookupsign() 
	{
		productlookupimagElement.click();
	}
	
	public void savecamp() 
	{
		savebottonElement.click();
	}
	
	
}
