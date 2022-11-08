package Selenium.ITI_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Empty_Username {

	WebDriver driver;

	@BeforeTest
	public void openURL()
	{
		String chromePath= System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://www.saucedemo.com/");	
	}
	
	@Test
	public void testImplicitTest() throws InterruptedException {
		
		WebElement txtpass = driver.findElement(By.id("password"));
		WebElement loginbtn = driver.findElement(By.id("login-button"));
		txtpass.clear();
		txtpass.sendKeys("12345");
		Thread.sleep(1000);
		loginbtn.click();
		Thread.sleep(1000);
		WebElement errorMsg = driver.findElement(By.tagName("h3"));
	    Assert.assertTrue(errorMsg.getText().contains("Username is required"));  
	    Thread.sleep(1000);
	}
	
	
	@AfterTest
	public void close() {
		driver.quit();
	}
}
