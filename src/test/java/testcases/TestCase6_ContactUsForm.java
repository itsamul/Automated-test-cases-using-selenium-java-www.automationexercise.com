package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase6_ContactUsForm {
	private WebDriver driver;

	@DataProvider(name = "dpContactForm")
	public Object[][] contactFormGetData() {
		return new Object[][] { { "penny.jones@example.com", "Penny Jones" }, };
	}
	
	@Test(dataProvider = "dpContactForm")
	public void testToSubmitTheContactUsForm(String str_Email, String str_Name) {
		
		driver = new ChromeDriver();
		System.out.println("1. Launch browser");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://automationexercise.com/");
		System.out.println("2. Navigate to url 'http://automationexercise.com'");
		
		Assert.assertEquals(driver.getTitle(), "Automation Exercise");
		System.out.println("3. Verified that home page is visible successfully");
		driver.findElement(By.linkText("Contact us")).click();
		System.out.println("4. Click on 'Contact Us' button");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='contact-form']/h2")).getText(),"GET IN TOUCH");
		System.out.println("5. Verified 'GET IN TOUCH' is visible");
		driver.findElement(By.name("name")).clear();
		driver.findElement(By.name("name")).sendKeys(str_Name);
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(str_Email);		
		driver.findElement(By.name("subject")).clear();
		driver.findElement(By.name("subject")).sendKeys("This is the Test Subject");
		driver.findElement(By.id("message")).clear();
		driver.findElement(By.id("message")).sendKeys("This is the sample message test.");
		System.out.println("6. Enter name, email, subject and message");
		driver.findElement(By.xpath("//input[@name='upload_file']")).sendKeys(System.getProperty("user.dir") + "//src//test/resources//Testfile.txt");
		System.out.println("7. Uploaded file");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		System.out.println("8. Clicked 'Submit' button");
		driver.switchTo().alert().accept();
		System.out.println("9. Clicked OK button on Alert");
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='status alert alert-success']")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='status alert alert-success']")).getText(), "Success! Your details have been submitted successfully.");
		System.out.println("10. Verify success message 'Success! Your details have been submitted successfully.' is visible");
		driver.findElement(By.xpath("//div[@id='form-section']/a/span")).click();
		System.out.println("11. Clicked 'Home' button ");
//		Assert.assertEquals(driver.getTitle(), "Automation Exercise - Contact Us");
		Assert.assertEquals(driver.getTitle(), "Automation Exercise");
		System.out.println("12. Verified that user is navigated to login page successfully");
		
		driver.quit();
	}
	
}
