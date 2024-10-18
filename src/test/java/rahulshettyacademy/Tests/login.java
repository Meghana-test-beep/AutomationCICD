package rahulshettyacademy.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingLoginPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;
import rahulshettyacademy.pageobjects.cartPage;

public class login extends BaseTest{

	@Test
	public void shopping() throws InterruptedException, IOException {
		String productName="ADIDAS ORIGINAL";
		
		//launchApplication();
		LandingLoginPage landingLoginPage = new LandingLoginPage(driver);
 landingLoginPage.loginApplication("meghanauday76@gmail.com", "Meghana@10");
		

		ProductCatalogue productcatalogue = new ProductCatalogue(driver);

List<WebElement>products = productcatalogue.getProductList();
productcatalogue.addProductToCart(productName);
productcatalogue.goToCartPage();
cartPage cartpage = new cartPage(driver);
Boolean match = cartpage.verifyProductDisplay(productName);
cartpage.goToCheckOut();
CheckoutPage checkout = new CheckoutPage(driver);
checkout.selectcountry("Ind");

ConfirmationPage confirmation =checkout.submitOrder();

 confirmation.VerifyConfirmationMessage();


		/*driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));// findElements(By.xpath("//*[@class='cartSection']/h3
		Boolean match=cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase("ADIDAS ORIGINAL"));
Assert.assertTrue(match);
driver.findElement(By.cssSelector(".totalRow button")).click();
gv).sendKeys("ind");
//driver.findElement(By.xpath("//i[@value='India'])")).click();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click(); // findElement(By.cssSelector(".ta-item:nth-of-type(2)
driver.findElement(By.cssSelector(".action__submit")).click();
String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
driver.close();
*/

















	}

}
