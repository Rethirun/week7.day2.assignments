package stepDefs;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SalesforceLoginPage extends SalesforceSpecificMethods {
	
	@Given ("Type the username as {string}")
	public void typeUsername(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
	}
	
	@And ("Type the password as {string}")
	public void typePassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}
	
	@When ("Click on the login button")
	public void clickLogin() {
		driver.findElement(By.id("Login")).click();
	}
	
	@Then ("Verify the Home Page is displayed")
	public void verifyHomePage() {
		String text = driver.getTitle();
		if(text.contains("Home")) {
			System.out.println("Home Page is displayed");
		}else {
			System.err.println("Home Page is not displayed");
		}
		
	}
}
