package com.erp.apigateway.live;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.http.MediaType;

//Before running this live test make sure both authorization server and first resource server are running   

public class PasswordFlowLiveTest {
    private String host = "http://localhost:8080";

    @Test
    public void givenUser_whenUseFooClient_thenOkForFooResourceOnly() {
        final String accessToken = obtainAccessToken("fooClientIdPassword", "john", "123");

        final Response fooResponse = RestAssured.given().header("Authorization", "Bearer " + accessToken).get(host + "/foos/1");
        assertEquals(200, fooResponse.getStatusCode());
        assertNotNull(fooResponse.jsonPath().get("name"));

        final Response barResponse = RestAssured.given().header("Authorization", "Bearer " + accessToken).get(host + "/bars/1");
        assertEquals(403, barResponse.getStatusCode());
    }

    @Test
    public void givenUser_whenUseBarClient_thenOkForBarResourceReadOnly() {
        final String accessToken = obtainAccessToken("barClientIdPassword", "john", "123");

        final Response fooResponse = RestAssured.given().header("Authorization", "Bearer " + accessToken).get(host +"/foos/1");
        assertEquals(403, fooResponse.getStatusCode());

        final Response barReadResponse = RestAssured.given().header("Authorization", "Bearer " + accessToken).get(host + "/bars/1");
        assertEquals(200, barReadResponse.getStatusCode());
        assertNotNull(barReadResponse.jsonPath().get("name"));

        final Response barWritResponse = RestAssured.given().contentType(MediaType.APPLICATION_JSON_VALUE).header("Authorization", "Bearer " + accessToken).body("{\"id\":1,\"name\":\"MyBar\"}").post(host + "/bars");
        assertEquals(403, barWritResponse.getStatusCode());
    }

    @Test
    public void givenAdmin_whenUseBarClient_thenOkForBarResourceReadWrite() {
        final String accessToken = obtainAccessToken("barClientIdPassword", "tom", "111");

        final Response fooResponse = RestAssured.given().header("Authorization", "Bearer " + accessToken).get(host + "/foos/1");
        assertEquals(403, fooResponse.getStatusCode());

        final Response barResponse = RestAssured.given().header("Authorization", "Bearer " + accessToken).get(host + "/bars/1");
        assertEquals(200, barResponse.getStatusCode());
        assertNotNull(barResponse.jsonPath().get("name"));

        final Response barWritResponse = RestAssured.given().contentType(MediaType.APPLICATION_JSON_VALUE).header("Authorization", "Bearer " + accessToken).body("{\"id\":1,\"name\":\"MyBar\"}").post(host + "/bars");
        assertEquals(201, barWritResponse.getStatusCode());
        assertEquals("MyBar", barWritResponse.jsonPath().get("name"));
    }

    //

    private String obtainAccessToken(String clientId, String username, String password) {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("grant_type", "password");
        params.put("client_id", clientId);
        params.put("username", username);
        params.put("password", password);
        final Response response = RestAssured.given().auth().preemptive().basic(clientId, "secret").and().with().params(params).when().post(host + "/oauth/token");
        return response.jsonPath().getString("access_token");
    }

}
