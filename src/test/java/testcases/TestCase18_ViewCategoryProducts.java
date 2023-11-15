package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase18_ViewCategoryProducts {
	private WebDriver driver;

	@Test
	public void testToViewCategoryProducts() {

		driver = new ChromeDriver();
		System.out.println("1. Launch browser");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://automationexercise.com/");
		System.out.println("2. Navigate to url 'http://automationexercise.com'");

		Assert.assertEquals(driver.getTitle(), "Automation Exercise");
		System.out.println("3. Verified that home page is visible successfully");
		driver.findElement(By.linkText("Test Cases")).click();
		System.out.println("4. Click on 'Test Cases' button");
		Assert.assertEquals(driver.findElement(By.xpath("//h2[contains(@class,'title')]/b")).getText(), "Test Cases");
		System.out.println("5. Verify user is navigated to test cases page successfully");
		
		driver.quit();
	}

}
