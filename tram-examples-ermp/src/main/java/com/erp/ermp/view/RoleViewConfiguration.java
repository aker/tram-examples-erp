package com.erp.ermp.view;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import io.eventuate.tram.consumer.kafka.TramConsumerKafkaConfiguration;
import io.eventuate.tram.events.subscriber.DomainEventDispatcher;
import io.eventuate.tram.messaging.consumer.MessageConsumer;

@Configuration
@Import({TramConsumerKafkaConfiguration.class})
public class RoleViewConfiguration {

    @Bean
    public RoleEventConsumer roleEventConsumer() {
        return new RoleEventConsumer();
    }

    @Bean
    public DomainEventDispatcher domainEventDispatcher(RoleEventConsumer roleEventConsumer, MessageConsumer messageConsumer) {
        return new DomainEventDispatcher("roleServiceEvents", roleEventConsumer.domainEventHandlers(), messageConsumer);
    }
}