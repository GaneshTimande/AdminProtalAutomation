package com.qa.testcases;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.pages.Addemployee;
import com.qa.pages.AddFunctionPage;
import com.qa.pages.AddFunctionRolePage;
import com.qa.pages.DashboardPage;
import com.qa.pages.LoginPage;
import com.qa.utilities.Base;


public class AddemployeeTest extends  Base {
	LoginPage loginpage;
	DashboardPage dashboardpage;
	AddFunctionPage addfunctionpage;
	AddFunctionRolePage dashboardfunctionrolepage;
	Addemployee addemployee;
	
	public AddemployeeTest()
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
	   
	    }
	
	
	
	@Test(priority=1, enabled=true)
	public void validateEmployeePageUrlTest() throws Exception
	{
		
		 addfunctionpage = new AddFunctionPage();
		
		 addemployee = new Addemployee();
		String url = addemployee.validateEmployeePageUrl();
		Assert.assertEquals(url, "https://preprod-web.vahanacloud.com/admin-portal-test/#/dashboard");
	}
	
	@Test(priority=2, enabled=true)
	public void addEmployeeTest() throws Throwable
	{
		
		addemployee.addEmployee();
	}
	@Test(priority=3, enabled=true)
	public void employeeCardTest() throws Throwable
	{  
		
		addemployee.employeeCard(); 
	}
	
	
	 @AfterClass
	    public void tearDown() 
	    {
	        
	        driver.quit();
	        
	    }
}
