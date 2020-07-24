package objectRepo;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.TestBase;

public class LandingPage extends TestBase{
	public LandingPage(WebDriver driver) 
	{
		this.driver= driver;
	}
	By tiltTable = By.id("mainContent");
	By mgmtTile = By.xpath("//a[text()='Management' and @class='tile-title']");
	By dlvryDashBrd = By.xpath("//a[text()='Delivery Dashboard' and @class='tile-title']");
	public void clickOnManagement() 
	{
		driverWaitforLoad(mgmtTile, 20);
		waitForactive(mgmtTile,20);
		driver.findElement(mgmtTile).click();
	}
	public void clickOnDeliveryDashBoard() 
	{
		driverWaitforLoad(dlvryDashBrd, 20);
		driver.findElement(dlvryDashBrd).click();
		Set<String> getWindows = driver.getWindowHandles();
		for(String a :getWindows)
		driver.switchTo().window(a);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
}
