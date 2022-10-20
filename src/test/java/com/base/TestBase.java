package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.base.DriverManager;


public class TestBase {
	public static WebDriver driver;
	public static Properties Config;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static WebDriverWait wait;
	public SoftAssert softAssert = new SoftAssert();
	
	@BeforeClass(alwaysRun = true)  
	@Parameters({ "propertyfile"})
    public void setUp(@Optional("Configuration") String propertyfile) throws Exception { 
		FileInputStream fis;
		Config=new Properties();
		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\"+propertyfile+".properties");

			Config.load(fis);	
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();	
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	

	
		String browserName= Config.getProperty("browser");
		if (browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
			driver= new ChromeDriver();

            DriverManager.setDriver(driver);
            DriverManager.getDriver().manage().window().maximize();

            DriverManager.getDriver().manage().deleteAllCookies();

            DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Integer.parseInt
					(Config.getProperty("implicit.wait")), TimeUnit.SECONDS);

            DriverManager.getDriver().manage().timeouts().implicitlyWait(Integer.parseInt
					(Config.getProperty("implicit.wait")), TimeUnit.SECONDS);

            wait = new WebDriverWait(driver, 20); 
            System.out.println(Config.getProperty("testsiteurl"));
            DriverManager.getDriver().get(Config.getProperty("testsiteurl"));
            
            
		}

	}
	
	@AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) throws Exception {
        int i = result.getStatus();
        if (i == ITestResult.FAILURE || i == ITestResult.SKIP) {

        	
        driver.close();
        driver.quit();

        	driver = null;
        }
    }
   
  
    @AfterClass
    public void tearDown() throws Exception {
        try {

            //Quit all drivers
            if (driver != null) {
            	
            	   driver.close();
                   driver.quit();
                           }


        } catch (Exception e) {
            throw e;
        }

    }
	
	

}
