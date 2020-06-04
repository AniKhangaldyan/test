package com.epam.mentoringBDD.steps;
import org.testng.Assert;
import com.epam.businessObjects.User;
import com.epam.pages.LoginPage;
import com.epam.pages.MainPage;
import com.epam.utils.BaseTest;
import com.epam.utils.Driver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class YandexLoginSteps extends BaseTest {
	String userName;
	String password;
	User user;
	LoginPage loginPage;
	MainPage mainPage; 
	
	@Given("^user navigates to yandex\\.com$")
	public void user_navigates_to_yandex_com() throws InterruptedException {
		userName = "ment.test";
		password = "mentoring12Test";
		user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		loginPage = new LoginPage(Driver.getDriver());

	}
	@When("^enters user credentials$")
	public void enters_user_credentials()   {
 

		loginPage.setUserName(user.getUserName());
		loginPage.setPassword(user.getPassword());
		loginPage.checkDontRemember();
		
		
	}
	
	@When("^submit login button$")
	public void submit_login_button() throws InterruptedException{
		
		mainPage = loginPage.pressLoginButton();
		 
		Assert.assertEquals(mainPage.getMailUserNameText(), userName);
	}
	
	@Then("^yandex home page is displayed$")
	public void yandex_home_page_is_displayed(){
		Assert.assertEquals(mainPage.getMailUserNameText(), userName);
		System.out.println("Login was completed correctly.");
	}
}
