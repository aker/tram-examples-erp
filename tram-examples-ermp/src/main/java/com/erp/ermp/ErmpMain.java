package com.erp.ermp;

import com.erp.ermp.command.RoleCommandConfiguration;
import com.erp.ermp.common.SwaggerConfiguration;
import com.erp.ermp.view.RoleViewConfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableAutoConfiguration
@Import({RoleCommandConfiguration.class, RoleViewConfiguration.class, SwaggerConfiguration.class})
@ComponentScan
public class ErmpMain {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ErmpMain.class, args);
    }
}