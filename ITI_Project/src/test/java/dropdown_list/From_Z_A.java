package dropdown_list;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class From_Z_A {

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
		new_list.selectByValue("za");
		Thread.sleep(2000);
		// Knowing that red shirt is the first product shown and the Backpack is the last one 
		// Knowing also that the first shown product's y coordinate location is 211 which is in the top of the page
		// We will assert that red shirt which is the first one is located where its y coordinate is 211 in the top
		// We will also assert that  backpack which is the lowest price one is located where its y coordinate is 649 at the bottom
		// So by that we made sure that products are listed from the Z to the A
		WebElement first_one = driver.findElement(By.partialLinkText("Red"));
		WebElement last_one = driver.findElement(By.partialLinkText("Backpack"));
	    Assert.assertEquals(211, first_one.getLocation().y);
	    Assert.assertEquals(694, last_one.getLocation().y);
		
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}
	
	
}
