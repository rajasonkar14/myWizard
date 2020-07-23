package testCases;
import java.io.IOException;

import org.testng.annotations.Test;

import objectRepo.LoginPage;
import utility.ExcelUtils;
import utility.TestBase;
public class TestClass extends TestBase {

LoginPage login = new LoginPage(driver);	
	
@Test
public void m1() throws IOException 
{
	
	loginToMyWizard();
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
