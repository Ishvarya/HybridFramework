package objectRepository;

import org.openqa.selenium.By;

public class LoginPage {
	
	public static By txtEmail = By.id("logonId");
	public static By txtPassword = By.id("logonPassword");
	public static By btnSignIn = By.xpath("//input[@value = 'Sign In']");

}
