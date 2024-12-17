package Generic_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import page_repo.HomePage_elements;
import page_repo.Login_Page;


public class BaseClass {

	public WebDriver driver;
	public static WebDriver sDriver;
	
	@BeforeSuite
	public void bs()
	{
		System.out.println("DATABASE CONNECTIVITY");
		
		
		}
	
	@BeforeTest
	public void BT() {
		// TODO Auto-generated method stub

	}
	
	
	//@Parameters("BROWSER")
	@BeforeClass
	public void BC () throws Throwable 
	{
		File_Utility fil = new File_Utility();
		String BROWSER = fil.getKeyAndValueData("Browser");
		
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		
		System.out.println("Launching browser");
		
	}
	
	
	@Parameters({"URL","USERNAME","PASSWORD"})
	@BeforeMethod
	public void BM()throws Throwable 
	{
			 System.out.println("login to application");
				File_Utility flib = new File_Utility();
				String URL = flib.getKeyAndValueData("url");
				String USERNAME = flib.getKeyAndValueData("username");
				String PASSWORD = flib.getKeyAndValueData("password");
				driver.get(URL);
				Login_Page log = new Login_Page(driver);
				log.loginPage(USERNAME, PASSWORD);
			
					
	}
	
	
	@AfterMethod
	public void AM() 
	{
		HomePage_elements home = new HomePage_elements(driver);
		home.signingout();
		
	}
	
	@AfterClass
	public void AC() 
	{
		System.out.println("quiting browser");
		driver.quit();
	}
	
	@AfterTest
	public void AT() 
	{
		System.out.println("close parallel execution");
	}
	
	@AfterSuite
	public void AS() 
	{
		System.out.println("Data base close");
	}
	
	}

