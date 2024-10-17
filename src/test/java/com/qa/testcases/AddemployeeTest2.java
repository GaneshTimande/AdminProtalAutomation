package com.qa.testcases;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import com.qa.pages.Addemployee2;
import com.qa.pages.AddFunctionPage;
import com.qa.pages.AddFunctionRolePage;
import com.qa.pages.DashboardPage;
import com.qa.pages.LoginPage;
import com.qa.utilities.Base;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.testng.annotations.DataProvider;


import java.io.FileInputStream;
import java.io.IOException;

public class AddemployeeTest2 extends  Base {
	LoginPage loginpage;
	DashboardPage dashboardpage;
	AddFunctionPage addfunctionpage;
	AddFunctionRolePage dashboardfunctionrolepage;
	Addemployee2 addemployee2;
	
	public AddemployeeTest2()
	{
		super();
	}	
	
	  public WebDriver driver;
	    @BeforeClass
	    public void setup() throws InterruptedException 
	    {
	        
	    driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
	    loginpage = new LoginPage();
	    dashboardpage= loginpage.login(prop.getProperty("Email"), prop.getProperty("otp")); 
	   
	    }
	
	
	
	@Test(priority=1, enabled=true)
	public void validateEmployeePageUrlTest1() throws Exception
	{
		
		 addfunctionpage = new AddFunctionPage();
		
		 addemployee2 = new Addemployee2();
		String url = addemployee2.validateEmployeePageUrl();
		Assert.assertEquals(url, "https://preprod-web.vahanacloud.com/admin-portal-test/#/dashboard");
	}
	
	@Test(priority=2, enabled=true)
	public void addEmployeeTest1() throws Throwable
	{
		
		addemployee2.addEmployee();
	}
	@Test(priority=3,dataProvider = "employeeData", enabled=true)
	
    public void testAddEmployee1(String salutationValue, String firstNameValue, String middleNameValue, 
                                 String lastNameValue, String mobileNumberValue, String personalEmailValue, 
                                 String fatherHusbandNameValue, String addressLine1Value, String pinCodeValue, 
                                 String employeeCodeValue, String companyNameValue, String designationNameValue, 
                                 String officeEmailValue, String functionValue, String functionRoleValue, 
                                 String joiningDateValue) throws InterruptedException {
        
		addemployee2.employeeCard(salutationValue, firstNameValue, middleNameValue, 
                                      lastNameValue, mobileNumberValue, personalEmailValue, 
                                      fatherHusbandNameValue, addressLine1Value, pinCodeValue, 
                                      employeeCodeValue, companyNameValue, designationNameValue, 
                                      officeEmailValue, functionValue, functionRoleValue, 
                                      joiningDateValue);
    }
	
	  @DataProvider(name = "employeeData")
	    public Object[][] getEmployeeData() throws IOException {
	        String excelPath = "C:\\Users\\Test\\eclipse-workspace\\AdminPortal27Sept Demo\\src\\main\\java\\com\\qa\\testdata\\ADDemployee.xlsx"; // Update this path

	        FileInputStream file = new FileInputStream(excelPath);
	        XSSFWorkbook workbook = new XSSFWorkbook(file);
	        XSSFSheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet

	        int rowCount = sheet.getPhysicalNumberOfRows();
	        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

	        Object[][] data = new Object[rowCount - 1][colCount]; // Exclude header row

	        DataFormatter formatter = new DataFormatter();
	        for (int i = 1; i < rowCount; i++) { // Start from row 1 to skip header
	            for (int j = 0; j < colCount; j++) {
	                data[i - 1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));
	            }
	        }
	        workbook.close();
	        return data;
	    }
	
	
	 @AfterClass
	    public void tearDown() 
	    {
	        
	        driver.quit();
	        
	    }
}
