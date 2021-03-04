package AssignmentToTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyLoginBtnVissibility {
	WebDriver driver ;
	
	@BeforeTest
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

		@Test (priority = 3)
		public void verifyLoginBtnVisibility() {
		boolean loginBtnvisibile = driver.findElement(By.id("login-button")) != null;
		Assert.assertTrue(loginBtnvisibile);
		}
	
		@AfterTest
		public void closeBrowser(){
			driver.close();
		}
	
}

