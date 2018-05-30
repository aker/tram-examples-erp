package com.erp.ermp.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories
@Import({SwaggerConfiguration.class})
public class ErmpWebConfiguration {

}