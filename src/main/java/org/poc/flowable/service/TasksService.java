package org.poc.flowable.service;

import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TasksService {

    @Autowired
    TaskService taskService;

    public void claimTaskById(String taskId, String userId) {
        this.taskService.claim(taskId, userId);
    }

    public void completeTaskById(String taskId) {
        this.taskService.complete(taskId);
    }

    public List<Task> listAllTasks() {
        return taskService.createTaskQuery().list();
    }

    public List<Task> listTasksByStartedProcessId(String processInstanceId) {
        return this.taskService.createTaskQuery().processInstanceBusinessKey(processInstanceId).list();
    }

    public List<Task> listByUserId(String userId) {
        return this.taskService.createTaskQuery().taskInvolvedUser(userId).list();
    }
}
