package com.erp.workflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class WorkflowMain extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(WorkflowMain.class, args);
    }

}