package com.qa.utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;

public class HighlightWebElementListener implements WebDriverEventListener {

    private void highlightElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Highlighting with yellow border and red background
        js.executeScript("arguments[0].style.border='3px solid yellow'", element);
        js.executeScript("arguments[0].style.backgroundColor='red'", element);
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        highlightElement(driver, element);
        System.out.println("Clicking on: " + element.toString());
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        highlightElement(driver, element);
        System.out.println("Changing value for: " + element.toString());
    }

    // Implement other methods from WebDriverEventListener (if necessary)
    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
    	 highlightElement(driver, element);
         System.out.println("Changing value for: " + element.toString());
    }
    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {}
    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {}
    @Override
    public void afterNavigateTo(String url, WebDriver driver) {}
    @Override
    public void beforeNavigateBack(WebDriver driver) {}
    @Override
    public void afterNavigateBack(WebDriver driver) {}
    @Override
    public void beforeNavigateForward(WebDriver driver) {}
    @Override
    public void afterNavigateForward(WebDriver driver) {}
    @Override
    public void beforeNavigateRefresh(WebDriver driver) {}
    @Override
    public void afterNavigateRefresh(WebDriver driver) {}
    @Override
    public void beforeFindBy(org.openqa.selenium.By by, WebElement element, WebDriver driver) {}
    @Override
    public void afterFindBy(org.openqa.selenium.By by, WebElement element, WebDriver driver) {}
    @Override
    public void onException(Throwable throwable, WebDriver driver) {}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
}