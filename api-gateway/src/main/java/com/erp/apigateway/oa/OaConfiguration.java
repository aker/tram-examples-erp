package com.erp.apigateway.oa;

import static org.springframework.cloud.gateway.handler.predicate.RoutePredicates.path;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.Routes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(OaDestinations.class)
public class OaConfiguration {

    @Bean
    public RouteLocator oaProxyRouting(OaDestinations ds) {
        return Routes.locator()
                .route("oaService")
                .uri(ds.getServiceUrl())
                .predicate(path("/notices").or(path("/noticesandroles")))
                .and()
                .build();
    }
}