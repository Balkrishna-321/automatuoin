package organisation;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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

public class Create_Org {

		@SuppressWarnings("deprecation")
		public static void main(String[] args) throws Throwable {
			
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
			
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			FileInputStream fis1 = new FileInputStream("./src/test/resources/framework.xlsx");
			Workbook book = WorkbookFactory.create(fis1);
			Sheet sheet = book.getSheet("Organisation");
			Row row = sheet.getRow(0);
			Cell cell = row.getCell(0);
			DataFormatter format = new DataFormatter();
			String orgname = format.formatCellValue(cell);
			
			System.out.println(orgname);
			Random rand = new Random();
			int rannum = rand.nextInt(1000);
			driver.findElement(By.name("accountname")).sendKeys(orgname+rannum);
			
			FileInputStream fis2 = new FileInputStream("./src/test/resources/framework.xlsx");
			Workbook book1 = WorkbookFactory.create(fis2);
			Sheet sheet1 = book1.getSheet("Organisation");
			Row row1 = sheet1.getRow(1);
			Cell cell1 = row1.getCell(0);
			String phnum = format.formatCellValue(cell1);
			driver.findElement(By.xpath("//input[@id=\"phone\"]")).sendKeys(phnum);
			
			
			FileInputStream fis3 = new FileInputStream("./src/test/resources/framework.xlsx");
			Workbook book2 = WorkbookFactory.create(fis3);
			Sheet sheet2 = book2.getSheet("Organisation");
			Row row2 = sheet2.getRow(2);
			Cell cell2 = row2.getCell(0);
			String email = format.formatCellValue(cell2);
			driver.findElement(By.xpath("//input[@id=\"email1\"]")).sendKeys(email);
			
			
			
			driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
			
			Thread.sleep(1000);
			
			
			driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
			driver.findElement(By.linkText("Sign Out")).click();

	}

}
