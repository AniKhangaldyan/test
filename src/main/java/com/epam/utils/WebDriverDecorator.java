package com.epam.utils;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class WebDriverDecorator implements WebDriver {
	protected WebDriver webdriver;
	
	public WebDriverDecorator(WebDriver driver){
		this.webdriver = driver;
		
	}

	@Override
	public void get(String url) {
		Reporter.log("Url is: "+ url);
		webdriver.get(url);		
	}

	@Override
	public String getCurrentUrl() {
		  
		return webdriver.getCurrentUrl();
	}

	@Override
	public String getTitle() {
		Reporter.log("Title is: "+ webdriver.getTitle());
		return webdriver.getTitle();
	}

	@Override
	public List<WebElement> findElements(By by) {
		 
		return webdriver.findElements(by);
	}

	@Override
	public WebElement findElement(By by) {
		Reporter.log("Element located: "+ by.toString());
		return webdriver.findElement(by);
	}

	@Override
	public String getPageSource() {
		 
		return webdriver.getPageSource();
	}

	@Override
	public void close() {
		Reporter.log("Close:: ");
		webdriver.close();
		
	}   

	@Override
	public void quit() {
		Reporter.log("Quit:: ");
		webdriver.quit();
		
	}

	@Override
	public Set<String> getWindowHandles() {
		 
		return webdriver.getWindowHandles();
	}

	@Override
	public String getWindowHandle() {
		 
		return webdriver.getWindowHandle();
	}

	@Override
	public TargetLocator switchTo() {
		 
		return webdriver.switchTo();
	}

	@Override
	public Navigation navigate() {
		 
		return webdriver.navigate();
	}

	@Override
	public Options manage() {
		 
		return webdriver.manage();
	}
}
