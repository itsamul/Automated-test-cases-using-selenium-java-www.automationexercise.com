package testcases;

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

public class TestCase12_AddProductsInCart {
	private WebDriver driver;

	@Test
	public void testToAddProductToCart() {

		driver = new ChromeDriver();
		System.out.println("1. Launch browser");
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://automationexercise.com/");
		System.out.println("2. Navigate to url 'http://automationexercise.com'");
		
		Assert.assertEquals(driver.getTitle(), "Automation Exercise");
		System.out.println("3. Verify that home page is visible successfully");
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.partialLinkText("Products")))).click(); 
		System.out.println("4. Clicked on 'Products' button");
		Assert.assertEquals(driver.getTitle(), "Automation Exercise - All Products");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='features_items']//h2[@class='title text-center']")).getText(), "ALL PRODUCTS");
		new Actions(driver).moveToElement(driver.findElement(By.xpath("//div[contains(@class,'productinfo')]/p[text()='Blue Top']/following-sibling::a[contains(@class,'add-to-cart')]"))).build().perform();
		driver.findElement(By.xpath("//div[contains(@class,'overlay-content')]/p[text()='Blue Top']/following-sibling::a[contains(@class,'add-to-cart')]")).click();
		System.out.println("5. Hover over first product and click 'Add to cart'");
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")))).click();
		System.out.println("6. Click 'Continue Shopping' button");
		new Actions(driver).moveToElement(driver.findElement(By.xpath("//div[contains(@class,'productinfo')]/p[text()='Men Tshirt']/following-sibling::a[contains(@class,'add-to-cart')]"))).build().perform();
		driver.findElement(By.xpath("//div[contains(@class,'overlay-content')]/p[text()='Men Tshirt']/following-sibling::a[contains(@class,'add-to-cart')]")).click();
		System.out.println("7. Hover over second product and click 'Add to cart'");
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("View Cart")))).click();
		System.out.println("8. Click 'View Cart' button");
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
			} else {
				//System.out.println(productName + " Product not present in the cart.");
				flag = false;
				break;
			}
		}	
		Assert.assertTrue(flag, "Product added to cart not found in the cart.");
		System.out.println("9. Verify both products are added to Cart");
		Assert.assertEquals(driver.findElement(By.xpath("//td[@class='cart_description']/h4/a[text()='Blue Top']/following::td[@class='cart_price']/p")).getText().replace("Rs. ", ""), "500");
		Assert.assertEquals(driver.findElement(By.xpath("//td[@class='cart_description']/h4/a[text()='Blue Top']/following::td[@class='cart_price']/p/following::td[@class='cart_quantity']/button")).getText(), "1");
		Assert.assertEquals(driver.findElement(By.xpath("//td[@class='cart_description']/h4/a[text()='Blue Top']/following::td[@class='cart_price']/p/following::td[@class='cart_quantity']/button/following::td[@class='cart_total']/p[@class='cart_total_price']")).getText().replace("Rs. ", ""), "500");
		Assert.assertEquals(driver.findElement(By.xpath("//td[@class='cart_description']/h4/a[text()='Men Tshirt']/following::td[@class='cart_price']/p")).getText().replace("Rs. ", ""), "400");
		Assert.assertEquals(driver.findElement(By.xpath("//td[@class='cart_description']/h4/a[text()='Men Tshirt']/following::td[@class='cart_price']/p/following::td[@class='cart_quantity']/button")).getText().replace("Rs. ", ""), "1");
		Assert.assertEquals(driver.findElement(By.xpath("//td[@class='cart_description']/h4/a[text()='Men Tshirt']/following::td[@class='cart_price']/p/following::td[@class='cart_quantity']/button/following::td[@class='cart_total']/p[@class='cart_total_price']")).getText().replace("Rs. ", ""), "400");
		System.out.println("10. Verify their prices, quantity and total price");

		driver.quit();

	}
}
