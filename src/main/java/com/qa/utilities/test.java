package com.qa.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class test {
	public static WebDriver driver;
	public static void main(String[] args) {
	
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");  
		//	WebDriverManager.chromedriver().setup();
		//	driver = new ChromeDriver();
		//		driver.manage().window().maximize();
		//	WebDriverManager.firefoxdriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setBinary("D:\\Selenium jar\\chrome-win64 (1)\\chrome-win64\\chrome.exe");
		//options.addArguments("--incognito");
		//	options.addArguments("--disable-extensions");
		//	options.addArguments("--remote-allow-origins=*");
		 driver = new ChromeDriver(options);
		 driver.manage().window().maximize();
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--disable-extensions");
//		driver = new ChromeDriver(options);
	}

}
