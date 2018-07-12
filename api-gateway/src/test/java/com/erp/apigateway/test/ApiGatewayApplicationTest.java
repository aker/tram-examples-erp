package com.erp.apigateway.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.client.WebClient;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiGatewayApplicationConfiguration.class,
	webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiGatewayApplicationTest {
	@LocalServerPort
	private int port;

	@Test
	public void testHealth() {
		WebClient client = WebClient.create("http://localhost:" + port + "/health");

		ResponseEntity<String> z = client
			.get()
			.exchange()
			.flatMap(r -> r.toEntity(String.class))
			.block();

		assertNotNull(z);
		assertEquals(HttpStatus.OK, z.getStatusCode());
	}

	@Test
	public void test() {
		assertTrue(true);
	}
}