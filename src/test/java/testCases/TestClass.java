package testCases;
import java.io.IOException;

import org.testng.annotations.Test;

import objectRepo.DeliveryDashboard;
import objectRepo.LandingPage;
import objectRepo.LoginPage;
import utility.ExcelUtils;
import utility.TestBase;
public class TestClass extends TestBase {

LoginPage login = new LoginPage(driver);	
LandingPage landingPage = new LandingPage(driver);	
DeliveryDashboard deliverydshbrd = new DeliveryDashboard(driver);
@Test(priority=0)
public void login() throws IOException 
{
	//ExcelUtils.createExcel();
	
	loginToMyWizard();
}
@Test(priority=1)
public void clickDlvryDshbrd() throws InterruptedException, IOException 
{
	landingPage.clickOnManagement();
	landingPage.clickOnDeliveryDashBoard();
	deliverydshbrd.clickOnAccountName();
	deliverydshbrd.enterAccName();
	///////////////debug from here
	deliverydshbrd.clickOnProjectName();
	deliverydshbrd.enterProjectName();//test case complt go and chk excel
}
public void loginToMyWizard() throws IOException 
{
	login.sendDataToUserID(ExcelUtils.readExcel("login", 1, 2));
	login.clickOnNext();
	login.enterPwd(ExcelUtils.readExcel("login", 1, 3));
	login.clickSignIn();
	login.clickOnDontHaveCode();
	login.clickOnNo();
	login.announcementBox();
	login.waitforInvisibilityofLocator();
	login.clickOnGetStarted();	
	
}




}
