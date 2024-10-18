package rahulshettyacademy.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.LandingLoginPage;

public class BaseTest  {
	public WebDriver driver;
	public LandingLoginPage loginPage;
	public WebDriver initializeDriver() throws IOException
	{
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//rahulshettyacademy//resources//GlobalData.properties");
	prop.load(fis);
		String BrowserName =prop.getProperty("browser");
		
		if(BrowserName.contains("firefox"))
		{
		//System.setProperty("webdriver.gecko.driver","C:/Drivers/geckodriver-v0.33.0-win64/geckodriver.exe");
		 driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
		else if(BrowserName.contains("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver",
			//		"C:/Users/hp/Downloads/chromedriver-win64 (3)/chromedriver-win64.exe");
			 driver = new ChromeDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		return driver;
		
		
}
	@BeforeMethod
	public LandingLoginPage launchApplication() throws IOException
	{
		
		 driver = initializeDriver();
		    if (driver != null) {
		    	LandingLoginPage  landingPage = new LandingLoginPage(driver);
		        landingPage.goTo();
		        return landingPage;
		    }
		    // Handle the case when driver initialization fails
		    return null;
		
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
