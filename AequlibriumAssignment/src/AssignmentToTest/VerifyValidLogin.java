package AssignmentToTest;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyValidLogin {
WebDriver driver;
	
	
@BeforeTest
public void openBrowser() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.saucedemo.com/");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);




}


  @Test(priority = 0)
  public void VerifyLogin()  throws IOException {
	try {
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
	driver.findElement(By.id("password")).sendKeys("secret_sauce");
	driver.findElement(By.id("login-button")).click();
	String expectedResult = "Products";
	String actualResult = driver.findElement(By.cssSelector("#inventory_filter_container > div")).getText();
	Assert.assertEquals(actualResult, expectedResult);
}
	catch (Exception e) {
			
		Assert.fail("Test Script Failed due to :"+e);
	}
}     
  private void takeScreenshot() throws IOException {
	File ss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileHandler.copy(ss, new File("D:\\SelJan5\\screenshot"+(new Random().nextInt())+".jpg"));
  }





  @AfterTest
  public void closeBrowser(){
	driver.close();
  }
  }
	


	
	

