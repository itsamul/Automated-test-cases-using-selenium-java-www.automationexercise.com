package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase3_LoginUserWithIncorrectEmailAndPassword {
	private WebDriver driver;

	@DataProvider(name = "dpTestData")
	public Object[][] getTestData() {
		return new Object[][] {  { "penny.jonesx@example.com", "Pass@123", "Penny Jones" }, };
	}
	
	@Test (priority = 1, dataProvider = "dpTestData")
	public void LoginUserWithCorrectEmailAndPassword(String str_Email, String str_Password, String str_Name) {
		
		driver = new ChromeDriver();
		System.out.println("1. Launch browser");
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://automationexercise.com/");
		System.out.println("2. Navigate to url 'http://automationexercise.com'");
		Assert.assertEquals(driver.getTitle(), "Automation Exercise");
		System.out.println("3. Verified that home page is visible successfully");
		driver.findElement(By.linkText("Signup / Login")).click();
		System.out.println("4. Click on 'Signup / Login' button");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-form']/h2")).getText(),"Login to your account");
		System.out.println("5. Verified 'New User Signup!' is visible");
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.xpath("//div[@class='login-form']//input[@type='email']")).sendKeys(str_Email);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(str_Password);
		System.out.println("6. Enter incorrect email address and password");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		System.out.println("7. Clicked on 'Login' button");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-form']//p")).getText(), "Your email or password is incorrect!");
		System.out.println("8. Verified error 'Your email or password is incorrect!' is visible");
		Assert.assertEquals(driver.getTitle(), "Automation Exercise - Signup / Login" );
		
		driver.quit();
	}
	
}
