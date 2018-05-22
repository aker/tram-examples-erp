package com.erp.oa.notice.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/notices")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping(method = RequestMethod.POST)
    public CreateNoticeResponse create(@RequestBody CreateNoticeRequest cNoticeRequest) {
        Notice notice = noticeService.create(cNoticeRequest);
        return new CreateNoticeResponse(notice.getId());
    }

}