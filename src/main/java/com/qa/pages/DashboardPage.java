package com.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.utilities.Base;



public class DashboardPage extends Base {
	
	public DashboardPage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//p[text()='Function']") 
	WebElement Functioncard;
	public String validateDashboardpageUrl() 
	{
		return driver.getCurrentUrl();
	}
	

	public String validateDashboardpageTitle() {
		return driver.getTitle();
	}
	
	
	
	

	
	public AddFunctionPage Functioncard() throws InterruptedException 
	{
		Thread.sleep(2000);
		Functioncard.click();
		Thread.sleep(5000);
		return  new AddFunctionPage();

	}
	
	
	
	
	
	
	
	
}
