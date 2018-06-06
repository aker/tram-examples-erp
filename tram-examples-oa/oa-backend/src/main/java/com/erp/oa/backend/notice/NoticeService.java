package com.erp.oa.backend.notice;

import java.util.Collections;

import com.erp.oa.backend.notice.sagas.createnoticeandrole.CreateNoticeAndRoleSagaData;
import com.erp.oa.common.notice.CreateNoticeRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.eventuate.tram.events.ResultWithEvents;
import io.eventuate.tram.sagas.orchestration.SagaManager;

@Service
@Transactional
public class NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    @Autowired
    private SagaManager<CreateNoticeAndRoleSagaData> createNoticeAndRoleSagaManager;

    public Notice create(CreateNoticeRequest noticeRequest) {
        Notice notice = new Notice(noticeRequest.getTitle(), noticeRequest.getContext());
        notice = noticeRepository.save(notice);

        return notice;
    }

    public Notice createNoticeAndRole(CreateNoticeRequest noticeRequest) {
        ResultWithEvents<Notice> ne = new ResultWithEvents<Notice>(new Notice(noticeRequest.getTitle(),noticeRequest.getContext()), Collections.emptyList());
        Notice notice = ne.result;
        noticeRepository.save(notice);

        CreateNoticeAndRoleSagaData data = new CreateNoticeAndRoleSagaData(notice.getId(),noticeRequest);
        createNoticeAndRoleSagaManager.create(data, Notice.class, notice.getId());
        
        return notice;
    }

	public void approve(long noticeId) {
        System.out.println("Service: approve notice:" + noticeId);
        Notice notice = noticeRepository.findOne(noticeId);

        if(notice == null) {
            throw new RuntimeException("Can not find Notice ID:" + noticeId);
        } else {
            notice.setState(NoticeState.APPROVED);
            noticeRepository.save(notice);
        }
	}

	public void reject(long noticeId) {
        Notice notice = noticeRepository.findOne(noticeId);
        if(notice == null) {
            throw new RuntimeException("Can not find Notice ID:" + noticeId);
        } else {
            notice.setState(NoticeState.REJECTED);
            noticeRepository.save(notice);
        }
	}
}