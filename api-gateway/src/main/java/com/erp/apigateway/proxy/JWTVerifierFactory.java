package com.erp.apigateway.proxy;

import com.auth0.jwk.JwkException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JWTVerifierFactory {

    @Bean
    @Qualifier("jwk")
    public JWTVerifier create() throws JwkException, IOException {

        Algorithm algorithm = Algorithm.HMAC256("123");

        return JWT.require(algorithm).build();
    }
}
