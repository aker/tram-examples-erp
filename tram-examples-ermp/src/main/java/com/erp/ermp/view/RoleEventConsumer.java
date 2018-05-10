package com.erp.ermp.view;

import com.erp.ermp.command.Role;
import com.erp.ermp.common.RoleCreated;

import io.eventuate.tram.events.subscriber.DomainEventHandlers;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;

public class RoleEventConsumer {
    public DomainEventHandlers domainEventHandlers() {
        return DomainEventHandlersBuilder
                .forAggregateType(Role.class.getName())
                .onEvent(RoleCreated.class, dee -> System.out.println("GET Role Event"))
                .build();
    }
}