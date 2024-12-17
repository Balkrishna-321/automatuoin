package page_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_elements {

	public HomePage_elements(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Products")
	private WebElement productbuttonElement;
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationbuttonElement;
	
	@FindBy(linkText = "More")
	private WebElement morebuttonElement;
	
	@FindBy(name = "Campaigns")
	private WebElement campaignbuttonElement;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement adminbuttonElement;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutbuttonElement;
	
	
	

	public WebElement getProductbuttonElement() {
		return productbuttonElement;
	}

	public WebElement getOrganizationbuttonElement() {
		return organizationbuttonElement;
	}

	public WebElement getMorebuttonElement() {
		return morebuttonElement;
	}

	public WebElement getCampaignbuttonElement() {
		return campaignbuttonElement;
	}
	
	public WebElement getAdminbuttonElement() {
		return adminbuttonElement;
	}

	public WebElement getSignoutbuttonElement() {
		return signoutbuttonElement;
	}
	
	
	
	public void organization() 
	{
		organizationbuttonElement.click();
	}
	
	public void campaign() 
	{
		campaignbuttonElement.click();
	}
	
	public void moreoption() 
	{
		morebuttonElement.click();
	}
	
	public void product() 
	{
		productbuttonElement.click();
	}
	
	public void adminbutton() 
	{
		adminbuttonElement.click();
	}
	
	public void signout() 
	{
		signoutbuttonElement.click();
	}
	
	public void signingout() 
	{
		adminbuttonElement.click();
		signoutbuttonElement.click();
	}
}
