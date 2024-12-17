package campaign;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Create_CampaignTest {

	@Test
	public  void Createcampaign() throws Throwable {
		WebDriver driver;
		FileInputStream fis = new FileInputStream("./src/test/resources/prop.properties.txt");
		Properties pro = new Properties();
		pro.load(fis);
		
		String BROWSER= pro.getProperty("Browser");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		String URL = pro.getProperty("url");
		
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
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		Thread.sleep(1000);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Campaign...\"]")).click();
		
	Thread.sleep(2000);
		
	FileInputStream fis1 = new FileInputStream("./src/test/resources/framework1.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sheet = book.getSheet("Campaign");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		DataFormatter format = new DataFormatter();
		String campname = format.formatCellValue(cell);
		
		System.out.println(campname);
		Random rand = new Random();
		int rannum = rand.nextInt(1000);
		driver.findElement(By.name("campaignname")).sendKeys(campname+rannum);
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();

	}

}
