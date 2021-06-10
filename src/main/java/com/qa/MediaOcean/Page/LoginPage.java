package com.qa.MediaOcean.Page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.MediaOcean.base.BasePage;


public class LoginPage extends BasePage {

	WebDriver driver;
	WebDriverWait wait;
	
	// 1. locators - By
	By logIn = By.xpath("//a[text()='Log in']");
	By continer = By.xpath("//*[@id='formContainer']");
	By emailID = By.id("email");
	By password = By.id("password");
	By logInBtn = By.id("submit-button");
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
	}

	// page actions:
	
	public StackPage doLogin(String user,String pwd) {
		driver.findElement(logIn).click();
		//(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(continer));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(emailID).sendKeys(user);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(logInBtn).click();
		return new StackPage(driver);
		
	}
	
	

}
