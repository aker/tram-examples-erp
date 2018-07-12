package com.erp.workflow.live;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ClientCredentialsTest {
    public final static String AUTH_SERVER = "http://localhost:8081";
    public final static String RESOURCE_SERVER = "http://localhost:8083";


    @Test
    public void givenUser_whenUseCredentialsClient_thenOkForFooResourceOnly() {
        final String accessToken = obtainAccessToken("test-client-credentials-id", "john", "123");

        assertTrue("AccessToke is empty", StringUtils.isNotBlank(accessToken));

        final Response fooResponse = RestAssured.given().header("Authorization", "Bearer " + accessToken).get(RESOURCE_SERVER + "/foos/1");
        assertEquals(200, fooResponse.getStatusCode());
        assertNotNull(fooResponse.jsonPath().get("name"));

        final Response barResponse = RestAssured.given().header("Authorization", "Bearer " + accessToken).get(RESOURCE_SERVER + "/bars/1");
        assertEquals(403, barResponse.getStatusCode());
    }

    private String obtainAccessToken(String clientId, String username, String password) {
        final String authorizeUrl = AUTH_SERVER + "/oauth/token";

        // get access token
        final Map<String, String> params = new HashMap<String, String>();
        params.put("grant_type", "client_credentials");
        Response response = RestAssured.given().auth().preemptive().basic(clientId, "secret")
                            .and().with().params(params).post(authorizeUrl);

        return response.jsonPath().getString("access_token");
    }
}