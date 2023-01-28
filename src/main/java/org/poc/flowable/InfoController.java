package org.poc.flowable;

import org.flowable.engine.RepositoryService;
import org.flowable.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/info")
public class InfoController {

    @Autowired
    TaskService taskService;

    @Autowired
    RepositoryService repositoryService;

    @GetMapping("/tasks")
    public ResponseEntity<List<Models.TaskDTO>> getTasks() {
        List<Models.TaskDTO> tasks = taskService.createTaskQuery().list()
                .stream()
                .map(Models.TaskDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/process-definition")
    public ResponseEntity<List<Models.ProcessDTO>> getProcess() {
        List<Models.ProcessDTO> process = repositoryService.createProcessDefinitionQuery().list()
                .stream()
                .map(Models.ProcessDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(process);
    }

}
