package com.qa.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    
    private int retryCount = 0; // number of times to retry
    private static final int maxRetryCount = 3; // maximum number of retries

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++; // increment retry count
            return true; // retry the test
        }
        return false; // do not retry
    }
}