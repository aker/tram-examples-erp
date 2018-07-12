package com.erp.workflow.test;

import com.erp.workflow.WorkflowMain;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WorkflowMain.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class WorkflowServerIntegrationTest {

    @Test
    public void whenLoadApplication_thenSuccess() {

    }
}
