package testcases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase25_VerifyScrollUpUsingArrowButtonAndScrollDownfunctionality {
	private WebDriver driver;
	
	@Test
	public void testVerifyScrollUpUsingArrowButtonAndScrollDownfunctionality () {
		
		driver = new ChromeDriver();
		System.out.println("1. Launch browser");
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://automationexercise.com/");
		System.out.println("2. Navigate to url 'http://automationexercise.com'");
		
		assertEquals(driver.getTitle(), "Automation Exercise");
		System.out.println("3. Verify that home page is visible successfully");
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");		
		System.out.println("4. Scroll down page to bottom");
		Assert.assertTrue( driver.findElement(By.xpath("//h2[text()='Subscription']")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//h2[text()='Subscription']")).getText(),"SUBSCRIPTION");
		System.out.println("5. Verify 'SUBSCRIPTION' is visible");
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@id='scrollUp']")))).click();
		System.out.println("6. Click on arrow at bottom right side to move upward");
		Assert.assertTrue( driver.findElement(By.xpath("//h2[text()='Full-Fledged practice website for Automation Engineers']")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//h2[text()='Full-Fledged practice website for Automation Engineers']")).getText(),"Full-Fledged practice website for Automation Engineers");

		driver.quit();

	}
}
