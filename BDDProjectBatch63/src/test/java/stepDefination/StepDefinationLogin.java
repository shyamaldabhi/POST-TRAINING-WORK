package stepDefination;

import org.junit.Assert;

import org.openqa.selenium.WebDriver;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Login_Page;

public class StepDefinationLogin {
	Login_Page lp = new Login_Page();
	WebDriver driver;
	
	@Given("^user is already on Login Page$")
	public void user_is_already_on_Login_Page() throws Throwable {
		lp.openBrowser();
		lp.openLoginPage();
	}

	@When("^title of login page is \"([^\"]*)\"$")
	public void title_of_login_page_is(String title) throws Throwable {
		String expectedErr = title;
		Assert.assertEquals(lp.title(),expectedErr);
	}

	@Then("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String a, String b) throws Throwable {
		lp.login(a,b);
	}

	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button() throws Throwable {
		lp.click();
	}

	@Then("^user get error for email$")
	public void user_get_error_for_email() throws Throwable {
		String expectedErr = "Couldn’t find a LinkedIn account associated with this email. Please try again.";
		Assert.assertEquals(lp.readEmailErr(), expectedErr);
	}

	@Then("^user quit$")
	public void user_quit() throws Throwable {
		lp.CloseBrowser();
	}


}
