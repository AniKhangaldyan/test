package com.epam.utils;

import org.openqa.selenium.WebDriver;

public abstract class WebDriverCreator {
	protected WebDriver webDriver;
	
	public abstract WebDriver factoryMethod();

}
