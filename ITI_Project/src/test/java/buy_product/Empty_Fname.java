package buy_product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Empty_Fname {
	
	WebDriver driver;

	@BeforeTest
	public void openURL()
	{
		String chromePath= System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://www.saucedemo.com/");	
		driver.manage().window().maximize();
	}
	
	@Test
	public void testImplicitTest() throws InterruptedException {
		
		
		WebElement txtusername = driver.findElement(By.id("user-name"));
		WebElement txtpass = driver.findElement(By.id("password"));
		WebElement loginbtn = driver.findElement(By.id("login-button"));
		txtusername.clear();
		txtusername.sendKeys("standard_user");
		txtpass.clear();
		txtpass.sendKeys("secret_sauce");
		Thread.sleep(1000);
		loginbtn.click();
		Thread.sleep(3000);
	    WebElement Cart_btn = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
	    Cart_btn.click();
	    Thread.sleep(1000);
	    WebElement Cart_list = driver.findElement(By.cssSelector("a.shopping_cart_link"));
	    Cart_list.click();
	    Thread.sleep(1000);
	    WebElement checkout = driver.findElement(By.id("checkout"));
	    checkout.click();
	    Thread.sleep(2000);
	    WebElement lname = driver.findElement(By.id("last-name"));
	    lname.sendKeys("Amr");
	    WebElement zcode = driver.findElement(By.id("postal-code"));
	    zcode.sendKeys("12345");
	    Thread.sleep(1000);
	    WebElement continueBtn = driver.findElement(By.id("continue"));
	    continueBtn.click();
	    Thread.sleep(2000);
	    WebElement Error = driver.findElement(By.tagName("h3"));
	    Assert.assertEquals("Error: First Name is required",Error.getText());
	  	   
	}
	
	
	@AfterTest
	public void close() {
		driver.quit();
	}

}
