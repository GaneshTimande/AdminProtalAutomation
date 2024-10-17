package com.qa.pages;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.utilities.Base;
public class EditFunction extends Base {

    // Constructor to initialize PageFactory
    public EditFunction() {
        PageFactory.initElements(driver, this);
    }

    // Web elements with proper camel case
    @FindBy(xpath = "//input[@placeholder='Search Function Code']")
    private WebElement functionCodeSearch;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//p[normalize-space()='Function']")
    private WebElement functionTab;

    @FindBy(xpath = "//mat-row[1]//mat-cell[4]//div[1]//a[1]//*[name()='svg']//*[name()='path' and contains(@fill,'#0696e8')]")
    private  WebElement editPencilIcon;

    // Edit Function Name field
    @FindBy(xpath = "//input[@name='name']")
    private WebElement functionName;

    // Status dropdown
    @FindBy(xpath = "//mat-select[@role='combobox']//div[2]")
    private WebElement statusDropdown;

    // Status Active option
    @FindBy(xpath = "//mat-option[@role='option']//span[contains(text(),'Active')]")
    private WebElement statusActiveOption;

    // Description textarea
    @FindBy(xpath = "//textarea[@name='description']")
    private WebElement descriptionField;

    // Update button
    @FindBy(xpath = "//button[normalize-space()='Update']")
    private WebElement updateButton;

    // Eye button to view details
    @FindBy(xpath = "//mat-row[1]//mat-cell[4]//div[1]//a[2]//*[name()='svg']")
    private WebElement eyeButton;

    // Edit button
    @FindBy(xpath = "//button[normalize-space()='Edit']")
    private WebElement editButton;

    // Search Head Emp field
    @FindBy(xpath = "//input[@placeholder='Search Head Emp']")
    private WebElement searchHeadEmpField;

    // TestRohit option
    @FindBy(xpath = "//span[normalize-space()='testRohit']")
    WebElement testRohitOption;

    // Delete Pencil Icon
    @FindBy(xpath = "//mat-row[1]//mat-cell[4]//div[1]//a[3]//*[name()='svg']")
    WebElement deletePencilIcon;

    // OK button for delete confirmation
    @FindBy(xpath = "//button[@class='mat-focus-indicator btn-primary btn-md mat-button mat-button-base']")
    WebElement okButton;

    // Method to perform search and edit actions
    public void searchAndEditFunction() throws InterruptedException {
        functionTab.click();
        Thread.sleep(5000);

        functionCodeSearch.sendKeys("SUNDAYTESTING");
        Thread.sleep(5000);

        System.out.println("Searching for function code: SUNDAYTESTING");
        searchButton.click();
        Thread.sleep(5000);
// Edit method
        
    }
        public void editFunction() throws InterruptedException {
            
        List<WebElement> listItems = driver.findElements(By.xpath("//mat-card[@class='mat-card mat-focus-indicator']"));

        if (!listItems.isEmpty()) {
            WebElement firstItem = listItems.get(0);
            firstItem.click();
            Thread.sleep(5000);

            editPencilIcon.click();
            System.out.println("Editing function: " + firstItem.getText());
            Thread.sleep(9000);

            functionName.clear();
            Thread.sleep(3000);

            functionName.sendKeys("SUNDAYTESTING Testing function updated");
            Thread.sleep(3000);

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", statusDropdown);
            statusDropdown.click();

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", statusActiveOption);
            statusActiveOption.click();
            Thread.sleep(5000);

            System.out.println("Selected status: Active");
            descriptionField.clear();
            Thread.sleep(4000);

            descriptionField.sendKeys("SUNDAYTESTING Testing Description Updated");
            Thread.sleep(5000);

            updateButton.click();
            System.out.println("Function updated successfully.");
            Thread.sleep(5000);

            //// Update method
            functionCodeSearch.sendKeys("SUNDAYTESTING");
            Thread.sleep(5000);

            System.out.println("Searching for function code: SUNDAYTESTING again");
            searchButton.click();
            Thread.sleep(5000);

            eyeButton.click();
            System.out.println("Viewing details of the function.");
            Thread.sleep(5000);

            editButton.click();
            System.out.println("Clicking on Edit button.");
            Thread.sleep(5000);

            searchHeadEmpField.clear();
            Thread.sleep(5000);

            searchHeadEmpField.sendKeys("test");
            Thread.sleep(4000);

            testRohitOption.click();
            Thread.sleep(2000);

            updateButton.click();
            System.out.println("Head employee updated successfully.");
            Thread.sleep(2000);
        } else {
            System.out.println("No function found with code: SUNDAYTESTING");
        }
    }
            
            // Delete method
        public void deleteFunction() throws InterruptedException {
            functionCodeSearch.sendKeys("SUNDAYTESTING");
            Thread.sleep(5000);

            System.out.println("Searching for function code: SUNDAYTESTING once more");
            searchButton.click();
            Thread.sleep(5000);

            deletePencilIcon.click();
            System.out.println("Clicked on delete option.");
            Thread.sleep(5000);

            okButton.click();
            Thread.sleep(5000);
            System.out.println("Deletion confirmed successfully.");
        }
    }
