package com.qa.testdata;

import com.qa.utilities.Xls_Reader;

public class ErrorMessagePage {

	Xls_Reader d = new Xls_Reader("C:\\Selenium_WorkSpace\\POM_TestNG_LinkedIn\\src\\main\\java\\com\\qa\\testdata\\POMTest.xlsx");

	public String SpecCharacErr= d.getCellData("Sheet1","SpecCharacErr", 2);
	public String NormalEmailErr = d.getCellData("Sheet1","NormalEmailErr",2);
	public String EmptyEmailErr= d.getCellData("Sheet1","EmptyEmailErr", 2);
}
