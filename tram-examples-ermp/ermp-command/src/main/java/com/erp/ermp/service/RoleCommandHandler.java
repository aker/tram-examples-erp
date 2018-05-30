package com.erp.ermp.service;

import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withFailure;
import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withSuccess;

import com.erp.ermp.api.replies.RoleNameUpdateFailed;
import com.erp.ermp.api.replies.RoleNameUpdated;
import com.erp.ermp.api.commands.UpdateRoleNameCommand;

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
                .onMessage(UpdateRoleNameCommand.class, this::updateRoleName)
                .build();
    }

    public Message updateRoleName(CommandMessage<UpdateRoleNameCommand> cm) {
        UpdateRoleNameCommand cmd = cm.getCommand();
        try {
            roleService.updateName(cmd.getRoleId(), cmd.getRoleName());

            return withSuccess(new RoleNameUpdated());
        } catch (Exception e) {
            return withFailure(new RoleNameUpdateFailed());
        }
    }
}