package objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import utility.TestBase;

public class LoginPage extends TestBase {


	public LoginPage(WebDriver driver) 
	{
		this.driver= driver;
	}
	By userID = By.name("loginfmt");
	By nextButton  = By.id("idSIButton9");	
	By password = By.id("passwordInput");
	By signIn = By.id("submitButton");
	By securityCode = By.id("vipOoblink");
	By clickNo = By.id("idBtn_Back");
    By loader = By.className("UserWait");
    By announcement = By.xpath("//div[@id='announce']//*[@class='close']");
    By getStarted = By.xpath("//*[@id='mainContent']//*/a[1]");
	public void sendDataToUserID(String data) 
	{
		driverWaitforLoad(userID,20);
		driver.findElement(userID).sendKeys(data+"@accenture.com");

	}

	public void clickOnNext() 
	{
		clickOnElement(nextButton);	
	}

	public void enterPwd(String pwd) 
	{
		driverWaitforLoad(password,20);
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickSignIn()
	{
		driver.findElement(signIn).click();
	}

	public void clickOnDontHaveCode()
	{
		driverWaitforLoad(securityCode, 15);
		driver.findElement(securityCode).click();
	}

	public void clickOnNo() 
	{
		driverWaitforLoad(clickNo, 60);
		driver.findElement(clickNo).click();
	}

	public void waitforInvisibilityofLocator() 
	{
		waitForInvisibility(loader,120);
		
	}
	
	public void announcementBox() 
	{
		driverWaitforLoad(announcement, 60);
		driver.findElement(announcement).click();
	}
public void clickOnGetStarted() 
{
	scrolling(0, 0, getStarted);
	driver.findElement(getStarted).click();
}
}
