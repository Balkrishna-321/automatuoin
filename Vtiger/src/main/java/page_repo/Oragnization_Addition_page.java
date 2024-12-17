package page_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Oragnization_Addition_page {

	public Oragnization_Addition_page(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement createorganizationbutonElement;
	
	public WebElement getCreateorganizationbutonElement() {
		return createorganizationbutonElement;
	}
	
	public void createorgbutton() 
	{
		createorganizationbutonElement.click();
	}
	
	
	
	
}
