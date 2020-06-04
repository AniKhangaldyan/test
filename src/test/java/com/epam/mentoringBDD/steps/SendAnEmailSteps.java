package com.epam.mentoringBDD.steps;

import org.testng.Assert;

import com.epam.businessObjects.User;
import com.epam.pages.LoginPage;
import com.epam.pages.MainPage;
import com.epam.pages.NewMailPage;
import com.epam.pages.SentPage;
import com.epam.utils.BaseTest;
import com.epam.utils.Driver;
import com.epam.utils.Utils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SendAnEmailSteps extends BaseTest{
	String userName;
	String password;
	String subject;
	String body;
	String address;
	MainPage mainPage;
	NewMailPage newMailPage;
	SentPage sentPage;
	LoginPage loginPage;
	User user;

	@Given("^user logins yandex$")
	public void user_logins_yandex() throws InterruptedException {
		userName = "ment.test";
		password = "mentoring12Test";
		user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		loginPage = new LoginPage(Driver.getDriver());
		loginPage.setUserName(user.getUserName());
		loginPage.setPassword(user.getPassword());
		loginPage.checkDontRemember();
		mainPage = loginPage.pressLoginButton();

	}

	@When("^creates an email$")
	public void creates_an_email() throws InterruptedException {
		subject = Utils.generateSubject();
		body = Utils.generateBody();
		newMailPage = mainPage.clickToComposeButton();
		newMailPage.setBody(body);
		newMailPage.setSubject(subject);
	}

	@And("^sent to user(\\d+)@test\\.am$")
	public void sent_to_user(String user) {
		newMailPage.setAddress(user);
		newMailPage.clickToSendButton();
	}

	@Then("^the email should be sent to user(\\d+)@test\\.am$")
	public void the_email_should_be_sent_to_user(String user) throws InterruptedException {
		newMailPage.clickToSendButton();
		sentPage = mainPage.clickToSent();
		sentPage.refreshPage();

		Assert.assertTrue(sentPage.findMailByAddress(user));
	}

}
