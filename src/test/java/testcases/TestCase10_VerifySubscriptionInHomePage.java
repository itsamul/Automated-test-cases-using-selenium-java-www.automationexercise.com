package testcases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCase10_VerifySubscriptionInHomePage {
	private WebDriver driver;

	@Test
	public void VerifySubscriptionInHomePage() throws InterruptedException {
		
		driver = new ChromeDriver();
		System.out.println("1. Launch browser");
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://automationexercise.com/");
		System.out.println("2. Navigate to url 'http://automationexercise.com'");
		
		assertEquals(driver.getTitle(), "Automation Exercise");
		System.out.println("3. Verify that home page is visible successfully");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.id("footer")));
		System.out.println("4. Scroll down to footer");
        assertEquals(driver.findElement(By.xpath("//div[@class='single-widget']/h2")).getText(),"SUBSCRIPTION");
		System.out.println("5. Verify text 'SUBSCRIPTION'");
		driver.findElement(By.id("susbscribe_email")).sendKeys("johndoe@email.com");
        driver.findElement(By.id("subscribe")).click();
        System.out.println("6. Enter email address in input and click arrow button");
        assertEquals(driver.findElement(By.xpath("//div[@class='alert-success alert']")).getText(),"You have been successfully subscribed!");
        System.out.println("7. Verify success message 'You have been successfully subscribed!' is visible");
        
		driver.quit();

	}
}
