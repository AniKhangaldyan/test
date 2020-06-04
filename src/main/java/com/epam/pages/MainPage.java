package com.epam.pages;

import static com.codeborne.selenide.Selenide.$;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

	public MainPage(WebDriver webdriver) throws InterruptedException {
		super(webdriver, "Main");

	}
	
	String mailUserNameTextXpath = "//div[@class='mail-User-Name']";

	@FindBy(xpath = "//a[text()='Log out']")
	private WebElement logOutButton;

	String composeBtnxpath = "//a[@title='Compose (w, c)' and span[@class='mail-ComposeButton-Text']]";
	 
	@FindBy(xpath = "//span[@class='mail-NestedList-Item-Name js-folders-item-name' and contains(text(), 'Drafts')]")  
	private WebElement draftsButton;

	@FindBy(xpath = "//span[text()='Sent']")
	private WebElement sentButton;

	public String getMailUserNameText() {
		
		waitUntilElementAppear(mailUserNameTextXpath);
		return $(By.xpath(mailUserNameTextXpath)).getText();
	}

	/**
	 * Click to Compose button by Selenide
	 * @return
	 * @throws InterruptedException
	 */
	public NewMailPage clickToComposeButton() throws InterruptedException {
		waitUntilElementAppear(composeBtnxpath);
		$(By.xpath(composeBtnxpath)).click();	 
		return new NewMailPage(webdriver);
	}

	public DraftsPage clickToDrafts() throws InterruptedException {

		waitUntilElementVisible(draftsButton);
		clickToElement(draftsButton);
		return new DraftsPage(webdriver);
	}

	public void clickToElement(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public SentPage clickToSent() throws InterruptedException {
		sentButton.click();
		return new SentPage(webdriver);
	}

	public void clickToUserName() {
		$(By.xpath(mailUserNameTextXpath)).click();
	}

	public void clickToLogOut() {
		clickToUserName();
		logOutButton.click();
	}
}
