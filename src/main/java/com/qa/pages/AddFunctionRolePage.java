package com.qa.pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.utilities.Base;


public class AddFunctionRolePage extends Base {

	public AddFunctionRolePage()
	{
		PageFactory.initElements(driver, this);
	}


	// Web elements with proper camel case and private visibility
	@FindBy(xpath = "//p[normalize-space()='Function Role']") 
	private WebElement functionRole;

	@FindBy(xpath = "//button[normalize-space()='Add Function Role']")
	private WebElement addFunctionRole;

	@FindBy(xpath = "//input[@name='code']")
	private WebElement functionRoleCode;

	@FindBy(xpath = "//input[@placeholder='Search Function']")
	private WebElement searchFunction;

	@FindBy(xpath = "//input[@name='name']")
	private WebElement functionRoleName;

	@FindBy(xpath = "//div[contains(@class,'mat-select-trigger')]")
	private WebElement status;

	@FindBy(xpath = "//input[@formcontrolname='entity']")
	private WebElement functionCode;    

	@FindBy(xpath = "//span[normalize-space()='QA']")
	private WebElement enterFunctionCode;    

	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement enterRoleDescription;

	@FindBy(xpath = "//input[@name='effectiveDate']")
	private WebElement roleEffectiveDate;

	@FindBy(xpath = "//button[@type='button' and @aria-current='date']")
	private WebElement roleCurrentDate;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement roleAddButton;

	@FindBy(xpath = "//p[text()=' Dashboard ']")
	private WebElement clickDashboard;

	@FindBy(xpath = "//input[@placeholder='Search Parent Role']")
	private WebElement parentRole;

	// Method to click on the Function Role card
	public void clickFunctionRoleCard() throws InterruptedException {
		Thread.sleep(2000);
		functionRole.click();
		System.out.println("Function Role card clicked.");
		Thread.sleep(5000);
	}

	// Method to validate the current URL
	public String validateFunctionPageUrl() {
		return driver.getCurrentUrl();
	}

	// Method to add a new Function Role
	public void addFunctionRole() throws InterruptedException {
		Thread.sleep(5000);
		addFunctionRole.click();
		System.out.println("Add Function Role button clicked.");
		Thread.sleep(5000);

		functionRoleCode.sendKeys("YBL Testing Demo");
		System.out.println("Function Role Code entered: YBL Testing Demo");
		Thread.sleep(5000);

		functionRoleName.sendKeys("Yes Bank Testing Demo");
		System.out.println("Function Role Name entered: Yes Bank Testing Demo");
		Thread.sleep(5000);

		searchFunction.sendKeys("QA");
		Thread.sleep(5000);

		enterFunctionCode.click();
		System.out.println("Function code selected.");
		Thread.sleep(5000);

		parentRole.sendKeys("manager");
		Thread.sleep(5000);
		enterRoleDescription.sendKeys("Add Function Role Demo");
		System.out.println("Role Description entered: Add Function Role Demo");

		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[normalize-space()='Manager']")).click();
		System.out.println("Parent Role selected: Manager");
		Thread.sleep(5000);

		roleAddButton.click();
		System.out.println("Add Role button clicked.");
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Record Added Successfully!']")));

	        // Validate the text in the popup
	        String expectedText = "Record Added Successfully";
	        
	       
	        String actualText = popup.getText();
	        Assert.assertTrue(actualText.contains(expectedText), "Text validation failed. Expected: " + expectedText + " but found: " + actualText);

	        System.out.println("Text validation passed.");
		
		
		
		
		Thread.sleep(5000);


	}
}