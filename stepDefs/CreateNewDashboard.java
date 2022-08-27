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

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateNewDashboard extends SalesforceSpecificMethods {
	
	@And ("Click Dashboards from App Launcher")
	public void clickDashboardLink() {
		WebElement dashboardLink = driver.findElement(By.xpath("//a[@data-label='Dashboards']//p"));
		builder.scrollToElement(dashboardLink).perform();
		dashboardLink.click();
	}
	
	@And ("Click on the New Dashboard option")
	public void clickNewDashboardButton() {
		WebElement newDashboardOption = driver.findElement(By.xpath("//a[@title='New Dashboard']"));
		newDashboardOption.click();
	}
	
	@And ("In New Dashboard enter Name as (.*)$")
	public void enterDashboardName(String opportunityName) {
		WebElement frameNewDash = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.switchTo().frame(frameNewDash);
		WebElement dashName = driver.findElement(By.xpath("//label[@class='slds-form-element__label']/following::input[1]"));
		dashName.sendKeys(opportunityName);
		
	}
	
	@And ("In dashboard page Click on Create")
	public void clickCreateButton() {
		WebElement createButton = driver.findElement(By.xpath("//button[text()='Create']"));
		createButton.click();
	}
	
	@When ("Click on Save button in dashboard")
	public void clickSaveDashboard() throws InterruptedException {
		driver.switchTo().defaultContent();
		WebElement frameSave = driver.findElement(By.xpath("//div[@class='dashboardContainer']/iframe"));
		driver.switchTo().frame(frameSave);
		/*Thread.sleep(10000);
		WebElement saveButton = driver.findElement(By.xpath("//div[@class='actionRibbon']//button[text()='Save']"));
		//Thread.sleep(3000);
		//wait.until(ExpectedConditions.stalenessOf(saveButton));
		saveButton.click();*/
		
	}
	
	@Then ("Verify dashboard name")
	public void verifyDashboardName() {
		String text1 = driver.findElement(By.xpath("//span[@class='slds-form-element__static slds-grid slds-grid_align-spread']")).getText();
		System.out.println(text1);	
		if(text1.contains("Salesforce Automation by Revathi")) {
			System.out.println("Verified Dashboard Name");
		}else {
			System.out.println("Not verified!!");
		}

	}



}
