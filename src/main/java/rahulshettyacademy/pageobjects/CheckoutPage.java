package rahulshettyacademy.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.AbstarctComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents {
WebDriver driver;

	public CheckoutPage(WebDriver driver) { // gives life to webdriver
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement Country;
	@FindBy(css="action__submit")
	private WebElement Submit;
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement selectCountry;
	
	By results = By.cssSelector(".ta-results");
	
	
	
	public void selectcountry(String countryName)
	{
		Actions action = new Actions(driver);
		action.sendKeys(Country,countryName).build().perform();
	
		waitForelementToAppear(By.cssSelector(".ta-results"));
		selectCountry.click();
	}
	public ConfirmationPage submitOrder()
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		Submit.click();
		return new ConfirmationPage(driver);
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


