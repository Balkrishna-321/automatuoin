package Generic_utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listnerimp implements ITestListener {

	
	public void onTestFailure(ITestResult result) {
		
		 if (BaseClass.sDriver != null) {
	            TakesScreenshot takesScreenshot = (TakesScreenshot) BaseClass.sDriver;

	            File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
	            File dst = new File("./FailedScripts.png");
	            try {
	                FileUtils.copyFile(src, dst);
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        } else {
	            System.out.println("WebDriver is null. Screenshot cannot be captured.");
		
		
//		TakesScreenshot takesSceenShot = (TakesScreenshot) BaseClass.sDriver;
//
//		File src = takesSceenShot.getScreenshotAs(OutputType.FILE);
//		File dst = new File("./FailedScripts.png");
//		try {
//			FileUtils.copyFile(src, dst);
//		} catch (IOException e) {
//
//			e.printStackTrace();
//		}
		
		
		
	}

	
	}
}
