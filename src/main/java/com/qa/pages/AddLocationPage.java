package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utilities.Base;


public class AddLocationPage extends Base {
	
	public AddLocationPage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//p[normalize-space()='Location']") 
	private WebElement Locationcard;
	
	@FindBy(xpath="//button[normalize-space()='Add Location']")
	private  WebElement AddLocationbtn;
	
	
	@FindBy(xpath="//input[@name='code']")
	private  WebElement Locationcode;
	
	
	@FindBy(xpath= "//input[@name='name']")
	private WebElement Locationname;
	
	@FindBy(xpath= "//input[@placeholder='Search Parent Location']")
	WebElement parentlocation;
	
	@FindBy(xpath= "//span[normalize-space()='Delhi']")
	private WebElement delhi;
	
	@FindBy(xpath= "//input[@placeholder='Search Head Emp']")
	private WebElement headEmp;
	
	@FindBy(xpath= "//mat-option[1]//span[1]//div[1]//span[1]")
	private WebElement headempname;
	
	@FindBy(xpath= "//input[@name='type']")
	private WebElement type;
	
	@FindBy(xpath= "//input[@name='subtype']")
	private WebElement subType;

	@FindBy(xpath= "//div[4]//div[1]//mat-form-field[1]//div[1]//div[1]//div[3]//input[1]")
	private WebElement address1;
	
	@FindBy(xpath= "//input[@placeholder='Search Pin Code']")
	private WebElement pincode;
	
	@FindBy(xpath= "//button[normalize-space()='Add']")
	private WebElement addlocation;


	public AddLocationPage AddLocation() throws InterruptedException 
	{
	
		Thread.sleep(5000);
		Locationcard.click();
		System.out.println("location carrd click");
		Thread.sleep(5000);
		AddLocationbtn.click();
		Thread.sleep(5000);
		
		Locationcode.sendKeys("AUTOMATIONTESTING");
		System.out.println("test");
		Thread.sleep(5000);
		Locationname.sendKeys("Sudhakar recidency");
		System.out.println("location nameename");
		
		Thread.sleep(5000);
		
		parentlocation.sendKeys("delhi");
		Thread.sleep(2000);
		delhi.click();
		
		
		headEmp.sendKeys("Vikas");
		System.out.println("qq");
		Thread.sleep(4000);
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", headempname);
	//	headempname.click();
		System.out.println("qqwwwwwwwwww");
		type.sendKeys("testing");
		Thread.sleep(3000);
		subType.sendKeys("testing demo");
		Thread.sleep(3000);
		
		address1.sendKeys("Sudhakar recidency , Nagpur");
		Thread.sleep(3000);
		pincode.sendKeys("110018");
		Thread.sleep(3000);
		System.out.println("Done");
		WebElement element =driver.findElement(By.xpath("//span[normalize-space()='(110018)']")); // Replace with appropriate locator
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		System.out.println("pincode1");
		Thread.sleep(6000);
		
//		enterFunctioncode.click();
//		Thread.sleep(5000);
		//driver.findElement(By.xpath("//body/app-root/div[@fxlayout='row']/div/app-location-add/app-edit-view[@ng-reflect-view-defs='[object Object]']/div/form/div/div[9]/div[1]/mat-form-field[1]/div[1]/div[1]/div[3]")).sendKeys("Add Function Location");
		//Thread.sleep(5000);
		System.out.println("Done");//body/app-root/div[@fxlayout='row']/div/app-location-add/app-edit-view[@ng-reflect-view-defs='[object Object]']/div/form/div/div[9]/div[1]/mat-form-field[1]/div[1]/div[1]/div[3]
		WebElement element1 = driver.findElement(By.xpath("//textarea[@name='description']")); // Replace with appropriate locator
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
		  // or sendKeys
		Thread.sleep(5000);
		element1.sendKeys("Location description demo");
		Thread.sleep(5000);
		System.out.println("Location done");
	//	WebElement element1 = driver.findElement(By.xpath("//textarea[@name='description']")); // Replace with appropriate locator
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addlocation);
		
		addlocation.click();
		Thread.sleep(5000);
		return  new AddLocationPage();
	}

}
