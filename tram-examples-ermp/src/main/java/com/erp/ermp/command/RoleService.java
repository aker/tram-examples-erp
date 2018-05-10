package com.erp.ermp.command;

import static java.util.Arrays.asList;

import com.erp.ermp.common.RoleCreated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.eventuate.tram.events.common.DomainEvent;
import io.eventuate.tram.events.publisher.DomainEventPublisher;

@Service
@Transactional
public class RoleService {

    @Autowired
    private RoleRespository roleRespository;

    @Autowired
    private DomainEventPublisher domainEventPublisher;

    public Role create(CreateRoleRequest cRoleRequest) {
        Role role = new Role(cRoleRequest.getCode(), cRoleRequest.getName());
        role = roleRespository.save(role);

        publishRoleEvent(role, new RoleCreated(role.getCode(), role.getName()));

        return role;
    }

    private void publishRoleEvent(Role role, DomainEvent... domainEvents) {
        domainEventPublisher.publish(Role.class, role.getId(), asList(domainEvents));
    }
}