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

public class CreateNewOpportunity extends SalesforceSpecificMethods {
	
	
	@Given ("Click on toggle menu button from the left corner")
	public void clickTogglemenu() throws InterruptedException {

		WebElement toggle = driver.findElement(By.xpath("//div[@role='navigation']/button"));
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(toggle));
		builder.moveToElement(toggle).perform();
		toggle.click();
	}
	
	@And ("Click view All")
	public void clickViewAlllink() throws InterruptedException {
		Thread.sleep(5000);
		WebElement viewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		wait.until(ExpectedConditions.visibilityOf(viewAll));
		viewAll.click();
	}
	
	@And ("Click Sales from App Launcher")
	public void clickSalesLink() throws InterruptedException {
		Thread.sleep(2000);
		WebElement sales = driver.findElement(By.xpath("//p[text()='Sales']"));
		sales.click();		
	}
	
	@And ("Click on Opportunity tab")
	public void clickOpporTab() throws InterruptedException {
		Thread.sleep(10000);
		WebElement opportLink = driver.findElement(By.xpath("//a[@title='Opportunities']"));
		builder.moveToElement(opportLink).click().perform();
		
	}
	
	@And ("Click on New button")
	public void clickNewButton() throws InterruptedException {
		//Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='New']")));
		WebElement newele = driver.findElement(By.xpath("//a[@title='New']"));
		newele.click();
		
	}
	
	@And ("Enter Opportunity name as (.*)$")
	public void enterOpporName(String opportunityName) throws InterruptedException {
		Thread.sleep(3000);
		WebElement opporName = driver.findElement(By.xpath("(//input[@class='slds-input'])[4]"));
		opporName.sendKeys(opportunityName);
		
	}
	
	@And ("Choose close date as Today")
	public void chooseCloseDate() {
		WebElement closeDate = driver.findElement(By.xpath("//input[@name='CloseDate']"));
		closeDate.click();
		WebElement todayDate = driver.findElement(By.xpath("//td[@class='slds-is-today']/span"));
		todayDate.click();
	}
	
	@And ("Select Stage as Need Analysis")
	public void selectStage() {
		WebElement stage = driver.findElement(By.xpath("//button[@data-value='--None--']"));
		stage.click();
		WebElement neeedsAnalysis = driver.findElement(By.xpath("//span[@class='slds-media__body']/following::span[text()='Needs Analysis']"));
		neeedsAnalysis.click();
	}
	
	@When ("Click on Save button")
	public void clickSaveButton() {
		WebElement saveButton = driver.findElement(By.xpath("//button[text()='Save']"));
		saveButton.click();
	}
	
	@Then ("VerifyOpportunity Name displayed is (.*)$")
	public void verifyOpporName(String opportunityName) throws InterruptedException {
		Thread.sleep(3000);
		String text = driver.findElement(By.xpath("//div[text()='Opportunity']/following::lightning-formatted-text[1]")).getText();
		if(text.equalsIgnoreCase(opportunityName)) {
			System.out.println("Opportunity Name matches");
		}else {
			System.out.println("Opportuity Name mismatch");
		}
	}





}
