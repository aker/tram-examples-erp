package com.erp.ermp;

import com.erp.ermp.service.RoleCommandHandler;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import io.eventuate.jdbckafka.TramJdbcKafkaConfiguration;
import io.eventuate.tram.commands.common.ChannelMapping;
import io.eventuate.tram.commands.common.DefaultChannelMapping;
import io.eventuate.tram.commands.consumer.CommandDispatcher;
import io.eventuate.tram.commands.producer.TramCommandProducerConfiguration;
import io.eventuate.tram.events.publisher.TramEventsPublisherConfiguration;
import io.eventuate.tram.sagas.orchestration.SagaOrchestratorConfiguration;
import io.eventuate.tram.sagas.participant.SagaCommandDispatcher;
import io.eventuate.tram.sagas.participant.SagaLockManager;
import io.eventuate.tram.sagas.participant.SagaParticipantConfiguration;

@Configuration
@Import({SagaParticipantConfiguration.class,
        TramEventsPublisherConfiguration.class,
        TramCommandProducerConfiguration.class,
        SagaOrchestratorConfiguration.class,
        TramJdbcKafkaConfiguration.class})
@EnableAutoConfiguration
public class ErmpCommandConfiguration {

    @Bean
    public ChannelMapping channelMapping() {
        return DefaultChannelMapping.builder().build();
    }

    @Bean
    public RoleCommandHandler roleCommandHandler() {
        return new RoleCommandHandler();
    }

    @Bean
    public CommandDispatcher consumCommandDispatcher(RoleCommandHandler  target, SagaLockManager sagaLockManager) {
        return new SagaCommandDispatcher("ermpCommandDispatcher", target.commandHandlerDefinitions());
    }
}