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

public class VerifyUserCanAddNewAddress {
   static WebDriver driver;
	static HomePage hp;
	static ProfilePage pp;
	
	@BeforeClass
	public void beforeClass() throws IOException
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
	public void VerifyUserAddNewAddress() throws InterruptedException
	{
		System.out.println("i am in address page");
		 int previouseAddressCount=pp.clicksaveAddressCount();
		 pp.getManageAddress();
		 Thread.sleep(2000);
		 pp.clickOnNewAddress();
		 pp.fillOnAddressDetails();
		 pp.clickOnTextArea();
		 pp.clickOnSaveBtn();
		 int currentAddressCount=pp.clicksaveAddressCount();
		 Thread.sleep(2000);
		 Assert.assertEquals(previouseAddressCount+1,currentAddressCount);
	}
}
