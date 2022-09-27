package com.qa.testcases;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.testdata.ErrorMessagePage;
import com.qa.utilities.TestUtil;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest extends TestBase {	
		
	LoginPage LoginPage;
	ErrorMessagePage ErrorMessagePage;
	HomePage homePage;
	TestUtil TestUtil;
	
	public LoginTest(){
		super();
	}
	
		@BeforeMethod
		public void setUp() throws IOException {
			TestBase.Loginpage();
			LoginPage = new LoginPage();
			ErrorMessagePage = new ErrorMessagePage();
			homePage = new HomePage();
			TestUtil=new TestUtil();
	}
		@Test(priority=1)
		public void LoginPageTitleTest() {
			String title=LoginPage.LoginPagetitle(); 
			Assert.assertEquals(title, "LinkedIn Login, Sign in | LinkedIn");
		}
		@Test(priority=2)
		public void LinkedInPageLogo(){
			boolean flag = LoginPage.ValidateLoginPageLogo();
			Assert.assertTrue(flag);			
			
		}
		@Test(priority=3)
		public void loginTestSpecChar() {
			LoginPage.login(prop.getProperty("WrongEmailSpecCharacter"), prop.getProperty("Password"));
			Assert.assertEquals(LoginPage.readEmailErr(),ErrorMessagePage.SpecCharacErr);
		}
		@Test(priority=4)
		public void loginTestNoSpecChar() {
			LoginPage.login(prop.getProperty("WrongEmail"), prop.getProperty("Password"));
			Assert.assertEquals(LoginPage.readEmailErr(), ErrorMessagePage.NormalEmailErr);
		}
		@Test(priority=5)
		public void loginTestEmptyEmail() {
			LoginPage.login("", prop.getProperty("Password"));
			Assert.assertEquals(LoginPage.readEmailErr(), ErrorMessagePage.EmptyEmailErr);
		}
		
		@Test(priority= 6)
		public void NavigateToHomePage(){
			homePage.logoIcon();
			homePage.jobIcon();
			homePage.SearchJob();
			homePage.Location();
			homePage.clickSearchButton();
			TestUtil.ListSearchedJob();
		}
		
		@AfterMethod
		public void tearDown() {
		driver.quit();
}
}	
