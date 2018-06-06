package com.erp.ermp.handler;

import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withFailure;
import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withSuccess;

import com.erp.ermp.backend.role.RoleService;
import com.erp.ermp.common.role.commands.CreateRoleCommand;
import com.erp.ermp.common.role.domain.CreateRoleRequest;
import com.erp.ermp.common.role.events.RoleCreated;
import com.erp.ermp.common.role.replies.RoleCreateFailed;

import org.springframework.beans.factory.annotation.Autowired;

import io.eventuate.tram.commands.consumer.CommandHandlers;
import io.eventuate.tram.commands.consumer.CommandMessage;
import io.eventuate.tram.messaging.common.Message;
import io.eventuate.tram.sagas.participant.SagaCommandHandlersBuilder;

public class RoleCommandHandler {

    @Autowired
    private RoleService roleService;

    public CommandHandlers commandHandlerDefinitions() {
        return SagaCommandHandlersBuilder
                .fromChannel("ermpService")
                .onMessage(CreateRoleCommand.class, this::createRole)
                .build();
    }

    public Message createRole(CommandMessage<CreateRoleCommand> cr) {
        System.out.println("Handler: create role");
        
        CreateRoleCommand cmd = cr.getCommand();
        try {
            roleService.create(new CreateRoleRequest(cmd.getCode(), cmd.getName()));

            return withSuccess(new RoleCreated());
        } catch (Exception ex) {
            return withFailure(new RoleCreateFailed());
        }
    }
}