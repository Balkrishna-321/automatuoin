package page_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization_Page_Elements {
	
	public Organization_Page_Elements(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(name = "button")
	private WebElement saveorganizationbuttonElement;
	
	@FindBy(name = "accountname")
	private WebElement organizationtextfieldElement;
	
	@FindBy(name = "phone")
	private WebElement phnumbertxtfieldElement;
	
	@FindBy(name = "email1")
	private WebElement emailtxtfieldElement;

	
	public WebElement getSaveorganizationbuttonElement() {
		return saveorganizationbuttonElement;
	}

	public WebElement getOrganizationtextfieldElement() {
		return organizationtextfieldElement;
	}

	public WebElement getPhnumbertxtfieldElement() {
		return phnumbertxtfieldElement;
	}

	public WebElement getEmailtxtfieldElement() {
		return emailtxtfieldElement;
	}
		
	
	
	public void saveordbutton() 
	{
		saveorganizationbuttonElement.click();
	}
	
	public void orgname(String orgname) 
	{
		organizationtextfieldElement.sendKeys(orgname);
	}
	
	public void phnum(CharSequence phnumber) 
	{
		phnumbertxtfieldElement.sendKeys(phnumber);
	}
	
	public void mailid(String emailid) 
	{
		emailtxtfieldElement.sendKeys(emailid);
	}
}
