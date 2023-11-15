package testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase21_AddReviewOnProduct {
	private WebDriver driver;
		
	@DataProvider(name = "dpTestData")
	public Object[][] getTestData() {
		return new Object[][] { { "Penny Jones", "penny.jones@example.com", "This is the test message" }, };
	}
	
	@Test(dataProvider = "dpTestData")
	public void testToAddReviewOnProduct(String str_name, String str_Email, String str_review) {
		
		
		driver = new ChromeDriver();
		System.out.println("1. Launch browser");
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://automationexercise.com/");
		System.out.println("2. Navigate to url 'http://automationexercise.com'");
		
		assertEquals(driver.getTitle(), "Automation Exercise");
		// ***** HOME PAGE *****
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.partialLinkText("Products")))).click(); 
		System.out.println("3. Clicked on 'Products' button");
		
		// ***** ALL PRODUCTS PAGE *****
		assertEquals(driver.getTitle(), "Automation Exercise - All Products");
		assertEquals(driver.findElement(By.xpath("//div[@class='features_items']//h2[@class='title text-center']")).getText(), "ALL PRODUCTS");
		System.out.println("4. Verify user is navigated to ALL PRODUCTS page successfully");
		WebElement viewProduct = driver.findElement(By.xpath("//div[@class='single-products']/div[@class='productinfo text-center']/p[text()='Blue Top']/following::a[text()='View Product']"));
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(viewProduct)).click();
		System.out.println("5. Click on 'View Product' button");
		
		// ***** PRODUCTS DETAILS PAGE *****
		assertTrue(driver.findElement(By.xpath("//a[text()='Write Your Review']")).isDisplayed());
		assertEquals(driver.findElement(By.xpath("//a[text()='Write Your Review']")).getText(), "WRITE YOUR REVIEW");
		System.out.println("6. Verify 'Write Your Review' is visible");
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys(str_name);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(str_Email);		
		driver.findElement(By.id("review")).clear();
		driver.findElement(By.id("review")).sendKeys(str_review);
		System.out.println("7. Enter name, email, review");
		driver.findElement(By.id("button-review")).click();
		System.out.println("8. Clicked 'Submit' button");
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert-success alert']")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert-success alert']")).getText(), "Thank you for your review.");
		System.out.println("9. Verify success message 'Thank you for your review.' is visible");	

		driver.quit();

	}

}
