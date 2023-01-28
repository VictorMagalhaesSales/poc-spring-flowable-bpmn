package org.poc.flowable.controller;

import org.flowable.engine.impl.persistence.entity.HistoricProcessInstanceEntityImpl;
import org.poc.flowable.service.ProcessesService;
import org.poc.flowable.model.Models;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/process")
public class ProcessController {

    @Autowired
    ProcessesService service;

    @GetMapping("/definition")
    public ResponseEntity<List<Models.ProcessDTO>> getProcess() {
        List<Models.ProcessDTO> process = this.service.listProcessDefinitions().stream()
                .map(Models.ProcessDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(process);
    }

    @GetMapping("/history")
    public ResponseEntity<List<HistoricProcessInstanceEntityImpl>> getProcessHistory() {
        List<HistoricProcessInstanceEntityImpl> list = this.service.listProcessHistory();
        return ResponseEntity.ok(list);
    }

    @PutMapping(value = "/{key}", params = "start")
    public ResponseEntity<Models.ProcessInstanceDTO> startProcess(@PathVariable String key) {
        Models.ProcessInstanceDTO piDTO = new Models.ProcessInstanceDTO(service.startProcessInstance(key));
        return ResponseEntity.ok(piDTO);
    }

}
