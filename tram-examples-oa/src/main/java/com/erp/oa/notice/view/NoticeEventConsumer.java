package com.erp.oa.notice.view;

import com.erp.oa.notice.command.Notice;
import com.erp.oa.notice.common.NoticeCreated;

import io.eventuate.tram.events.subscriber.DomainEventHandlers;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;

public class NoticeEventConsumer {
    public DomainEventHandlers domainEventHandlers() {
        return DomainEventHandlersBuilder
                .forAggregateType(Notice.class.getName())
                .onEvent(NoticeCreated.class, dee -> System.out.println("Get Notice Event"))
                .build();
    }
}