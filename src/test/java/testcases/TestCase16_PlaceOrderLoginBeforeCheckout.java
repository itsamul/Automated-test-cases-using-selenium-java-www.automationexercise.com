package testcases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase16_PlaceOrderLoginBeforeCheckout {
	private WebDriver driver;

	@DataProvider(name = "dpTestData")
	public Object[][] getTestData() {
		return new Object[][] { 
//			{ "penny.jones@example.com", "Pass@123", "Penny Jones", "Mrs", "The PennyJones company",
//				"29901 Elmore Shores", "Apt. 923", "United States", "Missouri", "Weissnatville", "205055", "19453439976" }, 
			{ "darryl.langosh@example.org", "Pass@123", "Darryl Langosh", "The DarrylLangosh Company", 
				"8421 Dooley Cove", "Suite 144", "United States", "Utah", "Macon-Bibb County", "233746", "13964843424" },	
		};

	}

	@Test(dataProvider = "dpTestData")
	public void placeOrderRegisterWhileCheckout(String str_Email, String str_Password, String str_Name,
			String str_Title, String str_Company, String str_Address1, String str_Address2, String str_Country,
			String str_State, String str_City, String str_Zipcode, String str_MobileNumber) {

		driver = new ChromeDriver();
		System.out.println("1. Launch browser");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://automationexercise.com/");
		System.out.println("2. Navigate to url 'http://automationexercise.com'");

		// ***** HOME PAGE *****
		Assert.assertEquals(driver.getTitle(), "Automation Exercise");
		System.out.println("3. Verified that home page is visible successfully");
		driver.findElement(By.linkText("Signup / Login")).click();
		System.out.println("4. Click on 'Signup / Login' button");

		// ***** SIGN UP / LOGIN PAGE *****
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-form']/h2")).getText(),
				"Login to your account");
		System.out.println("5. Verified 'New User Signup!' is visible");
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.xpath("//div[@class='login-form']//input[@type='email']")).sendKeys(str_Email);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(str_Password);
		System.out.println("6. Enter correct email address and password");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		System.out.println("7. Clicked on 'Login' button");

		// ***** HOME PAGE *****
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='header']//a/b")).getText(), str_Name);
		System.out.println("8. Verify that 'Logged in as username' is visible");
		driver.findElement(By.partialLinkText("Products")).click();
		System.out.println("4. Clicked on 'Products' button");

		// ***** ALL PRODUCTS PAGE *****
		assertEquals(driver.getTitle(), "Automation Exercise - All Products");
		assertEquals(driver.findElement(By.xpath("//div[@class='features_items']//h2[@class='title text-center']"))
				.getText(), "ALL PRODUCTS");
		System.out.println("5. Verify user is navigated to ALL PRODUCTS page successfully");
		System.out.println("6. The products list is visible");

		new Actions(driver).moveToElement(driver.findElement(By.xpath(
				"//div[contains(@class,'productinfo')]/p[text()='Blue Top']/following-sibling::a[contains(@class,'add-to-cart')]")))
				.build().perform();
		driver.findElement(By.xpath(
				"//div[@class='overlay-content']/p[text()='Blue Top']//following-sibling::a[contains(@class,'add-to-cart')]"))
				.click();
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]"))))
				.click();
		new Actions(driver).moveToElement(driver.findElement(By.xpath(
				"//div[contains(@class,'productinfo')]/p[text()='Men Tshirt']/following-sibling::a[contains(@class,'add-to-cart')]")))
				.build().perform();
		driver.findElement(By.xpath(
				"//div[@class='overlay-content']/p[text()='Men Tshirt']//following-sibling::a[contains(@class,'add-to-cart')]"))
				.click();
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]"))))
				.click();
		driver.findElement(By.partialLinkText("Cart")).click();
		System.out.println("5. Click 'Cart' button");

		// ***** SHOPPING CART PAGE *****
		Assert.assertTrue(
				driver.findElement(By.xpath("//*[@id='cart_items']//li[text()='Shopping Cart']")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='cart_items']//li[text()='Shopping Cart']")).getText(),
				"Shopping Cart");
		System.out.println("10. Verify that cart page is displayed");
		driver.findElement(By.linkText("Proceed To Checkout")).click();

		// ***** CHECKOUT PAGE *****
		assertEquals(driver.findElement(By.xpath("//li[@class='address_firstname address_lastname']")).getText(),
				str_Title + ". " + str_Name);
		assertEquals(driver.findElement(By.xpath("//*[@id='address_delivery']/li[3]")).getText(), str_Company);
		assertEquals(driver.findElement(By.xpath("//*[@id='address_delivery']/li[4]")).getText(), str_Address1);
		assertEquals(driver.findElement(By.xpath("//*[@id='address_delivery']/li[5]")).getText(), str_Address2);
		assertEquals(driver.findElement(By.xpath("//*[@id='address_delivery']/li[6]")).getText(),
				str_City + " " + str_State + " " + str_Zipcode);
		assertEquals(driver.findElement(By.xpath("//*[@id='address_delivery']/li[7]")).getText(), str_Country);
		assertEquals(driver.findElement(By.xpath("//*[@id='address_delivery']/li[8]")).getText(), str_MobileNumber);

		String[] productsAddedToCart = { "Blue Top", "Men Tshirt" };
		List<WebElement> productsInCart = driver.findElements(By.xpath("//td[@class='cart_description']/h4/a"));
		boolean flag = false;
		for (int i = 0; i < productsInCart.size(); i++) {
			List<String> productsAddedToCartList = Arrays.asList(productsAddedToCart);
			String productName = productsInCart.get(i).getText();
			// System.out.println(productName);
			if (productsAddedToCartList.contains(productName)) {
				flag = true;
				// System.out.println(productName + " Product present in the cart.");
			} else {
				// System.out.println(productName + " Product not present in the cart.");
				flag = false;
				break;
			}
		}
		Assert.assertTrue(flag, "Product added to cart not found in the cart.");
		Assert.assertEquals(driver
				.findElement(By.xpath(
						"//td[@class='cart_description']/h4/a[text()='Blue Top']/following::td[@class='cart_price']/p"))
				.getText().replace("Rs. ", ""), "500");
		Assert.assertEquals(driver.findElement(By.xpath(
				"//td[@class='cart_description']/h4/a[text()='Blue Top']/following::td[@class='cart_price']/p/following::td[@class='cart_quantity']/button"))
				.getText(), "1");
		Assert.assertEquals(driver.findElement(By.xpath(
				"//td[@class='cart_description']/h4/a[text()='Blue Top']/following::td[@class='cart_price']/p/following::td[@class='cart_quantity']/button/following::td[@class='cart_total']/p[@class='cart_total_price']"))
				.getText().replace("Rs. ", ""), "500");
		Assert.assertEquals(driver.findElement(By.xpath(
				"//td[@class='cart_description']/h4/a[text()='Men Tshirt']/following::td[@class='cart_price']/p"))
				.getText().replace("Rs. ", ""), "400");
		Assert.assertEquals(driver.findElement(By.xpath(
				"//td[@class='cart_description']/h4/a[text()='Men Tshirt']/following::td[@class='cart_price']/p/following::td[@class='cart_quantity']/button"))
				.getText(), "1");
		Assert.assertEquals(driver.findElement(By.xpath(
				"//td[@class='cart_description']/h4/a[text()='Men Tshirt']/following::td[@class='cart_price']/p/following::td[@class='cart_quantity']/button/following::td[@class='cart_total']/p[@class='cart_total_price']"))
				.getText().replace("Rs. ", ""), "400");
		Assert.assertEquals(driver
				.findElement(
						By.xpath("//table[@class='table table-condensed']//tr[3]/td[4]/p[@class='cart_total_price']"))
				.getText().replace("Rs. ", ""), "900");
		System.out.println("12. Verify Address Details and Review Your Order");
		driver.findElement(By.xpath("//div[@id='ordermsg']//textarea")).sendKeys("This is the test message.");
		driver.findElement(By.linkText("Place Order")).click();

		// ***** PAYMENT PAGE *****
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id='cart_items']//li[text()='Payment']")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='cart_items']//li[text()='Payment']")).getText(),
				"Payment");

		driver.findElement(By.name("name_on_card")).sendKeys(str_Name);
		driver.findElement(By.name("card_number")).sendKeys("4567123579858956");
		driver.findElement(By.name("cvc")).sendKeys("587");
		driver.findElement(By.name("expiry_month")).sendKeys("11");
		driver.findElement(By.name("expiry_year")).sendKeys("2024");
		driver.findElement(By.id("submit")).click();

		// ***** ORDER PLACED PAGE *****
		Assert.assertEquals(driver.findElement(By.xpath("//section[@id='form']//h2/b")).getText(), "ORDER PLACED!");
		Assert.assertTrue(driver.findElement(By.xpath("//section[@id='form']//h2/b")).isDisplayed());
		System.out.println("14. Verified that 'ORDER PLACED!' is visible");
		driver.findElement(By.linkText("Continue")).click();
		System.out.println("15. Clicked 'Continue' button");

		// ***** HOME PAGE *****
		Assert.assertEquals(driver.getTitle(), "Automation Exercise");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='header']//a/b")).getText(), str_Name);
		System.out.println("16. Verify that 'Logged in as username' is visible");
		driver.findElement(By.linkText("Delete Account")).click();
		System.out.println("17. Clicked 'Delete Account' button");

		// ***** ACCOUNT DELETED PAGE *****
		Assert.assertEquals(driver.findElement(By.xpath("//section[@id='form']//h2/b")).getText(), "ACCOUNT DELETED!");
		Assert.assertTrue(
				driver.findElement(By.xpath("//section[@id='form']//h2/b[text()='Account Deleted!']")).isDisplayed());
		System.out.println("18. Verify that 'ACCOUNT DELETED!' is visible and clicked on 'Continue' button");
		driver.findElement(By.linkText("Continue")).click();
		// ***** HOME PAGE *****
		Assert.assertEquals(driver.getTitle(), "Automation Exercise");

		driver.quit();

	}
}
