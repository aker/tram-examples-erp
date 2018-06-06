package com.erp.oa.backend.notice.sagas.createnoticeandrole;

import com.erp.oa.common.notice.CreateNoticeRequest;

public class CreateNoticeAndRoleSagaData {

    private Long noticeId;
    private CreateNoticeRequest createNoticeRequest;

    public CreateNoticeAndRoleSagaData() {}
    
    public CreateNoticeAndRoleSagaData(Long noticeId, CreateNoticeRequest noticeRequest) {
        this.noticeId = noticeId;
        this.createNoticeRequest = noticeRequest;
    }

    public Long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(long noticeId) {
        this.noticeId = noticeId;
    }

    public CreateNoticeRequest getCreateNoticeRequest() {
        return createNoticeRequest;
    }

    public void setCreateNoticeRequest(CreateNoticeRequest request) {
        this.createNoticeRequest = request;
    }
}