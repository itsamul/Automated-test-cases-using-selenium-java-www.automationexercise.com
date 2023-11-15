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

public class TestCase20_SearchProductsAndVerifyCartAfterLogin {
	private WebDriver driver;

	@DataProvider(name = "dpTestData")
	public Object[][] register() {
		return new Object[][] { 
//			{ "penny.jones@example.com", "Pass@123", "Penny Jones" }, 
			{ "jennie.rodriguez@example.net", "Pass@123", "Jennie Rodriguez"},
		};
	}
	
	@Test(dataProvider = "dpTestData")
	public void testToViewCategoryProducts(String str_Email, String str_Password, String str_Name ) {
		
		driver = new ChromeDriver();
		System.out.println("1. Launch browser");
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// ***** HOME PAGE *****
		driver.get("https://automationexercise.com/");
		System.out.println("2. Navigate to url 'http://automationexercise.com'");
		assertEquals(driver.getTitle(), "Automation Exercise");
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.partialLinkText("Products")))).click(); 
		System.out.println("3. Clicked on 'Products' button");
		
		// ***** ALL PRODUCTS PAGE *****
		assertEquals(driver.getTitle(), "Automation Exercise - All Products");
		assertEquals(driver.findElement(By.xpath("//div[@class='features_items']//h2[@class='title text-center']")).getText(), "ALL PRODUCTS");
		System.out.println("4. Verify user is navigated to ALL PRODUCTS page successfully");
		driver.findElement(By.id("search_product")).clear();
		driver.findElement(By.id("search_product")).sendKeys("Blue Top");
		driver.findElement(By.id("submit_search")).click();
		System.out.println("5. Enter product name in search input and click search button.");
		assertEquals(driver.findElement(By.xpath("//div[@class='features_items']//h2[@class='title text-center']")).getText(), "SEARCHED PRODUCTS");
		System.out.println("6. Verified 'SEARCHED PRODUCTS' is visible");
		assertEquals(driver.findElement(By.xpath("//div[@class='productinfo text-center']/p")).getText(), "Blue Top");
		System.out.println("7. Verified all the products related to search are visible");
		new Actions(driver).moveToElement(driver.findElement(By.xpath("//div[contains(@class,'productinfo')]/p[text()='Blue Top']/following-sibling::a[contains(@class,'add-to-cart')]"))).build().perform();
		driver.findElement(By.xpath("//div[@class='overlay-content']/p[text()='Blue Top']//following-sibling::a[contains(@class,'add-to-cart')]")).click();
		System.out.println("8. Add products to cart");
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")))).click();
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.partialLinkText("Cart")))).click();
		
		// ***** SHOPPING CART PAGE *****
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id='cart_items']//li[text()='Shopping Cart']")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='cart_items']//li[text()='Shopping Cart']")).getText(), "Shopping Cart");
		String[] productsAddedToCart = {"Blue Top"};
		List<WebElement> productsInCart = driver.findElements(By.xpath("//td[@class='cart_description']/h4/a"));
		boolean flag = false;
		for (int i = 0; i < productsInCart.size(); i++) {
			List<String> productsAddedToCartList = Arrays.asList(productsAddedToCart);
			String productName = productsInCart.get(i).getText();
			//System.out.println(productName);
			if(productsAddedToCartList.contains(productName)) {
				flag = true;
				//System.out.println(productName + " Product present in the cart.");	
			} else {
				//System.out.println(productName + " Product not present in the cart.");
				flag = false;
				break;
			}
		}	
		Assert.assertTrue(flag, "Product added to cart not found in the cart.");
		System.out.println("9. Click 'Cart' button and verify that products are visible in cart");
		driver.findElement(By.linkText("Signup / Login")).click();
	
		// ***** SIGN UP / LOGIN  PAGE *****
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-form']/h2")).getText(),"Login to your account");
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.xpath("//div[@class='login-form']//input[@type='email']")).sendKeys(str_Email);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(str_Password);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		System.out.println("10. Click 'Signup / Login' button and submit login details");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='header']//a/b")).getText(), str_Name);
		driver.findElement(By.partialLinkText("Cart")).click();
		System.out.println("11. Again, go to Cart page");
		
		// ***** SHOPPING CART PAGE *****
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id='cart_items']//li[text()='Shopping Cart']")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='cart_items']//li[text()='Shopping Cart']")).getText(), "Shopping Cart");
		productsInCart = driver.findElements(By.xpath("//td[@class='cart_description']/h4/a"));
		flag = false;
		for (int i = 0; i < productsInCart.size(); i++) {
			List<String> productsAddedToCartList = Arrays.asList(productsAddedToCart);
			String productName = productsInCart.get(i).getText();
			//System.out.println(productName);
			if(productsAddedToCartList.contains(productName)) {
				flag = true;
				//System.out.println(productName + " Product present in the cart.");	
			} else {
				//System.out.println(productName + " Product not present in the cart.");
				flag = false;
				break;
			}
		}	
		Assert.assertTrue(flag, "Product added to cart not found in the cart.");
		System.out.println("12. Verify that those products are visible in cart after login as well");
		driver.quit();
	}
}
