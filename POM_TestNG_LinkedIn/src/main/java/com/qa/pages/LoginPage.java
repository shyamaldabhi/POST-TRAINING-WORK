package com.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.TestBase;

public class LoginPage extends TestBase {

	
	@FindBy(id = "username")
    WebElement Email;
	
	@FindBy(id = "password")
    WebElement password;
	
	@FindBy(css = "*[aria-label='Sign in']")
    WebElement signInButton;
	
	@FindBy(id = "error-for-username")
    WebElement emailErr;
	
	@FindBy(id = "linkedin-logo")
    WebElement LinkedInLogo;
		
public LoginPage()  {

	PageFactory.initElements(driver, this);
}
public void login(String a,String b) {
	Email.sendKeys(a);
	password.sendKeys(b);
	signInButton.click();
	
}
public String LoginPagetitle() {
	return driver.getTitle();	
}
public boolean ValidateLoginPageLogo() {
	return LinkedInLogo.isDisplayed();
}
public String readEmailErr() {
	return emailErr.getText();
}
	public HomePage NavigateToHomePage() {
		return new HomePage();
	}
}

