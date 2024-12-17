package organisation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_utility.Excell_utility;
import Generic_utility.File_Utility;
import java_Utility.Java_Utility_Files;
import page_repo.HomePage_elements;
import page_repo.Login_Page;
import page_repo.Oragnization_Addition_page;
import page_repo.Organization_Page_Elements;

public class Organization_Utility {

	public static void main(String[] args) throws Throwable {
		WebDriver driver;
		
		File_Utility futil = new File_Utility();
		String URL = futil.getKeyAndValueData("url");
		String BROWSER = futil.getKeyAndValueData("Browser");
		String USERNAME = futil.getKeyAndValueData("username");
		String PASSWORD = futil.getKeyAndValueData("password");
		
		
		
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("edge")) {
			driver= new EdgeDriver(); 
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else {
			driver= new ChromeDriver();
		}
		
		driver.get(URL);
		
		Thread.sleep(1000);
		
		Login_Page logi = new Login_Page(driver);
		logi.loginPage(USERNAME, PASSWORD);
		
		HomePage_elements vhome = new HomePage_elements(driver);
		vhome.organization();
		
		Oragnization_Addition_page addorg = new Oragnization_Addition_page(driver);
		addorg.createorgbutton();
		
		Excell_utility elib = new Excell_utility();
		String orgname = elib.getexceldata("Organisation", 0, 0);
		
		Java_Utility_Files jlib = new Java_Utility_Files();
		int rannum = jlib.Random();
		
		Organization_Page_Elements orgpage = new Organization_Page_Elements(driver);
		orgpage.orgname(orgname+rannum);
		
		
		String phonumber = elib.getexceldata("Organisation", 1, 0);
		orgpage.phnum(phonumber);
		
		
		
		String emailid = elib.getexceldata("Organisation", 2, 0);
		orgpage.mailid(emailid);
		
		orgpage.saveordbutton();
		
		Java_Utility_Files jav = new Java_Utility_Files();
		jav.impwait(driver);
		
		
		vhome.adminbutton();
		vhome.signout();
		
		

	}

}
