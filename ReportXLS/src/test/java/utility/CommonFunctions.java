 package utility;

import config.StartBrowser;
import customCommands.ActionDrivers;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.MyAccountPage;

public class CommonFunctions {
	
	public ActionDrivers actionDriver;
	
	public CommonFunctions() {
		actionDriver = new ActionDrivers();
	}
	/**
	 * Used to sign in to the web application
	 * @throws Exception -- when locator not found
	 */
	public void signIn(String sEmail, String sPassword) throws Exception {
		  StartBrowser.childTest = StartBrowser.parentTest.createNode("Sign In to Costco");
		  ActionDrivers actionDriver = new ActionDrivers();
		  actionDriver.launchApplication("https://www.costco.com");
		  actionDriver.click(HomePage.lnkSignIn,"lnkSignIn");
		  actionDriver.type(LoginPage.txtEmail, sEmail,"txtEmail");
		  actionDriver.type(LoginPage.txtPassword, sPassword,"txtPassword");
		  actionDriver.click(LoginPage.btnSignIn,"btnSignIn");
		
	}
	/**
	 * Used to sign out of the web application
	 * @throws Exception -- when locator not found
	 */
	public void signOut() throws Exception {
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Sign Out of Costco");
		  actionDriver.mouseHover(MyAccountPage.lnkMyAccount,"lnkMyAccount");
		  //actionDriver.click(MyAccountPage.btnSignOut,"btnSignOut");
		
	}

}
