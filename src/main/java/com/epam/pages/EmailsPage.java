package com.epam.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import static com.codeborne.selenide.Selenide.$;

public abstract class EmailsPage extends BasePage {

	public EmailsPage(WebDriver webdriver, String pageTitle) throws InterruptedException {
		super(webdriver, pageTitle);
		 
	}

	@FindAll(@FindBy(xpath = "//div[@class='ns-view-container-desc mail-MessagesList js-messages-list']//span[@class='mail-MessageSnippet-Item mail-MessageSnippet-Item_subject']"))
	private List<WebElement> mailsSubjectsList;

	@FindAll(@FindBy(xpath = "//div[@class='ns-view-container-desc mail-MessagesList js-messages-list']//span[@class='mail-MessageSnippet-Item mail-MessageSnippet-Item_firstline js-message-snippet-firstline']"))
	private List<WebElement> mailsBodyList;

	@FindAll(@FindBy(xpath = "//div[@class='ns-view-container-desc mail-MessagesList js-messages-list']//span[@class='mail-MessageSnippet-FromText']"))
	private List<WebElement> mailsAddressList;

	@FindAll(@FindBy(xpath = "//div[@class='ns-view-container-desc mail-MessagesList js-messages-list']//div[@class='mail-MessageSnippet-Content']"))
	private List<WebElement> mailsList;
	
	@FindBy(xpath = "//a[@class='mail-Toolbar-Item mail-Toolbar-Item_top js-toolbar-button-top']")
	private static WebElement scrollUp;
	
	@FindBy(xpath = "//button[@class=' nb-button _nb-large-pseudo-button mail-MessagesPager-button js-message-load-more']")
	private static WebElement moreButton;
	
	@FindBy(xpath ="//div[contains(., 'There are no messages in “Drafts”.')]")
	private static WebElement noDraftMailText;
  

	/**
	 * Find mail by subject
	 * 
	 * @param address
	 * @return true if found
	 */
	public boolean findMailBySubject(String subject) {

		for (int i = 0; i < mailsSubjectsList.size(); i++) {

			if (mailsSubjectsList.get(i).getText().equals(subject)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Find mail by address
	 * 
	 * @param address
	 * @return true if found
	 */
	public boolean findMailByAddress(String address) {

		String actualAddress;
		for (int i = 0; i < mailsAddressList.size(); i++) {

			actualAddress = mailsAddressList.get(i).getText();

			if (actualAddress.indexOf("@") != -1
					&& actualAddress.substring(0, actualAddress.indexOf("@")).equals(address)) {
				return true;
			}

			else if (actualAddress.equals(address))
				return true;
		}
		return false;
	}

	/**
	 * Find mail by body
	 * 
	 * @param address
	 * @return true if found
	 */
	public boolean findMailByBody(String body) {

		for (int i = 0; i < mailsBodyList.size(); i++) {

			if (mailsBodyList.get(i).getText().equals(body)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Find mail by subject and open an email
	 * 
	 * @param address
	 * @return true if found
	 */
	public void findMailBySubjectAndOpen(String subject) {

		for (int i = 0; i < mailsSubjectsList.size(); i++) {

			if (mailsSubjectsList.get(i).getText().equals(subject)) {
				mailsSubjectsList.get(i).click();
				break;
			}
		}

	}

	/**
	 * Get mails count
	 * 
	 * @return int number of drafts
	 */
	public int getMailsCount() {

		try {
			if (isElementExists(moreButton)) {
				$(moreButton).click();
				scrollUp();				
			}
			
			
			waitForElementsList(mailsList);
			return mailsList.size();
		} catch (Exception ex) {
			return 0;
		}

	}
	public static void scrollUp(){		
		$(scrollUp).click();
	}

}