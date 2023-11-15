package testcases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase9_SearchProduct {
	private WebDriver driver;

	@Test
	public void searchProduct() {
		
		driver = new ChromeDriver();
		System.out.println("1. Launch browser");
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://automationexercise.com/");
		System.out.println("2. Navigate to url 'http://automationexercise.com'");
		
		Assert.assertEquals(driver.getTitle(), "Automation Exercise");
		driver.findElement(By.partialLinkText("Products")).click(); 
		System.out.println("4. Clicked on 'Products' button");
		assertEquals(driver.getTitle(), "Automation Exercise - All Products");
		assertEquals(driver.findElement(By.xpath("//div[@class='features_items']//h2[@class='title text-center']")).getText(), "ALL PRODUCTS");
		System.out.println("5. Verify user is navigated to ALL PRODUCTS page successfully");
		driver.findElement(By.id("search_product")).clear();
		driver.findElement(By.id("search_product")).sendKeys("winter top");
		driver.findElement(By.id("submit_search")).click();
		System.out.println("6. Entered product name in search input and clicked search button");
		assertEquals(driver.findElement(By.xpath("//div[@class='features_items']//h2[@class='title text-center']")).getText(), "SEARCHED PRODUCTS");
		System.out.println("7. Verified 'SEARCHED PRODUCTS' is visible");
		assertEquals(driver.findElement(By.xpath("//div[@class='productinfo text-center']/p")).getText(), "Winter Top");
		System.out.println("8. Verified all the products related to search are visible");
		
		driver.quit();
	}
}
