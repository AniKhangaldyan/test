package com.epam.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FFDriverCreator extends WebDriverCreator{

	@Override
	public WebDriver factoryMethod() {
		webDriver = new FirefoxDriver();
		webDriver = new WebDriverDecorator(webDriver);
		return webDriver;
	}

}
