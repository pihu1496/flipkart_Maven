package pomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilClass.UtilClass;

public class HomePage extends UtilClass {
    WebDriver driver;
	@FindBy(xpath="(//div[@class='_28p97w'])[1]")  
	private WebElement profileName;
	@FindBy(xpath="//div[text()='My Profile']")
	private WebElement myProfile;
	//constructor
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
//method for profile page
public boolean getProfileName() throws InterruptedException
{
	System.out.println("hello");
	explicitWait(driver, profileName);
	String pName= profileName.getText();
	System.out.println(pName);
	if(pName.equals("priyanka"))
	{
	return true;
	}
	return false;
}
public void moveToProfileName() throws InterruptedException
{
	Thread.sleep(5000);
	Actions act= new Actions(driver);
    act.moveToElement(profileName).click().build().perform();
    Thread.sleep(1000);
}
public void clickOnMyProfile()
   {
	explicitWait(driver, myProfile);
	myProfile.click();
	
}
}
