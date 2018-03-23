package cucumber.steps;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.GooglePage;

public class GooglePageTest extends GooglePage {
	

	@Before("~@test")
	public void setUp(){
		launchApp();
	
	}
	

	@When("^Search String Test$")
	public void search_String_Test() throws Throwable {

	}

	@Then("^returned result is more than (\\d+)$")
	public void returned_result_is_more_than(int arg1) throws Throwable {

	}

}
