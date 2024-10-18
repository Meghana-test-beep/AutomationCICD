package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstarctComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents{

	WebDriver driver;
	public  ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver= driver;//giving the driver from child to parent
PageFactory.initElements(driver,this);
	}

	@FindBy(css=".mb-3")
	List<WebElement>products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	
	By productsby =By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage =By.id("toast-container");

	public List<WebElement> getProductList()
	{
		waitForelementToAppear(productsby);
		return products;
	}
	public WebElement getProductByName(String productName)
	{
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName))
				.findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) throws InterruptedException
	{
		WebElement prod = getProductByName(productName);
		prod.findElement( addToCart).click();
		// page factory cannot be applied within webelement .findlemenT
		waitForelementToAppear(toastMessage);
	
		waitForElementToDisappear(spinner);
		}
	
}
