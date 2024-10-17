package com.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.utilities.Base;


public class EditLocation extends Base {
	
	public EditLocation()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//p[normalize-space()='Location']") 
	WebElement Location;
	
	
	
	@FindBy(xpath="//input[@placeholder='Search Location Name']")
	WebElement LocationName;	
	
	@FindBy(xpath="//button[normalize-space()='Search']")
	WebElement Search;
	
	@FindBy(xpath= "//mat-row[1]//mat-cell[5]//div[1]//a[1]//*[name()='svg']")
	WebElement PencilIcon;
	
	
	@FindBy(xpath="//textarea[@name='description']")
	WebElement Description;
	
	@FindBy(xpath="//button[normalize-space()='Update']")
	WebElement LocationUpdate;
	
	
	
	@FindBy(xpath="//mat-row[1]//mat-cell[5]//div[1]//a[1]//*[name()='svg']//*[name()='path' and contains(@fill,'#0696e8')]")
	WebElement EyeIcon;
	@FindBy(xpath="//button[@class='primary-btn ng-star-inserted']")
	WebElement Edit;
	
	@FindBy(css="input[name='addressLine1']")
	WebElement Address1;
	
	@FindBy(xpath="//mat-row[1]//mat-cell[5]//div[1]//a[3]//*[name()='svg']")
	WebElement DeleteIcon;
	
	@FindBy(xpath="//span[normalize-space()='Ok']")
	WebElement DeleteButton;
	
	
	
	
	
	
	
	
	

	public String validateEmployeePageUrl() 
	{
		return driver.getCurrentUrl();
	}
	public void Location() throws InterruptedException 
	{
		Thread.sleep(2000);
		Location.click();
		
		
		
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='Search Location Code']")).sendKeys("AUTOMATIONTESTING");
		System.out.println("Location Code");
		Thread.sleep(5000);
		LocationName.sendKeys("Sudhakar recidency");
		System.out.println("Location Name");
		Thread.sleep(5000);
		Search.click();
	}
	
	public void LocationEdit() throws InterruptedException 
	{
		Thread.sleep(9000);
//		driver.findElement(By.xpath("//mat-row[2]//mat-cell[5]//div[1]//a[1]//*[name()='svg']//*[name()='path' and contains(@fill,'#0696e8')]")).click();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", PencilIcon);
		PencilIcon.click();
		Thread.sleep(2000);
		
		
		System.out.println("PencilIconClick");
		
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(Salutation_option));
//		clickableElement.click();
//		System.out.println(" saluation_Option click");
		
		Description.clear();
		Thread.sleep(2000);
		
		Description.sendKeys("Ganesh");
		Thread.sleep(5000);
		
		LocationUpdate.click();
		System.out.println("Location Update");
		
			
}

	public void LocationView() throws InterruptedException 
	{
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='Search Location Code']")).sendKeys("AUTOMATIONTESTING");
		System.out.println("Location Code");
		Thread.sleep(5000);
		System.out.println("Location click");
		LocationName.sendKeys("Sudhakar recidency");
		Thread.sleep(5000);
		Search.click();
		System.out.println("serach");
		Thread.sleep(5000);
		EyeIcon.click();
		System.out.println("eye");
//		Thread.sleep(9000);
//	//	Edit.click();
//	JavascriptExecutor js = (JavascriptExecutor) driver;
//    js.executeScript("arguments[0].click();", Edit);
//	//	Edit.click();
//		System.out.println("edite");
	Thread.sleep(5000);
		Address1.clear();
		Address1.sendKeys("LocationAddressUpdated");
		System.out.println("location update");
		Thread.sleep(5000);
		LocationUpdate.click();
		System.out.println("bjbdjbdjbdjbjdjdlocation");
}
	public void Deletelocation() throws InterruptedException 
	{
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='Search Location Code']")).sendKeys("AUTOMATIONTESTING");
		System.out.println("Location Code");
		Thread.sleep(5000);
		System.out.println("Location click");
		LocationName.sendKeys("Sudhakar recidency");
		Thread.sleep(5000);
		Search.click();
		System.out.println("serach");
		Thread.sleep(5000);
		 DeleteIcon.click();
		System.out.println(" DeleteIcon");
//		
	Thread.sleep(5000);
	DeleteButton.click();
	Thread.sleep(5000);
		System.out.println("bjbdjbdjbdjbjdjdlocation");
}
}