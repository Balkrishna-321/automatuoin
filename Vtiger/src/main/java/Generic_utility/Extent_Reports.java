package Generic_utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java_Utility.Java_Utility_Files;

public class Extent_Reports implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	

	public void onStart(ITestContext context) {
		
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		
		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReportGen/Report.html"+time);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("VtigerReports");
		spark.config().setReportName("Bala");
		
				
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("platform", "windows");
		report.setSystemInfo("executedBy", "Bala");
		report.setSystemInfo("reviewedby", "Mishra");


	}

//-----------------------------------------------------------------------------------


	public void onTestStart(ITestResult result) {
		
		test=report.createTest(result.getMethod().getMethodName());
	}
	
//------------------------------------------------------------------------------------------------------	
	
	public void onTestSuccess(ITestResult result) {

		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
		System.out.println("Script Pass");
		
	}		
	
	
//------------------------------------------------------------------------------------------------------------

	

	public void onTestFailure(ITestResult result) {

		String testname = result.getMethod().getMethodName();
		test.log(Status.FAIL,testname+">>>>>>FAILED<<<<<<");
		test.log(Status.FAIL,result.getMethod().getMethodName());
		test.log(Status.FAIL,result.getThrowable());
		
//		String screenshot = null;
//		try {
//			screenshot = Java_Utility_Files.takeScreenShot1(BaseClass.sDriver, result.getMethod().getMethodName());
//
//		} catch (Throwable e) {
//
//			e.printStackTrace();
//		}
//		
//		
//		test.addScreenCaptureFromPath(screenshot);
		
		TakesScreenshot takesSceenShot = (TakesScreenshot) BaseClass.sDriver;
		
				File src = takesSceenShot.getScreenshotAs(OutputType.FILE);
				File dst = new File("./FailedScripts.png");
				try {
					FileUtils.copyFile(src, dst);
				} catch (IOException e) {
		
					e.printStackTrace();
				}
		
}
		
	
	
//------------------------------------------------------------------------------------------------------------	
	
	public void onTestSkipped(ITestResult result) {
	
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
		System.out.println("Script SKIP");
		
		String screenshot=null;
		try {
			screenshot = Java_Utility_Files.takeScreenShot1(BaseClass.sDriver, result.getMethod().getMethodName());

		} catch (Throwable e) {

			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(screenshot);
		}
		
	
	
//------------------------------------------------------------------------------------------------------------
	
	
	public void onFinish(ITestContext context) {
		
		
		report.flush();
		}
		

}
