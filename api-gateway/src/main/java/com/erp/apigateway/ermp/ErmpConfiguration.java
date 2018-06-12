package com.erp.apigateway.ermp;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.Routes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.cloud.gateway.handler.predicate.RoutePredicates.path;

import org.springframework.boot.context.properties.EnableConfigurationProperties;

@Configuration
@EnableConfigurationProperties(ErmpDestinations.class)
public class ErmpConfiguration {

    @Bean
    public RouteLocator ermpProxyRouting(ErmpDestinations ds) {

        return Routes.locator()
                .route("ermpService")
                .uri(ds.getServiceUrl())
                .predicate(path("/roles"))
                .and()
                .build();
    }

}