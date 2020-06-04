package com.epam.pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy; 

public class NewMailPage extends BasePage {

	public NewMailPage(WebDriver webdriver) throws InterruptedException {
		super(webdriver, "Yandex.Mail");
	}

	@FindBy(xpath = "//div[@class='mail-Compose-Field-Input']/div[@name='to']") 
	private WebElement toTextBox;

	@FindBy(xpath = "//input[@name='subj']")
	private WebElement subjectTextBox;

	@FindBy(xpath = "//div[@class='cke_inner cke_reset']//div[@role='textbox']")
	private WebElement bodyTextBox;

	@FindBy(xpath = "//button[@class=' nb-button _nb-small-action-button _init nb-with-s-right-gap js-resolve' and .//span[text()='Save and go']]")
	private WebElement saveAndGoButton;

	@FindBy(xpath = "//div[@class='mail-Compose-From']//button[@title='Send message (Ctrl + Enter)']")
	private WebElement sendButton;
	
	private By xpath = By.xpath("//div[@class='mail-Compose-From']//button[@title='Send message (Ctrl + Enter)']");

	/**
	 * Set address to "To" field
	 * 
	 * @param adress
	 */
	public void setAddress(String address) {
		$(toTextBox).sendKeys(address);
	}

	/**
	 * Set text to mail body
	 * 
	 * @param text
	 */
	public void setBody(String text) {
		$(bodyTextBox).sendKeys(text);
	}

	/**
	 * Set subject of the mail
	 * 
	 * @param text
	 */
	public void setSubject(String text) {
		$(subjectTextBox).sendKeys(text);
	}

	/**
	 * Get text from subjectTextBox
	 * 
	 * @return subjectTextBox text
	 */
	public String getSubject() {
		return $(subjectTextBox).getText();
	}

	public void clickToSaveAndGo() {
		$(saveAndGoButton).click();
			 
	}

	public void clickToSendButton() {
		 
		$(sendButton).click(); 
		waitUntilElementDisappear(xpath);

	}

}
