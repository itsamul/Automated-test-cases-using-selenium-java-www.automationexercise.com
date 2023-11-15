package testcases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase13_VerifyProductquantityInCart {
	@Test
	public void verifyProductquantityInCart() throws InterruptedException {
		String productName = "Winter Top";
		WebDriver driver;
		
		driver = new ChromeDriver();
		System.out.println("1. Launch browser");
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://automationexercise.com/");
		System.out.println("2. Navigate to url 'http://automationexercise.com'");
		
		assertEquals(driver.getTitle(), "Automation Exercise");
		System.out.println("3. Verify that home page is visible successfully");
		driver.findElement(By.partialLinkText("Products")).click(); 
		assertEquals(driver.getTitle(), "Automation Exercise - All Products");
		assertEquals(driver.findElement(By.xpath("//div[@class='features_items']//h2[@class='title text-center']")).getText(), "ALL PRODUCTS");
		driver.findElement(By.xpath("//div[@class='single-products']/div[@class='productinfo text-center']/p[text()='"+ productName +"']/following::a[text()='View Product']")).click();
		System.out.println("4. Click 'View Product' for any product on home page");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='product-information']/h2")).getText(),productName);
		System.out.println("5. Verify product detail is opened");
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.id("quantity")))).clear();
		driver.findElement(By.id("quantity")).sendKeys("4");
		System.out.println("6. Increase quantity to 4");
		driver.findElement(By.xpath("//button[@class='btn btn-default cart']")).click();
		System.out.println("7. Click 'Add to cart' button");
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("View Cart")))).click();
		System.out.println("8. Click 'View Cart' button");
		Assert.assertEquals(driver.findElement(By.xpath("//td[@class='cart_description']/h4/a")).getText(), productName);
		Assert.assertEquals(driver.findElement(By.xpath("//td[@class='cart_description']/h4/a[text()='" + productName + "']/following::td[@class='cart_price']/p/following::td[@class='cart_quantity']/button")).getText(), "4");
		System.out.println("9. Verify that product is displayed in cart page with exact quantity");
		
		driver.quit();

	}
}
