package camp_With_product;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Set;

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

import Generic_utility.Excell_utility;
import Generic_utility.File_Utility;
import page_repo.Login_Page;

public class Create_CampwithProduct {

	public static void main(String[] args) throws Throwable {
		WebDriver driver;
		
//		FileInputStream fis = new FileInputStream("./src/test/resources/prop.properties.txt");
//		Properties pro = new Properties();
//		pro.load(fis);
//		
//		String BROWSER= pro.getProperty("Browser");
//		String USERNAME = pro.getProperty("username");
//		String PASSWORD = pro.getProperty("password");
//		String URL = pro.getProperty("url");
		
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
		
		
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		Thread.sleep(1000);
//		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Product...\"]")).click();
		
		Thread.sleep(1000);
		
//		FileInputStream fis1 = new FileInputStream("./src/test/resources/framework.xlsx");
//		Workbook book = WorkbookFactory.create(fis1);
//		Sheet sheet = book.getSheet("Product");
//		Row row = sheet.getRow(0);
//		Cell cell = row.getCell(0);
//		DataFormatter format = new DataFormatter();
//		String prdname = format.formatCellValue(cell);
//		
//		System.out.println(prdname);
//		Random rand = new Random();
//		int rannum = rand.nextInt(1000);
//		String productname = prdname+rannum;
//		driver.findElement(By.name("productname")).sendKeys(productname);
		
		Excell_utility excel = new Excell_utility();
		String productname = excel.getexceldata("Product", 0, 0);
		driver.findElement(By.name("productname")).sendKeys(productname);
		
		
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		
		// CAMPIGN CREATION

		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Campaign...\"]")).click();
		
		
		FileInputStream fis2 = new FileInputStream("./src/test/resources/framework.xlsx");
		Workbook book1 = WorkbookFactory.create(fis2);
		Sheet sheet1 = book1.getSheet("Campaign");
		Row row1 = sheet1.getRow(0);
		Cell cell1 = row1.getCell(0);
		DataFormatter format1 = new DataFormatter();
		String campname = format1.formatCellValue(cell1);
		
		System.out.println(campname);
		//driver.findElement(By.name("campaignname")).sendKeys(campname+rannum);
		
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/select.gif\"]")).click();
		
		Set<String> allWins = driver.getWindowHandles();
		Iterator<String> id = allWins.iterator();

		while (id.hasNext()) 
		{
			String win = id.next();
			driver.switchTo().window(win);
			String title = driver.getTitle();
			if (title.contains("Products&action"))

			{
				break;
			}
		}
		
		//driver.findElement(By.xpath("//a[text()='"+productname+"']")).click();
		
		Set<String> allwin1 = driver.getWindowHandles();
		Iterator<String> id1 = allwin1.iterator();
		while (id1.hasNext()) {
			String win1 = id1.next();
			driver.switchTo().window(win1);
			String title1 = driver.getTitle();
			if (title1.contains("Campaigns&action")) 
			{
				break;
			}
			
		}
		
			

		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		

	}

}
