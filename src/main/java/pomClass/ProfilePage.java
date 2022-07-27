package pomClass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilClass.UtilClass;

public class ProfilePage extends UtilClass  {
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='_1ruvv2']")  
	private WebElement profileFullName;
	
	@FindBy(xpath="//div[text()='Manage Addresses']")  
	private WebElement manageAddress;
	
	@FindBy(xpath="//div[@class='_1QhEVk']")  
	private WebElement addNewAddress;
	
	@FindBy(xpath="//div[@class='_1lRtwc _1Jqgld']/input")  
	private WebElement inputFeildList;
	
	@FindBy(xpath="//textarea")  
	private WebElement textAddress;
	
	@FindBy(xpath="//button[text()='Save']")  
	private WebElement savebtn;
	
	@FindBy(xpath="//div[@class='_1CeZIA']")  
	private List<WebElement> saveAddressCount;
	
	
	//constructor
	public ProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	public boolean getFullProfileName() throws InterruptedException
	{
		explicitWait(driver, profileFullName);
		 String FullName=profileFullName.getText();
		 if(FullName.contains("priyanka"))
		 {
			 return true;
		 }
		 return false;
	}
	public void getManageAddress()
	{
		explicitWait(driver,manageAddress);
		manageAddress.click();
	}
	public void clickOnNewAddress()
	{
		addNewAddress.click();
	}
	public void fillOnAddressDetails()
	{
		String[] k= {"priyanka","9356457144","411014","Chandan Nagar"};
		
		 for(int i=0;i<4;i++)
		{
			inputFeildList.sendKeys(k[i]);
		}	
	}
	public void clickOnTextArea()
	{
		textAddress.sendKeys("Building no-5,Shivaji Chauk Pune");
	}
	public void clickOnSaveBtn()
	{
		savebtn.click();
	}
	public int clicksaveAddressCount()
	{
		return saveAddressCount.size();
	}
}
