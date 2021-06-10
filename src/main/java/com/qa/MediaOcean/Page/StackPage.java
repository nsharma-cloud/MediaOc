package com.qa.MediaOcean.Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StackPage {
	WebDriver driver;
	WebDriverWait wait;

	By search = By.name("q");
	By result = By.xpath("//*[@class='question-hyperlink']");
	By more = By.xpath("//button[@class='s-btn s-btn__muted s-btn__outlined s-btn__sm s-btn__dropdown is-selected']");
	By vote = By.xpath("//a[@href='/questions/tagged/selenium?tab=Votes']");
	// By voteCount =
	// By.xpath("//*[@class='question-summary']//span[@class='vote-count-post
	// ']/strong");
	// By VoteAnscount =
	// By.xpath("//*[@class='question-summary']//div[@class='stats']//strong");

	public StackPage(WebDriver driver) {
		this.driver = driver;

	}

	public void searchSelTag() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(search).clear();
		driver.findElement(search).sendKeys("[Selenium]");
		driver.findElement(search).sendKeys(Keys.ENTER);

	}

	public void total15Result() throws InterruptedException {

		List<WebElement> list = driver.findElements(result);
		int i = list.size();
		System.out.println(i);
		Assert.assertEquals(i, 15);

	}

	public void sortByVote() throws InterruptedException {
		driver.findElement(more).click();
		driver.findElement(vote).click();
	}

	public void resultWithVoteAns(){
		try{List<WebElement> list = driver.findElements(result);
		for (int i = 0; i < list.size(); i++) {
			getVoteAnsDetails(driver, list.get(i).getText());
		}
		}catch(Exception e)
		{
			
			String error1=e.getMessage();
			System.out.println("error1:" + error1);
		}
	}

	public void getVoteAnsDetails(WebDriver driver, String title) {
		List<WebElement> Votenaslist = driver.findElements(By.xpath("//*[text()='" + title
				+ "']//parent::h3//parent::div//preceding-sibling::div//div[@class='stats']//strong"));
		System.out.println(title + "\t");
		for (int i = 0; i < Votenaslist.size(); i++) {
			System.out.println(Votenaslist.get(i).getText() + "\t");
		}
		
	}

	public void resultWithTags(){
		try{
			System.out.println("result");
		List<WebElement> list = driver.findElements(result);
		
		for (int i = 0; i < list.size(); i++) {
			getAllTag(driver, list.get(i).getText());
		}
		}
		catch(Exception e)
		{
			String error=e.getMessage();
			System.out.println("error1:" + error);
		}

	}

	public void getAllTag(WebDriver driver, String title) {
		List<WebElement> tagList = driver.findElements(By.xpath("//*[text()='" + title
				+ "']/following::div[@class='grid ai-start jc-space-between fw-wrap']/div[@class='grid gs4 fw-wrap t-python t-selenium t-selenium-webdriver t-webdriver t-automated-tests']/a"));
		System.out.println(title + "\t");
		for (int i = 0; i < tagList.size(); i++) {
			System.out.println(tagList.get(i).getText() + "\t");
		}
	}

	public void acceptedAnsVote() {
		List<WebElement> list = driver.findElements(result);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
			list.get(i).click();
			try{
				driver.findElement(By.xpath("//*[@aria-label='Accepted']/preceding-sibling::div[@itemprop='upvoteCount']")).getText();
			}
			catch(NoSuchElementException e)
			{
				e.printStackTrace();
				System.out.println("accpeted ans not there");
			}

		}

	}

}
