package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase5_RegisterUserWithExistingEmail {
	private WebDriver driver;
	
	@DataProvider(name = "registerUser")
	public Object[][] register() {
		return new Object[][] { { "penny.jones@example.com", "Pass@123", "Penny Jones" }, };
	}

	@Test(dataProvider = "registerUser")
	public void testToRegisterUserWithExistingEmail(String str_Email, String str_Password, String str_Name) {

		driver = new ChromeDriver();
		System.out.println("1. Launch browser");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://automationexercise.com/");
		System.out.println("2. Navigate to url 'http://automationexercise.com'");
		
		Assert.assertEquals(driver.getTitle(), "Automation Exercise");
		System.out.println("3. Verified that home page is visible successfully");
		driver.findElement(By.linkText("Signup / Login")).click();
		System.out.println("4. Clicked on 'Signup / Login' button");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='signup-form']/h2")).getText(), "New User Signup!");
		System.out.println("5. Verified 'New User Signup!' is visible");
		driver.findElement(By.name("name")).clear();
		driver.findElement(By.name("name")).sendKeys(str_Name);
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.xpath("//div[@class='signup-form']//input[@type='email']")).sendKeys(str_Email);
		System.out.println("6. Entered name and already registered email address");
		driver.findElement(By.xpath("//button[text()='Signup']")).click();
		System.out.println("7. Clicked on 'Signup' button");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='signup-form']//p")).getText(), "Email Address already exist!");
		System.out.println("8. Verifyied error 'Email Address already exist!' is visible");
		Assert.assertEquals(driver.getTitle(), "Automation Exercise - Signup / Login");
		
		driver.quit();
	}

}
