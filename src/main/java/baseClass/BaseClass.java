package baseClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utilClass.UtilClass;

public class BaseClass extends UtilClass {
	static WebDriver driver=null;
	static ExtentHtmlReporter extentReporter;
	static ExtentReports report;
	 static ExtentTest test;
 public static WebDriver getDriver(String browser) throws IOException
 {
	if(driver==null)
	  {
		if(browser.equals("chrome"))
		 {
			System.setProperty("webdriver.chrome.driver","src\\main\\resources\\Browsers\\chromedriver.exe");
			driver=new ChromeDriver();
		  }
		  else if(browser.equals("edge"))
		  {
			  System.setProperty("webdriver.chrome.driver","src\\main\\resources\\Browsers\\msedgedriver.exe");
				driver=new EdgeDriver();
		  }
		  driver.get(UtilClass.getProperty("url"));
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  return driver;
 }
	else {
		
	  return driver;
	}
 }
 public static ExtentHtmlReporter getHtmlReporter()
 {
	 if (extentReporter==null)
	 {
		 extentReporter= new ExtentHtmlReporter("extentHtmlReporter.html");
		 
	 }
	 return extentReporter;
 }
 
 public static ExtentTest getExtentTest(String testName)
	{
		test = report.createTest(testName);
			return test;
	}
 public static ExtentReports getReports()
 {
	 if (report==null)
	 {
		 report= new ExtentReports();
		 report.attachReporter(extentReporter);
     }
	 return report;
 }
 }
