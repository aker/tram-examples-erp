package com.erp.ermp.backend;

import com.erp.ermp.backend.role.RoleService;

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