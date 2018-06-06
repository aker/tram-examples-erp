package com.erp.oa.common.notice.commands;

import io.eventuate.tram.commands.common.Command;

public class RejectNoticeCommand implements Command {

    private long noticeId;

    public RejectNoticeCommand() {

    }
    
    public RejectNoticeCommand(long noticeId) {
        this.noticeId = noticeId;
    }

    public long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(long noticeId) {
        this.noticeId = noticeId;
    }
}