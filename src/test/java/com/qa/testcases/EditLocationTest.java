package com.qa.testcases;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import com.qa.pages.Addemployee;

import com.qa.pages.DashboardPage;
import com.qa.pages.EditFunction;
import com.qa.pages.EditLocation;
import com.qa.pages.AddFunctionPage;
import com.qa.pages.AddFunctionRolePage;
import com.qa.pages.LoginPage;

import com.qa.utilities.Base;

public class EditLocationTest extends  Base{

	LoginPage loginpage;
	DashboardPage dashboardpage;
	AddFunctionPage addfunctionpage;
	AddFunctionRolePage dashboardfunctionrolepage;
	Addemployee addemployee;
	EditFunction editFunction;
	EditLocation editLocation;
	public EditLocationTest()
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
		editLocation = new EditLocation();

	}


	@Test(priority = 1)
	public void validateEmployeePageUrlTest() throws InterruptedException {
		// Call the method to search and edit function
		editLocation.validateEmployeePageUrl();
		// Assertions can be added here to verify the expected outcome
	}
	@Test(priority = 2)
	public void LocationTest() throws InterruptedException {
		// Directly call the edit function for a specific scenario
		editLocation.Location();
		// Assertions can be added here to verify the expected outcome
	}

	@Test(priority = 3)
	public void LocationEditTest() throws InterruptedException {
		// Directly call the edit function for a specific scenario
		editLocation.LocationEdit();
		// Assertions can be added here to verify the expected outcome
	}

	@Test(priority = 3)
	public void LocationViewTest() throws InterruptedException {
		// Directly call the delete function for a specific scenario
		editLocation.LocationView();
		// Assertions can be added here to verify the expected outcome
	}
	

	@Test(priority = 4)
	public void DeletelocationTest() throws InterruptedException {
		// Directly call the delete function for a specific scenario
		editLocation.Deletelocation();
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