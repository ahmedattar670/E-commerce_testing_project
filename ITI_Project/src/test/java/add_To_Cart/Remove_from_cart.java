package add_To_Cart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Remove_from_cart {

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
		Thread.sleep(1000);
	    WebElement Cart_btn = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
	    Cart_btn.click();
	    Thread.sleep(1000);
	    WebElement Cart2_btn = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
	    Cart2_btn.click();
	    Thread.sleep(1000);
	    WebElement Cart2_remove = driver.findElement(By.id("remove-sauce-labs-bike-light"));
	    Cart2_remove.click();
	    Thread.sleep(2000);
	    WebElement cart_list = driver.findElement(By.cssSelector("a.shopping_cart_link"));
	    Assert.assertEquals("1", cart_list.getText());
	    Thread.sleep(2000);
	    
	    
	}
	
	
	@AfterTest
	public void close() {
		driver.quit();
	}
	
}
