package com.erp.oa.handler;

import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withFailure;
import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withSuccess;

import com.erp.oa.backend.notice.NoticeService;
import com.erp.oa.common.notice.commands.ApproveNoticeCommand;
import com.erp.oa.common.notice.commands.RejectNoticeCommand;

import org.springframework.beans.factory.annotation.Autowired;

import io.eventuate.tram.commands.consumer.CommandHandlers;
import io.eventuate.tram.commands.consumer.CommandMessage;
import io.eventuate.tram.messaging.common.Message;
import io.eventuate.tram.sagas.participant.SagaCommandHandlersBuilder;

public class NoticeCommandHandler {

    @Autowired
    private NoticeService noticeService;

	public CommandHandlers commandHandlerDefinitions() {
        return SagaCommandHandlersBuilder
                .fromChannel("oaService")
                .onMessage(ApproveNoticeCommand.class, this::approveNotice)
                .onMessage(RejectNoticeCommand.class, this::rejectNotice)
                .build();
    }
    
    public Message approveNotice(CommandMessage<ApproveNoticeCommand> cm) {
        ApproveNoticeCommand cmd = cm.getCommand();
        System.out.println("Handler: approve notice:" + cmd.getNoticeId());

        try {
            noticeService.approve(cmd.getNoticeId());

            return withSuccess();
        } catch (Exception ex) {
            return withFailure();
        }
    }

    public Message rejectNotice(CommandMessage<RejectNoticeCommand> cm) {
        RejectNoticeCommand cmd = cm.getCommand();
        System.out.println("Handler: approve notice:" + cmd.getNoticeId());

        try {
            noticeService.reject(cmd.getNoticeId());

            return withSuccess();
        } catch (Exception ex) {
            return withFailure();
        }
    }

}