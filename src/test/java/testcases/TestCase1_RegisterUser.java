package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase1_RegisterUser {
	private WebDriver driver;

	@DataProvider(name = "dpRegister")
	public Object[][] getRegisterUserData() {
		return new Object[][] { 
			{ "Penny Jones", "penny.jones@example.com", "Mrs", "Pass@123", "21", "March", 
				"1986", "Yes", "Yes", "Penny", "Jones", "The PennyJones company", "29901 Elmore Shores", "Apt. 923", 
				"United States", "Missouri", "Weissnatville", "205055", "19453439976" }, 
		};
	}

	@Test(priority = 1, dataProvider = "dpRegister")
	public void testToRegisterUser(String str_Name, String str_Email, String str_Title, String str_Password, String str_Days,
			String str_Months, String str_Years, String str_Newsletter, String str_Special, String str_FirstName,
			String str_LastName, String str_Company, String str_Address1, String str_Address2, String str_Country,
			String str_State, String str_City, String str_Zipcode, String str_MobileNumber) {
		
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
		Assert.assertEquals(driver.findElement(By.xpath("//section[@id='form']/div/div/div[3]/div/h2")).getText(), "New User Signup!");
		System.out.println("5. Verified 'New User Signup!' is visible");
		driver.findElement(By.name("name")).clear();
		driver.findElement(By.name("name")).sendKeys(str_Name);
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.xpath("//div[@class='signup-form']//input[@type='email']")).sendKeys(str_Email);
		System.out.println("6. Enter name and email address");
		driver.findElement(By.xpath("//button[text()='Signup']")).click();
		System.out.println("7. Clicked on 'Signup' button");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-form']//h2/b")).getText(), "ENTER ACCOUNT INFORMATION");
		System.out.println("8. Verify that 'ENTER ACCOUNT INFORMATION' is visible");
		if (str_Title.equalsIgnoreCase("Mr")) {
			driver.findElement(By.id("id_gender1")).click();
		} else if (str_Title.equalsIgnoreCase("Mrs")) {
			driver.findElement(By.id("id_gender2")).click();
		}
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(str_Password);
		new Select(driver.findElement(By.id("days"))).selectByVisibleText(str_Days);
		new Select(driver.findElement(By.id("months"))).selectByVisibleText(str_Months);
		new Select(driver.findElement(By.id("years"))).selectByVisibleText(str_Years);
		System.out.println("9. Fill details: Title, Name, Email, Password, Date of birth");
		if (str_Newsletter.equalsIgnoreCase("Yes")) {
			driver.findElement(By.id("newsletter")).click();
		}
		System.out.println("10. Select checkbox 'Sign up for our newsletter!");
		if (str_Special.equalsIgnoreCase("Yes")) {
			driver.findElement(By.id("optin")).click();
		}
		System.out.println("11. Select checkbox 'Receive special offers from our partners!'");
		driver.findElement(By.id("first_name")).clear();
		driver.findElement(By.id("first_name")).sendKeys(str_FirstName);
		driver.findElement(By.id("last_name")).clear();
		driver.findElement(By.id("last_name")).sendKeys(str_LastName);
		driver.findElement(By.id("company")).clear();
		driver.findElement(By.id("company")).sendKeys(str_Company);
		driver.findElement(By.id("address1")).clear();
		driver.findElement(By.id("address1")).sendKeys(str_Address1);
		driver.findElement(By.id("address2")).clear();
		driver.findElement(By.id("address2")).sendKeys(str_Address2);
		new Select(driver.findElement(By.id("country"))).selectByVisibleText(str_Country);
		driver.findElement(By.id("state")).clear();
		driver.findElement(By.id("state")).sendKeys(str_State);
		driver.findElement(By.id("city")).clear();
		driver.findElement(By.id("city")).sendKeys(str_City);
		driver.findElement(By.id("zipcode")).clear();
		driver.findElement(By.id("zipcode")).sendKeys(str_Zipcode);
		driver.findElement(By.id("mobile_number")).clear();
		driver.findElement(By.id("mobile_number")).sendKeys(str_MobileNumber);
		System.out.println("12. Filled in details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("13. Clicked on 'Create Account button'");
		Assert.assertEquals(driver.findElement(By.xpath("//section[@id='form']//h2/b")).getText(), "ACCOUNT CREATED!");
		Assert.assertTrue(driver.findElement(By.xpath("//section[@id='form']//h2/b[text()='Account Created!']")).isDisplayed());
		System.out.println("14. Verified that 'ACCOUNT CREATED!' is visible");
		driver.findElement(By.linkText("Continue")).click();
		System.out.println("15. Clicked 'Continue' button");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='header']//a/b")).getText(), str_Name);
		System.out.println("16. Verify that 'Logged in as username' is visible");
		driver.findElement(By.linkText("Delete Account")).click();
		System.out.println("17. Clicked 'Delete Account' button");
		Assert.assertEquals(driver.findElement(By.xpath("//section[@id='form']//h2/b")).getText(), "ACCOUNT DELETED!");
		Assert.assertTrue(driver.findElement(By.xpath("//section[@id='form']//h2/b[text()='Account Deleted!']")).isDisplayed());
		System.out.println("18. Verify that 'ACCOUNT DELETED!' is visible and clicked on 'Continue' button");
		driver.findElement(By.linkText("Continue")).click();
		Assert.assertEquals(driver.getTitle(), "Automation Exercise");
		
		driver.quit();
	}
}
