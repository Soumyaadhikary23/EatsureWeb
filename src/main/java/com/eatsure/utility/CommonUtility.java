package com.eatsure.utility;

import static io.restassured.RestAssured.given;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CommonUtility {

	public String requesturlResponse;
	public synchronized String otp_api_call(String hiturl)  {
        String get_otp_api = hiturl;

        Response response = given().when().get(get_otp_api).then().extract().response();

        String otp_responseString = response.asString();

        JsonPath js = new JsonPath(otp_responseString);

        if (hiturl.contains("9494227881")) {
            int number_opt = js.getInt("otp");
            requesturlResponse = Integer.toString(number_opt);
            System.out.println("otp value-->" + requesturlResponse);

        } else {
            requesturlResponse = js.getString("message");
            System.out.println("Server response message" + requesturlResponse);

        }

        return requesturlResponse;
    }

}
