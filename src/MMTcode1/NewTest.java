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
public void Login_Into_MMT()throws IOException, InterruptedException {
//File Reading Code 
File file = new File("D:/workspace/MMT/src/MMTcode1/data.properties");
	FileInputStream fileInput = null;
	try {
		fileInput = new FileInputStream(file);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	Properties prop = new Properties();
	
	//load properties file
	try {
		prop.load(fileInput);
	} catch (IOException e) {
		e.printStackTrace();
	}

	 driver.manage().window().maximize();
	 driver.findElement(By.id("ch_login_icon")).click();
    Thread.sleep(2000);
driver.findElement(By.cssSelector("#ch_login_email")).sendKeys(prop.getProperty("username"));
driver.findElement(By.id("ch_login_password")).sendKeys(prop.getProperty("password"));
driver.findElement(By.id("ch_login_btn")).click();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
Assert.assertTrue(driver.findElement(By.xpath("//a[@id='ch_logged-in']//span[contains(text(),'Hey Akash')]")).isDisplayed());
}


 

@Test	
public void verifyAllTabsOnHomeapge() {
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	Assert.assertTrue(driver.findElement(By.xpath("//*[@id='header_tab_flights']")).isDisplayed());
	
	System.out.println("Flight tab is displayed in header and is selected by default");
	
}
@Test	
public void SelectFromToDestination() {
	
	
	WebElement Dropdown = driver.findElement(By.xpath("//input[@id='hp-widget__sTo']"));
	Dropdown.click();
	List <WebElement> Allelements = driver.findElements(By.xpath("//ul[@id='ui-id-2']"));
	
	for ( WebElement we: Allelements) { 
		System.out.println(we.getText());
		
        Dropdown.sendKeys( Keys.DOWN );
        Dropdown.sendKeys( Keys.ENTER );
       Thread.sleep(500);
        
       
        
        
    }
}

	  
	
  @AfterClass
  public void afterMethod() {
	  driver.close();
	  
	  
	  
  }

}
