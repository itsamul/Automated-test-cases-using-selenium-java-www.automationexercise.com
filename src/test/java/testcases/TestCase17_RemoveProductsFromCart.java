package testcases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase17_RemoveProductsFromCart {
	private WebDriver driver;

	@Test
	public void testToRemoveProductsFromCart() {
	
		driver = new ChromeDriver();
		System.out.println("1. Launch browser");
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://automationexercise.com/");
		System.out.println("2. Navigate to url 'http://automationexercise.com'");
		
		// ***** HOME PAGE *****
		assertEquals(driver.getTitle(), "Automation Exercise");
		System.out.println("3. Verified that home page is visible successfully");
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.partialLinkText("Products")))).click();
		// ***** ALL PRODUCTS PAGE *****
		assertEquals(driver.getTitle(), "Automation Exercise - All Products");
		assertEquals(driver.findElement(By.xpath("//div[@class='features_items']//h2[@class='title text-center']")).getText(), "ALL PRODUCTS");		
		new Actions(driver).moveToElement(driver.findElement(By.xpath("//div[contains(@class,'productinfo')]/p[text()='Blue Top']/following-sibling::a[contains(@class,'add-to-cart')]"))).build().perform();
		driver.findElement(By.xpath("//div[@class='overlay-content']/p[text()='Blue Top']//following-sibling::a[contains(@class,'add-to-cart')]")).click();
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")))).click();
		new Actions(driver).moveToElement(driver.findElement(By.xpath("//div[contains(@class,'productinfo')]/p[text()='Men Tshirt']/following-sibling::a[contains(@class,'add-to-cart')]"))).build().perform();
		driver.findElement(By.xpath("//div[@class='overlay-content']/p[text()='Men Tshirt']//following-sibling::a[contains(@class,'add-to-cart')]")).click();
		System.out.println("4. Add products to cart");
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")))).click();
		driver.findElement(By.partialLinkText("Cart")).click();
		System.out.println("5. Click 'Cart' button");
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id='cart_items']//li[text()='Shopping Cart']")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='cart_items']//li[text()='Shopping Cart']")).getText(), "Shopping Cart");
		System.out.println("6. Verify that cart page is displayed");
		
		// ***** SHOPPING CART PAGE *****
		String[] productsAddedToCart = {"Blue Top","Men Tshirt"};
		List<WebElement> productsInCart = driver.findElements(By.xpath("//td[@class='cart_description']/h4/a"));
		boolean flag = false;
		for (int i = 0; i < productsInCart.size(); i++) {
			List<String> productsAddedToCartList = Arrays.asList(productsAddedToCart);
			String productName = productsInCart.get(i).getText();
			//System.out.println(productName);
			if(productsAddedToCartList.contains(productName)) {
				flag = true;
				//System.out.println(productName + " Product present in the cart.");
				driver.findElement(By.xpath("//td[@class='cart_description']/h4/a[text()='" + productName + "']//following::a[@class='cart_quantity_delete']")).click();
				System.out.println("7. Click 'X' button corresponding to particular product");
				System.out.println(productName + " Product removed from the cart.");

			} else {
				//System.out.println(productName + " Product not present in the cart.");
				flag = false;
				break;
			}
		}	
		Assert.assertTrue(flag, "Product added to cart not found in the cart.");
		Assert.assertTrue(new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@id='empty_cart']/p/b")))).isDisplayed());
		System.out.println("8. Products removed from the cart.");
		
		
		driver.quit();

	}
}
