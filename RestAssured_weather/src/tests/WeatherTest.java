package tests;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import main.api.WeatherAPI;
import main.helper.ConfigHelper;

public class WeatherTest {
	WeatherAPI weatherAPI = new WeatherAPI();

	@Test
	public void getStateCode() {

		RestAssured.baseURI = ConfigHelper.readPropertyValue("weatherURL");
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.queryParam("lon", ConfigHelper.readPropertyValue("lon"));
		httpRequest.queryParam("lat", ConfigHelper.readPropertyValue("lat"));
		httpRequest.queryParam("key", ConfigHelper.readPropertyValue("APIkey"));
		Response response = httpRequest.get(WeatherAPI.CURRENT);
		JsonPath jsonPathEvaluator = response.jsonPath();
		System.out.println("State Code :  " + jsonPathEvaluator.get("data.state_code"));
		Assert.assertEquals(response.getStatusCode(), 200, " The status code is valid");

	}

	@Test
	public void getForecast() {

		RestAssured.baseURI = ConfigHelper.readPropertyValue("weatherURL");
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.queryParam("postal_code", ConfigHelper.readPropertyValue("postal_code"));
		httpRequest.queryParam("key", ConfigHelper.readPropertyValue("APIkey"));
		Response response = httpRequest.get(WeatherAPI.FORECAST);
		JsonPath jsonPathEvaluator = response.jsonPath();
		System.out.println("TimeStampUTC :  " + jsonPathEvaluator.get("data.timestamp_utc"));
		System.out.println("TimeStampUTC :  " + jsonPathEvaluator.get("data.weather"));
		Assert.assertEquals(response.getStatusCode(), 200, " The status code is valid");
	}

}
