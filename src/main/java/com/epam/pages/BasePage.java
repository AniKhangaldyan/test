package com.epam.pages;

import static com.codeborne.selenide.Selenide.$;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.codeborne.selenide.Condition;
import com.epam.utils.Driver;


public abstract class BasePage {

	protected WebDriver webdriver;
	protected WebDriverWait wait;
	String pageTitle;

	public BasePage(WebDriver webdriver, String pageTitle) throws InterruptedException {
		this.webdriver = webdriver;
		this.pageTitle = pageTitle;
		wait = new WebDriverWait(webdriver, 10);
		PageFactory.initElements(this.webdriver, this);
	}

  
	public String getPageTitle() {
		return pageTitle;
	}

	public void waitUntilTitleAppear() {	 
		wait.until(ExpectedConditions.titleContains(this.pageTitle));
	}

	/**
	 * Wait until element is appear
	 * 
	 * @param element WebElement
	 */
	public void waitUntilElementAppear(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}	
	
	/**
	 * Wait until element is appear
	 * 
	 * @param elementXpath
	 */
	public void waitUntilElementAppear(String elementXpath) {
		$(By.xpath(elementXpath)).waitUntil( Condition.appears, 10000);	
	}	
	

	/**
	 * Wait until element is disappear
	 * 
	 * @param
	 */
	public void waitUntilElementDisappear(By xpath) {
		 $(xpath).waitUntil( Condition.disappears, 10000);	

	}	

	/**
	 * Wait until list of elements are present
	 * 
	 * @param elements
	 */
	public void waitForElementsList(List<WebElement> elements) {
		wait = new WebDriverWait(webdriver, 3);
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}


	
	/**
	 * Check is element displayed
	 * @return true if element is displayed otherwise false
	 */
	public boolean isElementExists(WebElement element) {
		try {			 
			if ($(element).isDisplayed())
				return true;

			return false;
		} catch (Exception ex) {
			return false;
		}
	}
	
	/**
	 * Wait until element is clickable 
	 * @param element
	 */
	public void waitUntilElementClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitUntilElementVisible(WebElement element) {
		 
		$(element).shouldBe(Condition.visible) ;
	}
	
	public void refreshPage() {
		Driver.refresh();
		 
	}



}