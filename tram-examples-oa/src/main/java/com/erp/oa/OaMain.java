package com.erp.oa;

import com.erp.oa.notice.command.NoticeConfiguration;
import com.erp.oa.notice.common.SwaggerConfiguration;
import com.erp.oa.notice.view.NoticeViewConfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableAutoConfiguration
@Import({NoticeConfiguration.class, NoticeViewConfiguration.class, SwaggerConfiguration.class})
@ComponentScan
public class OaMain {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(OaMain.class, args);
    }
}