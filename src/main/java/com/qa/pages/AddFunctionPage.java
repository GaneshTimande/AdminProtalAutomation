package com.qa.pages;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.utilities.Base;

public class AddFunctionPage extends Base {

    public AddFunctionPage() {
        PageFactory.initElements(driver, this);
    }

    // Web elements with proper camel case
    @FindBy(xpath = "//button[text()=' Add Function']")
    private WebElement addFunctionCard;

    @FindBy(xpath = "//input[@name='code']")
    private WebElement functionCode;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement functionName;

    @FindBy(xpath = "//textarea[@name='description']")
    private WebElement enterDescription;

    @FindBy(xpath = "//div[contains(@class,'mat-select-trigger')]")
    private WebElement status;

    @FindBy(xpath = "//input[@name='effectiveDate']")
    private WebElement effectiveDate;

    @FindBy(xpath = "//button[@type='button' and @aria-current='date']")
    private WebElement currentDate;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement addBtn;

    @FindBy(xpath = "//mat-icon[normalize-space()='dashboard']")
    private WebElement clickDashboard;

    

    // Method to validate page URL
    public String validateFunctionPageUrl() {
        return driver.getCurrentUrl();
    }

    // Click the "Add Function" card
    public void clickAddFunctionCard() throws InterruptedException {
        Thread.sleep(2000);
        addFunctionCard.click();
        Thread.sleep(5000);
        System.out.println("Add Function card clicked");
    }

    // Enter function details
    public void enterFunctionDetails() throws InterruptedException {
        Thread.sleep(5000);
        functionCode.sendKeys("SUNDAYTESTING");
        System.out.println("Function code entered: SUNDAYTESTING");
        Thread.sleep(2000);

        functionName.sendKeys("SUNDAY TESTING Bank Testing");
        System.out.println("Function name entered: SUNDAY TESTING Bank Testing");
        Thread.sleep(5000);

        enterDescription.sendKeys("Add Function Testing");
        System.out.println("Function description entered: Add Function Testing");
        Thread.sleep(5000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Locate the dropdown search input field
        WebElement searchInput = driver.findElement(By.xpath("//input[@placeholder='Search Head Emp']"));
        searchInput.sendKeys("Vikas");
        System.out.println("Searching for head employee: Vikas");

        // Wait until the dropdown options appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ng-star-inserted"))); // Adjust class name if necessary
        WebElement element = driver.findElement(By.xpath("//span[normalize-space()='(TESTAMANHARSH)']"));
        element.click();
        System.out.println("Dropdown selected: (TESTAMANHARSH)");
    }

    // Click the "Add" button
    public AddFunctionRolePage clickAddButton() throws InterruptedException {
        Thread.sleep(2000);
        addBtn.click();
        System.out.println("Add button clicked");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Record Added Successfully!']")));

        // Validate the text in the popup
        String expectedText = "Record Added Successfully";
        
       
        String actualText = popup.getText();
        Assert.assertTrue(actualText.contains(expectedText), "Text validation failed. Expected: " + expectedText + " but found: " + actualText);

        System.out.println("Text validation passed.");
        
        
        
        
        Thread.sleep(5000);

        return new AddFunctionRolePage();
    }
    
   
    
}