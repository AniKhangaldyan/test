package com.epam.pages;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
 

public class LoginPage extends BasePage {

	public LoginPage(WebDriver webdriver) throws InterruptedException {
		super(webdriver, "Yandex.Mail — a free email service");
	}

	String loginButtonXpath= "//span[@class='new-auth-submit new-auth-form-line__item']/button";
	
	@FindBy(xpath = "//div[@class='new-auth-form-line']//input[@class='_nb-input-controller' and @name='login']")
	private WebElement usernameTextBox;

	@FindBy(xpath = "//div[@class='new-auth-form-line']/label[@type='password']//input[@class='_nb-input-controller' and @name='passwd']")
	private WebElement passwordTextBox;

	String dontRememberCheckboxXpath="//span[@class='_nb-checkbox-flag _nb-checkbox-normal-flag']";

	public void setUserName(String username) {
		$(By.name("login")).sendKeys(username);
	}

	public void setPassword(String password) {
		$(By.name("passwd")).sendKeys(password);
	}

	public void checkDontRemember() {
		$(By.xpath(dontRememberCheckboxXpath)).click();		
	}

	/**
	 * Finds Log In button and presses it
	 * 
	 * @return Main Page
	 * @throws InterruptedException
	 */
	public MainPage pressLoginButton() throws InterruptedException {		
		$(By.xpath(loginButtonXpath)).click();				
			return new MainPage(webdriver);
	}

}
