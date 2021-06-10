package com.qa.MediaOcean.tests;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.MediaOcean.Page.LoginPage;
import com.qa.MediaOcean.Page.StackPage;
import com.qa.MediaOcean.base.BasePage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic - 101 : create login page features")
@Feature("US - 501 : create test for login page on hubspot")
public class LoginPageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	
	Logger log = Logger.getLogger(LoginPageTest.class);

	@BeforeTest(alwaysRun=true)
	@Parameters(value={"browser"})
	public void setUp(String browser) throws InterruptedException {
		String browserName = null;
		basePage = new BasePage();
		prop = basePage.init_properties();
				
		
		if(browser.equals(null) || browser.equals("") || browser.isEmpty()){
			 browserName = prop.getProperty("browser");
		}else{
			browserName = browser;
		}
		
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		log.info("url is launched : " + prop.getProperty("url"));
		Thread.sleep(10000);
		loginPage = new LoginPage(driver);
		
	}

	
	
	@Test(priority = 1, enabled=false)
	@Description("verify Login Test....")
	@Severity(SeverityLevel.BLOCKER)
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	
	}
	
	
	
	@AfterTest(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}

}
