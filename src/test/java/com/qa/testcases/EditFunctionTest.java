package com.qa.testcases;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import com.qa.pages.Addemployee;
import com.qa.pages.AddFunctionPage;
import com.qa.pages.DashboardPage;
import com.qa.pages.EditFunction;
import com.qa.pages.AddFunctionRolePage;
import com.qa.pages.LoginPage;

import com.qa.utilities.Base;

public class EditFunctionTest extends  Base{

	LoginPage loginpage;
	DashboardPage dashboardpage;
	AddFunctionPage addfunctionpage;
	AddFunctionRolePage dashboardfunctionrolepage;
	Addemployee addemployee;
	EditFunction editFunction;
	public EditFunctionTest()
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
	    editFunction = new EditFunction();
	    }


	    @Test(priority = 1)
	    public void EditFunctionSearchAndEditTest() throws InterruptedException {
	        // Call the method to search and edit function
	        editFunction.searchAndEditFunction();
	        // Assertions can be added here to verify the expected outcome
	    }

	    @Test(priority = 2)
	    public void EditFunctionsTest() throws InterruptedException {
	        // Directly call the edit function for a specific scenario
	        editFunction.editFunction();
	        // Assertions can be added here to verify the expected outcome
	    }

	    @Test(priority = 3)
	    public void EditFunctionDeleteTest() throws InterruptedException {
	        // Directly call the delete function for a specific scenario
	        editFunction.deleteFunction();
	        // Assertions can be added here to verify the expected outcome
	    }

	    @AfterClass
	    public void tearDown() {
	        // Close the browser after tests are complete
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}