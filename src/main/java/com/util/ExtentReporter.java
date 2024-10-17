package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

    public static ExtentReports generateExtentReport() {

        ExtentReports extentReport = new ExtentReports();

        // Use File.separator for OS-independent paths
        File extentReportFile = new File(System.getProperty("user.dir") + File.separator + "test-output" + File.separator + "ExtentReports" + File.separator + "extentReport.html");

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("Admin Test Automation Results Report");
        sparkReporter.config().setDocumentTitle("TN Automation Report");
        sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");

        extentReport.attachReporter(sparkReporter);

        // Load properties file
        Properties configProp = new Properties();
        File configPropFile = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "com" + File.separator + "qa" + File.separator + "config" + File.separator + "config.properties");

        // Use try-with-resources for automatic resource management
        try (FileInputStream fisConfigProp = new FileInputStream(configPropFile)) {
            configProp.load(fisConfigProp);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Set system information in the Extent Report
        extentReport.setSystemInfo("Application URL", configProp.getProperty("url", "Not specified"));
        extentReport.setSystemInfo("Browser Name", configProp.getProperty("browserName", "Not specified"));
        extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
        extentReport.setSystemInfo("Username", System.getProperty("user.name"));
        extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));

        return extentReport;
    }
}