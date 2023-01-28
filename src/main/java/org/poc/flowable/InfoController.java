package org.poc.flowable;

import org.flowable.engine.impl.persistence.entity.HistoricProcessInstanceEntityImpl;
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
    FlowableService service;

    @GetMapping("/tasks")
    public ResponseEntity<List<Models.TaskDTO>> getTasks() {
        List<Models.TaskDTO> tasks = this.service.listAllTasks().stream()
                .map(Models.TaskDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/process-definition")
    public ResponseEntity<List<Models.ProcessDTO>> getProcess() {
        List<Models.ProcessDTO> process = this.service.listProcessDefinitions().stream()
                .map(Models.ProcessDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(process);
    }

    @GetMapping("/process-history")
    public ResponseEntity<List<HistoricProcessInstanceEntityImpl>> getProcessHistory() {
        List<HistoricProcessInstanceEntityImpl> list = this.service.listProcessHistory();
        return ResponseEntity.ok(list);
    }

}
