package com.erp.oa.web;

import com.erp.oa.backend.notice.Notice;
import com.erp.oa.backend.notice.NoticeService;
import com.erp.oa.common.notice.CreateNoticeRequest;
import com.erp.oa.common.notice.CreateNoticeResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping(path = "/notices", method = RequestMethod.POST)
    public CreateNoticeResponse create(@RequestBody CreateNoticeRequest cNoticeRequest) {
        Notice notice = noticeService.create(cNoticeRequest);
        return new CreateNoticeResponse(notice.getId());
    }

    @RequestMapping(path = "/noticesandroles", method = RequestMethod.POST)
    public CreateNoticeResponse createNoticeAndRole(@RequestBody CreateNoticeRequest request) {
        Notice notice = noticeService.createNoticeAndRole(request);

        return new CreateNoticeResponse(notice.getId());
    }
}