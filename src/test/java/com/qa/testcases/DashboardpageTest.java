package com.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.qa.pages.AddFunctionPage;
import com.qa.pages.DashboardPage;
import com.qa.pages.LoginPage;
import com.qa.utilities.Base;

public class DashboardpageTest extends  Base {

	LoginPage loginpage;
	DashboardPage dashboardpage;
	AddFunctionPage addfunctionpage;
	
	public DashboardpageTest()
	{
		super();
	}	
	
	public WebDriver driver;
    @BeforeClass
    public void setup() throws InterruptedException 
    {
        
    driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
    loginpage = new LoginPage();
    dashboardpage=loginpage.login(prop.getProperty("Email"), prop.getProperty("otp"));
	
	
    }
	@Test(priority=1, enabled=true)
	public void validateDashboardpageUrlTest() throws Exception
	{
		dashboardpage = new DashboardPage();
		String url = dashboardpage.validateDashboardpageUrl();
		Assert.assertEquals(url, "https://preprod-web.vahanacloud.com/admin-portal-test/#/dashboard");
	}
	
	@Test(priority=2, enabled=true)
	public void validateDashboardpageTitleTest()
	{			
		String title = dashboardpage.validateDashboardpageTitle();
		Assert.assertEquals(title, "Admin-Portal");
	}

	   @Test(priority=3, enabled=true)
	    public void functionDisplayed() {
	        // Navigate to the target page
	       
	        // Check if the module is displayed
	        WebElement  function= driver.findElement(By.xpath("//p[normalize-space()='Function']"));  // Change the ID to the actual ID of the module
	        Assert.assertTrue(function.isDisplayed(), "The function module is not displayed.");

	       
	    }
	
	
	
	@Test(priority=4, enabled=true)
	public void FunctioncardTest() throws Throwable
	{
		dashboardpage = new DashboardPage();
		addfunctionpage=dashboardpage.Functioncard();
	}

	   @AfterClass
	    public void tearDown() 
	    {
	        
	        driver.quit();
	        
	    }
	

}
