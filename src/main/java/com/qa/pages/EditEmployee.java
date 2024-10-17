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

import com.qa.utilities.Base;


public class EditEmployee extends Base {
	
	// Constructor
		public EditEmployee() {
			PageFactory.initElements(driver, this);
		}

		// WebElements
		 @FindBy(xpath = "//p[normalize-space()='Employee']")
		    private WebElement employee;

		    @FindBy(xpath = "//input[@placeholder='Search Employee Code']")
		    private WebElement employeeCode;

		    @FindBy(xpath = "//button[normalize-space()='Search']")
		    private WebElement searchButton;

		    @FindBy(xpath = "//mat-row[1]//mat-cell[6]//div[1]//a[1]//*[name()='svg']//*[name()='path' and contains(@fill,'#0696e8')]")
		    private WebElement pencilicon;

		    @FindBy(css = "input[name='addressLine2']")
		    private WebElement addressLine2;

		    @FindBy(xpath = "//button[normalize-space()='Update']")
		    private WebElement updateButton;
		    
		    
		    //   // WebElements view
		   

		    @FindBy(xpath = "//mat-row[1]//mat-cell[6]//div[1]//a[2]//*[name()='svg']")
		    private WebElement viewIcon;

		    @FindBy(xpath = "//button[normalize-space()='Edit']")
		    private WebElement editButton;

		    @FindBy(name = "addressLine3")
		    private WebElement addressLine3;

		    
		    
		//   deelte
			   

		    @FindBy(xpath = "//mat-row[1]//mat-cell[6]//div[1]//a[3]//*[name()='svg']")
		    private WebElement Delete;
		    @FindBy(xpath = "//span[normalize-space()='Ok']")
		    private WebElement Deleteok;


		// Methods
		public String validateEmployeePageUrl() {
			return driver.getCurrentUrl();
		}

		public void SearchEmployee() throws InterruptedException {
			Thread.sleep(2000);
			employee.click();
			Thread.sleep(5000);
			System.out.println("Add Employee clicked");
			employeeCode.sendKeys("Dec123");
			Thread.sleep(5000);
			searchButton.click();
			System.out.println("Search clicked");
			Thread.sleep(5000);
			pencilicon.click();
			System.out.println("pencil clicked");
			Thread.sleep(5000);
			addressLine2.clear();
			Thread.sleep(1000);
			addressLine2.sendKeys("Nagpur");
			
           System.out.println("address updated");
           Thread.sleep(5000);
           updateButton.click();
 System.out.println("Employee updated done");
    Thread.sleep(5000);




		}
		public void ViewEmployee() throws InterruptedException {
			Thread.sleep(2000);
			//employee.click();
			Thread.sleep(5000);
			//System.out.println("Add Employee clicked");
			employeeCode.sendKeys("Dec123");
			Thread.sleep(5000);
			searchButton.click();
			System.out.println("Search clicked");
			Thread.sleep(5000);
			viewIcon.click();
			System.out.println("viewIcon clicked");
			Thread.sleep(7000);
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 
			 js.executeScript("arguments[0].scrollIntoView(true);", editButton);
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		        // Wait for the element to be visible
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Edit']")));;
		        js.executeScript("arguments[0].click();",editButton);
			//editButton.click();
			System.out.println("edit clicked");
			Thread.sleep(5000);
			addressLine3.clear();
			Thread.sleep(5000);
			addressLine3.sendKeys("Nagpur");
			
           System.out.println("address updated");
           Thread.sleep(5000);
           updateButton.click();
 System.out.println("Employee view updated done");
    Thread.sleep(5000);
	}
		public void DeleteEmployee() throws InterruptedException {
			Thread.sleep(2000);
			//employee.click();
			Thread.sleep(5000);
			//System.out.println("Add Employee clicked");
			employeeCode.sendKeys("Dec123");
			Thread.sleep(5000);
			searchButton.click();
			System.out.println("Search clicked");
			Thread.sleep(5000);
			Delete.click();
			System.out.println("viewIcon clicked");
			Thread.sleep(7000);
			Deleteok.click();
			System.out.println("Employee delted successfully");
			
		}
}