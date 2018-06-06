package com.erp.oa.backend;

import com.erp.oa.backend.notice.NoticeService;
import com.erp.oa.backend.notice.sagas.createnoticeandrole.CreateNoticeAndRoleSaga;
import com.erp.oa.backend.notice.sagas.createnoticeandrole.CreateNoticeAndRoleSagaData;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.eventuate.tram.sagas.orchestration.Saga;
import io.eventuate.tram.sagas.orchestration.SagaManager;
import io.eventuate.tram.sagas.orchestration.SagaManagerImpl;

@Configuration
@EnableJpaRepositories
@EnableAutoConfiguration
public class OaBackendConfiguration {

    @Bean
    public NoticeService noticeService() {
        return new NoticeService();
    }

    @Bean
    public SagaManager<CreateNoticeAndRoleSagaData> createNoticeAndRoleSagaManager(Saga<CreateNoticeAndRoleSagaData> saga) {
        return new SagaManagerImpl<>(saga);
    }

    @Bean
    public CreateNoticeAndRoleSaga createNoticeAndRoleSaga() {
        return new CreateNoticeAndRoleSaga();
    }
}