package com.erp.apigateway;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class ApiGatewayApplicationConfiguration {

    @Bean
    public NettyReactiveWebServerFactory NettyReactiveWebServerFactory() {
        return new NettyReactiveWebServerFactory();
    }
}