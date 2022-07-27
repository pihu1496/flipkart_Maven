package pomClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilClass.UtilClass;

public class LoginPage extends UtilClass {
	 WebDriver driver;
	@FindBy(xpath="//input[@class='_2IX_2- VJZDxU']")
	 private WebElement emailfield;
	@FindBy(xpath="//input[@type='password']")
	 private WebElement password;
	@FindBy(xpath="(//button[@type='submit'])[2]")
	 private WebElement loginbtn;
     //constructor
	 public LoginPage(WebDriver driver)
	 {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	 }
    //public method for login page
	 public void getemail() throws InterruptedException, IOException
	 {
		 emailfield.sendKeys(getProperty("username"));
		
	 }
	 public void getpassword() throws IOException
	 {
    password.sendKeys(getProperty("password"));
  
	 }
	 public void getloginbtn() 
	{
	   loginbtn.click();
    }
}



