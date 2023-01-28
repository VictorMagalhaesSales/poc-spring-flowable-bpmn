package org.poc.flowable;

import org.flowable.engine.*;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.engine.impl.persistence.entity.HistoricProcessInstanceEntityImpl;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    HistoryService historyService;

    public ProcessInstance startProcessInstance(String key) {
        return this.runtimeService.startProcessInstanceByKey(key);
    }

    public List<ProcessDefinition> listProcessDefinitions() {
        return repositoryService.createProcessDefinitionQuery().list();
    }

    public List<Task> listAllTasks() {
        return taskService.createTaskQuery().list();
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

    public List<HistoricProcessInstanceEntityImpl> listProcessHistory() {
        return this.historyService.createHistoricProcessInstanceQuery()
                .list()
                    .stream()
                    .map(hpi -> (HistoricProcessInstanceEntityImpl) hpi)
                    .collect(Collectors.toList());
    }

}
