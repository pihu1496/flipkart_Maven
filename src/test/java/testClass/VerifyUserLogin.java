package testClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import baseClass.BaseClass;
import pomClass.HomePage;
import pomClass.LoginPage;

public class VerifyUserLogin {
	static WebDriver driver;
	 static LoginPage lp;
	 static ExtentHtmlReporter extentReporter;
	static ExtentReports report;
	static ExtentTest test;
	 static String path;
	
	@BeforeClass
	public void beforeClass()throws IOException
	{
		extentReporter =BaseClass.getHtmlReporter();
		report=BaseClass.getReports() ;
		test=BaseClass.getExtentTest("VerifyUserLogin");
		
		driver=BaseClass.getDriver("chrome");
	}
	@BeforeMethod
	public void beforeMethod()
	{
		lp=new LoginPage(driver);
	}
	@Test
	public void verifyUserLogin() throws InterruptedException, IOException
	{
		lp.getemail();
		lp.getpassword();
		lp.getloginbtn();
    
		HomePage hp = new HomePage(driver);
		Thread.sleep(4000);
		Assert.assertTrue(hp.getProfileName());
		System.out.println("in a login page");
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
	 if(result.getStatus()==ITestResult.SUCCESS)
	{
	  test.log(Status.PASS,result.getName()+"test passed");
    }
	else
	 {
	     path = lp.getScreenshot(driver,result.getName());
		test.log(Status.FAIL, result.getName()+"test failed",MediaEntityBuilder.createScreenCaptureFromPath(path).build());
      }
	}
	@AfterClass
	public void afterClass()
	{
		report.flush();
		System.out.println("hiii");
	}
}
