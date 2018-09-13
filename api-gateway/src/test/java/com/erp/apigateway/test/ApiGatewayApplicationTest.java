package com.erp.apigateway.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.erp.apigateway.ApiGatewayApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.client.WebClient;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiGatewayApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)
public class ApiGatewayApplicationTest {

	@Test
	public void testHealth() {
		WebClient client = WebClient.create("http://localhost:8080/health");

		ResponseEntity<String> z = client
			.get()
			.exchange()
			.flatMap(r -> r.toEntity(String.class))
			.block();

		assertNotNull(z);
		assertEquals(HttpStatus.OK, z.getStatusCode());
	}
}