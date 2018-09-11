package com.erp.oa.integrationtests;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.erp.oa.backend.notice.NoticeService;
import com.erp.oa.common.notice.CreateNoticeRequest;

import static org.junit.Assert.assertEquals;

public abstract class AbstractNoticesAndRolesIntegrationTest {

  @Autowired
  private NoticeService noticeService;

  @Test
  public void testCreateNoticesAndRoles() throws InterruptedException {
    CreateNoticeRequest request = new CreateNoticeRequest();
    request.setTitle("mytest");
    request.setContext("mytest_context");

    noticeService.createNoticeAndRole(request);
  }
}