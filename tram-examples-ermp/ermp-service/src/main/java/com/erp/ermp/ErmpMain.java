package com.erp.ermp;

import com.erp.ermp.web.ErmpWebConfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableAutoConfiguration
@Import({ErmpWebConfiguration.class, ErmpBackendConfiguration.class, ErmpCommandConfiguration.class})
@ComponentScan
public class ErmpMain {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ErmpMain.class, args);
    }
}