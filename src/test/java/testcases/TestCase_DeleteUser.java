package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase_DeleteUser {
	private WebDriver driver;

	@DataProvider(name = "dpDeleteUser")
	public Object[][] getDeleteUserData() {
		return new Object[][] { { "penny.jones@example.com", "Pass@123", "Penny Jones" }, 
			{ "darryl.langosh@example.org", "Pass@123", "Darryl Langosh"},
			{ "jennie.rodriguez@example.net", "Pass@123", "Jennie Rodriguez" },
			{ "frankie.carter@example.org", "Pass@123", "Frankie Carter"}, 
			};
	}

	@Test(dataProvider = "dpDeleteUser")
	public void deleteExistingUser(String str_Email, String str_Password, String str_Name) {
		
		driver = new ChromeDriver();
		System.out.println("1. Launch browser");
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://automationexercise.com/");
		System.out.println("2. Navigate to url 'http://automationexercise.com'");
		
		Assert.assertEquals(driver.getTitle(), "Automation Exercise");
		driver.findElement(By.linkText("Signup / Login")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-form']/h2")).getText(), "Login to your account");
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.xpath("//div[@class='login-form']//input[@type='email']")).sendKeys(str_Email);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(str_Password);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='header']//a/b")).getText(), str_Name);
		driver.findElement(By.linkText("Delete Account")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//section[@id='form']//h2/b")).getText(), "ACCOUNT DELETED!");
		Assert.assertTrue(driver.findElement(By.xpath("//section[@id='form']//h2/b[text()='Account Deleted!']")).isDisplayed());
		driver.findElement(By.linkText("Continue")).click();
		Assert.assertEquals(driver.getTitle(), "Automation Exercise");
		
		driver.quit();
	}
}
