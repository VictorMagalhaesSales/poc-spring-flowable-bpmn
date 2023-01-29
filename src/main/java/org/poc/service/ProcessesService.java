package org.poc.service;

import org.flowable.engine.*;
import org.flowable.engine.impl.persistence.entity.HistoricProcessInstanceEntityImpl;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProcessesService {

    @Autowired
    ProcessEngine processEngine;

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

    public List<HistoricProcessInstanceEntityImpl> listProcessHistory() {
        return this.historyService.createHistoricProcessInstanceQuery()
                .list()
                    .stream()
                    .map(hpi -> (HistoricProcessInstanceEntityImpl) hpi)
                    .collect(Collectors.toList());
    }

}
