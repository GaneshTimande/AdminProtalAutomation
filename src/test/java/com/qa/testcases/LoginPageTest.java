package com.qa.testcases;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.qa.pages.LoginPage;
import org.testng.Assert;


import com.qa.utilities.Base;
import com.qa.utilities.Utilities;
import com.util.JiraPolicy;


public class LoginPageTest extends Base{
   
    LoginPage loginpage;
    DashboardpageTest landingpage;
    
    public LoginPageTest(){
        super();
    }
    
    public WebDriver driver;
    @BeforeClass
    public void setup() 
    {
        
    driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
    loginpage = new LoginPage();
    }
    @JiraPolicy(logTicketReady=true)
   @Test(priority=1,enabled=true,retryAnalyzer =com.qa.listeners.RetryAnalyzer.class)
   // @Test(priority=1, enabled=true)
	public void LoginPageTitleTest()
	{
		String Title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(Title, "Admin-Portal1");
	}
    
    
    @Test(priority=2, enabled=true)
   	public void LoginPageUrlTest()
   	{
    	String url =loginpage.validateLoginPageUrl();
   		Assert.assertEquals(url, "https://preprod-web.vahanacloud.com/admin-portal-test/#/login");
   	}
    
    @Test(priority=3, enabled=true)
    public void LoginEmailAddressDisplayed() {
        // Navigate to the target page
       
        // Check if the module is displayed
        WebElement  Email_Address= driver.findElement(By.xpath("//input[@autocomplete='off']"));  // Change the ID to the actual ID of the module
        Assert.assertTrue(Email_Address.isDisplayed(), "The function module is not displayed.");

       
    }
    
    
    
    @JiraPolicy(logTicketReady=false)
  //@Test(priority=4, enabled=true,retryAnalyzer =com.qa.listeners.RetryAnalyzer.class)
  //@Test(priority=4, dataProvider="excelData",enabled=true,retryAnalyzer =com.qa.listeners.RetryAnalyzer.class)
   @Test(priority=4, dataProvider="excelData",enabled=true)
   // @Test(priority=4,enabled=true)
    
    public void LoginLoginTest(String Email, String otp) throws InterruptedException{
        
    	//loginpage = new LoginPage();
     loginpage.login(prop.getProperty("Email"), prop.getProperty("otp")); 
        
    
       
    }
    @DataProvider(name = "excelData")
	public Object[][] supplyTestData() {
		
		Object[][] data =  Utilities.getTestDataFromExcel("Login");
		return data;
	}
    
    
    
   
   
    @AfterClass
    public void tearDown() 
    {
        
        driver.quit();
        
    }

}