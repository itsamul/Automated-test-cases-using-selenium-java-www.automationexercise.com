package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase26_VerifyScrollUpWithoutArrowButtonAndScrollDownfunctionality {
	private WebDriver driver;

	@Test
	public void testVerifyScrollUpWithoutArrowButtonAndScrollDownfunctionality () {
		
		driver = new ChromeDriver();
		System.out.println("1. Launch browser");
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://automationexercise.com/");
		System.out.println("2. Navigate to url 'http://automationexercise.com'");
		
		Assert.assertEquals(driver.getTitle(), "Automation Exercise");
		System.out.println("3. Verify that home page is visible successfully");
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");		
		System.out.println("4. Scroll down page to bottom");
		Assert.assertTrue( driver.findElement(By.xpath("//h2[text()='Subscription']")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//h2[text()='Subscription']")).getText(),"SUBSCRIPTION");
		System.out.println("5. Verify 'SUBSCRIPTION' is visible");
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");		
		Assert.assertTrue( driver.findElement(By.xpath("//h2[text()='Full-Fledged practice website for Automation Engineers']")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//h2[text()='Full-Fledged practice website for Automation Engineers']")).getText(),"Full-Fledged practice website for Automation Engineers");
		
		driver.quit();

	}
}