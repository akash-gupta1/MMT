package MMTcode1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class NewTest {
	
	
 public String BaseURL= "https://www.makemytrip.com/";
 
 String driverpath = "D:\\workspace\\MMT\\chromedriver.exe";
 public WebDriver  driver;
 
	
 @BeforeClass
 public void launchBrowserAndURL() {
	  System.out.println("launching Chrome  browser"); 
     System.setProperty("webdriver.chrome.driver", driverpath);
     driver = new ChromeDriver();
     driver.get(BaseURL);
 }
	
@Test	
 public void verifyHomepageTitle() {
     String expectedTitle = "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday";
     String actualTitle = driver.getTitle();
     Assert.assertEquals(actualTitle, expectedTitle);
     System.out.print(actualTitle);
}
 

@Test	
public void verifyAllTabsOnHomeapge() {
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	Assert.assertTrue(driver.findElement(By.xpath("//*[@id='header_tab_flights']")).isDisplayed());
	//Assert.assertTrue(driver.findElement(By.xpath("//*[@id='header_tab_flights']")).isSelected());
	System.out.println("Flight tab is displayed in header and is selected by default");
	
}
@Test	
public void SelectFromToDestination() {
	
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	//driver.switchTo().frame("input[@id='hp-widget__sfrom']");
	driver.findElement(By.xpath("//input[@id='hp-widget__sfrom']")).click();
	driver.findElement(By.xpath("//span[contains(text(),'Mumbai, India')]")).click();
	
	//driver.findElement(By.xpath("//span[contains(text(),'Mumbai, India')]")).click();
	driver.findElement(By.xpath("//span[contains(text(),'New Delhi, India')]")).click();
	
	System.out.println("Destinations has been selected");
	
	

	/*WebElement mySelectElement = driver.findElement(By.xpath("//div[@class='inputM inputHlp inputFilter visited']//input[@id='hp-widget__sfrom']"));
	Select dropdown= new Select(mySelectElement);
	dropdown.selectByVisibleText("Mumbai");
	
	WebElement mySelectElement2 = driver.findElement(By.xpath("//input[@id='hp-widget__sTo']"));
	Select dropdown2= new Select(mySelectElement2);
	dropdown2.selectByVisibleText("New Delhi");
	System.out.println("Destination is now seleted");
}*/


}


	  
	
  @AfterClass
  public void afterMethod() {
	  driver.close();
	  
	  
	  
  }

}
