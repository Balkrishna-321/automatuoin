package java_Utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Generic_utility.BaseClass;

public class Java_Utility_Files {

	WebDriver driver;
	
	public int Random() 
	{
		Random ran = new Random();
		int rannum = ran.nextInt(1000);
		return rannum;
	}
	
//-----------------------------------------------------------------------------------------------------	
	
	public void maxwindow () 
	{
		
		driver.manage().window().maximize();
	}

//------------------------------------------------------------------------------------------------------
	
	public void acceptalert() 
	{
		driver.switchTo().alert().accept();
	}

//---------------------------------------------------------------------------------------------------------
	
	public void switchwindow(WebDriver driver,String pagetitle) 
	{
		Set<String> allWins = driver.getWindowHandles();
		Iterator<String> id = allWins.iterator();

		while (id.hasNext()) 
		{
			String win = id.next();
			driver.switchTo().window(win);
			String title = driver.getTitle();
			if (title.contains(pagetitle))

			{
				break;
			}
		}
		
	}
	
//---------------------------------------------------------------------------------------------------------------
	
	public void impwait(WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
//------------------------------------------------------------------------------------------------------------
	
		public void screenShot() {
		TakesScreenshot ts = (TakesScreenshot)BaseClass.sDriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./ScreenShots/image.png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//--------------------------------------------------------------------------------------------------------------------

		public static String takeScreenShot1(WebDriver driver, String screenShotName) throws Throwable {
		
		TakesScreenshot takesSceenShot = (TakesScreenshot) driver;
		File src = takesSceenShot.getScreenshotAs(OutputType.FILE);
		File dst = new File("./ScreenShots/" + screenShotName +".png");
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
	}
	
}
