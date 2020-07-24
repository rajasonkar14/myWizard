package objectRepo;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utility.ExcelUtils;
import utility.TestBase;

public class DeliveryDashboard extends TestBase{
	String activeWeek;
	public DeliveryDashboard(WebDriver driver) 
	{
		this.driver=driver;
	}
	By accountname = By.xpath("//span[1][@class='scope-selector-toggle-item']");
	By searchBoxAccName = By.xpath("//div[@class='ss-filter-text']/input");
	By selectAcc = By.xpath("//span[@class='ss-client']/span");
	By scrollId = By.id("scrollUl");
	By applyButton = By.xpath("//button[@class='btn btn-primary']");
	By projectId = By.xpath("/span[1][@class='scope-selector-toggle-item']");
	By activeWeekTile = By.xpath("//div[contains(@class,'carousel-active')]/div/div");
	By drpDwn = By.id("dropdownMenuButton");
	By dueDate = By.xpath("//*[contains(@class,'carousel-active')]//div/span[@class='myWizard-gov-slider-dues-values']");
	By submittedOn =By.xpath("//*[contains(@class,'carousel-active')]//div[@class='status-period-submitted']/span");
	By submittedBy =By.xpath("//div[contains(@class,'myWizard-gov-narrative-list-desc')]//i");
    By lastUpdatedBy =By.xpath("//div[contains(@class,'myWizard-gov-narrative-list-desc')]/div[2]/i");
	public void clickOnAccountName() 
	{
		driver.findElement(accountname).click();
		driverWaitforLoad(searchBoxAccName, 15);
	}
	public void enterAccName() 
	{
		driver.findElement(searchBoxAccName).sendKeys("Barclays");
		driverWaitforLoad(searchBoxAccName, 5);
		driver.findElement(selectAcc).click();
		driverWaitforLoad(scrollId, 10);
		driver.findElement(applyButton).click();
	}
	public void clickOnProjectName() throws InterruptedException 
	{
		Thread.sleep(2500);
		driver.findElement(projectId).click();
		driverWaitforLoad(searchBoxAccName, 15);
	}
	public void enterProjectName() throws InterruptedException, IOException 
	{
		driver.findElement(searchBoxAccName).sendKeys("9940318839");
		driverWaitforLoad(searchBoxAccName, 5);
		driver.findElement(selectAcc).click();
		driverWaitforLoad(scrollId, 10);
		driver.findElement(applyButton).click();
		Thread.sleep(2500);
	    activeWeek = driver.findElement(activeWeekTile).getText();
		System.out.println(activeWeek);
		ExcelUtils.createExcel(activeWeek,getdata());
	}
	public int selectFromDrpdwn() 
	{
		WebElement ele = driver.findElement(drpDwn);
		List<WebElement> e = ele.findElements(By.tagName("label"));
		return (e.size());
	}
    public Map<Integer, Object[]> getdata() 
    {
    	Select select = new Select(driver.findElement(drpDwn));
    	Map<Integer, Object[]> data = new HashMap<Integer, Object[]>(); 
	    data.put(1, new Object[]{ "Team Name", "Due Date", "Submitted On" ,"submitted By","Last Updated On"});
	for(int i=1;1<=selectFromDrpdwn();i++) 
	{
		select.selectByIndex(i);
		String teamName = driver.findElement(By.xpath("//div[contains(@class,'team-selector')]/label["+i+"]/span")).getText();
		driverWaitforLoad(submittedBy, 15);
		String dueDateText  = driver.findElement(dueDate).getText();
		String submittedOndate = driver.findElement(submittedOn).getText();
		String submittedByName = driver.findElement(submittedBy).getText();
		String lastUpdatedBydate = driver.findElement(lastUpdatedBy).getText();
		 
	    data.put(i+1, new Object[]{teamName,dueDateText,submittedOndate,submittedByName,lastUpdatedBydate}); 
	   
	}
	return data;
    }
}

