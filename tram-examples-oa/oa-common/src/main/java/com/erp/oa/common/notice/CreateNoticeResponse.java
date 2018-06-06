package com.erp.oa.common.notice;

public class CreateNoticeResponse {
    private Long id;

    public CreateNoticeResponse() {}

    public CreateNoticeResponse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}