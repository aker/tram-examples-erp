package com.erp.oa.notice.view;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import io.eventuate.tram.consumer.kafka.TramConsumerKafkaConfiguration;
import io.eventuate.tram.events.subscriber.DomainEventDispatcher;
import io.eventuate.tram.messaging.consumer.MessageConsumer;

@Configuration
@Import({TramConsumerKafkaConfiguration.class})
public class NoticeViewConfiguration {

    @Bean
    public NoticeEventConsumer noticeEventConsumer() {
        return new NoticeEventConsumer();
    }

    @Bean
    public DomainEventDispatcher domainEventDispatcher(NoticeEventConsumer noticeEventConsumer, MessageConsumer messageConsumer) {
        return new DomainEventDispatcher("noticeServiceEvents", noticeEventConsumer.domainEventHandlers(), messageConsumer);
    }
}