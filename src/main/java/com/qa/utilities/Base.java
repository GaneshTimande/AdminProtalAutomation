package com.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.listeners.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.events.EventFiringWebDriver;
public class Base {
	
	public static WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	 EventFiringWebDriver eventDriver;
	   WebEventListener eventListener;
	
	
		
	public Base() {
		
		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\config\\config.properties");
		
		dataProp = new Properties();
		File dataPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\testdata\\testdata.properties");
		
		try {
			FileInputStream dataFis = new FileInputStream(dataPropFile);
			dataProp.load(dataFis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
	}
	
	public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) {
		
		
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}else if(browserName.equalsIgnoreCase("ie")) {
			driver = new InternetExplorerDriver();
		}else if(browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}
			
	//	WebDriverManager.chromedriver().setup();
//		ChromeOptions options =new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
//		options.addArguments("--disable notificatios");
//		DesiredCapabilities cp= new DesiredCapabilities();
//		cp.setCapability(ChromeOptions.CAPABILITY, options);
//		options.merge(cp);
//		

		
	/*
	 * if(browserName.equalsIgnoreCase("chrome")) {
	 * WebDriverManager.chromedriver().setup(); ChromeOptions options = new
	 * ChromeOptions(); options.addArguments("--incognito");
	 * options.addArguments("--disable-extensions"); driver = new
	 * ChromeDriver(options);
	 * 
	 * // ChromeOptions options = new ChromeOptions(); //
	 * options.addArguments("--incognito"); // DesiredCapabilities capabilities =
	 * new DesiredCapabilities(); //
	 * capabilities.setCapability(ChromeOptions.CAPABILITY, options); //
	 * options.merge(capabilities); // ChromeDriver driver = new
	 * ChromeDriver(options);
	 * 
	 * }else if(browserName.equalsIgnoreCase("edge")) {
	 * 
	 * driver = new EdgeDriver();
	 * 
	 * }else if(browserName.equalsIgnoreCase("safari")) {
	 * 
	 * driver = new SafariDriver();
	 * 
	 * }
	 */
//		e_driver = new EventFiringWebDriver(driver);
//		// Now create object of EventListerHandler to register it with EventFiringWebDriver
//		eventListener = new WebEventListener();
//		e_driver.register(eventListener);
//		driver = e_driver;
		
		eventDriver = new EventFiringWebDriver(driver);

        // Initialize WebEventListener
        eventListener = new WebEventListener(driver);

        // Register the event listener
        eventDriver.register(eventListener);

        // Use eventDriver instead of original driver in your tests
        driver = eventDriver;
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utilities.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utilities.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		
		return driver;
		
	}
	
	
	
	
	
}