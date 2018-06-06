package com.erp.ermp.web;

import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Configuration
@EnableJpaRepositories
@Import({SwaggerConfiguration.class})
public class ErmpWebConfiguration {

    @Bean
    public HttpMessageConverters customConverters() {
      HttpMessageConverter<?> additional = new MappingJackson2HttpMessageConverter();
      return new HttpMessageConverters(additional);
    }
}