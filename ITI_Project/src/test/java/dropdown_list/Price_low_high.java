package dropdown_list;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Price_low_high {
	
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
		Thread.sleep(2000);
		WebElement list = driver.findElement(By.cssSelector("select.product_sort_container"));
		Select new_list = new Select(list);
		new_list.selectByValue("lohi");
		Thread.sleep(2000);
		// Knowing that Onesie is the cheapest product and fleece jacket is the most expensive one 
		// Knowing also that the first shown product's y coordinate location is 211 which is in the top of the page
		// We will assert that Onesie which is the cheapest one is located where its y coordinate is 211 in the top
		// We will also assert that fleece which is the highest price one is located where its y coordinate is 649 at the bottom
		// So by that we made sure that products are listed from the lowest to the highest
		WebElement low_price = driver.findElement(By.partialLinkText("Onesie"));
		WebElement high_price = driver.findElement(By.partialLinkText("Fleece Jacket"));
	    Assert.assertEquals(211, low_price.getLocation().y);
	    Assert.assertEquals(694, high_price.getLocation().y);
		
	}
	
	
	@AfterTest
	public void close() {
		driver.quit();
	}
	

}
