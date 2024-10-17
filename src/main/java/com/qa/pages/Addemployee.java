package com.qa.pages;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.utilities.Base;


public class Addemployee extends Base {
	
	// Constructor
		public Addemployee() {
			PageFactory.initElements(driver, this);
		}

		// WebElements
		@FindBy(xpath = "//p[normalize-space()='Employee']")
		private WebElement employee;

		@FindBy(xpath = "//button[normalize-space()='Add Employee']")
		private WebElement addEmployee;

		@FindBy(xpath = "//span[contains(text(),'Mr')]")
		private WebElement salutation;

		@FindBy(xpath = "//mat-option[@ng-reflect-value='MR']//span[contains(text(),'Mr')]")
		private WebElement salutationOption;

		@FindBy(xpath = "//input[@name='firstName']")
		private WebElement firstName;

		@FindBy(xpath = "//input[@name='middleName']")
		private WebElement middleName;

		@FindBy(xpath = "//input[@name='lastName']")
		private WebElement lastName;

		@FindBy(xpath = "//input[@name='mobileNumber']")
		private WebElement mobileNumber;

		@FindBy(xpath = "//input[@name='personalEmail']")
		private WebElement personalEmail;

		@FindBy(xpath = "//body/app-root/div[@fxlayout='row']/div/app-employee-add/app-edit-view[@ng-reflect-view-defs='[object Object]']/div/form/div/fieldset[@id='Personal Details']/div[@fxlayout='row wrap']/div[3]/mat-form-field[1]/div[1]/div[1]/div[3]")
		private WebElement dateInput;

		@FindBy(xpath = "//button[@aria-label='Choose month and year']")
		private WebElement displayedYear;

		@FindBy(xpath = "//button[@aria-label='Previous 24 years']")
		private WebElement previousYear;

		@FindBy(xpath = "//div[normalize-space()='1987']")
		private WebElement year;

		@FindBy(xpath = "//div[normalize-space()='OCT']")
		private WebElement months;

		@FindBy(xpath = "//div[normalize-space()='27']")
		private WebElement day;

		@FindBy(xpath = "//input[@name='fatherHusbandName']")
		private WebElement fatherHusbandName;

		@FindBy(css = "input[name='addressLine1']")
		private WebElement addressLine1;

		@FindBy(xpath = "//input[@placeholder='Search Pin Code']")
		private WebElement searchPinCode;

		@FindBy(xpath = "//span[normalize-space()='(110066)']")
		private WebElement pinCodeSelection;

		@FindBy(xpath = "//input[@name='code']")
		private WebElement employeeCode;

		@FindBy(xpath = "//input[@name='company']")
		private WebElement companyName;

		@FindBy(xpath = "//input[@name='designationName']")
		private WebElement designationName;

		@FindBy(xpath = "//input[@name='officeEmail']")
		private WebElement officeEmail;

		@FindBy(xpath = "//input[@placeholder='Search Function']")
		private WebElement searchFunction;

		@FindBy(xpath = "//span[normalize-space()='QA']")
		private WebElement functionSelection;

		@FindBy(xpath = "//input[@placeholder='Search Function Role']")
		private WebElement searchFunctionRole;

		@FindBy(xpath = "//span[normalize-space()='Zonal Manager']")
		private WebElement functionRoleSelection;

		@FindBy(xpath = "//input[@name='dateOfJoining']")
		private WebElement dateOfJoining;

		@FindBy(xpath = "//span[contains(text(),'OCT 2024')]")
		private WebElement joiningMonthYear;

		@FindBy(xpath = "//div[normalize-space()='2024']")
		private WebElement yearSelection;

		@FindBy(xpath = "//div[normalize-space()='OCT']")
		private WebElement monthSelection;

		@FindBy(xpath = "//div[normalize-space()='3']")
		private WebElement daySelection;

		@FindBy(xpath = "//button[normalize-space()='Add']")
		private WebElement addButton;

		@FindBy(xpath = "//mat-icon[normalize-space()='dashboard']")
		private WebElement clickDashboard;

		// Methods
		public String validateEmployeePageUrl() {
			return driver.getCurrentUrl();
		}

		public void addEmployee() throws InterruptedException {
			Thread.sleep(2000);
			employee.click();
			Thread.sleep(5000);
			System.out.println("Add Employee clicked");
			addEmployee.click();
			Thread.sleep(5000);
		}

		public void employeeCard() throws InterruptedException {
			// Enter employee details
			salutation.click();
			Thread.sleep(2000);
			System.out.println("Salutation clicked");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(salutationOption));
			clickableElement.click();
			System.out.println("Salutation option selected");

			firstName.sendKeys("Ganesh");
			Thread.sleep(5000);
			middleName.sendKeys("Maroti");
			Thread.sleep(5000);
			lastName.sendKeys("Timande");
			Thread.sleep(5000);
			mobileNumber.sendKeys("9960172176");
			Thread.sleep(5000);
			personalEmail.sendKeys("ganesh.timande@decimal.co.in");
			System.out.println("Email entered");
			Thread.sleep(5000);

			// Date of birth
			dateInput.click();
			Thread.sleep(5000);
			displayedYear.click();
			System.out.println("Year clicked");
			Thread.sleep(5000);
			previousYear.click();
			year.click();
			Thread.sleep(5000);
			months.click();
			Thread.sleep(5000);
			day.click();
			Thread.sleep(5000);
			System.out.println("Date of birth selected");

			// Additional details
			fatherHusbandName.sendKeys("Shankar Timande");
			Thread.sleep(5000);
			addressLine1.sendKeys("Sudhakar residency, Nagpur");
			Thread.sleep(5000);
			searchPinCode.sendKeys("110066");
			System.out.println("Pin code search");
			Thread.sleep(5000);
			pinCodeSelection.click();
			System.out.println("Pin code selected");

			// Employee details
			employeeCode.sendKeys("dec123");
			Thread.sleep(5000);
			companyName.sendKeys("Decimal Technologies");
			Thread.sleep(5000);
			designationName.sendKeys("QA");
			Thread.sleep(5000);
			officeEmail.sendKeys("ganesh.timande@decimal.co.in");
			Thread.sleep(5000);
			searchFunction.sendKeys("QA");
			Thread.sleep(5000);
			functionSelection.click();
			Thread.sleep(5000);
			searchFunctionRole.sendKeys("MANAGER");
			Thread.sleep(5000);
			functionRoleSelection.click();
			System.out.println("Function role selected");

			// Date of joining
			dateOfJoining.click();
			Thread.sleep(5000);
			joiningMonthYear.click();
			Thread.sleep(5000);
			yearSelection.click();
			Thread.sleep(5000);
			monthSelection.click();
			Thread.sleep(5000);
			daySelection.click();
			Thread.sleep(5000);
			System.out.println("Date of joining selected");

			// Scroll to "Add" button and click
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", addButton);
			addButton.click();
			
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(1000));
	        WebElement popup = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Record Added Successfully!']")));

	        // Validate the text in the popup
	        String expectedText = "Record Added Successfully";
	        
	       
	        String actualText = popup.getText();
	        Assert.assertTrue(actualText.contains(expectedText), "Text validation failed. Expected: " + expectedText + " but found: " + actualText);

	        System.out.println("Text validation passed.");
			Thread.sleep(10000);
			System.out.println("Employee added");
		}
	}