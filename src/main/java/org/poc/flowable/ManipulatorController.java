package org.poc.flowable;

import org.flowable.engine.RepositoryService;
import org.flowable.engine.TaskService;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/manipulator")
public class ManipulatorController {

    @Autowired
    FlowableService service;

    @PostMapping("/start-process/{key}")
    public ResponseEntity<Models.ProcessInstanceDTO> startProcess(@PathVariable String key) {
        Models.ProcessInstanceDTO piDTO = new Models.ProcessInstanceDTO(service.startProcessInstance(key));
        return ResponseEntity.ok(piDTO);
    }

    @PutMapping("/claim-task/{userId}/{taskId}")
    public ResponseEntity<Void> claimTask(@PathVariable String userId, @PathVariable String taskId) {
        this.service.claimTaskById(taskId, userId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/complete-task/{taskId}")
    public ResponseEntity<Void> completeTask(@PathVariable String taskId) {
        this.service.completeTaskById(taskId);
        return ResponseEntity.noContent().build();
    }

}
