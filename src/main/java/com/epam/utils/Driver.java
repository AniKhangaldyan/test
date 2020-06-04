package com.epam.utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

public class Driver  {
	private static WebDriver webdriver;
	static WebDriverCreator creator;
	
	

	public static void initialize(String browser) {
		if (webdriver == null) {
			switch (browser) {
			case "CH":
				creator = new ChromeDriverCreator();
				webdriver = creator.factoryMethod();
				break;
			case "IE":
				creator= new IEDriverCreator();
				webdriver = creator.factoryMethod();
				break;
			case "FF":
				creator = new FFDriverCreator();
				webdriver = creator.factoryMethod();
				break;
			default:
				creator = new ChromeDriverCreator();
				webdriver = creator.factoryMethod();
				break;
			}
		}
		webdriver.manage().window().maximize();		 
		webdriver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 

	}
	
	public static void cleanDriver(){
		webdriver.quit();
		webdriver = null;
    }
	
	public static void openUrl(String url){
		 
		webdriver.get(url);
	}
	
	public static WebDriver getDriver(){
		
		return webdriver;
		
	}

	public static void refresh(){
		webdriver.navigate().refresh();
	}





}