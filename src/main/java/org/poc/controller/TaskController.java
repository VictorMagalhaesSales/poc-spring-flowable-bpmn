package org.poc.controller;

import org.poc.model.Models;
import org.poc.model.ProcessVariablesDTO;
import org.poc.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TasksService service;

    @GetMapping()
    public ResponseEntity<List<Models.TaskDTO>> getTasks() {
        List<Models.TaskDTO> tasks = service.listAllTasks().stream()
                .map(Models.TaskDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Models.TaskDTO>> getTasksByUserId(@PathVariable String userId) {
        List<Models.TaskDTO> tasks = service.listByUserId(userId).stream()
                .map(Models.TaskDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(tasks);
    }

    @PutMapping(value = "/{taskId}", params = "claim")
    public ResponseEntity<Void> claimTask(@PathVariable String taskId, @RequestParam String userId) {
        this.service.claimTaskById(taskId, userId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{taskId}", params = "complete")
    public ResponseEntity<Void> completeTask(@PathVariable String taskId, @RequestBody ProcessVariablesDTO body) {
        this.service.completeTaskById(taskId, body.getVariables());
        return ResponseEntity.noContent().build();
    }

}
