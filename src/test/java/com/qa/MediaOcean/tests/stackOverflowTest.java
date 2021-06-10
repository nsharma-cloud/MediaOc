package com.qa.MediaOcean.tests;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.MediaOcean.Page.LoginPage;
import com.qa.MediaOcean.Page.StackPage;
import com.qa.MediaOcean.base.BasePage;


import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class stackOverflowTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	StackPage stackPage;
	LoginPage loginPage;
	
	@BeforeMethod(alwaysRun=true)
	public void setUp() throws InterruptedException {
		basePage = new BasePage();
		prop = basePage.init_properties();
		
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		String user=prop.getProperty("username");
		stackPage=loginPage.doLogin(user,prop.getProperty("password"));
		
	}

	
	@Test
	public void searchSelenium() throws InterruptedException {
		stackPage.searchSelTag();
		stackPage.total15Result();
		stackPage.sortByVote();
		stackPage.resultWithVoteAns();
		stackPage.resultWithTags();
		stackPage.acceptedAnsVote();
	}
	

	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}


}
