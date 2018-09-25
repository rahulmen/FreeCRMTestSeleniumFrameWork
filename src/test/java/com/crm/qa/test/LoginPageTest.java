package com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage login;
	
	@BeforeTest
	public void initliaze(){
	login = new LoginPage();
	}
	
	
	@Test(priority=1)
	public void validateTitleTest(){
		Assert.assertEquals(login.getLoginPageTitle(),"#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test(priority=2)
		public void validatePageLogoTest(){
		Assert.assertTrue(login.validateCrmLogo());
	}
	
	@Test(priority=3)
	public void loginTest(){
		login.login("rahulmen","rahulmen");
	}
	
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
	
	
}
