package com.erp.oa.backend.notice.sagas.createnoticeandrole;

import static io.eventuate.tram.commands.consumer.CommandWithDestinationBuilder.send;

import com.erp.ermp.common.role.commands.CreateRoleCommand;
import com.erp.oa.common.notice.commands.ApproveNoticeCommand;
import com.erp.oa.common.notice.commands.RejectNoticeCommand;

import io.eventuate.tram.commands.consumer.CommandWithDestination;
import io.eventuate.tram.sagas.orchestration.SagaDefinition;
import io.eventuate.tram.sagas.simpledsl.SimpleSaga;

public class CreateNoticeAndRoleSaga implements SimpleSaga<CreateNoticeAndRoleSagaData> {

    private SagaDefinition<CreateNoticeAndRoleSagaData> sagaDefinition =
        step()
            .withCompensation(this::reject)
        .step()
            .invokeParticipant(this::createRole)
        .step()
            .invokeParticipant(this::approve)
        .build();

    @Override
    public SagaDefinition<CreateNoticeAndRoleSagaData> getSagaDefinition() {
        return sagaDefinition;
    }

    private CommandWithDestination reject(CreateNoticeAndRoleSagaData data) {
        return send(new RejectNoticeCommand(data.getNoticeId()))
                .to("oaService")
                .build();
    }

    private CommandWithDestination createRole(CreateNoticeAndRoleSagaData data) {
        return send(new CreateRoleCommand(data.getCreateNoticeRequest().getTitle(), data.getCreateNoticeRequest().getContext()))
                .to("ermpService")
                .build();
    }

    private CommandWithDestination approve(CreateNoticeAndRoleSagaData data) {
        return send(new ApproveNoticeCommand(data.getNoticeId()))
                .to("oaService")
                .build();
    }
}