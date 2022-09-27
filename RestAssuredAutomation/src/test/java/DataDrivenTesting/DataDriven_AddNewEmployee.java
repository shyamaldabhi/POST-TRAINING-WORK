package DataDrivenTesting;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.Xls_Reader;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDriven_AddNewEmployee {

	@Test(dataProvider = "employeedata")
	void AddEmployeeData(String ename,String esalary,String eage) {
		
		//Specify base uri
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		
		//Request object
		RequestSpecification httprequest = RestAssured.given();
		
		//RequestPayload sending along with post request
				JSONObject requestparams = new JSONObject();
				requestparams.put("name", ename);
				requestparams.put("salary",esalary);
				requestparams.put("age",eage);
				
				httprequest.header("Content-Type","application/json");
				httprequest.body(requestparams.toJSONString());
		
		//ResponseObject
		Response response = httprequest.request(Method.POST,"/create");
		
		//print response in console
		String responseBody = response.getBody().asString();
		System.out.println("Response Body Is: "+responseBody);
		//Assert.assertEquals(responseBody.contains(ename), true);
		//Assert.assertEquals(responseBody.contains(esalary), true);
		//Assert.assertEquals(responseBody.contains(eage), true);
		
		//status code verification
		int statusCode = response.getStatusCode();
		System.out.println("Status Code is: "+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//Status line Verification
		String statusLine = response.getStatusLine();
		System.out.println("Staus Line is: "+statusLine);
		
		
	}
	@DataProvider(name= "employeedata")
	String[][] getEmpData() 
	{
		Xls_Reader d = new Xls_Reader("C:\\testing\\SamyTest.xlsx");
		
		int r = d.getRowCount("Sheet1");
		int c = d.getColumnCount("Sheet1");
		System.out.println(r);
		System.out.println(c);
		String empdata[][] = new String[r][c];
		for(int i=1;i<=r;i++) {
			for(int j=0;j<c;j++) {
				empdata[i-1][j] = d.getCellData("Sheet1", j, i);
			}
		}
		return empdata;
	//String empdata[][] = {{"sonika","10000","32"},{"ramila","10000","25"},{"Ramesh","23000","29"}};	
	
	}
	
	}


