package page_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

	
	public Login_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "user_name")
	private WebElement usernametextfieldElement;
	
	@FindBy(name = "user_password")
	private WebElement passwordtextfieldElement;
	
	@FindBy(id = "submitButton")
	private WebElement loginbuttonElement;

	public WebElement getUsernametextfieldElement() {
		return usernametextfieldElement;
	}

	public WebElement getPasswordtextfieldElement() {
		return passwordtextfieldElement;
	}

	public WebElement getLoginbuttonElement() {
		return loginbuttonElement;
	}
	
	
	public void loginPage(String username , String password ) 
	{
		usernametextfieldElement.sendKeys(username);
		passwordtextfieldElement.sendKeys(password);
		loginbuttonElement.click();
		
	}
	
	
	
}
