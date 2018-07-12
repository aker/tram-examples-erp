package com.erp.apigateway.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import com.erp.apigateway.ApiGatewayApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.response.Response;

//Before running this test make sure authorization server is running   

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiGatewayApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class AuthenticationClaimsIntegrationTest {

    @LocalServerPort
    private int port;

    @Test
    public void whenTokenDontContainIssuer_thenSuccess() {
        final String tokenValue = obtainAccessToken("fooClientIdPassword", "john", "123");
        
        final Response fooResponse = RestAssured.given().header("Authorization", "Bearer " + tokenValue).get("http://localhost:" + port +"/foos/1");
        assertEquals(200, fooResponse.getStatusCode());
        assertNotNull(fooResponse.jsonPath().get("name"));
    }

    private String obtainAccessToken(String clientId, String username, String password) {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("grant_type", "password");
        params.put("client_id", clientId);
        params.put("username", username);
        params.put("password", password);
        final Response response = RestAssured.given().auth().preemptive().basic(clientId, "secret").and().with().params(params).when().post("http://localhost:" + port +"/oauth/token");
        return response.jsonPath().getString("access_token");
    }

}
