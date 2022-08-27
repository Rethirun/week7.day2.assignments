package stepDefs;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateOpportunityWithoutMandatoryFields extends SalesforceSpecificMethods {
	
	@And ("Choose close date as Tomorrow date")
	public void chooseCloseDateAsTomo() {
		WebElement closeDate = driver.findElement(By.xpath("//input[@name='CloseDate']"));
		closeDate.click();
		WebElement tomoDate = driver.findElement(By.xpath("//td[@class='slds-is-today']/following::td[1]/span[1]"));
		tomoDate.click();
	}
	
	@Then ("Verify the Alert message Complete this field displayed for Name and Stage")
	public void verifyAlertMessageForNameStage() {
		String alertOppName = driver.findElement(By.xpath("(//div[@class='slds-form-element__help'])[1]")).getText();
		System.out.println(alertOppName);
		String alertStage = driver.findElement(By.xpath("(//div[@class='slds-form-element__help'])[2]")).getText();
		System.out.println(alertStage);
		
		Assert.assertEquals(alertOppName, "Complete this field.");
		Assert.assertEquals(alertStage, "Complete this field.");
		
		System.out.println("Alert message displayed (Complete this field) displayed for Name and Stage");

	}

}
