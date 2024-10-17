package com.qa.testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import com.qa.pages.Addemployee;
import com.qa.pages.AddFunctionPage;
import com.qa.pages.DashboardPage;
import com.qa.pages.EditFunction;
import com.qa.pages.EditFunctionRole;
import com.qa.pages.AddFunctionRolePage;
import com.qa.pages.LoginPage;

import com.qa.utilities.Base;

public class EditFunctionRoleTest extends  Base{

	LoginPage loginpage;
	DashboardPage dashboardpage;
	AddFunctionPage addfunctionpage;
	AddFunctionRolePage dashboardfunctionrolepage;
	Addemployee addemployee;
	EditFunction editFunction;
	 EditFunctionRole editFunctionRole;
	public EditFunctionRoleTest()
	{
		super();
	}	
	
	  public WebDriver driver;
	    @BeforeClass
	    public void setup() throws InterruptedException 
	    {
	        
	    driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
	    loginpage = new LoginPage();
	    dashboardpage= loginpage.login(prop.getProperty("Email"), prop.getProperty("otp")); 
	    editFunctionRole = new EditFunctionRole();  // Initialize the EditFunctionRole page object
	    }

	    // Test to verify the page title
	    

	    @Test(priority = 1)
	    public void verifyTitleTest() throws InterruptedException {
	        editFunctionRole.verifyTitle("Admin-Portal");  // Verify title with the expected title
	        // You can add assertions here to verify if the function role is updated correctly
	        System.out.println("verifyTitleTest executed successfully.");
	    }

	    @Test(priority = 2)
	    public void verifyUrlTest() throws InterruptedException {
	        editFunctionRole.verifyUrl("https://preprod-web.vahanacloud.com/admin-portal-test/#/org-management/function-role");  // Verify URL with the expected URL
	        // You can add assertions here to verify if the function role is updated correctly
	        System.out.println("verifyUrlTest executed successfully.");
	    }

	    // Test to search and edit a function role
	    @Test(priority = 3)
	    public void searchEditFunctionRoleTest() throws InterruptedException {
	        editFunctionRole.searchEditFunctionRole();  // Search for the function role and edit it
	        // You can add assertions here to verify if the function role is updated correctly
	        System.out.println("searchEditFunctionRoleTest executed successfully.");
	    }

	    @Test(priority = 4)
	    public void viewEditFunctionRoleTest() throws InterruptedException {
	        editFunctionRole.viewEditFunctionRole();  // Search for the function role and edit it
	        // You can add assertions here to verify if the function role is updated correctly
//	        String actualMessage = driver.findElement(By.xpath("span[normalize-space()='Record Updated Successfully!']")).getText();
//	        String expectedMessage = "Record Updated Successfully";
//	        Assert.assertEquals(actualMessage, expectedMessage, "Record Updated failed!");
	        
//	      @FindBy(xpath = "span[normalize-space()='Record Updated Successfully!']")
//	      private WebElement Record_Updated;
	        System.out.println("viewEditFunctionRoleTest executed successfully.");
	    }

	    @Test(priority = 5)
	    public void deleteFunctionRoleTest() throws InterruptedException {
	        editFunctionRole.deleteFunctionRole();  // Delete the function role
	        // You can add assertions here to verify if the function role is deleted correctly
	        System.out.println("deleteFunctionRoleTest executed successfully.");
	    }

	    @AfterClass
	    public void tearDown() {
	        // Clean up after tests (e.g., close the browser)
	    	driver.quit(); // Method to close WebDriver (not shown here)
	    }
}