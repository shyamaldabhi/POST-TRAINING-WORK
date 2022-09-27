package TrelloBatch65;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_POST_Request {

	@Test
	void getBoardCreated() {
		
		//Specify base uri
		RestAssured.baseURI = "https://api.trello.com/";
		
		//Request object
		RequestSpecification httprequest = RestAssured.given();
		
		//RequestPayload sending along with post request
		JSONObject requestparams = new JSONObject();
		requestparams.put("name", "Automation");
		requestparams.put("idBoard", "632b638b3a46b00187b1f965");
		httprequest.header("Content-Type","application/json");
		httprequest.body(requestparams.toJSONString());
		
		//ResponseObject
				Response response = httprequest.request(Method.POST,"/1/boards/?key=55afbf011733b2e24b1967c3ee5a84a9&token=fa7f6c761f87dfc841363f0db3f6b279fe3afcadb24b9bd7c23219e8f5b11a4a");
		
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
		
	}

}


