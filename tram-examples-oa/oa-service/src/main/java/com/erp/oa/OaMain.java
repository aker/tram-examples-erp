package com.erp.oa;

import com.erp.oa.backend.OaBackendConfiguration;
import com.erp.oa.handler.OaHandlerConfiguration;
import com.erp.oa.web.OaWebConfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableAutoConfiguration
@Import({OaWebConfiguration.class, OaBackendConfiguration.class, OaHandlerConfiguration.class})
@ComponentScan
public class OaMain {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(OaMain.class, args);
    }
}