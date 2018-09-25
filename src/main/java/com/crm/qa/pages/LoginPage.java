package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{


	/*
	 * This class constructor to load property file and initilize the browser with all necessary capabilities and to load the page factory WebElement
	 */
	public LoginPage(){
		super();
		initialize();
		PageFactory.initElements(driver, this);
	}

	/*
	 * Defining PageFactory
	 */
	@FindBy(name = "username")
	WebElement username;

	By submit = By.xpath("//div[@class='input-group-btn']/input");

	public WebElement submit(){
		return driver.findElement(submit);
	}

	@FindBy(xpath="//font[contains(text(),'Sign Up')]")
	WebElement signUp;

	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crlLogo;

	By loginPassword = By.name("password");

	public WebElement LoginPassword(){
		return driver.findElement(loginPassword);
	}

	/*
	 * Defining Page Methods
	 */

	public void login(String un,String pwd){

		username.sendKeys(un);
		LoginPassword().sendKeys(pwd);
		submit().submit();
	}


	/*
	 * Method to check if CRMLogo is displayed or not
	 */
	public boolean validateCrmLogo(){
		return crlLogo.isDisplayed();
	}

	/*
	 * Method to Validate PageTitle
	 */
	
	public String getLoginPageTitle(){
		return driver.getTitle();
	}





}