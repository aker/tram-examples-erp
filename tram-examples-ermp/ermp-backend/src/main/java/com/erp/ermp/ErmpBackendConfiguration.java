package com.erp.ermp;

import com.erp.ermp.service.RoleService;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories
@EnableAutoConfiguration
public class ErmpBackendConfiguration {

    @Bean
    public RoleService roleService() {
        return new RoleService();
    }
}