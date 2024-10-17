package com.qa.testcases;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.pages.AddFunctionPage;
import com.qa.pages.AddFunctionRolePage;
import com.qa.pages.AddLocationPage;
import com.qa.pages.DashboardPage;
import com.qa.pages.LoginPage;
import com.qa.utilities.Base;


public class AddlocationpageTest extends  Base {
	LoginPage loginpage;
	DashboardPage dashboardpage;
	AddFunctionPage addfunctionpage;
	AddFunctionRolePage dashboardfunctionrolepage;
	AddLocationPage dashboardlocationpage;
	
	public AddlocationpageTest()
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
	
	
	
	
	
//	@Test(priority=1, enabled=true)
//	public void validateFunctionPageUrlTest() throws Exception
//	{
//		dashboardfunctionrolepage = new Dashboardfunctionrolepage();
//		String url = dashboardfunctionrolepage.validateFunctionPageUrl();
//		Assert.assertEquals(url, "https://preprod-web.vahanacloud.com/admin-portal-test/#/org-management/function-role");
//	}
	@Test(priority=1, enabled=true)
	public void AddLocationTest() throws Throwable
	{  
		dashboardpage= new DashboardPage();
		dashboardlocationpage=new AddLocationPage();
		dashboardlocationpage.AddLocation();	
	}
	@AfterClass
    public void tearDown() 
    {
        
        driver.quit();
    }
}
