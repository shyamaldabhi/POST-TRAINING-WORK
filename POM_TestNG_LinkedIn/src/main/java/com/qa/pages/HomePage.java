package com.qa.pages;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(id = "linkedin-logo")
	WebElement Logo;
	
	@FindBy(css= "*[data-tracking-control-name='homepage-basic_guest_nav_menu_jobs']")
	WebElement job;
	
	@FindBy(css = "*[aria-label='Search job titles or companies']")
	WebElement SearchJob;
	
	@FindBy(css = "*[aria-label='Location']")
	WebElement JobLocation;
	
	@FindBy(xpath = "(//form[@role='search']/button)[2]")
	WebElement SearchButton;
	

	
	public HomePage()  {
		
		PageFactory.initElements(driver, this);
	}
	public void logoIcon() {
		Logo.click();
	}
	public void jobIcon() {
	job.click();	
	}
	public void SearchJob() {
		SearchJob.sendKeys("Software Tester");
	}
	public void Location() {
		JobLocation.clear();
		JobLocation.sendKeys("Kitchener, Ontario, Canada");
	}
	public void clickSearchButton() {
		SearchButton.click();
	
	}
}
