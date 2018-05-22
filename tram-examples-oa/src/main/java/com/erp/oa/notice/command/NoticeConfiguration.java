package com.erp.oa.notice.command;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.eventuate.tram.events.publisher.TramEventsPublisherConfiguration;
import io.eventuate.tram.messaging.producer.jdbc.TramMessageProducerJdbcConfiguration;

@Configuration
@EnableJpaRepositories
@Import({TramEventsPublisherConfiguration.class, TramMessageProducerJdbcConfiguration.class})
public class NoticeConfiguration {

}