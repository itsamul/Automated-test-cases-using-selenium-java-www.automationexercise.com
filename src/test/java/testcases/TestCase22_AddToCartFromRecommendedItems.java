package testcases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase22_AddToCartFromRecommendedItems {
	private WebDriver driver;

	@Test
	public void testAddToCartFromRecommendedItems() throws InterruptedException {
	
		driver = new ChromeDriver();
		System.out.println("1. Launch browser");
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://automationexercise.com/");
		System.out.println("2. Navigate to url 'http://automationexercise.com'");
		
		assertEquals(driver.getTitle(), "Automation Exercise");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//div[@class='recommended_items']//h2[@class='title text-center']")));
		System.out.println("3. Scroll to bottom of page");
		Assert.assertTrue( driver.findElement(By.xpath("//div[@class='recommended_items']//h2[@class='title text-center']")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='recommended_items']//h2[@class='title text-center']")).getText(),"RECOMMENDED ITEMS");
		System.out.println("4. Verify 'RECOMMENDED ITEMS' are visible");
		driver.findElement(By.xpath("//div[@id='recommended-item-carousel']//div[@class='single-products']//p[text()='Winter Top']//following::a[@class='btn btn-default add-to-cart']")).click();
		System.out.println("5. Click on 'Add To Cart' on Recommended product");
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")))).click();
		System.out.println("6. Click on 'View Cart' button");
		driver.findElement(By.partialLinkText("Cart")).click();
		String[] productsAddedToCart = { "Winter Top" };
		List<WebElement> productsInCart = driver.findElements(By.xpath("//td[@class='cart_description']/h4/a"));
		boolean flag = false;
		for (int i = 0; i < productsInCart.size(); i++) {
			List<String> productsAddedToCartList = Arrays.asList(productsAddedToCart);
			String productName = productsInCart.get(i).getText();
			//System.out.println(productName);
			if (productsAddedToCartList.contains(productName)) {
				flag = true;
				//System.out.println(productName + " Product present in the cart.");
			} else {
				//System.out.println(productName + " Product not present in the cart.");
				flag = false;
				break;
			}
		}
		Assert.assertTrue(flag, "Product added to cart not found in the cart.");
		System.out.println("7. Verify that product is displayed in cart page");

		driver.quit();

	}
}
