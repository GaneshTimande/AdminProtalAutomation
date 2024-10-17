package com.qa.listeners;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.By;

public class WebEventListener implements WebDriverEventListener {

    WebDriver driver;

    public WebEventListener(WebDriver driver) {
        this.driver = driver;
    }

    // Method to highlight an element
    private void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String originalStyle = element.getAttribute("style");
        js.executeScript("arguments[0].setAttribute('style', 'border: 3px solid red; background-color: yellow;');", element);
        try {
            Thread.sleep(2000); // pause for visualization, adjust as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        js.executeScript("arguments[0].setAttribute('style', '" + originalStyle + "');", element);
    }

    // Before clicking on an element
    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        highlightElement(element);
    }

    // Before finding an element
    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
//        if (element != null) {
//            highlightElement(element);
//        }
    }

    // Before changing the value of an element
    public void beforeChangeValueOf(WebElement element, WebDriver driver) {
      // highlightElement(element);
    }

    // Implement other methods if needed (optional)
    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
    	//highlightElement(element);
    }
    
    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
    	highlightElement(element);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {}

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {}

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {}

    @Override
    public void afterNavigateBack(WebDriver driver) {}

    @Override
    public void beforeNavigateBack(WebDriver driver) {}

    @Override
    public void afterNavigateForward(WebDriver driver) {}

    @Override
    public void beforeNavigateForward(WebDriver driver) {}

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {}

    @Override
    public void afterNavigateRefresh(WebDriver driver) {}

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
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
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