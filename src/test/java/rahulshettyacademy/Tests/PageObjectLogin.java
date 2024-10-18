package rahulshettyacademy.Tests;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.LandingLoginPage;


public class PageObjectLogin {

			public static void main(String[] args) {
				System.setProperty("webdriver.gecko.driver", "C:/Drivers/geckodriver-v0.33.0-win64/geckodriver.exe");
				FirefoxDriver driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
			
				driver.findElement(By.id("userEmail")).sendKeys("meghanauday76@gmail.com");
				driver.findElement(By.id("userPassword")).sendKeys("Meghana@10");
				driver.findElement(By.id("login")).click();

				
			
				
				
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".mb-3"))));
				List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
				WebElement prod = products.stream()
						.filter(product -> product.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL"))
						.findFirst().orElse(null);
				prod.findElement(By.cssSelector(".card-body button:last-of-type")).click(); // select the last option of the button element

				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("toast-container"))));
				wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
				driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
				List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));// findElements(By.xpath("//*[@class='cartSection']/h3
				Boolean match=cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase("ADIDAS ORIGINAL"));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("ind");
		//driver.findElement(By.xpath("//i[@value='India'])")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click(); // findElement(By.cssSelector(".ta-item:nth-of-type(2)
		driver.findElement(By.cssSelector(".action__submit")).click();
		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();


















			}

		


	}


