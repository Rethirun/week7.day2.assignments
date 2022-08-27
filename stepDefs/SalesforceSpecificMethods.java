package stepDefs;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceSpecificMethods extends AbstractTestNGCucumberTests {
	public static ChromeDriver driver;
	public static Actions builder;
	public static WebDriverWait wait;
		
	@BeforeMethod
	public void init() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();	
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		builder=new Actions(driver);
	
	}
	
	@AfterMethod
	public void teardown() {
		//driver.quit();
	}

}
