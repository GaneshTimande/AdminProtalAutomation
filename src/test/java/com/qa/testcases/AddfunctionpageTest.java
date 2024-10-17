package com.qa.testcases;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.pages.AddFunctionPage;
import com.qa.pages.AddFunctionRolePage;
import com.qa.pages.DashboardPage;
import com.qa.pages.LoginPage;
import com.qa.utilities.Base;


public class AddfunctionpageTest extends  Base {
	LoginPage loginpage;
	DashboardPage dashboardpage;
	AddFunctionPage addfunctionpage;
	AddFunctionRolePage dashboardfunctionrolepage;
	
	public AddfunctionpageTest()
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
	public void FunctionPageUrlTest() throws Exception
	{
		 addfunctionpage = new AddFunctionPage();
		 addfunctionpage=dashboardpage.Functioncard();
		String url = addfunctionpage.validateFunctionPageUrl();
		Assert.assertEquals(url, "https://preprod-web.vahanacloud.com/admin-portal-test/#/org-management/function");
	}
	
	@Test(priority=2, enabled=true)
	public void FunctioncardTest() throws Throwable
	{
		addfunctionpage = new AddFunctionPage();
		addfunctionpage.clickAddFunctionCard();
	}
	@Test(priority=3, enabled=true)
	public void FunctionnameTest() throws Throwable
	{  
		addfunctionpage = new AddFunctionPage();
		addfunctionpage.enterFunctionDetails(); 
	}
	@Test(priority=4, enabled=true)
	public void FunctionAddTest() throws Throwable
	{  
		addfunctionpage = new AddFunctionPage();
		dashboardfunctionrolepage=addfunctionpage.clickAddButton(); 
		
		
		
	}
	
	 @AfterClass
	    public void tearDown() 
	    {
	        
	        driver.quit();
	        
	    }
}
