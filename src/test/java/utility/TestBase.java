package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class TestBase {
	public static WebDriver driver;
	static String excelPath ="src//test//resources//testing.xls";
	String driverPath ="src//test//resources//chromedriver.exe";
	static WebDriverWait driverWait ;
	static String screenShotPath = System.getProperty("user.dir")+"//screenshot//";
	@BeforeClass
	 public void setup() throws IOException 
	 {
		   System.setProperty("webdriver.chrome.driver", driverPath);
		    driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			System.out.println("browser Launched");
		    String URL =ExcelUtils.readExcel("login", 1, 0);
			driver.get(URL);
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,1000)");
			
	 }
	 
	 public static void driverWaitforLoad(By data, int seconds) 
	 {
		 driverWait = new WebDriverWait(driver,seconds);
		 driverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(data));
	 }
	 public static void waitForInvisibility(By data, int seconds) 
	 {
		 driverWait = new WebDriverWait(driver,seconds);
		 driverWait.until(ExpectedConditions.invisibilityOfElementLocated(data));
	 
	 }
	 public static void waitForactive(By data, int seconds) 
	 {
		 driverWait = new WebDriverWait(driver,seconds);
		 driverWait.until(ExpectedConditions.elementToBeClickable(data));
	 
	 }
	 
	 public  void scrnShot(String name) throws IOException 
	 {
		/* String nameofCurrMethod = Thread.currentThread() 
	             .getStackTrace()[1] 
	             .getMethodName();*/
		// System.out.println("Taking screenshot "+nameofCurrMethod);
		 TakesScreenshot scr = ((TakesScreenshot)driver);
		 File  screenshotFile= scr.getScreenshotAs(OutputType.FILE);
		 File dest = new File(screenShotPath+name+".png");
		
		 System.out.println(dest);FileUtils.copyFile(screenshotFile, dest);
		 

	 }
	 public void scrolling(int horizontal, int vertical , By getStarted) 
	 {
		 JavascriptExecutor js = ((JavascriptExecutor)driver);
		 WebElement ele = driver.findElement(getStarted);
		 if(getStarted!=null) 
		 {
			 js.executeScript("arguments[0].scrollIntoView();", ele);
		 }
		 else {
			 String a ="window.scrollBy(+horizontal+,+vertical)";
			 
			 js.executeScript(a); 
		 }
		 
	 }
	 
	 public void chkAlert() 
	 {
		
		 if(driverWait.until(ExpectedConditions.alertIsPresent()) != null) {
			 System.out.println("alert not present");
		 }else {
		 Alert alert = driver.switchTo().alert();
		 alert.accept();}
		 
	 }
	 public void clickOnElement(By locatorValue) 
	 {
		 driver.findElement(locatorValue).click();
	 }
	// @AfterClass
	 public void tearDown() 
	 {
		 driver.quit();
	 }

}
