package product;

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
import org.testng.Assert;

public class Create_Product {

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
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Product...\"]")).click();
		
		Thread.sleep(1000);
		
		FileInputStream fis1 = new FileInputStream("./src/test/resources/framework1.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sheet = book.getSheet("Product");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		DataFormatter format = new DataFormatter();
		String prdname = format.formatCellValue(cell);
		
		System.out.println(prdname);
		Random rand = new Random();
		int rannum = rand.nextInt(1000);
		driver.findElement(By.name("productname")).sendKeys(prdname+rannum);
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		
		String actData = driver.findElement(By.xpath("//td[@id=\"mouseArea_Product Name\"]")).getText();
		
		Assert.assertEquals(actData,prdname+rannum, "product is created and validated");
		
		//Product_Validation vali = new Product_Validation(driver);
		//vali.validateproduct(driver, prdname);
		
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		
		
	}

}
