package com.erp.oa.notice.command;

import static java.util.Arrays.asList;

import com.erp.oa.notice.common.NoticeCreated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.eventuate.tram.events.common.DomainEvent;
import io.eventuate.tram.events.publisher.DomainEventPublisher;

@Service
@Transactional
public class NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    @Autowired
    private DomainEventPublisher domainEventPublisher;

    public Notice create(CreateNoticeRequest noticeRequest) {
        Notice notice = new Notice(noticeRequest.getTitle(), noticeRequest.getContext());
        notice = noticeRepository.save(notice);

        publishNoticeEvent(notice, new NoticeCreated(notice.getTitle(), notice.getContext()));

        return notice;
    }

    private void publishNoticeEvent(Notice notice, DomainEvent... domainEvents) {
        domainEventPublisher.publish(Notice.class, notice.getId(), asList(domainEvents));
    }

}