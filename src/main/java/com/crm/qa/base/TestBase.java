package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.util.TestUtil;


public class TestBase{

	public static WebDriver driver;
	public static Properties prop;

	/*
	 * Constructor to load Property FIle from com.crm.qa.config package
	 */
	public TestBase(){

		try{
			prop = new Properties();
			FileInputStream file = new FileInputStream("C:\\Users\\RXM05IL\\workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(file);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	
		
	}
	
	
	/*
	 * Method to initialize Browser
	 */
		public static void initialize(){
			
			String browserName = prop.getProperty("browser");
			
			switch(browserName){
			case "chrome" : {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\709003\\workspace\\BrowserExes\\chromedriver_win32_2.41\\chromedriver.exe");
				driver = new ChromeDriver();
				break;
			}
			case "gecko" : {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\709003\\workspace\\BrowserExes\\geckodriver-v0.22.0-win64");
				driver = new FirefoxDriver();
				break;
			}
			case "ie" : {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\709003\\workspace\\BrowserExes\\chromedriver_win32");
				driver = new InternetExplorerDriver();
				break;
			}
			default : System.err.println("There is no such browser availaible");	
			}
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.page_timeout, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
			}
		
		/*
		 * Method to define Explicit Wait
		 */
			
		
		public static WebDriverWait explicitWait()
		{
			return new WebDriverWait(driver,10);
		}


		
		
		
		
		
	}









