package customCommands;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.apache.commons.io.*;
import config.StartBrowser;

public class ActionDrivers {
	WebDriver driver;
	
	public ActionDrivers() {
		driver = StartBrowser.driver;
	}
	/**
	 * Used to launch the web application
	 * @param url -- Application URL
	 * Example -- http://www.google.com
	 * @throws Exception 
	 */
	public void launchApplication(String url) throws Exception {
		try{
			driver.get(url);
			StartBrowser.childTest.pass("Successfully launched the Application: "+url);
		}catch(Exception e) {
			StartBrowser.childTest.fail("Could not launch the Application: "+url+StartBrowser.childTest.addScreenCaptureFromPath(takeScreenShot(driver)));
			throw e;
		}
		
	}
	/**
	 * Used to perform click operation
	 * @param locator -- Get it from package: objectRepository
	 * Example -- HomePage.lnkSignIn
	 * @throws Exception 
	 */
	public void click(By locator, String elementName) throws Exception {
		try {
			driver.findElement(locator).click();
			StartBrowser.childTest.pass("Successfully clicked on: "+elementName);
		}catch(Exception e) {
			StartBrowser.childTest.fail("Could not click on: "+elementName+StartBrowser.childTest.addScreenCaptureFromPath(takeScreenShot(driver)));
			throw e;
		}
		
	}
	/**
	 * Used to type input Data into text box
	 * @param locator -- Get it from package: objectRepository Example -- HomePage.lnkSignIn
	 * @param inputData -- Get it from xls or hard code
	 * @throws Exception 
	 */
	public void type(By locator, String inputData, String elementName) throws Exception {
		try {
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(inputData);
			StartBrowser.childTest.pass("Successfully typed "+inputData+" on: "+elementName);
		}catch(Exception e) {
			StartBrowser.childTest.fail("Could not type " + inputData+" on: "+elementName+StartBrowser.childTest.addScreenCaptureFromPath(takeScreenShot(driver)));
			throw e;
		}
		
	}
	/**
	 * Used to perform mouse hover on a web element
	 * @param locator -- Get it from package: objectRepository
	 * Example -- HomePage.lnkSignIn
	 * @throws Exception 
	 */
	public void mouseHover(By locator, String elementName) throws Exception {
		try {
			WebElement element = driver.findElement(locator);
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			StartBrowser.childTest.pass("Successfully mouse hovered on: "+elementName);
		}catch(Exception e) {
			StartBrowser.childTest.fail("Could not mouse hover on: "+elementName+StartBrowser.childTest.addScreenCaptureFromPath(takeScreenShot(driver)));
			throw e;
		}
		
		
	}
	/**
	 * 
	 * @param driver -- Input web driver
	 * @return -- returns the path where the screen shot is saved
	 */
	public String takeScreenShot(WebDriver driver) {
		//Declare destination Path
		String destPath = "C:\\Users\\ishvarya\\git\\HybridFramework\\ReportXLS\\screenshot\\";
		UUID uuid = UUID.randomUUID();
		String dateTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile,new File(destPath+"SShot"+uuid+dateTime+".jpeg"));
		}catch(Exception e) {
			System.out.println("Could not take screen shot");
			
		}
		return destPath+"SShot"+uuid+dateTime+".jpeg";
		
	}
	
	

}
