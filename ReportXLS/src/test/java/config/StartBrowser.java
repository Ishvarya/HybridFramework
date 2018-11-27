package config;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class StartBrowser {
  public static WebDriver driver;
  
  public ExtentHtmlReporter htmlReporter;
  public static ExtentReports extent;
  public static ExtentTest parentTest;
  public static ExtentTest childTest;
  String method;
  
  @BeforeTest
  public void report() {
	  htmlReporter = new ExtentHtmlReporter("report/MyHtmlReport.html");
	  extent = new ExtentReports();
	  extent.attachReporter(htmlReporter);
  }
  
  @BeforeMethod
  public void getMethodName(Method method) {
	  parentTest = extent.createTest(method.getName());
  }
  
  @BeforeClass
  public void beforeClass() {
	  //Select the browser
	  String browserType = "Firefox";
	  if(browserType.equals("Firefox")) {
		  //Set the system property to point to gecko driver
		  System.setProperty("webdriver.gecko.driver", "C:\\Users\\ishvarya\\git\\HybridFramework\\Webdrivers\\geckodriver.exe");	
		  
		  //Create a new instance of the Firefox driver
		  driver = new FirefoxDriver();
	  }
	  else if(browserType.equals("Chrome")) {
		  //Set the system property to point to chrome driver
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\ishvarya\\git\\HybridFramework\\Webdrivers\\chromedriver.exe");
		  
		  //Create a new instance of the Chrome driver
		  driver = new ChromeDriver();
	  }
	  
	  //open the browser
	  //Put a Implicit wait
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      //Maximize the window
	  driver.manage().window().maximize();
	  
	  
  }

  @AfterClass
  public void afterClass() {
	// Close the driver
	driver.quit();
	extent.flush();
  }

}
