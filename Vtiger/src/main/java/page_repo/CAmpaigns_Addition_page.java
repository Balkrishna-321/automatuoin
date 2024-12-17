package page_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CAmpaigns_Addition_page {

	public CAmpaigns_Addition_page(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement createcampaignbuttonElement;
	
	//------------------------------------------------------------------------------------------
	
	public WebElement getCreatecampaignbuttonElement() {
		return createcampaignbuttonElement;
	}
	
	//----------------------------------------------------------------------------------------------
	
	public void createcampbutton() 
	{
		createcampaignbuttonElement.click();
	}
}
