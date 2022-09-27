package com.qa.utilities;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.qa.base.TestBase;


public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT=10;
	

	public void ListSearchedJob() {
	
		List<WebElement> all = driver.findElements(By.xpath("//ul[@class='jobs-search__results-list']/li"));
		
		System.out.println(all.size());
		
		for(WebElement a:all) {
			System.out.println(a.getText());
}
	}


	public static void takeScreenshotAtEndOfTest() throws IOException {
		// TODO Auto-generated method stub
		//File screenShotFile = driver.getScreenshotAs(OutputType.FILE); //This isfor firefox, chrome driver or any class
		File scrnFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //this line is for WebDriver
		String currentDir =System.getProperty("user.dir");
		
		FileUtils.copyFile(scrnFile, new File(currentDir+"/screenshots/"+System.currentTimeMillis()+".png")); // under project
		//FileUtils.copyFile(scrnFile, new File("C:\\testing\\screenshot.png")); // Save in Computer
	}

	}