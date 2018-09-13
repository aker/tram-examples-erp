package com.erp.auth;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import com.erp.auth.AuthorizationServerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuthorizationServerApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)
public class AuthServerIntegrationTest {

    public final static String AUTH_SERVER = "http://localhost:8181";

    @Test
    public void whenLoadApplication_thenSuccess() {
        final String accessToken = obtainAccessToken("fooClientIdPassword", "john", "123");
        assertNotNull(accessToken);
    }

    private String obtainAccessToken(String clientId, String username, String password) {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("grant_type", "password");
        params.put("client_id", clientId);
        params.put("username", username);
        params.put("password", password);
        final Response response = RestAssured.given().auth().preemptive().basic(clientId, "secret").and().with().params(params).when().post( AUTH_SERVER + "/oauth/token");
        return response.jsonPath().getString("access_token");
    }
}
