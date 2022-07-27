package testClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pomClass.HomePage;
import pomClass.ProfilePage;
public class VerifyUserCanGetProfile {
	static WebDriver driver;
	static HomePage hp;
	static ProfilePage pp;
	
	@BeforeClass
	public void beforeClass()throws IOException
	{
		driver=BaseClass.getDriver("chrome");
	}
	@BeforeMethod
	public void beforeMethod()
	{
		hp=new HomePage(driver);
		pp=new ProfilePage(driver);
	}
	@Test
	public void  verifyLoginUserProfile() throws InterruptedException, IOException
	{
		System.out.println("hii verify in user login page");
		hp.moveToProfileName();
		hp.getOffset(driver);
		hp.clickOnMyProfile();
		Thread.sleep(2000);
		System.out.println(hp.getProfileName());
		Assert.assertEquals(hp.getProfileName(), "priyanka");
		System.out.println("i am in home page");
		Thread.sleep(4000);
	}
	@Test(priority=1)
	public void  verifyUserCanGoToProfile() throws InterruptedException, IOException
	{
		System.out.println("profile page entry");
		 Thread.sleep(2000);
		 System.out.println(pp.getFullProfileName());
	    Assert.assertEquals(pp.getFullProfileName(),"priyanka kalpande");
	    System.out.println("i am in profile page");
	    Thread.sleep(4000);
	}
}
