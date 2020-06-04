package com.epam.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass; 
import org.testng.annotations.BeforeClass; 
import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
 
@CucumberOptions(strict = true, plugin = { "json:target/cucumber-report.json",
"html:target/cucumber-report" }, tags = "@testTag", features = "src/test/resources/features", glue = {
		"com.epam.mentoringDesignPatternsTask.steps" })

public class BaseTest extends AbstractTestNGCucumberTests {
	protected static Logger logger;

	@BeforeClass()
	public void setup() {
		Driver.initialize("CH");
		Configuration.baseUrl = "https://mail.yandex.ru";		
		Driver.openUrl("https://mail.yandex.ru/");
		logger = LoggerFactory.getLogger(this.getClass().getName());
		logger.info(" \n \n*** TEST STARTS ***\n ");

	}

	@AfterClass
	public void finish() {

		logger.info(" \n \n*** TEST END ***\n ");
		Driver.cleanDriver();

	}
}
