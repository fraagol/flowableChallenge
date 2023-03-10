package com.mimacom.flowableexample;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.engine.test.Deployment;
import org.flowable.task.api.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class FlowableChallengeTests {

    @Autowired
    private RuntimeService runtimeService;

    @Test
    @Order(1)
    @Deployment(resources = "processes/Process_1.bpmn20.xml")
    void runProcess1() {
        ProcessInstance processInstance = createProcessInstance("process1");
        assertThat(processInstance).isNotNull();

        List<ProcessInstance> processInstances = listProcessInstances();
        assertThat(processInstances.size()).isEqualTo(1);

        Task task = getSingleActiveTask();
        assertThat(task).isNotNull();

        completeTask(task);

        processInstances = listProcessInstances();
        assertThat(processInstances.size()).isEqualTo(0);
        assertThat(countCompletedProcessInstances()).isEqualTo(1);
    }

    @Test
    @Order(2)
    @Deployment(resources = "/processes/Process_2.bpmn20.xml")
    void runProcess2() {
        ProcessInstance processInstance = createProcessInstance("process2");
        List<ProcessInstance> processInstances = listProcessInstances();

        assertThat(processInstances.size()).isEqualTo(1);
    }

    @Test
    @Order(3)
    @Deployment(resources = "/processes/Process_3.bpmn20.xml")
    void runProcess3() {
        ProcessInstance processInstance = createProcessInstance("process3");

        List<ProcessInstance> processInstances = listProcessInstances();

        assertThat(processInstances.size()).isEqualTo(1);

        Task task = getSingleActiveTask();

        assertThat(task).isNotNull();
    }


    private ProcessInstance createProcessInstance(String processDefinitionKey) {
        return null;
    }

    private List<ProcessInstance> listProcessInstances() {
        return null;
    }

    private Task getSingleActiveTask() {
        return null;
    }

    private void completeTask(Task task) {
    }

    private long countCompletedProcessInstances() {
        return -1;
    }
}
