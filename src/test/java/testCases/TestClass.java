package testCases;
import org.testng.annotations.Test;

import objectRepo.LoginPage;
import utility.TestBase;
public class TestClass extends TestBase {

LoginPage login = new LoginPage(driver);	
	
@Test
public void m1() 
{
	loginToMyWizard();
}
public void loginToMyWizard() 
{
	login.sendDataToUserID("enter your enterprise id");
	login.clickOnNext();
	login.enterPwd("enter your pwd");
	login.clickSignIn();
	login.clickOnDontHaveCode();
	login.clickOnNo();
	login.announcementBox();
	login.waitforInvisibilityofLocator();
	login.clickOnGetStarted();	
}
}
