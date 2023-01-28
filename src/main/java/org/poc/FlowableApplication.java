package org.poc;

import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication(proxyBeanMethods = false)
@EnableScheduling
public class FlowableApplication {

    @Autowired
    TaskService taskService;

    @Autowired
    RepositoryService repositoryService;

    @Autowired
    RuntimeService runtimeService;

    public static void main(String[] args) {
        SpringApplication.run(FlowableApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    private void monitoringInitialResources() {
        System.out.println("Number of process definitions: "+ repositoryService.createProcessDefinitionQuery().count());
        this.repositoryService.createProcessDefinitionQuery().list().stream().forEach(pd -> {
            System.out.println("     ProcessDefinition: "+pd.getName()+" - "+pd.getId());
        });
        System.out.println("Number of deployments: "+ this.repositoryService.createDeploymentQuery().count());
        this.repositoryService.createDeploymentQuery().list().stream().forEach(d -> {
            System.out.println("     Deployment "+d.getName()+" - "+d.getId());
        });
        System.out.println();
    }

    @Scheduled(initialDelay = 7_000, fixedDelay = 5_000)
    public void monitoringResources() {
        System.out.println("Number of process instances: "+ this.runtimeService.createProcessInstanceQuery().count());
        this.runtimeService.createProcessInstanceQuery().list().stream().forEach(pi -> {
            System.out.println("     ProcessInstance: "+pi.getName()+" - "+pi.getId());
        });
        System.out.println("Number of tasks: "+ this.taskService.createTaskQuery().count());
        this.taskService.createTaskQuery().list().stream().forEach(t -> {
            System.out.println("     Task: "+t.getName()+" - "+t.getId());
        });
    }
}