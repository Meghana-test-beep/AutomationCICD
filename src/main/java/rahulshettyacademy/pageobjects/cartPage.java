package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstarctComponents.AbstractComponents;

public class cartPage extends AbstractComponents {

	WebDriver driver;
	public  cartPage(WebDriver driver)
	{
		super(driver); // giving the driver from child to parent
		this.driver = driver;
PageFactory.initElements(driver,this);
	}
	
	@FindBy (css=".cartSection h3")
	List<WebElement>cartProducts;
	
	@FindBy (css=".totalRow button")
	static
	WebElement checkOut;
	
	
	

	
	public Boolean  verifyProductDisplay(String productName)
	{
		Boolean match= cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckoutPage goToCheckOut()
	{
		
			checkOut.click();
			return new CheckoutPage(driver);
		
		
		
	
	}

	

}
