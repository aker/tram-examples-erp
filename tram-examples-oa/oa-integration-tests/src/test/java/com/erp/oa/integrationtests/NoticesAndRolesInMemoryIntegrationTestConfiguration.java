package com.erp.oa.integrationtests;

import io.eventuate.tram.inmemory.TramInMemoryConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@Import({OaIntegrationCommonIntegrationTestConfiguration.class, TramInMemoryConfiguration.class})
public class NoticesAndRolesInMemoryIntegrationTestConfiguration {

  @Bean
  @Primary
  public DataSource dataSource() {
    EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
    return builder.setType(EmbeddedDatabaseType.H2).addScripts("eventuate-tram-embedded-schema.sql", "eventuate-tram-sagas-embedded.sql").build();
  }

}