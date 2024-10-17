package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utilities.Base;


public class LoginPage extends Base {

    @FindBy(xpath = "//input[@formcontrolname='email']")
    private WebElement userEmail;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement getOtpBtn;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement userOtp;

    @FindBy(xpath = "//button[contains(@class,'btn-login')]")
    private WebElement submitBtn;

    // Initializing the Page Objects:
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    // Actions:
    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public String validateLoginPageUrl() {
        return driver.getCurrentUrl();
    }

    public DashboardPage login(String email, String otp) throws InterruptedException {
        Thread.sleep(5000);
        
//        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        jsExecutor.executeScript(
//            "arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", userEmail);
        
        userEmail.sendKeys(email);
        Thread.sleep(2000);
        getOtpBtn.click();
        Thread.sleep(5000);

        userOtp.sendKeys(otp);
        Thread.sleep(5000);
        submitBtn.click();
        Thread.sleep(5000);

        return new DashboardPage();
    }
}