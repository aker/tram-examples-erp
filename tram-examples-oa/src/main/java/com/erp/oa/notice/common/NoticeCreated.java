package com.erp.oa.notice.common;

import io.eventuate.tram.events.common.DomainEvent;

public class NoticeCreated implements DomainEvent {
    private String title;
    private String context;

    public NoticeCreated() {}

    public NoticeCreated(String title, String context) {
        this.title = title;
        this.context = context;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}