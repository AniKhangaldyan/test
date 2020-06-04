package com.epam.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverCreator extends WebDriverCreator {

	@Override
	public WebDriver factoryMethod() {
		System.setProperty("webdriver.chrome.driver", "src/main/java/com/epam/resources/chromedriver.exe");
		webDriver = new ChromeDriver();
		
		webDriver = new WebDriverDecorator(webDriver);
		return webDriver;
	}

}
