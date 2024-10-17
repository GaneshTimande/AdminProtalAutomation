package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utilities.Base;// Constructor to initialize PageFactory


public class EditFunctionRole extends Base {


    public EditFunctionRole() {
        PageFactory.initElements(driver, this);
    }

    // Web elements with camel case naming and declared as private
    @FindBy(xpath = "//p[normalize-space()='Function Role']")
    private WebElement functionRoleTab;

    @FindBy(xpath = "//input[@placeholder='Search Function Role Name']")
    private WebElement functionRoleNameField;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//body//app-root//a[1]//*[name()='svg']//*[name()='path' and contains(@fill,'#0696e8')]")
    private WebElement editIcon;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement functionNameField;

    @FindBy(xpath = "//mat-select[@role='combobox']//div[2]")
    private WebElement statusDropdown;

    @FindBy(xpath = "//mat-option[@role='option']//span[contains(text(),'Active')]")
    private WebElement statusActiveOption;

    @FindBy(xpath = "//textarea[@name='description']")
    private WebElement descriptionField;

    @FindBy(xpath = "//button[normalize-space()='Update']")
    private WebElement updateButton;

    @FindBy(xpath = "//mat-row[1]//mat-cell[5]//div[1]//a[2]//*[name()='svg']//*[name()='path' and contains(@fill,'#0696e8')]")
    private WebElement viewButton;

    @FindBy(xpath = "//button[normalize-space()='Edit']")
    private WebElement editViewButton;

    @FindBy(xpath = "//input[@placeholder='Search Parent Role']")
    private WebElement parentRoleSearchField;

    @FindBy(xpath = "//span[normalize-space()='Manager Role']")
    private WebElement managerRoleOption;

    @FindBy(xpath = "//mat-row[1]//mat-cell[5]//div[1]//a[3]//*[name()='svg']")
    private WebElement deleteIcon;

    @FindBy(xpath = "//span[normalize-space()='Ok']")
    private WebElement okDeleteButton;

    
    ////span[normalize-space()='Record Updated Successfully!']
    
//    @FindBy(xpath = "span[normalize-space()='Record Updated Successfully!']")
//    private WebElement Record_Updated;

    // Method to search and edit function role
    public void searchEditFunctionRole() throws InterruptedException {
        functionRoleTab.click();
        Thread.sleep(5000);

        functionRoleNameField.sendKeys("Yes Bank Testing Demo");
        Thread.sleep(5000);

        System.out.println("Searching for function code: Yes Bank Testing Demo");
        searchButton.click();
        Thread.sleep(5000);

        editIcon.click();
        Thread.sleep(5000);

        functionNameField.clear();
        Thread.sleep(3000);
        functionNameField.sendKeys("Yes Bank Testing Demo Updated");
        Thread.sleep(3000);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", statusDropdown);
        statusDropdown.click();

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", statusActiveOption);
        statusActiveOption.click();
        Thread.sleep(5000);

        System.out.println("Selected status: Active");
        descriptionField.clear();
        Thread.sleep(4000);
        descriptionField.sendKeys("Testing Function Role Update");
        updateButton.click();
        Thread.sleep(4000);
        System.out.println("Function role updated.");
    }

    // Method to view and edit function role
    public void viewEditFunctionRole() throws InterruptedException {
        WebElement dashboard = driver.findElement(By.xpath("//mat-icon[normalize-space()='dashboard']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", dashboard);
        System.out.println("Scrolled to element: " + dashboard);
        js.executeScript("arguments[0].click();", dashboard);
        System.out.println("Clicked on dashboard");
        Thread.sleep(4000);

        functionRoleTab.click();
        Thread.sleep(5000);

        functionRoleNameField.sendKeys("Yes Bank Testing Demo");
        Thread.sleep(5000);

        System.out.println("Searching for function code: Yes Bank Testing Demo");
        searchButton.click();
        Thread.sleep(5000);

        viewButton.click();
        Thread.sleep(5000);
        editViewButton.click();
        Thread.sleep(5000);

        parentRoleSearchField.clear();
        Thread.sleep(5000);
        parentRoleSearchField.sendKeys("Manager");
        Thread.sleep(3000);

        managerRoleOption.click();
        Thread.sleep(3000);

        updateButton.click();
        Thread.sleep(2000);
        System.out.println("Function role updated after viewing.");
    }

    // Method to delete function role
    public void deleteFunctionRole() throws InterruptedException {
        WebElement dashboard1 = driver.findElement(By.xpath("//mat-icon[normalize-space()='dashboard']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", dashboard1);
        System.out.println("Scrolled to element: " + dashboard1);
        js.executeScript("arguments[0].click();", dashboard1);
        System.out.println("Clicked on dashboard for deletion");
        Thread.sleep(5000);

        functionRoleTab.click();
        Thread.sleep(5000);

        functionRoleNameField.sendKeys("Yes Bank Testing Demo");
        Thread.sleep(5000);

        System.out.println("Searching for function code: Yes Bank Testing Demo");
        searchButton.click();
        Thread.sleep(5000);

        deleteIcon.click();
        Thread.sleep(5000);
        okDeleteButton.click(); // Assuming you want to confirm the deletion
        Thread.sleep(5000);

        System.out.println("Function role deleted.");
    }

    // Method to verify the page title
    public boolean verifyTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        System.out.println("Actual Title: " + actualTitle);
        return actualTitle.equals(expectedTitle);
    }

    // Method to verify the page URL
    public boolean verifyUrl(String expectedUrl) {
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
        return currentUrl.equals(expectedUrl);
    }
}