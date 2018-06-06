package com.erp.oa.common.notice;

public class CreateNoticeRequest {
    private String title;
    private String context;

    public CreateNoticeRequest() {}

    public CreateNoticeRequest(String title, String context) {
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