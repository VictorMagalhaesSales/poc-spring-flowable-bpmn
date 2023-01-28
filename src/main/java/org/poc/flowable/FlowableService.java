package org.poc.flowable;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowableService {

    @Autowired
    ProcessEngine processEngine;

    @Autowired
    TaskService taskService;

    @Autowired
    RepositoryService repositoryService;

    @Autowired
    RuntimeService runtimeService;

    public ProcessInstance startProcessInstance(String key) {
        return this.runtimeService.startProcessInstanceByKey(key);
    }

    public List<Task> listTasksByStartedProcessId(String processInstanceId) {
        return this.taskService.createTaskQuery().processInstanceBusinessKey(processInstanceId).list();
    }

    public void claimTaskById(String taskId, String userId) {
        this.taskService.claim(taskId, userId);
    }

    public void completeTaskById(String taskId) {
        this.taskService.complete(taskId);
    }



}
