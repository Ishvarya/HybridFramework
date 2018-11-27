package testScripts;

import org.testng.annotations.Test;

import config.StartBrowser;
import customCommands.ActionDrivers;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.MyAccountPage;

public class TestCase1 extends StartBrowser{
  @Test
  public void testSignInSignOut() throws Exception {
	  ActionDrivers actionDriver = new ActionDrivers();
	  StartBrowser.childTest = StartBrowser.parentTest.createNode("Sign In Sign Out to Costco");
	  actionDriver.launchApplication("https://www.costco.com");
	  actionDriver.click(HomePage.lnkSignIn,"lnkSignIn");
	  actionDriver.type(LoginPage.txtEmail, "I.Siddharth@pre-automation.com","txtEmail");
	  actionDriver.type(LoginPage.txtPassword, "Password123","txtPassword");
	  actionDriver.click(LoginPage.btnSignIn,"btnSignIn");
	  actionDriver.mouseHover(MyAccountPage.lnkMyAccount,"lnkMyAccount");
	  actionDriver.click(MyAccountPage.btnSignOut,"btnSignOut");
  }
}
