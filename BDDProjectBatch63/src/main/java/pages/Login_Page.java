package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

		WebDriver driver;
		
		@FindBy(id = "username")
	    public WebElement Email;
		
		@FindBy(id = "password")
	    public WebElement password;
		
		@FindBy(css = "*[aria-label='Sign in']")
	    public WebElement signInButton;
		
		@FindBy(id = "error-for-username")
	    public WebElement emailErr;
			
	public void openBrowser()  {
		System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
		driver = new FirefoxDriver();

		PageFactory.initElements(driver, this);
	}
	public void openLoginPage() {
		driver.get("https://www.linkedin.com/login");
	}
	
	public  void click() {
		signInButton.click();
	}
	public String title() {
		String actualErr = driver.getTitle();
		System.out.println(actualErr);
		return actualErr;
	}
	public void login(String email, String pass) {
		Email.sendKeys(email);
		password.sendKeys(pass);
		
	}
	public String readEmailErr() {
		String actualErr = emailErr.getText(); 
		System.out.println(actualErr);
		return actualErr;
	}
	public void CloseBrowser() {
		driver.quit();
	}
	}


