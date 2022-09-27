package TrelloBatch65;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_GET_Request {
	
	@Test
	void getBoardCreated() {
		
		//Specify base uri
		RestAssured.baseURI = "https://api.trello.com/";
		
		//Request object
		RequestSpecification httprequest = RestAssured.given();
		
		//ResponseObject
		Response response = httprequest.request(Method.GET,"//1/boards/id=632b638b3a46b00187b1f965?key=55afbf011733b2e24b1967c3ee5a84a9&token=fa7f6c761f87dfc841363f0db3f6b279fe3afcadb24b9bd7c23219e8f5b11a4a");
		
		//print response in console
		String responseBody = response.getBody().asString();
		System.out.println("Response Body Is: "+responseBody);
		
		//status code verification
		int statusCode = response.getStatusCode();
		System.out.println("Status Code is: "+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//Status line Verification
		String statusLine = response.getStatusLine();
		System.out.println("Staus Line is: "+statusLine);
		
		//Capture Header
		String contentType = response.header("Content-Type");
		System.out.println("Content-Type is: "+contentType);
		Assert.assertEquals(contentType,"text/html; charset=utf-8");
		
	}

}
