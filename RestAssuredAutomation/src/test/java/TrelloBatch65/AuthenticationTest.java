package TrelloBatch65;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthenticationTest {

	@Test
	void gitAuthorization() {
		
		//Specify base uri
		RestAssured.baseURI = "https://api.github.com";
		
		//Request Authorization\
		PreemptiveBasicAuthScheme authscheme = new PreemptiveBasicAuthScheme();
		authscheme.setUserName("shyamaldabhi");
		authscheme.setPassword("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");
		RestAssured.authentication = authscheme;
		
		//Request response
		RequestSpecification httprequest = RestAssured.given();
		
		//ResponseObject
		Response response = httprequest.request(Method.GET,"/user");
				
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
