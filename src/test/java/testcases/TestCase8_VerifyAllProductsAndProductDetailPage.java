package testcases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCase8_VerifyAllProductsAndProductDetailPage{
	private WebDriver driver;

	@Test
	public void VerifyAllProductsAndProductDetailPage() {

		driver = new ChromeDriver();
		System.out.println("1. Launch browser");
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://automationexercise.com/");
		System.out.println("2. Navigate to url 'http://automationexercise.com'");
				
		assertEquals(driver.getTitle(), "Automation Exercise");
		driver.findElement(By.partialLinkText("Products")).click(); 
		System.out.println("4. Clicked on 'Products' button");
		assertEquals(driver.getTitle(), "Automation Exercise - All Products");
		assertEquals(driver.findElement(By.xpath("//div[@class='features_items']//h2[@class='title text-center']")).getText(), "ALL PRODUCTS");
		System.out.println("5. Verify user is navigated to ALL PRODUCTS page successfully");
		System.out.println("6. The products list is visible");
		driver.findElement(By.xpath("(//div[@class='single-products'])[1]/following::a[1]")).click();
		System.out.println("7. Click on 'View Product' of first product");
		assertEquals(driver.getTitle(), "Automation Exercise - Product Details");
		System.out.println("8. User is landed to product detail page");
		assertEquals(driver.findElement(By.xpath("//div[@class='product-information']//h2")).getText(), "Blue Top");
		assertEquals(driver.findElement(By.xpath("//div[@class='product-information']/h2/following::p")).getText(), "Category: Women > Tops");
		assertEquals(driver.findElement(By.xpath("//div[@class='product-information']/h2/following::span/span")).getText(), "Rs. 500");
		assertEquals(driver.findElement(By.xpath("//div[@class='product-details']//p[2]")).getText(), "Availability: In Stock");
		assertEquals(driver.findElement(By.xpath("//div[@class='product-information']//span/following::p[2]")).getText(), "Condition: New");
		assertEquals(driver.findElement(By.xpath("//div[@class='product-information']//span/following::p[3]")).getText(), "Brand: Polo");
		System.out.println("9. Verify that detail detail is visible: product name, category, price, availability, condition, brand");
		
		driver.quit();
		
	}
}
